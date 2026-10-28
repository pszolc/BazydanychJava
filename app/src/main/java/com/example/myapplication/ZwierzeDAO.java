package com.example.myapplication;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface ZwierzeDAO {

    @Insert
    public void wstawdoBazy(Zwierze zwierze);

    @Insert
    public void wstawWIecejZwierzat(Zwierze ... zwierzes);
    @Delete
    public void usunZBazy(Zwierze zwierze);

    @Update
    public void zauktualizujZwierze(Zwierze zwierze);

    @Query("Select * FROM zwierzeta")
    public List<Zwierze> zwrovWszytskieZwierzeta();

    @Query("Select gatunek FROM zwierzeta WHERE sredniWiek>:wiek")
    public List<String> zwrocgatunkiStarszeNIz(int wiek);




}
