package com.example.tripathi.amit;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class MainActivity extends AppCompatActivity {
    ApiInterface apiInterface;
    private static String url = "http://www.omdbapi.com/?i=tt3896198&apikey=38f7f489";
    DataModel dataModel=new DataModel();

TextView txtMovieName,txtDirector;
    private List<DataModel> movieList = new ArrayList<>();
    public RecyclerView recyclerView;
    public MoviesAdapter mAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=(RecyclerView) findViewById(R.id.recycler_view);
        new JSONParse().execute();



        initiate();
    }

    private void initiate() {
        Gson gson = new GsonBuilder().setLenient().create();
        Retrofit retrofit = new Retrofit.Builder().baseUrl(AppUrl.MainUrl).addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson)).build();

        apiInterface = retrofit.create(ApiInterface.class);
    }

    public class JSONParse extends AsyncTask<String, String, JSONObject> {
        private ProgressDialog pDialog;
        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            recyclerView=(RecyclerView) findViewById(R.id.recycler_view);

            pDialog = new ProgressDialog(MainActivity.this);
            pDialog.setMessage("Getting Data ...");
            pDialog.setIndeterminate(false);
            pDialog.setCancelable(true);
            pDialog.show();

        }

        @Override
        protected JSONObject doInBackground(String... args) {
            JSONParser jParser = new JSONParser();


            JSONObject json = jParser.getJSONFromUrl(url);
            return json;
        }
        @Override
        protected void onPostExecute(JSONObject json) {
            pDialog.dismiss();
            try {

                 dataModel.setName(json.getString("Title"));
                dataModel.setDirector(json.getString("Director"));
                dataModel.setPoster(json.getString("Poster"));
                dataModel.setYear(json.getString("Year"));
                dataModel.setRated(json.getString("Rated"));
                dataModel.setReleased(json.getString("Released"));
                dataModel.setRuntime(json.getString("Runtime"));
                dataModel.setGenre(json.getString("Genre"));
                dataModel.setWriter(json.getString("Writer"));
                dataModel.setActors(json.getString("Actors"));
                dataModel.setPlot(json.getString("Plot"));
                dataModel.setLanguage(json.getString("Language"));
                dataModel.setCountry(json.getString("Country"));
                dataModel.setAwards(json.getString("Awards"));
                dataModel.setRatings(json.getString("Ratings"));
                dataModel.setMetascore(json.getString("Metascore"));
                dataModel.setImdbRating(json.getString("imdbRating"));
                dataModel.setImdbVotes(json.getString("imdbVotes"));
                movieList.add(dataModel);


                recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

                mAdapter = new MoviesAdapter(movieList,MainActivity.this);
                RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
                recyclerView.setLayoutManager(mLayoutManager);
                recyclerView.setAdapter(mAdapter);


Log.e("check value","values" + json.toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
    }
public android.support.v4.app.FragmentTransaction fragmentMethod()
{
    detailFragment fragment=new detailFragment();
    android.support.v4.app.FragmentManager fragmentManager=getSupportFragmentManager();
    android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
   return fragmentTransaction;
}
}
