package com.example.karorok.zamtest;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private static final int BASE_WIDTH = 150;

    private ArrayList<Item> items;


    private GestureDetector gestureDetector;

    public Adapter(ArrayList<Item> items, GestureDetector gestureDetector) {
        this.items = items;
        this.gestureDetector = gestureDetector;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item,viewGroup,false);
        ViewHolder holder = new ViewHolder(view);
        view.setOnTouchListener(touchListener);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Item item = items.get(i);
        viewHolder.layout.getLayoutParams().width = item.getWidth() * BASE_WIDTH;
        viewHolder.textView.setText(item.getText());
        viewHolder.layout.setBackgroundColor(getItemColor(item.getColor()));

    }

    private View.OnTouchListener touchListener = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            gestureDetector.onTouchEvent(motionEvent);
            return true;
        }
    };

    @Override
    public int getItemCount() {
        return items.size();
    }

    private int getItemColor(String color){
        if(color.equals("yellow")){
            return  Color.parseColor("#ffff00");
        }else if(color.equals("red")){
            return  Color.parseColor("#ff0000");
        }else{
            return  Color.parseColor("#0000ff");
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder{


        public TextView textView;

        public LinearLayout layout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            layout = itemView.findViewById(R.id.item_parent);
            textView = itemView.findViewById(R.id.textView);
        }
    }

}
