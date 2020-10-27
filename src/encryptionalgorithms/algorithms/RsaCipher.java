package encryptionalgorithms.algorithms;

import encryptionalgorithms.algorithms.util.Cipher;

import java.math.BigInteger;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;

public class RsaCipher implements Cipher {

    private final static int bitLength = 256;
    private static SecureRandom random;
    private static BigInteger one;
    private Charset charset = StandardCharsets.UTF_8;

    private BigInteger e;
    private BigInteger d;
    private BigInteger n;

    public RsaCipher() {
        random = new SecureRandom();
        one = BigInteger.valueOf(1);
    }

    public BigInteger getE() {
        return e;
    }

    public BigInteger getD() {
        return d;
    }

    public BigInteger getN() {
        return n;
    }

    public void init() {
        BigInteger p = BigInteger.probablePrime(bitLength, random);
        BigInteger q = BigInteger.probablePrime(bitLength, random);

        n = p.multiply(q);

        BigInteger phi = (p.subtract(one)).multiply(q.subtract(one));
        e = calcaulateE(phi);
        d = e.modInverse(phi);
    }

    @Override
    public String encrypt(String message, Object... key) {
        BigInteger e = (BigInteger) key[0];
        BigInteger n = (BigInteger) key[1];

        BigInteger encryptedMessage = new BigInteger(message.getBytes(charset));

        return encryptedMessage.modPow(e, n).toString();
    }

    @Override
    public String decrypt(String message, Object... key) {
        BigInteger d = (BigInteger) key[0];
        BigInteger n = (BigInteger) key[1];

        BigInteger integerMessage = new BigInteger(message);
        BigInteger decryptedMessage = integerMessage.modPow(d, n);

        return new String(decryptedMessage.toByteArray(), charset);
    }

    private BigInteger calcaulateE(BigInteger phi) {
        for (BigInteger i = phi.subtract(one); i.compareTo(one) > 0; i = i.subtract(one)) {
            if (i.isProbablePrime(1) && i.gcd(phi).equals(one)) {
                return i;
            }
        }

        return BigInteger.valueOf(2);
    }
}
