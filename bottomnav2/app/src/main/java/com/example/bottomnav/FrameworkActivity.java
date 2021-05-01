package com.example.bottomnav;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;



public class FrameworkActivity extends AppCompatActivity {

//    private ArrayList<Integer> imageGame = new ArrayList<Integer>();
//    private ArrayList<String> namaGame = new ArrayList<>();
//    private ArrayList<String> genreGame = new ArrayList<>();
//    private ArrayList<String> detailGame = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_framework);

        BottomNavigationView btnNav = findViewById(R.id.bottomNavigationView);
        btnNav.setOnNavigationItemSelectedListener(navListener);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_layout,new DashboardFragment()).commit();
//        getDataGame();
    }
    //navlistener
    private BottomNavigationView.OnNavigationItemSelectedListener navListener = new
            BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;

                    switch (item.getItemId()){
                        case R.id.item1:
                            selectedFragment = new DashboardFragment();
                            break;
                        case R.id.item2:
                            selectedFragment = new ProfileFragment();
                            break;
                        case R.id.item3:
                            selectedFragment = new SettingFragment();
                            break;
                    }
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.fragment_layout
                                    ,selectedFragment).commit();
                    return true;
                }
            };
    public void clickMethod(View v) {
        switch(v.getId()) {
            case R.id.btn_logout:
                SharedPreferences preferences = getSharedPreferences("SAVED_LOGIN", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();
                editor.clear();
                editor.apply();

                Intent intent = new Intent(FrameworkActivity.this, MainActivity.class);
                FrameworkActivity.this.startActivity(intent);
                finish();
                break;

            case R.id.btn_edit:
                Intent intentEP = new Intent(FrameworkActivity.this, EditActivity.class);
                FrameworkActivity.this.startActivity(intentEP);
                finish();
                break;
        }
    }
//    private void getDataGame(){
//        namaGame.add("Aspalt");
//        imageGame.add(R.drawable.aspalt);
//        genreGame.add("Rancing, Driver");
//        detailGame.add("Tear up the Asphalt in the ultimate console racing experience! Enjoy the intuitive TouchDrive controls as you take the wheel of the most prestigious dream cars across 70 gravity-defying tracks. Complete over 800 events in the solo Career mode and face up to 7 players in real time in multiplayer mode.");
//
//        namaGame.add("Minecraft");
//        imageGame.add(R.drawable.minecraft);
//        genreGame.add("Adventure, Action");
//        detailGame.add("Create anything you can imagine. Explore randomly generated worlds. Survive dangerous mobs at night. This collection includes the Minecraft base game and the Starter Pack compilation: Greek Mythology Mash-up, Plastic Texture Pack, Skin Pack 1, and Villains Skin Pack. Also get 700 Minecoins to use in the in-game Marketplace!");
//
//        namaGame.add("Forza Horizon");
//        imageGame.add(R.drawable.forzahorizon);
//        genreGame.add("Rancing");
//        detailGame.add("Forza Motorsport 7 is where Racers, Drifters, Drag Racers, Tuners, and Creators come together in a community devoted to everything automotive. Drive the cars of your dreams, with more than 700 amazing vehicles to choose from. Challenge yourself across 30 famous");
//        processRecyclerViewAdapter();
//    }
//    private void processRecyclerViewAdapter(){
//        RecyclerView recyclerView = findViewById(R.id.rv_game_seru);
//        RecyclerViewAdapter adapter = new RecyclerViewAdapter(imageGame, namaGame, genreGame, detailGame,this);
//        recyclerView.setAdapter(adapter);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//    }

}

