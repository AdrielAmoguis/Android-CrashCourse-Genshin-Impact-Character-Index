package com.mobdeve.s17.amoguis.adrielisaiah.animationtest.model;

import com.mobdeve.s17.amoguis.adrielisaiah.animationtest.R;

public class GenshinCharacter {

    private String name;
    private String resonance;
    private int image;

    public GenshinCharacter(String name, String resonance, int imageId) {
        this.name = name;
        this.resonance = resonance;

        if(imageId == 69420) {
            this.image = R.drawable.paimon_card;
        }
        else
            this.image = imageId;
    }

    public String getName() {
        return name;
    }

    public String getResonance() {
        return resonance;
    }

    public int getImage() {
        return image;
    }
}
