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
        String sql = "create table if not exists department(id int,name varchar(100),cash int,primary key(id))";
        statement.executeUpdate(sql);
        sql = "create table if not exists manager(id int,name varchar(100),address varchar(100),contact varchar(100),primary key(id))";
        statement.executeUpdate(sql);
        sql = "create table if not exists employee(id int,name varchar(100),age int,address varchar(100),contact varchar(100),job varchar(100),primary key(id))";
        statement.executeUpdate(sql);
        sql = "create table if not exists goods(id int,name varchar(100),selling_price decimal(10,2),purchasing_price decimal(10,2),primary key(id))";
        statement.executeUpdate(sql);
        sql = "create table if not exists supplier(id int,name varchar(100),contact varchar(100),tel varchar(20),primary key(id))";
        statement.executeUpdate(sql);
        sql = "create table if not exists storage(id int,name varchar(100),contact varchar(100),primary key(id))";
        statement.executeUpdate(sql);
        //CREATE OVER
        // RELATIONSHIPS
        sql = "create table if not exists depart_manager_relation(id int UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,department_id int,manager_id int)";
        statement.executeUpdate(sql);
        sql = "create table if not exists depart_employee_relation(id int UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,department_id int,employee_id int)";
        statement.executeUpdate(sql);
        sql = "create table if not exists depart_goods_relation(id int UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,department_id int,goods_id int)";
        statement.executeUpdate(sql);
        sql = "create table if not exists goods_supplier_relation(id int UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,goods_id int,supplier_id int)";
        statement.executeUpdate(sql);
        sql = "create table if not exists goods_storage_relation(id int UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,goods_id int,storage_id int)";
        statement.executeUpdate(sql);
        // RELATIONS CREATE OVER
        sql = "delete from department";
        statement.executeUpdate(sql);
        sql = "delete from manager";
        statement.executeUpdate(sql);
        sql = "delete from employee";
        statement.executeUpdate(sql);
        sql = "delete from goods";
        statement.executeUpdate(sql);
        sql = "delete from supplier";
        statement.executeUpdate(sql);
        sql = "delete from storage";
        statement.executeUpdate(sql);
        sql = "delete from depart_manager_relation";
        statement.executeUpdate(sql);
        sql = "delete from depart_employee_relation";
        statement.executeUpdate(sql);
        sql = "delete from depart_goods_relation";
        statement.executeUpdate(sql);
        sql = "delete from goods_supplier_relation";
        statement.executeUpdate(sql);
        sql = "delete from goods_storage_relation";
        statement.executeUpdate(sql);
    }

    // 建表

    public void insertDepart(int id, String name, int cash) throws SQLException {
        String sql1 = "insert into department(id,name,cash)" + "values(?,?,?)";
        PreparedStatement pre = con.prepareCall(sql1);
        pre.setInt(1, id);
        pre.setString(2, name);
        pre.setInt(3, cash);
        pre.executeUpdate();
    }

    public void insertManager(int id, String name, String contact, String address) throws SQLException {
        String sql1 = "insert into manager(id,name,address,contact)" + "values(?,?,?,?)";
        PreparedStatement pre = con.prepareCall(sql1);
        pre.setInt(1, id);
        pre.setString(2, name);
        pre.setString(3, address);
        pre.setString(4, contact);
        pre.executeUpdate();
    }

    public void insertEmployee(int id, String name, int age, String address, String contact, String job) throws SQLException {
        String sql1 = "insert into employee(id,name,age,address,contact,job)" + "values(?,?,?,?,?,?)";
        PreparedStatement pre = con.prepareCall(sql1);
        pre.setInt(1, id);
        pre.setString(2, name);
        pre.setInt(3, age);
        pre.setString(4, address);
        pre.setString(5, contact);
        pre.setString(6, job);
        pre.executeUpdate();
    }

    public void insertGoods(int id, String name, double sellingPrice, double purchasingPrice) throws SQLException {
        String sql1 = "insert into goods(id,name,selling_price,purchasing_price)" + "values(?,?,?,?)";
        PreparedStatement pre = con.prepareCall(sql1);
        pre.setInt(1, id);
        pre.setString(2, name);
        pre.setDouble(3, sellingPrice);
        pre.setDouble(4, purchasingPrice);
        pre.executeUpdate();
    }

    public void insertSupplier(int id, String name, String contact, String tel) throws SQLException {
        String sql1 = "insert into supplier(id,name,contact,tel)" + "values(?,?,?,?)";
        PreparedStatement pre = con.prepareCall(sql1);
        pre.setInt(1, id);
        pre.setString(2, name);
        pre.setString(3, contact);
        pre.setString(4, tel);
        pre.executeUpdate();
    }

    public void insertStorage(int id, String name, String contact) throws SQLException {
        String sql1 = "insert into Storage(id,name,contact)" + "values(?,?,?)";
        PreparedStatement pre = con.prepareCall(sql1);
        pre.setInt(1, id);
        pre.setString(2, name);
        pre.setString(3, contact);
        pre.executeUpdate();
    }


    public void departManagerRelation(int left, int right) throws SQLException {
        String sql1 = "insert into depart_manager_relation(department_id,manager_id)" + "values(?,?)";
        PreparedStatement pre = con.prepareCall(sql1);
        pre.setInt(1, left);
        pre.setInt(2, right);
        pre.executeUpdate();
    }

    public void departEmployeeRelation(int left, int right) throws SQLException {
        String sql1 = "insert into depart_employee_relation(department_id,employee_id)" + "values(?,?)";
        PreparedStatement pre = con.prepareCall(sql1);
        pre.setInt(1, left);
        pre.setInt(2, right);
        pre.executeUpdate();
    }

    public void departGoodsRelation(int left, int right) throws SQLException {
        String sql1 = "insert into depart_goods_relation(department_id,goods_id)" + "values(?,?)";
        PreparedStatement pre = con.prepareCall(sql1);
        pre.setInt(1, left);
        pre.setInt(2, right);
        pre.executeUpdate();
    }

    public void goodsSupplierRelation(int left, int right) throws SQLException {
        String sql1 = "insert into goods_supplier_relation(goods_id,supplier_id)" + "values(?,?)";
        PreparedStatement pre = con.prepareCall(sql1);
        pre.setInt(1, left);
        pre.setInt(2, right);
        pre.executeUpdate();
    }

    public void goodsStorageRelation(int left, int right) throws SQLException {
        String sql1 = "insert into goods_storage_relation(goods_id,storage_id)" + "values(?,?)";
        PreparedStatement pre = con.prepareCall(sql1);
        pre.setInt(1, left);
        pre.setInt(2, right);
        pre.executeUpdate();
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


    public void change(String dbName, int id, String toName, String tbName) throws SQLException {

        String sql = "update " + dbName + " set " + tbName + " = ?  where id = ?";
        PreparedStatement pre = con.prepareCall(sql);
        pre.setString(1, toName);
        pre.setInt(2, id);
        pre.executeUpdate();
    }


    public void delete(int id, String dbName) throws SQLException {
        System.out.println("删除"+dbName+" 里 id="+id+"的项");
        String sql = "delete from " + dbName + " where id = ?";
        PreparedStatement pre = con.prepareCall(sql);
        //pre.setString(1, dbName);
        pre.setInt(1, id);
        pre.executeUpdate();
    }


    public void search(String name, String dbName) throws SQLException {
        System.out.println("在 "+dbName+" 里查询" +name+ "项");
        String sql = "SELECT id FROM " + dbName + " WHERE name LIKE ?";
        PreparedStatement pre = con.prepareCall(sql);
        pre.setString(1, name);
        rs = pre.executeQuery();
        if (rs.getMetaData().getColumnCount()==0){
            System.out.println("未找到！");
            return;
        }
        while (rs.next()) {
            String id = rs.getString("id");
            print2(dbName, Integer.parseInt(id));
        }
    }


    public void search2(String name, String dbName) throws SQLException {
        System.out.println("在 "+dbName+" 里模糊查询" +name+ "项");
        String sql = "SELECT * FROM " + dbName + " WHERE name LIKE \"%\"?\"%\"";
        PreparedStatement pre = con.prepareCall(sql);
        pre.setString(1, name);
        rs = pre.executeQuery();
        if (rs.getMetaData().getColumnCount()==0){
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
