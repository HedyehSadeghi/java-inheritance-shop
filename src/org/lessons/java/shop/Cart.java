package org.lessons.java.shop;

import java.math.BigDecimal;
import java.util.Scanner;

public class Cart {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        System.out.print("Name: ");
        String nameInput = scanner.nextLine();
        System.out.print("Description: ");
        String descriptionInput = scanner.nextLine();

        BigDecimal price = null;
        while (price == null) {
            System.out.print("Price: ");
            String priceInput = scanner.nextLine();
            try {
                price = new BigDecimal(priceInput);
            } catch (Exception e) {
                System.out.println("Invalid number");
            }
        }

        BigDecimal vat = null;
        while (vat == null){
            System.out.print("Vat: ");
            String vatInput = scanner.nextLine();
            try{
                vat = new BigDecimal(vatInput);
            } catch(NumberFormatException e){
                System.out.println("Invalid number");
            }
        }

        System.out.print("Type of product (smartphone/television/headphones): ");
        String typeOfProduct= scanner.nextLine();
        switch (typeOfProduct){
            case "smartphones":
                System.out.print("memory (int): ");
                int memoryInput = Integer.parseInt(scanner.nextLine());
                Smartphone smartphone= new Smartphone(nameInput,descriptionInput,price,vat,memoryInput);
                System.out.println(smartphone.toString());
                break;
            case "television":
                System.out.print("inches: ");
                int inchesInput = Integer.parseInt(scanner.nextLine());
                System.out.print("Is it smart? (true/false): ");
                boolean smartInput = Boolean.parseBoolean( scanner.nextLine());
                Television tv = new Television(nameInput,descriptionInput,price,vat,inchesInput,smartInput);
                System.out.println(tv.toString());
                break;
            case "headphones":
                System.out.print("Color: ");
                String colorInput = scanner.nextLine();
                System.out.print("Are they wireless? (true/false): ");
                boolean wirelessInput =  Boolean.parseBoolean( scanner.nextLine());
                Headphones headphones= new Headphones(nameInput,descriptionInput,price,vat,colorInput,wirelessInput);
                System.out.println(headphones.toString());
                break;
            default:
                System.out.println("invalid choice");
                break;
        }



        /*
        try {
            Product product = new Product(nameInput, descriptionInput,price, vat);
            System.out.println(product);
        } catch(NumberFormatException numberFormatException){
            System.out.println("The price or vat is not a number");
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println("Sorry invalid parameters: " + illegalArgumentException.getMessage());
        }

         */







        scanner.close();

    }
}
