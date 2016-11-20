package id.sch.smktelkom_mlg.project.xirpl206152433.kantinmoklet.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import id.sch.smktelkom_mlg.project.xirpl206152433.kantinmoklet.R;
import id.sch.smktelkom_mlg.project.xirpl206152433.kantinmoklet.model.food;

/**
 * Created by fanani on 11/20/2016.
 */

public class foodadapter extends RecyclerView.Adapter<foodadapter.ViewHolder> {

    ArrayList<food> foodList;
    foodadapter.IfoodAdapter mIfoodAdapter;

    public foodadapter(Context context, ArrayList<food> foodList) {
        this.foodList = foodList;
        mIfoodAdapter = (foodadapter.IfoodAdapter) context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.food_list, parent, false);
        ViewHolder vh = new ViewHolder(v);

        return vh;
    }

    @Override
    public void onBindViewHolder(foodadapter.ViewHolder holder, int position) {

        food Food = foodList.get(position);
        holder.tvjudul.setText(Food.judul);
        holder.ivfoto.setImageURI(Uri.parse(Food.foto));
    }

    @Override
    public int getItemCount() {

        if (foodList != null)
            return foodList.size();
        return 0;
    }

    public interface IfoodAdapter {
        void doClick(int pos);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView ivfoto;
        TextView tvjudul;


        public ViewHolder(View itemView) {
            super(itemView);
            ivfoto = (ImageView) itemView.findViewById(R.id.imageViewFood);
            tvjudul = (TextView) itemView.findViewById(R.id.textViewJudulD);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mIfoodAdapter.doClick(getAdapterPosition());
                }
            });
        }
    }
}
