package OMS.POSEIDON;

import java.io.IOException;

import org.jdom2.JDOMException;
import org.json.JSONException;
import org.testng.annotations.Test;

import oms.Poseidon.Webservices.OMSCalls;

public class Tests {

	@Test
	public void LTWEBCreateOrder() throws JSONException, IOException, JDOMException, InterruptedException {
		
		String OrderID="100147885";
		String Banner = "LT";
		OMSCalls Calls = new OMSCalls();
		int ResponseCode=Calls.getOrderDetails(OrderID, Banner);
		System.out.println(ResponseCode);
		Calls.resolveBuyersRemorse(OrderID, Banner);
		Thread.sleep(5000);
		Calls.runScheduleAgent(OrderID, Banner);
		Thread.sleep(5000);
		Calls.runReleaseAgent(OrderID, Banner);
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
}
