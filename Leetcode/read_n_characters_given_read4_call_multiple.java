/**
 * The read4 API is defined in the parent class Reader4.
 *     int read4(char[] buf); 
 */
public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return    The number of actual characters read
     */
    Queue<Character> queue=new LinkedList<>();

    public int read(char[] buf, int n) {
        
        int anchor=0;
		//first read characters from queue
        while(!queue.isEmpty()&&n>0){
            buf[anchor++]=queue.poll();
            n--;
        }
        boolean eof=false;
        char[] temp=new char[4];
        while(!eof&&n>0){
            int cnt=read4(temp);
            if(cnt<4) eof=true;
            for(int i=0;i<Math.min(cnt,n);i++){
                buf[anchor++]=temp[i];
            }
			//offer unused characters to queue
            if(n<cnt){
                for(int i=n;i<cnt;i++){
                    queue.offer(temp[i]);
                }
            }
            n-=cnt;
        }
        return anchor;
    }
}
