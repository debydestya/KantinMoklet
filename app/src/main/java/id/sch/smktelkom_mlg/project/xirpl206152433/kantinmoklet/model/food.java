package id.sch.smktelkom_mlg.project.xirpl206152433.kantinmoklet.model;

import java.io.Serializable;

/**
 * Created by fanani on 11/20/2016.
 */

public class food implements Serializable {
    public String judul;
    public String deskripsi;
    public String lokasi;
    public String foto;

    public food(String judul, String deskripsi, String lokasi, String foto) {
        this.judul = judul;
        this.deskripsi = deskripsi;
        this.lokasi = lokasi;
        this.foto = foto;
    }
}
