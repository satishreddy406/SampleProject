package com.sample.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sample.model.Customer;
import java.lang.reflect.Type;

@Service("CustomerService")

public class CustomerService {

	public List<Customer> getAllCustomers() {
		List<Customer> customerList = new ArrayList<Customer>();
		String customerUrl = "https://integration-usealliancecotrial54990.integration.us2.oraclecloud.com/integration/flowapi/rest/WITHJAVA/v01/getAllWithoutjava";
		String result = "";
		Gson gson;
		URL oracle;
		try {
			oracle = new URL(customerUrl);
			HttpURLConnection con = (HttpURLConnection) oracle.openConnection();
			
			String userPassword = "rkumar@ealliancecorp.com:eAlliance2016!";
			String encoding = new String(org.apache.commons.codec.binary.Base64
					.encodeBase64(org.apache.commons.codec.binary.StringUtils.getBytesUtf8(userPassword)));
			System.out.println(encoding);

			// add reuqest header
			con.setRequestMethod("GET");
			// con.setRequestProperty("Content-Type", "application/json");
			con.setRequestProperty("charset", "UTF-8");
			con.setRequestProperty("Authorization", "Basic " + encoding);
		
			// con.setRequestProperty("User-Agent", "Mozilla/5.0");
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));

			StringBuilder sb = new StringBuilder();
			String line1 = in.readLine();
			while (line1 != null) {
				sb.append(line1);
				line1 = in.readLine();
			}
			result = sb.toString();

		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Type listType = new TypeToken<List<Customer>>() {
		}.getType();
		gson = new Gson();
		if (!(result.equals(""))) {
			customerList = gson.fromJson(result, listType);
		}
		for (Customer customer : customerList) {
			System.out.println(customer.toString());
		}

		return customerList;

	}

	public static void main(String args[]) {
		CustomerService customerService = new CustomerService();
		customerService.getAllCustomers();
	}

}
