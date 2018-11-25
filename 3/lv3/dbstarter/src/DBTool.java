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
        inittable();
    }

    // 建表

    public void insertCourse(String id, String name, String type, String status, String mode, String teacher, String info) throws SQLException {
        String sql1 = "insert into course(id,name,type,status,mode,teacher,info)" + "values(?,?,?,?,?,?,?)";
        PreparedStatement pre = con.prepareCall(sql1);
        pre.setString(1, id);
        pre.setString(2, name);
        pre.setString(3, type);
        pre.setString(4, status);
        pre.setString(5, mode);
        pre.setString(6, teacher);
        pre.setString(7, info);
        pre.executeUpdate();
    }

    public void inittable() throws SQLException {
        for (int i = 1; i <= 6; i++) {
            String sql = "insert into ctable(_time,id,w1,w2,w3,w4,w5,w6,w7)" + "values(?,?,?,?,?,?,?,?,?)";
            PreparedStatement pre = con.prepareCall(sql);
            String content = Integer.toString(i * 2 - 1) + "-" + Integer.toString(i * 2);
            pre.setString(1, content);
            pre.setInt(2, i);
            pre.setString(3, "");
            pre.setString(4, "");
            pre.setString(5, "");
            pre.setString(6, "");
            pre.setString(7, "");
            pre.setString(8, "");
            pre.setString(9, "");

            pre.executeUpdate();
        }

    }
    //插入数据


    public void print(String dbname, String... argu) throws SQLException {
        int len = argu.length;
        String info[] = new String[len];
        if (len == 0) {
            return;
        }
        String sql = "select ";
        for (int i = 0; i < len; i++) {
            sql = sql + argu[i];
            if (i != len - 1) {
                sql = sql + ",";
            }
        }
        sql = sql + " from ?";
        PreparedStatement pre = con.prepareCall(sql);
        pre.setString(1, dbname);
        rs = pre.executeQuery();
        while (rs.next()) {
            for (int i = 0; i < len; i++) {
                info[i] = rs.getString(i);
                System.out.print(argu[i] + " = " + info[i] + "  ");
            }
//            System.out.println(info);
        }
    }

    public void print2(String dbName, int id) throws SQLException {
        String sql = " select * from " + dbName + " where id = ? ";
        PreparedStatement pre = con.prepareCall(sql);
        pre.setInt(1, id);
        rs = pre.executeQuery();
        int con = rs.getMetaData().getColumnCount();
        while (rs.next()) {
            for (int i = 1; i <= con; i++) {
                System.out.println(rs.getMetaData().getColumnName(i) + "    " + rs.getString(i) + "      ");
            }
        }
    }


    public void change(String dbName, int id, String toName, String tbName, boolean isReserve) throws SQLException {
        String sql = "SELECT " + tbName + " FROM " + dbName + " WHERE id LIKE ?";
        PreparedStatement pre = con.prepareCall(sql);
        pre.setInt(1, id);
        rs = pre.executeQuery();
        String before = "";
        while (rs.next()) {
            before = rs.getString(tbName);
        }
        sql = "update " + dbName + " set " + tbName + " = ?  where id = ?";
        pre = con.prepareCall(sql);
        if (isReserve && !before.equals("")) {
            toName = before + "," + toName;
        }
        pre.setString(1, toName);
        pre.setInt(2, id);
        pre.executeUpdate();
    }


    public void delete(int id, String dbName) throws SQLException {
        System.out.println("删除" + dbName + " 里 id=" + id + "的项");
        String sql = "delete from " + dbName + " where id = ?";
        PreparedStatement pre = con.prepareCall(sql);
        //pre.setString(1, dbName);
        pre.setInt(1, id);
        pre.executeUpdate();
    }


    public void search(String name, String dbName) throws SQLException {
        System.out.println("在 " + dbName + " 里查询" + name + "项");
        String sql = "SELECT id FROM " + dbName + " WHERE name LIKE ?";
        PreparedStatement pre = con.prepareCall(sql);
        pre.setString(1, name);
        rs = pre.executeQuery();
        if (rs.getMetaData().getColumnCount() == 0) {
            System.out.println("未找到！");
            return;
        }
        while (rs.next()) {
            String id = rs.getString("id");
            print2(dbName, Integer.parseInt(id));
        }
    }


    public void search2(String name, String dbName) throws SQLException {
        System.out.println("在 " + dbName + " 里模糊查询" + name + "项");
        String sql = "SELECT * FROM " + dbName + " WHERE name LIKE \"%\"?\"%\"";
        PreparedStatement pre = con.prepareCall(sql);
        pre.setString(1, name);
        rs = pre.executeQuery();
        if (rs.getMetaData().getColumnCount() == 0) {
            System.out.println("未找到！");
            return;
        }
        while (rs.next()) {
            System.out.println("ID: " + rs.getInt("id") + rs.getString("name"));
        }
    }

    public void order(String dbName, String cName, boolean isAsc) throws SQLException {
        String order = " desc";
        if (isAsc) {
            order = " asc";
        }
        String sql = "select * from " + dbName + " order by " + cName + order;
        PreparedStatement pre = con.prepareCall(sql);
        // pre.setString(1,cName);
        System.out.println("按照" + cName + "  " + order + "排序");
        rs = pre.executeQuery();
        int con = rs.getMetaData().getColumnCount();
        while (rs.next()) {
            for (int i = 1; i <= con; i++) {
                System.out.println(rs.getMetaData().getColumnName(i) + "    " + rs.getString(i) + "      ");
            }
        }
    }
}
