public class JavaJester extends Adventurer {

  int charmMax = 20;
  int charm = 0;

  public PythonPrince(String name) {
    super(name, 50);
  }

  public String getSpecialName() {return "StackOverflow";}

  public int getSpecial() {return charm;}

  public int getSpecialMax() {return charmMax;}

  public void setSpecial(int n) {charm = n;}

  public String attack(Adventurer other) {
    int restoreage = 0;
    int totalDamage = 0;
    for (int i = 0; i < 7; i++) {
      int damage = (int) (Math.random() * 3) + 1;
      totalDamage += damage;
      other.applyDamage(damage);
    }80
    if(totalDamage < 14) {
      restoreSpecial(1);
      restoreage = 1;
    }
    else {
      restoreSpecial(2);
      restoreage = 2;
    }
    return this + " used Recursion and attacked " + other + " and dealt " + totalDamage + " to them and restored " + restoreage + " charm " ;
  }

  public String support(Adventurer other) {
    int original = other.getSpecial();
    int half = other.getSpecialMax() / 2;
    if (other.getSpecial() < half) {
      other.restoreSpecial(half);
    }
    else {
      other.setSpecial(other.getSpecialMax());
    }
    this.setSpecial(0);
    return this + " used IndexOutOfBoundsException and restored " + other + "'s special from " + original + " to " + other.getSpecial();
  }

  //heal or buff self
  public String support() {
    this.setSpecial(this.getSpecialMax());
    this.applyDamage(5);
    return this + " used IndexOutOfBoundsException and restored its special to max but lost 5 HP.";
  }

  //hurt or hinder the target adventurer, consume some special resource
  public String specialAttack(Adventurer other) {
    if (getSpecial() > 10) {
      setSpecial(getSpecial() - 10);
      int totalDamage = 0;
      int counter = (int) (Math.random() * 15) + 1;
      while (counter != 1) {
        int damage = (int) (Math.random() * 3) + 1;
        other.applyDamage(damage);
        totalDamage += damage;
        counter = (int) (Math.random() * 15) + 1;
      }
      return this + " used StackOverflow and attacked " + other
      + " and dealt " + totalDamage + " consuming 10 charm.";
    }
    else {
      setSpecial(0);
      return this + " tried to use StackOverflow but failed and lost all their charm.";
    }
  }
}
