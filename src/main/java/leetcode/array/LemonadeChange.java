package leetcode.array;

public class LemonadeChange {
    public boolean lemonadeChange(int[] bills) {
        int five = 0;
        int ten = 0;
        for (int i : bills) {
            if (i == 5) {
                five++;
            }
            else if (i == 10) {
                if (five == 0) {
                    return false;
                }
                five--;
                ten++;
            }
            else {
                if (five > 0 && ten > 0) {
                    five--;
                    ten--;
                }else if (five >= 3){
                    five -= 3;
                }
                else {
                    return false;
                }
            }
        }
        return true;
    }
}
