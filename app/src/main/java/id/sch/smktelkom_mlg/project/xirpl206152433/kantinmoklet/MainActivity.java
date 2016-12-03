package id.sch.smktelkom_mlg.project.xirpl206152433.kantinmoklet;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void list_food(View view) {
        startActivity(new Intent(MainActivity.this, Food.class));
    }

    public void list_drink(View view) {
        startActivity(new Intent(MainActivity.this, Drink.class));
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();

    }
}
