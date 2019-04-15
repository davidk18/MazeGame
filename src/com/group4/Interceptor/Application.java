package com.group4.Interceptor;

public class Application {
	
	public void LogIn(Context myContext, Dispatcher myDispatcher) {
		
		Interceptor myLogIn = ConcreteInterecptor.getInstanceOfInterceptorAction();  // Concrete Interceptor creation Singleton 
		
		myDispatcher.registerDispatcher(myLogIn);
		myDispatcher.preRequest(myContext);
	}
	
	
	public void LogOut(Context myContext , Dispatcher myDispatcher) {
		
		Interceptor myLogIn = ConcreteInterecptor.getInstanceOfInterceptorAction();
		
		myDispatcher.registerDispatcher(myLogIn);
		myDispatcher.postRequest(myContext);
	}
}



