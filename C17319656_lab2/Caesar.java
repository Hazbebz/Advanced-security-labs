package C17319656_lab2;
import java.util.*;

public class Caesar {
    public static void main(String args[]) {
        //scan in user input
        Scanner sc = new Scanner(System.in);
        System.out.println(" Input the plaintext msg : ");
        //assign entered string to plaintext
        String plaintext = sc.nextLine();
        //read in shift Number the user wants 
        System.out.println(" Enter the value by which each character in the plaintext message gets shifted : ");
        int shift = sc.nextInt();

        String Ctext = "";
        char alphabet;
        
        //Loop to shift for the length of the message plaintext
        for(int i=0; i < plaintext.length();i++) 
        {
             // Shift one character at a time
            alphabet = plaintext.charAt(i);
            
            // if alphabet lies between a and z 
            if(alphabet >= 'a' && alphabet <= 'z') 
            {
             // shift alphabet
             alphabet = (char) (alphabet + shift);
             // if shift alphabet greater than 'z'
             if(alphabet > 'z') {
                // reshift to starting position 
                alphabet = (char) (alphabet+'a'-'z'-1);
             }
             Ctext = Ctext + alphabet;
            }
            //same operation just implemented for upper case letters
            // if alphabet lies between 'A'and 'Z'
            else if(alphabet >= 'A' && alphabet <= 'Z') {
             // shift alphabet
             alphabet = (char) (alphabet + shift);    
                
             // if shift alphabet greater than 'Z'
             if(alphabet > 'Z') {
                 //reshift to starting position 
                 alphabet = (char) (alphabet+'A'-'Z'-1);
             }
             Ctext = Ctext + alphabet;
            }
            else {
             Ctext = Ctext + alphabet;   
            }
        
    }
    //print out the encrypted ciphertext
    System.out.println(" ciphertext : " + Ctext);
  }
}