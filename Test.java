public class Test {
  public static void main(String[] args) {
    CodeWarrior Bob = new CodeWarrior("Bob");
    JavaJester Jerry = new JavaJester("Jerry");
    System.out.println(Jerry.attack(Bob));
    System.out.println(Bob.getHP());
    System.out.println(Jerry.getSpecial());
  }
}
