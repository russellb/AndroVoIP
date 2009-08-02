// NAME
//      $RCSfile: BeanCan.java,v $
// DESCRIPTION
//      [given below in javadoc format]
// DELTA
//      $Revision: 1.9 $
// CREATED
//      $Date: 2006/05/12 14:14:13 $
// COPYRIGHT
//      Mexuar Technologies Ltd
// TO DO
//
package com.mexuar.corraleta.ui;

import java.awt.*;
import javax.swing.*;
import com.mexuar.corraleta.protocol.Log;
import com.mexuar.corraleta.audio.javasound.AudioProperties;

/**
 * Swing phone implementation
 * @author <a href="mailto:thp@westhawk.co.uk">Tim Panton</a>
 * @version $Revision: 1.9 $ $Date: 2006/05/12 14:14:13 $
 */
public class BeanCan {
    private static final String     version_id =
        "@(#)$Id: BeanCan.java,v 1.9 2006/05/12 14:14:13 uid100 Exp $ Copyright Mexuar Technologies Ltd";

  boolean packFrame = false;

  //Construct the application
  public BeanCan(String uname,String pass, String host, int level) {
    BeanCanFrameManager frame = new BeanCanFrameManager(uname,pass,host,false,level);
    //Validate frames that have preset sizes
    //Pack frames that have useful preferred size info, e.g. from their layout
    if (packFrame) {
      frame.pack();
    }
    else {
      frame.validate();
    }
    //Center the window
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    Dimension frameSize = frame.getSize();
    if (frameSize.height > screenSize.height) {
      frameSize.height = screenSize.height;
    }
    if (frameSize.width > screenSize.width) {
      frameSize.width = screenSize.width;
    }
    frame.setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);
    frame.setVisible(true);
    frame.register();
  }

  //Main method
  public static void main(String[] argv) {
/*
          try {
      UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    }
    catch(Exception e) {
      e.printStackTrace();
    }
        }
*/
      if ((argv.length == 3) || (argv.length == 4)) {
      int level = Log.ERROR;
      if (argv.length == 4){
        try {
          level = Integer.parseInt(argv[3]);
        } catch (NumberFormatException nfe){
          level = Log.ALL;
        }
      }
      AudioProperties.loadFromFile("audio.properties");
      BeanCan bc = new BeanCan(argv[0], argv[1], argv[2],level);
    } else {
      System.err.println("usage: BeanCan username pass iaxhost [debuglevel]");
    }
  }
}
