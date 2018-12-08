package com.example.inika.simpleservices;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import java.net.MalformedURLException;
import java.net.URL;


//To easily create a service that runs a task asynchronously and
// terminates itself when it is done, you can use the IntentService class.
public class MyIntentService extends IntentService {
    //create a new thread object
    private Thread thread = new Thread();
    //
    public MyIntentService() {
        super("MyIntentServiceName");
    }

    // onHandleIntent is executed on a worker thread
    @Override
    protected void onHandleIntent(Intent intent) {
        //thread.start(); //start the worker thread
        try {
            //download a pdf file
            int result = DownloadFile(new URL("http://www.amazon.com/somefile.pdf"));
            Log.i("IntentService", "Downloaded " + result + " bytes");


        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
    //fake download
    private int DownloadFile(URL url) {
        try {
        //---simulate taking some time to download a file---
            thread.sleep(5000); //sleep 5 secs
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Toast.makeText(getBaseContext(),
                "Downloaded " + String.valueOf( 100) + " bytes",
                Toast.LENGTH_LONG).show();
        return 100; //bytes
    }
    public void onDestroy()
    {
        Log.wtf("IntentService","Service ended when job finieshed");
    }
}

