public class Solution {
    //2�Ĵ��ݵ�����������ֻ�е�һλ��1
    public boolean isPowerOfTwo(int n) {
        return n>0 && (n&(n-1))==0;
    }
}