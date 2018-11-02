public class Human extends Animal {
    private int age;
    private double weight;
    private String name = "";

    Human(int age, double weight, String name) {
        super(age, weight, name);
        this.age = age;
        this.weight = weight;
        this.name = name;

    }

    public void Run() {
        System.out.println(name + "在奔跑");
    }

    public void Action() {
        System.out.println(name + "在学习");
    }

    public void RunAll() {
        System.out.println("name = " + name);
        System.out.println("age = " + age);
        System.out.println("weight = " + weight + "kg");
        Action();
        Run();
        Play();
        Eat(3);
    }
}
