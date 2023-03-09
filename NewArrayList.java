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
    for (int i = 0; i < this.capacity; ++i) {
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
      Shoe[] tempArray = new Shoe[this.capacity];
      for (int i = 0; i < index; ++i) {
        tempArray[i] = this.data[i];
      }
      
      for (int i = index + 1; i < capacity; ++i) {
        tempArray[i] = this.data[i - 1];
      }

      tempArray[index] = element;
      this.data = tempArray;
      this.size++;
    }

    if (this.data[this.capacity - 1] != null) {
    	ensureCapacity(10);
    }
  }

  public int capacity() {
    return this.capacity;
  }

  public void clear() {
    for (int i = 0; i < this.capacity; ++i) {
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
    if (minCapacity > this.capacity) {
      Shoe[] tempArray = new Shoe[Math.max(minCapacity, this.capacity * 2)];
      for (int i = 0; i < this.capacity; ++i) {
        tempArray[i] = this.data[i];
      }
      this.data = tempArray;
      this.capacity *= 2;
    }
  }
  
  public boolean equals(NewArrayList List) {
	  if (List.capacity() != this.capacity()) return false;
	  
	  for (int i = 0; i < this.capacity; ++i) {
		  if (List.data[i] != this.data[i]) {
			  return false;
		  }
	  }
	  return true;
  }

  public Shoe get(int index) {
	  int counter = 0;

	  for (int i = 0; i < this.data.length; ++i) {
	    if (counter == index) {
	      return this.data[i];
	    }
	      
	    if (this.data[i] != null) {
	      counter += 1;
	    }
	  }
	  return new Shoe("s", "d", 10, 10.5, 10);
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
    for (int i = 0; i < this.capacity - 1; ++i) {
      if (this.data[i] != null) {
        System.out.print("s");
      } else {
        System.out.print(" ");
      }
      System.out.print(", ");
    }
    
    String last = this.data[this.capacity - 1] == null ? " " : "s";
    System.out.println(last + "]");
  }

  public void printListShowSize() {
    System.out.print('[');
    for (int i = 0; i < this.capacity - 1; ++i) {
      if (this.data[i] != null) {
        System.out.print("s, ");
      } 
    }
    
    String last = this.data[this.capacity - 1] == null ? "" : "s";
    System.out.println(last + "]");
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
    String sizeString = "Size: " + this.size + '\n';
    String capacityString = "Capacity: " + this.capacity + '\n';
    String arrayString = "Array List: ";
    
    arrayString += '[';
    for (int i = 0; i < this.capacity - 1; ++i) {
      if (this.data[i] != null) {
        arrayString += this.data[i].getYear();
      } else {
        arrayString += " ";
      }

      arrayString += ", ";
    }
    String last = this.data[this.capacity - 1] == null ? " " : "s";
    arrayString += last + "]";

    return sizeString + capacityString + arrayString;
  }

  
  public static Shoe randomShoe() {
	  Random myRandGenerator = new Random();
	  
	  String randomBrand = "";
	  String randomModel = "";
	  int randomYear = 321;
	  double randomSize = myRandGenerator.nextDouble();
	  int randomSKU = myRandGenerator.nextInt(200);
	  
	  for (int i = 0; i < 7; ++i) {
		  randomBrand += (char) myRandGenerator.nextInt(97);
		  randomModel += (char) myRandGenerator.nextInt(97);
	  }
	  
	  return new Shoe(randomBrand, randomModel, randomYear, randomSize, randomSKU);
  }
  
}
