class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int high=0; //max_capacity
        int low = Integer.MIN_VALUE; //min_capacity
        for(int i = 0; i<weights.length; i++){
            high = high + weights[i];
            low = Math.max(weights[i], low);
        }
        int sum1 = low;

        while(low<high){
            int mid =low+(high-low)/2;
            int totalDays = helper(mid, weights);

            if(totalDays <= days){
                high = mid;
            }
            else{
                low = mid+1;
            }
        }
        return low;
        }


        public int helper(int currCap, int[] weights){
        int d=1;
        int temp=0; //current load
        for(int weight:weights){
            if(temp+weight>currCap){
                temp=0;
                d++;
            }
            temp+=weight;
        }
        return d;
    }
        

}