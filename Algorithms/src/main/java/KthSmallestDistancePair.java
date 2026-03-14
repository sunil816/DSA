import java.util.Arrays;

/*
The distance of a pair of integers a and b is defined as the absolute difference between a and b.

Given an integer array nums and an integer k, return the kth smallest distance among all the pairs nums[i] and nums[j] where 0 <= i < j < nums.length.



Example 1:

Input: nums = [1,3,1], k = 1
Output: 0
Explanation: Here are all the pairs:
(1,3) -> 2
(1,1) -> 0
(3,1) -> 2
Then the 1st smallest distance pair is (1,1), and its distance is 0.
Example 2:

Input: nums = [1,1,1], k = 2
Output: 0
Example 3:

Input: nums = [1,6,1], k = 3
Output: 5
 */
class MaxDifference
{
   public  int noOfElementsLessThanOrEqualToMidElement;
   public int maxDiff;
}
public class KthSmallestDistancePair {
    public static void main(String[] args) {
        //int minTotalEnergy = new KthSmallestDistancePair().GetKthSmallestPair(new int[]{10,60,10}, 3);
        int minTotalEnergy = new KthSmallestDistancePair().GetKthSmallestPair(new int[]{9,10,7,10,6,1,5,4,9,8}, 18);
        System.out.println(minTotalEnergy);
    }
    public int GetKthSmallestPair(int [] nums, int k)
    {
        int res = 0;
        Arrays.sort(nums);
        int minElement = nums[0];
        int maxElement = nums[nums.length - 1];
        int midElement;
        while (minElement <= maxElement)
        {
            midElement = (minElement + maxElement) / 2;
            MaxDifference maxDifference = ElementsLessThanOrEqualToMidElement(nums, midElement);
            if (k <= maxDifference.noOfElementsLessThanOrEqualToMidElement)
            {
                if(midElement == 0)
                {
                    return maxDifference.maxDiff;
                }
                MaxDifference maxDifferenceLeftElement = ElementsLessThanOrEqualToMidElement(nums, midElement-1);
                if(k > maxDifferenceLeftElement.noOfElementsLessThanOrEqualToMidElement)
                {
                    return maxDifference.maxDiff;
                }
                maxElement = midElement - 1;
            }
            else
            {
                minElement = midElement + 1;
            }
        }
        return res;
    }

    MaxDifference ElementsLessThanOrEqualToMidElement(int [] nums, int midElement)
    {
        MaxDifference maxDifference = new MaxDifference();
        int rightIndex = 0;
        int noOfElementsLessThanOrEqualTo = 0;
        int maxDiff = 0;
        for(int leftIndex = 0; leftIndex < nums.length; leftIndex++)
        {
            while(rightIndex < nums.length && (nums[rightIndex] - nums[leftIndex]) <= midElement)
            {
                rightIndex++;
            }

            int curMaxDiff = nums[rightIndex-1] - nums[leftIndex];
            if(maxDiff < curMaxDiff)
            {
                maxDiff = curMaxDiff;
            }
            noOfElementsLessThanOrEqualTo = noOfElementsLessThanOrEqualTo + rightIndex - leftIndex - 1;
        }
        maxDifference.maxDiff = maxDiff;
        maxDifference.noOfElementsLessThanOrEqualToMidElement = noOfElementsLessThanOrEqualTo;
        return maxDifference;
    }
}
