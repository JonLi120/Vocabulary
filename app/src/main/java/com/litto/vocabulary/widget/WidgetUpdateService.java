package com.litto.vocabulary.widget;

import android.app.IntentService;
import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Intent;
import android.database.Cursor;
import android.util.Log;
import android.widget.RemoteViews;

import java.util.Random;

import com.litto.vocabulary.R;
import com.litto.vocabulary.data.DatabaseContract;
import com.litto.vocabulary.data.Vocabulary;

public class WidgetUpdateService extends IntentService {
    private static final String TAG = WidgetUpdateService.class.getSimpleName();

    public static final String EXTRA_WIDGET_IDS = "widget_ids";

    public WidgetUpdateService() {
        super(TAG);
    }

    @Override
    protected void onHandleIntent(Intent intent) {

        AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(this);
        int[] appWidgetIds = appWidgetManager.getAppWidgetIds(new ComponentName(this,
                VocabularyWidget.class));

        for (int id : appWidgetIds) {

            int totalCards = 0;

            Cursor cursor = getContentResolver().query(DatabaseContract.CONTENT_URI,
                    null,
                    null,
                    null,
                    null);

            if (cursor != null) {
                totalCards = cursor.getCount();
            }

            if (cursor == null) {
                Log.w(TAG, "Unable to read card database");
                return;
            }

            Random randomNumberGenerator = new Random();
            int randomNumber = randomNumberGenerator.nextInt(totalCards);

            cursor.moveToPosition(randomNumber);
            Vocabulary randomFlashcard = new Vocabulary(cursor);

            //Load question info into widget view
            RemoteViews view = new RemoteViews(getPackageName(), R.layout.vocabulary_widget);
            view.setTextViewText(R.id.appwidget_text, "Hello, World!");

            //Update the widget
            appWidgetManager.updateAppWidget(id, view);
        }
    }
}

