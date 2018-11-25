import java.sql.Connection;
import java.sql.SQLException;

public class Main {

    private static final String DEFAULT = "http://jwzx.cqupt.edu.cn/kebiao/kb_stu.php?xh=2017212030";

    public static void main(String[] args) {
        Connection con = JDBCUtil.getConnection();
        DBTool myDB = new DBTool(con);
        try {
            DBController myController = new DBController(myDB);
            myDB.createTable();
            URLHelper defaultHelper = new URLHelper();
            HTMLResolve myRes = new HTMLResolve(defaultHelper.start(DEFAULT));
            myController.Dealer();// 处理数据库操作

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(myDB.getRs(), myDB.getStatement(), myDB.getCon());
        }

        //

        //

    }
}
