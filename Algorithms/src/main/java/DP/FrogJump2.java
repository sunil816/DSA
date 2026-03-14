package DP;

import java.util.Arrays;

public class FrogJump2 {
    public int N;
    public int K;
    public int[] arr;
    public int[] minVal;

    FrogJump2(int N, int K, int []arr)
    {
        this.N = N;
        this.K = K;
        this.arr = arr;
        minVal = new int[arr.length];
        Arrays.fill(minVal, -1);
    }

    int getMinTotalCost(int startIndex)
    {
        if(startIndex == (N - 1))
        {
            return 0;
        }

        if(minVal[startIndex] != -1)
            return minVal[startIndex];

        int minValueForStartIndex = Integer.MAX_VALUE;
        for (int jumpInterval = 1; jumpInterval <= K && (startIndex + jumpInterval) < N; jumpInterval++) {
            int jumpIndex = startIndex + jumpInterval;
            int curJumpIntMinVal = Math.abs(arr[startIndex] - arr[jumpIndex]) + getMinTotalCost(jumpIndex);
            minValueForStartIndex = Math.min(curJumpIntMinVal, minValueForStartIndex);
        }
        minVal[startIndex] = minValueForStartIndex;

        return minValueForStartIndex;
    }

    public static void main(String[] args) {
        FrogJump2 frogJump2 = new FrogJump2(10, 4, new int[]{40,10,20,70,80,10,20,70,80,60});
        int minVal = frogJump2.getMinTotalCost(0);
        System.out.println(minVal);
    }
}
