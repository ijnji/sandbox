public class Parity {

    private static int[] LUT = new int[0xFF + 1];

    private static int parity1(int x) {
        int p = 0;
        while (x != 0) {
            x = x & (x - 1);
            p ^= 1;
        }
        return p;
    }

    private static int parity2(int x) {
        int p = 0;
        while (x != 0) {
            if ((x & 1) == 1) {
                p ^= 1;
            }
            x = x >> 1;
        }
        return p;
    }

    private static int parity3(int x) {
        int p = LUT[x & 0xFF];
        p ^= LUT[(x >> 8) & 0xFF];
        p ^= LUT[(x >> 16) & 0xFF];
        p ^= LUT[(x >> 24) & 0xFF];
        return p;
    }

    private static void lutGen() {
        for (int i = 0; i <= 0xFF; i++) {
            LUT[i] = parity1(i);
        }
    }

    public static void main(String[] args) {
        assert(parity1(0b0000_0000_0000_0000_0000_0000_0000_0000) == 0);
        assert(parity1(0b0000_0000_0000_0000_0000_0000_0000_1001) == 0);
        assert(parity1(0b0000_0000_0000_0000_0000_0000_0110_0010) == 1);

        assert(parity2(0b0000_0000_0000_0000_0000_0000_0000_0000) == 0);
        assert(parity2(0b0000_0000_0000_0000_0000_0000_0000_1001) == 0);
        assert(parity2(0b0000_0000_0000_0000_0000_0000_0110_0010) == 1);
        
        lutGen();
        assert(parity3(0b0000_0000_0000_0000_0000_0000_0000_0000) == 0);
        assert(parity3(0b0000_0000_0000_0000_0000_0000_0000_1001) == 0);
        assert(parity3(0b0000_0000_0000_0000_0000_0000_0110_0010) == 1);

        System.out.println("All tests passed.");
    }
    
}