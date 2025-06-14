class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 1;
        int right = numbers.length;

        while(left<right){
            int current_sum = numbers[left-1]+numbers[right-1];
            if(current_sum == target){
                return new int[]{left,right};
            }
            else if(current_sum<target){
                left++;
            }
            else if(current_sum>target){
                right--;
            }

        }
        
        return new int[]{left,right};
    }
}