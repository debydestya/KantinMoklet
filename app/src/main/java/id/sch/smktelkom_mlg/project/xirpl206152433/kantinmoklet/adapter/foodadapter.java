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

public class foodadapter extends RecyclerView.Adapter<foodadapter.ViewHolder>
{
    ArrayList<food> foodList;
    IfoodAdapter mIfoodAdapter;



    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.food_list,parent,false);
        ViewHolder vh = new ViewHolder(v);

        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position)
    {
        food Food = foodList.get(position);
        holder.tvjudulf.setText(Food.judulf);
        holder.ivfotof.setImageURI(Uri.parse(Food.fotof));
    }

    @Override
    public int getItemCount()
    {
        if (foodList!=null)
            return foodList.size();
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        ImageView ivfotof;
        TextView tvjudulf;

        public ViewHolder(View itemView)
        {
            super(itemView);
            ivfotof = (ImageView) itemView.findViewById(R.id.imageViewFood);
            tvjudulf = (TextView) itemView.findViewById(R.id.textViewJudulF);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v)
                {
                    mIfoodAdapter.doClick(getAdapterPosition());
                }
            });
        }
    }

    public foodadapter(Context context, ArrayList<food> foodList)
    {
        this.foodList = foodList;
        mIfoodAdapter = (IfoodAdapter) context;
    }

    public interface IfoodAdapter
    {
        void doClick(int pos);
    }
}
