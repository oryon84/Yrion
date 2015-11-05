package fr.yrion.yrion.network;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.http.NameValuePair;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Objects;

import fr.yrion.yrion.Accueil;
import fr.yrion.yrion.MainActivity;

public class Update extends AsyncTask<String,String ,String>{
    private ProgressDialog dialog;
    private String login;
    private String password;
    private Activity activity;
    public Update(MainActivity activity, String login, String pass) {
        dialog = new ProgressDialog(activity);
        this.activity = activity;
        this.login = login;
        this.password = pass;
    }

    @Override
    protected void onPreExecute() {

        super.onPreExecute();
        dialog.setMessage("Connexion");
        dialog.show();
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        dialog.dismiss();
        Integer s1;
        String s2 = null;
        try {
            JSONObject obj = new JSONObject(s);
            s1 = obj.getInt("status");

            if (s1 == 1){
                Intent i = new Intent(this.activity,Accueil.class);
                this.activity.startActivity(i);
            }
            else {
                Toast.makeText(this.activity.getApplicationContext(), "Erreur Login", Toast.LENGTH_SHORT).show();
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }


    }

    @Override
    protected String doInBackground(String... params) {
        StringBuilder sb = new StringBuilder();
        String reponse = null;
        try {
            URL url = new URL("http://yrion.fr/android.php");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);

            OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream());
            writer.write("user="+this.login+"&password="+this.password);
            writer.flush();
            InputStream in = connection.getInputStream();
            InputStreamReader inw = new InputStreamReader(in);
            BufferedReader br = new BufferedReader(inw);

            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line+"\n");
            }
            br.close();



        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        reponse = sb.toString();
        return reponse;
    }
}