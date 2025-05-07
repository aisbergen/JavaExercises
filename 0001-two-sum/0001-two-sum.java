class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> lastSeenSoFar = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            int b = nums[i];
            int a = target - b;
            if (lastSeenSoFar.containsKey(a)) {
                // Found pair of (a, b), so that a + b = target
                // Number a last seen at index lastSeenSoFar.get(a)
                // and number b is last seen at index i.
                return new int[]{lastSeenSoFar.get(a), i};
            }
            // Save that number b (nums[i]) last seen at index i.
            lastSeenSoFar.put(b, i);
        }
        return new int[]{};
    }
}