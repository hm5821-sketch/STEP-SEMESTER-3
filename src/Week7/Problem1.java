package Week7;

abstract class Toy {
    private static int counter = 1000;
    private final String toyId;
    protected String name;

    public Toy(String name) {
        this.name = name;
        counter++;
        this.toyId = "TOY-" + counter;
    }

    public abstract String makeSound();

    public String getToyId() {
        return this.toyId;
    }
}

class ToyCar extends Toy {
    public ToyCar(String name) {
        super(name);
    }

    @Override
    public String makeSound() {
        return name + ": Vroom vroom!";
    }
}

class ToyRobot extends Toy {
    public ToyRobot(String name) {
        super(name);
    }

    @Override
    public String makeSound() {
        return name + ": Beep boop!";
    }
}

public class Problem1 {
    public static void main(String[] args) {
        ToyCar c = new ToyCar("Speedster");
        System.out.println(c.makeSound()); // Output: Speedster: Vroom vroom!

        ToyRobot r = new ToyRobot("Bolt");
        System.out.println(r.makeSound()); // Output: Bolt: Beep boop!

        System.out.println(c.getToyId());  // Output: TOY-1001
        System.out.println(r.getToyId());  // Output: TOY-1002
    }
}