class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> stat = new HashMap<>();
        for (int i: nums) {
            stat.putIfAbsent(i, 0);
            stat.put(i, stat.get(i) + 1);
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            int max = 0;
            Integer maxKey = 0;
            for (Integer key : stat.keySet()) {
                if (max < stat.get(key)) {
                    max = stat.get(key);
                    maxKey = key;
                }
            }
            stat.remove(maxKey);
            res[i] = maxKey;
        }
        return res;
    }
}
