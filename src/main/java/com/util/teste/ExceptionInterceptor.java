package com.util.teste;

import java.lang.reflect.Method;

import org.aopalliance.intercept.MethodInvocation;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

public class ExceptionInterceptor implements MethodInterceptor{

	Object invoke(MethodInvocation i) throws Throwable {  
		try {  
		    return i.proceed();  
		} catch (Exception e) {  
		    new TestarException();
			TestarException.gravarArquivo(e);
		}
		return i;  
	}

	@Override
	public Object intercept(Object arg0, Method arg1, Object[] arg2, MethodProxy arg3) throws Throwable {
		System.out.println("passei por aqui");
		return null;
	}  
}
