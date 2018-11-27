package oms.Poseidon.Webservices;

import java.io.ByteArrayInputStream;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import org.apache.commons.codec.binary.Base64;
import org.apache.http.HttpResponse;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.json.JSONException;

import com.hbc.lt.websom.SFSFulfilment;

public class OMSCalls {
	
	public static String ShipNode = null;

	private int getOrderDetails(String orderIDValue, String banner)
			throws IOException, JSONException, JDOMException, InterruptedException {

		String requestTemplate = getRequestProperty("getOrderDetails");

		String requestTemplate1 = requestTemplate.replaceAll("&orderIDValue", orderIDValue);
		String requestTemplate2 = requestTemplate1.replaceAll("&banner", banner);
		String environment = getProperty("Env");
		String url = getProperty("WSGOD" + environment);

		String finalrequest = requestTemplate2;

		String name = getProperty("UserCredentials");
		String password = getProperty("PWDCredentials");
		String authString = name + ":" + password;
		byte[] authEncBytes = Base64.encodeBase64(authString.getBytes());
		String authStringEnc = new String(authEncBytes);

		CloseableHttpClient client = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost(url);

		StringEntity entity = new StringEntity(finalrequest);
		httpPost.setEntity(entity);
		httpPost.setHeader("Accept", "application/xml");
		httpPost.setHeader("Content-type", "application/xml");
		httpPost.setHeader("Authorization", "Basic  " + authStringEnc);

		ResponseHandler<String> handler = new BasicResponseHandler();

		// String body = client.execute(httpPost, handler);
		HttpResponse httpResponse = null;
		httpResponse = client.execute(httpPost);
		httpResponse.getEntity().getContent().close();
		int ResponseCode = httpResponse.getStatusLine().getStatusCode();

		System.out.println(ResponseCode);
		int counter = 0;

		while (ResponseCode != 200) {
			Thread.sleep(15000);
			ResponseCode = httpResponse.getStatusLine().getStatusCode();
			;
			counter++;
			System.out.println(counter);
			if (counter == 18) {
				System.out.println(counter);
				break;

			}

		}
		return ResponseCode;

	}

	private ArrayList<String> getOrderStatus(String orderIDValue, String banner)
			throws IOException, JSONException, JDOMException, InterruptedException {

		String requestTemplate = getRequestProperty("getOrderDetails");

		String requestTemplate1 = requestTemplate.replaceAll("&orderIDValue", orderIDValue);
		String requestTemplate2 = requestTemplate1.replaceAll("&banner", banner);
		String environment = getProperty("Env");
		String url = getProperty("WSGOD" + environment);

		String finalrequest = requestTemplate2;

		String name = getProperty("UserCredentials");
		String password = getProperty("PWDCredentials");
		String authString = name + ":" + password;
		byte[] authEncBytes = Base64.encodeBase64(authString.getBytes());
		String authStringEnc = new String(authEncBytes);

		CloseableHttpClient client = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost(url);

		StringEntity entity = new StringEntity(finalrequest);
		httpPost.setEntity(entity);
		httpPost.setHeader("Accept", "application/xml");
		httpPost.setHeader("Content-type", "application/xml");
		httpPost.setHeader("Authorization", "Basic  " + authStringEnc);

		ResponseHandler<String> handler = new BasicResponseHandler();

		String body = client.execute(httpPost, handler);

		HashMap<String, String> AttributeValue = XMLConvertor(body);

		ArrayList<String> Status = new ArrayList<String>();

		Status.add(AttributeValue.get("MaxLineStatusDesc").toString());
		Status.add(AttributeValue.get("OrderedQty").toString());

		Status.add(AttributeValue.get("OrderReleaseKey").toString());
		Status.add(AttributeValue.get("ItemID").toString());

		Status.add(AttributeValue.get("ShipNode").toString());

		return Status;

	}

	String getProperty(String Prop) throws IOException {

		Properties prop = new Properties();
		InputStream input = null;

		input = this.getClass().getResourceAsStream("Config.properties");
		
		// FileInputStream("//Users//h895458//Desktop//Workspace//DataIssue//src//dataCheck//Keys.properties");
		prop.load(input);
		String Value = prop.getProperty(Prop);
		return Value;

	}

	String getRequestProperty(String Prop) throws IOException {

		Properties prop = new Properties();
		InputStream input = null;

		input = this.getClass().getResourceAsStream("Requests.properties");
		// System.out.println(path + "\n");
		// input = this.getClass().getResourceAsStream(path);
		// input = new FileInputStream(path);
		// FileInputStream("//Users//h895458//Desktop//Workspace//DataIssue//src//dataCheck//Keys.properties");
		prop.load(input);
		String Value = prop.getProperty(Prop);
		return Value;

	}

	private void resolveBuyersRemorse(String orderID, String banner) throws IOException {
		String requestTemplate = getRequestProperty("BuyersRemorse");
		String environment = getProperty("Env");
		String url = getProperty("WSBRH" + environment);

		String finalrequest = requestTemplate;

		String name = getProperty("UserCredentials");
		String password = getProperty("PWDCredentials");
		String authString = name + ":" + password;
		byte[] authEncBytes = Base64.encodeBase64(authString.getBytes());
		String authStringEnc = new String(authEncBytes);

		CloseableHttpClient client = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost(url);

		StringEntity entity = new StringEntity(finalrequest);
		httpPost.setEntity(entity);
		httpPost.setHeader("Accept", "application/xml");
		httpPost.setHeader("Content-type", "application/xml");
		httpPost.setHeader("Authorization", "Basic  " + authStringEnc);

		ResponseHandler<String> handler = new BasicResponseHandler();

		// String body = client.execute(httpPost, handler);
		HttpResponse httpResponse = null;
		httpResponse = client.execute(httpPost);
		httpResponse.getEntity().getContent().close();
		int ResponseCode = httpResponse.getStatusLine().getStatusCode();

		// TODO Auto-generated method stub

	}

	private void runScheduleAgent(String orderID, String banner) throws IOException {
		String requestTemplate = getRequestProperty("ScheduleAgent");
		String environment = getProperty("Env");
		String url = getProperty("WSSchedule" + environment);
		String finalrequest = requestTemplate;

		String name = getProperty("UserCredentials");
		String password = getProperty("PWDCredentials");
		String authString = name + ":" + password;
		byte[] authEncBytes = Base64.encodeBase64(authString.getBytes());
		String authStringEnc = new String(authEncBytes);

		CloseableHttpClient client = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost(url);

		StringEntity entity = new StringEntity(finalrequest);
		httpPost.setEntity(entity);
		httpPost.setHeader("Accept", "application/xml");
		httpPost.setHeader("Content-type", "application/xml");
		httpPost.setHeader("Authorization", "Basic  " + authStringEnc);

		ResponseHandler<String> handler = new BasicResponseHandler();

		// String body = client.execute(httpPost, handler);
		HttpResponse httpResponse = null;
		httpResponse = client.execute(httpPost);
		int ResponseCode = httpResponse.getStatusLine().getStatusCode();
		// TODO Auto-generated method stub

	}

	private void runReleaseAgent(String orderID, String banner) throws IOException {
		String requestTemplate = getRequestProperty("ReleaseAgent");
		String environment = getProperty("Env");
		String url = getProperty("WSRelease" + environment);
		String finalrequest = requestTemplate;

		String name = getProperty("UserCredentials");
		String password = getProperty("PWDCredentials");
		String authString = name + ":" + password;
		byte[] authEncBytes = Base64.encodeBase64(authString.getBytes());
		String authStringEnc = new String(authEncBytes);

		CloseableHttpClient client = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost(url);

		StringEntity entity = new StringEntity(finalrequest);
		httpPost.setEntity(entity);
		httpPost.setHeader("Accept", "application/xml");
		httpPost.setHeader("Content-type", "application/xml");
		httpPost.setHeader("Authorization", "Basic  " + authStringEnc);

		ResponseHandler<String> handler = new BasicResponseHandler();

		// String body = client.execute(httpPost, handler);
		HttpResponse httpResponse = null;
		httpResponse = client.execute(httpPost);
		// httpResponse.getEntity().getContent().close();
		int ResponseCode = httpResponse.getStatusLine().getStatusCode();
		// TODO Auto-generated method stub

	}

	private HashMap<String, String> XMLConvertor(String body) throws JSONException, IOException, JDOMException {

		SAXBuilder saxBuilder = new SAXBuilder();

		InputStream stream = new ByteArrayInputStream(body.getBytes("UTF-8"));

		System.out.println(body);
		Document document = saxBuilder.build(stream);
		Element classElement = document.getRootElement();
		List<Element> Values = classElement.getChildren();
		List<Attribute> ValueNodes = classElement.getAttributes();

		HashMap<String, String> AttributesValues = new HashMap<String, String>();

		// Multimap<String, String> AttributesValues = ArrayListMultimap.create();

		// ListMultimap<String, String> AttributesValues = Multimaps
		// .newListMultimap(new TreeMap<String, Collection<String>>(), new
		// Supplier<List<String>>() {
		// public List<String> get() {
		// return Lists.newArrayList();
		// }
		// });

		for (int temp = 0; temp < Values.size(); temp++) {
			Element Value = Values.get(temp);
			System.out.println("\nCurrent Element :" + Value.getName());

			List<Attribute> Attributes = Value.getAttributes();
			List<Element> Child = Value.getChildren();
			if (!Child.isEmpty()) {

				for (Element f : Child) {

					List<Attribute> ChildAttributes = f.getAttributes();
					List<Element> GrandChild = f.getChildren();

					if (!GrandChild.isEmpty()) {

						for (Element S : GrandChild)

						{
							List<Attribute> GrandChildAttributes = S.getAttributes();

							for (Attribute A : GrandChildAttributes) {

								if (A.getValue().isEmpty()) {
									continue;
								}
								AttributesValues.put(A.getName(), A.getValue());

							}

						}
					}

					for (Attribute g : ChildAttributes) {

						if (g.getValue().isEmpty()) {
							continue;
						}
						AttributesValues.put(g.getName(), g.getValue());

					}

				}

			}

			for (Attribute e : Attributes) {

				if (e.getValue().isEmpty()) {
					continue;
				}
				AttributesValues.put(e.getName(), e.getValue());

			}

		}

		return AttributesValues;

	}

	private int ShipSLDCOrder(String orderID, String banner, String Qty, String ReleaseKey, String ItemID,
			String ShipNode) throws IOException {

		String requestTemplate = getRequestProperty("ShippingAgent");
		String requestTemplate1 = requestTemplate.replaceAll("&orderIDValue", orderID);
		String requestTemplate2 = requestTemplate1.replaceAll("&banner", banner);
		String requestTemplate3 = requestTemplate2.replaceAll("&OrderedQty", Qty);
		String requestTemplate4 = requestTemplate3.replaceAll("&ReleaseKey", ReleaseKey);
		String requestTemplate5 = requestTemplate4.replaceAll("&ItemID", ItemID);
		String requestTemplate6 = requestTemplate5.replaceAll("&ShipNode", ShipNode);

		String environment = getProperty("Env");
		String url = getProperty("WSShip" + environment);

		String finalrequest = requestTemplate6;

		String name = getProperty("UserCredentials");
		String password = getProperty("PWDCredentials");
		String authString = name + ":" + password;
		byte[] authEncBytes = Base64.encodeBase64(authString.getBytes());
		String authStringEnc = new String(authEncBytes);

		CloseableHttpClient client = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost(url);

		StringEntity entity = new StringEntity(finalrequest);
		httpPost.setEntity(entity);
		httpPost.setHeader("Accept", "application/xml");
		httpPost.setHeader("Content-type", "application/xml");
		httpPost.setHeader("Authorization", "Basic  " + authStringEnc);

		ResponseHandler<String> handler = new BasicResponseHandler();

		// String body = client.execute(httpPost, handler);
		HttpResponse httpResponse = null;
		httpResponse = client.execute(httpPost);
		int ResponseCode = httpResponse.getStatusLine().getStatusCode();
		return ResponseCode;

		// TODO Auto-generated method stub

	}

	public void AgentRuns(String OrderId, String Banner)
			throws IOException, InterruptedException, JSONException, JDOMException {

		if (Banner.equalsIgnoreCase("Saks") || Banner.equalsIgnoreCase("OFF5")) {
			Thread.sleep(900 * 1000);
		} else

		{

			Thread.sleep(300 * 1000);
		}

		int ResponseCode = getOrderDetails(OrderId, Banner);
		System.out.println(ResponseCode);

		if (ResponseCode == 200) {
			resolveBuyersRemorse(OrderId, Banner);
			Thread.sleep(5000);
			runScheduleAgent(OrderId, Banner);
			Thread.sleep(5000);
			runReleaseAgent(OrderId, Banner);
		}

		else {
			System.out.println("Order has not reached OMS");
		}
		Thread.sleep(3000);

	}

	public void ShipmentCall(String OrderID, String Banner)
			throws IOException, JSONException, JDOMException, InterruptedException {
		ArrayList<String> Status = getOrderStatus(OrderID, Banner);

		SFSFulfilment SFS = new SFSFulfilment();

		switch (Status.get(0)) {

		case "Released":
			int ResponseCodeforShip = ShipSLDCOrder(OrderID, Banner, Status.get(1), Status.get(2), Status.get(3),
					Status.get(4));
			if (ResponseCodeforShip == 200) {
				System.out.println("Shipment Confirmed");
			} else {
				System.out.println("Error in Shipment");
			}
			break;

		case "Ready for Backroom Pick":

			ShipNode = Status.get(4);
			SFS.openWebsomURL(OrderID, Status.get(4));
			SFS.searchShipemnt(OrderID, Status.get(4));
			SFS.packOrder(OrderID, Status.get(4));
			SFS.carrierShipment(OrderID, Status.get(4));
			break;

		}

		ArrayList<String> FinalStatus = getOrderStatus(OrderID, Banner);

		System.out.println("Final Status of the Order is " + FinalStatus.get(0));

	}

}
