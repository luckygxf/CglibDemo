package com.gxf;

import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;

/**
 * Created by 58 on 2017/12/20.
 */
public class TableDAOFactory {
    private static TableDao tableDao = new TableDao();
    public static TableDao getInstance(){
        return tableDao;
    }

    public static TableDao getAuthInstance(AuthProxy authProxy){
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(TableDao.class);
        enhancer.setCallback(authProxy);
        return (TableDao) enhancer.create();
    }

    public static TableDao getAuthInstanceByFilter(AuthProxy authProxy){
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(TableDao.class);
        enhancer.setCallbacks(new Callback[]{authProxy, NoOp.INSTANCE});
        enhancer.setCallbackFilter(new AuthProxyFilter());
        return (TableDao) enhancer.create();
    }

}
