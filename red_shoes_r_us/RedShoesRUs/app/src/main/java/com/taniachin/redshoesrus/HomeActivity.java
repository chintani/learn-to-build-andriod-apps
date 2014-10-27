package com.taniachin.redshoesrus;

import android.app.ListActivity;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


public class HomeActivity extends ListActivity {

    protected String [] mBlogPostTitles;
    public static final int NUMBER_OF_POSTS = 20;
    public static final String TAG = HomeActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        try{
            URL blogFeedUrl = new URL("http://blogteamtreehouse.com/api/get_recent_summary/?count=" + NUMBER_OF_POSTS);
            HttpURLConnection connection = (HttpURLConnection) blogFeedUrl.openConnection();
            connection.connect();

            int responseCode = connection.getResponseCode();
            Log.i(TAG, "Code:" + responseCode);
        }
        catch (MalformedURLException e){
            Log.e(TAG, "Exception caught", e);

        }
        catch (java.io.IOException e){
            Log.e(TAG, "Exception caught", e);

        }
        catch (Exception e){
            Log.e(TAG, "Exception caught", e);

        }
        //Resources resources = getResources();
        //mBlogPostTitles = resources.getStringArray(R.array.android_names);

        //ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1 , mBlogPostTitles);
        //setListAdapter(adapter);


        //Toast.makeText(this, getString(R.string.no_items), Toast.LENGTH_LONG) .show();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    private class GetBlogPostsTask extends AsyncTask {

        @Override
        protected Object doInBackground(Object[] objects) {
            return null;
        }
    }
}
