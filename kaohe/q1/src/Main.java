import java.io.File;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner mySc = new Scanner(System.in);
        try {
            Student res = biSearch(FileUtil.parseStudents("students.txt"), Integer.parseInt(mySc.nextLine()));
            if (res == null) {
                System.out.println("该学生不存在");
            } else {
                System.out.println("找到 姓名：" + res.getName());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        mySc.close();

    }

    public static Student biSearch(Student[] array, int a) {
        int lo = 0;
        int hi = array.length - 1;
        int mid;
        while (lo <= hi) {
            mid = (lo + hi) / 2;
            if (Integer.parseInt(array[mid].getStuid()) == a) {
                return array[mid];
            } else if (Integer.parseInt(array[mid].getStuid()) < a) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return null;
    }

}
