package com.hey.blueberry.recipe.Activity;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.hey.blueberry.recipe.R;
import com.squareup.picasso.Picasso;

import java.util.List;


/**
 * Created by daeyo on 2018-02-20.
 */

public class RecipeAdapter extends RecyclerView.Adapter<RecipeAdapter.ViewHolder> {
    private Context context;
    private List<RecipeItem> items;
    Handler handler = new Handler();

     RecipeAdapter(Context context, List<RecipeItem> items) {
        this.context = context;
        this.items = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recipe, null);
        return new ViewHolder(v);
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        final RecipeItem item = items.get(position);

      ImageView picassoImageView = holder.imageld;
          Picasso.get()
                  .load(item.getImgUrl())
                  .fit()
                  .centerCrop()
                  .into(picassoImageView);



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
                Intent intent = new Intent(context, RecipeWebActivity.class);
                intent.putExtra("url", "http://board.miznet.daum.net/gaia/do/cook/recipe/mizr/" + item.getLinkUrl());
                context.startActivity(intent);
            }
        });

        //별을 누르면 목록에서 삭제
        holder.isFav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("aaaa", "아이템의 위치 : " + position);
                item.setFavorite(false);
                delete(position);
            }

            public void delete(int position) {
                items.remove(position);
                notifyDataSetChanged();
            }
        });

    }

    @Override
    public int getItemCount() {
        return this.items.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder  {
        ImageView imageld;
        TextView title;
        TextView material;
        TextView cooktime;
        TextView difficulty;
        ImageButton isFav;
        CardView cardview;

        ViewHolder(View itemView) {
            super(itemView);
            imageld = (ImageView) itemView.findViewById(R.id.recipe_image);
            title = (TextView) itemView.findViewById(R.id.title);
            material = (TextView) itemView.findViewById(R.id.material);
            cooktime = (TextView) itemView.findViewById(R.id.cooktime);
            difficulty = (TextView) itemView.findViewById(R.id.difficulty);
            isFav = (ImageButton) itemView.findViewById(R.id.isFav);
            cardview = (CardView) itemView.findViewById(R.id.cardview);
        }
    }
}

