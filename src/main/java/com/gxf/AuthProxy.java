package com.gxf;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by 58 on 2017/12/20.
 */
public class AuthProxy implements MethodInterceptor {
    private String name;

    public AuthProxy(String name) {
        this.name = name;
    }

    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        if(!"guanxiangfei".equals(name)){
            System.out.println("You have no auth.");
            return null;
        }
        return proxy.invokeSuper(obj, args);
    }
}
