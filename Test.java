public class Test {
  public static void main(String[] args) {
    CodeWarrior Bob = new CodeWarrior("Bob",2000);
    JavaJester Jerry = new JavaJester("Jerry");
    PythonPrince Patrick = new PythonPrince("Patrick");
    EnemyTank Goon1 = new EnemyTank("Goon1");
    System.out.println(Goon1.getHP());
    System.out.println(Goon1.support());
    System.out.println(Goon1.getHP());
    Goon1.applyDamage(15);
    System.out.println(Goon1.getHP());
    System.out.println(Goon1.support());
    System.out.println(Goon1.getHP());
  }
}
