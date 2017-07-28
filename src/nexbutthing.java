import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class nexbutthing implements ActionListener {
static int xt;
	
nexbutthing(int x) throws Exception{
	xt=x;
		
	System.out.println(xt);
        }

@Override
public void actionPerformed(ActionEvent e) {
	
	
	Comics  cm= new Comics();
	cm.frm.dispose();
	
	System.out.println("it exists");
	
	
	cm.getpic("http://www.comicscodes.com/page/"+xt);
	cm.glink("http://www.comicscodes.com/page/"+xt);
	
	
	try {
		cm.wfile();
	} catch (Exception e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	cm.showme();
	// TODO Auto-generated method stub
	
}	
	

	
}
