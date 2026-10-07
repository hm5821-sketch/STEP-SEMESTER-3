package Week7;

abstract class KitchenTool {
    private int speedLevel;

    public abstract String prepare();

    public int getSpeedLevel() {
        return speedLevel;
    }

    public void setSpeedLevel(int speedLevel) {
        if (speedLevel >= 1 && speedLevel <= 5) {
            this.speedLevel = speedLevel;
        }
    }
}

interface Washable {
    String clean();
}

class Blender extends KitchenTool implements Washable {
    @Override
    public String prepare() {
        return "Blending at speed " + getSpeedLevel();
    }

    @Override
    public String clean() {
        return "Blender rinsed and dried";
    }
}

public class Problem4 {
    public static void main(String[] args) {
        Blender b = new Blender();
        b.setSpeedLevel(3);
        System.out.println(b.getSpeedLevel()); // Output: 3

        b.setSpeedLevel(9); // Rejected, stays 3
        System.out.println(b.getSpeedLevel()); // Output: 3

        System.out.println(b.prepare());       // Output: Blending at speed 3
        System.out.println(b.clean());         // Output: Blender rinsed and dried
    }
}
