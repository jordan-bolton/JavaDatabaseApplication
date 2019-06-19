package Account;

public class Mechanic extends Staff {
    private float hourly_rate;
    
    // mechanic can either be a mechanic or foreperson
    public Mechanic (String id, String password, String role, String name, float hourly_rate) {
	super(id, password, role, name);
        this.hourly_rate = hourly_rate;
    }

    public float getHourly_rate() {
        return hourly_rate;
    }

    public void setHourly_rate(float hourly_rate) {
        this.hourly_rate = hourly_rate;
    }
    
    public Mechanic() {}
        

}