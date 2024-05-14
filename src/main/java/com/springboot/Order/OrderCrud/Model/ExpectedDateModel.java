package com.springboot.Order.OrderCrud.Model;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Size;
import org.springframework.dao.DataAccessException;

import java.util.Date;

public class ExpectedDateModel {


    int id;
    @FutureOrPresent(message = "Delivery date should be in future or today")
    Date expectedDate;

    public ExpectedDateModel() {
    }

    public ExpectedDateModel(int id, Date expectedDate) {
        this.id = id;
        this.expectedDate = expectedDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getExpectedDate() {
        return expectedDate;
    }

    public void setExpectedDate(Date expectedDate) {
        this.expectedDate = expectedDate;
    }

    @Override
    public String toString() {
        return "ExpectedDateModel{" +
                "id=" + id +
                ", expectedDate=" + expectedDate +
                '}';
    }
}
