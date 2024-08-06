package com.spring_boot.order.order_crud.entity;

import javax.swing.text.DateFormatter;
import java.text.DateFormat;
import java.util.Date;

public class Practice implements Comparable<Practice> {
    String msg;
    Date date;
    DateFormatter formateDate = new DateFormatter();


    public Practice(String msg, Date date) {
        this.msg = msg;
        this.date = date;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "practice{" +
                "msg='" + msg + '\'' +
                ", date=" + date +
                '}';
    }



    @Override
    public int compareTo(Practice o) {
        return this.date.compareTo(o.date);
    }
}
