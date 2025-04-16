class Solution {
    public void rotate(int[] nums, int k) {
        if(k>nums.length){
            k = k%nums.length;
        }
        int i=0;
        int j = nums.length-1;
        while (i < j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j]=temp;
            i++;
            j--;
        }

        int left = 0;
        int right = k-1;
        while (left<right){
            int temp = nums[left];
            nums[left]=nums[right];
            nums[right]=temp;
            left++;
            right--;
        }

        int start =k;
        int end = nums.length -1;
        while(start<end){
            int temp = nums[start];
            nums[start]=nums[end];
            nums[end]=temp;
            start++;
            end--;
        }
    }
}