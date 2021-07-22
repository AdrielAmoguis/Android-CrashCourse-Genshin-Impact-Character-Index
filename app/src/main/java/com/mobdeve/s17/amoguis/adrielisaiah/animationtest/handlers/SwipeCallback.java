package com.mobdeve.s17.amoguis.adrielisaiah.animationtest.handlers;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.Toast;

import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import com.mobdeve.s17.amoguis.adrielisaiah.animationtest.adapters.GenshinCharacterAdapter;

public class SwipeCallback extends ItemTouchHelper.SimpleCallback {

    // Provide the data adapter
    private GenshinCharacterAdapter characterAdapter;

    // Vary the color?
    private ColorDrawable background;

    public SwipeCallback(GenshinCharacterAdapter adapter) {
        // We won't be using drag. We will enable left and right swiping actions.
        super(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT);

        // Initialize student adapter
        this.characterAdapter = adapter;

        // Set the background
        this.background = new ColorDrawable(Color.LTGRAY);

    }

    @Override
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
        // We're doing false since we aren't really going to trigger anything when we move the item.
        return false;
    }

    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
        int position = viewHolder.getAdapterPosition();
        this.characterAdapter.removeCharacter(position);
    }

    @Override
    public void onChildDraw(Canvas c, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
        super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);

        // Let's do some Linear Algebra (kind of).
        View v = viewHolder.itemView;
        int backgroundCornerOffset = 20;

        // Handle process of swiping
        if(dX > 0) { // Swiping to the right
            this.background = new ColorDrawable(Color.LTGRAY);
            this.background.setBounds(v.getLeft(), v.getTop(), v.getRight() + ((int) dX) + backgroundCornerOffset, v.getBottom());
        } else if(dX < 0) { // Swiping to the left
            this.background = new ColorDrawable(Color.LTGRAY);
            this.background.setBounds(v.getLeft() + ((int) dX) - backgroundCornerOffset , v.getTop(), v.getRight(), v.getBottom());
        } else {
            this.background.setBounds(0, 0, 0, 0);
        }

        // Invoke changing of bg color
        this.background.draw(c);
    }
}
