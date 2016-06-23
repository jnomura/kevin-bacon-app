package com.janenomura.sixdegreesofkevinbacon;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.janenomura.sixdegreesofkevinbacon.model.Actor;
import com.janenomura.sixdegreesofkevinbacon.model.Media;
import com.janenomura.sixdegreesofkevinbacon.parsers.MediaJSONParser;

import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class ListActivity extends AppCompatActivity {

    private ProgressBar pb;
    List<Media> mediaList;
    List<Actor> actorList;
    private final String IMAGE_BASE_URL = "http://image.tmdb.org/t/p/w185";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        pb = (ProgressBar) findViewById(R.id.progressBar);
        pb.setVisibility(View.INVISIBLE);

        // Check to see if the user has internet connection
        if (isOnline()) {
            requestImage("http://image.tmdb.org/t/p/w185/qpcel7RjjJyiayVmw9zQ389qqwX.jpg");
            requestData("http://api.themoviedb.org/3/person/529/credits?api_key=15c79c3bc3611dd2a2040d83fb25b008");
        } else {
            Toast.makeText(ListActivity.this, "Sorry, network isn't available.", Toast.LENGTH_LONG).show();
        }

    }

    public void hideImageAnimated(final ImageView iv) {

        Animation alpha = new AlphaAnimation(1.0f, 0.0f);
        alpha.setDuration(1000);

        // Add AnimationListener
        alpha.setAnimationListener(new Animation.AnimationListener() {

            @Override
            public void onAnimationEnd(Animation arg0) {
                iv.setVisibility(View.GONE);
            }

            @Override
            public void onAnimationRepeat(Animation arg0) {
            }

            @Override
            public void onAnimationStart(Animation arg0) {
            }

        });

        iv.startAnimation(alpha);
    }

    protected boolean isOnline() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = cm.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnectedOrConnecting()) {
            return true;
        } else {
            return false;
        }
    }

    private void requestData(String uri) {
        GetDataTask task = new GetDataTask();
        task.execute(uri);
    }

    private void requestImage(String uri) {
        GetPhotoTask task = new GetPhotoTask();
        task.execute(uri);
    }

    protected void updateDisplay() {
        /*ActorListAdapter adapter = new ActorListAdapter(
                this, R.layout.list_item_actors, actorList);
        ListView lv = (ListView) findViewById(R.id.listView);
        lv.setAdapter(adapter);*/

        final ImageView iv = (ImageView) findViewById(R.id.imageView2);

        Handler h = new Handler();
        h.postDelayed(new Runnable() {

            @Override
            public void run() {
                // To hide it immediately
                //iv.setVisibility(View.GONE);

                // Or hide it using animation
                hideImageAnimated(iv);
            }
        }, 3000); // 3 seconds

        MediaListAdapter adapter = new MediaListAdapter(this, R.layout.list_item_media, mediaList);
        ListView lv = (ListView) findViewById(R.id.listView);
        lv.setAdapter(adapter);
    }

    private class GetDataTask extends AsyncTask<String, String, List<Media>> {

        @Override
        protected void onPreExecute() {
            pb.setVisibility(View.VISIBLE);
        }

        @Override
        protected List<Media> doInBackground(String... params) {

            String content = HttpManager.getData(params[0]);
            mediaList = MediaJSONParser.parseFeed(content);
            return mediaList;
        }

        @Override
        protected void onPostExecute(List<Media> result) {

            pb.setVisibility(View.INVISIBLE);

            if (result == null) {
                Toast.makeText(ListActivity.this, "Sorry, can't connect to web service.", Toast.LENGTH_LONG).show();
                return;
            }

            mediaList = result;
            updateDisplay();

        }

    }

    private class GetPhotoTask extends AsyncTask<String, String, Bitmap> {

        @Override
        protected void onPreExecute() {
            pb.setVisibility(View.VISIBLE);
        }

        @Override
        protected Bitmap doInBackground(String... params) {

            try {
                String imageURL = params[0];
                InputStream in = (InputStream) new URL(imageURL).getContent();
                Bitmap bitmap = BitmapFactory.decodeStream(in);
                //media.setMediaImage(bitmap);
                in.close();
                return bitmap;

            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }

        @Override
        protected void onPostExecute(Bitmap result) {

            pb.setVisibility(View.INVISIBLE);

            if (result == null) {
                Toast.makeText(ListActivity.this, "Sorry, no photo is available.", Toast.LENGTH_LONG).show();
                return;
            }

            ImageView smallImage = (ImageView) findViewById(R.id.imageView);
            smallImage.setImageBitmap(result);

        }

    }
}

