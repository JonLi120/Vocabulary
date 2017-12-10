package com.litto.vocabulary.data;

import android.content.ContentValues;
import android.content.Context;
import android.content.res.Resources;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.litto.vocabulary.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;


public class VocabularyHelper extends SQLiteOpenHelper {
    private static final String TAG = VocabularyHelper.class.getSimpleName();

    public static final String DB_NAME = "vocabulary.db";
    public static final int DB_VERSION = 1;

    private static final String SQL_CREATE_TABLE_FLASHCARDS = "CREATE TABLE " +
            DatabaseContract.TABLE_VOCABULARY + " (" +
            DatabaseContract.TableVocabulary._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            DatabaseContract.TableVocabulary.COL_WORD + " TEXT NOT NULL," +
            DatabaseContract.TableVocabulary.COL_MEANS + " TEXT NOT NULL )";
    private final Resources mResources;

    public VocabularyHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        mResources = context.getResources();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_TABLE_FLASHCARDS);
        try {
            readVocabulariesFromResources(db);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void readVocabulariesFromResources(SQLiteDatabase db) throws IOException, JSONException {
        StringBuilder builder = new StringBuilder();
        InputStream in = mResources.openRawResource(R.raw.vocabularies);
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        String line;
        while ((line = reader.readLine()) != null) {
            builder.append(line);
        }

        //Parse resource into key/values
        JSONObject root = new JSONObject(builder.toString());
        JSONArray vocabularies = root.getJSONArray(Vocabulary.KEY_VOCABULARIES);
        //Add each element to the database
        for (int i = 0; i < vocabularies.length(); i++) {
            JSONObject item = vocabularies.getJSONObject(i);
            ContentValues values = new ContentValues(2);

            values.put(DatabaseContract.TableVocabulary.COL_WORD,
                    item.getString(Vocabulary.KEY_MEANS));

            values.put(DatabaseContract.TableVocabulary.COL_MEANS,
                    item.getString(Vocabulary.KEY_WORD));

            db.insert(DatabaseContract.TABLE_VOCABULARY, null, values);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
