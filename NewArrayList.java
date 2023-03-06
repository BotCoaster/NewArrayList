//Sujan Poudel and Dev Wahi
//03/06/23
//Period 1 ADSB
//Purpose: Use arrays to create ArrayList implementation

import java.lang.Math;
import java.util.Random;

class NewArrayList {
  private Shoe[] data;
  private int size;
  private int capacity;

  public NewArrayList() {
    this.data = new Shoe[10];
    this.size = 0;
    this.capacity = 10;
  }

  public NewArrayList(int capacity) {
    this.data = new Shoe[capacity];
    this.size = 0;
    this.capacity = capacity;
  }

  public boolean addToFirstEmptySpace(Shoe E) {
    for (int i = 0; i < this.data.length; ++i) {
      if (this.data[i] == null) {
        this.data[i] = E;
        this.size++;
        return true;
      } 
    }
    return false;
  }

  public void add(int index, Shoe element) {
    if (index < 0 || index > this.capacity) throw new IndexOutOfBoundsException();
    
    if (this.data[index] == null) {
      this.set(index, element);
    } else {
      this.ensureCapacity(10);
      
    }
  }

  public int capacity() {
    return this.capacity;
  }

  public void clear() {
    for (int i = 0; i < this.data.length; ++i) {
      this.data[i] = null;
    }
    this.size = 0;
  }

  public boolean contains(Shoe E) {
    for (Shoe s : this.data) {
      if (s == E) {
        return true;
      }
    }
    return false;
  }

  public void ensureCapacity(int minCapacity) {
    if (this.size == this.capacity) {
      Shoe[] tempArray = new Shoe[Math.max(minCapacity, this.capacity * 2)];
      for (int i = 0; i < this.capacity; ++i) {
        tempArray[i] = this.data[i];
      }
      this.capacity *= 2;
    }
  }

  public Shoe get(int index) {
    return this.data[index];
  }

  public int indexOf(Shoe element) {
    for (int i = 0 ; i < this.capacity; ++i) {
      if (this.data[i] == element)
        return i;
    }
    return -1;
  }

  public boolean isEmpty() {
    return this.size == 0;
  }

  public void printListShowCapacity() {
    System.out.print('[');
    for (int i = 0; i < capacity; ++i) {
      char c = (char) (96 + i);
      System.out.print(c + ", ");
    }
    System.out.print(']');
  }

  public void printListShowSize() {
    System.out.print('[');
    for (int i = 0; i < this.capacity - 1; ++i) {
      if (this.data[i] != null) {
        System.out.print("s");
      } else {
        System.out.print(" ");
      }

      System.out.print(", ");
    }
    String last = this.data[this.capacity - 1] == null ? " " : "s";
    System.out.print(last + "]");
  }

  public boolean remove(Shoe e) {
    int indexOfElement = this.indexOf(e);
    
    if (indexOfElement != -1) {
      this.data[indexOfElement] = null;
      this.size--;
      return true;
    } else {
      return false;
    }
  }

  public Shoe remove(int index) {
    Shoe removed = this.data[index];
    this.data[index] = null;
    this.size--;
    return removed;
  }

  public Shoe[] toArray() {
    Shoe[] shoeArray = new Shoe[this.size];
    int placingIndex = 0;

    for (int i = 0; i < this.capacity; ++i) {
      if (this.data[i] != null) {
        shoeArray[placingIndex] = this.data[i];
        placingIndex++;
      }
    }

    return shoeArray;
  }

  public Shoe[] selectionSort() {
    Shoe[] shoeArray = this.toArray();
    
    for (int i = 0; i < shoeArray.length; ++i) {
      int min = i;
      for (int j = i; j < shoeArray.length; ++j) {
        if (shoeArray[j].getYear() < shoeArray[min].getYear()) {
          min = j;
        }
      }
      Shoe tempShoe = shoeArray[i];
      shoeArray[i] = shoeArray[min];
      shoeArray[min] = tempShoe;
    }

    return shoeArray;
  }

  public Shoe set(int index, Shoe element) {
    Shoe tempShoe = this.data[index];
    this.data[index] = element;
    
    if (tempShoe == null) 
    	this.size++;
    
    return tempShoe;
  }

  public int size() {
    return this.size;
  }

  public String toString() {
    String informationString = "";
    informationString += "Size: " + this.size + '\n';
    informationString += "Capacity: " + this.capacity + '\n';
    informationString += "Array List: ";
    
    informationString += '[';
    for (int i = 0; i < this.capacity - 1; ++i) {
      if (this.data[i] != null) {
        informationString += "s";
      } else {
        informationString += " ";
      }

      informationString += ", ";
    }
    String last = this.data[this.capacity - 1] == null ? " " : "s";
    informationString += last + "]";

    return informationString;
  }

  /*
  public static Shoe randomShoe() {
	  Random myRandGenerator = new Random();
	  
	  String randomBrand = "";
	  String randomModel = "";
	  int randomYear = myRandGenerator.nextInt(2000, 2023);
	  double randomSize = myRandGenerator.nextDouble(6, 10);
	  int randomSKU = myRandGenerator.nextInt(100, 500);
	  
	  for (int i = 0; i < 7; ++i) {
		  randomBrand += (char) myRandGenerator.nextInt(97, 122);
		  randomModel += (char) myRandGenerator.nextInt(97, 122);
	  }
	  
	  return new Shoe(randomBrand, randomModel, randomYear, randomSize, randomSKU);
  }

  public static void main(String[] args) {
    NewArrayList mine = new NewArrayList();
    for (int i = 0; i < 10; ++i) {
    	mine.addToFirstEmptySpace(randomShoe());
    }    
    
  } 
  */
  
}
