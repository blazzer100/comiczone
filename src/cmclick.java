import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class cmclick implements  ActionListener {

public String targ;	
	
  cmclick(String item){
	  
	  targ= item;
	  
	  
  }	
	
	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		System.out.println(targ);
		Desktop des= Desktop.getDesktop();
				try {
					des.browse(new URI(targ));
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (URISyntaxException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
		
		
		}
		
	

	
		
	
	
	
	
	
}
