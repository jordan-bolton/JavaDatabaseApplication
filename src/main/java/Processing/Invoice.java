package Processing;

public class Invoice {

	private int invoiceId;
	private String payment_type;
	private boolean isPaid;
	private float amountDue;
        private int jobId;
        private String jobStart;
	private String jobEnd;
        private int customerId;
        private String customerName;
        private boolean accountHolder;
        private String customerEmail;
        private String customerPhone;
        private String customerAddress;
        private boolean paymentReminder;
        private String paymentDueDate;
        private String customerPostCode;
        private String vehicleMake;
        private String vehicleModel;
        private float mechanicWage;
        private String regNum;
        private int mechanicAssigned;
        private float jobDuration;
        private int reminderSent;
        private float fixedCost;
        

	/**
	 * 
	 * @param payType
	 */
	public Invoice Invoice(String payType) {
		// TODO - implement Invoice.Invoice
		throw new UnsupportedOperationException();
	}

    public String getPaymentDueDate() {
        return paymentDueDate;
    }

    public void setPaymentDueDate(String paymentDueDate) {
        this.paymentDueDate = paymentDueDate;
    }

    public int getInvoiceId() {
        return invoiceId;
    }

    public boolean isIsPaid() {
        return isPaid;
    }

    public String getCustomerPostCode() {
        return customerPostCode;
    }

    public void setCustomerPostCode(String customerPostCode) {
        this.customerPostCode = customerPostCode;
    }

    public String getVehicleMake() {
        return vehicleMake;
    }

    public void setVehicleMake(String vehicleMake) {
        this.vehicleMake = vehicleMake;
    }

    public String getVehicleModel() {
        return vehicleModel;
    }

    public void setVehicleModel(String vehicleModel) {
        this.vehicleModel = vehicleModel;
    }

    public float getMechanicWage() {
        return mechanicWage;
    }

    public void setMechanicWage(float mechanicWage) {
        this.mechanicWage = mechanicWage;
    }

    public String getRegNum() {
        return regNum;
    }

    public void setRegNum(String regNum) {
        this.regNum = regNum;
    }

    public int getMechanicAssigned() {
        return mechanicAssigned;
    }

    public void setMechanicAssigned(int mechanicAssigned) {
        this.mechanicAssigned = mechanicAssigned;
    }

    public float getJobDuration() {
        return jobDuration;
    }

    public void setJobDuration(float jobDuration) {
        this.jobDuration = jobDuration;
    }

    public int isReminderSent() {
        return reminderSent;
    }

    public void setReminderSent(int reminderSent) {
        this.reminderSent = reminderSent;
    }

    public float getFixedCost() {
        return fixedCost;
    }

    public void setFixedCost(float fixedCost) {
        this.fixedCost = fixedCost;
    }
    
    
    
    
        
        

    public Invoice() {
    }
        
        public float calcMarkUpSpares(float sparePartsTotal) {
            float markUp = (float) (sparePartsTotal * 1.3);
            return markUp;
        }
        
        public float calcLabourCost(float jobDuration, float wage) {
            return jobDuration*wage;
        }
        
        //Adds VAT to payment total
        public float calcTotalWithVat(float labourCost, float sparePartsCost) {
            return (float) ((labourCost+sparePartsCost) * 1.2);
        }

        public int getJobId() {
            return jobId;
        }

        public void setJobId(int jobId) {
            this.jobId = jobId;
        }

        public String getJobStart() {
            return jobStart;
        }

        public void setJobStart(String jobStart) {
            this.jobStart = jobStart;
        }

        public String getJobEnd() {
            return jobEnd;
        }

        public void setJobEnd(String jobEnd) {
            this.jobEnd = jobEnd;
        }

        public int getCustomerId() {
            return customerId;
        }

        public void setCustomerId(int customerId) {
            this.customerId = customerId;
        }

        public String getCustomerName() {
            return customerName;
        }

        public void setCustomerName(String customerName) {
            this.customerName = customerName;
        }

        public boolean isAccountHolder() {
            return accountHolder;
        }

        public void setAccountHolder(boolean accountHolder) {
            this.accountHolder = accountHolder;
        }

        public String getCustomerEmail() {
            return customerEmail;
        }

        public void setCustomerEmail(String customerEmail) {
            this.customerEmail = customerEmail;
        }

        public String getCustomerPhone() {
            return customerPhone;
        }

        public void setCustomerPhone(String customerPhone) {
            this.customerPhone = customerPhone;
        }

        public String getCustomerAddress() {
            return customerAddress;
        }

        public void setCustomerAddress(String customerAddress) {
            this.customerAddress = customerAddress;
        }

        public boolean isPaymentReminder() {
            return paymentReminder;
        }

        public void setPaymentReminder(boolean paymentReminder) {
            this.paymentReminder = paymentReminder;
        }
        
        

	public int invoiceId() {
		return this.invoiceId;
	}

	/**
	 * 
	 * @param invoiceId
	 */
	public void setInvoiceId(int invoiceId) {
		this.invoiceId = invoiceId;
	}

	public String getPayment_type() {
		return this.payment_type;
	}

	/**
	 * 
	 * @param payment_type
	 */
	public void setPayment_type(String payment_type) {
		this.payment_type = payment_type;
	}

	public boolean getIsPaid() {
		return this.isPaid;
	}

	/**
	 * 
	 * @param isPaid
	 */
	public void setIsPaid(boolean isPaid) {
		this.isPaid = isPaid;
	}

	public float getAmountDue() {
		return this.amountDue;
	}

	/**
	 * 
	 * @param amountDue
	 */
	public void setAmountDue(float amountDue) {
		this.amountDue = amountDue;
	}

}