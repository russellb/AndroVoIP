// NAME
//      $RCSfile: AboutDialog.java,v $
// DESCRIPTION
//      [given below in javadoc format]
// DELTA
//      $Revision: 1.3 $
// CREATED
//      $Date: 2006/02/10 15:42:47 $
// COPYRIGHT
//      Mexuar Technologies Ltd
// TO DO
//
package com.mexuar.corraleta.ui;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
 *
 *
 * @author <a href="mailto:ray@westhawk.co.uk">Ray Tran</a>
 * @version $Revision: 1.3 $ $Date: 2006/02/10 15:42:47 $
 */
public class AboutDialog extends JDialog {
  private static final String     version_id =
        "@(#)$Id: AboutDialog.java,v 1.3 2006/02/10 15:42:47 uid6102 Exp $ Copyright Mexuar Technologies Ltd";
  JPanel panel1 = new JPanel();
  BorderLayout borderLayout1 = new BorderLayout();
  JButton jButton1 = new JButton();
  JPanel jPanel1 = new JPanel();
  JLabel jLabel1 = new JLabel();
  JLabel jLabel2 = new JLabel();

  public AboutDialog(Frame frame, String title, boolean modal) {
    super(frame, title, modal);
    try {
      jbInit();
      pack();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  public AboutDialog() {
    this(null, "", false);
  }

  private void jbInit() throws Exception {
    panel1.setLayout(borderLayout1);
    jButton1.setText("Ok");
    jButton1.addActionListener(new AboutDialog_jButton1_actionAdapter(this));
    jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
    jLabel1.setText("BeanCan");
    jLabel2.setText("<html><body><h1>BeanCan</h1><p>A pure java soft phone Copyright <a href=\"www.westhawk.co.uk\">Westhawk " +
    "Ltd 2005</a></p><p>"+this.getTitle()+"</p></body></html>");
    getContentPane().add(panel1);
    panel1.add(jPanel1, BorderLayout.SOUTH);
    jPanel1.add(jButton1, null);
    panel1.add(jLabel1, BorderLayout.NORTH);
    panel1.add(jLabel2, BorderLayout.CENTER);
  }

  void jButton1_actionPerformed(ActionEvent e) {
    this.hide();
  }
}

class AboutDialog_jButton1_actionAdapter implements java.awt.event.ActionListener {
  AboutDialog adaptee;

  AboutDialog_jButton1_actionAdapter(AboutDialog adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.jButton1_actionPerformed(e);
  }
}
