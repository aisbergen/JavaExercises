class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
  
        // First, count for each number its frequency.
        for (int x : nums) {
            freq.put(x, freq.getOrDefault(x, 0) + 1);
        }
 
        //                                                 (key  ,   value)
        // Convert the Map<Number, Frequency> to List<Pair<Number, Frequency>>.
        List<Pair<Integer, Integer>> sorted_freq_pairs = new ArrayList<>();
        for (var entry : freq.entrySet()) {
            Pair<Integer, Integer> freq_pair = new Pair<>(entry.getKey(), entry.getValue());
            sorted_freq_pairs.add(freq_pair);
        }
 
        // T: O(n log n)
        // S: O(n) 
 
        //                (key  ,   value)
        // Sort List<Pair<Number, Frequency>> by the Frequency (i.e. value)
        // in descending order.
        Collections.sort(sorted_freq_pairs, (fp1, fp2) -> {
            // < 0
            // == 0
            // > 0
            return fp2.getValue() - fp1.getValue();
        });
 
        // Create array to save k most frequent numbers.
        int[] results = new int[k];
        for (int i = 0; i < k; i++) {
            results[i] = sorted_freq_pairs.get(i).getKey();
        }
        return results;
    }
}