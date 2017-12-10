package com.litto.vocabulary.widget;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;

public class VocabularyWidget extends AppWidgetProvider {
    private static final String TAG = VocabularyWidget.class.getSimpleName();

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        //Start the background service to update the widgets
        context.startService(new Intent(context, WidgetUpdateService.class));
    }
}
