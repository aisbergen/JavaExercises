public class Solution {
    public int FindLengthOfLCIS(int[] nums) {
        int current_r=0;
        int best_r = 0;
        int count;
        for(int i=0; i<nums.Length; i++){
            if(i==0 || nums[i-1]>=nums[i]){
                current_r = 1;
            }
            else{
            current_r++;}
            best_r = Math.Max(best_r,current_r);
        }
        return best_r;
    }
}