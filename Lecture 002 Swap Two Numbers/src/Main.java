public class Main
{
    public static void main(String[] args)
    {
        int a = 5, b = 7;
        System.out.println("Before Swap\na is : "+a+", b is : "+b);
        a = a^b;
        b = b^a;
        a = a^b;
        System.out.println("After Swap\na is : "+a+", b is : "+b);
    }
}
