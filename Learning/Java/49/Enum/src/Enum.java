/**
 * Enum
 *      Class that demonstrates how to use enum.
 */
public class Enum {

    public static void main(String[] args) {

        Planet planetEarth = Planet.EARTH;
        Planet planetMars = Planet.MARS;

        habitable(planetEarth);
        habitable(planetMars);
    }

    /**
     * habitable
     *      Prints whether or not the given planet is habiatable.
     * 
     * Parameters:
     *      planet Planet
     *          One of the enumerated items in enum Planet.
     */
    static void habitable(Planet planet) {
        switch (planet) {
            case EARTH:
                System.out.println("You can live here");
                System.out.println("This is planet #" + planet.number + " from the sun");
                break;
            default:
                System.out.println("You can't live here... as of right now.");
                System.out.println("This is planet #" + planet.number + " from the sun");
        }
    }
}

/*
 * Planet
 *      Enumerated list containing planets in the solar system.
 */
enum Planet {
    MERCURY(1),
    VENUS(2),
    EARTH(3),
    MARS(4),
    JUPITER(5),
    SATURN(6),
    URANUS(7),
    NEPTUNE(8),
    PLUTO(9);

    // Attributes

    int number;

    // Methods

    /**
     * Planet
     *      Constructor for enum Planet that takes one parameter.
     * 
     * Parameters:
     *      number int
     *          Which number planet from the sun the planet it.
     */
    Planet(int number) {
        this.number = number;
    }
}
