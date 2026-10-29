package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private EditText editTextGatunek, editTextWiek;
    private Spinner spinner;
    private CheckBox checkBox;
    private Button przycisk;
    private ZwierzetaDataBase zwierzetaDataBase;
    private ListView listView;
    private ArrayAdapter<Zwierze> arrayAdapter;
    private List<Zwierze> zwierzeta;

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

        editTextGatunek = findViewById(R.id.editTextText);
        editTextWiek = findViewById(R.id.editTextNumber);
        przycisk = findViewById(R.id.button);
        spinner = findViewById(R.id.spinner);
        checkBox = findViewById(R.id.checkBox);



        zwierzetaDataBase = Room.databaseBuilder(
                getApplicationContext(),
                ZwierzetaDataBase.class,
                "zwierzeta_db"
        ).allowMainThreadQueries().build();

        zwierzetaDataBase.zwrocZwierzeDAO().wstawdoBazy(
                new Zwierze("sarna europjeska", true, 12, "srdpwpislp")
        );

        przycisk.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Zwierze zwierze = new Zwierze(
                                editTextGatunek.getText().toString(),
                                checkBox.isChecked(),
                                Integer.parseInt(editTextWiek.getText().toString()),
                                spinner.getSelectedItem().toString()
                        );
                        zwierzetaDataBase.zwrocZwierzeDAO().wstawdoBazy(zwierze);
                    }
                }
        );
        listView=findViewById(R.id.idlist);
        zwierzeta=zwierzetaDataBase.zwrocZwierzeDAO().zwrovWszytskieZwierzeta();
        arrayAdapter=new ArrayAdapter<>(MainActivity.this,
                android.R.layout.simple_list_item_1,
                zwierzeta);
        listView.setAdapter(arrayAdapter);

    }
}