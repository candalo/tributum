/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tributum.view;

import javax.swing.JOptionPane;
import tributum.controller.PessoaJuridicaController;
import tributum.model.PessoaJuridica;

/**
 *
 * @author lucas
 */
public class DadosPessoaJuridicaGUI extends javax.swing.JFrame {
    
    PessoaJuridica pessoa;
    /**
     * Creates new form DadosPessoaJuridicaGUI
     */
    public DadosPessoaJuridicaGUI() {
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        nomePjTextField = new javax.swing.JTextField();
        enderecoPjTextField = new javax.swing.JTextField();
        valorGHTextField = new javax.swing.JTextField();
        cadastrarButton = new javax.swing.JButton();
        telefonePjTextField = new javax.swing.JFormattedTextField();
        cnpjTextField = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Nome:");

        jLabel2.setText("Endereço:");

        jLabel3.setText("Telefone:");

        jLabel4.setText("CNPJ:");

        jLabel5.setText("Valor ganho/hora:");

        nomePjTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomePjTextFieldActionPerformed(evt);
            }
        });

        enderecoPjTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enderecoPjTextFieldActionPerformed(evt);
            }
        });

        valorGHTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                valorGHTextFieldActionPerformed(evt);
            }
        });

        cadastrarButton.setText("Cadastrar");
        cadastrarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastrarButtonActionPerformed(evt);
            }
        });

        try {
            telefonePjTextField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            cnpjTextField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.###.###/####-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cadastrarButton)
                        .addGap(0, 15, Short.MAX_VALUE))
                    .addComponent(nomePjTextField)
                    .addComponent(enderecoPjTextField)
                    .addComponent(valorGHTextField)
                    .addComponent(telefonePjTextField)
                    .addComponent(cnpjTextField))
                .addGap(75, 75, 75))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(nomePjTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(enderecoPjTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(telefonePjTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cnpjTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(valorGHTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addComponent(cadastrarButton)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    /* Metodos para validar os campos de texto que estao vazios*/
   
    /* Validacao do campo nome */
    private boolean isValidName() {
        if(this.nomePjTextField.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Campo nome não pode ser vazio", "Campo nome vazio",
                    JOptionPane.WARNING_MESSAGE);
            return false;
        }
        return true;
    }
    
    /* Validacao do campo endereco */
    private boolean isValidAddress() {
        if(this.enderecoPjTextField.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Campo endereço não pode ser vazio", 
                    "Campo endereço vazio", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        return true;
    }
    
    /* Validacao telefone */
    private boolean isValidValueGainedPerHour() {
        if(this.valorGHTextField.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Campo valor ganho/hora não pode ser vazio", 
                    "Campo valor ganho/hora vazio", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        return true;
    }
    
    private void nomePjTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomePjTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nomePjTextFieldActionPerformed

    private void enderecoPjTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enderecoPjTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_enderecoPjTextFieldActionPerformed

    private void valorGHTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_valorGHTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_valorGHTextFieldActionPerformed

    private void cadastrarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastrarButtonActionPerformed
        
        if(isValidName() && isValidAddress() && isValidValueGainedPerHour()) {
            PessoaJuridicaController.gravarPessoaJuridica(this, pessoa);

            // Vai para a proxima tela
            MenuGUI menuGui = new MenuGUI();
            menuGui.setVisible(true);

            // Fecha tela atual
            setVisible(false);
            dispose();
        }
    }//GEN-LAST:event_cadastrarButtonActionPerformed

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
            java.util.logging.Logger.getLogger(DadosPessoaJuridicaGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DadosPessoaJuridicaGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DadosPessoaJuridicaGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DadosPessoaJuridicaGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DadosPessoaJuridicaGUI dadosPJGui = new DadosPessoaJuridicaGUI();
                dadosPJGui.setTitle("Dados Pessoa Jurídica");
                dadosPJGui.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cadastrarButton;
    public javax.swing.JFormattedTextField cnpjTextField;
    public javax.swing.JTextField enderecoPjTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    public javax.swing.JTextField nomePjTextField;
    public javax.swing.JFormattedTextField telefonePjTextField;
    public javax.swing.JTextField valorGHTextField;
    // End of variables declaration//GEN-END:variables
}
