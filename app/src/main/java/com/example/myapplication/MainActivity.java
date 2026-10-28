package com.example.myapplication;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.room.Room;
import androidx.room.RoomDatabase;

public class MainActivity extends AppCompatActivity {
    private ZwierzetaDataBase zwierzetaDataBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        zwierzetaDataBase = Room.databaseBuilder(
                getApplicationContext(),
                ZwierzetaDataBase.class,
                "zwierzeta_db"
        ).allowMainThreadQueries().build();

        zwierzetaDataBase.zwrocZwierzeDAO().wstawdoBazy(
                new Zwierze("sarna europjeska", true, 12, "srdpwpislp")
        );


    }
}