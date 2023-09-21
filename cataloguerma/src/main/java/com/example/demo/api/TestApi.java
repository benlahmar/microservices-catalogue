package com.example.demo.api;

import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.UnknownHostException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestApi {

	@Value("${server.port}")
	String port;
	
	@GetMapping("categories/info")
	public String getinfo()
	{
		String ddd="";
		try {
			ddd = InetAddress.getLocalHost().getHostName();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return port+"-----"+ddd;
	}
}
