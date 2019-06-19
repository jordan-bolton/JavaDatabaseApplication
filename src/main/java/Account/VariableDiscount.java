package Account;

public class VariableDiscount implements DiscountPlan {

    private float percentage = 0;
    private float motPercentage = 0;
    private float individualPercentage = 0;
    private float sparePartsPercentage = 0;
    String type = null;
    
    /**
     *
     * @param p
     */
    public VariableDiscount(float p) {
        percentage = p;
        type = "Variable Discount";
    }

    public VariableDiscount(float p, float mp, float indi, float spare) {
        percentage = p;
        motPercentage = mp;
        individualPercentage = indi;
        sparePartsPercentage = spare;
        type = "Variable Discount";
    }
    
    public VariableDiscount() {
        
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
    
    public void setMOTPercentage(float mot) {
        motPercentage = mot;
    }
    
    public float getMOTPercentage() {
        return motPercentage;
    }
    
    public void setIndividualPercentage(float indi) {
        individualPercentage = indi;
    }

    public float getIndividualPercentage() {
        return individualPercentage;
    }
    
    public void setSparePartsPercentage(float spare) {
        sparePartsPercentage = spare;
    }
    
    public float getSparePartsPercentage() {
        return sparePartsPercentage;
    }
}
