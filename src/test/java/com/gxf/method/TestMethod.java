package com.gxf.method;

import org.junit.Test;

import java.lang.reflect.Method;

/**
 * Created by GuanXF on 2017/12/21.
 */
public class TestMethod {
    @Test
    public void testMethod(){
        String methodName = "sayHello";
        HelloMethod obj = new HelloMethod();
        Method method = null;
        try{
            method = obj.getClass().getMethod(methodName, String.class);
            method.invoke(obj, "guanxianseng");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
