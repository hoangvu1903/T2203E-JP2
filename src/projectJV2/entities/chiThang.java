package projectJV2.entities;

import java.util.Date;

public class chiThang {
    public Integer id;
    public String sname;
    public Integer spending;
    public String date;

    public chiThang(Integer id, String sname, Integer spending, String date) {
        this.id = id;
        this.sname = sname;
        this.spending = spending;
        this.date = date;
    }

    public chiThang(int id, String sname, int spending, Date date) {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public Integer getSpending() {
        return spending;
    }

    public void setSpending(Integer spending) {
        this.spending = spending;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public chiThang() {

    }
}

    
