/**
 * TestCalculator
 */
public class TestCalculator {

    public static void main(String[] args) {
        Calculator c = new Calculator();
        c.performOperation(10.5);
        c.performOperation('+');
        c.performOperation(5.2);
        c.performOperation('*');
        c.performOperation(10.0);
        c.performOperation('-');
        c.performOperation(2.0);
        c.performOperation('=');
        System.out.println(c.getResult());    
    }
}