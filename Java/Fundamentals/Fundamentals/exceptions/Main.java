import java.lang.ProcessBuilder.Redirect.Type;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Object> list = new ArrayList<>();
        list.add("String");
        list.add(1);
        list.add("String 2");
        list.add(200);
        list.add('a');
        for (Object object : list) {
            try {
                int castedObject = (int) object;
                System.out.println(castedObject);

            } catch (ClassCastException e) {
                System.out.println("type " + object.getClass() + " can not be converted to an integer");
            }
        }
    }
}