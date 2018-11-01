public class Person {
    String name, gender;
    double faceValue;
    int height, weight, bodyPrice;

    Person(String name, int isMan, int height, int weight, double faceValue, int bodyPrice) {
        this.name = name;
        this.gender = isMan == 1 ? "Male" : "Female";
        this.height = height;
        this.weight = weight;
        this.faceValue = faceValue;
        this.bodyPrice = bodyPrice;
        Print();
    }

    Person() {
        this.name = "Stranger";
        this.gender = "mysterious";
        this.height = 180;
        this.weight = 65;
        this.faceValue = 9.5;
        this.bodyPrice = 50000;
        Print();
    }

    void Print() {
        System.out.println("json {  name:\"" + name + "\", gender:\"" + gender + "\", height:\"" + height + "\", weight:\"" + weight + "\", faceValue:\"" + faceValue + "\", bodyPrice:\"" + bodyPrice + "\" }");
    }
}
