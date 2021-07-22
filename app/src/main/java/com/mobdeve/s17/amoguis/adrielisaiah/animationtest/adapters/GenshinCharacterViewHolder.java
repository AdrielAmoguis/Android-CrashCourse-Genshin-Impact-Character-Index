package com.mobdeve.s17.amoguis.adrielisaiah.animationtest.adapters;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.mobdeve.s17.amoguis.adrielisaiah.animationtest.R;

import java.util.function.Function;

public class GenshinCharacterViewHolder extends RecyclerView.ViewHolder {

    private TextView genshinCharacterName;
    private ImageView genshinCharacterImage;
    private TextView genshinCharacterResonance;

    public GenshinCharacterViewHolder(View itemView) {
        super(itemView);

        // Instantiate the Views
        this.genshinCharacterName = itemView.findViewById(R.id.genshin_character_name);
        this.genshinCharacterImage = itemView.findViewById(R.id.genshin_character_image);
        this.genshinCharacterResonance = itemView.findViewById(R.id.genshin_character_resonance);
    }

    // Establish setters

    public void setGenshinCharacterName(String characterName) {
        this.genshinCharacterName.setText(characterName);
    }

    public void setGenshinCharacterImage(int imageId) {
        this.genshinCharacterImage.setImageResource(imageId);
    }

    public void setGenshinCharacterResonance(String characterResonance) {
        this.genshinCharacterResonance.setText(characterResonance);
    }
}
