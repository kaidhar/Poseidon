package oms.Poseidon.Webservices;

import java.io.FileInputStream;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.commons.codec.binary.Base64;
import org.apache.http.HttpResponse;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.jdom2.JDOMException;
import org.json.JSONException;


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
			Thread.sleep(10000);
			ResponseCode = httpResponse.getStatusLine().getStatusCode();;
			counter++;
			System.out.println(counter);
			if(counter==18)
			{
				System.out.println(counter);
				break;
				
			}

			
		}
		return ResponseCode;

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
		// String path = ClassLoader.getSystemClassLoader().getResource(".").getPath() +
		// "Requests.properties";
		String path = "/Users/h895458/git/Poseidon/POSEIDON/src/main/java/oms/Poseidon/Webservices/Requests.properties";
		System.out.println(path + "\n");
		// input = this.getClass().getResourceAsStream(path);
		input = new FileInputStream(path);
		// FileInputStream("//Users//h895458//Desktop//Workspace//DataIssue//src//dataCheck//Keys.properties");
		prop.load(input);
		String Value = prop.getProperty(Prop);
		return Value;

	}

	public void resolveBuyersRemorse(String orderID, String banner) throws IOException {
		String requestTemplate = getRequestProperty("BuyersRemorse");
		String environment = getProperty("Env");
		String url = getProperty("WS" + environment);
		
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
		String url = getProperty("WS" + environment);
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
		String url = getProperty("WS" + environment);
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

}
