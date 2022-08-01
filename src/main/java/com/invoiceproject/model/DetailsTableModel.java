/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.invoiceproject.model;

import java.util.List;
import javax.swing.table.AbstractTableModel;

public class DetailsTableModel extends AbstractTableModel {

    private String[] columnNames = {"Item Name", "price", "Count", "Item Total"};

    private List<InvoiceLine> Details;

    public DetailsTableModel(List<InvoiceLine> Details) {
        this.Details = Details;
    }

    @Override
    public int getRowCount() {
        return Details.size();
    }

    @Override
    public int getColumnCount() {

        return columnNames.length;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        InvoiceLine details = Details.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return details.getItem();
            case 1:
                return details.getPrice();
            case 2:
                return details.getCount();
            case 3:
                return details.getTotal();

        }
        return "";
    }

    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }

    public List<InvoiceLine> getDetails() {
        return Details;
    }
}
