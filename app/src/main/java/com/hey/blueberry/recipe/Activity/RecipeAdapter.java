package com.hey.blueberry.recipe.Activity;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.hey.blueberry.recipe.R;

import java.util.List;


/**
 * Created by daeyo on 2018-02-20.
 */

public class RecipeAdapter extends RecyclerView.Adapter<RecipeAdapter.ViewHolder> {
    Context context;
    List<Recipe_item> items;
    int item_layout;

    public RecipeAdapter(Context context, List<Recipe_item> items, int item_layout) {
        this.context = context;
        this.items = items;
        this.item_layout = item_layout;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recipe, null);
        return new ViewHolder(v);
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Recipe_item item = items.get(position);
        Drawable drawable = context.getResources().getDrawable(item.getImage());

        //이미지...
        //holder.image.setBackground(drawable);

        /*Thread mThread = new Thread() {
            public void run() {
                try {
                    URL url = new URL(item.getImgUrl());

                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                    conn.setDoInput(true);
                    conn.connect();

                    InputStream is = conn.getInputStream();
                }
            }
        }*/


        //인자 집어 넣어 줌
        holder.material.setText(item.getMaterial());
        holder.title.setText(item.getTitle());
        holder.cooktime.setText(item.getCooktime());
        holder.difficulty.setText(item.getDifficulty());
        if(item.isFavorite())
            holder.isFav.setImageResource(android.R.drawable.btn_star_big_on);
        else
            holder.isFav.setImageResource(android.R.drawable.btn_star_big_off);


        //카드 클릭 시 url로 이동
        holder.cardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, item.getTitle(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://board.miznet.daum.net/gaia/do/cook/recipe/mizr/" + item.getLinkUrl()));
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return this.items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView title;
        TextView material;
        TextView cooktime;
        TextView difficulty;
        ImageButton isFav;
        CardView cardview;

        public ViewHolder(View itemView) {
            super(itemView);
            image = (ImageView) itemView.findViewById(R.id.stepImage);
            title = (TextView) itemView.findViewById(R.id.title);
            material = (TextView) itemView.findViewById(R.id.material);
            cooktime = (TextView) itemView.findViewById(R.id.cooktime);
            difficulty = (TextView) itemView.findViewById(R.id.difficulty);
            isFav = (ImageButton) itemView.findViewById(R.id.isFav);
            cardview = (CardView) itemView.findViewById(R.id.cardview);
        }
    }
}

