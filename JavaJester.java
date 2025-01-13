public class JavaJester extends Adventurer {

  int sillinessMax = 12;
  int silliness;

  public JavaJester(String name) {
    this(name, 80);
  }

  public String getSpecialName() {return "StackOverflow";}

  public int getSpecial() {return silliness;}

  public int getSpecialMax() {return sillinessMax;}

  public void setSpecial(int n) {silliness = n;}

  public String attack(Adventurer other) {
    for (int i = 0; i < 7; i++) {
      int damage = (int) (Math.random() * 3) + 1;
    }
  }
}
