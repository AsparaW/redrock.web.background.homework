import bean.Student;

import java.util.ArrayList;

public class Data {
    private static final Data instance = new Data();
    ArrayList<Student> myList = new ArrayList<>();
    private Data(){
        Student test = new Student();
        test.setStuid("2017212030");
        test.setAcademy("计算机");
        test.setClazz("04051702");
        test.setName("钟明翰");
        myList.add(test);
    }

    public String findById(String stuid){
        for (Student temp:myList){
            if (temp.getStuid().equals(stuid)){
                return temp.getStuid()+" "+temp.getAcademy()+" "+temp.getClazz()+" "+temp.getName();
            }
        }
        return "not found";
    }
    public String findByName(String name){
        for (Student temp:myList){
            if (temp.getName().equals(name)){
                return temp.getStuid()+" "+temp.getAcademy()+" "+temp.getClazz()+" "+temp.getName();
            }
        }
        return "not found";
    }
    public String findByClass(String clazz){
        for (Student temp:myList){
            if (temp.getClazz().equals(clazz)){
                return temp.getStuid()+" "+temp.getAcademy()+" "+temp.getClazz()+" "+temp.getName();
            }
        }
        return "not found";
    }
    public String findByAcademy(String academy){
        for (Student temp:myList){
            if (temp.getAcademy().equals(academy)){
                return temp.getStuid()+" "+temp.getAcademy()+" "+temp.getClazz()+" "+temp.getName();
            }
        }
        return "not found";
    }
    public static Data getInstance() {
        return instance;
    }
}
