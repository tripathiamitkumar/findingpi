package com.example.tripathi.amit;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;


public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MyViewHolder> {
Context context;
    private List<DataModel> moviesList=new ArrayList<>();

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView txtMovieName, txtDirector;
        ImageView txtMoviePosters;

        public MyViewHolder(View view) {
            super(view);
            txtMovieName = (TextView)view.findViewById(R.id.txtMovieName);
            txtDirector = (TextView)view.findViewById(R.id.txtDirector);
            txtMoviePosters = (ImageView)view.findViewById(R.id.txtMoviePoster);


        }
    }


    public MoviesAdapter(List<DataModel> moviesList, MainActivity context) {
        this.moviesList = moviesList;
        this.context=context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.movie_list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        final DataModel movie = moviesList.get(position);
        String data=movie.getPoster();
        holder.txtMovieName.setText(movie.getName());
        holder.txtDirector.setText(movie.getDirector());
        Glide.with(context).load(data).into(holder.txtMoviePosters);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(context,frameActivity.class);
                intent.putExtra("Title",movie.getName());
                intent.putExtra("year",movie.getYear());
                intent.putExtra("Rated",movie.getRated());
                intent.putExtra("Released",movie.getReleased());
                intent.putExtra("Runtime",movie.getRuntime());
                intent.putExtra("Genre",movie.getGenre());
                intent.putExtra("Director",movie.getDirector());
                intent.putExtra("Writer",movie.getWriter());
                intent.putExtra("Actors",movie.getActors());

                intent.putExtra("Plot",movie.getPlot());
                intent.putExtra("Language",movie.getLanguage());
                intent.putExtra("Country",movie.getCountry());
                intent.putExtra("Awards",movie.getLanguage());
                intent.putExtra("Poster",movie.getPoster());
                intent.putExtra("Ratings",movie.getRatings());
                intent.putExtra("Metascore",movie.getMetascore());
                intent.putExtra("imdbRating",movie.getImdbRating());
                intent.putExtra("imdbVotes",movie.getImdbVotes());

                context.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }
}
