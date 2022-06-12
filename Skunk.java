/**
 * A class representing a Skunk, a subclass of Pet. A Skunk can make other Pets weaker before
 * attacking them but only a set number of times.
 * @author Mashu Takeda mtakeda9
 * @version 1
 */
public class Skunk extends Pet {
    private int numSpray;

    /**
     * A constructor that takes health, attack, and numSpray.
     * @param health int representing the health points for this Pet.
     * @param attack int representing the attack points for this Pet.
     * @param numSpray int representing the number of times the Skunk can spray
     */
    public Skunk(int health, int attack, int numSpray) {
        super(health, attack);
        if (numSpray < 0) {
            this.numSpray = 0;
        } else {
            this.numSpray = numSpray;
        }
    }

    /**
     * A constructor that takes no arguments that sets health to 5, attack to 3, and numSpray
     * to 1.
     */
    public Skunk() {
        this(5, 3, 1);
    }

    /**
     * Method that takes in another Pet that will be sprayed by this Skunk
     * and reduces the attack and health of the pet sprayed by a third of its original stats.
     * @param anotherPet the pet that gets sprayed by the Skunk
     */
    public void sprayPet(Pet anotherPet) {
        if (numSpray > 0) {
            anotherPet.setAttack(anotherPet.getAttack() * 2 / 3);
            anotherPet.setHealth(anotherPet.getHealth() * 2 / 3);
            numSpray = numSpray - 1;
        }
    }


    @Override
    public void attackPet(Pet anotherPet) {
        if (numSpray > 0) {
            sprayPet(anotherPet);
        } else {
            anotherPet.getAttacked(this.getAttack());
        }
    }

    @Override
    public String toString() {
        return "Skunk:" + super.toString() + "/" + numSpray;
    }
}