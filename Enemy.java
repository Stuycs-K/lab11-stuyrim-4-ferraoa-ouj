public abstract class Enemy extends Adventurer {
    public Enemy() {
        super();
    }

    public Enemy(String name) {
        super(name);
    }

    public Enemy(String name, int hp) {
        super(name, hp);
    } 

    public String getSpecialName() {
        return null;
    }
    public int getSpecial() {
        return 0;
    }
    public int getSpecialMax() {
        return 0;
    }
    public void setSpecial(int n) {
        return;
    }
    public String specialAttack(Adventurer other) {
        return null;
    } 
    public String support(Adventurer other) {
        return null;
    }

    public abstract String support();
    public abstract String attack(Adventurer other);
 }