import java.util.*;
// JACKIE WENG
// I FORGOT TO COMMIT THIS ONE TOO
public class PracticeProblem {
// using memoization
    public static int fib(int number) {
        HashMap<Integer, Integer> val = new HashMap<>();
        return fibHelper(number, val);
    }
// using memoization again
    public static int fibHelper(int number, HashMap<Integer, Integer> val) {
        if (number <= 0) {
            return 0;
        } else if (number == 1) {
            return 1;
        }
        if (val.get(number) != null) {
            return val.get(number);
        }
        val.put(number, fibHelper(number - 1, val) + fibHelper(number - 2, val));
        return val.get(number);
    }
// climbing stairs method
    public static int minCostClimbingStairs(int[] cost) {
        HashMap<Integer, Integer> leastCostIndex = new HashMap<>();
        if (cost.length < 1) {
            return 0;
        } else if (cost.length == 1) {
            return cost[0];
        }
        return minCostHelper(-1, cost, cost.length, leastCostIndex);
    }

    public static int minCostHelper(int currentIndex, int[] cost, int costLength, HashMap<Integer, Integer> leastCostIndex) {
        if (currentIndex >= costLength) {
            return 0;
        }
        if (leastCostIndex.get(currentIndex) != null) {
            return leastCostIndex.get(currentIndex);
        } else {
            int step = minCostHelper(currentIndex + 1, cost, costLength, leastCostIndex);
            int twoStep = minCostHelper(currentIndex + 2, cost, costLength, leastCostIndex);
            if (currentIndex >= 0) {
                int min = Math.min(step, twoStep) + cost[currentIndex];
                leastCostIndex.put(currentIndex, min);
                return min;
            }
            int min = Math.min(step, twoStep);
            leastCostIndex.put(currentIndex, min);
            return min;
        }
    }
}


// DONE