import java.util.ArrayList;

public class StrController {
    private static final String STRING_FAULT = "操作失败";
    private String model;
    //private ArrayList<String> strs=new ArrayList();
    private int length;
    private String[] strs;

    StrController(String model) {
        this.model = model;
        strs = model.split(",");
        length = strs.length;
    }

    public static void sort(ArrayList<Integer> arr) {
        int length = arr.size();
        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - i - 1; j++) {
                if (arr.get(j) > arr.get(j + 1)) {
                    int temp = arr.get(j);
                    arr.remove(j);
                    arr.add(j, arr.get(j));
                    arr.remove(j + 1);
                    arr.add(j + 1, temp);
                }
            }
        }
    }

    public static void sortChar(ArrayList<Character> arr) {
        int length = arr.size();
        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - i - 1; j++) {

                if (arr.get(j) > arr.get(j + 1)) {
                    char temp = arr.get(j);
                    arr.remove(j);
                    arr.add(j, arr.get(j));
                    arr.remove(j + 1);
                    arr.add(j + 1, temp);
                }
            }
        }
    }

    void runAllTests() {
        System.out.println("原串 = " + model);
        int round = this.length;
        for (int i = 0; i < round; i++) {
            System.out.println("当前：" + strs[i]);
            System.out.println("方法一：判断字符串是否全是数字");
            System.out.println(strs[i] + "全是数字吗？  " + Boolean.toString(isNumric(strs[i])));
            System.out.println("方法二：判断字符串是否是大写字母");
            System.out.println(strs[i] + "全是大写字母吗？    " + Boolean.toString(isAllUpper(strs[i])));
            System.out.println("方法三：判断字符串是否全是小写字母");
            System.out.println(strs[i] + "全是小写字母吗？    " + Boolean.toString(isAllLower(strs[i])));
            System.out.println("方法四：如果字符串全是字母，将其中所有小写字母转换为大写字母");
            System.out.println(strs[i] + "<---->" + toUpper(strs[i]));
            System.out.println("方法五：如果字符串全是数字组成，则按照数字大小升序排序并装入整型数组中。最后按升序打印出该数组");
            System.out.println(strs[i] + "<---->" + sortNum(strs[i]));
            System.out.println("方法六：如果字符串全是字母组成，则按照字母排序装入字符数组中，并按字母顺序打印出该该数组。");
            System.out.println("字典序：" + strs[i] + "<---->" + sortChar(strs[i]));
            System.out.println("字母：" + strs[i] + "<---->" + sortChar(toUpper(strs[i])));
            System.out.println();
        }
    }

    boolean isNumric(String model) {
        int length = model.length();
        for (int i = 0; i < length; i++) {
            char nowChar = model.charAt(i);
            if (nowChar < 48 || nowChar > 57)
                return false;
        }
        return true;
    }

    boolean isAllLower(String model) {
        int length = model.length();
        for (int i = 0; i < length; i++) {
            char nowChar = model.charAt(i);
            if (nowChar < 97 || nowChar > 122)
                return false;
        }
        return true;
    }

    boolean isAllUpper(String model) {
        int length = model.length();
        for (int i = 0; i < length; i++) {
            char nowChar = model.charAt(i);
            if (nowChar < 65 || nowChar > 90)
                return false;
        }
        return true;
    }

    boolean isAllAlpha(String model) {
        int length = model.length();
        for (int i = 0; i < length; i++) {
            char nowChar = model.charAt(i);
            if (!((nowChar >= 97 && nowChar <= 122) || (nowChar >= 65 && nowChar <= 90)))
                return false;
        }
        return true;
    }

    String toUpper(String model) {
        if (!isAllAlpha(model))
            return STRING_FAULT;
        String newStr = "";
        int length = model.length();
        for (int i = 0; i < length; i++) {
            char nowChar = model.charAt(i);
            if (nowChar >= 97 && nowChar <= 122) {
                nowChar -= 32;
            }

            newStr = newStr + nowChar;
        }
        return newStr;
    }

    String sortNum(String model) {
        if (!isNumric(model))
            return STRING_FAULT;
        ArrayList nums = new ArrayList();
        String newStr = "";
        int length = model.length();
        for (int i = 0; i < length; i++) {
            String newChar = Character.toString(model.charAt(i));
            nums.add(Integer.parseInt(newChar));
        }
        sort(nums);
        return "nums = " + nums;
    }

    String sortChar(String model) {
        if (!isAllAlpha(model))
            return STRING_FAULT;
        ArrayList<Character> chars = new ArrayList();
        String newStr = "";
        int length = model.length();
        for (int i = 0; i < length; i++) {
            chars.add(model.charAt(i));
        }
        sortChar(chars);
        return "chars = " + chars;
    }

}
