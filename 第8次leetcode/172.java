//n的阶乘的结果中末尾的0的个数
//分解因子, 当且仅当因子中出现一对 (2,5)时, 最后结果会增加一个 trailing zero.
//2的个数永远多于5个个数
//只需求5的个数， SUM(n/5^1,  n/5^2, n/5^3...)
public class Solution {
    public int trailingZeroes(int n) {
        int count = 0;
        while(n/5!=0){
            n=n/5;
            count+=n;
        }
        return count;
    }
}