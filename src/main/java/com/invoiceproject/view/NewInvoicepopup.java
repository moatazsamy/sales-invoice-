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

    public NewInvoicepopup(Frame frame) {

        customerNameLbl = new JLabel("Customer Name");
        customerName = new JTextField(20);
        dateLbl = new JLabel("Inovice Date ");
        date = new JTextField(10);

        Okbtn = new JButton("ok");
        cancelbtn = new JButton("Cancel");

        Okbtn.setActionCommand("create new invoice Ok");
        cancelbtn.setActionCommand("cancel invoice");

        Okbtn.addActionListener(frame.getListener());
        cancelbtn.addActionListener(frame.getListener());

        setLayout(new GridLayout(3, 2));

        add(customerNameLbl);
        add(customerName);
        add(dateLbl);
        add(date);

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

}
