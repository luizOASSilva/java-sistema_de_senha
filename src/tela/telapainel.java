/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tela;

import classe.link_bd;
import static classe.link_bd.statement;
import java.sql.ResultSet;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;

/**
 *
 * @author Aluno
 */
public class telapainel extends javax.swing.JFrame {

   
    link_bd objbd = new link_bd();
    int seq = 0, minSenha = 0;
    String Texto ="", Tipo ="";
    DefaultListModel l= new DefaultListModel();  
    
    
    public telapainel() {
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

        jPanel1 = new javax.swing.JPanel();
        lbmen = new javax.swing.JLabel();
        lbmensagem = new javax.swing.JLabel();
        painelmonitor = new javax.swing.JLabel();
        lbmouse = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lm_senha = new javax.swing.JList<>();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(690, 400));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbmen.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        lbmen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(lbmen, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 170, 270, 120));

        lbmensagem.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jPanel1.add(lbmensagem, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 170, 110, 100));
        jPanel1.add(painelmonitor, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 110, 300, 220));

        lbmouse.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbmouseMouseClicked(evt);
            }
        });
        jPanel1.add(lbmouse, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 250, 90, 80));

        lm_senha.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jScrollPane1.setViewportView(lm_senha);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 120, 110, 200));

        jLabel2.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel2.setText("Painel de senhas");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 20, -1, -1));

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 50, 470, 20));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 690, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void pegasenha() {
      try{
            minSenha=0;
            String sql="Select min(tb01_num) FROM tb01_senha"
                    + " Where id01_tipo='"+Tipo+"' and id01_status='N';";
            
            
            objbd.conectar();
            ResultSet resultSet = statement.executeQuery(sql);
            if(resultSet.next()){
                minSenha = resultSet.getInt(1);
            }
            
            objbd.desconectar();
            statement.close();
            }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        ImageIcon iconnormal = new ImageIcon("src/img/monitor.jpg");
        painelmonitor.setIcon(iconnormal);
        iconnormal.setImage(iconnormal.getImage().getScaledInstance(painelmonitor.getWidth(), painelmonitor.getHeight(),1));
        
        ImageIcon iconemouse = new ImageIcon("src/img/mousetela.jpg");
        lbmouse.setIcon(iconemouse);
        iconemouse.setImage(iconemouse.getImage().getScaledInstance(lbmouse.getWidth(), lbmouse.getHeight(),1));
    }//GEN-LAST:event_formWindowOpened

    private void lbmouseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbmouseMouseClicked
        Tipo="P";
        pegasenha();
        if(minSenha==0){
            Tipo="N";
            pegasenha();
            if(minSenha==0){
                lbmen.setFont(new java.awt.Font("Tahoma", 1, 18));
                lbmen.setText("Nenhuma senha disponível");
                return;
            }
        }

        lbmen.setText(String.valueOf(minSenha));
        Texto= Tipo+ lbmen.getText();
        l.addElement("       " + Texto);
        lm_senha.setModel(l);
        novaSenha();                
    }//GEN-LAST:event_lbmouseMouseClicked

     private void novaSenha() {
     try{
            
            String sql="UPDATE (tb01_senha) SET id01_status='S' "
                    + "Where id01_tipo='"+Tipo+"' AND tb01_num="+minSenha+";";
            
            lbmen.setText(Tipo+minSenha);
            objbd.conectar();
            objbd.runSQL(sql);
            objbd.desconectar();
            statement.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
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
            java.util.logging.Logger.getLogger(telapainel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(telapainel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(telapainel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(telapainel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new telapainel().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lbmen;
    private javax.swing.JLabel lbmensagem;
    private javax.swing.JLabel lbmouse;
    private javax.swing.JList<String> lm_senha;
    private javax.swing.JLabel painelmonitor;
    // End of variables declaration//GEN-END:variables
}
