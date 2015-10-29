public class Solution {
    public int addDigits(int num) {
        while(num>=10){
            String s=String.valueOf(num);
            char[] c=s.toCharArray();
            num=0;
            for(int i=0;i<c.length;i++){
                num+=c[i]-'0';
            }
        }
        return num;
    }
}