package com.example.myoncoappbeta.treatment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myoncoappbeta.R;

public class TreatmentAdapter extends RecyclerView.Adapter<TreatmentAdapter.ViewHolder> {

    /**
     * Cette classe programme l'affichage l'adapter pour l'affichage de la liste de
     * la prise des médicaments
     */
    List<TreatmentModel> treatmentModelList;

    public TreatmentAdapter(List<TreatmentModel> treatmentModelList){
        this.treatmentModelList=treatmentModelList;
    }

    @NonNull
    @Override
    public TreatmentAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_treatment_item,parent,false);
        TreatmentAdapter.ViewHolder viewHolder = new TreatmentAdapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull TreatmentAdapter.ViewHolder holder, int position) {
        holder.nameMed.setText(treatmentModelList.get(position).getTitle());
        holder.modeMed.setText(treatmentModelList.get(position).getMode());
        holder.doseMed.setText(treatmentModelList.get(position).getDose());
        holder.unitMed.setText(treatmentModelList.get(position).getUnit());
        holder.startingdate.setText(treatmentModelList.get(position).getStart());
        holder.endingdate.setText(treatmentModelList.get(position).getEndate());
        holder.freq1.setText(treatmentModelList.get(position).getFreq1());
        holder.freq2.setText(treatmentModelList.get(position).getFreq2());
        holder.freq3.setText(treatmentModelList.get(position).getFreq3());



    }

    @Override
    public int getItemCount() {
        return treatmentModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView nameMed, modeMed, doseMed, unitMed, freq1, freq2, freq3, startingdate,endingdate;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nameMed = itemView.findViewById(R.id.nameMed);
            modeMed = itemView.findViewById(R.id.modeMed);
            doseMed=itemView.findViewById(R.id.doseMed);
            unitMed=itemView.findViewById(R.id.unitMed);
            freq1=itemView.findViewById(R.id.freq1);
            freq2=itemView.findViewById(R.id.freq2);
            freq3=itemView.findViewById(R.id.freq3);
            startingdate=itemView.findViewById(R.id.startingdate);
            endingdate=itemView.findViewById(R.id.endingdate);







        }
    }
}
