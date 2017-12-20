package com.gxf;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.FixedValue;
import net.sf.cglib.proxy.InvocationHandler;
import org.junit.Test;

import java.lang.reflect.Method;

/**
 * Created by 58 on 2017/12/20.
 */
public class TestCglib {

    @Test
    public void testFixedValue(){
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(SamplaClass.class);
        enhancer.setCallback(new FixedValue() {
            public Object loadObject() throws Exception {
                return "hello cglib";
            }
        });
        SamplaClass proxy = (SamplaClass) enhancer.create();
        System.out.println(proxy.test("hello guanxianseng"));
        System.out.println(proxy.print("hello guanxianseng"));
    }

    @Test
    public void testInvocationHandler(){
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(SamplaClass.class);
        enhancer.setCallback(new InvocationHandler() {
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if(method.getDeclaringClass() != Object.class && method.getReturnType() == String.class){
                    return "hello cglib!";
                }else{
                    throw new RuntimeException("Do not know what to do.");
                }
            }
        });
        SamplaClass samplaClass = (SamplaClass) enhancer.create();
        System.out.println(samplaClass.test(null));
    }

}
