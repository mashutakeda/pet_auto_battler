/**
 * A class that represents where Pet battles will occur.
 * @author Mashu Takeda mtakeda9
 * @version 1
 */
public class PetBattlefield {
    private Pet[] firstTeam;
    private Pet[] secondTeam;

    /**
     * A constructor that takes firstTeam and secondTeam and sets them appropriately. If either
     * array has a capacity of more than 5, replace both with empty arrays of size 5.
     * @param firstTeam one of the teams attending the battle
     * @param secondTeam another team that attends the battle
     */
    public PetBattlefield(Pet[] firstTeam, Pet[] secondTeam) {
        if (firstTeam.length > 5) {
            this.firstTeam = new Pet[5];
        }
        if (secondTeam.length > 5) {
            this.secondTeam = new Pet[5];
        } else {
            this.firstTeam = firstTeam;
            this.secondTeam = secondTeam;
        }
    }


    @Override
    public String toString() {
        String concat = "";
        concat += "First Team: ";
        for (int i = 0; i < firstTeam.length; i++) {
            if (firstTeam[i] == null) {
                concat += "Empty, ";
            } else {
                concat = concat + firstTeam[i].toString() + ", ";
            }
        }
        concat += "vs Second Team: ";
        for (int i = 0; i < secondTeam.length; i++) {
            if (secondTeam[i] == null) {
                concat += "Empty, ";
            } else {
                concat = concat + secondTeam[i].toString() + ", ";
            }
        }
        return concat;
    }

    /**
     * Method that compares each Pet in the first team with its corresponding Pet in the second team to
     * predicts which team is more likely to win solely based on their stats.
     */
    public void compareTeams() {
        int winner = 0;
        int shorter;
        if (firstTeam.length < secondTeam.length) {
            shorter = firstTeam.length;
        } else {
            shorter = secondTeam.length;
        }

        for (int i = 0; i < shorter; i++) {
            if (firstTeam[i] == null) {
                winner -= 1;
            } else if (secondTeam[i] == null) {
                winner += 1;
            } else if (firstTeam[i].compareTo(secondTeam[i]) > 0) {
                winner += 1;
            } else if (firstTeam[i].compareTo(secondTeam[i]) < 0) {
                winner -= 1;
            }
        }

        if (secondTeam.length != firstTeam.length) {
            winner = winner + (firstTeam.length - secondTeam.length);
        }


        if (winner > 0) {
            System.out.println("The first team will probably win.");
        } else if (winner < 0) {
            System.out.println("The second team will probably win.");
        } else {
            System.out.println("It is an even match.");
        }
    }

    /**
     * Method that conducts battle between the two teams in the PetBattlefield until at least one of the teams
     * has only fainted pets.
     */
    public void battle() {
        int i = 0;
        int j = 0;
        //handle null values  firstTeam[i] != null && secondTeam[j] != null
        while (i < firstTeam.length && j < secondTeam.length) {
//        for (i = 0, j = 0; j <= secondTeam.length && i <= firstTeam.length; i++, j++) {
            //handles null
            if (firstTeam[i] == null) {
                i++;
            }
            if (secondTeam[j] == null) {
                j++;
            }
            if (secondTeam[j] instanceof Turtle || secondTeam[j] instanceof Skunk) {
                battleHelper(secondTeam[j], firstTeam[i]);
                battleHelper(firstTeam[i], secondTeam[j]);
            } else {
                battleHelper(firstTeam[i], secondTeam[j]);
                battleHelper(secondTeam[j], firstTeam[i]);
            }
            if (secondTeam[j].getHealth() <= 0) {
                secondTeam[j] = null;
                j++;
            }
            if (firstTeam[i].getHealth() <= 0) {
                firstTeam[i] = null;
                i++;
            }
        }

        if (i >= firstTeam.length && j >= secondTeam.length) {
            System.out.println("Both teams fainted.");
        } else if (j >= secondTeam.length) {
            System.out.println("The first team won!");
        } else if (i >= firstTeam.length) {
            System.out.println("The second team won!");
        }
    }

    /**
     * Helper method for battle() method.
     * @param hit the pet that attacks for the turn
     * @param receive the pet that gets attacked for the turn
     */
    private void battleHelper(Pet hit, Pet receive) {
        if (hit instanceof Turtle) {
//            receive.getAttacked(hit.getAttack());
            hit.attackPet(receive);
        } else if (hit instanceof Hippo) {
            hit.attackPet(receive);  ///check if it's hippo attackpet
        } else if (hit instanceof Skunk) {
            hit.attackPet(receive);
        }
    }

    /**
     * Main method used to create objects and run the classes.
     * @param args the command line arguments.
     */
    public static void main(String[] args) {
        Pet[] teamone = {
            new Turtle(1, 2, false),
            new Hippo(2, 1, 5),
            new Skunk(1, 1, 1),
        };
        Pet[] teamtwo = {
            new Turtle(1, 2, false),
            new Hippo(2, 3, 5),
            new Skunk(1, 1, 1),
        };
        PetBattlefield battlefield = new PetBattlefield(teamone, teamtwo);
        battlefield.compareTeams();
        battlefield.battle();

        Pet[] teamthree = {
            new Hippo(2, 1, 5),
            new Turtle(1, 2, true),
            new Skunk(1, 1, 1),
        };
        Pet[] teamfour = {
            new Hippo(2, 1, 5),
            new Turtle(1, 2, false),
            new Skunk(1, 1, 1),
        };
        PetBattlefield battlefield2 = new PetBattlefield(teamthree, teamfour);
        battlefield2.compareTeams();
        battlefield2.battle();

        Pet[] teamfive = {
            new Hippo(2, 1, 5),
            null,
            new Skunk(1, 1, 1),
        };
        Pet[] teamsix = {
            new Hippo(2, 1, 5),
            new Turtle(1, 2, false),
            new Skunk(1, 1, 1),
        };
        PetBattlefield battlefield3 = new PetBattlefield(teamfive, teamsix);
        battlefield3.compareTeams();
        battlefield3.battle();

    }
}