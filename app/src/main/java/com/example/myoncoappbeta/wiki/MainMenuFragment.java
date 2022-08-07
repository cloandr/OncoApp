package com.example.myoncoappbeta.wiki;

import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myoncoappbeta.R;
import com.example.myoncoappbeta.appointment.AppointmentListFragment;
import com.example.myoncoappbeta.contact.ContactListFragment;
import com.example.myoncoappbeta.treatment.TreatmentListFragment;


public class MainMenuFragment extends Fragment {


    /**
     * Page d'accueil
     * Menu pour naviguer entre les différents fragments
     * */

    //Déclaration des cardview
    CardView contactCv, treatmentCv, wikiCv, rdvCv;

    public MainMenuFragment() {

    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View thisView =  inflater.inflate(R.layout.fragment_main_menu, container, false);

        /**rdvBtn = thisView.findViewById(R.id.rdvListBtn);
        rdvBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.host, new AppointmentLsitFragment());
                ft.addToBackStack(null);
                ft.commit();

            }
        });**/
        rdvCv = thisView.findViewById(R.id.rdv_card);
        rdvCv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.host, new AppointmentListFragment());
                ft.addToBackStack(null);
                ft.commit();

            }
        });

        treatmentCv = thisView.findViewById(R.id.treatment_card);
        treatmentCv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.host, new TreatmentListFragment());
                ft.addToBackStack(null);
                ft.commit();
            }
        });

        contactCv = thisView.findViewById(R.id.contact_card);
        contactCv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.host, new ContactListFragment());
                ft.addToBackStack(null);
                ft.commit();
            }
        });

        wikiCv = thisView.findViewById(R.id.wiki_card);
        wikiCv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.host, new MedicalWikiFragment());
                ft.addToBackStack(null);
                ft.commit();
            }
        });

        return thisView;
    }
}