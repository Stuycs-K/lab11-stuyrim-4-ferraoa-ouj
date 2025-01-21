public class EnemyAdware extends Enemy {

    int gluttony = 0;

    public int getGlutonny() {
        return gluttony;
    }
    
    public EnemyAdware(String name) {
        super(name, 80);
    }
    
    public String support() {
        int currentHP = this.getHP();
        if (currentHP + gluttony >= this.getmaxHP()) {
            this.setHP(this.getmaxHP());
            gluttony = 0;
            return this + " relished on the damage it dealt and healed " + (this.getmaxHP() - currentHP) + " HP.";
        }
        else { 
            this.setHP(currentHP + gluttony);
            gluttony = 0;
            return this + " relished on the damage it dealt and healed " + (this.getHP() - currentHP) + " HP.";
        }
    }

    public String attack(Adventurer other) {
        other.applyDamage(20);
        gluttony += 10;
        return this + " attacked " + other + " and dealt 20 damage.";
    }
}