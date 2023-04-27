package myapp2;

import java.text.NumberFormat;

public class MyUtil {
	public static String getMoneyForm(String str){
		String won;
		double bb = Double.parseDouble(str);
		won = NumberFormat.getIntegerInstance().format(bb);
		return won;
	}
}
