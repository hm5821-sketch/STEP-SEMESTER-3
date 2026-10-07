package Week7;

abstract class Instrument {
    public abstract String play();
}

class StringInstrument extends Instrument {
    @Override
    public String play() {
        return "Strumming the strings";
    }
}

class Violin extends StringInstrument {
    @Override
    public String play() {
        return super.play() + ", with a bow drawn across four strings";
    }
}

public class Problem3 {
    public static void main(String[] args) {
        StringInstrument s = new StringInstrument();
        System.out.println(s.play()); // Output: Strumming the strings

        Violin v = new Violin();
        System.out.println(v.play()); // Output: Strumming the strings, with a bow drawn across four strings
    }
}
