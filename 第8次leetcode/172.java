//n�Ľ׳˵Ľ����ĩβ��0�ĸ���
//�ֽ�����, ���ҽ��������г���һ�� (2,5)ʱ, �����������һ�� trailing zero.
//2�ĸ�����Զ����5������
//ֻ����5�ĸ����� SUM(n/5^1,  n/5^2, n/5^3...)
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