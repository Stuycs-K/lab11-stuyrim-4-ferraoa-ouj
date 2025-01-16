public class Test {
  public static void main(String[] args) {
    CodeWarrior Bob = new CodeWarrior("Bob",2000);
    JavaJester Jerry = new JavaJester("Jerry");
    System.out.println(Jerry.getHP() + " " + Jerry.getSpecial());
    System.out.println(Jerry.support());
    System.out.println(Jerry.getHP() + " " + Jerry.getSpecial());
  }
}
