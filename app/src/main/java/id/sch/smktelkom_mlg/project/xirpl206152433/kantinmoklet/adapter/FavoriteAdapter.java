package id.sch.smktelkom_mlg.project.xirpl206152433.kantinmoklet.adapter;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

import id.sch.smktelkom_mlg.project.xirpl206152433.kantinmoklet.R;
import id.sch.smktelkom_mlg.project.xirpl206152433.kantinmoklet.model.Favorite;

/**
 * Created by DEBY on 11/30/2016.
 */

public class FavoriteAdapter extends ArrayAdapter<Favorite> {
    public Favorite fav;
    public FavoriteAdapter(Context context, ArrayList<Favorite> favorite) {
        super(context, 0, favorite);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        final Favorite favorite = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_favorite, parent, false);
        }
        // Lookup view for data population
        TextView tvName = (TextView) convertView.findViewById(R.id.tvName);
        ImageView ivGambar = (ImageView) convertView.findViewById(R.id.ivGambar);
       // ivGambar.setImageResource(favorite.Gambar);
        ivGambar.setImageURI(Uri.parse(favorite.Gambar));
        // Populate the data into the template view using the data object
        tvName.setText(favorite.Nama);
        RelativeLayout ll = (RelativeLayout) convertView.findViewById(R.id.layoutN);
        ll.setTag(position);
        return convertView;
}
}
