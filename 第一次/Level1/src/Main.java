public class Main {
    public static final String sample = "acbdw,1269547,AASIDX,AIUydjs,12sjaA,3819247,ausSHSzio,IUFISsi";

    public static void main(String[] args) {
        StrController myStrController = new StrController(sample);
        myStrController.runAllTests();
    }
}
