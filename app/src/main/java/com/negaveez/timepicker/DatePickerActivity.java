package com.negaveez.timepicker;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.net.ParseException;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DatePickerActivity extends AppCompatActivity  implements View.OnClickListener
{
    int year,month,day,dateFlag=0;
    static final int DATE_DIALOG_ID = 999;
    DatePicker dp_titter_removal_date;
    TextView txt_titter_Removal_Date, textView;;
    String litter_removal_date;
    Button btnTitterRemovalDate;
    int  hour, minute;
    int myday, myMonth, myYear, myHour, myMinute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_picker);

        dp_titter_removal_date = (DatePicker)findViewById(R.id.dp_titter_Removal_Date);
        txt_titter_Removal_Date = findViewById(R.id.txt_titter_Removal_Date);

        textView = findViewById(R.id.textView);

        btnTitterRemovalDate = (Button)findViewById(R.id.btn_titter_Removal_Date);
        btnTitterRemovalDate.setOnClickListener(this);

        
    }
    @Override
    protected Dialog onCreateDialog(int id)
    {
        switch (id)
        {
            case DATE_DIALOG_ID: 								// Dialog for Litter Removal Date
                // set date picker as current date
                return new DatePickerDialog(this, datePickerListener, year, month,day);
        }
        return null;

    }


    private DatePickerDialog.OnDateSetListener datePickerListener = new DatePickerDialog.OnDateSetListener()
    {
        public void onDateSet(DatePicker view, int selectedYear, int selectedMonth, int selectedDay)
        {
            year = selectedYear;
            month = selectedMonth;
            day = selectedDay;

            Calendar mcurrentTime = Calendar.getInstance();
            hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
            minute = mcurrentTime.get(Calendar.MINUTE);

            TimePickerDialog mTimePicker = new TimePickerDialog(DatePickerActivity.this, new TimePickerDialog.OnTimeSetListener()
            {
                public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute)
                {
                    String time = selectedHour + ":" + selectedMinute;

                    SimpleDateFormat fmt = new SimpleDateFormat("HH:mm");

                    SimpleDateFormat fmtOut = new SimpleDateFormat("hh:mm aa");

                    Date date = null;
                    try {
                        date = fmt.parse(time );
                    } catch (ParseException e) {

                        e.printStackTrace();
                    } catch (java.text.ParseException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    String formattedTime = fmtOut.format(date);

                    System.out.println("formattedTime:::: "+formattedTime);

                    myHour = selectedHour;
                    myMinute = minute;
                    textView.setText("Year: " + year + "\n" +
                            "Month: " + month + "\n" +
                            "Day: " + day + "\n" +
                            "Time: " + formattedTime +"\n"+
                            "Hour: " + myHour + "\n" +
                            "Minute: " + myMinute);


                }
            }, hour, minute, true);//Yes 24 hour time
            mTimePicker.show();



        }
    };

    public void setCurrentDateOnView()
    {
        final Calendar c = Calendar.getInstance();
        year = c.get(Calendar.YEAR);
        month = c.get(Calendar.MONTH);
        day = c.get(Calendar.DAY_OF_MONTH);

        // set current date into datepicker  		//20-01-2020
        dp_titter_removal_date.init(year, month, day, null);
    }

    public void onClick(View v)
    {
        switch(v.getId())
        {

            case R.id.btn_titter_Removal_Date:
                setCurrentDateOnView();
                showDialog(DATE_DIALOG_ID);
                break;

            default :
                break;
        }
    }

}