import java.util.*;

/**
 * TMTimer - simple speech timer for Toastmasters or similar
 * events where speeches are time-limited.
 * @author  Ian F. Darwin, ian@darwinsys.com
 * @version $Id$
 */
public class TMTimer extends javax.swing.JFrame {

  /** Initializes the Form */
  public TMTimer() {
    initComponents ();
    pack ();
  }

  /** This method is called from within the constructor to
   * initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is
   * always regenerated by the FormEditor.
   */
  private void initComponents () {//GEN-BEGIN:initComponents
    addWindowListener (new java.awt.event.WindowAdapter () {
        public void windowClosing (java.awt.event.WindowEvent evt) {
          exitForm (evt);
        }
      }
    );
    getContentPane ().setLayout (new java.awt.BorderLayout ());

    jMenuBar1 = new javax.swing.JMenuBar ();
      fileMenu = new javax.swing.JMenu ();
      fileMenu.setText ("File");
        exitMenuItem = new javax.swing.JMenuItem ();
        exitMenuItem.setText ("Exit");
        exitMenuItem.addActionListener (new java.awt.event.ActionListener () {
            public void actionPerformed (java.awt.event.ActionEvent evt) {
              jMenuItem1ActionPerformed (evt);
            }
          }
        );
        fileMenu.add(exitMenuItem);

      jMenuBar1.add(fileMenu);


    setJMenuBar(jMenuBar1);
    buttonsPanel = new javax.swing.JPanel ();
    buttonsPanel.setLayout (new java.awt.FlowLayout ());

      startButton = new javax.swing.JButton ();
      startButton.setText ("Start");
      startButton.addActionListener (new java.awt.event.ActionListener () {
          public void actionPerformed (java.awt.event.ActionEvent evt) {
            jButton1ActionPerformed (evt);
          }
        }
      );
      buttonsPanel.add (startButton);

      stopButton = new javax.swing.JButton ();
      stopButton.setText ("Stop");
      buttonsPanel.add (stopButton);

      resetButton = new javax.swing.JButton ();
      resetButton.setText ("Reset");
      resetButton.addActionListener (new java.awt.event.ActionListener () {
          public void actionPerformed (java.awt.event.ActionEvent evt) {
            resetButtonActionPerformed (evt);
          }
        }
      );
      buttonsPanel.add (resetButton);

    getContentPane ().add (buttonsPanel, "South");

    timesPanel = new javax.swing.JPanel ();
    timesPanel.setLayout (new java.awt.BorderLayout ());

      presetsPanel = new javax.swing.JPanel ();
      presetsPanel.setLayout (new java.awt.FlowLayout ());

        presetsLabel = new javax.swing.JLabel ();
        presetsLabel.setText ("Presets:");
        presetsPanel.add (presetsLabel);

        presetsList = new javax.swing.JList ();
        presetsList.setMinimumSize (new java.awt.Dimension(100, 100));
        presetsPanel.add (presetsList);

      timesPanel.add (presetsPanel, "West");

      fieldsPanel = new javax.swing.JPanel ();
      fieldsPanel.setLayout (new java.awt.GridLayout (3, 2));

        greenLabel = new javax.swing.JLabel ();
        greenLabel.setBackground (java.awt.Color.green);
        greenLabel.setText ("Green");
        greenLabel.setHorizontalAlignment (javax.swing.SwingConstants.RIGHT);
        fieldsPanel.add (greenLabel);

        greenTF = new javax.swing.JTextField ();
        greenTF.setText ("0:00");
        fieldsPanel.add (greenTF);

        yellowLabel = new javax.swing.JLabel ();
        yellowLabel.setBackground (java.awt.Color.yellow);
        yellowLabel.setText ("Yellow");
        fieldsPanel.add (yellowLabel);

        yellowTF = new javax.swing.JTextField ();
        yellowTF.setText ("0:00");
        fieldsPanel.add (yellowTF);

        redLabel = new javax.swing.JLabel ();
        redLabel.setBackground (java.awt.Color.red);
        redLabel.setText ("Red");
        fieldsPanel.add (redLabel);

        redTF = new javax.swing.JTextField ();
        redTF.setText ("0:00");
        fieldsPanel.add (redTF);

      timesPanel.add (fieldsPanel, "Center");

      runningTimesPanel = new javax.swing.JPanel ();
      runningTimesPanel.setLayout (new javax.swing.BoxLayout (runningTimesPanel, 1));

        curTime = new javax.swing.JLabel ();
        curTime.setHorizontalTextPosition (javax.swing.SwingConstants.CENTER);
        curTime.setText ("0:00");
        curTime.setHorizontalAlignment (javax.swing.SwingConstants.CENTER);
        curTime.setFont (new java.awt.Font ("Dialog", 3, 36));
        runningTimesPanel.add (curTime);

        maxTime = new javax.swing.JLabel ();
        maxTime.setHorizontalTextPosition (javax.swing.SwingConstants.CENTER);
        maxTime.setText ("0:00");
        maxTime.setHorizontalAlignment (javax.swing.SwingConstants.CENTER);
        maxTime.setFont (new java.awt.Font ("Dialog", 3, 36));
        runningTimesPanel.add (maxTime);

      timesPanel.add (runningTimesPanel, "East");

    getContentPane ().add (timesPanel, "North");

    bigFlag = new javax.swing.JLabel ();
    bigFlag.setPreferredSize (new java.awt.Dimension(400, 300));
    bigFlag.setHorizontalAlignment (javax.swing.SwingConstants.CENTER);
    getContentPane ().add (bigFlag, "Center");

  }//GEN-END:initComponents

  private void resetButtonActionPerformed (java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetButtonActionPerformed
    // Add your handling code here:
    maxTime.setText(redTF.getText());
    bigFlag.setBackground(getBackground());
  }//GEN-LAST:event_resetButtonActionPerformed

  private void jButton1ActionPerformed (java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    // Add your handling code here:
  }//GEN-LAST:event_jButton1ActionPerformed

  private void jMenuItem1ActionPerformed (java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
    // Add your handling code here:
    System.exit(0);
  }//GEN-LAST:event_jMenuItem1ActionPerformed

  /** Exit the Application */
  private void exitForm(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_exitForm
    System.exit(0);
  }//GEN-LAST:event_exitForm


// Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JPanel buttonsPanel;
  private javax.swing.JButton startButton;
  private javax.swing.JButton stopButton;
  private javax.swing.JButton resetButton;
  private javax.swing.JMenuBar jMenuBar1;
  private javax.swing.JMenu fileMenu;
  private javax.swing.JMenuItem exitMenuItem;
  private javax.swing.JPanel timesPanel;
  private javax.swing.JPanel presetsPanel;
  private javax.swing.JLabel presetsLabel;
  private javax.swing.JList presetsList;
  private javax.swing.JPanel fieldsPanel;
  private javax.swing.JLabel greenLabel;
  private javax.swing.JTextField greenTF;
  private javax.swing.JLabel yellowLabel;
  private javax.swing.JTextField yellowTF;
  private javax.swing.JLabel redLabel;
  private javax.swing.JTextField redTF;
  private javax.swing.JPanel runningTimesPanel;
  private javax.swing.JLabel curTime;
  private javax.swing.JLabel maxTime;
  private javax.swing.JLabel bigFlag;
// End of variables declaration//GEN-END:variables

  protected void populateList(Properties p) {
    String[] labels = new String[p.size()];
    Enumeration e = p.keys();
    int i = 0;
    while (e.hasMoreElements())
      labels[i++] = (String)e.nextElement();
    presetsList.setListData(labels);
  }

  public static void main(java.lang.String[] args) {
  Properties p = new Properties();
  TMTimerUtil.getProperties(p, "TMTimer");
  TMTimerUtil.parseProps(p);
    TMTimer t = new TMTimer();
  t.populateList(p);
  t.setVisible(true);
  }
}
