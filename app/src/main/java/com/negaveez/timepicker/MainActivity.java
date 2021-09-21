package com.negaveez.timepicker;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.net.ParseException;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.text.TextUtils;
import android.text.format.DateUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.StringTokenizer;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnOnTimePicker, btnOffTimePicker,save,get, btn_channel_one_rule_offTime_2,btn_channel_one_rule_onTime_2;
    //EditText txtDate, txtTime;
    private int mYear, mMonth, mDay, mHour, mMinute;
    int onTimeInteger,OffTimeInteger;
    String OnTime,OffTime,channelOneDeviceOnTime_2, channelOneDeviceOffTime_2;
    long lnsTime, lneTime;
    Date dateObject;
    String summary = "My String";
    String[] str2;
    List<String> VoucherIdlist = new ArrayList<String>();
    List<String> VoucherList = new ArrayList<String>();

    String StartTime, EndTime,CountTime,deviceStartNEndTime1,startDeviceArray, startNEndTime[], deviceStartNEndTimeCount;
    String startTimeHour, startTimeMinute ,startTimeAmPm, endTimeHour, endTimeMinute, endTimeAmPm;
    int startTimeHoutInt, startTimeMinuteInt,startTimeAmPmInt, endTimeHoutInt, endTimeMinuteInt, endTimeAmPmInt, countTime, timeCount;
    Calendar beginTime,endTime;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnOnTimePicker=(Button)findViewById(R.id.btn_time_on);
        btnOffTimePicker=(Button)findViewById(R.id.btn_time_off);
        save=(Button)findViewById(R.id.save);


       /* btnOnTimePicker.setOnClickListener(this);
        btnOffTimePicker.setOnClickListener(this);*/

        btn_channel_one_rule_offTime_2 = (Button)findViewById(R.id.btn_channel_one_rule_offTime_2);
        btn_channel_one_rule_offTime_2.setOnClickListener(this);
        btn_channel_one_rule_onTime_2 = (Button)findViewById(R.id.btn_channel_one_rule_onTime_2);
        btn_channel_one_rule_onTime_2.setOnClickListener(this);

        get = findViewById(R.id.get);

        btnOnTimePicker.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                onTime();
            }
        });


        btnOffTimePicker.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
              offTime();
            }
        });


        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                timeValidation();

            }
        });

        get.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                getData();

            }
        });
    }

    private void offTime()
    {

        // datePicker(); // to call date datepicker here
        TimePickerDialog mTimePicker;
        Calendar mcurrentTime = Calendar.getInstance();
        int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
        int minut = mcurrentTime.get(Calendar.MINUTE);

        mTimePicker = new TimePickerDialog(MainActivity.this, new TimePickerDialog.OnTimeSetListener()
        {
            public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute)
            {
                String time = selectedHour + ":" + selectedMinute;

                System.out.println("time::::100 "+time);

                SimpleDateFormat fmt = new SimpleDateFormat("HH:mm");

                SimpleDateFormat fmtOut = new SimpleDateFormat("hh:mm aa");

                Date date = null;
                try
                {
                    date = fmt.parse(time );
                }
                catch (ParseException e)
                {
                    e.printStackTrace();
                }
                catch (java.text.ParseException e)
                {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                String formattedTime=fmtOut.format(date);

                btnOffTimePicker.setText(formattedTime);

            }
       // }, hour, minut, false);//Yes 24 hour time
        }, hour, minut, true);//Yes 24 hour time
        mTimePicker.setTitle("Select Time");
        mTimePicker.show();

    }

    private void onTime()
    {
        // datePicker(); // to call date datepicker here
        TimePickerDialog mTimePicker;
        Calendar mcurrentTime = Calendar.getInstance();
        int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
        int minut = mcurrentTime.get(Calendar.MINUTE);

        mTimePicker = new TimePickerDialog(MainActivity.this, new TimePickerDialog.OnTimeSetListener()
        {
            public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute)
            {
                String time = selectedHour + ":" + selectedMinute;

                System.out.println("time::::146 "+time);

                SimpleDateFormat fmt = new SimpleDateFormat("HH:mm");

                SimpleDateFormat fmtOut = new SimpleDateFormat("hh:mm aa");

                Date date = null;
                try
                {
                    date = fmt.parse(time );
                }
                catch (ParseException e)
                {
                    e.printStackTrace();
                }
                catch (java.text.ParseException e)
                {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                String formattedTime=fmtOut.format(date);

                btnOnTimePicker.setText(formattedTime);

            }
        }, hour, minut, true);//Yes 24 hour time
        mTimePicker.setTitle("Select Time");
        mTimePicker.show();

    }


    private  void timeValidation()
    {
       // Long l = Long.parseLong(str);
        boolean tvalid = false;
         OnTime = btnOnTimePicker.getText().toString().trim();
        System.out.println("OnTime::::: "+OnTime);
        OffTime = btnOffTimePicker.getText().toString().trim();
        System.out.println("OffTime::::: "+OffTime);

        channelOneDeviceOnTime_2 = btn_channel_one_rule_onTime_2.getText().toString().trim();
        channelOneDeviceOffTime_2 = btn_channel_one_rule_offTime_2.getText().toString().trim();

        try
        {


            DBController db = new DBController(MainActivity.this);
            //  db.insertDeviceSetupAddRule(channelOneSetRule, channelOneSelectRoom, channelOneSelectDevice, channelOneDeviceOnTime_1,channelOneDeviceOffTime_1,day1, day2, day3, day4, day5, day6, day7);
            db.insertDeviceSetupAddRule_1( OnTime, OffTime, channelOneDeviceOnTime_2,channelOneDeviceOffTime_2);

            SimpleDateFormat sdf = new SimpleDateFormat("hh:mm");
            Date inTime = sdf.parse(OnTime);
            Date outTime = sdf.parse(OffTime);

            System.out.println("inTime:::: "+inTime);
            System.out.println("outTime:::: "+outTime);

           // int dateDelta = inTime.compareTo(outTime);
            int dateDelta = outTime.compareTo(inTime);
            System.out.println("dateDelta::::: "+dateDelta);
            switch (dateDelta)
            {
                case 0:
                    //startTime and endTime not **Equal**
                    Log.d("Aditya:","Equal");
                    Toast.makeText(this, "Equal : "+dateDelta, Toast.LENGTH_LONG).show();
                    break;
                case 1:
                    //endTime is **Greater** then startTime
                    Log.d("Aditya:","Greater");
                    Toast.makeText(this, "Greater : "+dateDelta, Toast.LENGTH_LONG).show();
                    break;
                case -1:
                    //startTime is **Greater** then endTime
                    Log.d("Aditya:","Less than");
                    Toast.makeText(this, "Less than : "+dateDelta, Toast.LENGTH_LONG).show();
                    break;
            }

        }
        catch (NumberFormatException | java.text.ParseException e)
        {
            e.printStackTrace();
            System.out.println("not a number 176");
        }

        Calendar beginTime = Calendar.getInstance();
        beginTime.set(2021, 8, 20, 20, 30);
        Calendar endTime = Calendar.getInstance();
        endTime.set(2021, 8, 20, 21, 30);

        Intent intent = new Intent(Intent.ACTION_INSERT)
                .setData(CalendarContract.Events.CONTENT_URI)
                .putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, beginTime.getTimeInMillis())
                .putExtra(CalendarContract.EXTRA_EVENT_END_TIME, endTime.getTimeInMillis())
                .putExtra(CalendarContract.Events.TITLE, "Yoga")
                .putExtra(CalendarContract.Events.DESCRIPTION, "Group class")
                .putExtra(CalendarContract.Events.EVENT_LOCATION, "The gym")
                .putExtra(CalendarContract.Events.AVAILABILITY, CalendarContract.Events.AVAILABILITY_BUSY);
               // .putExtra(Intent.EXTRA_EMAIL, "rowan@example.com,trevor@example.com");
        startActivity(intent);
    }

    @Override
    public void onClick(View v)
    {

        switch(v.getId())
        {

            case R.id.btn_channel_one_rule_onTime_2:
                addRuleDeviceOnTimeTwo();
                break;

            case R.id.btn_channel_one_rule_offTime_2:
                addRuleDeviceOffTimeTwo();
                break;

            default :
                break;
        }
    }

    private void getData()
    {
        DBController db = new DBController(MainActivity.this);
        String getChannelOne = db.getDeviceSetupAddRule();

        System.out.println("My databse ::::: "+getChannelOne);

        String[] StartTime1 = getChannelOne.split("#:#:#");
        String deviceStartNEndTime1 = StartTime1[0];
        System.out.println("deviceStartNEndTime1:::: "+deviceStartNEndTime1);
        String deviceStartNEndTimeCount = StartTime1[1];
        int timeCount = Integer.parseInt(deviceStartNEndTimeCount);

        System.out.println("timeCount::: "+timeCount);


        for (int i = 1; i <= timeCount; i++)
        {
            //--------To split data-------------
            str2 = deviceStartNEndTime1.split("\n");

            StringTokenizer stringtokenizer2 = new StringTokenizer(str2[i], ">");
            while (stringtokenizer2.hasMoreElements())
            {
                StartTime = stringtokenizer2.nextElement().toString();
                EndTime = stringtokenizer2.nextElement().toString();

                System.out.println("StartTime::::: "+StartTime);
                System.out.println("EndTime::::: "+EndTime);

                startTimeHour = StartTime.substring(0,2).trim(); // 02
                startTimeHoutInt  = Integer.parseInt(startTimeHour);

                startTimeMinute = StartTime.substring(3,6).trim(); //23
                startTimeMinuteInt  = Integer.parseInt(startTimeMinute);

                startTimeAmPm = StartTime.substring(6,8).trim(); //am

                //*********************************

                endTimeHour = EndTime.substring(0,2).trim(); // 02
                endTimeHoutInt  = Integer.parseInt(endTimeHour);

                endTimeMinute = EndTime.substring(3,5).trim(); //23
                endTimeMinuteInt  = Integer.parseInt(endTimeMinute);

                endTimeAmPm = EndTime.substring(6,8).trim();

                VoucherIdlist.add(StartTime);
                VoucherList.add(EndTime);
            }



            beginTime = Calendar.getInstance();
           // beginTime.set(2021, 8, 20, 20, 30);
            beginTime.set(2021, 8, 20, startTimeHoutInt, startTimeMinuteInt);

            endTime = Calendar.getInstance();
            //endTime.set(2021, 8, 20, 21, 30);
            endTime.set(2021, 8, 20, endTimeHoutInt, endTimeMinuteInt);



            Intent intent = new Intent(Intent.ACTION_INSERT)
                    .setData(CalendarContract.Events.CONTENT_URI)
                    .putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, beginTime.getTimeInMillis())
                    .putExtra(CalendarContract.EXTRA_EVENT_END_TIME, endTime.getTimeInMillis())
                    .putExtra(CalendarContract.Events.TITLE, "Yoga")
                    .putExtra(CalendarContract.Events.DESCRIPTION, "Group class")
                    .putExtra(CalendarContract.Events.EVENT_LOCATION, "The gym")
                    .putExtra(CalendarContract.Events.AVAILABILITY, CalendarContract.Events.AVAILABILITY_BUSY);
            // .putExtra(Intent.EXTRA_EMAIL, "rowan@example.com,trevor@example.com");
            startActivity(intent);


           /* startTime = Calendar.getInstance();
            startTime.set(Calendar.HOUR_OF_DAY, startTimeHoutInt);
            startTime.set(Calendar.MINUTE, startTimeMinuteInt);
            startTime.set(Calendar.MONTH, newMonth - 1);
            startTime.set(Calendar.YEAR, newYear);

            endTime = (Calendar) startTime.clone();
            endTime.set(Calendar.HOUR_OF_DAY,endTimeHoutInt);
            endTime.set(Calendar.MINUTE, endTimeMinuteInt);
            //  endTime.add(Calendar.HOUR, 1);
            // endTime.set(Calendar.MONTH, newMonth - 1);
           // event = new WeekViewEvent(timeCount, getEventTitle(startTime), startTime, endTime);
           // event.setColor(getResources().getColor(R.color.event_color_01));
          //  events.add(event);
*/
        }


    }


    private void addRuleDeviceOnTimeTwo()
    {
        // datePicker(); // to call date datepicker here
        TimePickerDialog mTimePicker;
        Calendar mcurrentTime = Calendar.getInstance();
        int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
        int minut = mcurrentTime.get(Calendar.MINUTE);

        mTimePicker = new TimePickerDialog(MainActivity.this, new TimePickerDialog.OnTimeSetListener()
        {
            public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute)
            {
                String time = selectedHour + ":" + selectedMinute;

                SimpleDateFormat fmt = new SimpleDateFormat("HH:mm");

                SimpleDateFormat fmtOut = new SimpleDateFormat("hh:mm aa");

                Date date = null;
                try
                {
                    date = fmt.parse(time );
                }
                catch (ParseException e)
                {
                    e.printStackTrace();
                }
                catch (java.text.ParseException e)
                {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                String formattedTime=fmtOut.format(date);

                btn_channel_one_rule_onTime_2.setText(formattedTime);

            }
        }, hour, minut, true);//Yes 24 hour time
        mTimePicker.setTitle("Select Time");
        mTimePicker.show();
    }

    private void addRuleDeviceOffTimeTwo()
    {

        //datePickerOffTime(); // to call date datepicker here
        TimePickerDialog mTimePicker;
        Calendar mcurrentTime = Calendar.getInstance();
        int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
        int minut = mcurrentTime.get(Calendar.MINUTE);

        mTimePicker = new TimePickerDialog(MainActivity.this, new TimePickerDialog.OnTimeSetListener()
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
                String formattedTime=fmtOut.format(date);

                btn_channel_one_rule_offTime_2.setText(formattedTime);

            }
        }, hour, minut, true);//Yes 24 hour time
        mTimePicker.setTitle("Select Time");
        mTimePicker.show();

    }


   /* @Override
    public void onClick(View v)
    {
        if (v == btnDatePicker)
        {
            // Get Current Date
            final Calendar c = Calendar.getInstance();
            mYear = c.get(Calendar.YEAR);
            mMonth = c.get(Calendar.MONTH);
            mDay = c.get(Calendar.DAY_OF_MONTH);


            DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener()
            {
                        @Override
                        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth)
                        {

                            txtDate.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                        }
                    }, mYear, mMonth, mDay);
            datePickerDialog.show();
        }
        if (v == btnTimePicker) {

            // Get Current Time
            final Calendar c = Calendar.getInstance();
            mHour = c.get(Calendar.HOUR_OF_DAY);
            mMinute = c.get(Calendar.MINUTE);

            // Launch Time Picker Dialog
            TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                    new TimePickerDialog.OnTimeSetListener() {

                        @Override
                        public void onTimeSet(TimePicker view, int hourOfDay,
                                              int minute) {

                            txtTime.setText(hourOfDay + ":" + minute);
                        }
                    }, mHour, mMinute, false);
            timePickerDialog.show();
        }
    }*/
}