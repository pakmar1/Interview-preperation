public class Solution{
    public static void main(String []args){
       boolean a = isUnique("asda");
       System.out.println(a);
    }
    
    public static boolean isUnique(String str){
        for(int i=0;i<str.length();i++){
           for(int j=0;j<str.length();j++){
               if(i!=j && str.charAt(i)==str.charAt(j)){
                   return false;
               }
           }
       }
       return true;
    }
}