package DaoTool;
import java.net.URL;
import java.sql.*;


public class DBTool {
    Connection con;
    Statement statement;
    ResultSet rs;


    public DBTool(Connection con) {
        this.con = con;
        try {
            statement = con.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getCon() {
        return con;
    }

    public ResultSet getRs() {
        return rs;
    }

    public Statement getStatement() {
        return statement;
    }

    public void createTable() throws SQLException {
        String sql = "create table if not exists course(id varchar(100),name varchar(100),type varchar(10),status varchar(10),mode varchar(20),teacher varchar(20),info varchar(400),primary key(id))";
        statement.executeUpdate(sql);
        sql = "create table if not exists ctable(id int ,_time varchar(10),w1 varchar(100) not null,w2 varchar(100) not null,w3 varchar(100) not null,w4 varchar(100) not null,w5 varchar(100) not null,w6 varchar(100) not null,w7 varchar(100) not null)";
        statement.executeUpdate(sql);
        //CREATE OVER
        // RELATIONS CREATE OVER
        sql = "delete from course";
        statement.executeUpdate(sql);
        sql = "delete from ctable";
        statement.executeUpdate(sql);

    }

    public void search(String dbName) throws SQLException {
        String sql = "SELECT id FROM " + dbName ;
        PreparedStatement pre = con.prepareCall(sql);
        rs = pre.executeQuery();
        if (rs.getMetaData().getColumnCount() == 0) {
            return;
        }
        while (rs.next()) {
            String id = rs.getString("number");
            String rec= URLHelper.start("http://120.79.143.238/cqupt/query?search="+id);

        }
    }



}
