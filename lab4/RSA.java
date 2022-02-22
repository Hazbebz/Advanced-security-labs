// Java Program to Implement the RSA Algorithm
/*
Consider two prime numbers p and q.
Compute n = p*q
Compute ϕ(n) = (p – 1) * (q – 1)
Choose e such gcd(e , ϕ(n) ) = 1
Calculate d such e*d mod ϕ(n) = 1
Public Key {e,n} Private Key {d,n}
Cipher text C = Pe mod n where P = plaintext
For Decryption D = Dd mod n where D will refund the plaintext.
*/
import java.math.*;
import java.util.*;
 
public class RSA {
    
    public static void main(String args[])
    {
        int p, q, n, z, d = 0, e, i;
 
        // The number to be encrypted and decrypted
        int msg = 12;
        double c;
        BigInteger messageback;
 
        // 1st prime number p
        p = 5;
 
        // 2nd prime number q
        q = 11;
        n = p * q;
        z = (p - 1) * (q - 1);
        System.out.println("the value of z = " + z);
 
        for (e = 2; e < z; e++) {
 
            // e is for public key exponent
            if (GCD(e, z) == 1) {
                break;
            }
        }
        System.out.println("the value of e = " + e);
        for (i = 0; i <= 9; i++) {
            int x = 1 + (i * z);
 
            // d is for private key exponent
            if (x % e == 0) {
                d = x / e;
                break;
            }
        }
        System.out.println("Value of d = " + d);
        c = (Math.pow(msg, e)) % n;
        System.out.println("Encrypted message : " + c);
 
        // converting int value of n to BigInteger
        BigInteger N = BigInteger.valueOf(n);
 
        // converting float value of c to BigInteger
        BigInteger C = BigDecimal.valueOf(c).toBigInteger();
        messageback = (C.pow(d)).mod(N);
        System.out.println("Decrypted message is : "
                           + messageback);
    }
 
    static int GCD(int e, int z)
    {
        if (e == 0)
            return z;
        else
            return GCD(z % e, e);
    }
}