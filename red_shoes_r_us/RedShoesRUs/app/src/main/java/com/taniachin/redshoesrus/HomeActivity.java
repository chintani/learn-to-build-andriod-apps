package com.taniachin.redshoesrus;

import android.app.ListActivity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
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

        if (isNetworkAvailable()) {

            GetBlogPostsTask getBlogPostsTask = new GetBlogPostsTask();
            getBlogPostsTask.execute();

        } else {
            Toast.makeText(this, "Network is unavailable", Toast.LENGTH_LONG).show();
        }
        //Toast.makeText(this, getString(R.string.no_items), Toast.LENGTH_LONG) .show();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    //@Override
    //public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        //int id = item.getItemId();
        //if (id == R.id.action_settings) {
        //    return true;
        //}
        //return super.onOptionsItemSelected(item);
    // }
    private class GetBlogPostsTask extends AsyncTask<Object, Void, String> {

        @Override
        protected String doInBackground(Object[] objects) {
            int responseCode = -1;
            try{
                URL blogFeedUrl = new URL("http://blogteamtreehouse.com/api/get_recent_summary/?count=" + NUMBER_OF_POSTS);
                HttpURLConnection connection = (HttpURLConnection) blogFeedUrl.openConnection();
                connection.connect();

                responseCode = connection.getResponseCode();
                if(responseCode == HttpURLConnection.HTTP_OK) {
                    InputStream inputStream = connection.getInputStream();
                    Reader reader = new InputStreamReader(inputStream);
                    int contentLength = connection.getContentLength();
                    char[] charArray = new char [contentLength];
                    reader.read(charArray);
                    String responseData = new String(charArray);
                    //Log.v(TAG, responseData);
                    JSONObject jsonResponse = new JSONObject((responseData));
                    String status =jsonResponse.getString("status");
                    Log.v (TAG, status);

                    JSONArray jsonPosts = jsonResponse.getJSONArray("posts");
                    for (int i = 0; i<jsonPosts.length(); i ++) {
                        JSONObject jsonPost = jsonPosts.getJSONObject(i);
                        String title = jsonPost.getString("title");
                        Log.v(TAG, "Post" + i + ";" + title);

                    }

                }
                else {
                    Log.i(TAG, "Unsuccessful HTTP Code:" + responseCode);
                }
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
            return "Code:" + responseCode;
        }
    }



    private boolean isNetworkAvailable() {
        ConnectivityManager manager = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = manager.getActiveNetworkInfo();

        boolean isAvailable = false;
        if(networkInfo != null && networkInfo.isConnected()){
            isAvailable = true;
        }
        return isAvailable;
    }
}