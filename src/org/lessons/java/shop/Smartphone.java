package org.lessons.java.shop;

import java.math.BigDecimal;
import java.util.Random;

public class Smartphone extends Product {
    private int imeiCode;
    private int memory;

    public Smartphone(){
        this.imeiCode=createImeiCode();
    }

    public Smartphone(int memory) throws IllegalArgumentException{
        validateMemory(memory);
        this.imeiCode=createImeiCode();
        this.memory=memory;
    }

    public Smartphone(String name, String description, BigDecimal price, BigDecimal vat, int memory) throws IllegalArgumentException {
        super(name, description, price, vat);
        validateMemory(memory);
        this.imeiCode=createImeiCode();
        this.memory=memory;
    }

    public int getImeiCode() {
        return imeiCode;
    }

    public int getMemory() {
        return memory;
    }

    public void setMemory(int memory)throws IllegalArgumentException {
        validateMemory(memory);
        this.memory = memory;
    }

    @Override
    public String toString(){
        return super.toString() +"imei code: "+ imeiCode+ "\nmemory: "+ memory;
    }

    private int createImeiCode(){
        Random random= new Random();
        return random.nextInt(1000, Integer.MAX_VALUE);
    }

    private void validateMemory(int memory){
        if (memory<=0){
            throw new IllegalArgumentException("memory negative or zero");
        }

    }
}
