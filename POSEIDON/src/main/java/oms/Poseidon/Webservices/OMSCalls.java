package oms.Poseidon.Webservices;
import java.io.FileInputStream;

import java.io.ByteArrayInputStream;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import java.util.TreeMap;

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

import com.google.common.base.Supplier;
import com.google.common.collect.ListMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multimaps;

public class OMSCalls {

	public int getOrderDetails(String orderIDValue, String banner)
			throws IOException, JSONException, JDOMException, InterruptedException {

		String requestTemplate = getRequestProperty("getOrderDetails");

		String requestTemplate1 = requestTemplate.replaceAll("&orderIDValue", orderIDValue);
		String requestTemplate2 = requestTemplate1.replaceAll("&banner", banner);
		String environment = getProperty("Env");
		String url = getProperty("WS" + environment);

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

	public ArrayList<String> getOrderStatus(String orderIDValue, String banner)
			throws IOException, JSONException, JDOMException, InterruptedException {

		String requestTemplate = getRequestProperty("getOrderDetails");

		String requestTemplate1 = requestTemplate.replaceAll("&orderIDValue", orderIDValue);
		String requestTemplate2 = requestTemplate1.replaceAll("&banner", banner);
		String environment = getProperty("Env");
		String url = getProperty("WS" + environment);

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

		Status.add(AttributeValue.get("Status").toString());
		Status.add(AttributeValue.get("OrderedQty").toString());

		Status.add(AttributeValue.get("OrderReleaseKey").toString());

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

	public void resolveBuyersRemorse(String orderID, String banner) throws IOException {
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

	public void runScheduleAgent(String orderID, String banner) throws IOException {
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
		httpResponse.getEntity().getContent().close();
		int ResponseCode = httpResponse.getStatusLine().getStatusCode();
		// TODO Auto-generated method stub

	}

	public void runReleaseAgent(String orderID, String banner) throws IOException {
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
		httpResponse.getEntity().getContent().close();
		int ResponseCode = httpResponse.getStatusLine().getStatusCode();
		// TODO Auto-generated method stub

	}

	public HashMap<String, String> XMLConvertor(String body) throws JSONException, IOException, JDOMException {

		SAXBuilder saxBuilder = new SAXBuilder();

		InputStream stream = new ByteArrayInputStream(body.getBytes("UTF-8"));

		System.out.println(body);
		Document document = saxBuilder.build(stream);
		Element classElement = document.getRootElement();
		List<Element> Values = classElement.getChildren();
		List<Attribute> ValueNodes = classElement.getAttributes();

	 HashMap<String, String> AttributesValues = new HashMap<String, String>();

		// Multimap<String, String> AttributesValues = ArrayListMultimap.create();

//		ListMultimap<String, String> AttributesValues = Multimaps
//				.newListMultimap(new TreeMap<String, Collection<String>>(), new Supplier<List<String>>() {
//					public List<String> get() {
//						return Lists.newArrayList();
//					}
//				});

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

	public void ShipSLSQOrder(String orderID, String banner, String Qty, String ReleaseKey, String ItemID)
			throws IOException {

		String requestTemplate = getRequestProperty("ShippingAgent");
		String requestTemplate1 = requestTemplate.replaceAll("&orderIDValue", orderID);
		String requestTemplate2 = requestTemplate1.replaceAll("&banner", banner);
		String requestTemplate3 = requestTemplate2.replaceAll("&OrderedQty", Qty);
		String requestTemplate4 = requestTemplate3.replaceAll("&ReleaseKey", ReleaseKey);
		String requestTemplate5 = requestTemplate4.replaceAll("&ItemID", ItemID);

		String environment = getProperty("Env");
		String url = getProperty("WSShip" + environment);

		String finalrequest = requestTemplate5;

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

}
