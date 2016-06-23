package com.janenomura.sixdegreesofkevinbacon.parsers;

import java.util.ArrayList;
import java.util.List;
import com.janenomura.sixdegreesofkevinbacon.model.Media;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MediaJSONParser {

    public static List<Media> parseFeed(String content) {

        final String TAG_CAST = "cast";
        final String TAG_ID = "id";
        final String TAG_TITLE = "title";
        final String TAG_RELEASE = "release_date";
        final String TAG_POSTER = "poster_path";


        try {
            JSONObject mediaJSONObject = new JSONObject(content);
            JSONArray castArray = mediaJSONObject.getJSONArray(TAG_CAST);
            List<Media> mediaList = new ArrayList<>();

            for (int i = 0; i < castArray.length(); i++) {

                JSONObject obj = castArray.getJSONObject(i);
                Media movie = new Media();

                movie.setMediaID(obj.getInt(TAG_ID));
                movie.setMediaTitle(obj.getString(TAG_TITLE));
                if (obj.isNull(TAG_RELEASE)) {
                    movie.setReleaseDate("Unknown Date");
                } else {
                    String releaseDate = obj.getString(TAG_RELEASE);
                    movie.setReleaseDate(releaseDate.substring(0,4));
                }
                movie.setMediaPosterPath(obj.getString(TAG_POSTER));

                mediaList.add(movie);

            }

            return mediaList;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }

    }

}
