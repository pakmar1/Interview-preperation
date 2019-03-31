class Solution {
    public int maxProduct(String[] words) {
        int len = words.length;
        int[] value = new int[len];
        for (int i = 0; i < len; i++) {
            int val = 0;
            for (int j = 0; j < words[i].length(); j++) {
                val |= (0x1 << words[i].charAt(j) - 'a');
            }
            //System.out.println(val);
            value[i] = val;
        }
        int maxProduct = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i+1; j < len; j++) {
                if ((value[i] & value[j]) == 0) {
                    maxProduct = Math.max(maxProduct, words[i].length() * words[j].length());
                }
            }
        }
        return maxProduct;
    }
}
