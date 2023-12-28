public class Main {
    public static void main(String[] args) {
        Stack stack = new Stack(5);
        stack.push(22);
        stack.push(43);
        stack.push(44);
        stack.push(22);
        stack.push(43);
        stack.push(44);
        System.out.println(stack.peek());
        System.out.println("===========");

        stack.pop();
        System.out.println(stack.peek());
        System.out.println("===========");

        stack.pop();
        System.out.println(stack.peek());
        System.out.println("===========");

        stack.pop();
        System.out.println(stack.peek());
        System.out.println("===========");

        if(stack.isEmpty()) System.out.println("Stack is empty");
        else System.out.println("Stack is not empty");

    }
}
