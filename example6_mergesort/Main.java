public class Main {
    public static int[] mergeArrays(int[] a1, int[] a2) {
        int[] res = new int[a1.length + a2.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < a1.length && j < a2.length) {
            int a = a1[i];
            int b = a2[j];
            if (a <= b) {
                res[k] = a;
                ++i;
                ++k;
                continue;
            } else {
                res[k] = b;
                ++j;
                ++k;
            }
        }
        while (i < a1.length) {
            res[k] = a1[i];
            ++i;
            ++k;
        }
        while (j < a2.length) {
            res[k] = a2[j];
            ++j;
            ++k;
        }
        return res; // your implementation here
    }
    public static void main(String[] args) {
        System.out.println("asd");
    }
}