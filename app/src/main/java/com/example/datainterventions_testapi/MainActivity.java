package com.example.datainterventions_testapi;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    JSONArray jsonArray = null;
    Task[] tasksArray;

    ListView listTasks;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listTasks = findViewById(R.id.listTasks);

        new GetAllTasks().execute();
    }

    private class GetAllTasks extends AsyncTask<String, Integer, String>{
        @Override
        protected void onPreExecute()
        {
            super.onPreExecute();

        }

        @Override
        protected String doInBackground(String... strings) {
            // 1-- make connection with db (web service)
            try {
                URL url = new URL("http://10.0.2.2/Datainterventions_API/getInterventions.php");
                URLConnection urlConnection = url.openConnection();
                InputStreamReader inputStreamReader = new InputStreamReader(urlConnection.getInputStream());
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

                String ligne;
                while((ligne = bufferedReader.readLine()) != null){

                    jsonArray = new JSONArray(ligne);
                }

                Log.d("result", jsonArray.toString());


            }catch(MalformedURLException e){
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(String s) {

            super.onPostExecute(s);
            /// 2-- convert data from json array to java objects
            Gson gson = new Gson();
            tasksArray = gson.fromJson(jsonArray.toString(),
                    Task[].class);

            ArrayList<String> tasksData;
            tasksData = new ArrayList<>();

            for(Task task: tasksArray) tasksData.add(task.getRequester_name());
            ArrayAdapter<String> adapter;
            adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1,tasksData);
            listTasks.setAdapter(adapter);

        }
    }
}