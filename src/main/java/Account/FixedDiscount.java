package Account;

public class FixedDiscount implements DiscountPlan {

    float percentage = 0;
    String type = null;
    /**
     *
     * @param p
     */
    public FixedDiscount(float p) {
        percentage = p;
        type = "Fixed Discount";
    }

    public void Calculate() {
        
    }

    /**
     *
     * @param percentage
     */
    public void setPercentage(float percentage) {
        this.percentage = percentage;
    }
    
    public float getPercentage() {
        return percentage;
    }

}
