/**
 * Interface
 *      Class that demonstrates how interfaces work.
 */
public class Interface {

    public static void main(String[] args) {

        Melmetal melmetal = new Melmetal();
        melmetal.flashCannon();

        Infernape infernape = new Infernape();
        infernape.flameWheel();
        infernape.closeCombat();

        Mienshao mienshao = new Mienshao();
        mienshao.closeCombat();
    }
}

/**
 * Fire
 *      Interface that establishes an abstract method for a Fire type move.
 */
interface Fire {

    // Methods

    /**
     * flameWheel
     *      Abstract method for fire type move "Flame Wheel".
     */
    void flameWheel();
}

/**
 * Fighting
 *      Interface that establishes an abstract method for a Fighting type move.
 */
interface Fighting {

    // Methods

    /**
     * closeCombat
     *      Abstract method for fighting type move "Close Combat".
     */
    void closeCombat();
}

/**
 * Steel
 *      Interface that establishes an abstract method for a Steel type move.
 */
interface Steel {

    // Methods

    /**
     * flashCannon
     *      Abstract method for steel type move "Flash Cannon".
     */
    void flashCannon();
}

/**
 * Melmetal
 *      Class that represents the Pokemon Melmetal which implements
 *      interface Steel because it is a steel type Pokemon.
 */
class Melmetal implements Steel {

    // Methods

    /**
     * flashCannon
     *      Implementation of abstract method flashCannon by steel type Pokemon, Melmetal.
     */
    @Override
    public void flashCannon() {
        System.out.println("Melmetal used Flash Cannon!");
    }
}

/**
 * Infernape
 *      Class that represents the Pokemon Infernape which implements interface
 *      Fire and interface Fighting because it is a fire/fighting type Pokemon.
 */
class Infernape implements Fire, Fighting {

    // Methods

    /**
     * flameWheel
     *      Implementation of abstract method flameWheel by fire/fighting type Pokemon, Infernape.
     */
    @Override
    public void flameWheel() {
        System.out.println("Infernape used Flame Wheel!");
    }

    /**
     * closeCombat
     *      Implementation of abstract method closeCombat by fire/fighting type Pokemon, Infernape.
     */
    @Override
    public void closeCombat() {
        System.out.println("Infernape used Close Combat!");
    }
}

/**
 * Mienshao
 *      Class that represents the Pokemon Mienshao which implements
 *      interface Fighting because it is a fighting type Pokemon.
 */
class Mienshao implements Fighting {

    // Methods

    /**
     * closeCombat
     *      Implementation of abstract method closeCombat by fighting type Pokemon, Mienshao.
     */
    @Override
    public void closeCombat() {
        System.out.println("Mienshao used Close Combat!");
    }
}
