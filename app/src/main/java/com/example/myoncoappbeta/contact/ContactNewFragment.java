package com.example.myoncoappbeta.contact;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.myoncoappbeta.MainActivity;
import com.example.myoncoappbeta.R;
import com.example.myoncoappbeta.contact.ContactListFragment;
import com.example.myoncoappbeta.contact.ContactModel;


public class ContactNewFragment extends Fragment {

    /**
     * Fragment création d'un nouveau contact*/

    Button contactSaveBtn;
    ImageButton previousPage;
    EditText firstname, name, speciality, phoneno, mail;




    public ContactNewFragment() {
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
        View thisView = inflater.inflate(R.layout.fragment_contact_new, container, false);

        //Retour à la liste de contactes
        previousPage = thisView.findViewById(R.id.previousBtntoCList);
        previousPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.host, new ContactListFragment());
                ft.addToBackStack(null);
                ft.commit();
            }
        });

        //définitions des attributs de la claqsse
        firstname = thisView.findViewById(R.id.firstNameToSet);
        name= thisView.findViewById(R.id.lastNamToSet);
        speciality = thisView.findViewById(R.id.speToSet);
        phoneno = thisView.findViewById(R.id.phone);
        mail=thisView.findViewById(R.id.mail);


        //Enregistrement des données dans la base
        contactSaveBtn = thisView.findViewById(R.id.saveContact_btn);
        contactSaveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String firstnametxt = firstname.getText().toString();
                String lastnametxt = name.getText().toString();
                String specialitytxt = speciality.getText().toString();
                String phonenotxt = phoneno.getText().toString();
                String mailtxt = mail.getText().toString();

                ContactModel model = new ContactModel();
                model.setFirstname(firstnametxt);
                model.setLastname(lastnametxt);
                model.setSpeciality(specialitytxt);
                model.setPhone(phonenotxt);
                model.setMail(mailtxt);

               MainActivity.databse.getContactDao().addContact(model);

                //MainActivity.databse.getContactDao().getContact();

                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.host, new ContactListFragment());
                ft.addToBackStack(null);
                ft.commit();


            }
        });

        return thisView;
    }
}