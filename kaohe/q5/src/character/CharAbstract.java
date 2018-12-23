package character;

import item.Item;
import item.ItemAbstract;

import java.util.ArrayList;

public abstract class CharAbstract {
    String id;
    String name;
    int score;
    ArrayList<Item> itemList=new ArrayList<>();
    CharAbstract(String name,String id){
        this.name=name;
        this.id=id;
    }
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void addItem(Item item){
        this.itemList.add(item);
    }
    public ArrayList<? extends ItemAbstract> getItemList() {
        return itemList;
    }
    public void printList(){
        System.out.println(name +"的物品:");
        for (Item temp :itemList){
            System.out.println(temp.getName()+" price :"+temp.getPrice());
        }
    }
    public void printScore(){
        System.out.println(name + "的积分 :"+ getScore());
    }
}
