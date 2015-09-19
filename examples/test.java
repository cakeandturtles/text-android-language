public class test{
  public static void testing(){}

  public static void food(){ System.out.println("yum!"); }

  public static void main(String[] args){
    testing();
    //error, not a statement
    //test;
    int food = 3;
    food();
  }
}
