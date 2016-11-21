package id.sch.smktelkom_mlg.project.xirpl206152433.kantinmoklet.model;

import java.io.Serializable;


public class food implements Serializable {
    public String judulf;
    public String deskripsif;
    public String lokasif;
    public String fotof;

    public food(String judulf, String deskripsif, String lokasif, String fotof) {
        this.judulf = judulf;
        this.deskripsif = deskripsif;
        this.lokasif = lokasif;
        this.fotof = fotof;
    }
}
