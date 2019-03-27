class Solution {
    
   public List<List<String>> wordSquares(String[] words) {
        List<List<String>> res = new ArrayList<>();
        if (words == null || words.length == 0) return res;
        int n = words[0].length();
        Trie tr = new Trie(words);
        List<String> path = new ArrayList<>();
        for (String word: words) {
            path.add(word);
            dfsHelper(path, n, tr, res);
            path.remove(path.size() - 1);
        }
        return res;
    }
    
    class TrieNode {
        List<String> startWith;
        TrieNode[] children;

        TrieNode() {
            startWith = new ArrayList<>();
            children = new TrieNode[26];
        }
    }

    class Trie {
        TrieNode root;

        Trie(String[] words) {
            root = new TrieNode();
            for (String w : words) {
                TrieNode cur = root;
                for (char ch : w.toCharArray()) {
                    int idx = ch - 'a';
                    if (cur.children[idx] == null)
                        cur.children[idx] = new TrieNode();
                    cur.children[idx].startWith.add(w);
                    cur = cur.children[idx];
                }
            }
        }

        List<String> findByPrefix(String prefix) {
            List<String> ans = new ArrayList<>();
            TrieNode cur = root;
            for (char ch : prefix.toCharArray()) {
                int idx = ch - 'a';
                if (cur.children[idx] == null)
                    return ans;

                cur = cur.children[idx];
            }
            ans.addAll(cur.startWith);
            return ans;
        }
    }
    
    private void dfsHelper(List<String> path, 
                           int n,
                           Trie tr,
                           List<List<String>> res) {
        if (path.size() == n) {
            res.add(new ArrayList<>(path));
            return;
        }
        int row = path.size();
        StringBuilder prefix = new StringBuilder();
        for (String word: path) {
            prefix.append(word.charAt(row));
        }
        List<String> startWithPrefix = tr.findByPrefix(prefix.toString());
        for (String word: startWithPrefix) {
            path.add(word);
            dfsHelper(path, n, tr, res);
            path.remove(path.size() - 1);
        }
    }
}
