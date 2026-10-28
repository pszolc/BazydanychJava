package com.example.myapplication;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "zwierzeta")
public class Zwierze {
    @PrimaryKey(autoGenerate = true)
    public int id;


    public  String gatunek;

    @ColumnInfo(name = "srodowisko_zycia")
    public String srodowisko;


    public boolean czyRoslinozerny;
    //true je rosliny false = jest normalny

    public int sredniWiek;

    public Zwierze() {
    }

    public Zwierze(String gatunek, boolean czyRoslinozerny, int sredniWiek, String srodowisko) {
        this.gatunek = gatunek;
        this.czyRoslinozerny = czyRoslinozerny;
        this.sredniWiek = sredniWiek;
        this.srodowisko = srodowisko;
    }
}
