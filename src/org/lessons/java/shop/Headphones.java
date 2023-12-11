package org.lessons.java.shop;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Headphones extends Product {

    private String color;
    private boolean wireless;

    public Headphones(String color, boolean wireless)throws IllegalArgumentException {
        validateColor(color);
        this.color = color;
        this.wireless = wireless;
    }

    public Headphones(String name, String description, BigDecimal price, BigDecimal vat, String color, boolean wireless) throws IllegalArgumentException {
        super(name, description, price, vat);
        validateColor(color);
        this.color = color;
        this.wireless = wireless;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color)throws IllegalArgumentException {
        validateColor(color);
        this.color = color;
    }

    public boolean isWireless() {
        return wireless;
    }

    public void setWireless(boolean wireless) {
        this.wireless = wireless;
    }

    public String toString(){
        return super.toString() +"color: "+ color+ "\nis wireless: "+ wireless;
    }

    @Override
    public BigDecimal getDiscountedPrice(){
        if (!wireless){
            return getPrice().subtract(getFullPrice().multiply(new BigDecimal("0.07"))).setScale(2, RoundingMode.HALF_DOWN);
        }else {
            return super.getDiscountedPrice();
        }
    }

    private void validateColor(String color){
        if (color.isBlank()){
            throw new IllegalArgumentException("you didn't type a color");
        }

    }
}
