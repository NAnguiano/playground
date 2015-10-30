

public class findAdditionalCharacter {

    public static void main(String[] args) {
        char duplicateChar;
        int longestLength = args[1].length();
        String longerString = args[1];
        String shorterString = args[0];
        if (args[0].length() > args[1].length()) {
             longestLength = args[0].length();
             longerString = args[0];
             shorterString = args[1];
        } 
        for (int i = 0; i < longestLength; i++) {
            try {
                if(longerString.charAt(i) != shorterString.charAt(i)) {
                    duplicateChar = longerString.charAt(i);
                }
            } catch (StringIndexOutOfBoundsException e) {
                 duplicateChar = longerString.charAt(i);
            }
        }
        System.out.println(duplicateChar);
    }
}