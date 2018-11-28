package poseidon.Tests;

import java.io.IOException;

import org.jdom2.JDOMException;
import org.json.JSONException;
import org.testng.annotations.Test;

import com.BaseClass.SingleLineAllTenderTypes;
import oms.Poseidon.Webservices.OMSCalls;

public class SaksTest {
	
	@Test
	public void runner() throws JSONException, IOException, JDOMException, InterruptedException
	
	{
		TestsForSAKS();
		
	}

	@Test(enabled = true)
	public void TestsForSAKS() throws JSONException, IOException, JDOMException, InterruptedException {

		//SingleLineAllTenderTypes SQATT = new SingleLineAllTenderTypes();

		//String OrderID = SQATT.SingleLineAmex();

	String OrderID="073069815";

		String Banner = "SAKS";
		OMSCalls Calls = new OMSCalls();
		Calls.AgentRuns(OrderID, Banner);
		Calls.ShipmentCall(OrderID, Banner);

	}
}