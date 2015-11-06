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


public class view_parcelle extends Activity {
    TextView titre;
    RecyclerView rv;
    FloatingActionButton boutonadd;
    LinearLayoutManager llm;
    RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_parcelle);
        titre = (TextView)findViewById(R.id.titre);
        boutonadd = (FloatingActionButton)findViewById(R.id.boutonadd);
        boutonadd.setBackgroundTintList(getResources().getColorStateList(android.R.color.holo_red_light));
        rv = (RecyclerView)findViewById(R.id.rv);
        llm = new LinearLayoutManager(getApplicationContext());
        rv.setLayoutManager(llm);
        Intent intent = getIntent();
        String name = intent.getStringExtra("parcelle");
        titre.setText(name);
        final ArrayList<String> mDataSet = new ArrayList<>();
        boutonadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDataSet.add("toto");
                RecyclerView.Adapter adapter = new RVAdapter(view_parcelle.this,mDataSet);
                adapter.notifyDataSetChanged();
                rv.setAdapter(adapter);
            }
        });
        for(int i=0;i<10;i++){
            mDataSet.add("Bonjour"+i);
        }
        RecyclerView.Adapter adapter = new RVAdapter(view_parcelle.this,mDataSet);
        rv.setAdapter(adapter);

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
