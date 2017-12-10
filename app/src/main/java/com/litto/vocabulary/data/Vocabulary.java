package com.litto.vocabulary.data;

import android.database.Cursor;

/**
 * Created by tom on 2016/11/19.
 */

public class Vocabulary {
    public static final String KEY_WORD = "word";
    public static final String KEY_MEANS = "means";
    public static final String KEY_VOCABULARIES = "vocabularies";
    int id;
    String word;
    String means;

    public Vocabulary() {
    }

    public Vocabulary(String word, String means) {
        this.word = word;
        this.means = means;
    }

    public Vocabulary(Cursor cursor) {
        this.id = cursor.getInt(cursor.getColumnIndex(DatabaseContract.TableVocabulary.COL_ID));
        this.word = cursor.getString(cursor.getColumnIndex(DatabaseContract.TableVocabulary.COL_WORD));
        this.means = cursor.getString(cursor.getColumnIndex(DatabaseContract.TableVocabulary.COL_MEANS));
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getMeans() {
        return means;
    }

    public void setMeans(String means) {
        this.means = means;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
