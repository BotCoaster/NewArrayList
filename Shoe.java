public class Shoe {

  private String brand;
  private String model;
  private int year;
  private double size;
  private int SKU;

  //getters
  public String getBrand() {
    return this.brand;
  }

  public String getModel() {
    return this.model;
  }

  public int getYear() {
    return this.year;
  }

  public double getSize() {
    return this.size;
  }

  public int getSKU() {
    return this.SKU;
  }

  //setters
  public void setBrand(String brand) {
    this.brand = brand;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public void setYear(int year) {
    this.year = year;
  }

  public void setSize(double size) {
    this.size = size;
  }

  public void setSKU(int SKU) {
    this.SKU = SKU;
  }

  //constructor
  public Shoe(String brand, String model, int year, double size, int SKU) {
    this.brand = brand;
    this.model = model;
    this.year = year;
    this.size = size;
    this.SKU = SKU;
  }

  //override toString()
  public String toString() {
    return brand + "-" + model + "-" + year + "-" + size + "-" + SKU;
  }

  //override equals()
  public boolean equals(Object obj) {
    // same instance
    if (obj == this) {
      return true;
    }

    // null
    if (obj == null) {
      return false;
    }

    // type
    if (!(obj instanceof Shoe)) {
      return false;
    }

    // cast and compare state
    Shoe sh = (Shoe)obj;
    return sh.brand.equals(brand) && sh.model.equals(model) && sh.year == year && sh.size == size && sh.SKU == SKU;
    
  }

  public int hashCode() {
    return SKU;
  }
}
