package com.example.myoncoappbeta.contact;

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

public class ContactListFragment extends Fragment {
    /**
     * Affichage de la liste des contacts
     * Erreur : error thread lors de la création du recyclerview
     */

    private Button addNewContact;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private ContactAdapter adapter;
    ImageButton previous;



    public ContactListFragment() {
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
        View thisView = inflater.inflate(R.layout.fragment_contact_lsit, container, false);

        //Bouton vers le fragment ajouter contact
        addNewContact = thisView.findViewById(R.id.addContactBtn);
        addNewContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.host, new ContactNewFragment());
                ft.addToBackStack(null);
                ft.commit();
            }
        });

        //Retour à lapage précédente
        previous = thisView.findViewById(R.id.previoustoCHome);
        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.host, new MainMenuFragment());
                ft.addToBackStack(null);
                ft.commit();
            }
        });

        //Affichage du recyclerview rend le code non exécutable


        recyclerView = thisView.findViewById(R.id.contactRv);
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        List<ContactModel> list = MainActivity.databse.getContactDao().getContact();
        adapter= new ContactAdapter(list);
        recyclerView.setAdapter(adapter);

        return thisView;
    }


}