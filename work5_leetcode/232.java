
/**
 * 用两个栈模拟一个队列：
     栈a和b
（1）取队列头元素： 返回有元素的栈的首元素
（2）判队列空：若栈a和b均为空则队列空
（3）入队列：栈a当前有元素，b为空（倒过来也一样）则将a中的元素依次出栈并入栈到b中，
     然后将需要入队列的元素也放到b中，最后，将b中的元素依次出栈放到a中。
    （b始终为空）
（4）出队列：将有元素的栈出栈即可。
    比如先将1插入栈a中，现在要将2入队列，则将a中的1出栈入到b中，然后2插入b中，b中的元素变为2，1，
    将b中的元素依次出栈到a中，a变为1,2
    现在要将3 入队列，则将a中的1，2出栈入到b中 ，然后3插入b中，b中的元素变为3，2，1，
    将b中的元素依次出栈到a中，a变为1,2，3。

*/


class MyQueue {
    Stack<Integer> s1=new Stack<Integer>();
    Stack<Integer> s2=new Stack<Integer>();
    // Push element x to the back of queue.
    public void push(int x) {
        if(s1.empty()){
            //s1.push(x);
            while(!s2.empty()) s1.push(s2.pop());
            s1.push(x);
            while(!s1.empty())
            s2.push(s1.pop());
        }
         if(s2.empty()){
            //s1.push(x);
            while(!s1.empty()) s2.push(s1.pop());
            s2.push(x);
            while(!s2.empty())
            s1.push(s2.pop());
        }
        
    }

    // Removes the element from in front of queue.
    public void pop() {
        if(!s1.empty())
          s1.pop();
          if(!s2.empty())
          s2.pop();
        
    }

    // Get the front element.
    public int peek() {
        int x=0;
        if(!s1.empty())
          x=s1.peek();
         if(!s2.empty())
          x=s2.peek();
          return x;
        
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return s1.empty() && s2.empty();
    }
}