package id.sch.smktelkom_mlg.project.xirpl206152433.kantinmoklet.adapter;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import id.sch.smktelkom_mlg.project.xirpl206152433.kantinmoklet.R;
import id.sch.smktelkom_mlg.project.xirpl206152433.kantinmoklet.model.drink;

public class drinkadapter extends RecyclerView.Adapter<drinkadapter.ViewHolder>
{

    ArrayList<drink> drinkList;

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.drink_list,parent,false);
        ViewHolder vh = new ViewHolder(v);

        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        drink Drink = drinkList.get(position);
        holder.tvjudul.setText(Drink.judul);
        holder.ivfoto.setImageDrawable(Drink.foto);
    }

    @Override
    public int getItemCount()
    {

        if(drinkList!=null)
            return drinkList.size();
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView ivfoto;
        TextView tvjudul;


        public ViewHolder(View itemView)
        {
            super(itemView);
            ivfoto = (ImageView) itemView.findViewById(R.id.imageViewDrink);
            tvjudul = (TextView) itemView.findViewById(R.id.textViewJudulD);

        }
    }

    public drinkadapter(ArrayList<drink> drinkList)
    {
        this.drinkList = drinkList;
    }
}
