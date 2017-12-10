package com.litto.vocabulary.data;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import android.support.annotation.Nullable;

public class VocabularyProvider extends ContentProvider {
    private static final String TAG = VocabularyProvider.class.getSimpleName();
    private static final int VOCABULARIES = 200;
    private static final int VOCABULARY_WITH_ID = 201;
    private static final UriMatcher sUriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
    static {
        sUriMatcher.addURI(DatabaseContract.CONTENT_AUTHORITY,
                DatabaseContract.TABLE_VOCABULARY,
                VOCABULARIES);

        sUriMatcher.addURI(DatabaseContract.CONTENT_AUTHORITY,
                DatabaseContract.TABLE_VOCABULARY + "/#",
                VOCABULARY_WITH_ID);
    }
    VocabularyHelper mVocabularyHelper;

    @Override
    public boolean onCreate() {
        mVocabularyHelper = new VocabularyHelper(getContext());
        return true;
    }

    @Nullable
    @Override
    public Cursor query(Uri uri, String[] strings, String s, String[] strings1, String s1) {
        //TODO: Implement the query function
        return null;
    }

    @Nullable
    @Override
    public String getType(Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(Uri uri, ContentValues contentValues) {
        //TODO: Implement the insert function
        return null;
    }

    @Override
    public int delete(Uri uri, String s, String[] strings) {
        throw new UnsupportedOperationException("This provider does not support deletion");
    }

    @Override
    public int update(Uri uri, ContentValues contentValues, String s, String[] strings) {
        throw new UnsupportedOperationException("This provider does not support updates");
    }
}
