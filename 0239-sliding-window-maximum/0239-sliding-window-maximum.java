class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new ArrayDeque<>();
        int[] result = new int[nums.length - k + 1];
        for(int i=0; i<nums.length; i++){

           while (!dq.isEmpty() && nums[i] > nums[dq.peekLast()]){
                dq.pollLast(); 
            }

            dq.addLast(i); // Just add the index once every iteration
            
            if(!dq.isEmpty() && dq.peekFirst() <= i - k){
                dq.pollFirst();
            }

            if(i>=k-1){
                result[i - k + 1] = nums[dq.peekFirst()];
            }
        }
        return result;

            
    }
}