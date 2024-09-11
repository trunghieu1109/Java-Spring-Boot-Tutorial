public class SwitchCaseDemo {
    public static void main(String[] args) {
        int num1 = 1;
        int num2 = 2;
        switch(num2) {
            case 0:
                System.out.println("Num1 is greater than num2");
                break;
            case 1:
                System.out.println("Num1 is equal to num2");
                break;
            case 2:
                System.out.println("Num1 is less than num2");
                break;
            default:
                System.out.println("None of above");
        }
    }
}