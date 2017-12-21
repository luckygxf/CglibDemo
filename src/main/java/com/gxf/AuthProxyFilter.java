package com.gxf;

import net.sf.cglib.proxy.CallbackFilter;

import java.lang.reflect.Method;

/**
 * Created by GuanXF on 2017/12/21.
 */
public class AuthProxyFilter implements CallbackFilter {
    public int accept(Method method) {
        if(!"query".equalsIgnoreCase(method.getName())){
            return 0;
        }
        return 1;
    }
}
