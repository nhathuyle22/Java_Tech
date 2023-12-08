public class Exercise1 {
    public static void main(String[] args){
        if (args.length != 3){
            System.out.println("Invalid expression");
            return;
        }
        double value1 = Integer.parseInt(args[0]);
        double value2 = Integer.parseInt(args[2]);
        switch (args[1]){
            case "+":
                System.out.println(value1 + value2);
                break;
            case "-":
                System.out.println(value1 - value2);
                break;
            case "*":
                System.out.println(value1 * value2);
                break;
            case "/":
                System.out.println(value1 / value2);
                break;
            case "^":
                System.out.println(Math.pow(value1,value2));
                break;
            default:
                System.out.println("Unsupported operator");
                return;
        }
    }
}