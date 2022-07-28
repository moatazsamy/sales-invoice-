package com.invoiceproject.model;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import com.invoiceproject.view.Frame;

public class ListingTableModel extends AbstractTableModel {

    private String[] columnNames = {"Number", "Date", "Customer Name", "Total"};
    private List<InvoiceList> invoices;

    public ListingTableModel(List<InvoiceList> invoices) {

        this.invoices = invoices;
    }

    public int getRowCount() {

        return invoices.size();
    }

    public int getColumnCount() {

        return columnNames.length;
    }

    public String getColumnName(int columnIndex) {

        return columnNames[columnIndex];
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        InvoiceList inv = invoices.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return inv.getNumber();

            case 1:
                return Frame.simpleDate.format(inv.getDate());

            case 2:
                return inv.getCustomer();
            case 3:
                return inv.getTotal();
        }

        return "";
    }

}
