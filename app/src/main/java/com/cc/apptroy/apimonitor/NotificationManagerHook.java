package com.cc.apptroy.apimonitor;

import java.lang.reflect.Method;
import android.app.Notification;

import com.cc.apptroy.hook.HookParam;
import com.cc.apptroy.util.Logger;
import com.cc.apptroy.util.RefInvoke;

public class NotificationManagerHook extends ApiMonitorHook {

	@Override
	public void startHook() {
		// TODO Auto-generated method stub
		Method notifyMethod = RefInvoke.findMethodExact("android.app.NotificationManager", ClassLoader.getSystemClassLoader(), "notify",int.class,Notification.class);
		hookhelper.hookMethod(notifyMethod, new AbstractBahaviorHookCallBack() {
			@Override
			public void descParam(HookParam param) {
				// TODO Auto-generated method stub
				Notification notification = (Notification) param.args[1];
				Logger.log_behavior("Send Notification ->");
				Logger.log_behavior(notification.toString()); 
			}
		});
	}

}
