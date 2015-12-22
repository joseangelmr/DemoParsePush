package com.devs.demosafecam;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.parse.ParsePushBroadcastReceiver;

import org.json.JSONException;
import org.json.JSONObject;

public class JSONCustomReceiver extends ParsePushBroadcastReceiver {

    @Override
    protected void onPushReceive(Context context, Intent intent) {
        Bundle extras = intent.getExtras();
        String jsonData = extras != null ? extras.getString("com.parse.Data") : "";

        try {
            // System.out.println("JSON Data [" + jsonData + "]");
            JSONObject obj = new JSONObject(jsonData);
            Log.i("ALERT: ", obj.getString("alert"));
            Log.i("PHOTO: ", obj.getString("photo"));
            Log.i("QUALITY: ", obj.getString("quality"));
            Log.i("CAMERA: ", obj.getString("camera"));
        } catch (JSONException jse) {
            jse.printStackTrace();
        }
    }
}
