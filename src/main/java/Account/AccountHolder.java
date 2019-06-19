package Account;

import java.util.List;

public class AccountHolder extends Customer {

	private DiscountPlan discount_plan;
	private boolean pay_later;
       

        public AccountHolder(boolean accountHolder, int customerId, List<Vehicle> vehicles, String name, String email, String phone, String address) {
            super(accountHolder, customerId, vehicles, name, email, phone, address);
        }
        
        public AccountHolder(String name, String email, String phone, String address, String pc) {
            super(name, email, phone, address, pc);
        }
        
        public AccountHolder(String name, String email, String phone, String address, String pc, int id) {
            super(name, email, phone, address, pc, id);
        }
        
        public AccountHolder(String name, String email, String phone, String address, String pc, String contact) {
            super(name, email, phone, address, pc, contact);
        }
        
        public AccountHolder() {
            super();
        }
        
        

	public DiscountPlan getDiscount_plan() {
		return this.discount_plan;
	}

	/**
	 * 
	 * @param discount_plan
	 */
	public void setDiscount_plan(DiscountPlan discount_plan) {
		this.discount_plan = discount_plan;
	}

	public boolean getPay_later() {
		return this.pay_later;
	}

	/**
	 * 
	 * @param pay_later
	 */
	public void setPay_later(boolean pay_later) {
		this.pay_later = pay_later;
	}

}