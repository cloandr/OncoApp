package com.example.myoncoappbeta.treatment;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.AppCompatCheckBox;
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
import android.widget.ImageButton;
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

public class TreatmentNewFragment extends Fragment {

    AppCompatCheckBox everyday;
    ImageButton beginDate_btn, endDate_btn, time1_btn, time2_btn,time3_btn;
    Button save_btn;
    DatePickerDialog.OnDateSetListener dateSetListener, dateSetListener2;
    TimePickerDialog.OnTimeSetListener timeSetListener1, timeSetListener2, timeSetListener3;
    TextView dateETv, dateBTv,timeTv1, timeTv2, timeTv3;
    List<String> listeA, listeD;
    ArrayAdapter<String> adapterA, adapterD;
    EditText title, dose;
    String newItemA, newItemD;





    public TreatmentNewFragment() {
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
        View thisView = inflater.inflate(R.layout.fragment_treatment_new, container, false);

        //Variables pour le time picker

        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int date = calendar.get(Calendar.DAY_OF_MONTH);
        int hour = calendar.get(Calendar.HOUR);
        int min = calendar.get(Calendar.MINUTE);
        boolean is24Hour = true;

        //attributs saisies par l'utilisateur

        title = (EditText) thisView.findViewById(R.id.nameMedicine);
        dose = (EditText) thisView.findViewById(R.id.doseText);

        //Selection de la date de début
        dateBTv = (TextView) thisView.findViewById(R.id.dateDebutToSet);
        beginDate_btn =  (ImageButton) thisView.findViewById(R.id.selectDateDebut);
        beginDate_btn.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {
                DatePickerDialog dialog = new DatePickerDialog(getContext(), Theme_DeviceDefault_Dialog,dateSetListener,year,month,date);
                dialog.show();

            }
        });
        dateSetListener = new DatePickerDialog.OnDateSetListener() {
               @SuppressLint("NonConstantResourceId")
                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                    month = month + 1;
                    String date = dayOfMonth + "/" + month + "/" + year;
                    dateBTv.setText(date);

                }
            };

        //sselection de la date de fin
        dateETv = (TextView) thisView.findViewById(R.id.dateFinToSet);
        endDate_btn =  (ImageButton) thisView.findViewById(R.id.selectDateFin);
        endDate_btn.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {
                DatePickerDialog dialog = new DatePickerDialog(getContext(), Theme_DeviceDefault_Dialog,dateSetListener2,year,month,date);
                dialog.show();

            }
        });
        dateSetListener2 = new DatePickerDialog.OnDateSetListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month = month + 1;
                String date = dayOfMonth + "/" + month + "/" + year;
                dateETv.setText(date);

            }
        };

        //selection de l'heure de la 1ère pruse de ka journée
        timeTv1 = (TextView) thisView.findViewById(R.id.tpTV1);
        time1_btn = (ImageButton) thisView.findViewById(R.id.selectTime1);
        time1_btn.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {
                TimePickerDialog timePickerDialog = new TimePickerDialog(getContext(), Theme_DeviceDefault_Dialog, timeSetListener1, hour, min, is24Hour);

                timePickerDialog.show();
            }
        });

        timeSetListener1 = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                String timeString = hourOfDay + " : " +minute;
                timeTv1.setText(timeString);

            }
        };

        //Selection de la deuxième prise de la journée
        timeTv2 = (TextView) thisView.findViewById(R.id.tpTV2);
        time2_btn = (ImageButton) thisView.findViewById(R.id.selectTime2);
        time2_btn.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {
                TimePickerDialog timePickerDialog = new TimePickerDialog(getContext(), Theme_DeviceDefault_Dialog, timeSetListener2, hour, min, is24Hour);

                timePickerDialog.show();
            }
        });

        timeSetListener2 = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                String timeString = hourOfDay + " : " +minute;
                timeTv2.setText(timeString);

            }
        };

        //Selection de la 3ème prise de la journée
        timeTv3 = (TextView) thisView.findViewById(R.id.tpTV3);
        time3_btn = (ImageButton) thisView.findViewById(R.id.selectTime3);
        time3_btn.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {
                TimePickerDialog timePickerDialog = new TimePickerDialog(getContext(), Theme_DeviceDefault_Dialog, timeSetListener3, hour, min, is24Hour);

                timePickerDialog.show();
            }
        });

        timeSetListener3 = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                String timeString = hourOfDay + " : " +minute;
                timeTv3.setText(timeString);

            }
        };

        Spinner spinnerA = thisView.findViewById(R.id.spinnerAdministration);
        listeA  = Arrays.asList("Orale","Injection intraveineuse","Injection intramusculaire","Pulmonaire");
        adapterA = new ArrayAdapter<>(this.getActivity(), android.R.layout.simple_spinner_item, listeA);
        adapterA.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerA.setAdapter(adapterA);
        spinnerA.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                newItemA = spinnerA.getSelectedItem().toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //Sélections du type de dosage
        Spinner spinnerD = thisView.findViewById(R.id.spinnerDosage);
        listeD  = Arrays.asList("mg","mL","Pilule(s)","Goblet(s)","Injection(s)","Cuillère(s) à café","Cuillère(s) à soupe","Pastille(s)","Spray(s)","Patch(s)");
        adapterD = new ArrayAdapter<>(this.getActivity(), android.R.layout.simple_spinner_item, listeD);
        adapterD.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerD.setAdapter(adapterD);
        spinnerD.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                newItemD = spinnerD.getSelectedItem().toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //Enregistrements dans la base de données

        save_btn = thisView.findViewById(R.id.saveT_btn);
        save_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name_txt = title.getText().toString().trim();
                String mode_txt = newItemA;
                String dose_txt =  dose.getText().toString().trim();
                String unit_txt = newItemD;
                String start_txt =  dateBTv.getText().toString().trim();
                String end_txt =  dateETv.getText().toString().trim();
                String f1_txt = timeTv1.getText().toString().trim();
                String f2_txt =  timeTv2.getText().toString().trim();
                String f3_txt = timeTv3.getText().toString().trim();

                TreatmentModel model = new TreatmentModel();
                model.setTitle(name_txt);
                model.setMode(mode_txt);
                model.setDose(dose_txt);
                model.setUnit(unit_txt);
                model.setStart(start_txt);
                model.setEndate(end_txt);
                model.setFreq1(f1_txt);
                model.setFreq2(f2_txt);
                model.setFreq3(f3_txt);

               //Enregistrement à la BDD
                MainActivity.databse.getTreatmentDao().addTreatment(model);
               Toast.makeText(getContext(), "Enregistré" , Toast.LENGTH_SHORT).show();
                title.setText(" ");

                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.host, new TreatmentListFragment());
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

}