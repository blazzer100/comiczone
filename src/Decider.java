
public class Decider {

	protected void getcom() throws Exception{
	
	Comics  cm= new Comics();
 
	String place= System.getProperty("os.name");
	String win1="Windows 8.1";
	String win2="Windows 7";
	String win3 ="Windows 10";
	
	if (place.equals(win1)||place.equals(win2)||place.equals(win3)){
	
	cm.getpic("http://www.comicscodes.com/page/2");
	cm.glink("http://www.comicscodes.com/page/2");
	cm.wfile();
	cm.showme();
	} else{System.out.println("i dont know");}
		

	}




               }
