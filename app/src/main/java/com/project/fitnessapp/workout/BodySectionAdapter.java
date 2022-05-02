package com.project.fitnessapp.workout;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainer;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.project.fitnessapp.MainActivity;
import com.project.fitnessapp.MenuActivity;
import com.project.fitnessapp.R;
import com.project.fitnessapp.nutrition.NutritionFragment;

import java.util.ArrayList;
import java.util.List;

public class BodySectionAdapter extends RecyclerView.Adapter<BodySectionAdapter.CardViewDesignObjectHandler> {
    private Context mContext;
    private List<BodySection> bodySectionList;
    public WorkoutFragment workoutFragment ;
    public BlankFragment blankFragment;


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

               // Fragmentten fragmente geçişte null pointer exception dönmektedir fragmentten activitye tanımlanmıştır

                blankFragment = new BlankFragment();
                FragmentTransaction transaction = workoutFragment.getActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.recyclerView,blankFragment);
                transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                transaction.addToBackStack(null);
                transaction.commit();


                /*
                if (holder.getAdapterPosition() == 0) {
                    Intent intent = new Intent(mContext,ExerciseListActivity.class);
                    mContext.startActivity(intent);
                }
                if (holder.getAdapterPosition() == 1) {
                    Intent intent = new Intent(mContext,ExerciseListActivity.class);
                    mContext.startActivity(intent);
                }

                 */


            }
        });






    }

    @Override
    public int getItemCount() {
        return bodySectionList.size();
    }
}
