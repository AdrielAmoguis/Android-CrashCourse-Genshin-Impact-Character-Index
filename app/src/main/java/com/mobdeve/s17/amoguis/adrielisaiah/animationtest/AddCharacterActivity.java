package com.mobdeve.s17.amoguis.adrielisaiah.animationtest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import com.mobdeve.s17.amoguis.adrielisaiah.animationtest.databinding.ActivityAddCharacterBinding;

public class AddCharacterActivity extends AppCompatActivity {

    // The ViewBinding object
    private ActivityAddCharacterBinding viewBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.viewBinding = ActivityAddCharacterBinding.inflate(getLayoutInflater());
        setContentView(viewBinding.getRoot());

        // Set the event handler for the save button
        viewBinding.btnAddNewCharacter.setOnClickListener(view -> {
            // Grab the data
            String newCharacterName = viewBinding.newCharacterName.getText().toString();
            String newCharacterResonance = viewBinding.newCharacterResonance.getText().toString();

            Bundle dataBundle = new Bundle();
            dataBundle.putString("name", newCharacterName);
            dataBundle.putString("resonance", newCharacterResonance);

            Intent returnIntent = new Intent();
            returnIntent.putExtra("newCharacterData", dataBundle);

            setResult(1, returnIntent);
            finish();
        });
    }
}