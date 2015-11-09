package fr.yrion.yrion;

import android.app.Activity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import fr.yrion.yrion.network.Update;


public class MainActivity extends Activity {


    TextView yrion;
    EditText login;
    EditText password;
    Button connexion;
    Animation animFadeIn;
    Animation animFadeOut;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        login = (EditText)findViewById(R.id.editText);
        password = (EditText)findViewById(R.id.password);
        connexion = (Button)findViewById(R.id.connexion);
        yrion = (TextView)findViewById(R.id.yrion);

        animFadeIn = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_in);
        animFadeOut = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_out);

        yrion.startAnimation(animFadeIn);
        connexion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String log = login.getText().toString();
                String pass = password.getText().toString();
                new Update(MainActivity.this,log,pass).execute();
            }
        });







    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
