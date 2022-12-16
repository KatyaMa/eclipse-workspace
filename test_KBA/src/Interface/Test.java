package Interface;


public class Test {
  public static void main(String[] args) {
    MyFunctionalInterface fi = b -> {
      return b * b;
    };
    System.out.println(fi.sqr(6));
  }
}