package com.sabakieng.managerspecialslist;

import android.app.Application;

public class ManagerSpecialsListApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        SpecialsList modelSpecailsList = new SpecialsList();
    }
}
