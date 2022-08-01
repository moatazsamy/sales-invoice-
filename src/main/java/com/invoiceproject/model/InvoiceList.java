package com.invoiceproject.model;

import com.invoiceproject.view.Frame;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author lenovo
 */
public class InvoiceList extends DefaultTableModel {

    private int number;
    private String customer;
    private Date date;
    private ArrayList<InvoiceLine> Lines;

    public InvoiceList(int number, Date date, String customer) {
        this.number = number;
        this.customer = customer;
        this.date = date;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public ArrayList<InvoiceLine> getLines() {

        if (Lines == null) {

            Lines = new ArrayList<>();
        }
        return Lines;
    }

    public void setLines(ArrayList<InvoiceLine> Lines) {
        this.Lines = Lines;
    }

    public double getTotal() {

        double total = 0;
        for (InvoiceLine line : getLines()) {
            total += line.getTotal();
        }
        return total;
    }

    public String changeToCSV() {

        return number + "," + Frame.simpleDate.format(date) + "," + customer;

    }
}
