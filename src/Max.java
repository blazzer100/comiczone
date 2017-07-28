 import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Max {

	
	
	public static void main(String[] args) throws Exception {
		
/*to do
 * button hot hookup yet
 * 
 * button for next page not tyet created 
 * 
 */
		JFrame mframe= new JFrame();
		JButton butz= new JButton();
		JButton pdfbutton = new JButton();
   JPanel panz= new JPanel();
  
   ImageIcon imz= new ImageIcon(Max.class.getResource("pdfgiant.jpg"));
   Image imz2= imz.getImage();
   Image im3= imz2.getScaledInstance(227,140,java.awt.Image.SCALE_SMOOTH);
   
   
   
   butz.setIcon(new ImageIcon( Max.class.getResource("ccode.png")));
   
   pdfbutton.setIcon(new ImageIcon(im3));
   pdfbutton.setBackground(Color.BLACK);
   butz.setBackground(Color.BLACK);
   panz.setBackground(Color.black);
   panz.add(butz);
   panz.add(pdfbutton);
   
   
   butz.addActionListener(new ActionListener() {
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Decider did= new Decider();
		try {
			did.getcom();
			mframe.dispose();
			
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
}  );
   
   
   
   
   pdfbutton.addActionListener( new ActionListener() {
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		pgfgiant  pdf = new pgfgiant();
		try {
			pdf.getmagpic("http://pdf-giant.com/english/");
			pdf.showit();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
	}
});
   
   
   
   mframe.add(panz);
   mframe.setSize(400,400);
   mframe.setVisible(true);
   
	
		
		
		
		
		
              }
}