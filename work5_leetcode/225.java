import java.util.LinkedList;
import java.util.Queue;
/**
 * 用两个队列模拟一个堆栈：
     队列a和b
（1）取栈顶元素： 返回有元素的队列的首元素
（2）判栈空：若队列a和b均为空则栈空
（3）入栈：a队列当前有元素，b为空（倒过来也一样）则将需要入栈的元素先放b中，然后将a中的元素依次出列并入列倒b中。（保证有一个队列是空的）
（4）出栈：将有元素的队列出列即可。
    比如先将1插入队a中 ，现在要将2入栈，则将2插入b总然后将a中的1出列入到b中，b中的元素变为 2 ，1
    a为空，现在要压入3 则将3插入a中 ，依次将b中的2 ，1 出列并加入倒a中 ，a中的元素变为 3，2，1 b为空
    算法保证在任何时候都有一队列为空

*/
class MyStack {
    Queue<Integer> queue1=new LinkedList<Integer>();
    Queue<Integer> queue2=new LinkedList<Integer>();
    // Push element x onto stack.
    public void push(int x) {
        if(queue1.isEmpty()){
            queue1.offer(x);
            while(!queue2.isEmpty()){
                int tmp=queue2.poll();
               // queue2.poll();
                queue1.offer(tmp);
            }
        }else{
            queue2.offer(x);
            while(!queue1.isEmpty()){
                int tmp=queue1.poll();
               // queue2.poll();
                queue2.offer(tmp);
            }
        }
        
    }

    // Removes the element on top of the stack.
    public void pop() {
        if(!queue1.isEmpty())
        queue1.poll();
        if(!queue2.isEmpty())
        queue2.poll();
        
    }

    // Get the top element.
    public int top() {
        int x=0;
        if(!queue1.isEmpty()){
            //x=queue1.poll();
           x= queue1.peek();  
        }
        
        if(!queue2.isEmpty())
        //x=queue1.poll();
         x= queue2.peek();
         return x;
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return queue1.isEmpty() && queue2.isEmpty();
        
    }
}