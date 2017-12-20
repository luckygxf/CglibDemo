package com.gxf;

/**
 * Created by 58 on 2017/12/20.
 */
public class Client {

    public static void main(String[] args) {
        haveAuth();
        haveNoAuth();
    }

    public static void haveAuth(){
        TableDao tableDao = TableDAOFactory.getAuthInstance(new AuthProxy("guanxiangfei"));
        doMethod(tableDao);
    }

    public static void haveNoAuth(){
        TableDao tableDao = TableDAOFactory.getAuthInstance(new AuthProxy("zhangsan"));
        doMethod(tableDao);
    }

    public static void doMethod(TableDao tableDao){
        tableDao.create();
        tableDao.query();
        tableDao.update();
        tableDao.delete();
    }
}
