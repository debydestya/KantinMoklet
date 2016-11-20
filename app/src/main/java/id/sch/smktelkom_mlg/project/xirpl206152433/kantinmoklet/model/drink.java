package id.sch.smktelkom_mlg.project.xirpl206152433.kantinmoklet.model;


import android.graphics.drawable.Drawable;

import java.io.Serializable;

public class drink implements Serializable
{
    public String judul;
    public String deskripsi;
    public String lokasi;
    public String foto;

    public drink(String judul, String deskripsi,String lokasi, String foto)
    {
        this.judul = judul;
        this.deskripsi = deskripsi;
        this.lokasi = lokasi;
        this.foto = foto;
    }
}
