package Account;

public class Vehicle {

	private String model;
	private String reg_num;
	private String make;
	private String colour;
	private String engine_serial_no;
	private String chassis_no;
        private String purchase_date;
        
        public Vehicle() {}

	/**
	 * 
         * @param model
	 * @param reg_num
	 * @param make
         * @param colour
	 * @param engine_serial_no
         * @param chassis_no
	 */
	public Vehicle(String reg_num, String make, String model, String colour, String engine_serial_no, String chassis_no) {
            this.model = model;
            this.reg_num = reg_num;
            this.make = make;
            this.colour = colour;
            this.engine_serial_no = engine_serial_no;
            this.chassis_no = chassis_no;
        }
        
        public Vehicle(String reg_num, String make, String model, String colour, String engine_serial_no, String chassis_no, String purchase_date) {
            this.model = model;
            this.reg_num = reg_num;
            this.make = make;
            this.colour = colour;
            this.engine_serial_no = engine_serial_no;
            this.chassis_no = chassis_no;
            this.purchase_date = purchase_date;
        }

	public String getModel() {
		return this.model;
	}

	/**
	 * 
	 * @param model
	 */
	public void setModel(String model) {
		this.model = model;
	}

	public String getReg_num() {
		return this.reg_num;
	}

	/**
	 * 
	 * @param reg_num
	 */
	public void setReg_num(String reg_num) {
		this.reg_num = reg_num;
	}

	public String getMake() {
		return this.make;
	}

	/**
	 * 
	 * @param make
	 */
	public void setMake(String make) {
		this.make = make;
	}

	public String getColour() {
		return this.colour;
	}

	/**
	 * 
	 * @param colour
	 */
	public void setColour(String colour) {
		this.colour = colour;
	}

	public String getEngine_serial_no() {
		return this.engine_serial_no;
	}

	/**
	 * 
	 * @param engine_serial_no
	 */
	public void setEngine_serial_no(String engine_serial_no) {
		this.engine_serial_no = engine_serial_no;
	}

	public String getChassis_no() {
		return this.chassis_no;
	}

	/**
	 * 
	 * @param chassis_no
	 */
	public void setChassis_no(String chassis_no) {
		this.chassis_no = chassis_no;
	}

        public String getPurchase_date() {
            return purchase_date;
        }

        public void setPurchase_date(String purchase_date) {
            this.purchase_date = purchase_date;
        }

        
}