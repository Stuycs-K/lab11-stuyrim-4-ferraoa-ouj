public class Boss extends Enemy {

    boolean doubleDamage = false;
    Adventurer poisoned = null;

    private void restoreHP(int n) {
        if (this.getHP() + n > this.getmaxHP()) {
            this.setHP(this.getmaxHP());
        }
        else {
            this.setHP(this.getHP() + n);
        }
    }
    
    private void poison(Adventurer other) {
        poisoned = other;
    }

    public Boss(String name) {
        super(name, 200);
    }

    public String support() {
        //  Heal, DoubleDamage
        int supporter = (int) (Math.random() * 2); 
        if (supporter == 0) {
            this.setHP(this.getHP() + 20);
            if (this.getHP() > this.getmaxHP()) {
                this.setHP(this.getmaxHP());
                return this + " healed to max HP.";
            }
            return this + " healed 50 HP.";
        }
        else {
            doubleDamage = true;
            return this + " buffed itself and will do double damage on the next turn.";
        }
    }

    public String attack(Adventurer other) {
        int whichAttack = (int) (Math.random() * 3);
        String output = "";
        if(poisoned != null) {
            poisoned.applyDamage(10);
            output += poisoned + " lost 10 HP from poison!";
        }
        if (whichAttack == 0) {
            //Poison
            poison(other);
            output = other + " has been poisoned. " + output;
        }
        else if (whichAttack == 1) {
           //Lifesteal
           int damage = 0;
            if (doubleDamage) {
                other.applyDamage(20);
                this.restoreHP(20);
                damage += 20;
            }
            other.applyDamage(20);
            this.restoreHP(20);
            damage += 20;
            doubleDamage = false;
            output = this + " took " + damage + " HP from " + other + ". " + output;
        }
        else if (whichAttack == 2) {
            int damage = 0;
            if (doubleDamage) {
                other.applyDamage(25);
                damage+=25;
            }
            other.applyDamage(25);
            damage+=25;
            output = this + " dealt " + damage + " damage to " + other + ". " + output;
        }
        return output;
    }
}