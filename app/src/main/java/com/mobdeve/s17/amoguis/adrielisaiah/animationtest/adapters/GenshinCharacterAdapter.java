package com.mobdeve.s17.amoguis.adrielisaiah.animationtest.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.mobdeve.s17.amoguis.adrielisaiah.animationtest.R;
import com.mobdeve.s17.amoguis.adrielisaiah.animationtest.model.GenshinCharacter;

import java.util.ArrayList;

public class GenshinCharacterAdapter extends RecyclerView.Adapter<GenshinCharacterViewHolder> {

    // Data List
    private ArrayList<GenshinCharacter> characterList;

    public GenshinCharacterAdapter(ArrayList<GenshinCharacter> characters) {
        this.characterList = characters;
    }

    @Override
    public GenshinCharacterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.character_card, parent, false);
        return new GenshinCharacterViewHolder(v);
    }

    @Override
    public void onBindViewHolder(GenshinCharacterViewHolder holder, int position) {
        holder.setGenshinCharacterImage(this.characterList.get(position).getImage());
        holder.setGenshinCharacterName(this.characterList.get(position).getName());
        holder.setGenshinCharacterResonance(this.characterList.get(position).getResonance());
    }

    @Override
    public int getItemCount() {
        return this.characterList.size();
    }

    // Data Modification Handlers
    public void addCharacter(GenshinCharacter character) {
        this.characterList.add(0, character);
        notifyItemInserted(0);
        // or notifyDataSetChanged();
    }

    public void removeCharacter(int position) {
        this.characterList.remove(position);
        notifyItemRemoved(position);
        // or notifyDataSetChanged();
    }
}
