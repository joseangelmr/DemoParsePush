package com.devs.demosafecam;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseACL;
import com.parse.ParseObject;
import com.parse.ParseUser;

/**
 * Created by joseangelmr on 19/12/15.
 */
public class PhotoApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        ParseObject.registerSubclass(Photo.class);
        Parse.initialize(this, "Application ID", "Client Key");
        ParseUser.enableAutomaticUser();
        ParseACL defaultACL = new ParseACL();
        defaultACL.setPublicReadAccess(true);
        ParseACL.setDefaultACL(defaultACL, true);
    }

}
