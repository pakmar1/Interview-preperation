class Solution {
    public boolean validUtf8(int[] data) {
        int count = 0;
        for(int value : data) {
            if(count == 0) {
                if(value >> 5 == 0b110)
                    count = 1; //more 1 byte
                else if(value >> 4 == 0b1110)
                    count = 2; //more 2 bytes
                else if(value >> 3 == 0b11110)
                    count = 3; //more 3 bytes
                else if(value >> 7 != 0)
                    return false; //means just 1 byte data
            }
            else {
                if(value >> 6 != 0b10) //all bytes should start with 10
                    return false;
                count--;
            }
        }
        
        return count == 0;
    }
}
