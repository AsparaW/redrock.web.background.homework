package permission;

import character.CharAbstract;

public class CheckPermission {
    private static CheckPermission instance = new CheckPermission();
    private CheckPermission(){
    }
    boolean Check(CharAbstract a, String b){
return true;
    }
    public static CheckPermission getInstance(){
        return  instance;
    }
}
