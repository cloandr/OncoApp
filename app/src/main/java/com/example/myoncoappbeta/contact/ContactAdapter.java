package com.example.myoncoappbeta.contact;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myoncoappbeta.R;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ViewHolder>{

    /**
     * Cette classe programme l'affichage l'adapter pour l'affichage de la liste des contacts
     */

    Context context;
    List<ContactModel> contactList;


    public ContactAdapter(List<ContactModel>contactList){

        this.contactList =contactList;


    }


    @NonNull
    @Override
    public ContactAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_appointment_item,parent,false);
        ContactAdapter.ViewHolder viewHolder = new ContactAdapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.firstname.setText(contactList.get(position).getFirstname());
        holder.lastname.setText(contactList.get(position).getLastname());
        holder.speciality.setText(contactList.get(position).getSpeciality());

    }



    @Override
    public int getItemCount() {
        return contactList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView firstname, lastname, speciality;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            firstname = itemView.findViewById(R.id.firstnameContact);
            lastname = itemView.findViewById(R.id.nameContact);
            speciality = itemView.findViewById(R.id.speciality);


        }
    }
}
