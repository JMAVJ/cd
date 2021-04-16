/**
 * Calculator
 */
public class Calculator implements java.io.Serializable {
    private double operandOne;
    private double operandTwo;
    private char operation;
    private double result;

    public Calculator() {
        
    }

    public void setOperandOne(double operand) {
        this.operandOne = operand;
    }

    public void setOperandTwo(double operand) {
        this.operandTwo = operand;
    }

    public void setOperation(char operation) {
        this.operation = operation;
    }

    public double getResult() {
        return this.result;
    }

    public void performOperation() {
        switch (this.operation) {
            case '+':
                this.result = this.operandOne + this.operandTwo;    
                break;

            case '-':
                this.result = this.operandOne - this.operandTwo;        
                break;
        }
    }
}