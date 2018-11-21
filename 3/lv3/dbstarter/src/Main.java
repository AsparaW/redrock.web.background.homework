import java.sql.Connection;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {
        Connection con = JDBCUtil.getConnection();
        DBTool myDB = new DBTool(con);
        try {
            myDB.createTable();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.close(myDB.getRs(),myDB.getStatement(),myDB.getCon());
        }

        //

        //

    }
}
