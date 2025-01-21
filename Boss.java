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
        String output = "";
        if(poisoned != null && poisoned.getHP() > 0) {
            poisoned.applyDamage(10);
            output += poisoned + " lost 10 HP from poison!";
        }

        int supporter = (int) (Math.random() * 2); 
        if (supporter == 0) {
            this.setHP(this.getHP() + 50);
            if (this.getHP() > this.getmaxHP()) {
                this.setHP(this.getmaxHP());
                output = this + " healed to max HP. " + output;
            }
            else{
                output = this + " healed 50 HP. " + output;
            }
        }
        else {
            doubleDamage = true;
            output = this + " buffed itself and will do double damage on the next turn. " + output;
        }

        return output;
    }

    public String attack(Adventurer other) {
        int whichAttack = (int) (Math.random() * 3);
        String output = "";
        if(poisoned != null && poisoned.getHP() > 0) {
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
                other.applyDamage(15);
                this.restoreHP(15);
                damage += 15;
            }
            other.applyDamage(15);
            this.restoreHP(15);
            damage += 15;
            doubleDamage = false;
            output = this + " took " + damage + " HP from " + other + ". " + output;
        }
        else if (whichAttack == 2) {
            //Heavy Hitter
            int damage = (int) (Math.random() * 11) + 25;
            if (doubleDamage) {
                other.applyDamage(damage * 2);
                output = this + " dealt " + (damage * 2) + " damage to " + other + ". " + output;
            }
            else{
                other.applyDamage(damage);
                output = this + " dealt " + damage + " damage to " + other + ". " + output;
            }
        }
        return output;
    }
}