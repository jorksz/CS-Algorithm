package leetcode.array;

public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int i = 0;
        int n = gas.length;
        while (i < n) {
            int gasSum = 0;
            int costSum = 0;
            int count = 0;
            while (count < n) {
                int j = (i + count) % n;
                gasSum += gas[j];
                costSum += cost[j];
                if (gasSum < costSum) {
                    break;
                }
                count++;
            }
            if (gasSum >= costSum) {
                return i;
            }
            else {
                i = i + count + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        GasStation gasStation = new GasStation();
        int[] gas = {1,2,3,4,5};
        int[] cost = {3,4,5,1,2};
        System.out.println(gasStation.canCompleteCircuit(gas, cost));
    }
}
