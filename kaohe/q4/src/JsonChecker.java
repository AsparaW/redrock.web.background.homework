
public class JsonChecker {
    private static final JsonChecker instance =new JsonChecker();
    private JsonChecker(){

    }
    public boolean check(String json){
        String Left="";
        int length = json.length();
        for (int i =0;i<length;i++){
            char temp = json.charAt(i);
            if (temp=='{'||temp=='['){
                Left=Left+temp;
            }else if (temp=='}'){
                if (Left.charAt(Left.length()-1)=='{'){
                    Left=Left.substring(0,Left.length()-1);
                }else {
                    return false;
                }
            }else if (temp==']'){
                if (Left.charAt(Left.length()-1)=='['){
                    Left=Left.substring(0,Left.length()-1);
                }else {
                    return false;
                }
            }
        }
        if (Left.equals("")){
            return true;
        }else {
            return false;
        }
    }
    public static JsonChecker getInstance(){
        return instance;
    }
}
