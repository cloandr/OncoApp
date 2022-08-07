package com.example.myoncoappbeta.appointment;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import static android.R.style.Theme_DeviceDefault_Dialog;

import com.example.myoncoappbeta.MainActivity;
import com.example.myoncoappbeta.R;
import com.example.myoncoappbeta.appointment.AppointmentListFragment;
import com.example.myoncoappbeta.appointment.AppointmentModel;


public class AppointmentNewFragment extends Fragment {

    /**
     * Ajouter un nouveau rendez-vous*/

    Button saveBtn, dateBtn, timeBtn;
    EditText title, doctor;
    TextView dateTv, timeTv;
    DatePickerDialog.OnDateSetListener dateSetListener;
    TimePickerDialog.OnTimeSetListener timeSetListener;
    List<String> listeType;
    ArrayAdapter<String> adapter;
    String newItem;
    Button backListRdv;


    public AppointmentNewFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @SuppressLint("WrongViewCast")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View thisView = inflater.inflate(R.layout.fragment_appointment_new, container, false);

        title = (EditText) thisView.findViewById(R.id.setTitle);
        doctor = (EditText) thisView.findViewById(R.id.setDoc);

        //Selectionner une date
        dateTv = (TextView) thisView.findViewById(R.id.dateToSet);
        dateBtn =  (Button) thisView.findViewById(R.id.selectDate);
        dateBtn.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {
                showDatePickerDialog();

            }
        });

        dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month = month+1;
                String date = dayOfMonth + "/" + month +"/" + year;
                dateTv.setText(date);



            }
        };

        //Selectionner une heure
        timeTv = (TextView) thisView.findViewById(R.id.timeToSet);
        timeBtn = (Button) thisView.findViewById(R.id.selectTime);
        timeBtn.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {
                showTimePickerDialog();
            }
        });

        timeSetListener = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                String timeString = hourOfDay + " : " +minute;
                timeTv.setText(timeString);

            }
        };

        //Selectionner le type de rendez-vous : choix par liste
        Spinner spinner = thisView.findViewById(R.id.spinner_rdv);
        listeType  = Arrays.asList("Consultation","Examen","Chimiothérapie","Radiothérapie");
        adapter = new ArrayAdapter<>(this.getActivity(), android.R.layout.simple_spinner_item, listeType);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                newItem = spinner.getSelectedItem().toString();
                Toast.makeText(getContext(), "Tu as sélectionné :" + newItem, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        /**
         * Code non exécutable avec la partie ci'dessous commentée
         * Enregistrement des données dans la base*/



        saveBtn = thisView.findViewById(R.id.saveBtn_appointment);
        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title_txt = title.getText().toString();
                String doctor_txt = doctor.getText().toString().trim();
                String date_txt =  dateTv.getText().toString().trim();
                String time_txt = timeTv.getText().toString().trim();
                String type_txt = newItem;

                AppointmentModel model = new AppointmentModel();
                model.setTitle(title_txt);
                model.setDoctor_name(doctor_txt);
                model.setStarting_date(date_txt);
                model.setHour(time_txt);
                model.setRdv_type(type_txt);

                MainActivity.databse.getAppointmentDao().addAppointment(model);

                Toast.makeText(getContext(), "Enregistré" , Toast.LENGTH_SHORT).show();

                title.setText(" ");
                doctor.setText(" ");
                dateTv.setText("Date");
                timeTv.setText("Heure");
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.host, new AppointmentListFragment());
                ft.addToBackStack(null);
                ft.commit();


            }
        });

    //Retour au fragment précédent
        backListRdv = (Button) thisView.findViewById(R.id.backRdvBtn);
        backListRdv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.host, new AppointmentListFragment());
                ft.addToBackStack(null);
                ft.commit();
            }
        });

        return thisView;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void showDatePickerDialog(){
        Calendar calendar = Calendar.getInstance();

        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int date = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog dialog = new DatePickerDialog(getContext(), Theme_DeviceDefault_Dialog,dateSetListener,year,month,date);
        dialog.show();


    }
    @RequiresApi(api = Build.VERSION_CODES.N)
    private void showTimePickerDialog(){
        Calendar calendar = Calendar.getInstance();

        int hour = calendar.get(Calendar.HOUR);
        int min = calendar.get(Calendar.MINUTE);
        boolean is24Hour = true;

        TimePickerDialog timePickerDialog = new TimePickerDialog(getContext(), Theme_DeviceDefault_Dialog, timeSetListener, hour, min, is24Hour);

        timePickerDialog.show();

    }



}