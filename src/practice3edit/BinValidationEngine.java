package practice3edit;

import java.math.BigInteger;

public class BinValidationEngine {
    BinValidationEngine() {
        System.out.println("Построен экземпляр класса проверки!");
    }

    public char positionValue(BigInteger num, int i) {
        char positionValue = num.toString().charAt(i);
        return positionValue;
    }

    public boolean cardNumberValidityNew(String cardNum) {
        int cardlength = cardNum.length();
        int evenSum = 0, oddSum = 0, sum;
        for (int i = cardlength - 1; i >= 0; i--) {
            //System.out.println(cardNum.charAt(i));
            int digit = Character.getNumericValue(cardNum.charAt(i));
            if (i % 2 == 0) {
                int multiplyByTwo = digit * 2;
                if (multiplyByTwo > 9) {
                    /* Добавьте две цифры для обработки случаев, когда после удвоения получаются две цифры */
                    String multi = String.valueOf(multiplyByTwo);
                    multiplyByTwo = Character.getNumericValue(multi.charAt(0)) + Character.getNumericValue(multi.charAt(1));
                }
                evenSum += multiplyByTwo;
            } else {
                oddSum += digit;
            }
        }
        sum = evenSum + oddSum;
        if (sum % 10 == 0) {
            System.out.println("....card validation");
            return true;
        } else {
            System.out.println("System failure: invalid card");
            return false;
        }
    }
}