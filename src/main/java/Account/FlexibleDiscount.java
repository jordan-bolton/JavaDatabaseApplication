package Account;

import java.util.List;

public class FlexibleDiscount implements DiscountPlan {

    private float percentage = 0;
    private boolean available;
    String type = null;
    List<FlexibleDiscountContainer> fdContainer;
    String currentMonth = null;
    
    /**
     *
     * @param p
     */
    public FlexibleDiscount(float p) {
        type = "Flexible Discount";
    }
    
    public FlexibleDiscount(List<FlexibleDiscountContainer> fdc) {
        type = "Flexible Discount";
        fdContainer = fdc;
    }
    
    public FlexibleDiscount(List<FlexibleDiscountContainer> fdc, String cm) {
        type = "Flexible Discount";
        fdContainer = fdc;
        currentMonth = cm;
    }
    
    public FlexibleDiscount() {
        type = "Flexible Discount";
    }

    public void Calculate() {
        
    }

    /**
     *
     * @param percentage
     */
    
    public void setType(String t) {
        type = t;
    }
    
    public String getType() {
        return type;
    }
    
    public void setFDContainer(List<FlexibleDiscountContainer> fdc) {
        fdContainer = fdc;
    }
    
    public List<FlexibleDiscountContainer> getFDContainer() {
        return fdContainer;
    }
    
    public void setCurrentMonth(String cm) {
        currentMonth = cm;
    }
    
    public String getMonth() {
        return currentMonth;
    }

    @Override
    public void setPercentage(float percentage) {
        this.percentage = percentage;
    }

}
