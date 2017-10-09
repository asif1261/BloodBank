package com.example.user.bloodbank;

import android.app.DatePickerDialog;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class Calender extends AppCompatActivity {

    TextView textViewLastDonationDate2, textViewNowYouCanDonate2;
    EditText editTextEnterDate;
    Button buttonSubmit;

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    Calendar c = Calendar.getInstance();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calender);

        textViewLastDonationDate2 = (TextView) findViewById(R.id.textViewLastDonationDate2);
        textViewLastDonationDate2.setTypeface(Typeface.SANS_SERIF);
        textViewLastDonationDate2.setTypeface(textViewLastDonationDate2.getTypeface(), Typeface.BOLD);
        textViewNowYouCanDonate2  = (TextView) findViewById(R.id.textViewNowYouCanDonate2);
        textViewNowYouCanDonate2.setTypeface(Typeface.SANS_SERIF);
        textViewNowYouCanDonate2.setTypeface(textViewLastDonationDate2.getTypeface(), Typeface.BOLD);
        editTextEnterDate = (EditText) findViewById(R.id.editTextEnterDate);
        buttonSubmit = (Button) findViewById(R.id.buttonSubmit);

        // disable keyboard from showing
        editTextEnterDate.setInputType(InputType.TYPE_NULL);

        final Calendar myCalendar = Calendar.getInstance();
        final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                String myFormat = "dd/MM/yyyy";
                SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.FRENCH);
                editTextEnterDate.setText(sdf.format(myCalendar.getTime()));
            }
        };

        editTextEnterDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog dp = new DatePickerDialog(Calender.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH));
                dp.show();
            }
        });

        OnbuttonClick();

    }

    public void OnbuttonClick()
    {
        buttonSubmit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                String editTextValue = editTextEnterDate.getText().toString();
                String result = editTextEnterDate.getText().toString();
                String myFormat = "dd/MM/yyyy";
                SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.ENGLISH);

                try {
                    c.setTime(sdf.parse(editTextValue));
                    c.add(Calendar.DATE, 90);
                    Date resultdate = new Date(c.getTimeInMillis());
                    result = sdf.format(resultdate);
                    textViewNowYouCanDonate2.setText(result);
                    textViewLastDonationDate2.setText(editTextValue);

                } catch (ParseException e) {
                    e.printStackTrace();
                }

            }
        });
    }

}
