public class Fish extends Animal {
    private int age;
    private double weight;
    private String name = "";

    Fish(int age, double weight, String name) {
        super(age, weight, name);
        this.age = age;
        this.weight = weight;
        this.name = name;

    }

    public void Swim() {
        System.out.println(name + "在游泳");
    }

    public void Action() {
        System.out.println(name + "在跳水");
    }

    public void RunAll() {
        System.out.println("name = " + name);
        System.out.println("age = " + age);
        System.out.println("weight = " + weight + "kg");
        Action();
        Swim();
        Play();
        Eat(0.5);
    }
}
