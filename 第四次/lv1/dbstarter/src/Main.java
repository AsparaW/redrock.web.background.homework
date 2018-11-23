import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;

public class Main {

    Connection con ;
    Statement statement;
    ResultSet rs;


    public Connection getCon() {
        return con;
    }

    public ResultSet getRs() {
        return rs;
    }

    public Statement getStatement() {
        return statement;
    }


    public  Main (Connection con){
        this.con = con;
        try {
            statement = con.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void createTable() throws SQLException {
        String sql = "create table if not exists students(id int,name varchar(100),age int,primary key(id))";
        statement.executeUpdate(sql);
        sql  = "delete from students";
        statement.executeUpdate(sql);
    }

    public void insert() throws SQLException {
        String sql1 = "insert into students(id,name,age)" +"values(?,?,?)" ;
        PreparedStatement pre = con.prepareCall(sql1);
        pre.setString(1,"1");
        pre.setString(2,"小明");
        pre.setString(3,"18");
        pre.executeUpdate();
        pre.setString(1,"2");
        pre.setString(2,"小红");
        pre.setString(3,"19");
        pre.executeUpdate();
        pre.setString(1,"3");
        pre.setString(2,"小刚");
        pre.setString(3,"22");
        pre.executeUpdate();
        }
    public void select() throws SQLException {
        String sql ="select id,name,age from students";
        rs=statement.executeQuery(sql);
        while (rs.next()){
            String id =rs.getString("id");
            String name= rs.getString("name");
            String age = rs.getString("age");
            System.out.println("Index：" + id +"  姓名："+ name + "  年龄："+age);
        }
    }
public void delete() throws SQLException {
        String sql  = "delete from students where id = 2";
        statement.executeUpdate(sql);
}
    public static void main(String[] args) {
        Connection con = JDBCUtil.getConnection();
        Main main = new Main(con);
        try {
            main.createTable();
            main.insert();
            main.select();
            main.delete();
            System.out.println("删除后");
            main.select();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.close(main.getRs(),main.getStatement(),main.getCon());
        }

    }
}
