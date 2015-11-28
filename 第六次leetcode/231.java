public class Solution {
    //2的次幂的数，二进制只有第一位是1
    public boolean isPowerOfTwo(int n) {
        return n>0 && (n&(n-1))==0;
    }
}