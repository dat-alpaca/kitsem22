package kadai11;

public class CalcCtrl {
    private final CalcModel model;

    public CalcCtrl() {
        this.model = new CalcModel();
    }

    public int calc(int num1, String op, int num2) {
        switch (op.trim()) {
            case "+" -> {
                return model.plus(num1, num2);
            }

            case "-" -> {
                return model.minus(num1, num2);
            }
            
            case "*" -> {
                return model.multi(num1, num2);
            }

            case "/" -> {
                return model.divide(num1, num2);
            }

            default -> throw new IllegalArgumentException("Unsupported operator: " + op);
        }
    }
}