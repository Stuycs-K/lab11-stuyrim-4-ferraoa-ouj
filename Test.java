public class Test {
  public static void main(String[] args) {
    CodeWarrior Bob = new CodeWarrior("Bob",2000);
    JavaJester Jerry = new JavaJester("Jerry");
    PythonPrince Patrick = new PythonPrince("Patrick");
    EnemyTank Goon1 = new EnemyTank("Goon1");
    EnemySharpshooter Goon2 = new EnemySharpshooter("Goon2");
    System.out.println(Goon2.attack(Bob));
    System.out.println(Bob.getHP());
    System.out.println(Goon2.support());
    System.out.println(Goon2.attack(Bob));
    System.out.println(Bob.getHP());

  }
}
