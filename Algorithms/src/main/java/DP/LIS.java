package DP;

public class LIS {
//    ArrayList<Integer> increasingSubStringLen = new ArrayList<>();
    static int [] increasingSubStringLen;
    static int[] startIndices;
    static int[] nextIndex;
    public static void main(String[] args) {
        String input = "empathy";
        increasingSubStringLen = new int[input.length()];
        startIndices = new int[input.length()];
        nextIndex = new int[input.length()];

        System.out.println(longestIncreasingSubsequence(input,0));
        for(int i=0;i<input.length();)
        {
            int nextI;
            if(startIndices[i] == i)
            {
                System.out.println(input.charAt(i));
                nextI = nextIndex[i];
            } else {
                nextI = startIndices[i];
            }
            if(nextI == i)
                break;
            i = nextI;
        }
    }
    //empathy
    //empty
    public static int longestIncreasingSubsequence(String input, int startIndex)
    {
        if(increasingSubStringLen[startIndex] != 0)
        {
            return increasingSubStringLen[startIndex];
        }

        if(startIndex == input.length()-1)
        {
            startIndices[startIndex] = startIndex;
            nextIndex[startIndex] = startIndex;
            increasingSubStringLen[startIndex] = 1;
            return 1;//String.valueOf(input.charAt(startIndex));
        }
        int maxLenWithoutStartIndex = longestIncreasingSubsequence(input, startIndex + 1);
        startIndices[startIndex] = startIndices[startIndex+1];
        nextIndex[startIndex] = nextIndex[startIndex+1];
        int maxLength = maxLenWithoutStartIndex;
        for(int i=startIndex+1;i<input.length();i++)
        {
            if(input.charAt(startIndex) < input.charAt(i)) {
                int maxLenWithStartIndex = 1 + longestIncreasingSubsequence(input, i);
                if (maxLength <= maxLenWithStartIndex) {
                    maxLength = maxLenWithStartIndex;
                    startIndices[startIndex] = startIndex;
                    nextIndex[startIndex] = i;
                }
            }
        }
        increasingSubStringLen[startIndex] = maxLength;
        return increasingSubStringLen[startIndex];
    }
}
