public class Main {
    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(5);
        stack.push(10);
        stack.print();
        stack.pop();
        stack.print();
        System.out.println(stack.peek());
        System.out.println(stack.isEmpty());
        stack.pop();
        stack.print();
        System.out.println(stack.isEmpty());
    }
}
