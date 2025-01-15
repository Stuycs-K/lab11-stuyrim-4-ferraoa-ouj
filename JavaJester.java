public class JavaJester extends Adventurer {

  int sillinessMax = 15;
  int silliness;

  public JavaJester(String name) {
    super(name, 80);
  }

  public String getSpecialName() {return "StackOverflow";}

  public int getSpecial() {return silliness;}

  public int getSpecialMax() {return sillinessMax;}

  public void setSpecial(int n) {silliness = n;}

  public String attack(Adventurer other) {
    int restoreage = 0;
    int totalDamage = 0;
    for (int i = 0; i < 7; i++) {
      int damage = (int) (Math.random() * 3) + 1;
      totalDamage += damage;
      other.applyDamage(damage);
    }
    if(totalDamage < 14) {
      restoreSpecial(1);
      restoreage = 1;
    }
    else {
      restoreSpecial(2);
      restoreage = 2;
    }
    return this + " used Recursion and attacked " + other + " and dealt " + totalDamage + " to them and restored " + restoreage + " silliness " ;
  }

  public String support(Adventurer other) {
    int returner;
    double allyMeter = (double) other.getSpecial();
    if (allyMeter < (1.0/2.0) * other.getSpecialMax()) {
      int twoThirds = (int) (1.0/2.0) * other.getSpecialMax();
      returner = twoThirds;
      other.setSpecial(other.getSpecial() + twoThirds);
    }
    else {
      other.setSpecial(other.getSpecialMax());
      returner = getSpecialMax;
    }
    this.setSpecial(0);
    return this + " used IndexOutOfBoundsException and restored " + returner + " special to " + other;
  }

  //heal or buff self
  public String support() {
    return "";
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
      + " and dealt " + totalDamage + " consuming 10 silliness.";
    }
    else {
      setSpecial(0);
      return this + " tried to use StackOverflow but failed and lost all their silliness.";
    }
  }
}
