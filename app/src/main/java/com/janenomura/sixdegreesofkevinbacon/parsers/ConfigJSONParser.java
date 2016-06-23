package com.janenomura.sixdegreesofkevinbacon.parsers;

import com.janenomura.sixdegreesofkevinbacon.model.Config;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ConfigJSONParser {

    public static Config parseFeed(String content) {

        final String TAG_IMAGES = "images";
        final String TAG_BASE_URL = "base_url";
        final String TAG_POSTER_SIZES = "poster_sizes";
        final String TAG_PROFILE_SIZES = "profile_sizes";
        final String TAG_CHANGE_KEYS = "change_keys";

        try {
            JSONObject configJSONObject = new JSONObject(content);

            Config config = new Config();
            config.setBaseImageURL(configJSONObject.getString(TAG_BASE_URL));

            JSONArray posterArray = configJSONObject.getJSONArray(TAG_POSTER_SIZES);
            List<String> posterList = new ArrayList<>();

            for (int i = 0; i < posterArray.length(); i++) {
                posterList.add(posterArray.getString(i));
            }

            JSONArray profileArray = configJSONObject.getJSONArray(TAG_PROFILE_SIZES);
            List<String> profileList = new ArrayList<>();

            for (int i = 0; i < profileArray.length(); i++) {
                profileList.add(profileArray.getString(i));
            }

            JSONArray keysArray = configJSONObject.getJSONArray(TAG_CHANGE_KEYS);
            List<String> keysList = new ArrayList<>();

            for (int i = 0; i < keysArray.length(); i++) {
                keysList.add(keysArray.getString(i));
            }

            config.setPosterSize(posterList);
            config.setProfileSize(profileList);
            config.setChangeKeys(keysList);

            return config;

        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }

    }

}
