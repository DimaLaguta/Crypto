package encryptionalgorithms.algorithms.util;

import java.math.BigInteger;

public class Ring {

    public BigInteger add(BigInteger c1, BigInteger c2, BigInteger n) {
        return (c1.add(c2)).mod(n);
    }

    public BigInteger subtract(BigInteger c1, BigInteger c2, BigInteger n) {
        return (c1.subtract(c2)).mod(n);
    }

    public BigInteger multiply(BigInteger c1, BigInteger c2, BigInteger n) {
        return (c1.multiply(c2)).mod(n);
    }
}
