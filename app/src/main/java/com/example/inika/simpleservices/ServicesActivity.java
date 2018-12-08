package com.example.inika.simpleservices;

import java.net.MalformedURLException;
import java.net.URL;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;

import android.view.View;
import android.widget.TextView;
import android.widget.Toast;



import android.content.ComponentName;
import android.os.IBinder;
import android.content.ServiceConnection;


public class ServicesActivity extends Activity {

	//Your activity will respond to this action String
	//public static final String RECEIVE_INFO = "com.net.learn2develop.Services.RECEIVE_INFO";
	public TextView textView;
	

	//This will handle the broadcast
	public BroadcastReceiver receiver = new BroadcastReceiver() {
			//capture here the message sent by MyService
			//@Override
			public void onReceive(Context context, Intent intent) {
					String action = intent.getAction();
					if (action.equals(MySimpleService.INFO_INTENT)) {
						String info = intent.getStringExtra("com.net.learn2develop.Services.INFO_UPDATE");
						textView.setText("Incoming message: "+info);

					}
			}
	};
	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		textView = (TextView) findViewById(R.id.textView);

	}//
	public void onResume()
	{
		super.onResume();
		//This needs to be in the activity that will end up receiving the broadcast
		registerReceiver(receiver, new IntentFilter("com.net.learn2develop.Services.INFO_UPDATE"));
		                
	}
	public void startService(View view) {
		startService(new Intent(getBaseContext(), MyIntentService.class));
	}//

	public void stopService(View view) {
		stopService(new Intent(getBaseContext(), MyIntentService.class));
	}

}
