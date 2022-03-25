package com.shakawat21.retrofit.get_countryCode_and_find_AllTeamMembers;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.shakawat21.retrofit.R;

public class Adapter_ct extends RecyclerView.Adapter<Adapter_ct.viewHolder>{

    private  Country_team_model_1_2 first_1;
    private Country_team_data_class_2_3 second_2;

    public Adapter_ct(Country_team_model_1_2 first_1, Country_team_data_class_2_3 second_2) {
        this.first_1 = first_1;
        this.second_2 = second_2;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new viewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_item_country_team,parent,false));
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {



            holder.ct_id.setText(first_1.getData().getId()+"");
            holder.ct_country_id.setText(first_1.getData().getCountry_id()+"");
            holder.ct_name.setText(first_1.getData().getName()+"");
//            holder.ct_position_name.setText();
//            holder.ct_position_id.setText();
//            holder.ct_full_name.setText();
//            holder.ct_date_of_birth.setText();
//            holder.ct_gender.setText();

    }

    @Override
    public int getItemCount() {
        return 0;
    }


    public class viewHolder extends RecyclerView.ViewHolder{
        TextView ct_id, ct_country_id, ct_name, ct_position_name, ct_position_id, ct_full_name, ct_date_of_birth, ct_gender;

        public viewHolder(@NonNull View itemView) {
            super(itemView);

            ct_id= itemView.findViewById(R.id.ct_id);
            ct_country_id= itemView.findViewById(R.id.ct_country_id);
            ct_name= itemView.findViewById(R.id.ct_name);
            ct_position_name= itemView.findViewById(R.id.ct_position_name);
            ct_position_id= itemView.findViewById(R.id.ct_position_id);
            ct_full_name= itemView.findViewById(R.id.ct_full_name);
            ct_date_of_birth= itemView.findViewById(R.id.ct_date_of_birth);
            ct_gender= itemView.findViewById(R.id.ct_gender);

        }
    }
}
