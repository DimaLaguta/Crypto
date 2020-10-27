package encryptionalgorithms.algorithms;

import encryptionalgorithms.algorithms.util.Cipher;

import java.math.BigInteger;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;

public class RabinCipher implements Cipher {

    private final static int bitLength = 2048;
    private static SecureRandom random;
    private Charset charset = StandardCharsets.UTF_8;
    private static BigInteger THREE;
    private static BigInteger FOUR;

    private BigInteger p;
    private BigInteger q;
    private BigInteger n;

    public RabinCipher() {
        random = new SecureRandom();
        THREE = BigInteger.valueOf(3);
        FOUR = BigInteger.valueOf(4);
    }

    public BigInteger getP() {
        return p;
    }

    public BigInteger getQ() {
        return q;
    }

    public BigInteger getN() {
        return n;
    }

    public void init() {
        p = calculatePrime();
        q = calculatePrime();
        n = p.multiply(q);
    }

    @Override
    public String encrypt(String message, Object... key) {
        BigInteger n = (BigInteger) key[0];

        BigInteger c = new BigInteger(message.getBytes(charset));

        return ((c.multiply(c)).mod(n)).toString();
    }

    @Override
    public String decrypt(String message, Object... key) {
        BigInteger p = (BigInteger) key[0];
        BigInteger q = (BigInteger) key[1];
        BigInteger n = (BigInteger) key[2];

        BigInteger c = new BigInteger(message);

        BigInteger p1 = c.modPow(p.add(BigInteger.ONE).divide(FOUR), p);
        BigInteger p2 = p.subtract(p1);
        BigInteger q1 = c.modPow(q.add(BigInteger.ONE).divide(FOUR), q);
        BigInteger q2 = q.subtract(q1);

        BigInteger[] ext = Gcd(p, q);
        BigInteger y_p = ext[1];
        BigInteger y_q = ext[2];

        BigInteger d1 = y_p.multiply(p).multiply(q1).add(y_q.multiply(q).multiply(p1)).mod(n);
        BigInteger d2 = y_p.multiply(p).multiply(q2).add(y_q.multiply(q).multiply(p1)).mod(n);
        BigInteger d3 = y_p.multiply(p).multiply(q1).add(y_q.multiply(q).multiply(p2)).mod(n);
        BigInteger d4 = y_p.multiply(p).multiply(q2).add(y_q.multiply(q).multiply(p2)).mod(n);

        StringBuilder sb = new StringBuilder();
        sb.append(new String(d1.toByteArray()));
        sb.append('\n').append(new String(d2.toByteArray(), charset));
        sb.append('\n').append(new String(d3.toByteArray(), charset));
        sb.append('\n').append(new String(d4.toByteArray(), charset));

        return sb.toString();
    }

    private BigInteger[] Gcd(BigInteger a, BigInteger b)
    {
        BigInteger s = BigInteger.ZERO;
        BigInteger old_s = BigInteger.ONE;
        BigInteger t = BigInteger.ONE;
        BigInteger old_t = BigInteger.ZERO;
        BigInteger r = b;
        BigInteger old_r = a;
        while (!r.equals(BigInteger.ZERO)) {
            BigInteger q = old_r.divide(r);
            BigInteger tr = r;
            r = old_r.subtract(q.multiply(r));
            old_r = tr;

            BigInteger ts = s;
            s = old_s.subtract(q.multiply(s));
            old_s = ts;

            BigInteger tt = t;
            t = old_t.subtract(q.multiply(t));
            old_t = tt;
        }
        return new BigInteger[] { old_r, old_s, old_t };
    }

   private BigInteger calculatePrime() {
        BigInteger p;
        do {
            p = BigInteger.probablePrime(bitLength, random);
        } while (!p.mod(FOUR).equals(THREE));
        return p;
    }
}
