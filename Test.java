public class Test {
  public static void main(String[] args) {
    CodeWarrior Bob = new CodeWarrior("Bob",2000);
    JavaJester Jerry = new JavaJester("Jerry");
    Bob.setSpecial(2);
    System.out.println(Bob.getSpecialMax());
    System.out.println(Bob.getSpecial());
    System.out.println(Jerry.support(Bob));
    System.out.println(Bob.getSpecial());
  }
}
