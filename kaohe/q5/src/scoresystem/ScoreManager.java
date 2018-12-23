package scoresystem;

import item.Item;

import java.util.ArrayList;

public class ScoreManager {
    private static  ScoreManager instance = new ScoreManager();

    ArrayList<Item> itemList = new ArrayList();
    private ScoreManager(){

    }
    public static ScoreManager getInstance(){
        return instance;
    }
    public void addItem(Item item){
        itemList.add(item);
    }

    public ArrayList<Item> getItemList() {
        return itemList;
    }

    public void printItem(){
        for (Item temp:itemList){
            System.out.println("物品："+temp.getName() +" price = "+temp.getPrice());
        }
    }
}
