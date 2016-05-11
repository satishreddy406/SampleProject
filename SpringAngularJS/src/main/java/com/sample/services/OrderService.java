package com.sample.services;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

@Service("OrderService")
public class OrderService {
	private static final Logger log = Logger.getLogger("OrderService.class");

	public String saveOrder(String json) {

		String url = "https://integration-usealliancecotrial54990.integration.us2.oraclecloud.com/integration/flowapi/rest/INSERT/v01/pushdata";
		URL oracle;
		String result = "";
		OutputStreamWriter printout;
		try {
			oracle = new URL(url);
			HttpURLConnection con = (HttpURLConnection) oracle.openConnection();
			
			String userPassword = "rkumar@ealliancecorp.com:eAlliance2016!";
			String encoding = new String(org.apache.commons.codec.binary.Base64
					.encodeBase64(org.apache.commons.codec.binary.StringUtils.getBytesUtf8(userPassword)));
			System.out.println(encoding);
			con.setRequestMethod("POST");
			con.setRequestProperty("Authorization", "Basic " + encoding);
			con.setRequestProperty("Accept", "application/json");
			con.setRequestProperty("Content-Type", "application/json");
			con.setDoOutput(true);
			con.setDoInput(true);
	
			con.setUseCaches (false);
			 printout = new OutputStreamWriter(con.getOutputStream ());
			 printout.write(json.toString());
			 //printout.write(URLEncoder.encode(json.toString(),"UTF-8"));
			 printout.flush ();
			 
			
	/*	post.setRequestBody(json);
		post.setRequestHeader("Content-Type", "application/json");
		post.setRequestHeader("Accept", "application/json");

		post.setRequestHeader("Authorization", "Basic " + encoding);*/
		// post.setRequestProperty("Authorization", "Basic " + encoding);
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));

			StringBuilder sb = new StringBuilder();
			String line1 = in.readLine();
			while (line1 != null) {
				sb.append(line1);
				line1 = in.readLine();
			}
			result = sb.toString();
			printout.close ();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Result==>" + result);
		return result;
		
		
	}
	
	@SuppressWarnings("deprecation")
	public void save(String json){
		   String targetURL = "https://integration-usealliancecotrial54990.integration.us2.oraclecloud.com/integration/flowapi/rest/ORDER_INSERT/v01/saveOrder1";
		   // log.info(targetURL);
		   PostMethod post = new PostMethod(targetURL);
		   String userPassword = "rkumar@ealliancecorp.com:eAlliance2016!";
			String encoding = new String(org.apache.commons.codec.binary.Base64
					.encodeBase64(org.apache.commons.codec.binary.StringUtils.getBytesUtf8(userPassword)));
			System.out.println(encoding);
			post.setRequestHeader("Authorization", "Basic " + encoding);
			post.setRequestHeader("Accept", "application/json");
			post.setRequestHeader("Content-Type", "application/json");
			post.setRequestBody(json);
		   
			 String postResp="";
		   HttpClient httpclient = new HttpClient();
		   long t1 = System.currentTimeMillis();
		   int result;
		try {
			result = httpclient.executeMethod(post);
			 log.info(result);
			   log.info(">> Time taken " + (System.currentTimeMillis() - t1));
			   postResp  = post.getResponseBodyAsString();
		} catch (HttpException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
		   log.info(postResp);
		   //response.getWriter().write(postResp);
	}
	/*public static void main(String args[]){
		
		OrderService  orderService = new OrderService();
		orderService.saveOrder(""))
	}
*/
}
