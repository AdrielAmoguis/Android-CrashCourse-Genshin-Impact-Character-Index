package com.mobdeve.s17.amoguis.adrielisaiah.animationtest;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.mobdeve.s17.amoguis.adrielisaiah.animationtest.adapters.GenshinCharacterAdapter;
import com.mobdeve.s17.amoguis.adrielisaiah.animationtest.databinding.ActivityMainBinding;
import com.mobdeve.s17.amoguis.adrielisaiah.animationtest.handlers.SwipeCallback;
import com.mobdeve.s17.amoguis.adrielisaiah.animationtest.model.GenshinCharacter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // View Binding
    private ActivityMainBinding viewBinding;

    // Data List & Adapter
    private ArrayList<GenshinCharacter> characters;
    private GenshinCharacterAdapter characterAdapter;

    // ItemTouchHelper (touch interactions)
    private ItemTouchHelper touchHelper;

    // For Launching the New Character Activity
    private ActivityResultLauncher<Intent> launchAddCharacter;

    public MainActivity() {
        // Generate the data
        this.characters = new ArrayList<GenshinCharacter>();
        this.generateData();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Disable Night Theme
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        super.onCreate(savedInstanceState);
        this.viewBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(this.viewBinding.getRoot());

        // Prepare the Activity Launcher
        this.launchAddCharacter = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        // Process the returned data
                        Intent intentData = result.getData();
                        Bundle data = intentData.getBundleExtra("newCharacterData");
                        characterAdapter.addCharacter(new GenshinCharacter(data.getString("name"), data.getString("resonance"),69420));
                    }
                });

        // Prepare the recycler
        viewBinding.recyclerArea.setLayoutManager(new LinearLayoutManager(this));
        this.characterAdapter = new GenshinCharacterAdapter(this.characters);
        viewBinding.recyclerArea.setAdapter(this.characterAdapter);

        // Initialize the touch helper
        this.touchHelper = new ItemTouchHelper(new SwipeCallback(this.characterAdapter));
        this.touchHelper.attachToRecyclerView(viewBinding.recyclerArea);

        // Apply Event Handler to Add Character FAB
        viewBinding.fabAddCharacter.setOnClickListener(view -> {
            // Go to AddCharacterActivity via Intent
            Intent gotoAddCharacterActivity = new Intent(MainActivity.this, AddCharacterActivity.class);
            this.launchAddCharacter.launch(gotoAddCharacterActivity);
        });
    }

    private void generateData() {
        this.characters.add(new GenshinCharacter(
                "Diluc",
                "Pyro",
                R.drawable.diluc_card)
        );
        this.characters.add(new GenshinCharacter(
                "Barbara",
                "Hydro",
                R.drawable.barbara_card)
        );
        this.characters.add(new GenshinCharacter(
                "Hu Tao",
                "Pyro",
                R.drawable.hutao_card)
        );
        this.characters.add(new GenshinCharacter(
                "Keqing",
                "Electro",
                R.drawable.keqing_card)
        );
        this.characters.add(new GenshinCharacter(
                "Yanfei",
                "Pyro",
                R.drawable.yanfei_card)
        );
    }
}