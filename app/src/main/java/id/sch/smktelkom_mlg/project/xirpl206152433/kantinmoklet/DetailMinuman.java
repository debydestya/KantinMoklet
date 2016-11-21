package id.sch.smktelkom_mlg.project.xirpl206152433.kantinmoklet;

import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import id.sch.smktelkom_mlg.project.xirpl206152433.kantinmoklet.model.drink;

public class DetailMinuman extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_minuman);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Anda menyukai makanan ini^^", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        drink Drink = (drink) getIntent().getSerializableExtra(id.sch.smktelkom_mlg.project.xirpl206152433.kantinmoklet.Drink.DRINK);
        setTitle(Drink.judul);
        ImageView ivFoto = (ImageView) findViewById(R.id.imageFoto);
        ivFoto.setImageURI(Uri.parse(Drink.foto));
        TextView tvDeskripsi = (TextView) findViewById(R.id.drink_detail);
        tvDeskripsi.setText(Drink.deskripsi+"\n\n");
        TextView tvLokasi = (TextView) findViewById(R.id.drink_location);
        tvLokasi.setText(Drink.lokasi);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }
}
