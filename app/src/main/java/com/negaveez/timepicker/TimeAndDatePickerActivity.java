package com.negaveez.timepicker;

import androidx.appcompat.app.AppCompatActivity;

import android.net.ParseException;
import android.os.Bundle;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static android.content.ContentValues.TAG;

public class TimeAndDatePickerActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener
{
    TextView textView;
    Button button;
    int day, month, year, hour, minute;
    int myday, myMonth, myYear, myHour, myMinute;
    Calendar date;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_and_date_picker);

        textView = findViewById(R.id.textView);
        button = findViewById(R.id.btnPick);
        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Calendar calendar = Calendar.getInstance();
                year = calendar.get(Calendar.YEAR);
                month = calendar.get(Calendar.MONTH);
                day = calendar.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog datePickerDialog = new DatePickerDialog(TimeAndDatePickerActivity.this, TimeAndDatePickerActivity.this,year, month,day);
                datePickerDialog.show();

               // showDateTimePicker();
            }
        });
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth)
    {
        myYear = year;
        myday = day;
        myMonth = month;
     //   Calendar c = Calendar.getInstance();
      //  hour = c.get(Calendar.HOUR);
      //  minute = c.get(Calendar.MINUTE);
     //   TimePickerDialog timePickerDialog = new TimePickerDialog(TimeAndDatePickerActivity.this, TimeAndDatePickerActivity.this, hour, minute, DateFormat.is24HourFormat(this));
     //   TimePickerDialog timePickerDialog = new TimePickerDialog(TimeAndDatePickerActivity.this, TimeAndDatePickerActivity.this, hour, minute,false);
     //   timePickerDialog.show();

        //*****************************
       /// TimePickerDialog mTimePicker;
        Calendar mcurrentTime = Calendar.getInstance();
    //    int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
        hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
       // int minut = mcurrentTime.get(Calendar.MINUTE);
        minute = mcurrentTime.get(Calendar.MINUTE);

        TimePickerDialog mTimePicker = new TimePickerDialog(TimeAndDatePickerActivity.this, new TimePickerDialog.OnTimeSetListener()
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
             //   btn_channel_one_rule_offTime_2.setText(formattedTime);

                myHour = selectedHour;
                myMinute = minute;
                textView.setText("Year: " + myYear + "\n" +
                        "Month: " + myMonth + "\n" +
                        "Day: " + myday + "\n" +
                        "Time: " + formattedTime +"\n"+
                        "Hour: " + myHour + "\n" +
                        "Minute: " + myMinute);


            }
        }, hour, minute, true);//Yes 24 hour time
      //  mTimePicker.setTitle("Select Time");
        mTimePicker.show();


        //****************************






    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute)
    {
        myHour = hourOfDay;
        myMinute = minute;
        textView.setText("Year: " + myYear + "\n" +
                "Month: " + myMonth + "\n" +
                "Day: " + myday + "\n" +
                "Hour: " + myHour + "\n" +
                "Minute: " + myMinute);
    }


    public void showDateTimePicker() {
        final Calendar currentDate = Calendar.getInstance();
        date = Calendar.getInstance();
        new DatePickerDialog(TimeAndDatePickerActivity.this, new DatePickerDialog.OnDateSetListener()
        {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth)
            {
                date.set(year, monthOfYear, dayOfMonth);
                new TimePickerDialog(TimeAndDatePickerActivity.this, new TimePickerDialog.OnTimeSetListener()
                {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute)
                    {
                        date.set(Calendar.HOUR_OF_DAY, hourOfDay);
                        date.set(Calendar.MINUTE, minute);
                        Log.v(TAG, "The choosen one " + date.getTime());
                    }
                }, currentDate.get(Calendar.HOUR_OF_DAY), currentDate.get(Calendar.MINUTE), false).show();
            }
        }, currentDate.get(Calendar.YEAR), currentDate.get(Calendar.MONTH), currentDate.get(Calendar.DATE)).show();
    }

}