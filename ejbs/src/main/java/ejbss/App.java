package ejbss;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Response;

@ApplicationPath("/api")
public class App extends Application {
	public static void main(String[] args) {
		
		CalcService calcService = new CalcService();

	    Calculation calculation = new Calculation();
	    calculation.setNumber1(10);
	    calculation.setNumber2(5);
	    calculation.setOperation("/");

	    Response response = calcService.performCalculation(calculation);

	    // Handle response
	    if (response.getStatus() == Response.Status.OK.getStatusCode()) {
	      CalResult result = (CalResult) response.getEntity();
	      System.out.println("Result: " + result.getResult());
	    } else {
	      System.out.println("Error: " + response.getStatusInfo().getReasonPhrase());
	    }
	  }
}