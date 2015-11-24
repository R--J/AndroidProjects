package com.example.jon.myfourthapplication;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.provider.Settings;
import android.widget.RemoteViews;

/**
 * Created by jon on 15/11/13.
 */
public class MyWidgetProvider extends AppWidgetProvider {
    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        super.onUpdate(context, appWidgetManager, appWidgetIds);

        Intent intent = new Intent(context, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, 0);

        // use RemoteView to update Widget
        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.new_app_widget);

        remoteViews.setOnClickPendingIntent(R.id.appwidget_text, pendingIntent);

        // update AppWidget
        appWidgetManager.updateAppWidget(appWidgetIds, remoteViews);
    }
}
