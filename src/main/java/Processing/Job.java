package Processing;

import java.util.Calendar;
import Account.*;
import StockControl.*;

public class Job {

	private String registrationNum;
        private int customerId;
	private String status;
	private String type;
	private int mechanicId;
	private Part[] parts;
	private int estimate_duration;
	private int duration;
	private String date_start;
	private String date_end;
	private float total_cost;
        private String workRequired;
        private String workDone;
        private int jobId;
        private float fixedCost;
          

	/**
	 * 
	 * @param type
	 * @param mech
	 * @param desc
	 */
	
        
        public Job() {}
                
        public String getRegistrationNum() {
            return registrationNum;
        }

        public void setRegistrationNum(String registrationNum) {
            this.registrationNum = registrationNum;
        }

        public int getCustomerId() {
            return customerId;
        }

        public void setCustomerId(int customerId) {
            this.customerId = customerId;
        }
        

	public String getStatus() {
		return this.status;
	}

	/**
	 * 
	 * @param status
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	public String getType() {
		return this.type;
	}

	/**
	 * 
	 * @param type
	 */
	public void setType(String type) {
		this.type = type;
	}

	public int getMechanicId() {
		return this.mechanicId;
	}

	/**
	 * 
	 * @param mechanic
	 */
	public void setMechanicId(int mechanicId) {
		this.mechanicId = mechanicId;
	}

	public Part[] getParts() {
		return this.parts;
	}

	/**
	 * 
	 * @param parts
	 */
	public void setParts(Part[] parts) {
		this.parts = parts;
	}


	public int getEstimate_duration() {
		return this.estimate_duration;
	}

	/**
	 * 
	 * @param estimate_duration
	 */
	public void setEstimate_duration(int estimate_duration) {
		this.estimate_duration = estimate_duration;
	}

	public int getDuration() {
		return this.duration;
	}

	/**
	 * 
	 * @param duration
	 */
	public void setDuration(int duration) {
		this.duration = duration;
	}

	public String getDate_start() {
		return this.date_start;
	}

	/**
	 * 
	 * @param date_start
	 */
	public void setDate_start(String date_start) {
		this.date_start = date_start;
	}

	public String getDate_end() {
		return this.date_end;
	}

	/**
	 * 
	 * @param date_end
	 */
	public void setDate_end(String date_end) {
		this.date_end = date_end;
	}

	public float getTotal_cost() {
		return this.total_cost;
	}

	/**
	 * 
	 * @param total_cost
	 */
	public void setTotal_cost(float total_cost) {
		this.total_cost = total_cost;
	}

	public void CreateJobSheet() {
		// TODO - implement Job.CreateJobSheet
		throw new UnsupportedOperationException();
	}

        public String getWorkRequired() {
            return workRequired;
        }

        public void setWorkRequired(String workRequired) {
            this.workRequired = workRequired;
        }

        public String getWorkDone() {
            return workDone;
        }

        public void setWorkDone(String workDone) {
            this.workDone = workDone;
        }

        public int getJobId() {
            return jobId;
        }

        public void setJobId(int jobId) {
            this.jobId = jobId;
        }

        public float getFixedCost() {
            return fixedCost;
        }

        public void setFixedCost(float fixedCost) {
            this.fixedCost = fixedCost;
        }
        
        
        
        

}