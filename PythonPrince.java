public class PythonPrince extends Adventurer {
  
  boolean selfSupport = false;
  boolean otherSupport = false;
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
    int damage = this.getmaxHP() - this.getHP();
    if (selfSupport || otherSupport) { 
      other.applyDamage(1.5 * damage);
    }
    other.applyDamage(damage);
    selfSupport = false;
    otherSupport = false;
    return this + " used Bug in the Code and dealt " + damage + " damage to " + other;
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
    return this + " used Function Call and acquired a strength potion from " + 
    other + ", who lost 5 HP but " + this  + " will do 1.5x damage on next turn.";
  }

  //heal or buff self
  public String support() {
    this.setSpecial(this.getSpecialMax());
    this.applyDamage(5);
    return this + " used Function Call and drank its own strength potion, losing 10HP but doing 1.5x damage";
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
