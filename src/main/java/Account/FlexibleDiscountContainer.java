package Account;

public class FlexibleDiscountContainer {

    private float percentage = 0;
    private int startPrice;
    private int endPrice;
    private int id;

    /**
     *
     * @param p
     */
    public FlexibleDiscountContainer(float p, int sp, int ep) {
        percentage = p;
        startPrice = sp;
        endPrice = ep;
    }
    
    public FlexibleDiscountContainer(float p, int sp, int ep, int id) {
        percentage = p;
        startPrice = sp;
        endPrice = ep;
        this.id = id;
    }
    
    public FlexibleDiscountContainer() {
        
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
    
    public void setStartPrice(int sp) {
        startPrice = sp;
    }
    
    public int getStartPrice() {
        return startPrice;
    }
    
    public void setEndPrice(int ep) {
        endPrice = ep;
    }
    
    public int getEndPrice() {
        return endPrice;
    }

    public void setID(int id) {
        this.id = id;
    }
    
    public int getID() {
        return id;
    }

}
