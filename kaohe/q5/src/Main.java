import character.CharAbstract;
import character.Elder;
import character.Student;
import item.Item;
import scoresystem.ScoreManager;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        HashMap<String,? super CharAbstract> character =new HashMap<>();
        character.put("学长1号",new Elder("学长1号","201701"));
        character.put("学长2号",new Elder("学长2号","201702"));
        character.put("学员1号",new Student("学员1号","201801"));
        character.put("学员2号",new Student("学员2号","201802"));
        character.put("学员3号",new Student("学员3号","201803"));

        ScoreManager.getInstance().addItem(new Item("矿泉水",1));
        ScoreManager.getInstance().addItem(new Item("mp3",100));
        ScoreManager.getInstance().addItem(new Item("U盘",30));
        ScoreManager.getInstance().printItem();

        Object a  =character.get("学长1号");
        Object b = character.get("学员1号");
        ((Student) b).buyItem(ScoreManager.getInstance().getItemList().get(0));
        ((Student) b).printList();
        ((Student) b).printScore();
        character.replace(((Student) b).getName(),(Student)b);
         b = character.get("学员1号");
        ((Elder) a).giveScore((Student)b,100);
        character.replace(((Student) b).getName(),(Student)b);
        b = character.get("学员1号");
        ((Student) b).buyItem(ScoreManager.getInstance().getItemList().get(0));
        character.replace(((Student) b).getName(),(Student)b);
        b =character.get("学员1号");
        ((Student) b).printList();
        ((Student) b).printScore();
    }
}
