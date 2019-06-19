-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema garitsdb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema garitsdb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `garitsdb` DEFAULT CHARACTER SET utf8 ;
USE `garitsdb` ;

-- -----------------------------------------------------
-- Table `garitsdb`.`Customer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `garitsdb`.`Customer` (
  `customer_id` INT(10) NOT NULL AUTO_INCREMENT,
  `customer_name` VARCHAR(255) NOT NULL,
  `customer_address` VARCHAR(255) NOT NULL,
  `customer_postcode` VARCHAR(8) NOT NULL,
  `customer_tel` INT(11) NOT NULL,
  `customer_email` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`customer_id`),
  UNIQUE INDEX `customer_id_UNIQUE` (`customer_id` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `garitsdb`.`Vehicle`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `garitsdb`.`Vehicle` (
  `reg_no` VARCHAR(8) NOT NULL,
  `car_make` VARCHAR(255) NOT NULL,
  `car_model` VARCHAR(255) NOT NULL,
  `engine_serial` VARCHAR(255) NOT NULL,
  `chassis_no` VARCHAR(255) NOT NULL,
  `colour` VARCHAR(255) NOT NULL,
  `customer_id` INT(10) NOT NULL,
  PRIMARY KEY (`reg_no`),
  INDEX `customer_id_idx` (`customer_id` ASC) VISIBLE,
  CONSTRAINT `customer_id`
    FOREIGN KEY (`customer_id`)
    REFERENCES `garitsdb`.`Customer` (`customer_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `garitsdb`.`User`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `garitsdb`.`User` (
  `user_id` INT(10) NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(255) NOT NULL,
  `password` VARCHAR(255) NOT NULL,
  `user_role` VARCHAR(45) NOT NULL,
  `user_pay` FLOAT(10) NULL,
  PRIMARY KEY (`user_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `garitsdb`.`Foreperson`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `garitsdb`.`Foreperson` (
  `user_id` INT(10) NOT NULL,
  `hourly_rate` FLOAT(10) NOT NULL,
  PRIMARY KEY (`user_id`),
  CONSTRAINT `user_id`
    FOREIGN KEY (`user_id`)
    REFERENCES `garitsdb`.`User` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `garitsdb`.`Mechanic`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `garitsdb`.`Mechanic` (
  `user_id` INT(10) NOT NULL,
  `hourly_rate` FLOAT(10) NOT NULL,
  PRIMARY KEY (`user_id`),
    FOREIGN KEY (`user_id`)
    REFERENCES `garitsdb`.`User` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `garitsdb`.`Supplier`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `garitsdb`.`Supplier` (
  `part_supplier_id` INT NOT NULL AUTO_INCREMENT,
  `supplier_name` VARCHAR(255) NOT NULL,
  `supplier_address` VARCHAR(255) NOT NULL,
  `supplier_tel` INT(11) NOT NULL,
  `supplier_email` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`part_supplier_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `garitsdb`.`Parts`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `garitsdb`.`Parts` (
  `part_id` INT NOT NULL AUTO_INCREMENT,
  `part_ name` VARCHAR(255) NOT NULL,
  `part_manufacturer` VARCHAR(255) NOT NULL,
  `part_supplier_id` INT(10) NOT NULL,
  `vehicle_type` VARCHAR(255) NOT NULL,
  `year` INT(10) NOT NULL,
  `part_quantity` INT(10) NOT NULL,
  PRIMARY KEY (`part_id`),
  UNIQUE INDEX `part_supplier_id_UNIQUE` (`part_supplier_id` ASC) VISIBLE,
  CONSTRAINT `part_supplier_id`
    FOREIGN KEY (`part_supplier_id`)
    REFERENCES `garitsdb`.`Supplier` (`part_supplier_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `garitsdb`.`Job`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `garitsdb`.`Job` (
  `job_id` INT NOT NULL AUTO_INCREMENT,
  `job_date` DATE NOT NULL,
  `reg_no` VARCHAR(8) NOT NULL,
  `customer_id` INT(10) NOT NULL,
  `mechanic_assigned` INT(10) NOT NULL,
  `job_details` VARCHAR(255) NULL,
  `job_duration` TIME NOT NULL,
  `job_status` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`job_id`),
  UNIQUE INDEX `reg_no_UNIQUE` (`reg_no` ASC) VISIBLE,
  INDEX `mechanic_assigned_idx` (`mechanic_assigned` ASC) VISIBLE,
  INDEX `customer_id_idx` (`customer_id` ASC) INVISIBLE,
  CONSTRAINT `reg_no`
    FOREIGN KEY (`reg_no`)
    REFERENCES `garitsdb`.`Vehicle` (`reg_no`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `mechanic_assigned`
    FOREIGN KEY (`mechanic_assigned`)
    REFERENCES `garitsdb`.`Mechanic` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
FOREIGN KEY (`customer_id`)
REFERENCES `garitsdb`.`Customer` (`customer_id`)
ON DELETE NO ACTION
ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `garitsdb`.`Part_Used`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `garitsdb`.`Part_Used` (
  `part_used_id` INT NOT NULL AUTO_INCREMENT,
  `part_id` INT(10) NOT NULL,
  `job_id` INT(10) NOT NULL,
  `quantity_used` INT(10) NOT NULL,
  PRIMARY KEY (`part_used_id`),
  INDEX `part_id_idx` (`part_id` ASC) VISIBLE,
  INDEX `job_id_idx` (`job_id` ASC) VISIBLE,
  CONSTRAINT `part_id`
    FOREIGN KEY (`part_id`)
    REFERENCES `garitsdb`.`Parts` (`part_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `job_id`
    FOREIGN KEY (`job_id`)
    REFERENCES `garitsdb`.`Job` (`job_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `garitsdb`.`Account_Holder`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `garitsdb`.`Account_Holder` (
  `customer_id` INT(10) NOT NULL,
  `discount_plan` VARCHAR(255) NOT NULL,
  `pay_later` TINYINT NOT NULL,
  PRIMARY KEY (`customer_id`),
FOREIGN KEY (`customer_id`)
REFERENCES `garitsdb`.`Customer` (`customer_id`)
ON DELETE NO ACTION
ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `garitsdb`.`Discount`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `garitsdb`.`Discount` (
  `discount_type` VARCHAR(255) NOT NULL,
  `customer_id` INT(10) NOT NULL,
  PRIMARY KEY (`discount_type`, `customer_id`),
  INDEX `customer_id_idx` (`customer_id` ASC) VISIBLE,
    FOREIGN KEY (`customer_id`)
    REFERENCES `garitsdb`.`Account_Holder` (`customer_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `garitsdb`.`Flexible_Discount`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `garitsdb`.`Flexible_Discount` (
  `customer_id` INT(10) NOT NULL,
  `discount_type` VARCHAR(255) NOT NULL,
  `discount_value` INT(10) NOT NULL,
  `current_month` DATE NOT NULL,
  PRIMARY KEY (`customer_id`),
  INDEX `discount_type_idx` (`discount_type` ASC) VISIBLE,
    FOREIGN KEY (`customer_id`)
    REFERENCES `garitsdb`.`Discount` (`customer_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `discount_type`
    FOREIGN KEY (`discount_type`)
    REFERENCES `garitsdb`.`Discount` (`discount_type`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `garitsdb`.`Variable_Discount`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `garitsdb`.`Variable_Discount` (
  `customer_id` INT(10) NOT NULL,
  `discount_type` VARCHAR(255) NOT NULL,
  `business_type` VARCHAR(255) NOT NULL,
  `discount_percentage` INT(10) NULL,
  PRIMARY KEY (`customer_id`, `discount_type`),
  INDEX `discount_type_idx` (`discount_type` ASC) VISIBLE,
    FOREIGN KEY (`customer_id`)
    REFERENCES `garitsdb`.`Discount` (`customer_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
    FOREIGN KEY (`discount_type`)
    REFERENCES `garitsdb`.`Discount` (`discount_type`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `garitsdb`.`Fixed_Discount`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `garitsdb`.`Fixed_Discount` (
  `customer_id` INT(10) NOT NULL,
  `discount_type` VARCHAR(255) NOT NULL,
  `discount_percentage` INT(10) NOT NULL,
  PRIMARY KEY (`customer_id`, `discount_type`),
  INDEX `discount_type_idx` (`discount_type` ASC) VISIBLE,
    FOREIGN KEY (`customer_id`)
    REFERENCES `garitsdb`.`Discount` (`customer_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
    FOREIGN KEY (`discount_type`)
    REFERENCES `garitsdb`.`Discount` (`discount_type`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `garitsdb`.`Stock`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `garitsdb`.`Stock` (
  `part_id` INT(10) NOT NULL,
  `part_stock_quantity` INT(10) NOT NULL,
  `part_threshold` INT(10) NOT NULL,
  PRIMARY KEY (`part_id`),
    FOREIGN KEY (`part_id`)
    REFERENCES `garitsdb`.`Parts` (`part_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `garitsdb`.`Invoice`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `garitsdb`.`Invoice` (
  `invoice_id` INT NOT NULL AUTO_INCREMENT,
  `job_id` INT(10) NOT NULL,
  `invoice_date` DATE NOT NULL,
  `payment_due_date` DATE NOT NULL,
  `invoice_total` FLOAT NOT NULL,
  `invoice_paid` TINYINT NOT NULL,
  PRIMARY KEY (`invoice_id`),
  INDEX `job_id_idx` (`job_id` ASC) VISIBLE,
    FOREIGN KEY (`job_id`)
    REFERENCES `garitsdb`.`Job` (`job_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `garitsdb`.`Invoice_Reminder`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `garitsdb`.`Invoice_Reminder` (
  `invoice_reminder_id` INT NOT NULL AUTO_INCREMENT,
  `invoice_id` INT(10) NOT NULL,
  `reminder_sent` TINYINT NOT NULL,
  PRIMARY KEY (`invoice_reminder_id`),
  INDEX `invoice_id_idx` (`invoice_id` ASC) VISIBLE,
    FOREIGN KEY (`invoice_id`)
    REFERENCES `garitsdb`.`Invoice` (`invoice_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
