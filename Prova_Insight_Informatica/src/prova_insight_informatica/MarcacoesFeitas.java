package prova_insight_informatica;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class MarcacoesFeitas extends javax.swing.JFrame {

   
    public MarcacoesFeitas() {
        initComponents();
        Connect();
        LoadMarcacoes();
        LoadHoraTrabalho();
        Fetch();
        Fetch2();
    }
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    
    
    public void Connect(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(MarcacoesFeitas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void LoadMarcacoes(){
        try {
            pst = con.prepareStatement("SELECT id FROM marcacoesfeitas");
            rs = pst.executeQuery();
            cmboxMarcacoes.removeAllItems();
            
            while(rs.next()){
                cmboxMarcacoes.addItem(rs.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(MarcacoesFeitas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     public void LoadHoraTrabalho(){
        try {
            pst = (com.mysql.jdbc.PreparedStatement) con.prepareStatement("SELECT id FROM horariotrabalho");
            rs = pst.executeQuery();
            cmboxHorario.removeAllItems();
            
            while(rs.next()){
                cmboxHorario.addItem(rs.getString(1));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(HorarioDeTrabalho.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void Fetch(){
        
        try {
            pst = con.prepareStatement("SELECT * FROM marcacoesfeitas");
            rs = pst.executeQuery();
            
            ResultSetMetaData rss = rs.getMetaData();
           int q = rss.getColumnCount();
            
            DefaultTableModel df = (DefaultTableModel) TableMarcacoes.getModel();
            df.setRowCount(0);
            
            while(rs.next()){
                Vector v = new Vector();
                for(int i=0;i<=q;i++){
                    v.add(rs.getString("id"));
                    v.add(rs.getString("entrada"));
                    v.add(rs.getString("saida"));
                }
                df.addRow(v);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(MarcacoesFeitas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
      public void Fetch2(){
        
        try {
            pst = con.prepareStatement("SELECT * FROM horaextra");
            rs = pst.executeQuery();
            
            ResultSetMetaData rss = rs.getMetaData();
           int q = rss.getColumnCount();
            
            DefaultTableModel df = (DefaultTableModel) TableHora.getModel();
            df.setRowCount(0);
            
            while(rs.next()){
                Vector v = new Vector();
                for(int i=0;i<=q;i++){
                    v.add(rs.getString("id"));
                    v.add(rs.getString("entrada"));
                    v.add(rs.getString("saida"));
                }
                df.addRow(v);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(MarcacoesFeitas.class.getName()).log(Level.SEVERE, null, ex);
        }
      
    }
    

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        TableHora = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableMarcacoes = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        txtSaida = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtEntrada = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cmboxMarcacoes = new javax.swing.JComboBox<String>();
        cmboxHorario = new javax.swing.JComboBox<String>();
        btnSub = new javax.swing.JButton();
        btnSubAll = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        TableHora.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "Entrada", "Saída"
            }
        ));
        jScrollPane2.setViewportView(TableHora);

        TableMarcacoes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "Entrada", "Saída"
            }
        ));
        jScrollPane1.setViewportView(TableMarcacoes);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("MarcacoesFeitas"));

        btnAdd.setText("Adicionar");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnEdit.setText("Editar");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnClear.setText("Limpar");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Entrada:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Saida:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtEntrada)
                    .addComponent(txtSaida, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnEdit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtSaida, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("HoraExtra"));

        jLabel1.setText("HorarioDeTrabalho");

        jLabel4.setText("MarcacoesFeitas");

        cmboxMarcacoes.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cmboxHorario.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnSub.setText("SubstracaoEntreHorarios");
        btnSub.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubActionPerformed(evt);
            }
        });

        btnSubAll.setText("SubstracaoEntreHorariosALL");
        btnSubAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubAllActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(5, 5, 5)
                        .addComponent(cmboxHorario, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(19, 19, 19)
                        .addComponent(cmboxMarcacoes, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSubAll, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSub, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmboxMarcacoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSub)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cmboxHorario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnSubAll))
                    .addComponent(jLabel1))
                .addContainerGap(82, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
         txtEntrada.setText("");
         txtSaida.setText("");
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        String entrada = txtEntrada.getText();
        String saida = txtSaida.getText();
        if(entrada.isEmpty() && saida.isEmpty()){
            JOptionPane.showMessageDialog(null, "Algum Campo Está Vazio Preecha pra Continua o Inserção", "", JOptionPane.WARNING_MESSAGE);
        }else{
            try {
                pst = (com.mysql.jdbc.PreparedStatement) con.prepareStatement("INSERT INTO marcacoesfeitas(entrada,saida) VALUES(?,?)");
                pst.setString(1, entrada);
                pst.setString(2, saida);
                
                int d = pst.executeUpdate();

                if(d==1){
                    JOptionPane.showMessageDialog(null," Marcacão Foi Adicionado com Sucesso!!","",JOptionPane.INFORMATION_MESSAGE);
                    txtEntrada.setText("");
                    txtSaida.setText("");
                    Fetch();
                    LoadMarcacoes();

                }else{
                    JOptionPane.showMessageDialog(null,"ERROR, Marcacão não foi Adicionado!!", "", JOptionPane.ERROR_MESSAGE);
                }

            } catch (SQLException ex) {
                Logger.getLogger(HorarioDeTrabalho.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        String entrada = txtEntrada.getText();
        String saida = txtSaida.getText();
        String id = cmboxMarcacoes.getSelectedItem().toString();
        
        if(entrada.isEmpty() && saida.isEmpty()){
            JOptionPane.showMessageDialog(null, "Algum Campo Está Vazio Preecha pra Continua o Inserção", "", JOptionPane.WARNING_MESSAGE);
        }else{
            try {
                pst = (com.mysql.jdbc.PreparedStatement) con.prepareStatement("UPDATE marcacoesfeitas SET entrada = ?,saida = ? WHERE id = ?");
                pst.setString(1, entrada);
                pst.setString(2, saida);
                pst.setString(3, id);
                
                int d = pst.executeUpdate();

                if(d==1){
                    JOptionPane.showMessageDialog(null," Marcacão Foi Atualizado com Sucesso!!","",JOptionPane.INFORMATION_MESSAGE);
                    txtEntrada.setText("");
                    txtSaida.setText("");
                    Fetch();
                    LoadMarcacoes();

                }else{
                    JOptionPane.showMessageDialog(null,"ERROR, Marcacão não foi Atualizado!!", "", JOptionPane.ERROR_MESSAGE);
                }

            } catch (SQLException ex) {
                Logger.getLogger(HorarioDeTrabalho.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
          try {
            String id = cmboxMarcacoes.getSelectedItem().toString();
 
            pst = (com.mysql.jdbc.PreparedStatement) con.prepareStatement("DELETE FROM  marcacoesfeitas WHERE id=?");
            pst.setString(1,id);
            
            int a = pst.executeUpdate();
            
            if(a==1){
                JOptionPane.showMessageDialog(null,"Marcações Foi Deletado com Sucesso!!","",JOptionPane.INFORMATION_MESSAGE);
                txtEntrada.setText("");
                txtSaida.setText("");
                Fetch();
                LoadMarcacoes();
            }else{
                JOptionPane.showMessageDialog(null,"ERROR, Marcações não foi Deletado!!","",JOptionPane.ERROR_MESSAGE);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(HorarioDeTrabalho.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnSubActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubActionPerformed
        String id1 = cmboxMarcacoes.getSelectedItem().toString();
        String id2 = cmboxHorario.getSelectedItem().toString();
        
        try {
        PreparedStatement  a1 =  pst = (com.mysql.jdbc.PreparedStatement) 
                con.prepareStatement("SELECT (SELECT entrada FROM marcacoesfeitas  WHERE id = ?) - (SELECT entrada FROM horariotrabalho  WHERE id = ?)");
                a1.setString(1, id1);
                a1.setString(2, id2);
                ResultSet r1 = rs = a1.executeQuery();
                
                PreparedStatement  a2 =  pst = (com.mysql.jdbc.PreparedStatement) 
                con.prepareStatement("SELECT (SELECT saida FROM marcacoesfeitas WHERE id = ?) - (SELECT saida FROM horariotrabalho WHERE id = ?)");
                a2.setString(1, id1);
                a2.setString(2, id2);
                ResultSet r2 = rs = a2.executeQuery();
                
                Date entrada = r1.getDate(2);
                Date saida = r2.getDate(3);
                try {
                pst = (com.mysql.jdbc.PreparedStatement) con.prepareStatement("INSERT INTO atraso(entrada,saida) VALUES(?,?)");
                pst.setDate(1, entrada);
                pst.setDate(2, saida);
                
                int d = pst.executeUpdate();

                if(d==1){
                    JOptionPane.showMessageDialog(null," Subtração de marcacoesfeitas e horaiotrabalho foi realizada Sucesso!!","",JOptionPane.INFORMATION_MESSAGE);
                    Fetch2();
                    

                }else{
                    JOptionPane.showMessageDialog(null,"ERROR, Na Subtração de marcacoesfeitas e horaiotrabalho!!", "", JOptionPane.ERROR_MESSAGE);
                }

            } catch (SQLException ex) {
                Logger.getLogger(HorarioDeTrabalho.class.getName()).log(Level.SEVERE, null, ex);
            }
                
               
                  
                
        } catch (SQLException ex) {
            Logger.getLogger(MarcacoesFeitas.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            
            
        
        
    }//GEN-LAST:event_btnSubActionPerformed

    private void btnSubAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubAllActionPerformed
        String id1 = cmboxMarcacoes.getSelectedItem().toString();
        String id2 = cmboxHorario.getSelectedItem().toString();
        
        try {
        PreparedStatement  a1 =  pst = (com.mysql.jdbc.PreparedStatement) 
                con.prepareStatement("SELECT (SELECT SUM(entrada) FROM marcacoesfeitas  WHERE id = ?) - (SELECT SUM(entrada) FROM horariotrabalho  WHERE id = ?)");
                a1.setString(1, id1);
                a1.setString(2, id2);
                ResultSet r1 = rs = a1.executeQuery();
                
                PreparedStatement  a2 =  pst = (com.mysql.jdbc.PreparedStatement) 
                con.prepareStatement("SELECT (SELECT SUM(saida) FROM marcacoesfeitas WHERE id = ?) - (SELECT SUM(saida) FROM horariotrabalho WHERE id = ?)");
                a2.setString(1, id1);
                a2.setString(2, id2);
                ResultSet r2 = rs = a2.executeQuery();
                
                Date entrada = r1.getDate(2);
                Date saida = r2.getDate(3);
                try {
                pst = (com.mysql.jdbc.PreparedStatement) con.prepareStatement("INSERT INTO atraso(entrada,saida) VALUES(?,?)");
                pst.setDate(1, entrada);
                pst.setDate(2, saida);
                
                int d = pst.executeUpdate();

                if(d==1){
                    JOptionPane.showMessageDialog(null," Subtração de marcacoesfeitas e horaiotrabalho foi realizada Sucesso!!","",JOptionPane.INFORMATION_MESSAGE);
                    Fetch2();
                    

                }else{
                    JOptionPane.showMessageDialog(null,"ERROR, Na Subtração de marcacoesfeitas e horaiotrabalho!!", "", JOptionPane.ERROR_MESSAGE);
                }

            } catch (SQLException ex) {
                Logger.getLogger(HorarioDeTrabalho.class.getName()).log(Level.SEVERE, null, ex);
            }
                
               
                  
                
        } catch (SQLException ex) {
            Logger.getLogger(MarcacoesFeitas.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }//GEN-LAST:event_btnSubAllActionPerformed

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
            java.util.logging.Logger.getLogger(MarcacoesFeitas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MarcacoesFeitas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MarcacoesFeitas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MarcacoesFeitas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MarcacoesFeitas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TableHora;
    private javax.swing.JTable TableMarcacoes;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnSub;
    private javax.swing.JButton btnSubAll;
    private javax.swing.JComboBox<String> cmboxHorario;
    private javax.swing.JComboBox<String> cmboxMarcacoes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField txtEntrada;
    private javax.swing.JTextField txtSaida;
    // End of variables declaration//GEN-END:variables
}
