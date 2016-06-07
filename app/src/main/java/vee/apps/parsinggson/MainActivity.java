package vee.apps.parsinggson;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;

import vee.apps.parsinggson.hasilparsing.Holidays;
import vee.apps.parsinggson.hasilparsing.HolidaysItem;

public class MainActivity extends AppCompatActivity {

    static TextView tvHello;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvHello = (TextView)findViewById(R.id.txtHello);

        String secondStorage = System.getenv("SECONDARY_STORAGE");
        String filename = secondStorage + "/mSignage/holiday.txt";

        ReadTxt read = new ReadTxt();
        Gson gson = new GsonBuilder().create();

        //read txt file
        String isiFile = read.readFile(filename);

        Holidays holidays = gson.fromJson(isiFile,Holidays.class);

        HolidaysItem holItem;
        String isi = "";

        for(int i=0;i<holidays.getListHolidays().size();i++){
            holItem = holidays.getListHolidays().get(i);
            isi += holItem.getCountry() + "\n" + holItem.getDate() + " - " + holItem.getName() + "\n\n";
        }

        tvHello.setText(isi);
    }
}
