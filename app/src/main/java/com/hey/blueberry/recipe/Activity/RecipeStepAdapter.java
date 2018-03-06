package com.hey.blueberry.recipe.Activity;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.hey.blueberry.recipe.R;

import java.util.List;

/**
 * Created by daeyo on 2018-02-20.
 */

public class RecipeStepAdapter extends RecyclerView.Adapter<RecipeStepAdapter.ViewHolder> {
    Context context;
    List<RecipeStep_item> items;
    int item_layout;
    public RecipeStepAdapter(Context context, List<RecipeStep_item> items, int item_layout){
        this.context=context;
        this.items=items;
        this.item_layout=item_layout;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recipestep, null);
        return new ViewHolder(v);
    }
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final RecipeStep_item item=items.get(position);
        Drawable drawable=context.getResources().getDrawable(item.getStepImage());

        //holder.image.setBackground(drawable);

        holder.step.setText(item.getStep());
        /*holder.cardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,item.getTitle(),Toast.LENGTH_SHORT).show();
            }
        });*/
    }

    @Override
    public int getItemCount() {
        return this.items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView stepImage;
        TextView step;
        CardView cardview;

        public ViewHolder(View itemView) {
            super(itemView);
            stepImage=(ImageView)itemView.findViewById(R.id.stepImage);
            step=(TextView)itemView.findViewById(R.id.step);
            cardview=(CardView)itemView.findViewById(R.id.cardview);
        }
    }
}
