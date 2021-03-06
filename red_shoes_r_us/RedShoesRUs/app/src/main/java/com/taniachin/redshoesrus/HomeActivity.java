package com.taniachin.redshoesrus;

import android.app.ListActivity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.Toast;
import org.json.JSONArray;
import org.json.JSONException;
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
    protected JSONObject mBlogData;

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
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }
    private void updateList() {
        if (mBlogData == null) {
            //TODO: Handle error
        }
        else {
            try {
                JSONArray jsonPosts = mBlogData.getJSONArray("posts");
                mBlogPostTitles = new String[jsonPosts.length()];
                for (int i = 0; i < jsonPosts.length(); i++){
                    JSONObject post = jsonPosts.getJSONObject(i);
                    String title = post.getString("title");
                    title = Html.fromHtml(title).toString();
                    mBlogPostTitles[i] = title;
                }
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                        android.R.layout.simple_list_item_1, mBlogPostTitles);
                setListAdapter(adapter);
               // Log.d(TAG, mBlogData.toString(2));
            } catch (JSONException e) {
                Log.e(TAG, "Exception caught!", e);
            }
        }
    }
    private class GetBlogPostsTask extends AsyncTask<Object, Void, JSONObject> {

        @Override
        protected JSONObject doInBackground(Object[] objects) {
            int responseCode = -1;
            JSONObject jsonResponse = null;

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
                    jsonResponse = new JSONObject((responseData));
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
            return jsonResponse;
        }
        @Override
        protected void onPostExecute(JSONObject result){
            mBlogData = result;
            updateList();

        }
    }
}