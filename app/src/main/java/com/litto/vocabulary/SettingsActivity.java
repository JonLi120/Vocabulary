package com.litto.vocabulary;

import android.app.AlarmManager;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.litto.vocabulary.reminders.ScheduledJobService;

public class SettingsActivity extends AppCompatActivity implements SharedPreferences.OnSharedPreferenceChangeListener {

    private static final int JOB_ID = 100;
    private static final String TAG = SettingsActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
    }
    @Override
    protected void onResume() {
        super.onResume();
        PreferenceManager.getDefaultSharedPreferences(this)
                .registerOnSharedPreferenceChangeListener(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        PreferenceManager.getDefaultSharedPreferences(this)
                .unregisterOnSharedPreferenceChangeListener(this);
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
        String remindersKey = getString(R.string.pref_key_reminders);
        if (key.equals(remindersKey)) {
            boolean enabled = sharedPreferences.getBoolean(remindersKey, false);
            JobScheduler jobScheduler =
                    (JobScheduler) getSystemService(Context.JOB_SCHEDULER_SERVICE);

            if (!enabled) {
                jobScheduler.cancel(JOB_ID);
                Log.d(TAG, "cancelling scheduled job");
            } else {
                long interval = AlarmManager.INTERVAL_DAY;
                JobInfo job = new JobInfo.Builder(JOB_ID,
                        new ComponentName(getPackageName(),
                                ScheduledJobService.class.getName()))
                        .setPersisted(true)
                        .setPeriodic(interval)
                        .build();
                Log.d(TAG, "setting scheduled job for: " + interval);
            }
        }
    }
}
