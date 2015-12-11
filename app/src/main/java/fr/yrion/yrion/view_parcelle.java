package fr.yrion.yrion;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import fr.yrion.yrion.network.UpdatePa;


public class view_parcelle extends Activity {
    TextView titre;
    public static RecyclerView rv;
    FloatingActionButton boutonadd;
    LinearLayoutManager llm;
    String name;
    public static RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_parcelle);
        titre = (TextView)findViewById(R.id.titre);
        boutonadd = (FloatingActionButton)findViewById(R.id.boutonadd);
        boutonadd.setBackgroundTintList(getResources().getColorStateList(R.color.teal_darken_1));
        rv = (RecyclerView)findViewById(R.id.rv);
        llm = new LinearLayoutManager(getApplicationContext());
        rv.setLayoutManager(llm);
        Intent intent = getIntent();
        name = intent.getStringExtra("extra");
        titre.setText(name);


        boutonadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new UpdatePa(view_parcelle.this,name).execute();
            }
        });




    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_view_parcelle, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
