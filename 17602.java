import javax.swing.JLabel;

/**
 *
 * @author k00118447
 */
public class two extends javax.swing.JFrame {

    /** Creates new form two */
    public two(String abc) {
        initComponents();
        jLabel2.setText(abc);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    private void initComponents() {
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        jLabel1.setText("two");
        jLabel2.setText("jLabel2");
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(48, 48, 48).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jLabel2).addComponent(jLabel1)).addContainerGap(318, Short.MAX_VALUE)));
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(jLabel1).addGap(49, 49, 49).addComponent(jLabel2).addContainerGap(212, Short.MAX_VALUE)));
        pack();
    }

    private javax.swing.JLabel jLabel1;

    private javax.swing.JLabel jLabel2;
}
