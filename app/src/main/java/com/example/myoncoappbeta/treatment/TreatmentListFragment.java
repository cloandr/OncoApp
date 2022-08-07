package com.example.myoncoappbeta.treatment;

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

import com.example.myoncoappbeta.R;
import com.example.myoncoappbeta.MainActivity;

import java.util.List;


public class TreatmentListFragment extends Fragment {

    /**
     * Affichage de la liste des médicaments à prendre
     * Erreur : error thread lors de la création du recyclerview
     */

    private Button addTreatment ;
    public ImageButton back;
    public RecyclerView recyclerView;
    public RecyclerView.LayoutManager layoutManager;
    public TreatmentAdapter adapter;



    public TreatmentListFragment() {
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
        View thisView= inflater.inflate(R.layout.fragment_treatment_list, container, false);
        addTreatment = thisView.findViewById(R.id.addTreatmentBtn);
        addTreatment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.host, new TreatmentNewFragment());
                ft.addToBackStack(null);
                ft.commit();
            }
        });

        /**
         * Code exécutable sans la partie ci-dessous commentée
         * création du recycler view
         * Mise à jour du recycler view*/

        recyclerView = thisView.findViewById(R.id.treatmentRv);
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        List<TreatmentModel> list = MainActivity.databse.getTreatmentDao().getTreatment();
        adapter= new TreatmentAdapter(list);
        recyclerView.setAdapter(adapter);

        return thisView;
    }
}