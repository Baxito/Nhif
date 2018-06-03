package com.example.miriam.tibakwanza;

import android.app.Application;
import com.firebase.client.Firebase;

/**
 * Created by HOT_admin on 01/06/2018.
 */

public class FireB extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        Firebase.setAndroidContext(this);
    }
}
