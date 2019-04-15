package com.group4.Interceptor;

public class ConcreteFrameWork {

	public void Start() {
		// TODO Auto-generated method stub
		
		Dispatcher myDispatcher = Dispatcher.getInstanceOfDispatcher();  // create dispatcher singleton
		
		Application userLog = new Application();
		
		
		userLog.LogIn(new Context(System.nanoTime(),"user 1" ), myDispatcher);
		userLog.LogIn(new Context(System.nanoTime(),"user 2" ), myDispatcher);

		userLog.LogOut(new Context(System.nanoTime(),"user 1" ), myDispatcher);
		userLog.LogOut(new Context(System.nanoTime(),"user 2" ), myDispatcher);
		
	}

}
