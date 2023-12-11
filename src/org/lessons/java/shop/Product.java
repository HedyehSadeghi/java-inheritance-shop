package org.lessons.java.shop;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;


public class Product {
  // ATTRIBUTI
  private int code;
  private String name; // non deve essere vuoto
  private String description;

 private BigDecimal price; // non deve essere negativo
 private BigDecimal vat; // non deve essere negativo


  // COSTRUTTORI
  public Product(){
    this.code = generateCode();
  }

  public Product(String name, String description, BigDecimal price, BigDecimal vat) throws IllegalArgumentException{
    // prima faccio tutte le validazioni
    validateName(name);
    validatePrice(price);
    validateVat(vat);
    // se le validazioni sono passate allora assegno il valore ai campi
    this.code = generateCode();
    this.name = name;
    this.description = description;
    this.price = price;
    this.vat = vat;

  }
  // GETTER e SETTER

  public int getCode() {
    return code;
  }

  public String getName() {
    return name;
  }

  public String getDescription() {
    return description;
  }

  public BigDecimal getPrice() {
    return price;
  }

  public BigDecimal getVat() {
    return vat;
  }

  public void setName(String name) throws IllegalArgumentException{
    validateName(name); // prima testo il valore che viene da fuori: se non valido si interrompe con eccezione
    this.name = name;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public void setPrice(BigDecimal price) throws IllegalArgumentException{
    validatePrice(price);
    this.price = price;
  }

  public void setVat(BigDecimal vat) throws IllegalArgumentException{
    validateVat(vat);
    this.vat = vat;
  }




  // METODI
  // metodo che calcola il prezzo con iva
  // 1) livello di accesso, 2) tipo di dato di ritorno, 3) nome del metodo 4) parametri
  public BigDecimal getFullPrice(){
    // double fullPrice = price + price*vat;
    BigDecimal vatOnPrice = price.multiply(vat);
    return price.add(vatOnPrice).setScale(2, RoundingMode.HALF_EVEN);
  }
  // metodo che restituisce il nome completo codice + nome
  public String getFullName(){
    return code + " " + name;
  }
  // metodo che genera un numero random da assegnare al codice
  private int generateCode(){
    Random randomGenerator = new Random();
    return randomGenerator.nextInt(0, 10000);
  }

  public BigDecimal getDiscountedPrice(){
      BigDecimal discountOnPrice=getFullPrice().multiply(new BigDecimal("0.02"));
      return getFullPrice().subtract(discountOnPrice).setScale(2, RoundingMode.HALF_EVEN);
  }

  // metodi di validazione
  private void validateName(String name) throws IllegalArgumentException{
    if(name == null || name.isEmpty()){
      // name non è valido
      throw new IllegalArgumentException("name empty");
    }
  }

  private void validatePrice(BigDecimal price) throws IllegalArgumentException{
    if(price == null || price.compareTo(new BigDecimal(0)) < 0){
      // prezzo negativo
      throw new IllegalArgumentException("price negative " + price);
    }
  }

  private void validateVat(BigDecimal vat) throws IllegalArgumentException{
    if(vat == null || vat.compareTo(new BigDecimal(0))< 0){
      throw new IllegalArgumentException("vat negative " + vat);
    }
  }
  // facciamo il toString che mi restituisce nome completo + prezzo in euro + categoria
  @Override
  public String toString(){
    return getFullName() + ": " + getFullPrice() + "€\n";
  }
}
