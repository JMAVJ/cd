public class StringManipulatorTest {
    public static void main(String[] args) {
        System.out.println(StringManipulator.trimAndConcat("  Hello  ", "   World   "));
        System.out.println(StringManipulator.getIndex("java", 'j'));
        System.out.println(StringManipulator.getIndex("java", "av"));
        System.out.println(StringManipulator.concatSubstring("Hello", 1, 3, "World"));
    }    
}
