package Interface;

@FunctionalInterface
interface MyFunctionalInterface {
  public Integer sqr(int a);

  default String sqr(String a) {
    return a + a;
  }
}
