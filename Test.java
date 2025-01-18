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
    System.out.println(Patrick.getSupport());
    
    System.out.println("\n\n" + Patrick.support(Jerry));
    System.out.println(Jerry.getHP());
    System.out.println(Patrick.getSupport());
    System.out.println(Patrick.attack(Bob));
    System.out.println(Bob.getHP());
    System.out.println(Patrick.getSupport());

    System.out.println("\n\n" + Patrick.attack(Bob));
    System.out.println(Bob.getHP());
    System.out.println(Patrick.support());
    System.out.println(Patrick.getHP());
    System.out.println(Patrick.getSupport());
    System.out.println(Patrick.attack(Bob));
    System.out.println(Bob.getHP());
    System.out.println(Patrick.getSupport());
    
  }
}
