import java.nio.charset.IllegalCharsetNameException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBTool {
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


    public DBTool(Connection con){
        this.con = con;
        try {
            statement = con.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
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
        sql = "create table if not exists storage(id int,manager_name varchar(100),contact varchar(100),primary key(id))";
        statement.executeUpdate(sql);
        //CREATE OVER
        // RELATIONSHIPS
        sql = "create table if not exists depart_manager_relation(id int UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,department_id int,manager_id int,primary key(id))";
        statement.executeUpdate(sql);
        sql = "create table if not exists depart_employee_relation(id int UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,department_id int,employee_id int,primary key(id))";
        statement.executeUpdate(sql);
        sql = "create table if not exists depart_goods_relation(id int UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,department_id int,goods_id int,primary key(id))";
        statement.executeUpdate(sql);
        sql = "create table if not exists goods_supplier_relation(id int UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,goods_id int,supplier_id int,primary key(id))";
        statement.executeUpdate(sql);
        sql = "create table if not exists goods_storage_relation(id int UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,goods_id int,storage_id int,primary key(id))";
        statement.executeUpdate(sql);
        // RELATIONS CREATE OVER
    }

    // 建表

    public void insertDepart(int id,String name,int cash) throws SQLException {
        String sql1 = "insert into department(id,name,cash)" +"values(?,?,?)" ;
        PreparedStatement pre = con.prepareCall(sql1);
        pre.setString(1,Integer.toString(id));
        pre.setString(2,name);
        pre.setString(3,Integer.toString(cash));
        pre.executeUpdate();
    }

    public void insertManager(int id,String name,String contact,String address) throws SQLException {
        String sql1 = "insert into manager(id,name,address,contact)" +"values(?,?,?,?)" ;
        PreparedStatement pre = con.prepareCall(sql1);
        pre.setString(1, Integer.toString(id));
        pre.setString(2,name);
        pre.setString(3,address);
        pre.setString(4,contact);
        pre.executeUpdate();
    }
    public void insertEmployee(int id,String name,int age,String address,String contact,String job) throws SQLException {
        String sql1 = "insert into employee(id,name,age,address,contact,job)" +"values(?,?,?,?,?,?)" ;
        PreparedStatement pre = con.prepareCall(sql1);
        pre.setString(1,Integer.toString(id));
        pre.setString(2,name);
        pre.setString(3,Integer.toString(age));
        pre.setString(4,address);
        pre.setString(5,contact);
        pre.setString(6,job);
        pre.executeUpdate();
    }
    public void insertGoods(int id,String name,double sellingPrice,double purchasingPrice) throws SQLException {
        String sql1 = "insert into goods(id,name,sellingPrice,purchasingPrice)" +"values(?,?,?,?)" ;
        PreparedStatement pre = con.prepareCall(sql1);
        pre.setString(1,Integer.toString(id));
        pre.setString(2,name);
        pre.setString(3,Double.toString(sellingPrice));
        pre.setString(4,Double.toString(purchasingPrice));
        pre.executeUpdate();
    }
    public void insertSupplier(int id,String name,String contact,String tel) throws SQLException {
        String sql1 = "insert into supplier(id,name,contact,tel)" +"values(?,?,?,?)" ;
        PreparedStatement pre = con.prepareCall(sql1);
        pre.setString(1,Integer.toString(id));
        pre.setString(2,name);
        pre.setString(3,contact);
        pre.setString(4,tel);
        pre.executeUpdate();
    }
    public void insertStorage(int id,String manager_name,String contact) throws SQLException {
        String sql1 = "insert into String(id,manager_name,contact)" +"values(?,?,?)" ;
        PreparedStatement pre = con.prepareCall(sql1);
        pre.setString(1,Integer.toString(id));
        pre.setString(2,manager_name);
        pre.setString(3,contact);
        pre.executeUpdate();
    }


    public void departManagerRelation(int left,int right) throws SQLException {
        String sql1 = "insert into depart_manager_relation(department_id,manager_id)" +"values(?,?)" ;
        PreparedStatement pre = con.prepareCall(sql1);
        pre.setString(1,Integer.toString(left));
        pre.setString(2,Integer.toString(right));
        pre.executeUpdate();
    }

    public void departEmployeeRelation(int left,int right) throws SQLException {
        String sql1 = "insert into depart_employee_relation(department_id,employee_id)" +"values(?,?)" ;
        PreparedStatement pre = con.prepareCall(sql1);
        pre.setString(1,Integer.toString(left));
        pre.setString(2,Integer.toString(right));
        pre.executeUpdate();
    }
    public void departGoodsRelation(int left,int right) throws SQLException {
        String sql1 = "insert into depart_goods_relation(department_id,goods_id)" +"values(?,?)" ;
        PreparedStatement pre = con.prepareCall(sql1);
        pre.setString(1,Integer.toString(left));
        pre.setString(2,Integer.toString(right));
        pre.executeUpdate();
    }
    public void goodsSupplierRelation(int left,int right) throws SQLException {
        String sql1 = "insert into goods_supplier_relation(goods_id,supplier_id)" +"values(?,?)" ;
        PreparedStatement pre = con.prepareCall(sql1);
        pre.setString(1,Integer.toString(left));
        pre.setString(2,Integer.toString(right));
        pre.executeUpdate();
    }
    public void goodsStorageRelation(int left,int right) throws SQLException {
        String sql1 = "insert into goods_storage_relation(goods_id,storage_id)" +"values(?,?)" ;
        PreparedStatement pre = con.prepareCall(sql1);
        pre.setString(1,Integer.toString(left));
        pre.setString(2,Integer.toString(right));
        pre.executeUpdate();
    }
    //插入数据


    public void print(String dbname,String... argu) throws SQLException {
        int len = argu.length;
        String info[]= new String[len];
        if (len==  0){
            return;
        }
        String sql ="select ";
        for (int i= 0 ;  i<len;i++){
            sql = sql + argu[i];
            if (i!=len-1){
                sql = sql + ",";
            }
        }
        sql = sql +" from ?";
        rs=statement.executeQuery(sql);
        while (rs.next()){
            for (int i = 0;i<len;i++){
                info[i]= rs.getString(i);
            }
            System.out.println(info);
        }
    }
    public void delete(int id,String dbName) throws SQLException {
        String sql  = "delete from ? where id = ?";
        PreparedStatement pre = con.prepareCall(sql);
        pre.setString(1,dbName);
        pre.setString(2,Integer.toString(id));
        statement.executeUpdate(sql);
    }
}
