public class Main {
    public static void main(String[] args) {
        TwoStack ts = new TwoStack(5);
        ts.push1(1);
        ts.push2(5);
        ts.print();
        ts.push1(2);
        ts.push1(3);
        ts.print();
        ts.push2(4);
        ts.print();
        ts.pop2();
        ts.pop1();
        ts.print();
        ts.push1(9);
        ts.print();
    }
}
