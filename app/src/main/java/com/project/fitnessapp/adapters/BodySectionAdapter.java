package com.project.fitnessapp.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.project.fitnessapp.R;
import com.project.fitnessapp.activities.ExerciseActivity;
import com.project.fitnessapp.classes.BodySection;
import com.project.fitnessapp.data.Database;
import java.util.List;

public class BodySectionAdapter extends RecyclerView.Adapter<BodySectionAdapter.CardViewDesignObjectHandler> {
    private Context mContext;
    private List<BodySection> bodySectionList;
    private Database db;

    public BodySectionAdapter(Context mContext, List<BodySection> bodySectionList) {
        this.mContext = mContext;
        this.bodySectionList = bodySectionList;
    }

    public class CardViewDesignObjectHandler extends RecyclerView.ViewHolder {

        public ImageView imageViewBodySection;
        public TextView textViewBodySection;
        public CardView cardViewBodySection;


        public CardViewDesignObjectHandler(@NonNull View itemView) {
            super(itemView);
            imageViewBodySection = itemView.findViewById(R.id.imageViewBodySection);
            textViewBodySection = itemView.findViewById(R.id.textViewBodySection);
            cardViewBodySection = itemView.findViewById(R.id.cardViewBodySection);

        }

    }

    @NonNull
    @Override
    public BodySectionAdapter.CardViewDesignObjectHandler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_bodysection_design,parent,false);
        return new CardViewDesignObjectHandler(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull BodySectionAdapter.CardViewDesignObjectHandler holder, int position) {
        final BodySection bodySection = bodySectionList.get(position);

        holder.textViewBodySection.setText(bodySection.getBodysection_name());
        holder.imageViewBodySection.setImageResource(mContext.getResources().getIdentifier(bodySection.getBodysection_image_name(),"drawable", mContext.getPackageName()));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(mContext,ExerciseActivity.class);
                intent.putExtra("bodysection_object",bodySection);
                mContext.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return bodySectionList.size();
    }

}
