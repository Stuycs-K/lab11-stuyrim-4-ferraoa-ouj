public class EnemySpyware extends Enemy{

    public EnemySpyware(String name) {
        super(name, 120);
    }

    public String support() {
        this.setHP(this.getHP() + 25);
        if (this.getHP() > this.getmaxHP()) {
            this.setHP(this.getmaxHP());
            return this + " stole information, healing to maxHP";
        }
        else {
            return this + " stole information, healing 25 HP";
        }
    }

    public String attack(Adventurer other) {
        other.applyDamage(10);
        return this + " attacked " + other + " and dealt 10 damage.";
    }
}