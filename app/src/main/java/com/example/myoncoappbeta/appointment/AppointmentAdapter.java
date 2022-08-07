package com.example.myoncoappbeta.appointment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myoncoappbeta.R;


public class AppointmentAdapter extends RecyclerView.Adapter<AppointmentAdapter.ViewHolder> {

    /**
     * Cette classe programme l'affichage l'adapter pour l'affichage de la liste des rendez-vous
     */
    Context context;
    List<AppointmentModel> appointmentList;


    public AppointmentAdapter(List<AppointmentModel>appointmentList){

        this.appointmentList=appointmentList;


    }


    @NonNull
    @Override
    public AppointmentAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_appointment_item,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull AppointmentAdapter.ViewHolder holder, int position) {
        holder.title.setText(appointmentList.get(position).getTitle());
        holder.doctor.setText(appointmentList.get(position).getDoctor_name());
        holder.starting_date.setText(appointmentList.get(position).getStarting_date());
        holder.hour.setText(appointmentList.get(position).getHour());
        holder.rdv_type.setText(appointmentList.get(position).getRdv_type());



    }

    @Override
    public int getItemCount() {
        return appointmentList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView title, doctor, starting_date, hour, rdv_type;

        /**
         *
         * Paramétrage de l'affichage d'un item de la liste
         * Avec les différents Tv où les données s'afficheront
         */

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            rdv_type = itemView.findViewById(R.id.typedisplay);
            title = itemView.findViewById(R.id.titledisplay);
            doctor = itemView.findViewById(R.id.docdisplay);
            starting_date = itemView.findViewById(R.id.datedisplay);
            hour = itemView.findViewById(R.id.timedisplay);

        }
    }
}
