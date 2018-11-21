import java.sql.SQLException;

public class DBController {

    DBTool dbTool;
    DBController(DBTool dbTool){
        this.dbTool=dbTool;
    }

    void  Dealer() throws SQLException {
        //录入功能
        dbTool.insertDepart(87,"87号超市",10000000);
        dbTool.insertDepart(321,"321超市",321123);
        dbTool.insertDepart(666,"666号超市",666666);

        dbTool.insertEmployee(201701,"张三",22,"重庆市南岸区","电话19322223333","售货员");
        dbTool.insertEmployee(201703,"李四",21,"重庆市北碚区","电话19324423333","杂工");
        dbTool.insertEmployee(201722,"王五",23,"重庆市渝北区","电话19325523333","搬运工");
        dbTool.insertEmployee(201704,"小赵",32,"重庆市江北区","电话19326623333","清洁工");
        dbTool.insertEmployee(201705,"小钱",42,"重庆市巴南区","电话19327723333","工头");
        dbTool.insertEmployee(201706,"小孙",26,"重庆市渝中区","电话19328823333","会计");
        dbTool.insertEmployee(201777,"小李",32,"重庆市大渡口区","电话19399223333","售货员");

        dbTool.insertGoods(222,"洗衣液",22.4,10.0);
        dbTool.insertGoods(333,"苏打水",4,3);
        dbTool.insertGoods(444,"洗衣粉",20,10.5);
        dbTool.insertGoods(555,"台灯",40,30);
        dbTool.insertGoods(777,"U盘",30,20);

        dbTool.insertManager(200010,"李老板","电话68882222","北京");
        dbTool.insertManager(200045,"刘老板","电话68552222","上海");
        dbTool.insertManager(200455,"钟老板","电话68662222","重庆");

        dbTool.insertSupplier(177,"百货市场177号","QQ12233","电话63333333");
        dbTool.insertSupplier(188,"百货市场188号","QQ13333","电话63333322");

        dbTool.insertStorage(1,"王经理","电话66662222");
        dbTool.insertStorage(2,"周经理","电话66662233");

        dbTool.departEmployeeRelation(87,201701);
        dbTool.departEmployeeRelation(321,201703);
        dbTool.departEmployeeRelation(321,201722);
        dbTool.departEmployeeRelation(666,201704);
        dbTool.departEmployeeRelation(666,201705);
        dbTool.departEmployeeRelation(666,201706);
        dbTool.departEmployeeRelation(666,201777);

        dbTool.departGoodsRelation(87,222);
        dbTool.departGoodsRelation(87,333);
        dbTool.departGoodsRelation(321,333);
        dbTool.departGoodsRelation(321,444);
        dbTool.departGoodsRelation(321,555);
        dbTool.departGoodsRelation(666,444);
        dbTool.departGoodsRelation(666,555);
        dbTool.departGoodsRelation(666,777);

        dbTool.departManagerRelation(87,200010);
        dbTool.departManagerRelation(321,200045);
        dbTool.departManagerRelation(666,200455);

        dbTool.goodsStorageRelation(222,1);
        dbTool.goodsStorageRelation(333,1);
        dbTool.goodsStorageRelation(444,1);
        dbTool.goodsStorageRelation(444,2);
        dbTool.goodsStorageRelation(555,2);
        dbTool.goodsStorageRelation(777,2);

        dbTool.goodsSupplierRelation(222,177);
        dbTool.goodsSupplierRelation(333,177);
        dbTool.goodsSupplierRelation(777,177);
        dbTool.goodsSupplierRelation(222,188);
        dbTool.goodsSupplierRelation(444,188);
        dbTool.goodsSupplierRelation(555,188);
        dbTool.goodsSupplierRelation(777,188);

        //删除

        //查询

        //修改

        //价格降序/升序排列

        //模糊查询
    }



}
