public class Main {

  public static void main(String[] args) {
    NewArrayList mine = new NewArrayList(1); 
    mine.add(0, NewArrayList.randomShoe());
    mine.add(1, NewArrayList.randomShoe());
    mine.add(3, NewArrayList.randomShoe());
    mine.add(3, NewArrayList.randomShoe());

    System.out.println(mine);
    
  } 
  
}
