package OMS.POSEIDON;

import java.io.IOException;

import java.util.ArrayList;

import org.jdom2.JDOMException;
import org.json.JSONException;
import org.testng.annotations.Test;

import com.BaseClass.MultiqunatityAllTenderTypes;
import com.BaseClass.SingleLineAllTenderTypes;

import oms.Poseidon.Webservices.OMSCalls;

public class Tests {

	@Test(enabled=true)
	public void TestsForSAKS() throws JSONException, IOException, JDOMException, InterruptedException {

		SingleLineAllTenderTypes SQATT = new SingleLineAllTenderTypes();

		String OrderID = SQATT.SingleLineAmex();

		// String OrderID="073069815";

		String Banner = "SAKS";

		Thread.sleep(900 * 1000);

		OMSCalls Calls = new OMSCalls();
		int ResponseCode = Calls.getOrderDetails(OrderID, Banner);
		System.out.println(ResponseCode);

		if (ResponseCode == 200) {
			Calls.resolveBuyersRemorse(OrderID, Banner);
			Thread.sleep(5000);
			Calls.runScheduleAgent(OrderID, Banner);
			Thread.sleep(5000);
			Calls.runReleaseAgent(OrderID, Banner);
		}

		else {
			System.out.println("Order has not reached OMS");
		}

		ArrayList<String> Status = Calls.getOrderStatus(OrderID, Banner);

		switch (Status.get(0)) {

		case "Released":
			int ResponseCodeforShip = Calls.ShipSLSQOrder(OrderID, Banner, Status.get(1), Status.get(2), Status.get(3),
					Status.get(4));
			if (ResponseCodeforShip == 200) {
				System.out.println("Shipment Confirmed");
			} else {
				System.out.println("Error in Shipment");
			}
			break;

		// case "Ready for Backroom Pick": Calls.callWebSOM();
		// break;

		}
	}
	

	@Test(enabled=true)
	public void TestsForSAKSMQ() throws JSONException, IOException, JDOMException, InterruptedException {

		MultiqunatityAllTenderTypes SQATT = new MultiqunatityAllTenderTypes();

			String OrderID = SQATT.MultiLineAmex();

			// String OrderID="073069815";

			String Banner = "SAKS";

			Thread.sleep(900 * 1000);

			OMSCalls Calls = new OMSCalls();
			int ResponseCode = Calls.getOrderDetails(OrderID, Banner);
			System.out.println(ResponseCode);

			if (ResponseCode == 200) {
				Calls.resolveBuyersRemorse(OrderID, Banner);
				Thread.sleep(5000);
				Calls.runScheduleAgent(OrderID, Banner);
				Thread.sleep(5000);
				Calls.runReleaseAgent(OrderID, Banner);
			}

			else {
				System.out.println("Order has not reached OMS");
			}

			ArrayList<String> Status = Calls.getOrderStatus(OrderID, Banner);

			switch (Status.get(0)) {

			case "Released":
				int ResponseCodeforShip = Calls.ShipSLSQOrder(OrderID, Banner, Status.get(1), Status.get(2), Status.get(3),
						Status.get(4));
				if (ResponseCodeforShip == 200) {
					System.out.println("Shipment Confirmed");
				} else {
					System.out.println("Error in Shipment");
				}
				break;

			// case "Ready for Backroom Pick": Calls.callWebSOM();
			// break;

			}


	}
	
	

}
