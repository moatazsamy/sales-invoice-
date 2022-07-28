package com.invoiceproject.view;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class NewInvoicepopup extends JDialog {

    private JTextField customerName;
    private JTextField date;
    private JLabel customerNameLbl;
    private JLabel dateLbl;
    private JButton Okbtn;
    private JButton cancelbtn;

    ///
    private JLabel itemNameLbl;
    private JLabel itemPriceLbl;
    private JLabel itemCountLbl;

    private JTextField itemNameField;
    private JTextField itemPriceField;
    private JTextField itemCountField;

    public NewInvoicepopup(Frame frame) {

        customerNameLbl = new JLabel("Customer Name");
        customerName = new JTextField(20);
        dateLbl = new JLabel("Inovice Date ");
        date = new JTextField(10);

        //////
        itemNameLbl = new JLabel("Item Name");

        itemPriceLbl = new JLabel("Item Price");

        itemCountLbl = new JLabel("Item Count");
        itemNameField = new JTextField(20);
        itemCountField = new JTextField(20);
        itemPriceField = new JTextField(20);

        Okbtn = new JButton("ok");
        cancelbtn = new JButton("Cancel");

        Okbtn.setActionCommand("create new invoice Ok");
        cancelbtn.setActionCommand("cancel invoice");

        Okbtn.addActionListener(frame.getListener());
        cancelbtn.addActionListener(frame.getListener());

        setLayout(new GridLayout(6, 2));

        add(customerNameLbl);
        add(customerName);
        add(dateLbl);
        add(date);

        add(itemNameLbl);
        add(itemNameField);
        add(itemPriceLbl);
        add(itemPriceField);
        add(itemCountLbl);
        add(itemCountField);

        add(Okbtn);
        add(cancelbtn);
        setModal(true);
        pack();

    }

    public JTextField getCustomerName() {
        return customerName;
    }

    public JTextField getDate() {
        return date;
    }

    public JTextField getItemNameField() {
        return itemNameField;
    }

    public JTextField getItemPriceField() {
        return itemPriceField;
    }

    public JTextField getItemCountField() {
        return itemCountField;
    }

}
