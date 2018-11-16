import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class StuController {

    private static final String DIVIDE_LINE = "-------------------------";
    public static int maxIndex = 0;
    private static ArrayList<Student> stuList = new ArrayList<>();
    private StuTool myTool;
    private Scanner mySc;

    StuController() {
        myTool = new StuTool();
        mySc = new Scanner(System.in);
        init();
        selection();
    }


    void init() {
        stuList.add(new Student("041701", "学生5号", "20170005", 18, "男", maxIndex++));
        stuList.add(new Student("041701", "学生3号", "20170003", 18, "女", maxIndex++));
        stuList.add(new Student("041702", "学生6号", "20170006", 19, "女", maxIndex++));
        stuList.add(new Student("041701", "学生2号", "20170002", 19, "男", maxIndex++));
        stuList.add(new Student("041701", "学生4号", "20170004", 17, "男", maxIndex++));
        stuList.add(new Student("041702", "学生1号", "20170001", 20, "男", maxIndex++));
    }

    void showWelcome() {
        System.out.println(DIVIDE_LINE);
        System.out.println("请输入操作！");
        System.out.println("1：增加学生");
        System.out.println("2：删除学生");
        System.out.println("3：按学号遍历（升序）");
        System.out.println("4：按学号遍历（降序）");
        System.out.println("5：先按班级再按学号遍历（升序）");
        System.out.println("6：先按班级再按学号遍历（降序）");
        System.out.println("7：写入文件studentinfo_COPY.txt");
        System.out.println("8：读取文件studentinfo.txt");
        System.out.println("0：exit");
        System.out.println(DIVIDE_LINE);
    }

    void selection() {
        while (true) {
            showWelcome();
            int mySele;
            mySele = Integer.parseInt(mySc.nextLine());
            switch (mySele) {
                case 1:
                    addStu();
                    break;
                case 2:
                    delStu();
                    break;
                case 3:
                    myTool.sortByNum(stuList, true, true);
                    break;
                case 4:
                    myTool.sortByNum(stuList, false, true);
                    break;
                case 5:
                    myTool.sortByClassThenNum(stuList, true, true);
                    break;
                case 6:
                    myTool.sortByClassThenNum(stuList, false, true);
                    break;
                case 7:
                    myTool.writeToFile(stuList);
                    break;
                case 8:
                    stuList.clear();
                    stuList.addAll(myTool.readToFile());
                    break;
                case 0:
                    System.exit(0);
                    break;

            }
            //mySc.close();
        }
    }

    void addStu() {
        String clas;
        String name;
        String stuNum;
        int age;
        String gender;
        int id;
        System.out.println("请输入班级号");
        String temp = mySc.nextLine();
        clas = temp;
        System.out.println("请输入姓名");
        temp = mySc.nextLine();
        name = temp;
        System.out.println("请输入学号");
        temp = mySc.nextLine();
        stuNum = temp;
        System.out.println("请输入年龄");
        temp = mySc.nextLine();
        age = Integer.parseInt(temp);
        System.out.println("请输入性别(男为1 女为0)");
        temp = mySc.nextLine();
        if (temp.equals("1")) {
            gender = "男";
            stuList.add(new Student(clas, name, stuNum, age, gender, maxIndex++));
            System.out.println("ADD OVER");
        } else if (temp.equals("0")) {
            gender = "女";
            stuList.add(new Student(clas, name, stuNum, age, gender, maxIndex++));
            System.out.println("ADD OVER");
        } else {
            System.out.println("输入错误！");
        }
        //mySc.close();
    }

    void delStu() {
        myTool.print(stuList, true);
        System.out.println("已按学号升序遍历！请输入要删除学生的ID！");
        int id = Integer.parseInt(mySc.nextLine());
        Iterator<Student> iter = stuList.iterator();
        while (iter.hasNext()) {
            if (iter.next().getId() == id) {
                iter.remove();
                break;
            }
        }
        //mySc.close();
    }
}
