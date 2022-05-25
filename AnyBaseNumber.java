import java.util.ArrayList;
/**
 * A number of any base-N system, intended for especially for bases other than 10.
 * Numbers initiated without a decimal value will begin at 0.
 * 
 * @author Alex McColm 
 * @version (a version number or a date)
 */
public class AnyBaseNumber
{
    // instance variables - replace the example below with your own
    private String[] symbols;
    private String[] digits;
    private int base10Value;
    private int base;

    /**
     * Constructor for objects of class AnyBaseNumber
     */
    public AnyBaseNumber(int base, int base10Value, String[] symbols)
    {
        // initialise instance variables
        this.base10Value = base10Value;
        this.base = base;
        this.symbols = symbols;
        String[] numberRep = convertNum(base10Value);
        this.digits = numberRep;
    }
    
    public AnyBaseNumber(int base, String[] symbols) { 
        this.base10Value = 0;
        this.base = base;
        this.symbols = symbols;
        String zeroSym = symbols[0];
        String[] zero = {zeroSym};
        this.digits = zero;
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  n   a base 10 number of int type
     * @return     a string array, which read in order represents the number in desired base
     */
    public String[] convertNum(int n)
    {
        ArrayList<String> list = new ArrayList<>();
        int r;
        int q = n;
        while (q != 0) {
            // Get the remainder.
            r = q % base;
            // Divide the decimal number by the value of the new base.
            q = q / base;
            // Add the remainder to the left of the list, such that
            // by completion, the digit at index 0 should be the Most Significant Digit (MSD).
            list.add(symbols[r]);
            // If the number is not zero, repeat with the new quotient.
        }
        
        String[] newDigits = new String[list.size()];
        
        for (int i = 0; i < newDigits.length; ++i)
        {
            newDigits[newDigits.length - i - 1] = list.get(i);
        }
        
        return newDigits;
        
    }
    /** 
     * Add the given number to this number. Uses base 10 addition and
     * converts it back.
     */
    public void add(AnyBaseNumber b) {
		this.base10Value = this.base10Value + b.base10Value;
        String[] numberRep = convertNum(base10Value);
        this.digits = numberRep;
	}
    
    /**
     * Multiply this number by the given number. Uses base 10 multiplication
     * and converts it back.
     */
    public void multiply(AnyBaseNumber b) {
		this.base10Value = this.base10Value * b.base10Value;
        String[] numberRep = convertNum(base10Value);
        this.digits = numberRep;
	}
    
    /**
     * Returns a string representation of number in given bases with
     * given symbols.
     */
    public String toString()
    {
        String numberStr = "";
        for (String digit : digits)
        {
            numberStr += digit;
        }
        return numberStr;
    }
    
    public static void main(String[] args)
    {
        String[] symbols = {"0", "1"};
        AnyBaseNumber binaryThree = new AnyBaseNumber(2, 1, symbols);
        binaryThree.multiply(new AnyBaseNumber(2, 64, symbols));
        System.out.println("Should be 100 : " + binaryThree.toString());
    }
}
