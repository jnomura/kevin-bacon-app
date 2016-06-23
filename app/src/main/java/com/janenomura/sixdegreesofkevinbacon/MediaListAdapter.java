package com.janenomura.sixdegreesofkevinbacon;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.janenomura.sixdegreesofkevinbacon.model.Media;

import java.util.List;

public class MediaListAdapter extends ArrayAdapter<Media> {

    private List<Media> mediaList;
    private Context context;

    public MediaListAdapter(Context context, int resource, List<Media> objects) {
        super(context, resource, objects);
        this.context = context;
        this.mediaList = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.list_item_media, parent, false);
        }
        /*LayoutInflater inflater =
                (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View mediaView = inflater.inflate(R.layout.list_item_media, parent, false);*/

        Media media = mediaList.get(position);

        TextView nameText = (TextView) convertView.findViewById(R.id.mediaTitleText);
        nameText.setText(media.getMediaTitle());

        TextView releaseText = (TextView) convertView.findViewById(R.id.releaseText);
        releaseText.setText(media.getReleaseDate());

        return convertView;
    }
}
