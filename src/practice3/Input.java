package practice3;

import java.math.BigInteger;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Input {
    Input() {
    }

    void startInput() {
        // строим класс с методами проверки
        BinCheckerEngine binCheckerEngine = new BinCheckerEngine();
        //
        Scanner in = new Scanner(System.in);
        System.out.print("Введите номер банковский карты: ");
        BigInteger num = in.nextBigInteger();
        // отформатируем вывод номера карты
        StringBuffer formatCardNumber = new StringBuffer(num.toString());
        formatCardNumber.insert(4, '-');
        formatCardNumber.insert(9, '-');
        formatCardNumber.insert(14, '-');
        //System.out.println(formatCardNumber.toString());
        //System.out.printf("Вы вввели номер карты: %d \n", num);
        System.out.printf("Вы вввели номер карты: %s \n", formatCardNumber);
        int cardnumberLength = num.toString().length();
        if (cardnumberLength == 16) System.out.println("Длина номера карты " + cardnumberLength + " цифр." + " Ок!");
        if (cardnumberLength != 16) System.out.println("Вы ввели неверный номер карты");
        StringBuffer strBuffer = new StringBuffer("Карта принадлежит платежной системе ");
        StringBuilder strBuilder = new StringBuilder("Номер счета клиента: ");
        for (int i = 0; i < cardnumberLength; i++) {
            //char positionValue = num.toString().charAt(i);
            // перечитаем все цифры номера в цикле
            System.out.print(num.toString().charAt(i));
            //binCheckerEngine.positionValue(num, i);
            // цепочка условий в цикле определяющая цифру в каждой позиции
            if (i == 0 && binCheckerEngine.positionValue(num, i) == 2) {
                System.out.println("MIR");
                strBuffer.append(" МИР. ");
            }
//            if (i == 0 && binCheckerEngine.positionValue(num, i) == 3 && binCheckerEngine.positionValue(num, i+1) == 4 || binCheckerEngine.positionValue(num, i+1) == 7) {
//                strBuffer.append(" American Express. ");
//            }
//            if (i == 0 && binCheckerEngine.positionValue(num, i) == 3 && binCheckerEngine.positionValue(num, i+1) == 1 || binCheckerEngine.positionValue(num, i+1) == 5) {
//                strBuffer.append(" JCB® International. ");
//            }
//
//            if (i == 0 && binCheckerEngine.positionValue(num, i) == 4) {
//                strBuffer.append(" VISA. ");
//            }
            //
            // Mastercard & Maestro
//            if (i == 0 && binCheckerEngine.positionValue(num, i) == 5) {
//                if (i == 2 && (binCheckerEngine.positionValue(num, i) == 1 || binCheckerEngine.positionValue(num, i) == 2
//                        || binCheckerEngine.positionValue(num, i) == 3 || binCheckerEngine.positionValue(num, i) == 4
//                        || binCheckerEngine.positionValue(num, i) == 5)) {
//                    System.out.println("Mastercard");
//                    strBuffer.append(" Mastercard. ");
//                }
//                if (i == 2 && (binCheckerEngine.positionValue(num, i) == 0 || binCheckerEngine.positionValue(num, i) == 6
//                        || binCheckerEngine.positionValue(num, i) == 7 || binCheckerEngine.positionValue(num, i) == 8)) {
//                    System.out.println("Mastercard");
//                    strBuffer.append(" Mastercard Maestro. ");
//                }
//            }
//            if (i == 1 && binCheckerEngine.positionValue(num, i) == 6) {
//                if (i == 2 && (binCheckerEngine.positionValue(num, i) == 3 || binCheckerEngine.positionValue(num, i) == 7)) {
//                    System.out.println("Mastercard");
//                    strBuffer.append(" Mastercard Maestro. ");
//                }
//            }

            if (i >= 6 && i <= 14) {
                // суммируем номер счета в строку
                //System.out.print("Номер счета клиента: " + binCheckerEngine.positionValue(num, i));
                strBuilder.append(binCheckerEngine.positionValue(num, i));
            }
        }
        // распечатаем всю собранную строку идентификации банка
        System.out.println(strBuffer);
        // распечатаем всю собранную строку идентификации номера счета клиента
        System.out.println(strBuilder);
            //System.out.printf("Длина: %d \n", num.toString().length());
            //System.out.println("Емкость: " + strBuffer.capacity());
            // определяем шаблон поиска Pattern — само регулярное выражение
            // и затем Matcher — ищем совпадение с шаблоном описываемым регулярным выражением
            //Pattern p = Pattern.compile("d{16}"); // что ищем
            //Matcher m = p.matcher((CharSequence) num); // где ищем
            //System.out.println("Pattern:" + m.toMatchResult());

        // 5521400012349311
        // 4276400070268546
        // 2200260107630810
            // приведем BigInteger к строке
            // The way I understand it is that you're doing the following transformations:
            //  String  -----------------> byte[] ------------------> BigInteger
            //          String.getBytes()         BigInteger(byte[])
            //And you want the reverse:
            //  BigInteger ------------------------> byte[] ------------------> String
            //             BigInteger.toByteArray()          String(byte[])
        //byte[] cardNumberByte = num.toByteArray();
            //String cardNumberStr = new String(cardNumberByte);
            //System.out.println(cardNumberStr);
            //System.out.printf("Your card String number ✖: %s \n", cardNumberStr);
            // выбираем первый символ
            //System.out.println(cardNumberByte[4]);
            // выбирем второй символ

            // Форматируем вывод
            // %[аргумент_индекс][флаги][ширина][.точность]спецификатор типа

            //String str = String.format("%1$+4x", num);
            //System.out.print(str);
            in.close();
    }
}
