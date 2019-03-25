class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums2);
        Set<Integer> set1 = toSet(nums1);
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums2.length; i++) {
            if (set1.contains(nums2[i])) {
                if (list.isEmpty()) {
                    list.add(nums2[i]);
                } else if (list.get(list.size() - 1) != nums2[i]) {
                    list.add(nums2[i]);
                }
            }
        }
        
        int[] arr = new int[list.size()];
        for (int i = 0, listSize = list.size(); i < listSize; i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }

    private Set<Integer> toSet(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        return set;
    }
}
