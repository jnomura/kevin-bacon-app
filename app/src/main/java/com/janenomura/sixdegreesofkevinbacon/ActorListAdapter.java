package com.janenomura.sixdegreesofkevinbacon;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.janenomura.sixdegreesofkevinbacon.model.Actor;

import java.util.List;

public class ActorListAdapter extends ArrayAdapter<Actor>{

    private Context context;
    private List<Actor> actorList;

    public ActorListAdapter(Context context, int resource, List<Actor> objects) {
        super(context, resource, objects);
        this.context = context;
        this.actorList = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        /*LayoutInflater inflater =
                (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View actorView = inflater.inflate(R.layout.list_item_actors, parent, false);*/

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.list_item_actors, parent, false);
        }

        Actor actor = actorList.get(position);

        TextView nameText = (TextView) convertView.findViewById(R.id.nameText);
        nameText.setText(actor.getActorName());

        TextView characterText = (TextView) convertView.findViewById(R.id.characterText);
        characterText.setText(actor.getCharacterName());

        return convertView;
    }

}
