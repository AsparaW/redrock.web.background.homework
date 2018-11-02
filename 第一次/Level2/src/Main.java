public class Main {

    public static void main(String[] args) {
        Animal chick = new Animal(1, 0.1, "无名鸡");
        Bird bird = new Bird(1, 2, "无名鸟");
        Fish fish = new Fish(3, 10, "无名鱼");
        Human man = new Human(20, 60, "无名人");
        chick.RunAll();
        bird.RunAll();
        fish.RunAll();
        man.RunAll();
    }
}
