package com.example.khizzipool.assignment3;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.textclassifier.TextLinks;
import android.widget.EditText;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.tasks.Task;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class Task1 extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerAdapter recyclerAdapter;
    private ArrayList<item> items;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task1);

        editText = (EditText) findViewById(R.id.Search);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        items = new ArrayList<>();
    }

    public void search(View view)
    {
        items.clear();
        String search = editText.getText().toString();
        String url = "https://pixabay.com/api/?key=10979290-5d39e2dc33d64efb67d7032d3&q="+search+"&image_type=photo&pretty=true";
        Json json = new Json();
        json.execute(url);
    }

    public class Json extends AsyncTask<String,Void,Void>
    {
        String creatorName;
        int likes;
        String imageurl;
        private ProgressDialog progressDialog;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog = new ProgressDialog(Task1.this);
            progressDialog.setTitle("Pixabay.com");
            progressDialog.setMessage("Loading...");
            progressDialog.show();
        }

        @Override
        protected Void doInBackground(String... params) {
            String stringUrl = params[0];

            try {
                URL url = new URL(stringUrl);

                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");
                connection.connect();

                InputStream stream = new BufferedInputStream(connection.getInputStream());
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(stream));
                StringBuilder builder = new StringBuilder();

                String inputString;
                while ((inputString = bufferedReader.readLine()) != null) {
                    builder.append(inputString);
                }

                JSONArray jsonArray;
                JSONObject jsonObject = new JSONObject(builder.toString());
                jsonArray = jsonObject.getJSONArray("hits");

                for(int i=0 ; i<jsonArray.length() ; i++)
                {
                    JSONObject hit = jsonArray.getJSONObject(i);
                    String creatorName = hit.getString("user");
                    int likes = hit.getInt("likes");
                    String imageurl = hit.getString("webformatURL");

                    items.add(new item(imageurl,creatorName,likes));
                }

                connection.disconnect();

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            progressDialog.dismiss();

            recyclerAdapter = new RecyclerAdapter(Task1.this,items);
            recyclerView.setAdapter(recyclerAdapter);
        }
    }

}
