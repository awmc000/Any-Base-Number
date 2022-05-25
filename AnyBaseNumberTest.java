//import org.junit.Test;
//import org.junit.Ignore; //afaik i dont need this
//import static org.junit.Assert.assertEquals;\

public class AnyBaseNumberTest { 
	//@Test
	public static void correctBinary() { 
		AnyBaseNumber num;
		String[] symbolsArr = {"0", "1"};
		for (int i = 1; i <= 100000; i++) { 
			num = new AnyBaseNumber(2, i, symbolsArr);
			assert (num.toString().equals(Integer.toBinaryString(i)));
			System.out.print("[ " + i + " OK]");
			if (i % 5 == 0) { 
				System.out.println();
			}
		}
	}
	
	public static void correctDecimal() {
		AnyBaseNumber num;
		String[] symbolsArr = {"0", "1", "2", "3", "4", 
			"5", "6", "7", "8", "9"};
		for (int i = 1; i <= 100000; i++) { 
			num = new AnyBaseNumber(10, i, symbolsArr);
			assert (num.toString().equals(Integer.toString(i)));
			System.out.print("[ " + i + " OK]");
			if (i % 5 == 0) { 
				System.out.println();
			}
		}
	}
	
	public static void characterSwaps() { 
		AnyBaseNumber num;
		String[] symbolsArr = {"A", "1", "2", "3", "4", 
			"5", "6", "7", "8", "9"};
		for (int i = 1; i <= 100000; i++) { 
			num = new AnyBaseNumber(10, i, symbolsArr);
			assert (num.toString().equals(Integer.toString(i).replace("0", "A")));
			System.out.print("[ " + i + " OK]");
			if (i % 5 == 0) { 
				System.out.println();
			}
		}
	}
	
	public static void main(String[] args) { 
		System.out.println("================BASE 2 / BINARY TEST!"
		+ "================");
		correctBinary();
		System.out.println("================BASE 10 / DECIMAL TEST!"
		+ "================");
		correctDecimal();
		System.out.println("================CHARACTER SWAP TEST!"
		+ "================");
		characterSwaps();
	}
}
