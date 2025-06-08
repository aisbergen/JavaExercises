class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int maxLength=0;
        for (int num : nums) {
            set.add(num); // fill the set first
        }
        
        int currentStreak = 1;
        for(int number : set){
            if (!set.contains(number - 1)){ //Is number the start of a new consecutive sequence?
                int currentNum = number;
                int streakStart = number;

                while(set.contains(currentNum + 1)){
                    currentNum++; //move to next number and repeat
                    
                }
                maxLength = Math.max(maxLength, currentNum - streakStart + 1);
            }
        }
        return maxLength; 
    }
}