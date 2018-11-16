import java.io.Serializable;

public class Student implements Serializable {
    private String name;
    private int age;
    private String stuNum;
    private String gender;
    private String clas;
    private int id;

    Student(String clas, String name, String stuNum, int age, String gender, int id) {
        this.clas = clas;
        this.name = name;
        this.stuNum = stuNum;
        this.age = age;
        this.gender = gender;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }


    public int getAge() {
        return age;
    }

    public String getStuNum() {
        return stuNum;
    }

    public String getGender() {
        return gender;
    }

    public String getClas() {
        return clas;
    }
}
