/**
 * Dianping.com Inc.
 * Copyright (c) 2003-2013 All Rights Reserved.
 */
package com.dianping.pigeon.demo.thrift;

import com.dianping.pigeon.container.SpringContainer;
import com.dianping.pigeon.remoting.ServiceFactory;
import com.dianping.pigeon.remoting.invoker.concurrent.InvocationCallback;

public class ClientBootstrap {

	private static SpringContainer CLIENT_CONTAINER = new SpringContainer(
			"classpath*:META-INF/spring/thrift/invoker.xml");

	static InvocationCallback callback = new InvocationCallback() {

		@Override
		public void onSuccess(Object result) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onFailure(Throwable exception) {
			// TODO Auto-generated method stub
			
		}

		
	};

	static EchoService echoServiceCallback = ServiceFactory.getService(EchoService.class, callback, 1000);

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		CLIENT_CONTAINER.start();

		EchoService echoService = (EchoService) CLIENT_CONTAINER.getBean("echoService");
		EchoService echoServiceWithCallback = (EchoService) CLIENT_CONTAINER.getBean("echoServiceWithCallback");
		EchoService echoServiceWithFuture = (EchoService) CLIENT_CONTAINER.getBean("echoServiceWithFuture");

		int i = 0;
		while (true) {
			try {
				// echoServiceWithFuture.echo("scott");
				// ServiceFuture future = ServiceFutureFactory.getFuture();
				// System.out.println(future._get());
				// echoServiceWithCallback.echo("scott");
				// Thread.sleep(2);
				System.out.println(echoService.echo("scott"));
				// System.out.println(echoService.echo(Gender.FEMALE));
				// System.out.println(echoService.isMale());
				// System.out.println(echoService.findUsers(1));
				// Thread.sleep(10);
				// System.out.println(echoService.asyncEcho("" + (i++)));
				// System.out.println(echoService.now());
				// echoServiceWithFuture.echo("hi " + i++);
				// ServiceFuture future = ServiceFutureFactory.getFuture();
				// Thread.sleep(20);
				// future._get();

				// System.out.println("response:" +
				// ContextUtils.getResponseContext("key1"));
			} catch (Exception e) {
			}
		}
	}
}
