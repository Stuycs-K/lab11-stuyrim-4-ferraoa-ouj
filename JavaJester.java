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
    int totalDamage = 0;
    for (int i = 0; i < 7; i++) {
      int damage = (int) (Math.random() * 3) + 1;
      totalDamage++;
      other.applyDamage(damage);
    }
  }

  public String support(Adventurer other) {
    return "";
  }

  //heal or buff self
  public String support() {
    return "";
  }

  //hurt or hinder the target adventurer, consume some special resource
  public String specialAttack(Adventurer other) {
    return ""
  }
}
