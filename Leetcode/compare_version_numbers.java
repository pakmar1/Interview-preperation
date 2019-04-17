class Solution {
    public int compareVersion(String version1, String version2) {
        int len1 = version1.length();
        int len2 = version2.length();
        int result = 0;
        
        if(len1 == 0 && len2 == 0) {
            return 0;
        }
        else if(len1 == 0) {
            return -1;
        }
        else if(len2 == 0){
            return 1;
        }
        
        String[] v1Split = version1.split("\\.");
        String[] v2Split = version2.split("\\.");
        
        int lengthToUse = v1Split.length > v2Split.length ? v1Split.length : v2Split.length;
            
        for(int i = 0; i < lengthToUse; i++) {
            int v1 = 0;
            int v2 = 0;
            if(i < v1Split.length) {
                v1 = Integer.parseInt(v1Split[i]);
            }
            
            if(i < v2Split.length) {
                v2 = Integer.parseInt(v2Split[i]);
            }
            
            if(v1 > v2) return 1;
            if(v2 > v1) return -1;
        }
        return result;
    }
}
