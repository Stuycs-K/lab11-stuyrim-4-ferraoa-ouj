public class Test {
  public static void main(String[] args) {
    CodeWarrior Bob = new CodeWarrior("Bob", 2000);
    Boss Bossy = new Boss("Bossy");
    System.out.println(Bossy.support());
    System.out.println(Bossy.support());

    System.out.println(Bossy.support());
    System.out.println(Bossy.support());
    System.out.println(Bossy.support());
    System.out.println(Bossy.support());
    System.out.println(Bossy.attack(Bob));
    System.out.println(Bob.getHP());
    System.out.println(Bossy.attack(Bob));
    System.out.println(Bob.getHP());
    System.out.println(Bossy.attack(Bob));
    System.out.println(Bob.getHP());

    
  
  }
}
