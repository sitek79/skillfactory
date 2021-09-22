package practice3edit;

import java.math.BigInteger;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Input {
    void startInput() {
        // строим класс с методами проверки
        BinValidationEngine binCheckerEngine = new BinValidationEngine();

        Scanner in = new Scanner(System.in);
        System.out.print("Введите номер банковский карты: ");
        BigInteger num = in.nextBigInteger();
        // отформатируем вывод номера карты
        StringBuffer formatCardNumber = new StringBuffer(num.toString());
        formatCardNumber.insert(4, '-');
        formatCardNumber.insert(9, '-');
        formatCardNumber.insert(14, '-');

        System.out.printf("Вы ввели номер карты: %s \n", formatCardNumber);
        // проверка корректности ввода
        // добавим в условие if еще и регулярное выражение возвращающее True или False
        // определяем шаблон поиска Pattern — само регулярное выражение
        // и затем Matcher — ищем совпадение с шаблоном описываемым регулярным выражением
        String regexp = "^\\d{16}$";
        Pattern pattern = Pattern.compile(regexp); // что ищем
        Matcher matcher = pattern.matcher(num.toString()); // где ищем
        int cardnumberLength = num.toString().length();
        if (cardnumberLength == 16) System.out.println("Длина номера карты " + cardnumberLength + " цифр: " + matcher.find());
        if (cardnumberLength != 16) System.out.println("Вы ввели неверный номер карты");

        // Вычисление контрольной цифры номера пластиковой карты (Алгоритм Луна).
        System.out.println("Карта валидна: " + binCheckerEngine.cardNumberValidityNew(num.toString()));

        StringBuffer strBuffer = new StringBuffer("Карта принадлежит платежной системе ");
        StringBuilder strBuilder = new StringBuilder("Номер счета клиента: ");
        for (int i = 0; i < cardnumberLength-1; i++) {
            // перечитаем все цифры номера в цикле
            // создадим 2 переменные которым присвоим результаты возврата вычислений из метода в i и i + 1 позициях. Внимание мы возвращаем код цифры - типа char !!!
            int a = binCheckerEngine.positionValue(num, i);
            int aPlusOne = binCheckerEngine.positionValue(num, i+1);
            // А теперь сконвертируем char в int чтобы использовать с операторами условий
            int convertToNum = Character.getNumericValue(a);
            int convertToNumPlusOne = Character.getNumericValue(aPlusOne);
            // цепочка условий получающая цифру в каждой позиции и определяющая направление ветвления
            if (i == 0 && convertToNum == 2) {
                strBuffer.append(" МИР. ");
            }
            if (i == 0 && convertToNum == 3 && (convertToNumPlusOne == 4 || convertToNumPlusOne == 7)) {
                strBuffer.append(" American Express. ");
            }
            if (i == 0 && convertToNum == 3 && (convertToNumPlusOne == 1 || convertToNumPlusOne == 5)) {
                strBuffer.append(" JCB® International. ");
            }
            if (i == 0 && convertToNum == 4) {
                strBuffer.append(" VISA. ");
            }
            // Mastercard & Maestro
            if (i == 0 && convertToNum == 5 && (convertToNumPlusOne == 1 || convertToNumPlusOne == 2 || convertToNumPlusOne == 3 || convertToNumPlusOne == 4 || convertToNumPlusOne == 5)) {
                strBuffer.append(" Mastercard. ");
            }
            if (i == 0 && convertToNum == 5 && (convertToNumPlusOne == 0 || convertToNumPlusOne == 6 || convertToNumPlusOne == 7 || convertToNumPlusOne == 8)) {
                strBuffer.append(" Maestro. ");
            }
            if (i == 0 && convertToNum == 6 && (convertToNumPlusOne == 3 || convertToNumPlusOne == 7)) {
                strBuffer.append(" Maestro. ");
            }
            // найдем номер счета клиента
            if (i >= 6 && i <= 14) {
                // соберем строку с номером счета используя StringBuilder
                strBuilder.append(binCheckerEngine.positionValue(num, i));
            }
        }
        // распечатаем всю собранную строку идентификации Платежной Системы
        System.out.println(strBuffer);
        // распечатаем всю собранную строку идентификации номера счета клиента
        System.out.println(strBuilder);
        in.close();
    }
}
