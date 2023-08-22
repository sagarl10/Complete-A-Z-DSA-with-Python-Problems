package JAVA.STACK;

import java.util.LinkedList;
import java.util.Queue;

public class ImpleStckusing1queue {
   Queue<Integer> q;
   public ImpleStckusing1queue(){
      this.q=new LinkedList<>();
   }
   public void push(int item){
      q.add(item);
      for (int i = 0; i < q.size()-1; i++) {
        q.add(q.remove());
      }

   }
   public int pop(){
    return q.remove();
   }
   public int peek(){
    return q.peek();
   }

}
