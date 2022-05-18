package com.example.datainterventions_testapi;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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


                }
            }catch(MalformedURLException e){
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            /// 2-- convert data from json array to java objects

            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
        }
    }
}