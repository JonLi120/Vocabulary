package com.litto.vocabulary.data;

import android.net.Uri;
import android.provider.BaseColumns;

/**
 * Created by tom on 2016/11/19.
 */

public class DatabaseContract {
    // Database schema information
    public static final String TABLE_VOCABULARY = "vocabulary";
    public static final class TableVocabulary implements BaseColumns {
        public static final String COL_ID = "_id";
        public static final String COL_WORD = "word";
        public static final String COL_MEANS = "means";
    }

    // Unique authority string for the content provider
    public static final String CONTENT_AUTHORITY = "com.google.developer.vocabulary";
    // Default sort for query results
    public static final String DEFAULT_SORT_VOCABULARY = TableVocabulary.COL_ID;

    // Base content Uri for accessing the provider
    public static final Uri CONTENT_URI = new Uri.Builder().scheme("content")
            .authority(CONTENT_AUTHORITY)
            .appendPath(TABLE_VOCABULARY)
            .build();
}
