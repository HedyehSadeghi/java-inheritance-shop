package org.lessons.java.shop;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Television extends Product{

    private int inches;
    private boolean smart;


    public Television(){

    }
    public Television(int inches, boolean smart) throws IllegalArgumentException{
        validateInches(inches);
        this.inches=inches;
        this.smart=smart;
    }

    public Television(String name, String description, BigDecimal price, BigDecimal vat, int inches, boolean smart) throws IllegalArgumentException {
        super(name, description, price, vat);
        validateInches(inches);
        this.inches=inches;
        this.smart=smart;
    }

    public int getInches() {
        return inches;
    }

    public void setInches(int inches) throws IllegalArgumentException {
        validateInches(inches);
        this.inches = inches;
    }

    public boolean isSmart() {
        return smart;
    }

    public void setSmart(boolean smart) {
        this.smart = smart;
    }

    public String toString(){
        return super.toString() +"inches: "+ inches+ "\nis smart: "+ smart;
    }
    @Override
    public BigDecimal getDiscountedPrice(){
        if (!smart){
            return getPrice().subtract(getFullPrice().multiply(new BigDecimal("0.10"))).setScale(2, RoundingMode.HALF_DOWN);
        }else {
            return super.getDiscountedPrice();
        }
    }

    private void validateInches(int inches){
        if (inches<=20){
            throw new IllegalArgumentException("not enough inches for a tv, or negative inches");
        }
    }
}
