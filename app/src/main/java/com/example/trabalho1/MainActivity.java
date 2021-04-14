package com.example.trabalho1;

import android.content.Intent;

import android.graphics.Typeface;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.Gravity;
import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import entidades.Franchise;
import viewHelper.MenuViewHelper;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        LinearLayout llItems = findViewById(R.id.LLItems);

        ArrayList<Franchise> franchises = Franchise.loadFranchises();
        for (Franchise f : franchises){
            LinearLayout horizontalView = new LinearLayout(this);
            horizontalView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
            horizontalView.setOrientation(LinearLayout.HORIZONTAL);

            llItems.addView(horizontalView);

            ImageView imageLogo = new ImageView(getApplicationContext());
            imageLogo.setImageDrawable(getDrawable(f.getFranchiseLogoId()));
            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(200, 300);
            imageLogo.setLayoutParams(lp);
            imageLogo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent myIntent = new Intent(MainActivity.this, RestaurantActivity.class);
                    myIntent.putExtra("franchiseName", f.getName());
                    myIntent.putExtra("franchiseLogo", f.getFranchiseLogoId());
                    startActivity(myIntent);
                }
            });
            horizontalView.addView(imageLogo);



            LinearLayout llFranchiseData = new LinearLayout(this);
            llFranchiseData.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
            llFranchiseData.setOrientation(LinearLayout.VERTICAL);
            horizontalView.addView(llFranchiseData);

            //create a Layout to concentrate the Franchise name and the number of restaurants
            LinearLayout horizontalDataLL = new LinearLayout(this);
            horizontalDataLL.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
            horizontalDataLL.setOrientation(LinearLayout.HORIZONTAL);

            //add Franchise's name
            TextView franchiseName = new TextView(llItems.getContext());
            franchiseName.setText(f.getName());
            franchiseName.setTextSize(14f);
            franchiseName.setTypeface(franchiseName.getTypeface(), Typeface.BOLD);
            franchiseName.setPadding(8,30,2,15);
            franchiseName.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent myIntent = new Intent(MainActivity.this, RestaurantActivity.class);
                    myIntent.putExtra("franchiseName", f.getName());
                    myIntent.putExtra("franchiseLogo", f.getFranchiseLogoId());
                    startActivity(myIntent);
                }
            });
            horizontalDataLL.addView(franchiseName);

            //add number of restaurants
            TextView numOfRestaurants = new TextView(llItems.getContext());
            numOfRestaurants.setText("Qtd: " + f.getNumOfRestaurants());
            numOfRestaurants.setTextSize(14f);
            numOfRestaurants.setTypeface(numOfRestaurants.getTypeface(), Typeface.BOLD);
            numOfRestaurants.setPadding(2,30,2,15);
            numOfRestaurants.setGravity(Gravity.END);
            numOfRestaurants.setTextAlignment(View.TEXT_ALIGNMENT_GRAVITY);
            numOfRestaurants.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
            horizontalDataLL.addView(numOfRestaurants);
            numOfRestaurants.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent myIntent = new Intent(MainActivity.this, RestaurantActivity.class);
                    myIntent.putExtra("franchiseName", f.getName());
                    myIntent.putExtra("franchiseLogo", f.getFranchiseLogoId());
                    startActivity(myIntent);
                }
            });
            //add franchise name and num of restaurants to Layout
            llFranchiseData.addView(horizontalDataLL);

            //add franchise description
            LinearLayout franchiseDescription = new LinearLayout(this);
            franchiseDescription.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
            franchiseDescription.setOrientation(LinearLayout.HORIZONTAL);

            //franchise description
            TextView description = new TextView(llItems.getContext());
            description.setText(f.getDescription());
            description.setTextSize(15f);
            description.setPadding(8,5,2,3);
            franchiseDescription.addView(description);
            franchiseDescription.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent myIntent = new Intent(MainActivity.this, RestaurantActivity.class);
                    myIntent.putExtra("franchiseName", f.getName());
                    Log.i("Franchise: ", f.getName());
                    Log.i("DEBUG REST: ", f.getName());
                    for (int i = 0 ;i<f.getNumOfRestaurants(); i++){
                        Log.i("-", f.getRestaurants().get(i).getName());
                    }
                    myIntent.putExtra("franchiseLogo", f.getFranchiseLogoId());
                    startActivity(myIntent);
                }
            });
            llFranchiseData.addView(franchiseDescription);

            Log.i("DEBUG REST: ", f.getName());
            for (int i = 0 ;i<f.getNumOfRestaurants(); i++){
                Log.i("-", f.getRestaurants().get(i).getName());
            }
        }


        //shareButton
        FloatingActionButton fab = findViewById(R.id.share);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                String texto = "See more at: https://github.com/MatheusHeck";
                sendIntent.putExtra(Intent.EXTRA_TEXT, texto);
                sendIntent.setType("text/plain");

                Intent shareIntent = Intent.createChooser(sendIntent, null);
                startActivity(shareIntent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return new MenuViewHelper(this.getBaseContext()).onCreateOptionsMenu(this, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        new MenuViewHelper(this.getBaseContext()).onOptionsItemSelected(item, this);
        return super.onOptionsItemSelected(item);
    }

}