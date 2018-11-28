package poseidon.Tests;

import java.io.IOException;

import java.util.ArrayList;

import org.jdom2.JDOMException;
import org.json.JSONException;
import org.testng.annotations.Test;

import com.bay.BaseClass.*;

import oms.Poseidon.Webservices.OMSCalls;

public class Baytest {

	@Test
	public void TestsForBay() throws JSONException, IOException, JDOMException, InterruptedException {

		SingleLineAllTenderTypes SQATT = new SingleLineAllTenderTypes();

		String OrderID = SQATT.SinglineVisa();

		// String OrderID="073069815";

		String Banner = "BAY";

		OMSCalls Calls = new OMSCalls();
		Calls.AgentRuns(OrderID, Banner);
		Calls.ShipmentCall(OrderID, Banner);
	
	}

}
