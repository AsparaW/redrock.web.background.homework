
import java.io.IOException;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) {

        try {
            Student myStu[]=FileUtil.parseStudents("students.txt");
            HashMap<String ,Integer> map=new HashMap();
            int max=1;
            String maxName="";
            for (Student temp:myStu){
                boolean flag=false;
                String tempName=temp.getName();
                if (map.containsKey(tempName)){
                    int now=map.get(tempName);
                    now++;
                    map.put(tempName,now);
                    if (now>max){
                        max=now;
                        maxName=tempName;
                    }
                }else {
                    map.put(tempName,1);
                }
            }
            System.out.println(maxName+" "+max+"次");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static Student biSearch(Student[] array, int a) {
        int lo = 0;
        int hi = array.length - 1;
        int mid;
        while (lo <= hi) {
            mid = (lo + hi) / 2;
            if (Integer.parseInt(array[mid].getStuid()) == a) {
                return array[mid];
            } else if (Integer.parseInt(array[mid].getStuid()) < a) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return null;
    }

}
