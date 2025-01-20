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
    }
    else {
      other.applyDamage((int) damage);
      this.restoreSpecial(1);
    }

    support = false;
    return this + " used Static Method and dealt " + (int) damage + " damage to " + other;
  }

  public String support(Adventurer other) {
    other.applyDamage(10);
    support = true;
    return this + " used Overwrite and acquired a strength potion from " + 
    other + ", who lost 10 HP but " + this  + " will do 1.5x damage on next turn.";
  }

  //heal or buff self
  public String support() {
    this.applyDamage(10);
    support = true;
    return this + " used Overwrite and drank its own strength potion, losing 10HP but does 1.5x damage on next turn";
  }

  //hurt or hinder the target adventurer, consume some special resource
  public String specialAttack(Adventurer other) {
    if (getSpecial() > 7) {
      setSpecial(getSpecial() - 7);
      this.attack(other);
      this.setHP(this.getmaxHP());
      return this + " used Class Method and attacked " + other
      + " and dealt " + (this.getmaxHP() - this.getHP()) + " restoring HP to max and consuming 7 charm.";
    }
    else {
      return this + " tried to use Class Method but failed and lost turn.";
    }
  }
}
