import java.util.ArrayList;

public class ManastersAlgo {
    public static void main(String[] args) {
        ManastersAlgo manastersAlgo = new ManastersAlgo();
        String longestPalindrome = manastersAlgo.getLongestPalindrome("abacabacabaded");
        System.out.println(longestPalindrome);
    }

    public static String getLongestPalindrome(String input){
        String longestPalindrome = "";
        ArrayList<Integer> palindromeLengths = new ArrayList<>(input.length());
        palindromeLengths.add(0,1);
        palindromeLengths.add(1,1);
        int palindromeLen;
        int maxPalLenIndex = 0;
        for(int position=1;position<input.length();)
        {
            palindromeLen = calculatePalindrome(position, input, palindromeLengths.get(position));
            palindromeLengths.remove(position);
            palindromeLengths.add(position, palindromeLen);
            if(palindromeLen > palindromeLengths.get(maxPalLenIndex)) {
                maxPalLenIndex = position;
            }
            position = updateAndGetNextPosition(position, input, palindromeLengths);
        }
        int maxPalLen = palindromeLengths.get(maxPalLenIndex);
        int start = maxPalLenIndex - (maxPalLen - 1)/2;
        longestPalindrome = input.substring(start, maxPalLenIndex + (maxPalLen - 1)/2 + 1);
        return longestPalindrome;
    }

    private static int updateAndGetNextPosition(int position, String input, ArrayList<Integer> palindromeLengths) {
        int nextPos = position + palindromeLengths.get(position)/2 + 1;
        int maxLeftIndex = position - (palindromeLengths.get(position)-1)/2;
        for(int curIndex=position-1; curIndex>=0 && curIndex>=maxLeftIndex; curIndex--)
        {
            int rightIndex = position + (position - curIndex);
            int maxLeftIndexOfCurIndex = curIndex - (palindromeLengths.get(curIndex)-1)/2;
            //Touches the boundary
            if(maxLeftIndexOfCurIndex == maxLeftIndex) {
                palindromeLengths.add(rightIndex, palindromeLengths.get(curIndex));
                return rightIndex;
            } //Confined in the boundaries
            else if(maxLeftIndexOfCurIndex > maxLeftIndex) {
                palindromeLengths.add(rightIndex, palindromeLengths.get(curIndex));
            } else {
                int palLen = (curIndex - maxLeftIndex)*2 + 1;
                palindromeLengths.add(rightIndex, palLen);
            }
        }
        palindromeLengths.add(nextPos, 1);
        return nextPos;
    }

    public static int calculatePalindrome(int index, String input, int currentIndexPalLen)
    {
        int leftIndex = index - currentIndexPalLen/2 - 1;
        int rightIndex = index + currentIndexPalLen/2 + 1;
        while(leftIndex>=0 && rightIndex<input.length())
        {
            if(input.charAt(leftIndex) != input.charAt(rightIndex)) {
                break;
            } else {
                --leftIndex;
                ++rightIndex;
            }
        }
        leftIndex++;
        rightIndex--;
        return rightIndex-leftIndex+1;
    }

}