public class ReverseString {
    public static void main(String[] args) {
        String startingString = args[0];
        String reversedString = "";
        for (int currentChar = startingString.length() - 1; currentChar >= 0; currentChar--) {
            reversedString = reversedString + startingString.charAt(currentChar);
        }
        System.out.println(reversedString);
    }
}