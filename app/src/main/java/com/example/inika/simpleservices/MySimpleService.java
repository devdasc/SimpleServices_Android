package com.example.inika.simpleservices;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

public class MySimpleService extends Service{

	public static final String INFO_INTENT = "com.net.learn2develop.Services.INFO_UPDATE";

	@Override
	public IBinder onBind(Intent arg0) {
	return null;
	}
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		// We want this service to continue running until it is explicitly
		// stopped, so return sticky.
		Toast.makeText(this, "Service Started", Toast.LENGTH_LONG).show();
		//broadcast info to starting activity (reports back)
		Intent broadcastIntent = new Intent();
		broadcastIntent.setAction(INFO_INTENT);
		broadcastIntent.putExtra(INFO_INTENT, "Hello there from COMP34 class!");
		//broadcasting the intent to a receiver
		this.sendBroadcast(broadcastIntent);
		//will run as long as nobody stops it
		return START_STICKY;
	}
	@Override
	public void onDestroy() {
		super.onDestroy();
		Toast.makeText(this, "Service Destroyed", Toast.LENGTH_LONG).show();
	}

}
