import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
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
import javax.swing.JTextField;

public class search {
	
	ArrayList plist= new ArrayList();
	public ArrayList linkList = new ArrayList();
	public JFrame frm= new JFrame();
	static int cbut=2;	
	

	public void getpic(String page){
		
		try {
			URL ultar= new URL(page);
			URLConnection conn= ultar.openConnection();
			conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10.4; en-US; rv:1.9.2.2) Gecko/20100316 Firefox/3.6.2");
			Pattern pat= Pattern.compile("http://www.comicscodes.com/wp-content/uploads/.*jpg\"");
			Scanner scn= new Scanner(conn.getInputStream());
			while(scn.hasNext()){
				Matcher mat=pat.matcher(scn.nextLine());
				
				if(mat.find()){
					String pics=mat.group();
					String pics2=pics.replace("\"","");
					//System.out.println(mat.group());
					plist.add(pics2);
					
					
				     }
				
				
				
				
			        }
			
			
			
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


			
			
			
		                    }	
			
       			
		public void wfile() throws Exception{
			int x=0;
			
		//String spce="C:\\Users\\Lenovo t510\\Desktop\\code";
			
		System.out.println("the size was"+plist.size());	
			
		String spce="C:\\code\\sresults";	
		File path2= new File(spce);
		 if (path2.exists()){
			 
			 path2.delete();
			 System.out.println("its deleted");
		            }
		 
		 else{
			 System.out.println("patch created");
		path2.mkdirs();}



			
		while (x<plist.size()){
			

				URL ull= new URL(plist.get(x).toString());
				
				//System.out.println(ull);
				
				x+=1;
				
		String countp=path2+"\\pic"+x+".jpg";		
				
		URLConnection conn= ull.openConnection();
		conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10.4; en-US; rv:1.9.2.2) Gecko/20100316 Firefox/3.6.2");


		InputStream in = new BufferedInputStream(conn.getInputStream());
		OutputStream out = new BufferedOutputStream(new FileOutputStream(countp));

		for ( int i; (i = in.read()) != -1; ) {
		    out.write(i);
		}
		in.close();
		out.close();
				
				
			     }
			
			
			
			
			
			
		              }	
			
		    

		public void showme(){

		JPanel pan= new JPanel();
		pan.setBackground(Color.BLACK);
		
		System.out.println(plist.size());
		cbut+=1;

		int x=1;
		int y=0;
		while (x<plist.size()){
			x+=1;
			
			//ImageIcon imc= new ImageIcon("C:\\Users\\Lenovo t510\\Desktop\\code\\pic"+x+".jpg");
			
			ImageIcon imc= new ImageIcon("C:\\code\\sresults\\pic"+x+".jpg");
			
			Image  inz= imc.getImage();
			Image newi=inz.getScaledInstance(210,210,Image.SCALE_REPLICATE);
			
			
			JButton but= new JButton(new ImageIcon(newi));
			
			
			but.setBackground(Color.BLACK);
			
			but.addActionListener(new cmclick(linkList.get(y).toString()));
			
			y+=1;
			pan.add(but);
			
		         }

		JButton nexbut= new JButton("next but");


		JTextField enbox= new JTextField(20);


		JButton  sbutton= new JButton("search");
		pan.add(enbox);

		pan.add(sbutton);


		sbutton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			String word=	enbox.getText();
			String sword="http://www.comicscodes.com/?s="+word+"&searchsubmit=";
			Comics  cm= new Comics();
			cm.getpic(sword);
			cm.glink(sword);
			try {
				cm.wfile();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			cm.showme();
			
			
			}
		});



		try {
			nexbut.addActionListener(new nexbutthing(cbut));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}



		pan.add(nexbut);
		frm.setBackground(Color.BLACK);
		frm.add(pan);
		frm.setSize(1500,800);
		frm.setVisible(true);
		frm.setDefaultCloseOperation(frm.EXIT_ON_CLOSE);
			
			
			
		    }




		public void glink(String target){
			
		try {
			URL tar =new URL(target);
			URLConnection conn= tar.openConnection();
			conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10.4; en-US; rv:1.9.2.2) Gecko/20100316 Firefox/3.6.2");
			
			Scanner scn= new Scanner(conn.getInputStream());
			Pattern pat= Pattern.compile("<a href=.*Continue reading");
			while (scn.hasNext()){
				Matcher mat=pat.matcher(scn.nextLine());
				
				if (mat.find()){
					
					String v1=mat.group();
					String v2= v1.replace("\" class=\"more-link\">Continue reading","");
					String v3= v2.replace("<a href=\"","");
					linkList.add(v3);
					
					//System.out.println(v3);
				          }
				
				
				
			              }
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
			
		                 }




		public void close(){
			frm.setVisible(false);
			frm.dispose();
			
			
		}
	
	
	


           }
