package id.sch.smktelkom_mlg.project.xirpl206152433.kantinmoklet;

import android.content.ContentResolver;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

import id.sch.smktelkom_mlg.project.xirpl206152433.kantinmoklet.adapter.foodadapter;
import id.sch.smktelkom_mlg.project.xirpl206152433.kantinmoklet.model.drink;
import id.sch.smktelkom_mlg.project.xirpl206152433.kantinmoklet.model.food;


public class Food extends AppCompatActivity implements foodadapter.IfoodAdapter
{
    public static final String FOOD = "food";
    ArrayList<food> mList = new ArrayList<>();
    foodadapter mAdapter;

    ArrayList<food> mListAll = new ArrayList<>();
    boolean isFiltered;
    ArrayList<Integer> mListMapFilter = new ArrayList<>();
    String mQuery;

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerViewFood);
        GridLayoutManager layoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(layoutManager);
        mAdapter = new foodadapter(this,mList);
        recyclerView.setAdapter(mAdapter);

        fillData();
    }

    private void fillData()
    {
        Resources resources = getResources();
        String [] arJudul = resources.getStringArray(R.array.food);
        String [] arDeskripsi = resources.getStringArray(R.array.food_desc);
        String [] arLokasi = resources.getStringArray(R.array.food_locations);
        TypedArray a = resources.obtainTypedArray(R.array.food_picture);
        String [] arFoto = new String[a.length()];
        for (int i = 0; i < arFoto.length; i++)
        {
            int id = a.getResourceId(i,0);

            arFoto[i] = ContentResolver.SCHEME_ANDROID_RESOURCE+"://"
                    +resources.getResourcePackageName(id)+'/'
                    +resources.getResourceTypeName(id)+'/'
                    +resources.getResourceEntryName(id);
        }
        a.recycle();

        for (int i = 0; i < arJudul.length; i++)
        {
            mList.add(new food(arJudul[i],arDeskripsi[i],arLokasi[i],arFoto[i]));
        }
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void doClick(int pos)
    {
        Intent intent = new Intent(this, DetailMakanan.class);
        intent.putExtra(FOOD,mList.get(pos));
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu (Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu_food_list, menu);

        MenuItem searchItem = menu.findItem(R.id.actionsearch);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener()
        {
            @Override
            public boolean onQueryTextSubmit(String query)
            {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText)
            {
                mQuery = newText.toLowerCase();
                doFilter(mQuery);
                return true;
            }
        });

        return true;
    }

    private void doFilter(String query)
    {
        if (!isFiltered)
        {
            mListAll.clear();
            mListAll.addAll(mList);
            isFiltered =  true;
        }

        mList.clear();
        if (query ==  null || query.isEmpty())
        {
            mList.addAll(mListAll);
            isFiltered = false;
        }

        else
        {
            mListMapFilter.clear();
            for (int i = 0; i < mListAll.size(); i++)
            {
                food Food = mListAll.get(i);
                if (Food.judulf.toLowerCase().contains(query)||
                        Food.deskripsif.toLowerCase().contains(query)||
                        Food.lokasif.toLowerCase().contains(query))
                {
                    mList.add(Food);
                    mListMapFilter.add(i);
                }


            }
        }
        mAdapter.notifyDataSetChanged();
    }
}
