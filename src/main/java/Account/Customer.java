package Account;

import java.util.List;

public class Customer extends Account {

    private boolean accountHolder;
    private int customerId;
    private List<Vehicle> vehicles;
    private String postcode;
    private String customer_contact;

    public Customer() {
    }

    /**
     *
     * @param accountHolder
     * @param vehicles
     * @param name
     * @param email
     * @param phone
     * @param address
     */
    public Customer(boolean accountHolder, int customerId, List<Vehicle> vehicles, String name, String email, String phone, String address) {
        super(name, email, phone, address);
        this.accountHolder = accountHolder;
        this.customerId = customerId;
        this.vehicles = vehicles;
    }

    public Customer(String n, String email, String phone, String addr, String pc) {
        super(n, email, phone, addr);
        this.postcode = pc;
    }

    public Customer(String n, String email, String phone, String addr, String pc, int id) {
        super(n, email, phone, addr);
        this.postcode = pc;
        this.customerId = id;
    }
    
    public Customer(String n, String email, String phone, String addr, String pc, int id, String contact) {
        super(n, email, phone, addr);
        this.postcode = pc;
        this.customerId = id;
        this.customer_contact = contact;
    }
    
    public Customer(String n, String email, String phone, String addr, String pc, String contact) {
        super(n, email, phone, addr);
        this.postcode = pc;
        this.customer_contact = contact;
    }

    public boolean isAccountHolder() {
        return accountHolder;
    }

    public void setAccountHolder(boolean accountHolder) {
        this.accountHolder = accountHolder;
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }
    
    public String getPostcode() {
        return postcode;
    }
    
    public void setPostcode(String pc) {
        this.postcode = pc;
    }
    
    public String getCustomerContact() {
        return customer_contact;
    }
    
    public void setCustomerContact(String contact) {
        this.customer_contact = contact;
    }
}