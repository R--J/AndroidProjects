package com.example.jon.myfourthapplication;

import android.appwidget.AppWidgetManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;

/**
 * Created by jon on 15/11/13.
 */
public class MyBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        // use RemoteViews to update Widget
        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.new_app_widget);

        // set RemoteViews according to editText through intent extra
        remoteViews.setTextViewText(R.id.appwidget_text, intent.getStringExtra("message"));

        // update widget by RemoteViews
        AppWidgetManager.getInstance(context).updateAppWidget(new ComponentName((context.getApplicationContext()), MyWidgetProvider.class), remoteViews);
    }
}
