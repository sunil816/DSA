package DP;

import java.util.HashSet;

public class KEqualSum {
    /*
    [2,3,4,6,9,3,1,8] k=4
    [9], [3,6], [1,8], [2,4,3]
     */
    public static void main(String []argv)
    {
        int k=4;
        int []input = new int[]{2,3,4,6,9,3,2,9};
        int sum = 0;
        for(int i=0;i<input.length;i++)
        {
            sum = sum + input[i];
        }
        sum = sum/k;
        HashSet<Integer> usedIndex = new HashSet<>();
        boolean isValid = true;
        for(int i=0;i<k;i++) {
            isValid = isValid(sum, input, 0, usedIndex);
            if(!isValid)
                break;
        }
        System.out.println(isValid && usedIndex.size() == input.length);
    }

    public static boolean isValid(int sum, int []input, int startIndex, HashSet<Integer> usedIndex) {
        for(int i=startIndex;i<input.length;i++) {
            if (!usedIndex.contains(i)) {
                if (input[i] == sum) {
                    usedIndex.add(i);
                    return true;
                }

                if(input[i] < sum) {
                    usedIndex.add(i);
                    boolean isV = isValid(sum-input[i], input, i+1, usedIndex);
                    if(!isV)
                        usedIndex.remove(i);
                    else
                        return true;
                }
            }
        }
        return false;
    }

}
