import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {
	
	public static void main(String a[]){
		try{
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		Date retDate = sdf.parse("05/09/2017");
		SimpleDateFormat sdf1 = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		Date arrivalDate = sdf.parse("05/05/2017 16:30:16");
		System.out.println(retDate.after(arrivalDate));
		}catch(Exception e){
			System.out.println(e);
		}
	}

}
