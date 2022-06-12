/**
 * This will be a class representing a Hippo, a subclass of Pet. A Hippo can get stronger, or buffed, each
 * time it makes an enemy Pet faint.
 * @author Mashu Takeda mtakeda9
 * @version 1
 */
public class Hippo extends Pet {
    private int buff;

    /**
     * A constructor that takes health, attack, and buff.
     * @param health int representing the health points for this Pet.
     * @param attack int representing the attack points for this Pet.
     * @param buff An int representing the buff, or increase to this Hippo’s health and attack, it will
     * receive if it successfully knocks out another Pet.
     */
    public Hippo(int health, int attack, int buff) {
        super(health, attack);
        if (buff < 0) {
            this.buff = 0;
        } else {
            this.buff = buff;
        }
    }

    /**
     * A constructor that takes no arguments that sets health to 7, attack to 4, and buff to 2.
     */
    public Hippo() {
        this(7, 4, 2);
    }


    /**
     * Method that increase the Hippo's health and attack by buff.
     */
    public void getBuffed() {
        this.setAttack(this.getAttack() + buff);
        this.setHealth(this.getHealth() + buff);
    }


    /**
     * Method that attacks other pets. If the attack successfully causes the attacked Pet to faint,
     * this Hippo should get buffed.
     * @param anotherPet the pet that Hippo is attacking
     */
    @Override
    public void attackPet(Pet anotherPet) {
        anotherPet.getAttacked(this.getAttack());
        if (anotherPet.getHealth() <= 0) {
            getBuffed();
        }
    }

    /**
     * Method that returns a string representing health, attack, and buff values for the Hippo.
     * @return a string representing health, attack, and buff values for the Hippo.
     */
    @Override
    public String toString() {
        return "Hippo:" + super.toString() + "/" + buff;
    }


}