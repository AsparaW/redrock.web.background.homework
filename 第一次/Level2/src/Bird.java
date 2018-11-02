public class Bird extends Animal {
    private int age;
    private double weight;
    private String name = "";

    Bird(int age, double weight, String name) {
        super(age, weight, name);
        this.age = age;
        this.weight = weight;
        this.name = name;
    }

    public void Sing() {
        System.out.println(name + "在唱歌");
    }

    public void Action() {
        System.out.println(name + "在飞");
    }

    public void RunAll() {
        System.out.println("name = " + name);
        System.out.println("age = " + age);
        System.out.println("weight = " + weight + "kg");
        Action();
        Sing();
        Play();
        Eat(0.05);
    }

    protected Bird Test() {
        return new Bird(age, weight, name);
    }
}
