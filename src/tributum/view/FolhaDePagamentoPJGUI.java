/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tributum.view;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import tributum.controller.PessoaJuridicaController;
import tributum.model.EmptyException;
import tributum.model.Imposto;
import tributum.model.PessoaJuridica;

/**
 *
 * @author lucas
 */
public class FolhaDePagamentoPJGUI extends javax.swing.JFrame {
    
    private short horasTrabalhadas = -1;
    private PessoaJuridica pj = PessoaJuridicaController.getPessoaJuridica();
    private Imposto[] impostos;
    
    /**
     * Creates new form FolhaDePagamentoPJGUI
     */
    public FolhaDePagamentoPJGUI() {
        initComponents();
    }
    
    private void exibeDados() {
        valorBrutoJLabel.setText(Double.toString(pj.getSalarioBruto()));
        irrfJLabel.setText(Double.toString(impostos[0].getValorImposto()));
        pisCofCsllJLabel.setText(Double.toString(impostos[1].getValorImposto()));
        issJLabel.setText(Double.toString(impostos[2].getValorImposto()));
        salarioLiqJLabel.setText(Double.toString(pj.getSalarioLiquido()));
    }
    
    /* Metodo que ira verificar se campo horas trabalhadas eh vazio */
    private boolean isEmptyWorkedHours() {
        if(this.horastrabTextField.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Campo horas trabalhadas não pode ser vazio", 
                    "Campo horas trabalhadas vazio", JOptionPane.WARNING_MESSAGE);
            return true;
        }
        return false;
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
        calcularTextField = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        valorBrutoJLabel = new javax.swing.JLabel();
        irrfJLabel = new javax.swing.JLabel();
        pisCofCsllJLabel = new javax.swing.JLabel();
        issJLabel = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        salarioLiqJLabel = new javax.swing.JLabel();
        horastrabTextField = new javax.swing.JFormattedTextField();
        voltarButton = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        calcularImpostosButton = new javax.swing.JButton();
        totalImpostosJLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Folha de pagamento PJ");

        jLabel1.setText("Horas trabalhadas:");

        calcularTextField.setText("Calcular");
        calcularTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calcularTextFieldActionPerformed(evt);
            }
        });

        jLabel2.setText("Valor bruto:");

        jLabel3.setText("IRRF:");

        jLabel4.setText("PIS/COFINS/CSLL:");

        jLabel5.setText("ISS:");

        jLabel6.setText("Salário Líquido:");

        horastrabTextField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));

        voltarButton.setText("Voltar");
        voltarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                voltarButtonActionPerformed(evt);
            }
        });

        jLabel7.setText("Total de impostos:");

        calcularImpostosButton.setText("Calcular impostos");
        calcularImpostosButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calcularImpostosButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(valorBrutoJLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(irrfJLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pisCofCsllJLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(issJLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(salarioLiqJLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(totalImpostosJLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(voltarButton)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(calcularTextField))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(calcularImpostosButton)
                                    .addComponent(horastrabTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(267, 267, 267))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(horastrabTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(calcularTextField)
                    .addComponent(calcularImpostosButton))
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(valorBrutoJLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(irrfJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(pisCofCsllJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(issJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6))
                    .addComponent(salarioLiqJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(totalImpostosJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(voltarButton)
                .addGap(50, 50, 50))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void calcularTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calcularTextFieldActionPerformed
        
        if(!isEmptyWorkedHours()) {
            horasTrabalhadas = Short.parseShort(this.horastrabTextField.getText());

            try {
                //Chama o método que ira calcular os impostos
                impostos = PessoaJuridicaController.calcularImpostos(horasTrabalhadas);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), 
                        e.getMessage(), JOptionPane.WARNING_MESSAGE);
                return;
            }

            // Exibe os valores na tela
            exibeDados();
        }      
    }//GEN-LAST:event_calcularTextFieldActionPerformed

    private void voltarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_voltarButtonActionPerformed
        dispose();
    }//GEN-LAST:event_voltarButtonActionPerformed

    private void calcularImpostosButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calcularImpostosButtonActionPerformed
        
        if(horasTrabalhadas != -1)
            try {
                totalImpostosJLabel.setText(Double.toString(pj.valorTotalImposto(impostos))); 
            } catch (NullPointerException | EmptyException ex) {
                Logger.getLogger(FolhaDePagamentoPJGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        else
            JOptionPane.showMessageDialog(null, "Calcule o salário primeiro", 
                        "Calcule o salário primeiro", JOptionPane.WARNING_MESSAGE);
            
    }//GEN-LAST:event_calcularImpostosButtonActionPerformed

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
            java.util.logging.Logger.getLogger(FolhaDePagamentoPJGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FolhaDePagamentoPJGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FolhaDePagamentoPJGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FolhaDePagamentoPJGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FolhaDePagamentoPJGUI folhaDePagamentoPjGui =
                        new FolhaDePagamentoPJGUI();
                folhaDePagamentoPjGui.setTitle("Folha de pagamento PJ");
                folhaDePagamentoPjGui.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton calcularImpostosButton;
    private javax.swing.JButton calcularTextField;
    private javax.swing.JFormattedTextField horastrabTextField;
    private javax.swing.JLabel irrfJLabel;
    private javax.swing.JLabel issJLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel pisCofCsllJLabel;
    private javax.swing.JLabel salarioLiqJLabel;
    private javax.swing.JLabel totalImpostosJLabel;
    private javax.swing.JLabel valorBrutoJLabel;
    private javax.swing.JButton voltarButton;
    // End of variables declaration//GEN-END:variables
}
