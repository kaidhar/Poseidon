package OMS.POSEIDON;

import java.io.IOException;

import org.jdom2.JDOMException;
import org.json.JSONException;
import org.testng.annotations.Test;

import com.BaseClass.MultiqunatityAllTenderTypes;
import com.BaseClass.SingleLineAllTenderTypes;

import oms.Poseidon.Webservices.OMSCalls;

public class Tests {

	@Test
	public void TestsForSAKS() throws JSONException, IOException, JDOMException, InterruptedException {

		SingleLineAllTenderTypes SQATT = new SingleLineAllTenderTypes();
		//String OrderID = SQATT.SingleLineAmex();
		
		String OrderID="073069669";
		String Banner = "SAKS";
		OMSCalls Calls = new OMSCalls();
		int ResponseCode = Calls.getOrderDetails(OrderID, Banner);
		System.out.println(ResponseCode);
		Calls.resolveBuyersRemorse(OrderID, Banner);
		Thread.sleep(5000);
		Calls.runScheduleAgent(OrderID, Banner);
		Thread.sleep(5000);
		Calls.runReleaseAgent(OrderID, Banner);

	}

}
