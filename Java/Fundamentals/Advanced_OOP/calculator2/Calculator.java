import java.util.ArrayList;

/**
 * Calculator
 */
public class Calculator implements java.io.Serializable {
    private ArrayList<Double> numbers; 
    private ArrayList<Character> operators;
    private double result;

    public Calculator() {
        this.numbers = new ArrayList<>();
        this.operators = new ArrayList<>();
        this.result = 0;
    }

    private void calculateResult() {
        this.result = this.numbers.get(0);
        this.numbers.remove(0);
        for (int i=0; i<this.operators.size(); i++) {
            if (this.operators.get(i) == '+') {
                this.result += this.numbers.get(0);
            } else if (this.operators.get(i) == '-') {
                this.result -= this.numbers.get(0);
            }
            this.numbers.remove(0);
        }
    }

    public double getResult() {
        return this.result;
    }

    public void performOperation(Double num) {
        if (this.numbers.size() == 0) {
            this.numbers.add(num);
            return;
        }
        Character lastOperator = this.operators.get(this.operators.size()-1);
        if (lastOperator == '*') {
            Double operationResult = this.numbers.get(this.numbers.size()-1)*num;
            this.numbers.add(operationResult);
            this.numbers.remove(this.numbers.size()-2);
            this.operators.remove(this.operators.size()-1);
        } else if (lastOperator == '/') {
            Double operationResult = this.numbers.get(this.numbers.size()-1)/num;
            this.numbers.add(operationResult);
            this.numbers.remove(this.numbers.size()-2);
            this.operators.remove(this.operators.size()-1);
        } else {
            this.numbers.add(num);
        }
    }

    public void performOperation(Character operation) {
        if (operation == '=') {
            calculateResult();
            return;
        }
        this.operators.add(operation);
    }
}