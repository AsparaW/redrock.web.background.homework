import java.sql.Connection;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {
        Connection con = JDBCUtil.getConnection();
        DBTool myDB = new DBTool(con);
        try {
            DBController myController = new DBController(myDB);
            myDB.createTable();
            myController.Dealer();// 处理操作
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(myDB.getRs(), myDB.getStatement(), myDB.getCon());
        }

        //

        //

    }
}
