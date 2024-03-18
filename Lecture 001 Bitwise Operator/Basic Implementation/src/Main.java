public class Main
{
    public static void main(String[] args)
    {
        int a = 4, b = 6;
        int result = a&b;
        System.out.println("a&b : " + result);

        result = a|b;
        System.out.println("a|b : " + result);

        result = ~a;
        System.out.println("~a : " + result);

        result = a^b;
        System.out.println("a^b : " + result);
    }
}
