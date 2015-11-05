package fr.yrion.yrion;

import android.app.Activity;

import android.content.Intent;
import android.graphics.Typeface;

import android.os.Bundle;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.TextView;

import java.util.ArrayList;


public class Accueil extends Activity {
    TextView yrion;
    GridView grid;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accueil);
        yrion = (TextView)findViewById(R.id.yrion1);
        grid = (GridView)findViewById(R.id.gridlayout1);
        Typeface MyCustomFont = Typeface.createFromAsset(getAssets(),"fonts/police.ttf");
        yrion.setTypeface(MyCustomFont);
        final String[] parcelle = new String[]{
                "Grande J","Petit J","syrah","toto","roro","titi"
        };
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,parcelle);
        grid.setAdapter(adapter);
        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent i1 = new Intent(getApplicationContext(),view_parcelle.class);

                i1.putExtra("parcelle",((TextView) view).getText());
                startActivity(i1);
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_accueil, menu);
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
