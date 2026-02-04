public class Solution {
    public int FindMin(int[] nums) {
        if(nums[0]<nums[nums.Length - 1]){
            return nums[0];
        }
        int l=0;
        int r=nums.Length-1;
        while(l<r){
            int m = (l+r) /2;      
            if(nums[m]>=nums[0]){
                l=m+1;
            }
            else{
                r=m;
            }    
    }return nums[l];
            
    }
}