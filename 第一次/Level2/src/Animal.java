public class Animal {
    private int age;
    private double weight;
    private String name = "";

    Animal(int age, double weight, String name) {
        this.age = age;
        this.weight = weight;
        this.name = name;
    }

    Animal() {
    }

    protected void Action() {
        System.out.println(name + "在发呆");
    }

    protected void Eat(double a) {
        System.out.println(this.name + "吃了" + a + "kg食物");
    }

    protected void Play() {
        System.out.println(this.name + "在玩耍");
    }

    protected Animal Test() {
        return new Animal(this.age, this.weight, this.name);
    }

    protected void RunAll() {
        System.out.println("name = " + name);
        System.out.println("age = " + age);
        System.out.println("weight = " + weight + "kg");
        Action();
        Play();
        Eat(0.1);
    }
}
