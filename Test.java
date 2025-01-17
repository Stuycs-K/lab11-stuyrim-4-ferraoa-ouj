public class Test {
  public static void main(String[] args) {
    CodeWarrior Bob = new CodeWarrior("Bob",2000);
    JavaJester Jerry = new JavaJester("Jerry");
    PythonPrince Patrick = new PythonPrince("Patrick");
    System.out.println(Patrick.attack(Bob));
    System.out.println(Bob.getHP());
    Patrick.applyDamage(10);
    System.out.println(Patrick.attack(Bob));
    System.out.println(Bob.getHP());
  }
}
