package bean;

public class Student {
    String name;
    String stuid;
    String clazz;
    String academy;

    public String getName() {
        return name;
    }

    public String getStuid() {
        return stuid;
    }

    public String getClazz() {
        return clazz;
    }

    public String getAcademy() {
        return academy;
    }

    public void setAcademy(String academy) {
        this.academy = academy;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStuid(String stuid) {
        this.stuid = stuid;
    }
}
