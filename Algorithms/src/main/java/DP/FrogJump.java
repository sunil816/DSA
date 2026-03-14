package DP;

import java.util.ArrayList;

public class FrogJump {
    public static void main(String[] args) {
        int minTotalEnergy = frogJump(4, new int[]{10,20,30,10});
        System.out.println(minTotalEnergy);
    }
    public static int frogJump(int n, int heights[]) {
        int []minTotalEnergy = new int[n];
        int energyWithOneStep, energyWith2Steps;
        ArrayList<Integer> nums = new ArrayList<>();
        int[] maxValAtIndex = new int[nums.size()];
        for(int curIndex = n-2; curIndex >= 0; curIndex--)
        {
            energyWithOneStep = minTotalEnergy[curIndex + 1] + Math.abs(heights[curIndex] - heights[curIndex + 1]);
            if(curIndex + 2 < n)
            {
                energyWith2Steps = Math.abs(heights[curIndex] - heights[curIndex + 2]) + minTotalEnergy[curIndex + 2];
                minTotalEnergy[curIndex] = Math.min(energyWith2Steps, energyWithOneStep);
            } else {
                minTotalEnergy[curIndex] = energyWithOneStep;
            }
        }
        return minTotalEnergy[0];
    }
}
