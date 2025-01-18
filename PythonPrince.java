public class PythonPrince extends Adventurer {
  
  boolean support = false;
  int charmMax = 10;
  int charm = 7;

  public PythonPrince(String name) {
    super(name, 50);
  }

  public String getSpecialName() {return "StackOverflow";}

  public int getSpecial() {return charm;}

  public int getSpecialMax() {return charmMax;}

  public void setSpecial(int n) {charm = n;}

  public boolean getSupport() {return support;}

  public String attack(Adventurer other) {
    double damage = (double) this.getmaxHP() - this.getHP();
    if (support) {
      damage = 1.5 * damage;
      other.applyDamage((int) damage);
      this.restoreSpecial(2)
    }
    else {
      other.applyDamage((int) damage);
      this.restoreSpecial(1);
    }

    support = false;
    return this + " used Bug in the Code and dealt " + (int) damage + " damage to " + other;
  }

  public String support(Adventurer other) {
    other.applyDamage(10);
    support = true;
    return this + " used Function Call and acquired a strength potion from " + 
    other + ", who lost 10 HP but " + this  + " will do 1.5x damage on next turn.";
  }

  //heal or buff self
  public String support() {
    this.applyDamage(10);
    support = true;
    return this + " used Function Call and drank its own strength potion, losing 10HP but does 1.5x damage on next turn";
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
