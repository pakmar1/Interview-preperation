class Solution {
    public List<Boolean> prefixesDivBy5(int[] A) {
        List<Boolean> list = new ArrayList<>();
        for (int i = 1; i < A.length; i++) {
            A[i] = (2 * A[i - 1] + A[i]) % 5;
        }
        for (int i = 0; i < A.length; i++) {
            if (A[i] % 5 == 0) {
                list.add(true);
            }
            else {
                list.add(false);
            }
        }
        return list;
    }
}
