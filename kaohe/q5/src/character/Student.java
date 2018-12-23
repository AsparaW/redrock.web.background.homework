package character;

import item.Item;

public class Student extends CharAbstract {

    public Student(String name, String id){
        super(name,id);
    }
    public void buyItem(Item item){
        if (super.score<item.getPrice()){
            System.out.println(name +"余额不足  金钱 :" +super.score +"  需要 :"+item.getPrice());
        }else {
            this.addItem(item);
            this.setScore(this.getScore()-item.getPrice());
        }

    }
}
