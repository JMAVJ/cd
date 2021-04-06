public class StringManipulator {
    public static String trimAndConcat(String string1, String string2) {
        return string1.trim() + string2.trim();
    }

    public static int getIndex(String string, char character) {
        return string.indexOf(character);
    }

    public static int getIndex(String string, String substring) {
        return string.indexOf(substring);
    }

    public static String concatSubstring(String string1, int fromIndex, int toIndex, String string2) {
        string1 = string1.substring(fromIndex, toIndex);
        return string1 + string2;
    }
}
