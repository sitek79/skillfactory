package weekofpractice;

public class Bell {
    Boolean switcher = true;

    void sound() {
        if (switcher) {
            System.out.println("ding");
        } else System.out.println("dong");
        switcher = !switcher;
    }
}
