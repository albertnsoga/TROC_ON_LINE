package com.google.firebase.quickstart.auth.troc_on_line.Helpers;

import android.content.Context;
import android.graphics.Color;
import android.provider.SyncStateContract;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.github.ivbaranov.mli.MaterialLetterIcon;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.quickstart.auth.troc_on_line.Model.Troc;
import com.google.firebase.quickstart.auth.troc_on_line.R;
import com.google.firebase.quickstart.auth.troc_on_line.Views.DetailActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private Context c;
    private final TypedValue mTypedValue = new TypedValue();
    private int mBackground;
    private int[] mMaterialColors;
    private final List<Troc> trocs;

    private String searchingString = "";




    /* creation d'une classe ViewHolder*/

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private  TextView nameTxt, mDescriptionTxt;
        private  MaterialLetterIcon mIcon;
        private  ItemClickListener itemClickListener;
        private  ImageView mImageView;



        public ViewHolder(View itemView){
            super(itemView);

            mIcon = itemView.findViewById(R.id.mMaterialLetterIcon);
            nameTxt = itemView.findViewById(R.id.mNameTxt);
            mDescriptionTxt = itemView.findViewById(R.id.mNameTxt);
            mImageView = itemView.findViewById(R.id.mImageView);

            itemView.setOnClickListener(this);
        }



        @Override
        public void onClick(View view) {
            this.itemClickListener.onItemClick(this.getLayoutPosition());

        }

         void setItemClickListener(ItemClickListener itemClickListerner) {
            this.itemClickListener = itemClickListerner;

        }
    }

    public MyAdapter( ){
        this.trocs = new ArrayList<>();


    }
    public void addAll(List<Troc> newTrocs){
        int initialSise = trocs.size();
        trocs.addAll(newTrocs);
        notifyItemRangeInserted(initialSise, newTrocs.size());
    }
    public void clear() {
        trocs.clear();
        notifyDataSetChanged();
    }

    @NonNull
@Override
public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    this.c = parent.getContext();
    mMaterialColors = c.getResources().getIntArray(R.array.colors);
    View view = LayoutInflater.from(c).inflate(R.layout.model, parent, false);
    return new ViewHolder(view);
}


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position){
        final Troc t = trocs.get(position);
        holder.nameTxt.setText(t.getName());
        holder.mDescriptionTxt.setText(t.getDescription());
        holder.mIcon.setInitials(true);

        if (t.getImageURL() != null && !t.getImageURL().isEmpty()) {
            holder.mIcon.setVisibility(View.GONE);
            holder.mImageView.setVisibility(View.VISIBLE);

            /*Utils.loadImageFromNetwork(SyncStateContract.Constants.IMAGES_BASE_URL + t.getImageURL(), R.drawable.image_not_found, holder.mImageView*;*/

        } else {
            holder.mImageView.setVisibility(View.GONE);
            holder.mIcon.setVisibility(View.VISIBLE);

            holder.mIcon.setInitials(true);
            holder.mIcon.setInitialsNumber(2);
            holder.mIcon.setLetterSize(14);
            holder.mIcon.setShapeColor(mMaterialColors[new Random().nextInt(
                    mMaterialColors.length)]);
            holder.mIcon.setLetter(t.getName());
        }

        holder.itemView.setBackgroundColor(Color.parseColor("#efefef"));

        //open detail activity when clicked
        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClick(int pos) {
                Utils.sendTrocToActivity(c, t,
                        DetailActivity.class);
            }
        });
    }
    @Override
    public int getItemCount() {
        return trocs.size();
    }

    interface ItemClickListener {
        void onItemClick(int pos);
    }
}
