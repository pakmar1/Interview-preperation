class Solution {
    public int wordsTyping(String[] sentence, int rows, int cols) {
        int len = sentence.length;
        int sum = 0;
        for (String str : sentence) {
            sum += str.length();
        }
        int index = 0;
        int result = 0;
        for (int i = 0; i < rows; ++i) {
            int colRemain = cols;
            while (colRemain > 0) {
                if (colRemain >= sentence[index].length()) {
                    colRemain -= sentence[index].length();
                    if (colRemain > 0) {
                        colRemain--;
                    }
                    if (++index >= len) {
                        result += 1 + colRemain / (sum + len);
                        colRemain %= (sum + len);
                        index = 0;
                    }
                } else {
                    break;
                }
            }
        }
        return result;
    }
}
