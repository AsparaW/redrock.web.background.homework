
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner mySc = new Scanner(System.in);
        boolean result = JsonChecker.getInstance().check(mySc.nextLine());
        if (result){
            System.out.println("合法");
        }else {
            System.out.println("非法");
        }
        mySc.close();
    }
}
