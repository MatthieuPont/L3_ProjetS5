package GUI;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.util.Calendar;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.NavigableSet;
import java.util.TreeMap;
import java.util.TreeSet;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

import Client.*;

public class TicketInfosGUI extends JFrame {
	private Map<EnumStatusUtilisateur, NavigableSet<Utilisateur>> listeStatus;
    private Ticket ticket;
    private Groupe groupe;
    private ProgrammePrincipal programme;
    private int x, y;
    /**
     * Creates new form OptionPane2
     */
    public TicketInfosGUI(ProgrammePrincipal programme, Ticket ticket, int x, int y ) {
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
            java.util.logging.Logger.getLogger(StatusMessageGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StatusMessageGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StatusMessageGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StatusMessageGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
    	
        this.listeStatus=ticket.getListeStatus();
        this.ticket=ticket;
        this.groupe=ticket.getGroupe();
        this.x=x;
        this.y=y;
        this.programme=programme;
        initComponents2();
        this.setVisible(true);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="InitComponents">                          
    private void initComponents2() {
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        
        int taille=0;
        for(NavigableSet<Utilisateur> N : listeStatus.values()){
            taille += N.size();
        }
        Object[][] table=new Object[taille][2];  
        int cpt=0;
    
            NavigableSet<Utilisateur> utilisateurs = listeStatus.get(EnumStatusUtilisateur.ENLIGNE);
            for(Utilisateur u : utilisateurs){
                table[cpt][0] = u.getPrenom()+" "+u.getNom();
                table[cpt][1] = "En ligne";          
                cpt++;
            }
            utilisateurs = listeStatus.get(EnumStatusUtilisateur.HORSLIGNE);
            for(Utilisateur u : utilisateurs){
                if(u!=programme.getUtilisateurPrincipal()){
                    table[cpt][0] = u.getPrenom()+" "+u.getNom();
                    table[cpt][1] = "Hors ligne";     
                    cpt++;
                }
            }
      
        
        String [] s = {"Utilisateurs", "Status"};
        jTable1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            table, s){
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        
        JPanel jpanel=new JPanel();
        jTable1.setDefaultRenderer(Object.class, new jTableRender());;
        jScrollPane1.setViewportView(jTable1);
        jpanel.add(jScrollPane1, java.awt.BorderLayout.CENTER);
        jpanel.setBackground(Color.WHITE);
        jScrollPane1.getViewport().setBackground(Color.WHITE);
        //this.setUndecorated(true);
        jTable1.setEnabled(false);
        jPanel1.setBackground(Color.WHITE);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().add(jpanel, java.awt.BorderLayout.PAGE_END);

        jpanel.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText(ticket.getTitre());

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Utilisateur createur=ticket.getCreateur();
        jLabel2.setText("Expediteur : "+createur.getPrenom()+" "+createur.getNom());

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Calendar calendar=ticket.getDate();   
        String tampon = calendar.get(Calendar.DAY_OF_MONTH)+"/"+(calendar.get(Calendar.MONTH)+1)+"/"+calendar.get(Calendar.YEAR);
        tampon += " "+calendar.get(Calendar.HOUR_OF_DAY)+":"+calendar.get(Calendar.MINUTE);
        jLabel3.setText("Cr�ation : "+tampon);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Groupe : "+groupe.getNom());

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );


        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);
        
        jTable1.setSize(new Dimension(600,230));
        jScrollPane1.setSize(new Dimension(600,230));
        this.setLocationRelativeTo(null);
        this.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                    thisFocusLost(evt);
                }
            });
        
        pack();
    }// </editor-fold>    
    
    private void thisFocusLost(java.awt.event.FocusEvent evt) {                                  
        dispose();
    } 

public class jTableRender extends DefaultTableCellRenderer {
 
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component component = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        /**
         * Fixer la couleur de fond de la premi�re colonne en blanc
         */
 
        /**
         * Colorier les cellules en orange si le montant est n�gatif
         */
        Object o = table.getValueAt(row, 1);
        if (o != null && component instanceof JLabel) {
            JLabel label = (JLabel) component;
            if (label.getText().contains("En ligne")) {
                 Color clr = new Color(51, 204, 0);
                component.setBackground(clr);
            }
            if (label.getText().contains("Hors ligne")) {
                 Color clr = new Color(255, 215, 198);
                component.setBackground(clr);
            }
        }
        if(column==0){
            Color clr = new Color(255, 255, 255);
            component.setBackground(clr);
        }
        return component;
    }
}

    // Variables declaration - do not modify                     
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration                   
}
