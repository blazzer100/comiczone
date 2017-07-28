import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class pgfgiant {
	
ArrayList magpic= new ArrayList();	


public void getmagpic(String target) throws Exception{
	
URL ull= new URL(target);
URLConnection conz=  ull.openConnection();
conz.setRequestProperty("User-Agent", "Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10.4; en-US; rv:1.9.2.2) Gecko/20100316 Firefox/3.6.2");
Scanner scnn= new Scanner(conz.getInputStream());
Pattern patz= Pattern.compile("src=\"http://pdf-giant.com/uploads/posts/.*jpg");
while(scnn.hasNext()){
	Matcher mat= patz.matcher(scnn.nextLine());
	
	if (mat.find()){
		
		String goo= mat.group();
		String goo1= goo.replace("src=\"", "");
		System.out.println(goo1);
		magpic.add(goo1);
		
	            }
	
	
	
	
	
	
               }



	
	
	
	
                    }	
	
public void getpicz(){
	
	
	
	
	File path=new File("C:\\Users\\cow");
	//InputStream in = new InputStream("");
	//OutputStream outs= new OutputStream(path);
   

              }


public void showit() throws Exception{
	JFrame frm= new JFrame();
	JPanel panz= new JPanel();
	int number= magpic.size();
	System.out.println(number);
	while (number>0){
		number--;
		JButton buts= new JButton ();
		buts.setIcon(new ImageIcon(new URL(magpic.get(3).toString())));
		
		panz.add(buts);
		
	           }
	frm.add(panz);
	frm.setSize(1200, 600);
	frm.setVisible(true);
	
	
                 }



          }
