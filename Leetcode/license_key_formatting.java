class Solution {
    public String licenseKeyFormatting(String S, int K) {
        List<Character> characters = new ArrayList<>();
        
        for(char c : S.toCharArray()) {
            if(c != '-') {
                characters.add(c);
            }
        }
       
        int remainder = characters.size() % K;
        StringBuilder sb = new StringBuilder();
        
        if(remainder != 0) {
            for(int i = 0 ; i<remainder; i++) {
                sb.append(Character.toUpperCase(characters.get(i)));
            }
        }
        
        for(int i = remainder; i<characters.size(); i++) {
            if((i-remainder)%K == 0 && i != 0) {
                sb.append("-");
            }
            sb.append(Character.toUpperCase(characters.get(i)));
        }

        return sb.toString();
    }
}
