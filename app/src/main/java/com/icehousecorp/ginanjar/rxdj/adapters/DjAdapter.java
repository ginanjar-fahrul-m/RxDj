package com.icehousecorp.ginanjar.rxdj.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.icehousecorp.ginanjar.rxdj.R;
import com.icehousecorp.ginanjar.rxdj.models.Collections;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by ginanjar on 4/6/15.
 */
public class DjAdapter extends ArrayAdapter<Collections> {

    public DjAdapter(Context ctx, ArrayList<Collections> collections){
        super(ctx, 0, collections);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Collections collections = getItem(position);
        if(convertView == null)
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.song_list, parent, false);

        TextView title = (TextView) convertView.findViewById(R.id.title);
        title.setText(collections.song);

        TextView name = (TextView) convertView.findViewById(R.id.name);
        name.setText(collections.name);

        ImageView imageView = (ImageView) convertView.findViewById(R.id.thumbnail);
        Picasso.with(convertView.getContext())
                .load(collections.picture)
                .into(imageView);

        return convertView;
    }
}
