package com.utd.learning.mycontacts.ui;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.utd.learning.mycontacts.R;

public class HomeActivity extends FragmentActivity {

    private static final String TAG = HomeActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "Activity Created");
        setContentView(R.layout.activity_home);
    }

    @Override
    protected void onStart() {
        Log.d(TAG, "Activity Started");
        super.onStart();
    }

    @Override
    protected void onStop() {
        Log.d(TAG, "Activity Stopped");
        super.onStop();
    }

    @Override
    protected void onResume() {
        Log.d(TAG, "Activity Resumed");
        super.onResume();
    }

    @Override
    protected void onPause() {
        Log.d(TAG, "Activity Paused");
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        Log.d(TAG, "Activity Destroyed");
        super.onDestroy();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
