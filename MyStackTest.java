public class MyStackTest {
    public static void main(String args[])
    {
    MyStack stack = new MyStack();
    System.out.println("is empty true:"+stack.isEmpty());
    stack.push(new Square(1,2,3));
    stack.push(new Square(2,3,1));
    stack.push(new Square(3,1,2));
    System.out.println("is empty false:"+stack.isEmpty());
    System.out.println("size 3:"+stack.size());

    System.out.println("front (2,1,E):"+stack.top());
    System.out.println("pop (same):"+stack.pop());
    System.out.println("front (3,2,#):"+stack.top());
    System.out.println("size 2"+stack.size());
    stack.clear();
    System.out.println("size 0:"+stack.size());
    }
}
