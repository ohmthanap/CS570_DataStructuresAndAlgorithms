// Name-Surname: Thanapoom Phatthanaphan
// CWID: 20011296
// CS 570-PA

import java.lang.String;
import java.lang.Character;
import java.util.Arrays;

public class BinaryNumber {

	private int data[];
	private boolean overflow;
	
	public BinaryNumber(int length) {
		
		data = new int[length];
		for (int i = 0; i < length; i++) {
			
			data[i] = 0;
			
		}
		
		System.out.println(Arrays.toString(data));
		
	}
	
	public BinaryNumber(String str) {
		
		data = new int[str.length()];
		for (int i = 0; i < data.length; i++) {
			
			if (Character.getNumericValue(str.charAt(i)) == 0 || Character.getNumericValue(str.charAt(i)) == 1) {
				
			// check the number if that is a binary number, then continue.
				
				data[i] = Character.getNumericValue(str.charAt(i));
				// Add a value at each index of binary number into an array
			
			} else {
				
				System.out.println("This number is not the binary number. A binary number contains only 0 and 1.");
				// Display a message that this number is not a binary number
				break;
				
			}
		}
	}
	
	public int getLength() {
		
		return data.length;
		
	}
	
	public int getDigit(int index) {
	// get the value in an array of a binary number at the index as indicated by a parameter
		
		if (index > data.length - 1) {
		// check if indicated index as parameter is not in array length,
		// then displays that the index is out of bounds and return -1
			
			System.out.println("The index is out of bounds");
			return -1;
			
		} else {
			
			return data[index];
			
		}
	}

	public void ShiftR(int amount) {
	// shift all digits of a binary number at any number of places to the right, as indicated by a parameter "amount"
		
		int new_data[] = Arrays.copyOf(data,  data.length + amount);
		// create a new array by copying from an original array and add more length as indicated by a parameter "amount"
		
		for (int i = 0; i < new_data.length; i++) {
		// add values into a new array by firstly adding zeros as the numbers indicated by a parameter,
		// then add values from an original array after zeros
			
			if (i - amount < 0) {
				
				new_data[i] = 0;
				
			} else {
				
				new_data[i] = data[i - amount];
				
			}
			
			System.out.print(new_data[i]);
			
		}
		
		System.out.println();
		
	}
	
	public void add(BinaryNumber aBinaryNumber) {
	// addition of two binary numbers
		
		int sum[] = new int[data.length];
		// create an array of the addition of two binary numbers
		
		if (data.length == aBinaryNumber.getLength()) {
		// check the the lengths of two binary numbers
			
			int carry = 0;
			// declare a variable to use as carry digit in addition method
			
			for (int i = 0; i < data.length; i++) {
				
				if (carry == 0) {
					
					if (data[i] == 0 && aBinaryNumber.getDigit(i) == 0) {
						
						sum[i] = 0;
						
					} else if ((data[i] == 1 && aBinaryNumber.getDigit(i) == 0) || (data[i] == 0 && aBinaryNumber.getDigit(i) == 1)) {
						
						sum[i] = 1;
						
					} else if (data[i] == 1 && aBinaryNumber.getDigit(i) == 1) {
						
						sum[i] = 0;
						carry = 1;
						
					}
					
				} else if (carry == 1) {
					
					if (data[i] == 0 && aBinaryNumber.getDigit(i) == 0) {
						sum[i] = 1;
						carry = 0;
						
					} else if ((data[i] == 1 && aBinaryNumber.getDigit(i) == 0) || (data[i] == 0 && aBinaryNumber.getDigit(i) == 1)) {
						
						sum[i] = 0;
						
					} else if (data[i] == 1 && aBinaryNumber.getDigit(i) == 1) {
						
						sum[i] = 1;
						
					}
				}
			}
			
			if (carry == 1) {
			// in case that the result has larger length than the summands,
			// declare that this binary number is overflow
				
				sum = Arrays.copyOf(sum,  sum.length + 1);
				sum[sum.length - 1] = 1;
				overflow = true;
				
			}
			
			data = sum;
			
		} else {
			// in case of the lengths of two binary numbers do not coincide
			
			System.out.println("The lengths of the binary numbers do not coincide.");
			
		}
	}
	
	public String toString() {
	// transform a binary number to a String. If the number is the result of an overflow,
	// then returns the string "Overflow"
		
		String array_toString = "";
		if(overflow == true) {
		// check if the number is the result of an overflow, then returns "Overflow"
			
			return "Overflow";
			
		} else {
			
			for (int i = 0; i < data.length; i++) {
				array_toString += data[i];
				
			}
			
			return array_toString;
			
		}
	}
	
	public int toDecimal() {
	// convert a binary number to a decimal number	
		
		int decimal_number = 0;
		for (int i = 0; i < data.length; i++) {
			decimal_number += data[i] * Math.pow(2, i);
			
		}
		
		return decimal_number;
		
	}
	
	public void clearOverflow() {
	// clear the overflow flag by declaring it as "False"
		
		overflow = false;
		
	}
	
	public static void main(String[] args) {
		
		BinaryNumber binaryNumber_length = new BinaryNumber(5);
		System.out.println();
		// create object that contains an array of length as indicated by a parameter
		
		BinaryNumber binaryNumber_1 = new BinaryNumber("11010");
		BinaryNumber binaryNumber_2 = new BinaryNumber("1001");
		BinaryNumber binaryNumber_3 = new BinaryNumber("11111");
		BinaryNumber binaryNumber_4 = new BinaryNumber("10001");
		BinaryNumber binaryNumber_5 = new BinaryNumber("10000");
		// create objects (binary numbers), using little-endian format
		
		BinaryNumber binaryNumber_6 = new BinaryNumber("12345");
		// create an object that is not a binary number
		// the program displays message that this is not a binary number
		
		System.out.println();
		
		System.out.println(binaryNumber_1.getDigit(1));
		System.out.println();
		// get the digit in a binary number at the index as indicated by a parameter
		
		System.out.println(binaryNumber_2.getDigit(5));
		System.out.println();
		// get the digit in a binary number at the index as indicated by a parameter
		// this is the case that index is out of bounds, displays message and return -1
		
		System.out.println(binaryNumber_3.getLength());
		System.out.println();
		// get the length of an array of a binary number
		
		binaryNumber_4.ShiftR(3);
		System.out.println();
		// shift all digits of a binary number at any number of places to the right, as indicated by a parameter
		
		System.out.println(binaryNumber_3.toDecimal());
		System.out.println();
		// convert the binary number to decimal number
		
		binaryNumber_1.add(binaryNumber_3);
		System.out.println(binaryNumber_1.toString());
		// add two binary numbers in case that the result is overflow
		
		binaryNumber_1.clearOverflow();
		// set the overflow flag as False
		System.out.println(binaryNumber_1.toString());
		// display that binaryNumber_1 is added by binaryNumber_3
		// even the addition result is overflow
		
		System.out.println();
	
		binaryNumber_2.add(binaryNumber_4);
		// add two binary numbers in case that the lengths of two binary numbers do not coincide
		System.out.println(binaryNumber_2.toString());
		// display binaryNumber_2 isn't added by binaryNumber_4, and still remain an original value
		
		System.out.println();
		
		binaryNumber_4.add(binaryNumber_5);
		// add two binary numbers in case that two binary numbers have the same lengths and the result is not overflow
		System.out.println(binaryNumber_4.toString());
		// display that binaryNumber_4 is added by binaryNumber_5
	
	}
}
