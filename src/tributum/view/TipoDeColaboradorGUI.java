/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tributum.view;

import javax.swing.ButtonGroup;

/**
 *
 * @author lucas
 */
public class TipoDeColaboradorGUI extends javax.swing.JFrame {
    public static int botaoAtivo;
    /**
     * Creates new form TipoDeColaboradorGUI
     */
    public TipoDeColaboradorGUI() {
        initComponents();
        groupButton();
    }
    
    /*
     * Esse metodo e usado para que nao ocorra a situacao de dois
     * radio buttons serem selecionados ao mesmo tempo
     */
    private void groupButton() {
        ButtonGroup bg1 = new ButtonGroup();
        
        bg1.add(celetistaRadioButton);
        bg1.add(pjRadioButton); 
        bg1.add(produtoRadioButton);    
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
        celetistaRadioButton = new javax.swing.JRadioButton();
        pjRadioButton = new javax.swing.JRadioButton();
        confirmButton = new javax.swing.JButton();
        produtoRadioButton = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setText("Tipo de Colaborador");

        celetistaRadioButton.setSelected(true);
        celetistaRadioButton.setText("Celetista");
        celetistaRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                celetistaRadioButtonActionPerformed(evt);
            }
        });

        pjRadioButton.setText("Pessoa Jurídica");
        pjRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pjRadioButtonActionPerformed(evt);
            }
        });

        confirmButton.setText("Confirmar");
        confirmButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmButtonActionPerformed(evt);
            }
        });

        produtoRadioButton.setText("Cadastro de Produtos");
        produtoRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                produtoRadioButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(produtoRadioButton)
                    .addComponent(confirmButton)
                    .addComponent(celetistaRadioButton)
                    .addComponent(pjRadioButton)
                    .addComponent(jLabel1))
                .addGap(208, 208, 208))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(jLabel1)
                .addGap(30, 30, 30)
                .addComponent(celetistaRadioButton)
                .addGap(18, 18, 18)
                .addComponent(pjRadioButton)
                .addGap(18, 18, 18)
                .addComponent(produtoRadioButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addComponent(confirmButton)
                .addGap(34, 34, 34))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void celetistaRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_celetistaRadioButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_celetistaRadioButtonActionPerformed

    private void pjRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pjRadioButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pjRadioButtonActionPerformed

    private void confirmButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmButtonActionPerformed
        
        DadosCeletistaGUI dadosCeletistaGui = new DadosCeletistaGUI();
        DadosPessoaJuridicaGUI dadosPjGui = new DadosPessoaJuridicaGUI();
        DadosProdutoGUI dadosProdutosGui = new DadosProdutoGUI();

        if(celetistaRadioButton.isSelected()) {
            botaoAtivo = 1;
            dadosCeletistaGui.setVisible(true);
        }
        else {
            if(pjRadioButton.isSelected()){
                botaoAtivo = 2;
                dadosPjGui.setVisible(true);
            }
            else{
                botaoAtivo = 3;
                dadosProdutosGui.setVisible(true);
            }
        }
        
        setVisible(true);
        //dispose();        
    }//GEN-LAST:event_confirmButtonActionPerformed

    private void produtoRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_produtoRadioButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_produtoRadioButtonActionPerformed

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
            java.util.logging.Logger.getLogger(TipoDeColaboradorGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TipoDeColaboradorGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TipoDeColaboradorGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TipoDeColaboradorGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TipoDeColaboradorGUI tipoDeColaboradorGui = 
                        new TipoDeColaboradorGUI();
                tipoDeColaboradorGui.setTitle("Tipo de colaborador");
                tipoDeColaboradorGui.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton celetistaRadioButton;
    private javax.swing.JButton confirmButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JRadioButton pjRadioButton;
    public javax.swing.JRadioButton produtoRadioButton;
    // End of variables declaration//GEN-END:variables
}
