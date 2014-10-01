package com.taniachin.blogreader;

import android.app.ListActivity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
//import android.widget.Toast;


public class MainListActivity extends ListActivity {
    protected String[] mBlogPostTitles;
    public static final int NUMBER_OF_POSTS = 20;
    public static final String TAG = MainListActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_list);

       //Toast.makeText(this, getString(R.string.no_items), Toast.LENGTH_LONG).show();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_list, menu);
        return true;
    }

    private class GetBlogPostsTask extends AsyncTask<Object, Void, String> {

        @Override
        protected String doInBackground(Object[] objects) {
            try {
                URL blogFeedUrl = new URL("feeds.feedburner.com/aworldofproducts/"); //?count=" + NUMBER_OF_POSTS);
                HttpURLConnection connection = (HttpURLConnection) blogFeedUrl.openConnection();
                connection.connect();

                int responseCode = connection.getResponseCode();
                Log.i(TAG, "Code:" + responseCode);
            }
            catch(MalformedURLException e) {
                Log.e(TAG, "Exception caught:", e);
            }
            catch (IOException e) {
                Log.e(TAG, "Exception caught;", e);
            }
            catch (Exception e) {
                Log.e(TAG, "Exception caught;", e);
            }

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
}
