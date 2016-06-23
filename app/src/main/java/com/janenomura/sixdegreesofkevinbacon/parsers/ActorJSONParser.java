package com.janenomura.sixdegreesofkevinbacon.parsers;

import com.janenomura.sixdegreesofkevinbacon.model.Actor;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ActorJSONParser {

    public static List<Actor> parseFeed(String content) {

        final String TAG_ACTOR_CAST = "cast";
        final String TAG_ACTOR_CHARACTER = "character";
        final String TAG_ACTOR_ID = "id";
        final String TAG_ACTOR_POSTER = "profile_path";
        final String TAG_ACTOR_NAME = "name";

        try {
            JSONObject actorJSONObject = new JSONObject(content);
            JSONArray actorJSONArray = actorJSONObject.getJSONArray(TAG_ACTOR_CAST);
            List<Actor> actorList = new ArrayList<>();

            for (int i = 0; i < actorJSONArray.length(); i++) {

                JSONObject obj = actorJSONArray.getJSONObject(i);
                Actor actor = new Actor();

                actor.setActorID(obj.getInt(TAG_ACTOR_ID));
                actor.setActorName(obj.getString(TAG_ACTOR_NAME));
                actor.setCharacterName(obj.getString(TAG_ACTOR_CHARACTER));
                actor.setActorPosterPath(obj.getString(TAG_ACTOR_POSTER));

                actorList.add(actor);

            }

            return actorList;

        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }

    }

}
