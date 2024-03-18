public class Main
{
    // Method to print binary representation of a number
    public static void printBinaryRepresentation(int number)
    {
        if (number == 0)
        {
            System.out.println("Binary representation: 0"); // Special case for 0
            return;
        }

        StringBuilder binary = new StringBuilder();

        // Starting from the leftmost bit (most significant bit), extract each bit using right shift operator
        for (int i = 31; i >= 0; i--)
        {
            int bit = (number >> i) & 1; // Extract the i-th bit using bitwise AND with 1
            binary.append(bit); // Append the bit to the result
        }

        // Remove leading zeros
        int index = 0;
        while (index < binary.length() && binary.charAt(index) == '0')
        {
            index++;
        }
        System.out.println("Binary representation: " + binary.substring(index));
    }
    public static void main(String[] args)
    {
        //extracting the ith bit
        int n = 13;
        printBinaryRepresentation(n);

        //ith bit extraction
        int ithBit = 2; //0 based indexing
        int mask = 1<<ithBit;
        int extractedBit = (n&mask) >> ithBit;
        System.out.println(ithBit + " bit is : "+extractedBit);

        //change ith bit(lets flip 1st bit i.e., 0 to 1)
        System.out.println("===================");
        ithBit = 1;
        mask = 1<<ithBit;
        int num = n|mask;
        printBinaryRepresentation(num);

        //clearing ith bit(setting the bit to 0)
        System.out.println("===================");
        ithBit = 0;
        mask = ~(1<<ithBit);
        num = n&mask;
        printBinaryRepresentation(num);

        System.out.println("===================");
        ithBit = 1;
        mask = ~(1<<ithBit);
        num = n&mask;
        printBinaryRepresentation(num); // wont change anything as 1st bit is already 0


    }
}
