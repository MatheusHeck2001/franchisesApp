package com.example.trabalho1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import entidades.Franchise;
import entidades.Restaurant;
import viewHelper.MenuViewHelper;

public class RestaurantActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant);

        String franchiseName = getIntent().getStringExtra("franchiseName");
        int franchiseLogo = getIntent().getIntExtra("franchiseLogo",0);
        Franchise f = null;


        for(int i=0; i<Franchise.getNumOfFranchises();i++){
            if (franchiseName.equals(Franchise.loadFranchises().get(i).getName())){
                f = Franchise.loadFranchises().get(i);
            }
        }

        assert f != null;
        ArrayList<Restaurant> restaurants = f.getRestaurants();

        ImageView franchLogo = findViewById(R.id.franchLogo);
        int height = 200;
        int width = 200;
        ConstraintLayout.LayoutParams params = new ConstraintLayout.LayoutParams(width, height);
        franchLogo.setLayoutParams(params);
        franchLogo.setPadding(4,20,4,20);
        franchLogo.setImageResource(franchiseLogo);


        TextView franchName = findViewById(R.id.franchName);
        franchName.setText(franchiseName);
        franchName.setTextSize(24f);
        franchName.setPadding(4,10,4,20);
        franchName.setTypeface(franchName.getTypeface(), Typeface.BOLD_ITALIC);


        LinearLayout llRestaurants = findViewById(R.id.llRestaurants);

        for (Restaurant r : restaurants){
            LinearLayout horizontalView = new LinearLayout(this);
            horizontalView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
            horizontalView.setOrientation(LinearLayout.HORIZONTAL);

            llRestaurants.addView(horizontalView);

            ImageView imageLogo = new ImageView(getApplicationContext());
            imageLogo.setImageDrawable(getDrawable(r.getLogo()));
            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(200, 300);
            imageLogo.setLayoutParams(lp);

            horizontalView.addView(imageLogo);



            LinearLayout llRestaurantData = new LinearLayout(this);
            llRestaurantData.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
            llRestaurantData.setOrientation(LinearLayout.VERTICAL);
            horizontalView.addView(llRestaurantData);

            //create a Layout to concentrate the Restaurant name and the city
            LinearLayout horizontalDataLL = new LinearLayout(this);
            horizontalDataLL.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
            horizontalDataLL.setOrientation(LinearLayout.HORIZONTAL);

            //add Franchise's name
            TextView restaurantName = new TextView(llRestaurants.getContext());
            restaurantName.setText(r.getName());
            restaurantName.setTextSize(14f);
            restaurantName.setTextColor(Color.BLACK);
            restaurantName.setTypeface(restaurantName.getTypeface(), Typeface.BOLD);
            restaurantName.setPadding(15,20,2,30);

            horizontalDataLL.addView(restaurantName);

            //add Restaurant city
            //Restaurant city
            TextView city = new TextView(llRestaurantData.getContext());
            city.setText(r.getCity());
            city.setTextSize(15f);
            city.setTypeface(city.getTypeface(), Typeface.BOLD);
            city.setPadding(2,30,2,10);
            city.setGravity(Gravity.END);
            city.setTextAlignment(View.TEXT_ALIGNMENT_GRAVITY);
            city.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
            horizontalDataLL.addView(city);

            llRestaurantData.addView(horizontalDataLL);


            //add restaurant address
            LinearLayout restaurantAddress = new LinearLayout(this);
            restaurantAddress.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
            restaurantAddress.setOrientation(LinearLayout.HORIZONTAL);

            //Restaurant address
            TextView address = new TextView(llRestaurantData.getContext());
            address.setText(r.getAddress());
            address.setTextSize(15f);
            address.setPadding(8,5,2,3);
            restaurantAddress.addView(address);

            llRestaurantData.addView(restaurantAddress);




        }


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.menu_main, menu);
        //return true;

        return new MenuViewHelper(this.getBaseContext()).onCreateOptionsMenu(this, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        //int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        /*if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
        */

        new MenuViewHelper(this.getBaseContext()).onOptionsItemSelected(item, this);
        return super.onOptionsItemSelected(item);
    }

}