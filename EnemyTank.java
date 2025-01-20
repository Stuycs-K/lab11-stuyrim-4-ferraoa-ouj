public class EnemyTank extends Enemy{

    public EnemyTank(String name) {
        super(name, 120);
    }

    public String support() {
        this.setHP(this.getHP() + 10);
        if (this.getHP() > this.getmaxHP()) {
            this.setHP(this.getmaxHP());
            return this + " used its heal and healed to its maxHP";
        }
        else {
            return this + " used its heal and healed 10 HP";
        }
    }

    public String attack(Adventurer other) {
        other.applyDamage(10);
        return this + " attacked " + other + " and dealt 10 damaage. ";
    }
}