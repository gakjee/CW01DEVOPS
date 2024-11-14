
public class Dec2Hex {
    public static void main(String[] args) {
        //check if there is no inputs
        if (args.length == 0) {
            System.out.println("Error: No input provided. Please provide an integer value.");
            return;  //exit if there is no inputs provided
        }

        try {
            //attempt to parse the input to an integer
            int decimalValue = Integer.parseInt(args[0]);

            //convert the integer value to a hexidecimal
            String hexValue = Integer.toHexString(decimalValue).toUpperCase();

            //print the output
            System.out.println("Converting the Decimal Value " + decimalValue + " to Hex...");
            System.out.println("Hexadecimal representation is: " + hexValue);
        } catch (NumberFormatException e) {
            //error message for when the input is not a valid integer
            System.out.println("Error: Invalid input. Please provide a valid integer value.");
        }
    }
}

