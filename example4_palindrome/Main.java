public class Main {
    public static boolean isPalindrome(String text) {
        int i = 0;
        int j = text.length() - 1;
        while (i < j) {
            char ch1 = Character.toLowerCase(text.charAt(i));
            char ch2 = Character.toLowerCase(text.charAt(j));
            if (!Character.isLetterOrDigit(ch1)) {
                i += 1;
                continue;
            }
            if (!Character.isLetterOrDigit(ch2)) {
                j -= 1;
                continue;
            }
            if (ch1 != ch2) {
                return false;
            }
            i += 1;
            j -= 1;
        }
        return true;
    }
    public static void main(String[] args) {
        if (args.length != 1) {
            throw new IllegalArgumentException("Expectede 1 arg");
        }
        System.out.println(isPalindrome(args[0]));
    }
}