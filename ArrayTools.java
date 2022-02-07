/*
	Name - Anmol Singh
	Student Number - A00246505
	This Lab is to encypt/decrypt a user defined message with ceaser cipher and generate methods to get average of a numeric array,
	see if the array contains a user defined number and reverse the array and print the values out.
*/

import java.util.Scanner; //importing Scanner Class

public class ArrayTools{
	
	private static
		Scanner input = new Scanner(System.in); //Globally creating a scanner object which will be used to get user input
	
	public static void main(String[] args){ //defining main function
		
		System.out.println("\t Welcome to Lab 2 - ArrayTools");
		System.out.println("\t Please provide your input wherever it is required to run this Lab... \n\t Thank You");
		System.out.println("Hit 'Enter' to Begin");
		input.nextLine();
		
		//Caesar Cipher
        System.out.print("Enter a message with small and CAPITAL letters to encrypt : ");
		String String_to_encrypt = input.nextLine(); //gets string value from user input
		System.out.print("Enter Encryption Number : ");
		int ShiftValue = input.nextInt(); //gets Int value from user input
		
		String encryptedStr = encrypt(String_to_encrypt, ShiftValue); //encrypt method is called to generate encrypted string and is stored in String variable
        System.out.println("Encrypted Message : " + encryptedStr); //printing out encrypted value
		
		System.out.println("Decrypting by " + ShiftValue);
		//Way 1 -- creating a decrypt method and pass the same shiftvalue without negating it
		String decryptedStr = decrypt(encryptedStr, ShiftValue); //decrypt method is called to generate decrypted string and is stored in String variable
		
		/* //Way 2 -- Passing negative of the shiftvalue to encrypt method
		ShiftValue *= -1;
		String decryptedStr = encrypt(encryptedStr, ShiftValue);
		*/
		System.out.println( "Decrypted message is : " + decryptedStr); //printing out decrypted value
		System.out.println(""); //Spacing for clear view in output

		//generating numeric Array
		int[] newArray = {1,4,6,7,43,90,104,80}; //Hard coding array values for now
		System.out.print("Array used to check [");
		for(int i = 0; i < newArray.length ; i++){
			System.out.print(" " + newArray[i]);//printing each character of the array
		}
		System.out.println(" ]");
		System.out.println(""); //Spacing for clear view in output
		
		//getting Average
		int arrayAverage = arrayAvg(newArray); //calls arrayAvg method which will give average value of the input array
		System.out.println("Array Average = " + arrayAverage); //printing average value of the input array
		System.out.println(""); //Spacing for clear view in output
		
		//checking Value
		System.out.print("Enter a value to check : ");
		int value = input.nextInt(); //gets Int Value from user input
		boolean valueExists = arrayContains(newArray, value); //calls arrayContains method which returns if the given value exists in the given array
		System.out.println("The fact that the Array contains " + value + " is '" + valueExists + "'"); //printing existance of the user input value in the defined array
		System.out.println(""); //Spacing for clear view in output
		
		//Reversing Array
		int[] reversedArray = arrayReverse(newArray); //calls arrayReverse method to reverse the input array
		System.out.print("Reversed Array is [");
		for(int i = 0; i <reversedArray.length; i++){
			System.out.print(" " + reversedArray[i]); //printing all the characters of the reversed array
		}
		System.out.println(" ]");
		
	}
	
	private static String encrypt(String strToencrypt, int shiftValue){
		
		int len = strToencrypt.length(); //get length of the string
		char[] newcharArray = new char[len]; //creating new char array to store the encrypted message
		for(int i = 0; i < len; i++){
			/*reading each character from the input string and shifting its value by shiftValue(user defined)
			  and storing it in newcharArray only if the character is not a 'space'
			  eg. string is "abc ABC" and shiftValue is '1' then it will be ecrypted to "bcd BCD"
			*/
			if(strToencrypt.charAt(i) == ' '){
				newcharArray[i] = (char)strToencrypt.charAt(i);
			}else{
				newcharArray[i] = (char)(strToencrypt.charAt(i) + shiftValue);
			}
		}
        String encryptedString = new String(newcharArray); //converting char array to string
		return encryptedString; //string is returned where the function is called
	}
	
	private static String decrypt(String strTodecrypt, int shiftValue){
		
		int len = strTodecrypt.length(); //get length of the string
		char[] newcharArray = new char[len];//creating new char array to store the decrypted message
		for(int i = 0; i < len; i++){
			/*reading each character from the input string and shifting its value by shiftValue(user defined)
			  and storing it in newcharArray only if the character is not a 'space'
			  eg. string is "bcd BCD" and shiftValue is '1' then it will be decrypted to "abc ABC"
			*/
			if(strTodecrypt.charAt(i) == ' '){
				newcharArray[i] = (char)strTodecrypt.charAt(i);
			}else{
				newcharArray[i] = (char)(strTodecrypt.charAt(i) - shiftValue);
			}
		}
        String decryptedString = new String(newcharArray); //converting char array to string
		return decryptedString; //string is returned where the function is called
	}

	private static int arrayAvg(int[] arrayToavg){
		int arrayLength = arrayToavg.length; //get length of input array
		int average = 0; //variable to calculate and store average value
		for(int i = 0; i < arrayLength; i++){
			average += arrayToavg[i]; //adding values from input string to variable for averaging
		}
		average = average/arrayLength; //total sum is divided by length of the array
		return average; //returning average value where the function is called
	}
	
	private static boolean arrayContains(int[] arrayTocheck, int valueTocheck){
		for(int i = 0; i < arrayTocheck.length ; i++){ //going through all the elements of the array
			if(valueTocheck == arrayTocheck[i]){ //checking if the input value matches with the current element of the array
				return true; //if matches returns true
			}
		}
		return false; //all the elements are checked and none of them matches with the input value so returns false
	}
	
	private static int[] arrayReverse(int[] arrayToRev){
		int len = arrayToRev.length; //gets length of input array
		int[] tempArray = new int[len]; //creating temporary array to store reverse value
		int j = 0; //a variable to be used as index counter
		for(int i = len - 1; i >= 0 ; i--){//going through all the elements in th array starting from last to first
			tempArray[j] = arrayToRev[i]; //storing current element of input array in temporary array's 'j' index
			j++; //incrementing index counter for tempArray
		}
		return tempArray; //returning the whole array where the method id called
	}
}