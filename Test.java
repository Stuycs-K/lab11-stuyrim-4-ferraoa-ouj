public class Test {
  public static void main(String[] args) {
    CodeWarrior Bob = new CodeWarrior("Bob",2000);
    JavaJester Jerry = new JavaJester("Jerry");
    Jerry.setSpecial(5);
    System.out.println(Jerry.getSpecial());
    System.out.println(Jerry.specialAttack(Bob));
    System.out.println(Bob.getHP());
    System.out.println(Jerry.getSpecial());
    Jerry.setSpecial(13);
    System.out.println(Jerry.getSpecial());
    System.out.println(Jerry.specialAttack(Bob));
    System.out.println(Bob.getHP());
    System.out.println(Jerry.getSpecial());
  }
}
