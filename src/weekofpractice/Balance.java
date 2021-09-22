package weekofpractice;

public class Balance {
    int weightL;
    int weightR;
    String balance;

    void addRight(int n) {
        weightR = weightR + n;
    }
    void addLeft(int n) {
        weightL = weightL + n;
    }
    String getSituation() {
        if (weightL == weightR) {
            balance = "=";
        } else if (weightR > weightL) {
            balance = "R";
        } else balance = "L";

        return balance;
    }
}
