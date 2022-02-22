package C17319656_lab2;
import java.util.Scanner;

public class Vig {
	public static void main(String[] args) {

		System.out.println("----Vigenere Cipher Encryptor----\n");
		Scanner in = new Scanner(System.in);

		//encyrpt, decrypt or invaild input 
		System.out.println("- Press 1 to encrypt a message / Press 2 to decrypt a message - ");
		int input = in.nextInt();

		if (input == 1) {
            
			System.out.print("Enter the key in UPPER Case: ");
			String key = in.next();//encyrption key 
			System.out.print("Enter the message that would like to be encrypted by Vigenere cipher: ");
			String EMessage = in.next();//string to be encrypted
			String encryptMessage = encrypt(EMessage, key); //call encryption function and pass in message and key 
			System.out.println("The encrypted message is: " + encryptMessage);
		}
		else if (input == 2) {
			System.out.print("Enter the key in UPPER Case: ");
			String key = in.next();
			System.out.print("Enter the message that would like to be decrypted by Vigenere cipher: ");
			String DMessage = in.next();
			String decryptMessage = decrypt(DMessage, key);
			System.out.println("The decrypted message is: " + decryptMessage);
		}
		else {
			System.out.println("Wrong Input!");
		}
		in.close();
	}

	//	Encryption
	// Using ASCII Dec Representation:
	//	((72-65) + (83-65)) % 26 + 65 >> Encrypted "Z"
	public static String encrypt(String Message, String Key) {
		String EMessage = "";
		Message = Message.toUpperCase();//convert to uppercase
		//for the length of the message 
		for (int i = 0, j = 0; i < Message.length(); i++) {
			char letter = Message.charAt(i);
			EMessage += (char)(((letter - 65) + (Key.charAt(j)-65)) % 26 + 65);
			j = ++j % Key.length();
		}
		return EMessage;
	}

	//	Decryption using ASCII dec rep
	//	ASCII: "Z" is 90 && "S" is 83
	//	(90-83+26) % 26 + 65 >> Encrypted "Z"
	public static String decrypt(String Message, String Key) {
		String DMessage = "";
		Message = Message.toUpperCase();
		for (int i = 0, j = 0; i < Message.length(); i++) {
			char letter = Message.charAt(i);
			DMessage += (char)((letter - Key.charAt(j) + 26) % 26 + 65);
			j = ++j % Key.length();
		}
		return DMessage;
	}
}
