package com.connected.service.impl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.connected.service.ConnectedService;

@Service
public class ConnectedServiceImpl implements ConnectedService {

	@Override
	public String isConnected(String origin, String destination) {
		String result = "no";
		try {
			Map<String, String> data = getData();
			boolean flag = true;
			while(flag) {
				if(destination.equals(data.get(origin))) {
					result = "yes";
					flag = false;
				}else if(data.get(origin)!=null){
					origin = data.get(origin);
				}else {
					flag = false;
				}
			}
		} catch (Exception e) {
			System.out.println("Error while processing the connected process " + e);
		}
		return result;
	}

	private Map<String, String> getData() throws Exception {
		String filePath = "city.txt";
		Map<String, String> map = new HashMap<String, String>();

		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(filePath));
			String line;
			while ((line = reader.readLine()) != null) {
				String[] parts = line.split(",", 2);
				if (parts.length >= 2) {
					String key = parts[1];
					String value = parts[0];
					map.put(key, value);
				} else {
					System.out.println("ignoring line: " + line);
				}
			}
		} catch (Exception e) {
			System.out.println("Error while processing the file " + e);
		} finally {
			if (reader != null)
				reader.close();
		}
		return map;
	}

}
