package com.group4.Interceptor;

import java.util.ArrayList;

public class ConcreteInterecptor implements Interceptor{

	
	ArrayList<String> DetailsOfLogin = new ArrayList<String>();
	ArrayList<String> DetailsOfLogout = new ArrayList<String>();
	
	private static ConcreteInterecptor myInterceptorAction;
	
	private ConcreteInterecptor() {
		
	}
	
	public void preRequest(Context context) {
		System.out.println("The time when\t"+context.getUserName()+"\tuser is connected\t"+context.getTime());
		DetailsOfLogin.add(context.getUserName()+"\t"+context.getTime());
	}

	public void postRequest(Context context) {
		System.out.println("The time when\t"+context.getUserName()+"\tuser is disconnected\t"+context.getTime());
		DetailsOfLogout.add(context.getUserName()+"\t"+context.getTime());
	}
	

	public static ConcreteInterecptor getInstanceOfInterceptorAction() {
		if(myInterceptorAction == null) 
			return new ConcreteInterecptor();
		else
			return myInterceptorAction;
	}
	
	
}
