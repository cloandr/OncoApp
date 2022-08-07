package com.example.myoncoappbeta.appointment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.myoncoappbeta.MainActivity;
import com.example.myoncoappbeta.wiki.MainMenuFragment;
import com.example.myoncoappbeta.R;

import java.util.List;


public class AppointmentListFragment extends Fragment {

    /**
     * Affichage de la liste des rdv
     * Erreur : error thread lors de la création du recyclerview
     */
    public Button addNewRdv, test;
    public ImageButton back;
    public RecyclerView recyclerView;
    public RecyclerView.LayoutManager layoutManager;
    public AppointmentAdapter adapter;


    public AppointmentListFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View thisView = inflater.inflate(R.layout.fragment_appointment_lsit, container, false);

        // Bouton d'accès pour vers le fragment pour ajouter un rendez vous
        addNewRdv = thisView.findViewById(R.id.addAppontmentBtn);
        addNewRdv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.host, new AppointmentNewFragment());
                ft.addToBackStack(null);
                ft.commit();

            }
        });

        //Bouton retour vers la page d'accueil

        back = thisView.findViewById(R.id.imageButtonbck);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.host, new MainMenuFragment());
                ft.addToBackStack(null);
                ft.commit();
            }
        });

        /**
         * Code exécutable sans la partie ci-dessous commentée
         * création du recycler view
         * Mise à jour du recycler view*/


        recyclerView = thisView.findViewById(R.id.appointmentRv);
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        List<AppointmentModel> list = MainActivity.databse.getAppointmentDao().getAppointment();
        adapter= new AppointmentAdapter(list);
        recyclerView.setAdapter(adapter);






        return thisView;
    }
}