public class EnemySharpshooter extends Enemy {

    boolean doubleDamage = false;

    public EnemySharpshooter(String name) {
        super(name, 50);
    }

    public String support() {
        doubleDamage = true;
        return this + " buffed themselves up and will do double damage on the next turn.";
    }

    public String attack(Adventurer other) {
        int damage = 0;
        if(doubleDamage) {
            other.applyDamage(15);
            damage += 15;
        }
        other.applyDamage(15);
        damage += 15;
        doubleDamage = false;
        return this + " dealt " + damage + " damage to " + other + ".";
    }
}