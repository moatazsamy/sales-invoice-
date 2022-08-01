package com.invoiceproject.controller;

import com.invoiceproject.model.DetailsTableModel;
import com.invoiceproject.model.InvoiceLine;
import com.invoiceproject.model.InvoiceList;
import com.invoiceproject.model.ListingTableModel;
import com.invoiceproject.view.Frame;
import com.invoiceproject.view.NewInvoicepopup;
import com.invoiceproject.view.NewInvoiceLine;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class InvoiceListener implements ActionListener, ListSelectionListener {

    private InvoiceList invlist;
    private Frame frame;
    private DetailsTableModel dm;
    private NewInvoicepopup invoicePopup;
    private NewInvoiceLine invoiceLineDialoge;

    public InvoiceListener(Frame frame) {

        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();

        switch (action) {
            case "Add Invoice":
                createInvoice();
                break;
            case "delete Invoice":
                deleteInvoice();
                break;

            case "create new Line":
                createNewLine();
                break;
            case "create new line Ok":
                createNewLineOk();
                break;
            case "cancel":
                break;
            case "load":
                loadData(null, null);
                break;
            case "save files":
                saveFileData();
                break;
            case "create new invoice Ok":
                addNewInvoicePopup();
            case "cancel invoice":
                cancelNewInvoicePopup();
                break;
            case "cancel line":
                cancelLine();
                break;

        }
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        int selectedRow = frame.getInvoicesTable().getSelectedRow();
        int selectedColumn = frame.getInvoicesTable().getSelectedColumn();

        if (selectedRow > -1 && selectedRow < frame.getInvoices().size()) {
            InvoiceList invoice = frame.getInvoices().get(selectedRow);
            List<InvoiceLine> Itemdetails = invoice.getLines();
            frame.getDetailsTable().setModel(new DetailsTableModel(Itemdetails));

            frame.getNumber().setText("" + invoice.getNumber());
            frame.getCustName().setText("" + invoice.getCustomer());
            frame.getTotal().setText("" + invoice.getTotal());
            frame.getInvDate().setText("" + frame.simpleDate.format(invoice.getDate()));

            DetailsTableModel dm = new DetailsTableModel(Itemdetails);
            dm.isCellEditable(selectedRow, selectedColumn);
            dm.setValueAt(frame.getNumber().getText(), selectedRow, selectedColumn);

        } else {

            frame.getNumber().setText("");
            frame.getCustName().setText("");
            frame.getTotal().setText("");
            frame.getInvDate().setText("");
            frame.getDetailsTable().setModel(new DetailsTableModel(new ArrayList<InvoiceLine>()));
        }

    }

    private void saveFileData() {

        String invoiceHeaderData = "";
        String invoiceLineData = "";

        for (InvoiceList invoice : frame.getInvoices()) {

            invoiceHeaderData += invoice.changeToCSV();
            invoiceHeaderData += "\n";

            for (InvoiceLine invline : invoice.getLines()) {

                invoiceLineData += invline.changeToCSV();
                invoiceLineData += "\n";
            }
        }
        JFileChooser filechooser = new JFileChooser();
        int result = filechooser.showSaveDialog(frame);

        if (result == JFileChooser.APPROVE_OPTION) {
            File headerFile = filechooser.getSelectedFile();

            result = filechooser.showSaveDialog(frame);

            if (result == JFileChooser.APPROVE_OPTION) {

                File lineFile = filechooser.getSelectedFile();

                try {
                    FileWriter headerFw = new FileWriter(headerFile);
                    headerFw.write(invoiceHeaderData);
                    headerFw.flush();
                    headerFw.close();

                    FileWriter lineFw = new FileWriter(lineFile);
                    lineFw.write(invoiceLineData);
                    lineFw.flush();
                    lineFw.close();
                } catch (IOException e) {

                    JOptionPane.showMessageDialog(frame, "can't save", "error", JOptionPane.ERROR_MESSAGE);

                };
            }
        }

    }

    public void createNewLine() {

        int selectedInvocie = frame.getInvoicesTable().getSelectedRow();
        if (selectedInvocie != -1) {
            invoiceLineDialoge = new NewInvoiceLine(frame);
            invoiceLineDialoge.setVisible(true);
        }

    }

    public void createNewLineOk() {

        int selectInvoice = frame.getInvoicesTable().getSelectedRow();

        if (selectInvoice != -1) {
            InvoiceList invoice = frame.getInvoices().get(selectInvoice);
            String name = invoiceLineDialoge.getItemNameField().getText();
            String pricestr = invoiceLineDialoge.getItemPriceField().getText();
            String countstr = invoiceLineDialoge.getItemCountField().getText();
            invoiceLineDialoge.setVisible(true);
            invoiceLineDialoge.dispose();
            Double price = Double.parseDouble(pricestr);
            int count = Integer.parseInt(countstr);

            InvoiceLine invLine = new InvoiceLine(name, price, count, invoice);
            invoice.getLines().add(invLine);

            ((DetailsTableModel) frame.getDetailsTable().getModel()).fireTableDataChanged();
            ((ListingTableModel) frame.getInvoicesTable().getModel()).fireTableDataChanged();
            frame.getInvoicesTable().setRowSelectionInterval(selectInvoice, selectInvoice);

        }

    }

    public void cancelLine() {

        invoiceLineDialoge.setVisible(false);
        invoiceLineDialoge.dispose();

    }

    private void createInvoice() {

        invoicePopup = new NewInvoicepopup(frame);
        invoicePopup.setVisible(true);
    }

    private void addNewInvoicePopup() {

        String customerName = invoicePopup.getCustomerName().getText();
        String date = invoicePopup.getDate().getText();
        // String itemName = invoicePopup.getItemNameField().getText();
        //   Double itemPrice = Double.parseDouble(invoicePopup.getItemPriceField().getText());
        // int itemCount = Integer.parseInt(invoicePopup.getItemCountField().getText());

        invoicePopup.setVisible(false);
        invoicePopup.dispose();

        int num = getInvoiceNum();

        try {
            Date invoiceDate = frame.simpleDate.parse(date);
            InvoiceList invoice = new InvoiceList(num, invoiceDate, customerName);
            frame.getInvoices().add(invoice);
            ((ListingTableModel) frame.getInvoicesTable().getModel()).fireTableDataChanged();

            //InvoiceList invoiceNumber = getInvoiceByNumber(num);
            // InvoiceLine invline = new InvoiceLine(customerName, itemPrice, itemCount, invoiceNumber);
            // invoice.getLines().add(invline);
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(frame, "Please enter a valid date format", "ERROR", JOptionPane.ERROR_MESSAGE);
        }

    }

    public void cancelNewInvoicePopup() {

        invoicePopup.setVisible(false);
        invoicePopup.dispose();

    }

    private int getInvoiceNum() {
        int num = 1;
        for (InvoiceList invoice : frame.getInvoices()) {
            if (invoice.getNumber() > num) {

                num = invoice.getNumber();

            }
        }
        return num + 1;

    }

    private void deleteInvoice() {

        int deletedRow = frame.getInvoicesTable().getSelectedRow();

        if (deletedRow != -1) {
            frame.getInvoices().remove(deletedRow);
            ((ListingTableModel) frame.getInvoicesTable().getModel()).fireTableDataChanged();
        }
    }

    private void saveInvoice() {

    }

    private InvoiceList getInvoiceByNumber(int number) {

        for (InvoiceList invoice : frame.getInvoices()) {

            if (number == invoice.getNumber()) {

                return invoice;
            }
        }
        return null;

    }

    public void loadData(String header, String line) {

        File headerFile = null;
        File lineFile = null;

        if (header == null && line == null) {
            JFileChooser fileChooser = new JFileChooser();
            int selectedResult = fileChooser.showOpenDialog(frame);
            if (selectedResult == JFileChooser.APPROVE_OPTION) {
                headerFile = fileChooser.getSelectedFile();
                selectedResult = fileChooser.showOpenDialog(frame);
                if (selectedResult == JFileChooser.APPROVE_OPTION) {
                    lineFile = fileChooser.getSelectedFile();
                }
            }

        } else {
            headerFile = new File(header);
            lineFile = new File(line);
        }
        if (headerFile != null && lineFile != null) {

            try {
                List<String> headerDataLines = Files.lines(Paths.get(headerFile.getAbsolutePath())).collect(Collectors.toList());
                List<String> dataLines = Files.lines(Paths.get(lineFile.getAbsolutePath())).collect(Collectors.toList());
                ArrayList<InvoiceList> invoices = new ArrayList<>();

                for (String headerdata : headerDataLines) {
                    String[] sections = headerdata.split(",");

                    String number = sections[0];
                    String dateStr = sections[1];
                    String name = sections[2];

                    int num = Integer.parseInt(number);
                    Date date = Frame.simpleDate.parse(dateStr);
                    InvoiceList inv = new InvoiceList(num, date, name);
                    frame.getInvoices().add(inv);
                }

                for (String details : dataLines) {
                    String[] detailsSplit = details.split(",");

                    int number = Integer.parseInt(detailsSplit[0]);

                    String customerName = detailsSplit[1];
                    double price = Double.parseDouble(detailsSplit[2]);
                    int count = Integer.parseInt(detailsSplit[3]);

                    InvoiceList invoice = getInvoiceByNumber(number);

                    InvoiceLine invline = new InvoiceLine(customerName, price, count, invoice);

                    invoice.getLines().add(invline);

                    //   frame.getInvoiceLines().add(invline);
                }
                frame.getInvoicesTable().setModel(new ListingTableModel(frame.getInvoices()));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

}
