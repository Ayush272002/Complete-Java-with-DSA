public class Main
{
    public static void main(String[] args)
    {
        //Right Shift - mainly div by 2, but can fail on large/small numbers and end up giving negative result
        System.out.println(17>>1);
        System.out.println(17>>2);

        //Left Shift - mainly multiply by 2, but can fail on large numbers
        System.out.println(19<<1);
        System.out.println(21<<2);
        System.out.println(Integer.MAX_VALUE<<1); // will give a negative number cause of overflow
    }
}
