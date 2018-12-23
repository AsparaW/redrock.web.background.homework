package character;

import item.Item;
import item.ItemAbstract;

public class Elder extends CharAbstract {
    public Elder(String name, String id){
        super(name,id);
    }
    public void giveScore(CharAbstract object,int add){
        System.out.println("给"+ object.getName()+ " "+add+"分");
        object.setScore(object.getScore()+add);
    }
    public void giveItem(CharAbstract object, Item item){
        object.addItem(item);
    }
}
