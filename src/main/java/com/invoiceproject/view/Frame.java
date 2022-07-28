
package com.invoiceproject.view;

import com.invoiceproject.controller.InvoiceListener;
import com.invoiceproject.model.DetailsTableModel;
import com.invoiceproject.model.InvoiceLine;
import com.invoiceproject.model.InvoiceList;
import com.invoiceproject.model.ListingTableModel;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JTable;

/**
 *
 * @author lenovo
 */
public class Frame extends javax.swing.JFrame {

    /**
     * Creates new form Frame
     */
    public Frame() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        InvoiceTable = new javax.swing.JTable();
        InvoiceTable.getSelectionModel().addListSelectionListener(listener);
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        number = new javax.swing.JLabel();
        custName = new javax.swing.JLabel();
        invDate = new javax.swing.JLabel();
        Total = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        detailsTable = new javax.swing.JTable();
        addBtn = new javax.swing.JButton();
        addBtn.addActionListener(listener);
        deleteBtn = new javax.swing.JButton();
        deleteBtn.addActionListener(listener);
        saveBtn = new javax.swing.JButton();
        saveBtn.addActionListener(listener);
        cancelBtn = new javax.swing.JButton();
        cancelBtn.addActionListener(listener);
        jMenuBar1 = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        loadMenu = new javax.swing.JMenuItem();
        loadMenu.addActionListener(listener);
        saveMenu = new javax.swing.JMenuItem();
        saveMenu.addActionListener(listener);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        InvoiceTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(InvoiceTable);

        jLabel1.setText("no.");

        jLabel2.setText("customer name ");

        jLabel3.setText("inovice date ");

        jLabel4.setText("total");

        number.setText("jLabel5");

        custName.setText("jLabel6");

        invDate.setText("jLabel7");

        Total.setText("jLabel8");

        detailsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(detailsTable);

        addBtn.setText("Add Invoice");

        deleteBtn.setText("delete Invoice");

        saveBtn.setText("save");

        cancelBtn.setText("cancel");

        fileMenu.setText("File");

        loadMenu.setText("load");
        fileMenu.add(loadMenu);

        saveMenu.setText("save files");
        fileMenu.add(saveMenu);

        jMenuBar1.add(fileMenu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(77, 77, 77)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(Total))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(invDate))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel2)
                                                .addGap(40, 40, 40))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(jLabel1)
                                                .addGap(109, 109, 109)))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(number)
                                            .addComponent(custName)))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(addBtn)
                        .addGap(85, 85, 85)
                        .addComponent(deleteBtn)
                        .addGap(139, 139, 139)
                        .addComponent(saveBtn)
                        .addGap(77, 77, 77)
                        .addComponent(cancelBtn)))
                .addContainerGap(267, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(number)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(custName))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(invDate))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(Total))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addBtn)
                    .addComponent(deleteBtn)
                    .addComponent(saveBtn)
                    .addComponent(cancelBtn))
                .addGap(197, 197, 197))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Frame frame = new Frame();

                frame.setVisible(true);
                frame.listener.loadData("InvoiceHeader.csv", "InvoiceLine.csv");

            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable InvoiceTable;
    private javax.swing.JLabel Total;
    private javax.swing.JButton addBtn;
    private javax.swing.JButton cancelBtn;
    private javax.swing.JLabel custName;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JTable detailsTable;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JLabel invDate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JMenuItem loadMenu;
    private javax.swing.JLabel number;
    private javax.swing.JButton saveBtn;
    private javax.swing.JMenuItem saveMenu;
    // End of variables declaration//GEN-END:variables

    private InvoiceListener listener = new InvoiceListener(this);
    public static SimpleDateFormat simpleDate = new SimpleDateFormat("dd-MM-yyyy");
    private ListingTableModel listTableModel;
    private DetailsTableModel detailsTableModel;

    private ArrayList<InvoiceList> invoices;
    private ArrayList<InvoiceLine> invoiceLines;

    public ArrayList<InvoiceLine> getInvoiceLines() {
        return invoiceLines;
    }

    public ArrayList<InvoiceList> getInvoices() {

        if (invoices == null) {
            invoices = new ArrayList<>();
        }
        return invoices;
    }

    public void setInvoices(ArrayList<InvoiceList> invoices) {
        this.invoices = invoices;
    }

    public ListingTableModel getListingTable() {

        return listTableModel;
    }

    public DetailsTableModel getDetailTable() {

        return detailsTableModel;

    }

    public void setListingTableModel(ListingTableModel listTableModel) {

        this.listTableModel = listTableModel;

    }

    public JTable getInvoicesTable() {

        return InvoiceTable;

    }

    public JTable getDetailsTable() {

        return detailsTable;
    }

    public JLabel getTotal() {
        return Total;
    }

    public JLabel getCustName() {
        return custName;
    }

    public JLabel getInvDate() {
        return invDate;
    }

    public JLabel getNumber() {
        return number;
    }

    public InvoiceListener getListener() {

        return listener;
    }

}