package service.hash;

public class CustomHasher implements Hasher {

    private static byte[] secretNumbers = {26, 12, 111, -102, 40, 3};

    @Override
    public int hash(byte[] src) {
        int hash = 0;
        for (int i = 0; i < src.length; i++) {
            hash += src[i] * secretNumbers[i % (secretNumbers.length - 1)];
            System.out.println(src[i] + " * " + secretNumbers[i % (secretNumbers.length - 1)] + " = " + hash);
        }
        return hash;
    }

    public byte[] hashToBytes(byte[] src) {
        int hash = hash(src);
        byte[] result = new byte[8];
        for (int i = 0; i < 8; i++) {
            result[i] = (byte) (hash >> (i * 8));
        }
        return result;
    }
}
