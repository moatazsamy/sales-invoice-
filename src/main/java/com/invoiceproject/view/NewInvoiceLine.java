/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.invoiceproject.view;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class NewInvoiceLine extends JDialog {

    private JLabel itemNameLbl;
    private JLabel itemPriceLbl;
    private JLabel itemCountLbl;

    private JTextField itemNameField;
    private JTextField itemPriceField;
    private JTextField itemCountField;
    private JButton Okbtn;
    private JButton cancelbtn;

    public NewInvoiceLine(Frame frame) {

        itemNameLbl = new JLabel("Item Name");

        itemPriceLbl = new JLabel("Item Price");

        itemCountLbl = new JLabel("Item Count");
        itemNameField = new JTextField(20);
        itemCountField = new JTextField(20);
        itemPriceField = new JTextField(20);

        Okbtn = new JButton("ok");
        cancelbtn = new JButton("Cancel");

        Okbtn.setActionCommand("create new line Ok");
        cancelbtn.setActionCommand("cancel line");

        Okbtn.addActionListener(frame.getListener());
        cancelbtn.addActionListener(frame.getListener());

        setLayout(new GridLayout(4, 2));

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
