import java.util.ArrayList;

public class TS1 {
public static void main(String args[]) {
		String s="1,2,3,4,-,*,+";
		System.out.println(cal(s.split(",")));
}
public static Double cal(String[] cals ) {
	ArrayList<Double> result=new ArrayList<>();
	for(String cal:cals) {
		switch(cal) {
		case "+":
		case "-":
		case "*":
		case "/":
			calres(result,cal);		
			break;
		default:
			result.add(Double.valueOf(cal));
		}
	}
	return result.get(0);
}
	private static void calres(ArrayList<Double> result,String dec) {
		Double b1=result.get(result.size()-2);
		Double b2=result.get(result.size()-1);
		Double b3 = null;
		switch(dec) {
		case "+":
			 b3=b1+b2;
			break;
		case "-":
			 b3=b1+b2;
			break;
		case "*":
			 b3=b1+b2;
			break;
		case "/":
			 b3=b1+b2;
			break;
		}
		result.remove(result.size()-1);
		result.remove(result.size()-1);
		result.add(b3);
	}
}
