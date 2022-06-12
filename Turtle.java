/**
 * This will be a class representing a Turtle, a subclass of Pet. A Turtle can start with melon armor which
 * prevents up to 20 damage the first time it is attacked.
 * @author Mashu Takeda mtakeda9
 * @version 1
 */
public class Turtle extends Pet {
    private boolean melonArmor;

    /**
     * A constructor that takes health, attack, and melonArmor.
     * @param health int representing the health points for this Pet.
     * @param attack int representing the attack points for this Pet.
     * @param melonArmor boolean representing whether the turtle has melonarmor, the ability
     *                   to block 20 damage from the attack.
     */
    public Turtle(int health, int attack, boolean melonArmor) {
        super(health, attack);
        this.melonArmor = melonArmor;
    }

    /**
     * A constructor that takes no arguments that sets health to 4, attack to 2, and
     * melonArmor to true.
     */
    public Turtle() {
        this(4, 2, true);
    }


    //---------------------methods--------------

    @Override
    public void getAttacked(int damage) {
        if (melonArmor) {
            if (damage > 20) {
                melonArmor = false;
                super.getAttacked(damage - 20);
            } else {
                melonArmor = false;
                super.getAttacked(0);
            }
        } else {
            super.getAttacked(damage);
        }
    }

    @Override
    public String toString() {
        return "Turtle:" + super.toString() + "/" + melonArmor;
    }


}