package com.example.tripathi.amit;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;



public class frameActivity extends AppCompatActivity {
    FrameLayout frameLayout;
    TextView title,year,rated,released,runtime,genre,director,writer,actors,posterT,ratingsT;
    TextView plot,language,country,awards,poster,ratings,metaS,imbdR,imdbV,plotT,metascoreT,imdRT,imdbVT;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail);
        frameLayout=(FrameLayout)findViewById(R.id.frame);
        title=(TextView)frameLayout.findViewById(R.id.title);
        year=(TextView)frameLayout.findViewById(R.id.year);
        rated=(TextView)frameLayout.findViewById(R.id.rated);
        released=(TextView)frameLayout.findViewById(R.id.released);
        runtime=(TextView)frameLayout.findViewById(R.id.runtime);
        genre=(TextView)frameLayout.findViewById(R.id.genre);
        director=(TextView)frameLayout.findViewById(R.id.director);
        writer=(TextView)frameLayout.findViewById(R.id.writer);
        actors=(TextView)frameLayout.findViewById(R.id.actors);

        metascoreT=(TextView)frameLayout.findViewById(R.id.metascoreT);
        imdRT=(TextView)frameLayout.findViewById(R.id.imdRT);
        imdbVT=(TextView)frameLayout.findViewById(R.id.imdbVT);


        posterT=(TextView)frameLayout.findViewById(R.id.posterT);

        ratingsT=(TextView) frameLayout.findViewById(R.id.ratingsT);

        plot=(TextView)frameLayout.findViewById(R.id.plot);
        plotT=(TextView)frameLayout.findViewById(R.id.plotT);

        language=(TextView)frameLayout.findViewById(R.id.language);
        country=(TextView)frameLayout.findViewById(R.id.country);
        awards=(TextView)frameLayout.findViewById(R.id.awards);
        poster=(TextView)frameLayout.findViewById(R.id.poster);
        ratings=(TextView)frameLayout.findViewById(R.id.ratings);
        metaS=(TextView)frameLayout.findViewById(R.id.metaS);
        imbdR=(TextView)frameLayout.findViewById(R.id.imbdR);
        imdbV=(TextView)frameLayout.findViewById(R.id.imdbV);


        Intent intent=getIntent();
        title.setText(intent.getStringExtra("Title"));
        year.setText(intent.getStringExtra("year"));
        rated.setText(intent.getStringExtra("Rated"));
        released.setText(intent.getStringExtra("Released"));
        runtime.setText(intent.getStringExtra("Runtime"));
        genre.setText(intent.getStringExtra("Genre"));
        director.setText(intent.getStringExtra("Director"));
        writer.setText(intent.getStringExtra("Writer"));
        actors.setText(intent.getStringExtra("Actors"));

        plot.setText(intent.getStringExtra("Plot"));

        if (plot.getLineCount() == 0 && plot.getText().length() != 0) {
            plot.addOnLayoutChangeListener(new View.OnLayoutChangeListener() {
                @Override
                public void onLayoutChange(final View v, final int left, final int top,
                                           final int right, final int bottom, final int oldLeft,
                                           final int oldTop, final int oldRight, final int oldBottom) {
                    plot.removeOnLayoutChangeListener(this);
                    final int count = plot.getLineCount();
                    plotT.setEllipsize (TextUtils.TruncateAt.END);
                    plotT.setMinLines(count);

                }
            });
        } else {
            final int count =plot.getLineCount();
            plotT.setEllipsize (TextUtils.TruncateAt.END);
            plotT.setMinLines(count);

        }
        poster.setText(intent.getStringExtra("Poster"));

        if (poster.getLineCount() == 0 && poster.getText().length() != 0) {
            poster.addOnLayoutChangeListener(new View.OnLayoutChangeListener() {
                @Override
                public void onLayoutChange(final View v, final int left, final int top,
                                           final int right, final int bottom, final int oldLeft,
                                           final int oldTop, final int oldRight, final int oldBottom) {
                    poster.removeOnLayoutChangeListener(this);
                    final int count = poster.getLineCount();
                    posterT.setEllipsize (TextUtils.TruncateAt.END);
                    posterT.setMinLines(count);

                }
            });
        } else {
            final int count =poster.getLineCount();
            posterT.setEllipsize (TextUtils.TruncateAt.END);
            posterT.setMinLines(count);

        }
        ratings.setText(intent.getStringExtra("Ratings"));
        if (ratings.getLineCount() == 0 && ratings.getText().length() != 0) {
            ratings.addOnLayoutChangeListener(new View.OnLayoutChangeListener() {
                @Override
                public void onLayoutChange(final View v, final int left, final int top,
                                           final int right, final int bottom, final int oldLeft,
                                           final int oldTop, final int oldRight, final int oldBottom) {
                    ratings.removeOnLayoutChangeListener(this);
                    final int count = ratings.getLineCount();
                    ratingsT.setEllipsize (TextUtils.TruncateAt.END);
                    ratingsT.setMinLines(count);

                }
            });
        } else {
            final int count =ratings.getLineCount();
            ratingsT.setEllipsize (TextUtils.TruncateAt.END);
            ratingsT.setMinLines(count);

        }

        language.setText(intent.getStringExtra("Language"));
        country.setText(intent.getStringExtra("Country"));
        awards.setText(intent.getStringExtra("Awards"));
        metaS.setText(intent.getStringExtra("Metascore"));
        imbdR.setText(intent.getStringExtra("imdbRating"));
        imdbV.setText(intent.getStringExtra("imdbVotes"));



    }
}
