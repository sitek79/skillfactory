package practice3;

import static practice3.BinCheckerHello.printHello;

public class App {
    static String mulString(String p, int n) {
        String result = "";
        for (int i = 0; i < n; i++)
            result += p;
        return result;
    }

    public static void main(String[] args) {
        printHello();
        System.out.println(mulString("#", 30));
        // light
        Light lt = new Light();
        lt.on();
        // Введите номер кредитной карты ХХХХ_ХХХХ_ХХХХ_ХХХХ
        Input inp = new Input();
        inp.startInput();
    }
}
