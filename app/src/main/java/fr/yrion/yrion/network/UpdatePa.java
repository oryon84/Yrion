package fr.yrion.yrion.network;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

import fr.yrion.yrion.view_parcelle;

/**
 * Created by oisn on 09/11/2015.
 */
public class UpdatePa extends AsyncTask<String,String,String> {
    private ProgressDialog dialog;
    private Activity activity;
    private JSONArray infos = null;
    private static String TAG_STATUS = "PaNumPa";
    private ArrayList<HashMap<String,String>> tacheList;
    private String name;
    private String nom;

    public UpdatePa(view_parcelle parcelle,String nom) {
        super();
        activity = parcelle;
        dialog = new ProgressDialog(activity);
        this.name =  nom;

    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        dialog.setMessage("Mise à jour");
        dialog.show();
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        dialog.dismiss();
        int longueur = s.length()-2;
        String s1 = s.substring(1,longueur);

        

        try {
            JSONObject obj = new JSONObject(s1);
            infos = obj.getJSONArray(TAG_STATUS);

            for(int i=0; i <=infos.length();i++){
                JSONObject c = infos.getJSONObject(i);
                String id = c.getString("PaNumPa");
                String tache = c.getString("PaNumTache");
                String date = c.getString("PaDate");
                HashMap<String,String> taches = new HashMap<>();
                taches.put("PaNumPa",id);
                taches.put("PaNumTache",tache);
                taches.put("PaDate",date);
                tacheList.add(taches);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        view_parcelle.rv.setAdapter(new RVAdapter(activity.getApplicationContext(),tacheList));

        Toast.makeText(activity.getApplicationContext(),s1,Toast.LENGTH_LONG).show();



    }

    @Override
    protected String doInBackground(String... params) {
        StringBuilder sb = new StringBuilder();
        String reponse = null;
        try {
            URL url = new URL("http://yrion.fr/android/connect.php");
            HttpURLConnection connection = (HttpURLConnection)url.openConnection();
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);

            OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream());
            writer.write("parcelle=" + this.name);
            writer.flush();
            InputStream in = connection.getInputStream();
            InputStreamReader inw = new InputStreamReader(in);
            BufferedReader br = new BufferedReader(inw);
            String line;
            while((line=br.readLine()) != null){
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
