package com.negaveez.timepicker;

/**
 * @author Aditya A Wasnik
 *
 * This class is use for create a database and its table and column
 *
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.ByteArrayOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DBController extends SQLiteOpenHelper
{
    // All Static variables
    public Context context;

    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "DeviceDatabase.db";

    // Contacts table name
    private static final String TABLE_DEVICEINFO = "device_info"; // main table  when we inner join
    private static final String TABLE_DEVICENAME = "table_device_name";


    private static final String TABLE_MACADDRESS = "table_mac_address";
    private static final String MAC_DEVICE_ID = "mac_device_id";
    private static final String MAC_DEVICE_NAME = "mac_device_name";
    private static final String MAC_ADDRESS = "mac_address";
    private static final String MAC_SELECT_DEVICE = "mac_select_device";
    private static final String MAC_SELECT_DEVICE_STATUS_IMAGE = "mac_select_device_status_image";
    private static final String MAC_SELECT_DEVICE_IMAGE = "mac_select_device_image";
    private static final String MAC_SELECT_DEVICE_IMAGE_FLAG = "mac_select_device_image_flag";

    private static final String DEVICE_NAME_ID = "device_name_id";
    private static final String DEVICE_NAME = "device_name";
    private static final String MAC_ADDRESS_ID_FK = "mac_address_id_fk";

    // MyDevice Summary table
    private static final String TABLE_MYDEVICE_SUMMARY = "table_mydevice_summary";
    private static final String DEVICE_MYDEVICE_SUMMARY_ID = "device_mydevice_summary_id";
    private static final String DEVICE_MYDEVICE_SUMMARY_DEVICE = "device_mydevice_summary_device";
    private static final String DEVICE_MYDEVICE_SUMMARY_NAME = "device_mydevice_summary_name";
    private static final String DEVICE_MYDEVICE_SUMMARY_LOCATION = "device_mydevice_summary_location";
    private static final String DEVICE_MYDEVICE_SUMMARY_STATUS = "device_mydevice_summary_status";

    // table Location from MainActicity
    private static final String TABLE_LOCATION = "table_location";
    private static final String LOCATION_ID = "location_id";
    private static final String LOCATION = "location";

    // table NAme from SensorModelFragment
    private static final String TABLE_NAME = "table_name";
    private static final String NAME_ID = "name_id";
    private static final String NAME = "name";
    private static final String DEVICE_IMAGE = "device_image";

    //******** table NAme for device setup add rule activity ********************
    private static final String TABLE_DEVICE_SETUP_ADD_RULE_1 = "table_device_setup_add_rule_1";
    private static final String DEVICE_SETUP_ADD_RULE_ID_1 = "device_setup_add_rule_id_1";

    private static final String DEVICE_SETUP_ADD_RULE_SELECT_STARTTIME1 = "device_setup_add_rule_select_starttime1";
    private static final String DEVICE_SETUP_ADD_RULE_SELECT_ENDTIME1 = "device_setup_add_rule_select_select_endtime1";
    private static final String DEVICE_SETUP_ADD_RULE_SELECT_STARTTIME2 = "device_setup_add_rule_select_starttime2";
    private static final String DEVICE_SETUP_ADD_RULE_SELECT_ENDTIME2 = "device_setup_add_rule_select_select_endtime2";




    //******** table NAme for device setup add rule activity 2 ********************
    private static final String TABLE_DEVICE_SETUP_ADD_RULE_TWO_2 = "table_device_setup_add_rule_2";
    private static final String DEVICE_SETUP_ADD_RULE_TWO_ID_2 = "device_setup_add_rule_id_2";
    private static final String DEVICE_SETUP_ADD_RULE_TWO_ADDRULE_2 = "device_setup_add_rule_addrule_2";
    private static final String DEVICE_SETUP_ADD_RULE_TWO_SELECT_ROOM_2 = "device_setup_add_rule_select_room_2";
    private static final String DEVICE_SETUP_ADD_RULE_TWO_SELECT_DEVICE_2 = "device_setup_add_rule_select_device_2";
    private static final String DEVICE_SETUP_ADD_RULE_TWO_SELECT_STARTTIME_1= "device_setup_add_rule_select_starttime_1";
    private static final String DEVICE_SETUP_ADD_RULE_TWO_SELECT_ENDTIME_1= "device_setup_add_rule_select_select_endtime_1";
    private static final String DEVICE_SETUP_ADD_RULE_TWO_SELECT_STARTTIME_2 = "device_setup_add_rule_select_starttime_2";
    private static final String DEVICE_SETUP_ADD_RULE_TWO_SELECT_ENDTIME_2 = "device_setup_add_rule_select_select_endtime_2";
    private static final String DEVICE_SETUP_ADD_RULE_TWO_SELECT_STARTTIME_3 = "device_setup_add_rule_select_starttime_3";
    private static final String DEVICE_SETUP_ADD_RULE_TWO_SELECT_ENDTIME_3 = "device_setup_add_rule_select_select_endtime_3";
    private static final String DEVICE_SETUP_ADD_RULE_TWO_SELECT_STARTTIME_4 = "device_setup_add_rule_select_starttime_4";
    private static final String DEVICE_SETUP_ADD_RULE_TWO_SELECT_ENDTIME_4 = "device_setup_add_rule_select_select_endtime_4";
    private static final String DEVICE_SETUP_ADD_RULE_TWO_SELECT_SELECT_DAY_MON_2 = "device_setup_add_rule_select_day_mon_2";
    private static final String DEVICE_SETUP_ADD_RULE_TWO_SELECT_SELECT_DAY_TUES_2= "device_setup_add_rule_select_day_tues_2";
    private static final String DEVICE_SETUP_ADD_RULE_TWO_SELECT_SELECT_DAY_WED_2 = "device_setup_add_rule_select_day_wed_2";
    private static final String DEVICE_SETUP_ADD_RULE_TWO_SELECT_SELECT_DAY_THU_2 = "device_setup_add_rule_select_day_thu_2";
    private static final String DEVICE_SETUP_ADD_RULE_TWO_SELECT_SELECT_DAY_FRI_2= "device_setup_add_rule_select_day_fri_2";
    private static final String DEVICE_SETUP_ADD_RULE_TWO_SELECT_SELECT_DAY_SAT_2 = "device_setup_add_rule_select_day_sat_2";
    private static final String DEVICE_SETUP_ADD_RULE_TWO_SELECT_SELECT_DAY_SUN_2 = "device_setup_add_rule_select_day_sun_2";
    private static final String  DEVICE_SETUP_ADD_RULE_TWO_SELECT_FLAG = "device_setup_add_rule_two_flag";

    //***************
    //******** table NAme for device setup add rule activity 3 ********************
    private static final String TABLE_DEVICE_SETUP_ADD_RULE_THREE_3 = "table_device_setup_add_rule_3";
    private static final String DEVICE_SETUP_ADD_RULE_THREE_ID_3 = "device_setup_add_rule_id_3";
    private static final String DEVICE_SETUP_ADD_RULE_THREE_ADDRULE_3 = "device_setup_add_rule_addrule_3";
    private static final String DEVICE_SETUP_ADD_RULE_THREE_SELECT_ROOM_3 = "device_setup_add_rule_select_room_3";
    private static final String DEVICE_SETUP_ADD_RULE_THREE_SELECT_DEVICE_3 = "device_setup_add_rule_select_device_3";
    private static final String DEVICE_SETUP_ADD_RULE_THREE_SELECT_STARTTIME_1 = "device_setup_add_rule_select_starttime_1";
    private static final String DEVICE_SETUP_ADD_RULE_THREE_SELECT_ENDTIME_1 = "device_setup_add_rule_select_select_endtime_1";
    private static final String DEVICE_SETUP_ADD_RULE_THREE_SELECT_STARTTIME_2 = "device_setup_add_rule_select_starttime_2";
    private static final String DEVICE_SETUP_ADD_RULE_THREE_SELECT_ENDTIME_2 = "device_setup_add_rule_select_select_endtime_2";
    private static final String DEVICE_SETUP_ADD_RULE_THREE_SELECT_STARTTIME_3 = "device_setup_add_rule_select_starttime_3";
    private static final String DEVICE_SETUP_ADD_RULE_THREE_SELECT_ENDTIME_3 = "device_setup_add_rule_select_select_endtime_3";
    private static final String DEVICE_SETUP_ADD_RULE_THREE_SELECT_STARTTIME_4 = "device_setup_add_rule_select_starttime_4";
    private static final String DEVICE_SETUP_ADD_RULE_THREE_SELECT_ENDTIME_4 = "device_setup_add_rule_select_select_endtime_4";
    private static final String DEVICE_SETUP_ADD_RULE_THREE_SELECT_SELECT_DAY_MON_3 = "device_setup_add_rule_select_day_mon_3";
    private static final String DEVICE_SETUP_ADD_RULE_THREE_SELECT_SELECT_DAY_TUES_3= "device_setup_add_rule_select_day_tues_3";
    private static final String DEVICE_SETUP_ADD_RULE_THREE_SELECT_SELECT_DAY_WED_3 = "device_setup_add_rule_select_day_wed_3";
    private static final String DEVICE_SETUP_ADD_RULE_THREE_SELECT_SELECT_DAY_THU_3 = "device_setup_add_rule_select_day_thu_3";
    private static final String DEVICE_SETUP_ADD_RULE_THREE_SELECT_SELECT_DAY_FRI_3 = "device_setup_add_rule_select_day_fri_3";
    private static final String DEVICE_SETUP_ADD_RULE_THREE_SELECT_SELECT_DAY_SAT_3 = "device_setup_add_rule_select_day_sat_3";
    private static final String DEVICE_SETUP_ADD_RULE_THREE_SELECT_SELECT_DAY_SUN_3= "device_setup_add_rule_select_day_sun_3";
    private static final String  DEVICE_SETUP_ADD_RULE_THREE_SELECT_FLAG = "device_setup_add_rule_three_flag";

    //************
    //******** table NAme for device setup add rule activity ********************
    private static final String TABLE_DEVICE_SETUP_ADD_RULE_FOUR_4 = "table_device_setup_add_rule_4";
    private static final String DEVICE_SETUP_ADD_RULE_FOUR_ID_4 = "device_setup_add_rule_id_4";
    private static final String DEVICE_SETUP_ADD_RULE_FOUR_ADDRULE_4 = "device_setup_add_rule_addrule_4";
    private static final String DEVICE_SETUP_ADD_RULE_FOUR_SELECT_ROOM_4 = "device_setup_add_rule_select_room_4";
    private static final String DEVICE_SETUP_ADD_RULE_FOUR_SELECT_DEVICE_4 = "device_setup_add_rule_select_device_4";
    private static final String DEVICE_SETUP_ADD_RULE_FOUR_SELECT_STARTTIME_1 = "device_setup_add_rule_select_starttime1";
    private static final String DEVICE_SETUP_ADD_RULE_FOUR_SELECT_ENDTIME_1 = "device_setup_add_rule_select_select_endtime1";
    private static final String DEVICE_SETUP_ADD_RULE_FOUR_SELECT_STARTTIME_2 = "device_setup_add_rule_select_starttime_2";
    private static final String DEVICE_SETUP_ADD_RULE_FOUR_SELECT_ENDTIME_2 = "device_setup_add_rule_select_select_endtime_2";
    private static final String DEVICE_SETUP_ADD_RULE_FOUR_SELECT_STARTTIME_3 = "device_setup_add_rule_select_starttime_3";
    private static final String DEVICE_SETUP_ADD_RULE_FOUR_SELECT_ENDTIME_3 = "device_setup_add_rule_select_select_endtime_3";
    private static final String DEVICE_SETUP_ADD_RULE_FOUR_SELECT_STARTTIME_4 = "device_setup_add_rule_select_starttime_4";
    private static final String DEVICE_SETUP_ADD_RULE_FOUR_SELECT_ENDTIME_4 = "device_setup_add_rule_select_select_endtime_4";
    private static final String DEVICE_SETUP_ADD_RULE_FOUR_SELECT_SELECT_DAY_MON_4 = "device_setup_add_rule_select_day_mon_4";
    private static final String DEVICE_SETUP_ADD_RULE_FOUR_SELECT_SELECT_DAY_TUES_4 = "device_setup_add_rule_select_day_tues_4";
    private static final String DEVICE_SETUP_ADD_RULE_FOUR_SELECT_SELECT_DAY_WED_4 = "device_setup_add_rule_select_day_wed_4";
    private static final String DEVICE_SETUP_ADD_RULE_FOUR_SELECT_SELECT_DAY_THU_4 = "device_setup_add_rule_select_day_thu_4";
    private static final String DEVICE_SETUP_ADD_RULE_FOUR_SELECT_SELECT_DAY_FRI_4 = "device_setup_add_rule_select_day_fri_4";
    private static final String DEVICE_SETUP_ADD_RULE_FOUR_SELECT_SELECT_DAY_SAT_4 = "device_setup_add_rule_select_day_sat_4";
    private static final String DEVICE_SETUP_ADD_RULE_FOUR_SELECT_SELECT_DAY_SUN_4 = "device_setup_add_rule_select_day_sun_4";
    private static final String  DEVICE_SETUP_ADD_RULE_FOUR_SELECT_FLAG = "device_setup_add_rule_four_flag";

    //******** table NAme for SensorDeviceSchedule activity ********************
    private static final String TABLE_SENSOR_DEVICE_SCHEDULE        = "table_sensor_device_schedule";
    private static final String SENSOR_DEVICE_SCHEDULE_ID           = "sensor_device_schedule_id";
    private static final String INTRUSION_DETECTION_ONTIME_ONE      = "intrusion_detection_ontime_one";
    private static final String INTRUSION_DETECTION_OFFTIME_ONE     = "intrusion_detection_offtime_one";
    private static final String ENERGY_SAVING_MODE_ONTIME_TWO       = "energy_saving_mode_ontime_two";
    private static final String ENERGY_SAVING_MODE_OFFTIME_TWO      = "energy_saving_mode_offtime_two";
    private static final String SCHEDULED_ONOFF_ONTIME_THREE        = "scheduled_onoff_ontime_three";
    private static final String SCHEDULED_ONOFF_OFFTIME_THREE       = "scheduled_onoff_offtime_three";
    private static final String ELDERLY_CARE_ONTIME_FOUR            =  "elderly_care_ontime_four";
    private static final String ELDERLY_CARE_OFFTIME_FOUR           = "elderly_care_offtime_four";
    private static final String SENSOR_DEVICE_SCHEDULE_DAY_MON      = "sensor_device_schedule_day_mon";
    private static final String SENSOR_DEVICE_SCHEDULE_DAY_TUES     = "sensor_device_schedule_day_tues";
    private static final String SENSOR_DEVICE_SCHEDULE_DAY_WED      = "sensor_device_schedule_day_wed";
    private static final String SENSOR_DEVICE_SCHEDULE_DAY_THU      = "sensor_device_schedule_day_thu";
    private static final String SENSOR_DEVICE_SCHEDULE_DAY_FRI      = "sensor_device_schedule_day_fri";
    private static final String SENSOR_DEVICE_SCHEDULE_DAY_SAT      = "sensor_device_schedule_day_sat";
    private static final String SENSOR_DEVICE_SCHEDULE_DAY_SUN      = "sensor_device_schedule_day_sun";
    private static final String SENSOR_DEVICE_SCHEDULE_NOTIFICATION = "sensor_device_schedule_notification";
    private static final String SENSOR_DEVICE_SCHEDULE_FLAG         = "sensor_device_schedule_flag";


    //******** table NAme for user credential Register Activity ********************
    private static final String TABLE_USER_CREDENTIAL = "table_user_credential";
    private static final String USER_CREDENTIAL_ID    = "user_credential_id";
    private static final String USERNAME              = "username";
    private static final String EMAIL                 = "email";
    private static final String MOBILE_NUMBER         = "mobile_number";
    private static final String PASSWORD              = "password";


    // Contacts table name
    private static final String TABLE_DEVICENAME_DIALOG = "table_devicename_dialog";
    // Contacts Table Columns names
    private static final String DEVICENAME_DIALOG_ID = "devicename_dialog_id";
    private static final String DEVICENAME_DIALOG_DNAME = "devicename_dialog_dname";


    private static final String TABLE_DEVICE_SETUP_CHANNEL = "table_device_setup_channel";
    private static final String DEVICE_SETUP_CHANNEL_ID = "device_setup_channel_id";
    private static final String DEVICE_SETUP_CHANNEL_ONE = "device_setup_channel_one";
    private static final String DEVICE_SETUP_CHANNEL_TWO = "device_setup_channel_two";
    private static final String DEVICE_SETUP_CHANNEL_THREE = "device_setup_channel_three";
    private static final String DEVICE_SETUP_CHANNEL_FOUR = "device_setup_channel_four";

    ///
    // table NAme for notification
    private static final String TABLE_NOTIFICATION = "table_notification";
    private static final String NNOTIFICATION_ID = "notification_id";
    private static final String NOTIFICATION_MESSAGE = "notification_message";
    private static final String NOTIFICATION_TIME = "notification_time";


    Bitmap bitmap, bitmap1 ;


    public DBController(Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) //PRIMARY KEY
    {
        //************ Create table for device setup add rule *******************
        String CREATE_DEVICE_SETUP_ADD_RULE_TABLE_1 = "CREATE TABLE " + TABLE_DEVICE_SETUP_ADD_RULE_1 + "(" + DEVICE_SETUP_ADD_RULE_ID_1+
                " INTEGER PRIMARY KEY AUTOINCREMENT," + DEVICE_SETUP_ADD_RULE_SELECT_STARTTIME1 + " TEXT ,"+ DEVICE_SETUP_ADD_RULE_SELECT_ENDTIME1 + " TEXT ,"
                + DEVICE_SETUP_ADD_RULE_SELECT_STARTTIME2 + " TEXT ,"+ DEVICE_SETUP_ADD_RULE_SELECT_ENDTIME2 + " TEXT )";
        db.execSQL(CREATE_DEVICE_SETUP_ADD_RULE_TABLE_1);

    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_DEVICE_SETUP_ADD_RULE_1);
        // Create tables again
        onCreate(db);
    }

    public void insertMacAddress(String deviceName, String mac_address, String selectDevice,  int conDisconnectImage, int image, String deviceIconImageFlag) throws SQLiteException
    {
        bitmap1 = BitmapFactory.decodeResource(context.getResources(), conDisconnectImage);
        ByteArrayOutputStream stream1 = new ByteArrayOutputStream();
        bitmap1.compress(Bitmap.CompressFormat.PNG, 100, stream1);
        byte[] byteArray1 = stream1.toByteArray();

        bitmap = BitmapFactory.decodeResource(context.getResources(), image);
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
        byte[] byteArray = stream.toByteArray();

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(MAC_DEVICE_NAME, deviceName);
        values.put(MAC_ADDRESS, mac_address);
        values.put(MAC_SELECT_DEVICE, selectDevice);
        values.put(MAC_SELECT_DEVICE_STATUS_IMAGE, byteArray1);
        values.put(MAC_SELECT_DEVICE_IMAGE, byteArray);
        values.put(MAC_SELECT_DEVICE_IMAGE_FLAG, deviceIconImageFlag);

        db.insert(TABLE_MACADDRESS, null, values);
        db.close(); // Closing database connection
    }

    public void insertDevice(String device_name)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(DEVICE_NAME, device_name);
        // Inserting Row
        db.insert(TABLE_DEVICENAME, null, values);
        db.close(); // Closing database connection
    }


    //************** Get data from query***********************************

    public String getDeviceInfo(int position)
    {
        //  if(position == 0)
        //  {
             /*  String selectQuery = " SELECT TMA.MAC_ADDRESS AS MAC_ADDRESS, TDN.DEVICE_NAME AS DEVICE_NAME\n " +
                             " FROM table_mac_address TMA\n "+ "INNER JOIN table_device_name TDN\n "+ " ON TMA.MAC_DEVICE_ID = TDN.DEVICE_NAME_ID ";*/

        // String query="select url from clienturl where client_id='"+tokens+"'";
      //  String selectQuery = "select * from table_mac_address where mac_device_id = '"+position+"' ";  // 14-08-2021 for get positon of id

        String selectQuery = "select rowid, * from table_mac_address where rowid = '"+position+"' ";

        System.out.println("selectQuery:::: "+selectQuery);
        SQLiteDatabase db  = this.getReadableDatabase();
        Cursor cursor      = db.rawQuery(selectQuery, null);
        String url= null;
        String clientDb, selectDeviceColumn;
        String clientData="";
        int cnt =0;

        if (cursor.moveToFirst())
        {
            do
            {
                // get the data into array, or class variable
                url = (cursor.getString(0));
                clientDb = (cursor.getString(2));
                clientData=url+";"+clientDb;

            }
            while (cursor.moveToNext());
        }
        cursor.close();
        return clientData;
        //   }
      /*  else
        {
             *//*  String selectQuery = " SELECT TMA.MAC_ADDRESS AS MAC_ADDRESS, TDN.DEVICE_NAME AS DEVICE_NAME\n " +
                             " FROM table_mac_address TMA\n "+ "INNER JOIN table_device_name TDN\n "+ " ON TMA.MAC_DEVICE_ID = TDN.DEVICE_NAME_ID ";*//*

            // String query="select url from clienturl where client_id='"+tokens+"'";
            String selectQuery = "select * from table_mac_address where mac_device_id = '"+position+"'";

            System.out.println("selectQuery:::: "+selectQuery);
            SQLiteDatabase db  = this.getReadableDatabase();
            Cursor cursor      = db.rawQuery(selectQuery, null);
            String url= null;
            String clientDb;
            String clientData="";
            int cnt =0;
            String macandIdString = "", sendMacandIdString;

            if (cursor.moveToFirst())
            {
                do
                {
                    // get the data into array, or class variable+
           *//*     url = (cursor.getString(cursor.getColumnIndex("MAC_ADDRESS")));
                clientDb = (cursor.getString(cursor.getColumnIndex("DEVICE_NAME")));*//*
                    url = (cursor.getString(0));
                    clientDb = (cursor.getString(1));
                    Log.d("url:::",url);
                    Log.d("clientDb:::",clientDb);
                    clientData=url+";"+clientDb;
                    System.out.println("clientData::: "+clientData);
                    Log.d("clientData::: ",clientData);
                }
                while (cursor.moveToNext());
            }
            cursor.close();
            return clientData;
        }
*/




     /*   if (cursor.moveToFirst())
        {
            do
            {
                // get the data into array, or class variable+
                url = (cursor.getString(0));
                clientDb = (cursor.getString(1));
                macandIdString += "\n"+url +";"+ clientDb ;
                cnt++;
            }
            while (cursor.moveToNext());
        }
        sendMacandIdString = macandIdString +"#:#:#" + cnt ;
        cursor.close();
        return sendMacandIdString;*/
    }


    //***************To Get Mac Address ***********************
    public String getMacAddress()
    {
        // String selectQuery = "SELECT * FROM " + TABLE_MACADDRESS;
        String selectQuery = "select * from table_mac_address where mac_select_device = 'Bedroom' ";
        SQLiteDatabase db  = this.getReadableDatabase();
        Cursor cursor      = db.rawQuery(selectQuery, null);
        String selectDeviceList="";
        String mac_address = null;
        String clientData="", clientDb, selectDeviceColumn;
        int cnt=0;

        if (cursor.moveToFirst())
        {
            do
            {
                //url = (cursor.getString(0));
                clientDb = (cursor.getString(1));
                selectDeviceColumn = (cursor.getString(2));
                // clientData=url+";"+clientDb+";"+selectDeviceColumn;
                clientData += "\n"+clientDb +">"+ selectDeviceColumn;
                cnt++;

            }
            while (cursor.moveToNext());
        }
        selectDeviceList = clientData +"#:#:#" + cnt ;
        cursor.close();
        return selectDeviceList;
    }

   ///******************* get row id from table table_device_setup_add_rule_1******************************
   public int getReadRowId()
   {
       // String selectQuery = "SELECT * FROM " + TABLE_MACADDRESS;
       String selectQuery = "SELECT * FROM table_device_setup_add_rule_1 ";
       SQLiteDatabase db  = this.getReadableDatabase();
       Cursor cursor      = db.rawQuery(selectQuery, null);
      // String selectDeviceList = null, clientData = "" ;
       int selectDeviceList = 0;
     //  String deviceSetupAddRuleIdOne, deviceSetupAddRuleOneFlag ;
       int deviceSetupAddRuleIdOne = 0, deviceSetupAddRuleOneFlag ;
       int cnt = 0;

    /*   if (cursor.moveToFirst()) {
           while (!cursor.isAfterLast())
           {
                name = cursor.getInt(0);
               cursor.moveToNext();
           }
       }

       return name;*/


       if (cursor.moveToFirst())
       {
           do
           {
               deviceSetupAddRuleIdOne = cursor.getInt(0);
              // deviceSetupAddRuleIdOne = cursor.getString(0);
             //  deviceSetupAddRuleOneFlag= (cursor.getString(19));

              // clientData += "\n"+deviceSetupAddRuleIdOne +">"+ deviceSetupAddRuleOneFlag;
               cnt++;
           }
           while (cursor.moveToNext());
       }
      // selectDeviceList = clientData + "#:#:#" + cnt ;
       cursor.close();
       return deviceSetupAddRuleIdOne;

   }


//*************************

/*
    // Updating Farmer Id
    public int updateFarmerId(String device_id)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
       // values.put(IMEI, device_id);
       // values.put(FARMER_NAME, farmer_name);

        String unique_device_id = device_id;

        // updating row
      // return db.update(TABLE_REGISTER, values, "id=1", null);
    }*/

    public int getRowCount(String querry) //Not For Synch
    {
        int count = 0;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(querry, null);

        if (cursor.moveToFirst())
        {
            do
            {
                count++;
            }
            while (cursor.moveToNext());
        }
        else
        {
            count =0;
        }

        cursor.close();
        db.close();

        return count+1;
    }

    //delete the note
    public void deleteDeviceList(String ID) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        //deleting row
        sqLiteDatabase.delete(TABLE_MYDEVICE_SUMMARY, "DEVICE_MYDEVICE_SUMMARY_ID=" + ID, null);
        sqLiteDatabase.close();
    }


    //************** Get data from query***********************************

   /* public ArrayList<DeviceDetails> getMyDeviceSummaryInfo()
    {
        ArrayList<DeviceDetails> arrayList = new ArrayList<>();

        String selectQuery = "SELECT * FROM " + TABLE_DEVICENAME;
        // String selectQuery = "SELECT * FROM table_device_name";
        System.out.println("selectQuery:::: "+selectQuery);

        System.out.println("selectQuery:::: "+selectQuery);
        SQLiteDatabase db  = this.getReadableDatabase();
        Cursor cursor      = db.rawQuery(selectQuery, null);
        System.out.println("Cursor :  "+cursor);

        if (cursor.moveToFirst())
        {
            do
            {
                DeviceDetails deviceDetails = new DeviceDetails();
                // get the data into array, or class variable+
              //  deviceDetails.setID(cursor.getString(0));
                deviceDetails.setDevice(cursor.getString(1));
                deviceDetails.setName(cursor.getString(2));
                deviceDetails.setLocation(cursor.getString(3));
                deviceDetails.setStatus(cursor.getString(4));
                arrayList.add(deviceDetails);

            }
            while (cursor.moveToNext());
        }
        cursor.close();
        return arrayList;
    }*/

    //************** Insert Location from Main Activity **********
    public void insertLocation(String device_name)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.beginTransaction();

        ContentValues values = new ContentValues();
        values.put(LOCATION, device_name);
        // Inserting Row
        db.insert(TABLE_LOCATION, null, values);
        db.setTransactionSuccessful();
        db.endTransaction();
        db.close(); // Closing database connection
    }


    //************** Insert device name and image from sensor model fragment ********** Bitmap  byte[] image
    public void insertName(String device_name, int image) throws SQLiteException
    {
        try
        {
            bitmap = BitmapFactory.decodeResource(context.getResources(), image);

            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
            byte[] byteArray = stream.toByteArray();

            SQLiteDatabase db = getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put(NAME, device_name);
            values.put(DEVICE_IMAGE, byteArray);
            db.insert(TABLE_NAME, null, values);
            // Toast.makeText(MainActivity.this, "Save Image 104 ", Toast.LENGTH_SHORT).show();

            db.close();
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

    }



    //************** Insert Notification Message ********** Added by Aditya Wasnik on 11-09-2021
    public void insertNotificationMessage(String notification_message)
    {
        SQLiteDatabase db  = this.getReadableDatabase();
        db.beginTransaction();

        ContentValues values = new ContentValues();
        values.put(NOTIFICATION_MESSAGE, notification_message);
        values.put(NOTIFICATION_TIME, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        // Inserting Row
        db.insert(TABLE_NOTIFICATION, null, values);
        db.setTransactionSuccessful();
        db.endTransaction();
        db.close(); // Closing database connection
    }



    //************** To store data in sqlite database of Device setup add rule activity********************
    public void insertDeviceSetupAddRule_1( String startTime1, String endTime1,String startTime2, String endTime2)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.beginTransaction();

        ContentValues values = new ContentValues();
        values.put(DEVICE_SETUP_ADD_RULE_SELECT_STARTTIME1, startTime1);
        values.put(DEVICE_SETUP_ADD_RULE_SELECT_ENDTIME1, endTime1);
        values.put(DEVICE_SETUP_ADD_RULE_SELECT_STARTTIME2, startTime2);
        values.put(DEVICE_SETUP_ADD_RULE_SELECT_ENDTIME2, endTime2);

        db.insert(TABLE_DEVICE_SETUP_ADD_RULE_1, null, values);
        db.setTransactionSuccessful();
        db.endTransaction();
        db.close(); // Closing database connection
    }

    //***************To Get Mac Address ***********************
    public String getDeviceSetupAddRule()
    {
        //******************
        String selectQuery = "select * from table_device_setup_add_rule_1 ";

        SQLiteDatabase db  = this.getReadableDatabase();
        Cursor cursor      = db.rawQuery(selectQuery, null);
        String deviceSetupAddRuleOneStartTime_1,deviceSetupAddRuleOneEndTime_1,deviceSetupAddRuleOneStartTime_2,deviceSetupAddRuleOneEndTime_2,deviceSetupAddRuleOneStartTime_3,deviceSetupAddRuleOneEndTime_3,deviceSetupAddRuleOneStartTime_4,deviceSetupAddRuleOneEndTime_4;
        String deviceSetUpOne="", deviceStartNEndTime = null;
        int deviceSetupAddRuleOneFlag;
        int cnt =0;

        if (cursor.moveToFirst())
        {
            do
            {
                deviceSetupAddRuleOneStartTime_1 = (cursor.getString(1));
                deviceSetupAddRuleOneEndTime_1= (cursor.getString(2));
                deviceSetupAddRuleOneStartTime_2= (cursor.getString(3));
                deviceSetupAddRuleOneEndTime_2 = (cursor.getString(4));

                deviceSetUpOne += "\n"+deviceSetupAddRuleOneStartTime_1 + ">" + deviceSetupAddRuleOneEndTime_1 + ">" + deviceSetupAddRuleOneStartTime_2 + ">" + deviceSetupAddRuleOneEndTime_2 ;
                cnt++;

            }
            while (cursor.moveToNext());
        }
        deviceStartNEndTime = deviceSetUpOne +"#:#:#" + cnt ;
        cursor.close();
        return deviceStartNEndTime;

        //********************

    }


    //************** Insert Device name from Sensor model fragment **********
    public void insertDeviceNameDialog(String device_name)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.beginTransaction();

        ContentValues values = new ContentValues();
        values.put(DEVICENAME_DIALOG_DNAME, device_name);
        // Inserting Row
        db.insert(TABLE_DEVICENAME_DIALOG, null, values);
        db.setTransactionSuccessful();
        db.endTransaction();
        db.close(); // Closing database connection
    }






    //********* To set my schedule Recycler view Adapter Hall Acticity*************
    public String getSelectDeviceImageFlag()
    {
        String selectDeviceImageFlag,saveData="", getsaveData ="",selectDevice;
        int cnt=0;
        String selectQuery = "select * from table_mac_address ";
        SQLiteDatabase db  = this.getReadableDatabase();
        Cursor cursor      = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst())
        {
            do
            {
                selectDevice= cursor.getString(2);
                selectDeviceImageFlag= cursor.getString(5);
                getsaveData += "\n"+selectDeviceImageFlag +">"+ selectDevice;
                cnt++;

            }
            while (cursor.moveToNext());
        }
        saveData = getsaveData + "#:#:#" + cnt ;
        cursor.close();
        return saveData;
    }

    //********* To get bedroom flag of postion 30-08-2021 *************
    public String getBedroomSelectDeviceImageFlag()
    {
        String selectDeviceImageFlag,saveData="", getsaveData ="",selectDevice;
        int cnt=0;
        String selectQuery = "select * from table_mac_address where mac_select_device = 'Bedroom'";
        SQLiteDatabase db  = this.getReadableDatabase();
        Cursor cursor      = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst())
        {
            do
            {
                selectDevice= cursor.getString(2);
                selectDeviceImageFlag= cursor.getString(5);
                getsaveData += "\n"+ selectDeviceImageFlag + ">" + selectDevice  ;
                cnt++;
            }
            while (cursor.moveToNext());
        }
        saveData = getsaveData +"#:#:#" + cnt ;
        cursor.close();
        return saveData;
    }



    /***********  Updating single contact  ****************/

    public int updateContact(String contact, int id) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(DEVICENAME_DIALOG_DNAME, contact);

        // updating row
        return db.update(TABLE_DEVICENAME_DIALOG, values, DEVICENAME_DIALOG_ID + " = ?", new String[] { String.valueOf(id) });
    }

    public void updateDeviceStatus(String deviceStatus, int conDisconnectImage)
    {
      try
      {
          SQLiteDatabase db = this.getWritableDatabase();

          Bitmap bitmapUpdateDeviceStatus = BitmapFactory.decodeResource(context.getResources(), conDisconnectImage);
          ByteArrayOutputStream stream1 = new ByteArrayOutputStream();
          bitmapUpdateDeviceStatus.compress(Bitmap.CompressFormat.PNG, 100, stream1);
          byte[] byteArray1 = stream1.toByteArray();

          //   db.execSQL("UPDATE table_mac_address SET mac_select_device_status="+status+" WHERE id="+id+"");
          db.execSQL("UPDATE table_mac_address SET mac_select_device_status_image='"+byteArray1+"' WHERE mac_device_name = '"+deviceStatus+"'");
      }
      catch (Exception e)
      {
          e.printStackTrace();
      }

    }


    /****** Deleting single contact **********/
   /* public void deleteContact(int Id)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_DEVICENAME_DIALOG, DEVICENAME_DIALOG_ID + " = ?", new String[] { String.valueOf(Id) });
        db.close();
    }*/

    //*********Delete mac address************************
    public void deleteMacAddress(String deviceName )
    {
        // SQLiteDatabase db = this.getWritableDatabase(); table_devicename_dialog
        //db.delete(TABLE_MACADDRESS, MAC_DEVICE_ID + " = ?", new String[] { String.valueOf(Id) });
        // db.close();

        SQLiteDatabase db = this.getWritableDatabase();
        //  db.delete(TABLE_NAME, NAME + "=" +'"+selectRoom+"', null);
    //    db.execSQL("delete from table_devicename_dialog where devicename_dialog_dname='"+deviceName+"'"); //14-08-2021
        db.execSQL("delete from table_mac_address where mac_device_name='"+deviceName+"'");
        db.close();


    }










    //********* To set my schedule Recycler view Adapter*************
    public String getMyScheduleForSubmitData()
    {
        String id,deviceName,onTime,offTime,saveData="", getsaveData ="";
        int cnt=0;
        String selectQuery = "select * from table_device_setup_add_rule_2 ";
        SQLiteDatabase db  = this.getReadableDatabase();
        Cursor cursor      = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst())
        {
            do
            {
                // id = cursor.getString(0);
                deviceName = cursor.getString(2);
                onTime = cursor.getString(4);
                offTime= cursor.getString(5);

                // saveData = id+deviceName+onTime+offTime;
                //   getsaveData += "\n"+deviceName +">"+ onTime + ">" + offTime  ;
                getsaveData += "\n"+ onTime + ">" + offTime  ;

            }
            while (cursor.moveToNext());
        }
        saveData = getsaveData +"#:#:#" + cnt ;
        cursor.close();
        return saveData;
    }


    //************** To store data in sqlite database of Device setup add rule activity 2********************
    public void insertDeviceSetupAddRule_2(String setRule, String selectRoom, String selectDevice, String startTime1, String endTime1,String startTime2, String endTime2,String startTime3, String endTime3,String startTime4, String endTime4, boolean day1, boolean day2, boolean day3, boolean day4, boolean day5, boolean day6, boolean day7,int flag)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.beginTransaction();

        ContentValues values = new ContentValues();
        values.put(DEVICE_SETUP_ADD_RULE_TWO_ADDRULE_2, setRule);
        values.put(DEVICE_SETUP_ADD_RULE_TWO_SELECT_ROOM_2, selectRoom);
        values.put(DEVICE_SETUP_ADD_RULE_TWO_SELECT_DEVICE_2, selectDevice);
        values.put(DEVICE_SETUP_ADD_RULE_TWO_SELECT_STARTTIME_1, startTime1);
        values.put(DEVICE_SETUP_ADD_RULE_TWO_SELECT_ENDTIME_1, endTime1);
        values.put(DEVICE_SETUP_ADD_RULE_TWO_SELECT_STARTTIME_2, startTime2);
        values.put(DEVICE_SETUP_ADD_RULE_TWO_SELECT_ENDTIME_2, endTime2);
        values.put(DEVICE_SETUP_ADD_RULE_TWO_SELECT_STARTTIME_3, startTime3);
        values.put(DEVICE_SETUP_ADD_RULE_TWO_SELECT_ENDTIME_3, endTime3);
        values.put(DEVICE_SETUP_ADD_RULE_TWO_SELECT_STARTTIME_4, startTime4);
        values.put(DEVICE_SETUP_ADD_RULE_TWO_SELECT_ENDTIME_4, endTime4);
        values.put(DEVICE_SETUP_ADD_RULE_TWO_SELECT_SELECT_DAY_MON_2, day1);
        values.put(DEVICE_SETUP_ADD_RULE_TWO_SELECT_SELECT_DAY_TUES_2, day2);
        values.put(DEVICE_SETUP_ADD_RULE_TWO_SELECT_SELECT_DAY_WED_2, day3);
        values.put(DEVICE_SETUP_ADD_RULE_TWO_SELECT_SELECT_DAY_THU_2, day4);
        values.put(DEVICE_SETUP_ADD_RULE_TWO_SELECT_SELECT_DAY_FRI_2, day5);
        values.put(DEVICE_SETUP_ADD_RULE_TWO_SELECT_SELECT_DAY_SAT_2, day6);
        values.put(DEVICE_SETUP_ADD_RULE_TWO_SELECT_SELECT_DAY_SUN_2, day7);
        values.put(DEVICE_SETUP_ADD_RULE_TWO_SELECT_FLAG, flag);
        // Inserting Row
        db.insert(TABLE_DEVICE_SETUP_ADD_RULE_TWO_2, null, values);
        db.setTransactionSuccessful();
        db.endTransaction();
        db.close(); // Closing database connection
    }

    //************** To store data in sqlite database of Device setup add rule activity 3 ********************
    public void insertDeviceSetupAddRule_3(String setRule, String selectRoom, String selectDevice, String startTime1, String endTime1,String startTime2, String endTime2,String startTime3, String endTime3,String startTime4, String endTime4, boolean day1, boolean day2, boolean day3, boolean day4, boolean day5, boolean day6, boolean day7, int flag)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.beginTransaction();

        ContentValues values = new ContentValues();
        values.put(DEVICE_SETUP_ADD_RULE_THREE_ADDRULE_3, setRule);
        values.put(DEVICE_SETUP_ADD_RULE_THREE_SELECT_ROOM_3, selectRoom);
        values.put(DEVICE_SETUP_ADD_RULE_THREE_SELECT_DEVICE_3, selectDevice);
        values.put(DEVICE_SETUP_ADD_RULE_THREE_SELECT_STARTTIME_1, startTime1);
        values.put(DEVICE_SETUP_ADD_RULE_THREE_SELECT_ENDTIME_1, endTime1);
        values.put(DEVICE_SETUP_ADD_RULE_THREE_SELECT_STARTTIME_2, startTime2);
        values.put(DEVICE_SETUP_ADD_RULE_THREE_SELECT_ENDTIME_2, endTime2);
        values.put(DEVICE_SETUP_ADD_RULE_THREE_SELECT_STARTTIME_3, startTime3);
        values.put(DEVICE_SETUP_ADD_RULE_THREE_SELECT_ENDTIME_3, endTime3);
        values.put(DEVICE_SETUP_ADD_RULE_THREE_SELECT_STARTTIME_4, startTime4);
        values.put(DEVICE_SETUP_ADD_RULE_THREE_SELECT_ENDTIME_4, endTime4);
        values.put(DEVICE_SETUP_ADD_RULE_THREE_SELECT_SELECT_DAY_MON_3, day1);
        values.put(DEVICE_SETUP_ADD_RULE_THREE_SELECT_SELECT_DAY_TUES_3, day2);
        values.put(DEVICE_SETUP_ADD_RULE_THREE_SELECT_SELECT_DAY_WED_3, day3);
        values.put(DEVICE_SETUP_ADD_RULE_THREE_SELECT_SELECT_DAY_THU_3, day4);
        values.put(DEVICE_SETUP_ADD_RULE_THREE_SELECT_SELECT_DAY_FRI_3, day5);
        values.put(DEVICE_SETUP_ADD_RULE_THREE_SELECT_SELECT_DAY_SAT_3, day6);
        values.put(DEVICE_SETUP_ADD_RULE_THREE_SELECT_SELECT_DAY_SUN_3, day7);
        values.put(DEVICE_SETUP_ADD_RULE_THREE_SELECT_FLAG, flag);
        // Inserting Row
        db.insert(TABLE_DEVICE_SETUP_ADD_RULE_THREE_3, null, values);
        db.setTransactionSuccessful();
        db.endTransaction();
        db.close(); // Closing database connection
    }

    //************** To store data in sqlite database of Device setup add rule activity********************
    public void insertDeviceSetupAddRule_4(String setRule, String selectRoom, String selectDevice, String startTime1, String endTime1,String startTime2, String endTime2,String startTime3, String endTime3,String startTime4, String endTime4, boolean day1, boolean day2, boolean day3, boolean day4, boolean day5, boolean day6, boolean day7, int flag)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.beginTransaction();

        ContentValues values = new ContentValues();
        values.put(DEVICE_SETUP_ADD_RULE_FOUR_ADDRULE_4, setRule);
        values.put(DEVICE_SETUP_ADD_RULE_FOUR_SELECT_ROOM_4, selectRoom);
        values.put(DEVICE_SETUP_ADD_RULE_FOUR_SELECT_DEVICE_4, selectDevice);
        values.put(DEVICE_SETUP_ADD_RULE_FOUR_SELECT_STARTTIME_1, startTime1);
        values.put(DEVICE_SETUP_ADD_RULE_FOUR_SELECT_ENDTIME_1, endTime1);
        values.put(DEVICE_SETUP_ADD_RULE_FOUR_SELECT_STARTTIME_2, startTime2);
        values.put(DEVICE_SETUP_ADD_RULE_FOUR_SELECT_ENDTIME_2, endTime2);
        values.put(DEVICE_SETUP_ADD_RULE_FOUR_SELECT_STARTTIME_3, startTime3);
        values.put(DEVICE_SETUP_ADD_RULE_FOUR_SELECT_ENDTIME_3, endTime3);
        values.put(DEVICE_SETUP_ADD_RULE_FOUR_SELECT_STARTTIME_4, startTime4);
        values.put(DEVICE_SETUP_ADD_RULE_FOUR_SELECT_ENDTIME_4, endTime4);
        values.put(DEVICE_SETUP_ADD_RULE_FOUR_SELECT_SELECT_DAY_MON_4, day1);
        values.put(DEVICE_SETUP_ADD_RULE_FOUR_SELECT_SELECT_DAY_TUES_4, day2);
        values.put(DEVICE_SETUP_ADD_RULE_FOUR_SELECT_SELECT_DAY_WED_4, day3);
        values.put(DEVICE_SETUP_ADD_RULE_FOUR_SELECT_SELECT_DAY_THU_4, day4);
        values.put(DEVICE_SETUP_ADD_RULE_FOUR_SELECT_SELECT_DAY_FRI_4, day5);
        values.put(DEVICE_SETUP_ADD_RULE_FOUR_SELECT_SELECT_DAY_SAT_4, day6);
        values.put(DEVICE_SETUP_ADD_RULE_FOUR_SELECT_SELECT_DAY_SUN_4, day7);
        values.put(DEVICE_SETUP_ADD_RULE_FOUR_SELECT_FLAG, flag);
        // Inserting Row
        db.insert(TABLE_DEVICE_SETUP_ADD_RULE_FOUR_4, null, values);
        db.setTransactionSuccessful();
        db.endTransaction();
        db.close(); // Closing database connection
    }

    //************** To store data in sqlite database of Device setup add rule activity 2********************
    public void insertDataSensorDeviceSchedule( String startTime1, String endTime1,String startTime2, String endTime2,String startTime3, String endTime3,String startTime4, String endTime4, boolean day1, boolean day2, boolean day3, boolean day4, boolean day5, boolean day6, boolean day7,boolean isNotification, int flag)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.beginTransaction();

        ContentValues values = new ContentValues();
        values.put(INTRUSION_DETECTION_ONTIME_ONE, startTime1);
        values.put(INTRUSION_DETECTION_OFFTIME_ONE, endTime1);
        values.put(ENERGY_SAVING_MODE_ONTIME_TWO, startTime2);
        values.put(ENERGY_SAVING_MODE_OFFTIME_TWO, endTime2);
        values.put(SCHEDULED_ONOFF_ONTIME_THREE, startTime3);
        values.put(SCHEDULED_ONOFF_OFFTIME_THREE, endTime3);
        values.put(ELDERLY_CARE_ONTIME_FOUR, startTime4);
        values.put(ELDERLY_CARE_OFFTIME_FOUR, endTime4);
        values.put(SENSOR_DEVICE_SCHEDULE_DAY_MON, day1);
        values.put(SENSOR_DEVICE_SCHEDULE_DAY_TUES, day2);
        values.put(SENSOR_DEVICE_SCHEDULE_DAY_WED, day3);
        values.put(SENSOR_DEVICE_SCHEDULE_DAY_THU, day4);
        values.put(SENSOR_DEVICE_SCHEDULE_DAY_FRI, day5);
        values.put(SENSOR_DEVICE_SCHEDULE_DAY_SAT, day6);
        values.put(SENSOR_DEVICE_SCHEDULE_DAY_SUN, day7);
        values.put(SENSOR_DEVICE_SCHEDULE_NOTIFICATION, day7); ///
        values.put(SENSOR_DEVICE_SCHEDULE_FLAG, flag);
        // Inserting Row
        db.insert(TABLE_SENSOR_DEVICE_SCHEDULE, null, values);
        db.setTransactionSuccessful();
        db.endTransaction();
        db.close(); // Closing database connection
    }

    ////
    //************** To store data in sqlite database of User Credential signup activity********************
    public void insertUserCredential( String username, String email, String mobileNumber, String password)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.beginTransaction();

        ContentValues values = new ContentValues();
        values.put(USERNAME, username);
        values.put(EMAIL, email);
        values.put(MOBILE_NUMBER, mobileNumber);
        values.put(PASSWORD, password);
        db.insert(TABLE_USER_CREDENTIAL, null, values);
        db.setTransactionSuccessful();
        db.endTransaction();
        db.close(); // Closing database connection
    }

    //////
    //***************To Get Device Setup Add Rule  1 ***********************
    public String getUserCredential()
    {
        String selectQuery = "SELECT * FROM " + TABLE_USER_CREDENTIAL;

        SQLiteDatabase db  = this.getReadableDatabase();
        Cursor cursor      = db.rawQuery(selectQuery, null);
        String email, password;
        String userCredential="";

        if (cursor.moveToFirst())
        {
            do
            {
                email = (cursor.getString(2));
                password= (cursor.getString(4));
                userCredential = email + " ## " + password;
            }
            while (cursor.moveToNext());
        }
        cursor.close();
        return userCredential;
    }

    public boolean getCount()
    {
        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = "SELECT * FROM " + TABLE_USER_CREDENTIAL;
        Cursor cursor      = db.rawQuery(selectQuery, null);
        if (cursor != null)
         {
            if(cursor.getCount() > 0)
            {
                cursor.close();
                return true;
            }
        }
        return false;
    }



    public String getResetPassword(String email)
    {
        SQLiteDatabase db  = this.getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM " + "table_user_credential" + " where email = '" + email + "'" , null);
        String getEmail = null, Email;
        int UserId;
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do
            {
                UserId = (cursor.getInt(0));
                Email = (cursor.getString(2));
                getEmail = UserId + " ## " + Email;

            } while (cursor.moveToNext());
        }
        return getEmail;
    }

    //***** update Reset Password from ResetPasswordActivity *******
    public void  updateResetPassword(String newPassword,String email, int UserId)
    {
      try
      {
          SQLiteDatabase db = this.getWritableDatabase();
          db.execSQL("UPDATE table_user_credential SET password='"+newPassword+"' WHERE email = '"+email+"' and user_credential_id = '"+UserId+"'  ");
      }
      catch (Exception e)
      {
          e.printStackTrace();
      }

    }

    //***************To Get Device Setup Add Rule  1 ***********************
    public String getDeviceSetupAddRule_1()
    {
         String selectQuery = "SELECT * FROM " + TABLE_DEVICE_SETUP_ADD_RULE_1;

        SQLiteDatabase db  = this.getReadableDatabase();
        Cursor cursor      = db.rawQuery(selectQuery, null);
        String deviceSetupAddRuleOneStartTime_1,deviceSetupAddRuleOneEndTime_1,deviceSetupAddRuleOneStartTime_2,deviceSetupAddRuleOneEndTime_2,deviceSetupAddRuleOneStartTime_3,deviceSetupAddRuleOneEndTime_3,deviceSetupAddRuleOneStartTime_4,deviceSetupAddRuleOneEndTime_4;
        String deviceSetUpOne="";
        int deviceSetupAddRuleOneFlag;

        if (cursor.moveToFirst())
        {
            do
            {
                deviceSetupAddRuleOneStartTime_1 = (cursor.getString(4));
                deviceSetupAddRuleOneEndTime_1= (cursor.getString(5));
                deviceSetupAddRuleOneStartTime_2= (cursor.getString(6));
                deviceSetupAddRuleOneEndTime_2 = (cursor.getString(7));
                deviceSetupAddRuleOneStartTime_3= (cursor.getString(8));
                deviceSetupAddRuleOneEndTime_3= (cursor.getString(9));
                deviceSetupAddRuleOneStartTime_4 = (cursor.getString(10));
                deviceSetupAddRuleOneEndTime_4= (cursor.getString(11));
                deviceSetupAddRuleOneFlag= (cursor.getInt(19));

                deviceSetUpOne = deviceSetupAddRuleOneStartTime_1 + " ## " + deviceSetupAddRuleOneEndTime_1 + " ## " + deviceSetupAddRuleOneStartTime_2 + " ## " + deviceSetupAddRuleOneEndTime_2 + " ## " + deviceSetupAddRuleOneStartTime_3 + " ## " + deviceSetupAddRuleOneEndTime_3 + " ## " + deviceSetupAddRuleOneStartTime_4 + " ## " +deviceSetupAddRuleOneEndTime_4 + " ##"+ deviceSetupAddRuleOneFlag ;

            }
            while (cursor.moveToNext());
        }
        cursor.close();
        return deviceSetUpOne;
    }



    //***************To Get Device Setup Add Rule  2 ***********************
    public String getDeviceSetupAddRule_2()
    {
        String selectQuery = "SELECT * FROM " + TABLE_DEVICE_SETUP_ADD_RULE_TWO_2 ;

        SQLiteDatabase db  = this.getReadableDatabase();
        Cursor cursor      = db.rawQuery(selectQuery, null);
        String deviceSetupAddRuleTwoStartTime_1,deviceSetupAddRuleTwoEndTime_1,deviceSetupAddRuleTwoStartTime_2,deviceSetupAddRuleTwoEndTime_2,deviceSetupAddRuleTwoStartTime_3,deviceSetupAddRuleTwoEndTime_3,deviceSetupAddRuleTwoStartTime_4,deviceSetupAddRuleTwoEndTime_4;
        String deviceSetUpTwo="";
        int deviceSetupAddRuleTwoFlag;

        if (cursor.moveToFirst())
        {
            do
            {
                deviceSetupAddRuleTwoStartTime_1 = (cursor.getString(4));
                deviceSetupAddRuleTwoEndTime_1= (cursor.getString(5));
                deviceSetupAddRuleTwoStartTime_2= (cursor.getString(6));
                deviceSetupAddRuleTwoEndTime_2 = (cursor.getString(7));
                deviceSetupAddRuleTwoStartTime_3= (cursor.getString(8));
                deviceSetupAddRuleTwoEndTime_3= (cursor.getString(9));
                deviceSetupAddRuleTwoStartTime_4 = (cursor.getString(10));
                deviceSetupAddRuleTwoEndTime_4= (cursor.getString(11));
                deviceSetupAddRuleTwoFlag= (cursor.getInt(19));

                deviceSetUpTwo = deviceSetupAddRuleTwoStartTime_1 + " ## " + deviceSetupAddRuleTwoEndTime_1 + " ## " + deviceSetupAddRuleTwoStartTime_2 + " ## " + deviceSetupAddRuleTwoEndTime_2 + " ## " + deviceSetupAddRuleTwoStartTime_3 + " ## " + deviceSetupAddRuleTwoEndTime_3 + " ## " + deviceSetupAddRuleTwoStartTime_4 + " ## " +deviceSetupAddRuleTwoEndTime_4 + " ##"+ deviceSetupAddRuleTwoFlag ;

            }
            while (cursor.moveToNext());
        }
        cursor.close();
        return deviceSetUpTwo;
    }

    //***************To Get Device Setup Add Rule 3 ***********************
    public String getDeviceSetupAddRule_3()
    {
        String selectQuery = "SELECT * FROM " + TABLE_DEVICE_SETUP_ADD_RULE_THREE_3 ;

        SQLiteDatabase db  = this.getReadableDatabase();
        Cursor cursor      = db.rawQuery(selectQuery, null);
        String deviceSetupAddRuleThreeStartTime_1,deviceSetupAddRuleThreeEndTime_1,deviceSetupAddRuleThreeStartTime_2,deviceSetupAddRuleThreeEndTime_2,deviceSetupAddRuleThreeStartTime_3,deviceSetupAddRuleThreeEndTime_3,deviceSetupAddRuleThreeStartTime_4,deviceSetupAddRuleThreeEndTime_4;
        String deviceSetUpTwo="";
        int deviceSetupAddRuleThreeFlag;

        if (cursor.moveToFirst())
        {
            do
            {
                deviceSetupAddRuleThreeStartTime_1 = (cursor.getString(4));
                deviceSetupAddRuleThreeEndTime_1= (cursor.getString(5));
                deviceSetupAddRuleThreeStartTime_2= (cursor.getString(6));
                deviceSetupAddRuleThreeEndTime_2 = (cursor.getString(7));
                deviceSetupAddRuleThreeStartTime_3= (cursor.getString(8));
                deviceSetupAddRuleThreeEndTime_3= (cursor.getString(9));
                deviceSetupAddRuleThreeStartTime_4 = (cursor.getString(10));
                deviceSetupAddRuleThreeEndTime_4= (cursor.getString(11));
                deviceSetupAddRuleThreeFlag= (cursor.getInt(19));

                deviceSetUpTwo = deviceSetupAddRuleThreeStartTime_1 + " ## " + deviceSetupAddRuleThreeEndTime_1 + " ## " + deviceSetupAddRuleThreeStartTime_2 + " ## " + deviceSetupAddRuleThreeEndTime_2 + " ## " + deviceSetupAddRuleThreeStartTime_3 + " ## " + deviceSetupAddRuleThreeEndTime_3 + " ## " + deviceSetupAddRuleThreeStartTime_4 + " ## " +deviceSetupAddRuleThreeEndTime_4 + " ##"+ deviceSetupAddRuleThreeFlag ;

            }
            while (cursor.moveToNext());
        }
        cursor.close();
        return deviceSetUpTwo;
    }


    //***************To Get Device Setup Add Rule 3 ***********************
    public String getDeviceSetupAddRule_4()
    {
        String selectQuery = "SELECT * FROM " + TABLE_DEVICE_SETUP_ADD_RULE_FOUR_4 ;
        SQLiteDatabase db  = this.getReadableDatabase();

        Cursor cursor      = db.rawQuery(selectQuery, null);
        String deviceSetupAddRuleFourStartTime_1,deviceSetupAddRuleFourEndTime_1,deviceSetupAddRuleFourStartTime_2,deviceSetupAddRuleFourEndTime_2,deviceSetupAddRuleFourStartTime_3,deviceSetupAddRuleFourEndTime_3,deviceSetupAddRuleFourStartTime_4,deviceSetupAddRuleFourEndTime_4;
        String deviceSetUpFour="";
        int deviceSetupAddRuleFourFlag;

        if (cursor.moveToFirst())
        {
            do
            {
                deviceSetupAddRuleFourStartTime_1 = (cursor.getString(4));
                deviceSetupAddRuleFourEndTime_1= (cursor.getString(5));
                deviceSetupAddRuleFourStartTime_2= (cursor.getString(6));
                deviceSetupAddRuleFourEndTime_2 = (cursor.getString(7));
                deviceSetupAddRuleFourStartTime_3= (cursor.getString(8));
                deviceSetupAddRuleFourEndTime_3= (cursor.getString(9));
                deviceSetupAddRuleFourStartTime_4 = (cursor.getString(10));
                deviceSetupAddRuleFourEndTime_4= (cursor.getString(11));
                deviceSetupAddRuleFourFlag= (cursor.getInt(19));

                deviceSetUpFour = deviceSetupAddRuleFourStartTime_1 + " ## " + deviceSetupAddRuleFourEndTime_1 + " ## " + deviceSetupAddRuleFourStartTime_2 + " ## " + deviceSetupAddRuleFourEndTime_2 + " ## " + deviceSetupAddRuleFourStartTime_3 + " ## " + deviceSetupAddRuleFourEndTime_3 + " ## " + deviceSetupAddRuleFourStartTime_4 + " ## " +deviceSetupAddRuleFourEndTime_4 + " ##"+ deviceSetupAddRuleFourFlag ;

            }
            while (cursor.moveToNext());
        }
        cursor.close();
        return deviceSetUpFour;
    }




   // *************************************

    //***************To Get Device Setup Add Rule 1 String ***********************
    public int getDeviceSetupAddRuleChannelOneString(int position)
    {
        // String selectQuery = "SELECT * FROM " + TABLE_DEVICE_SETUP_ADD_RULE_1;
        String selectQuery = "select * from table_device_setup_add_rule_1 where device_setup_add_rule_id_1 = '"+position+"' ";

        SQLiteDatabase db  = this.getReadableDatabase();
        Cursor cursor      = db.rawQuery(selectQuery, null);
        String deviceSetupAddRuleOneStartTime_1,deviceSetupAddRuleOneEndTime_1,deviceSetupAddRuleOneStartTime_2,deviceSetupAddRuleOneEndTime_2,deviceSetupAddRuleOneStartTime_3,deviceSetupAddRuleOneEndTime_3,deviceSetupAddRuleOneStartTime_4,deviceSetupAddRuleOneEndTime_4;
        String deviceSetUpOne="";
        int deviceSetupAddRuleOneFlag = 0;

        if (cursor.moveToFirst())
        {
            do
            {
                deviceSetupAddRuleOneFlag= (cursor.getInt(19));
            }
            while (cursor.moveToNext());
        }
        cursor.close();
        return deviceSetupAddRuleOneFlag;
    }

    //***************To get Device Setup AddRule Channel Two String ***********************
    public int getDeviceSetupAddRuleChannelTwoString(int position)
    {
        // String selectQuery = "SELECT * FROM " + TABLE_DEVICE_SETUP_ADD_RULE_1;
        String selectQuery = "select * from table_device_setup_add_rule_2 where device_setup_add_rule_id_2 = '"+position+"' ";

        SQLiteDatabase db  = this.getReadableDatabase();
        Cursor cursor      = db.rawQuery(selectQuery, null);

        int deviceSetupAddRuleTwoFlag = 0;

        if (cursor.moveToFirst())
        {
            do
            {
                deviceSetupAddRuleTwoFlag= (cursor.getInt(19));
            }
            while (cursor.moveToNext());
        }
        cursor.close();
        return deviceSetupAddRuleTwoFlag;
    }

    //***************To get Device Setup AddRule Channel Three String 08-09-2021 Aditya***********************
    public int getDeviceSetupAddRuleChannelThreeString(int position)
    {
        String selectQuery = "select * from table_device_setup_add_rule_3 where device_setup_add_rule_id_3 = '"+position+"' ";

        SQLiteDatabase db  = this.getReadableDatabase();
        Cursor cursor      = db.rawQuery(selectQuery, null);

        int deviceSetupAddRuleThreeFlag = 0;

        if (cursor.moveToFirst())
        {
            do
            {
                deviceSetupAddRuleThreeFlag= (cursor.getInt(19));
            }
            while (cursor.moveToNext());
        }
        cursor.close();
        return deviceSetupAddRuleThreeFlag;
    }

    //***************To get Device Setup AddRule Channel Three String 08-09-2021 Aditya***********************
    public int getDeviceSetupAddRuleChannelFourString(int position)
    {
        String selectQuery = "select * from table_device_setup_add_rule_4 where device_setup_add_rule_id_4 = '"+position+"' ";

        SQLiteDatabase db  = this.getReadableDatabase();
        Cursor cursor      = db.rawQuery(selectQuery, null);
        int deviceSetupAddRuleFourFlag = 0;

        if (cursor.moveToFirst())
        {
            do
            {
                deviceSetupAddRuleFourFlag= (cursor.getInt(19));
            }
            while (cursor.moveToNext());
        }
        cursor.close();
        return deviceSetupAddRuleFourFlag;
    }

    //************** get Device Setup Add Rule Channel Two ***********
    public String getDeviceSetupAddRuleChannelTwo(int position)
    {
        String selectQuery = "select * from table_device_setup_add_rule_2 where device_setup_add_rule_id_2 = '"+position+"' ";

        SQLiteDatabase db  = this.getReadableDatabase();
        Cursor cursor      = db.rawQuery(selectQuery, null);
        String deviceSetupAddRuleTwoStartTime_1,deviceSetupAddRuleTwoEndTime_1,deviceSetupAddRuleTwoStartTime_2,deviceSetupAddRuleTwoEndTime_2,deviceSetupAddRuleTwoStartTime_3,deviceSetupAddRuleTwoEndTime_3,deviceSetupAddRuleTwoStartTime_4,deviceSetupAddRuleTwoEndTime_4;
        String deviceSetUpTwo="";
        int deviceSetupAddRuleTwoFlag;

        if (cursor.moveToFirst())
        {
            do
            {
                deviceSetupAddRuleTwoStartTime_1 = (cursor.getString(4));
                deviceSetupAddRuleTwoEndTime_1= (cursor.getString(5));
                deviceSetupAddRuleTwoStartTime_2= (cursor.getString(6));
                deviceSetupAddRuleTwoEndTime_2 = (cursor.getString(7));
                deviceSetupAddRuleTwoStartTime_3= (cursor.getString(8));
                deviceSetupAddRuleTwoEndTime_3= (cursor.getString(9));
                deviceSetupAddRuleTwoStartTime_4 = (cursor.getString(10));
                deviceSetupAddRuleTwoEndTime_4= (cursor.getString(11));
                deviceSetupAddRuleTwoFlag= (cursor.getInt(19));

                deviceSetUpTwo = deviceSetupAddRuleTwoStartTime_1 + " ## " + deviceSetupAddRuleTwoEndTime_1 + " ## " + deviceSetupAddRuleTwoStartTime_2 + " ## " + deviceSetupAddRuleTwoEndTime_2 + " ## " + deviceSetupAddRuleTwoStartTime_3 + " ## " + deviceSetupAddRuleTwoEndTime_3 + " ## " + deviceSetupAddRuleTwoStartTime_4 + " ## " +deviceSetupAddRuleTwoEndTime_4 + " ##"+ deviceSetupAddRuleTwoFlag ;

            }
            while (cursor.moveToNext());
        }
        cursor.close();
        return deviceSetUpTwo;
    }

    //************** get Device Setup Add Rule Channel Three ***********
    public String getDeviceSetupAddRuleChannelThree(int position)
    {
        String selectQuery = "select * from table_device_setup_add_rule_3 where device_setup_add_rule_id_3 = '"+position+"' ";

        SQLiteDatabase db  = this.getReadableDatabase();
        Cursor cursor      = db.rawQuery(selectQuery, null);
        String deviceSetupAddRuleThreeStartTime_1,deviceSetupAddRuleThreeEndTime_1,deviceSetupAddRuleThreeStartTime_2,deviceSetupAddRuleThreeEndTime_2,deviceSetupAddRuleThreeStartTime_3,deviceSetupAddRuleThreeEndTime_3,deviceSetupAddRuleThreeStartTime_4,deviceSetupAddRuleThreeEndTime_4;
        String deviceSetUpThree="";
        int deviceSetupAddRuleThreeFlag;

        if (cursor.moveToFirst())
        {
            do
            {
                deviceSetupAddRuleThreeStartTime_1 = (cursor.getString(4));
                deviceSetupAddRuleThreeEndTime_1= (cursor.getString(5));
                deviceSetupAddRuleThreeStartTime_2= (cursor.getString(6));
                deviceSetupAddRuleThreeEndTime_2 = (cursor.getString(7));
                deviceSetupAddRuleThreeStartTime_3= (cursor.getString(8));
                deviceSetupAddRuleThreeEndTime_3= (cursor.getString(9));
                deviceSetupAddRuleThreeStartTime_4 = (cursor.getString(10));
                deviceSetupAddRuleThreeEndTime_4= (cursor.getString(11));
                deviceSetupAddRuleThreeFlag= (cursor.getInt(19));

                deviceSetUpThree = deviceSetupAddRuleThreeStartTime_1 + " ## " + deviceSetupAddRuleThreeEndTime_1 + " ## " + deviceSetupAddRuleThreeStartTime_2 + " ## " + deviceSetupAddRuleThreeEndTime_2 + " ## " + deviceSetupAddRuleThreeStartTime_3 + " ## " + deviceSetupAddRuleThreeEndTime_3 + " ## " + deviceSetupAddRuleThreeStartTime_4 + " ## " +deviceSetupAddRuleThreeEndTime_4 + " ##"+ deviceSetupAddRuleThreeFlag ;

            }
            while (cursor.moveToNext());
        }
        cursor.close();
        return deviceSetUpThree;
    }

    //************** get Device Setup Add Rule Channel Three ***********
    public String getDeviceSetupAddRuleChannelFour(int position)
    {
        // String selectQuery = "SELECT * FROM " + TABLE_DEVICE_SETUP_ADD_RULE_1;
        String selectQuery = "select * from table_device_setup_add_rule_4 where device_setup_add_rule_id_4 = '"+position+"' ";

        SQLiteDatabase db  = this.getReadableDatabase();

        Cursor cursor      = db.rawQuery(selectQuery, null);
        String deviceSetupAddRuleFourStartTime_1,deviceSetupAddRuleFourEndTime_1,deviceSetupAddRuleFourStartTime_2,deviceSetupAddRuleFourEndTime_2,deviceSetupAddRuleFourStartTime_3,deviceSetupAddRuleFourEndTime_3,deviceSetupAddRuleFourStartTime_4,deviceSetupAddRuleFourEndTime_4;
        String deviceSetUpFour="";
        int deviceSetupAddRuleFourFlag;

        if (cursor.moveToFirst())
        {
            do
            {
                deviceSetupAddRuleFourStartTime_1 = (cursor.getString(4));
                deviceSetupAddRuleFourEndTime_1= (cursor.getString(5));
                deviceSetupAddRuleFourStartTime_2= (cursor.getString(6));
                deviceSetupAddRuleFourEndTime_2 = (cursor.getString(7));
                deviceSetupAddRuleFourStartTime_3= (cursor.getString(8));
                deviceSetupAddRuleFourEndTime_3= (cursor.getString(9));
                deviceSetupAddRuleFourStartTime_4 = (cursor.getString(10));
                deviceSetupAddRuleFourEndTime_4= (cursor.getString(11));
                deviceSetupAddRuleFourFlag= (cursor.getInt(19));

                deviceSetUpFour = deviceSetupAddRuleFourStartTime_1 + " ## " + deviceSetupAddRuleFourEndTime_1 + " ## " + deviceSetupAddRuleFourStartTime_2 + " ## " + deviceSetupAddRuleFourEndTime_2 + " ## " + deviceSetupAddRuleFourStartTime_3 + " ## " + deviceSetupAddRuleFourEndTime_3 + " ## " + deviceSetupAddRuleFourStartTime_4 + " ## " +deviceSetupAddRuleFourEndTime_4 + " ##"+ deviceSetupAddRuleFourFlag ;

            }
            while (cursor.moveToNext());
        }
        cursor.close();
        return deviceSetUpFour;
    }

    //***************To Get Device Sensor Device Schedule Activity ***********************
    public int getSensorDeviceScheduleString(int position)
    {
        String selectQuery = "select * from table_sensor_device_schedule where sensor_device_schedule_id = '"+position+"' ";

        SQLiteDatabase db  = this.getReadableDatabase();
        Cursor cursor      = db.rawQuery(selectQuery, null);
        String deviceSetUpOne="";
        int deviceSetupAddRuleOneFlag = 0;


        if (cursor.moveToFirst())
        {
            do
            {
                deviceSetupAddRuleOneFlag= (cursor.getInt(16));
            }
            while (cursor.moveToNext());
        }
        cursor.close();
        return deviceSetupAddRuleOneFlag;
    }


    //***************To Get Sensor Device Schedule ***********************
    public String getSensorDeviceSchedule(int position)
    {
        String selectQuery = "select * from table_sensor_device_schedule where sensor_device_schedule_id = '"+position+"' ";

        SQLiteDatabase db  = this.getReadableDatabase();
        Cursor cursor      = db.rawQuery(selectQuery, null);
        String intrusion_detection_ontime_one,intrusion_detection_offtime_one,energy_saving_mode_ontime_two,energy_saving_mode_offtime_two, scheduled_onoff_ontime_three, scheduled_onoff_offtime_three, elderly_care_ontime_four, elderly_care_offtime_four, sensor_device_schedule_day_mon, sensor_device_schedule_day_tues, sensor_device_schedule_day_wed, sensor_device_schedule_day_thu, sensor_device_schedule_day_fri, sensor_device_schedule_day_sat,sensor_device_schedule_day_sun   ;
        String sensorDeviceSchedule="";
        int sensor_device_schedule_flag;

        if (cursor.moveToFirst())
        {
            do
            {
                intrusion_detection_ontime_one = (cursor.getString(1));
                intrusion_detection_offtime_one= (cursor.getString(2));
                energy_saving_mode_ontime_two= (cursor.getString(3));
                energy_saving_mode_offtime_two = (cursor.getString(4));
                scheduled_onoff_ontime_three= (cursor.getString(5));
                scheduled_onoff_offtime_three= (cursor.getString(6));
                elderly_care_ontime_four = (cursor.getString(7));
                elderly_care_offtime_four= (cursor.getString(8));

                sensor_device_schedule_day_mon= (cursor.getString(9));
                sensor_device_schedule_day_tues= (cursor.getString(10));
                sensor_device_schedule_day_wed= (cursor.getString(11));
                sensor_device_schedule_day_thu= (cursor.getString(12));
                sensor_device_schedule_day_fri= (cursor.getString(13));
                sensor_device_schedule_day_sat= (cursor.getString(14));
                sensor_device_schedule_day_sun= (cursor.getString(15));
                sensor_device_schedule_flag= (cursor.getInt(16));

                sensorDeviceSchedule = intrusion_detection_ontime_one + " ## " + intrusion_detection_offtime_one + " ## " + energy_saving_mode_ontime_two + " ## " + energy_saving_mode_offtime_two + " ## " + scheduled_onoff_ontime_three + " ## " + scheduled_onoff_offtime_three + " ## " + elderly_care_ontime_four + " ## " + elderly_care_offtime_four + " ## "
                        + sensor_device_schedule_day_mon +" ## " + sensor_device_schedule_day_tues + " ## " + sensor_device_schedule_day_wed + " ## " + sensor_device_schedule_day_thu + " ## " + sensor_device_schedule_day_fri +" ## " + sensor_device_schedule_day_sat + " ## " + sensor_device_schedule_day_sun + " ##"+ sensor_device_schedule_flag ;

            }
            while (cursor.moveToNext());
        }
        cursor.close();
        return sensorDeviceSchedule;
    }

    // Update data from Channel One Activity
    public void updateAddChannelOneSchedule(String setRule,String selectRoom, String selectDevice, String startTime1, String endTime1, String startTime2, String endTime2, String startTime3, String endTime3, String startTime4, String endTime4, boolean day1, boolean day2, boolean day3, boolean day4, boolean day5, boolean day6, boolean day7)
    {
        try
        {
            SQLiteDatabase db = this.getWritableDatabase();
            String sql = "UPDATE table_device_setup_add_rule_1 SET device_setup_add_rule_addrule = '"+setRule+"', device_setup_add_rule_select_room  = '"+selectRoom+"', device_setup_add_rule_select_device = '"+selectDevice+"', " +
                    "device_setup_add_rule_select_starttime1   = '"+startTime1+"', device_setup_add_rule_select_select_endtime1    = '"+endTime1+"', " +
                    " device_setup_add_rule_select_starttime2  = '"+startTime2+"', device_setup_add_rule_select_select_endtime2    = '"+endTime2+"', " +
                    "device_setup_add_rule_select_starttime3   = '"+startTime3+"', device_setup_add_rule_select_select_endtime3    = '"+endTime3+"'," +
                    " device_setup_add_rule_select_starttime4  = '"+startTime4+"', device_setup_add_rule_select_select_endtime4    = '"+endTime4+"', " +
                    " device_setup_add_rule_select_day_mon     = '"+day1+"',       device_setup_add_rule_select_day_tues           = '"+day2+"',   " +
                    "  device_setup_add_rule_select_day_wed    = '"+day3+"',       device_setup_add_rule_select_day_thu            = '"+day4+"',  " +
                    " device_setup_add_rule_select_day_fri     = '"+day5+"',       device_setup_add_rule_select_day_sat            = '"+day6+"', device_setup_add_rule_select_day_sun = '"+day7+"' WHERE device_setup_add_rule_id_1 = '1' ";

            db.execSQL(sql);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    // Update data from Channel Two Activity
    public void updateAddChannelTwoSchedule(String setRule,String selectRoom, String selectDevice, String startTime1, String endTime1, String startTime2, String endTime2, String startTime3, String endTime3, String startTime4, String endTime4, boolean day1, boolean day2, boolean day3, boolean day4, boolean day5, boolean day6, boolean day7)
    {
        try
        {
            SQLiteDatabase db = this.getWritableDatabase();
            String sql = "UPDATE table_device_setup_add_rule_2 SET device_setup_add_rule_addrule_2 = '"+setRule+"', device_setup_add_rule_select_room_2  = '"+selectRoom+"', device_setup_add_rule_select_device_2 = '"+selectDevice+"', " +
                    "device_setup_add_rule_select_starttime_1   = '"+startTime1+"', device_setup_add_rule_select_select_endtime_1    = '"+endTime1+"', " +
                    " device_setup_add_rule_select_starttime_2  = '"+startTime2+"', device_setup_add_rule_select_select_endtime_2    = '"+endTime2+"', " +
                    "device_setup_add_rule_select_starttime_3   = '"+startTime3+"', device_setup_add_rule_select_select_endtime_3    = '"+endTime3+"'," +
                    " device_setup_add_rule_select_starttime_4  = '"+startTime4+"', device_setup_add_rule_select_select_endtime_4    = '"+endTime4+"', " +
                    " device_setup_add_rule_select_day_mon_2     = '"+day1+"',       device_setup_add_rule_select_day_tues_2           = '"+day2+"',   " +
                    "  device_setup_add_rule_select_day_wed_2    = '"+day3+"',       device_setup_add_rule_select_day_thu_2            = '"+day4+"',  " +
                    " device_setup_add_rule_select_day_fri_2     = '"+day5+"',       device_setup_add_rule_select_day_sat_2            = '"+day6+"', device_setup_add_rule_select_day_sun_2 = '"+day7+"' WHERE device_setup_add_rule_id_2 = '1' ";

            db.execSQL(sql);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }





    // Update data from Channel Three Activity
    public void updateAddChannelThreeSchedule(String setRule,String selectRoom, String selectDevice, String startTime1, String endTime1, String startTime2, String endTime2, String startTime3, String endTime3, String startTime4, String endTime4, boolean day1, boolean day2, boolean day3, boolean day4, boolean day5, boolean day6, boolean day7)
    {
        try
        {
            SQLiteDatabase db = this.getWritableDatabase();
            String sql = "UPDATE table_device_setup_add_rule_3 SET device_setup_add_rule_addrule_3 = '"+setRule+"', device_setup_add_rule_select_room_3  = '"+selectRoom+"', device_setup_add_rule_select_device_3 = '"+selectDevice+"', " +
                    "device_setup_add_rule_select_starttime_1   = '"+startTime1+"', device_setup_add_rule_select_select_endtime_1    = '"+endTime1+"', " +
                    " device_setup_add_rule_select_starttime_2  = '"+startTime2+"', device_setup_add_rule_select_select_endtime_2    = '"+endTime2+"', " +
                    "device_setup_add_rule_select_starttime_3   = '"+startTime3+"', device_setup_add_rule_select_select_endtime_3    = '"+endTime3+"'," +
                    " device_setup_add_rule_select_starttime_4  = '"+startTime4+"', device_setup_add_rule_select_select_endtime_4    = '"+endTime4+"', " +
                    " device_setup_add_rule_select_day_mon_3     = '"+day1+"',       device_setup_add_rule_select_day_tues_3           = '"+day2+"',   " +
                    "  device_setup_add_rule_select_day_wed_3    = '"+day3+"',       device_setup_add_rule_select_day_thu_3            = '"+day4+"',  " +
                    " device_setup_add_rule_select_day_fri_3     = '"+day5+"',       device_setup_add_rule_select_day_sat_3            = '"+day6+"', device_setup_add_rule_select_day_sun_3 = '"+day7+"' WHERE device_setup_add_rule_id_3 = '1' ";

            db.execSQL(sql);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }


    // Update data from Channel Four Activity
    public void updateAddChannelFourSchedule(String setRule,String selectRoom, String selectDevice, String startTime1, String endTime1, String startTime2, String endTime2, String startTime3, String endTime3, String startTime4, String endTime4, boolean day1, boolean day2, boolean day3, boolean day4, boolean day5, boolean day6, boolean day7)
    {
        try
        {
            SQLiteDatabase db = this.getWritableDatabase();
            String sql = "UPDATE table_device_setup_add_rule_4 SET device_setup_add_rule_addrule_4 = '"+setRule+"', device_setup_add_rule_select_room_4  = '"+selectRoom+"', device_setup_add_rule_select_device_4 = '"+selectDevice+"', " +
                    "device_setup_add_rule_select_starttime1   = '"+startTime1+"', device_setup_add_rule_select_select_endtime1    = '"+endTime1+"', " +
                    " device_setup_add_rule_select_starttime_2  = '"+startTime2+"', device_setup_add_rule_select_select_endtime_2    = '"+endTime2+"', " +
                    "device_setup_add_rule_select_starttime_3   = '"+startTime3+"', device_setup_add_rule_select_select_endtime_3    = '"+endTime3+"'," +
                    " device_setup_add_rule_select_starttime_4  = '"+startTime4+"', device_setup_add_rule_select_select_endtime_4    = '"+endTime4+"', " +
                    " device_setup_add_rule_select_day_mon_4     = '"+day1+"',       device_setup_add_rule_select_day_tues_4           = '"+day2+"',   " +
                    "  device_setup_add_rule_select_day_wed_4    = '"+day3+"',       device_setup_add_rule_select_day_thu_4            = '"+day4+"',  " +
                    " device_setup_add_rule_select_day_fri_4     = '"+day5+"',       device_setup_add_rule_select_day_sat_4            = '"+day6+"', device_setup_add_rule_select_day_sun_4 = '"+day7+"' WHERE device_setup_add_rule_id_4 = '1' ";

            db.execSQL(sql);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    // Update data from SensorDeviceSchedule Activity
    public void updateSensorDeviceSchedule( String startTime1, String endTime1, String startTime2, String endTime2, String startTime3, String endTime3, String startTime4, String endTime4, boolean day1, boolean day2, boolean day3, boolean day4, boolean day5, boolean day6, boolean day7, boolean isNotification)
    {
        try
        {
            SQLiteDatabase db = this.getWritableDatabase();
            String sql = "UPDATE table_sensor_device_schedule SET  " + "intrusion_detection_ontime_one   = '"+startTime1+"', intrusion_detection_offtime_one    = '"+endTime1+"', " +
                    " energy_saving_mode_ontime_two  = '"+startTime2+"', energy_saving_mode_offtime_two    = '"+endTime2+"', " +
                    "scheduled_onoff_ontime_three   = '"+startTime3+"', scheduled_onoff_offtime_three    = '"+endTime3+"'," +
                    " elderly_care_ontime_four  = '"+startTime4+"', elderly_care_offtime_four    = '"+endTime4+"', " +
                    " sensor_device_schedule_day_mon     = '"+day1+"',       sensor_device_schedule_day_tues           = '"+day2+"',   " +
                    "  sensor_device_schedule_day_wed    = '"+day3+"',       sensor_device_schedule_day_thu            = '"+day4+"',  " +
                    " sensor_device_schedule_day_fri     = '"+day5+"',       sensor_device_schedule_day_sat            = '"+day6+"', sensor_device_schedule_day_sun = '"+day7+"', sensor_device_schedule_notification = '"+isNotification+"' WHERE sensor_device_schedule_id = '1' ";

            db.execSQL(sql);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }


    public   void insertDeviceSetupChannel(String deviceSetupChannelOne, String deviceSetupChannelTwo, String deviceSetupChannelThree, String deviceSetupChannelFour)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.beginTransaction();

        ContentValues values = new ContentValues();
        values.put(DEVICE_SETUP_CHANNEL_ONE, deviceSetupChannelOne);
        values.put(DEVICE_SETUP_CHANNEL_TWO, deviceSetupChannelTwo);
        values.put(DEVICE_SETUP_CHANNEL_THREE, deviceSetupChannelThree);
        values.put(DEVICE_SETUP_CHANNEL_FOUR, deviceSetupChannelFour);

        // Inserting Row
        db.insert(TABLE_DEVICE_SETUP_CHANNEL, null, values);
        db.setTransactionSuccessful();
        db.endTransaction();
        db.close(); // Closing database connection

    }

}




