package com.mootal.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import java.net.*;
import javax.servlet.http.HttpServletRequest;

@RestController
@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(HttpServletRequest request) throws UnknownHostException {
		// boot config
        System.out.println("config port : " + port);
		
		InetAddress address = InetAddress.getLocalHost();
        System.out.println("actual ipaddr : " + address.getHostAddress());
        System.out.println("actual port : " + request.getLocalPort());
		return "config port : " + port + "\n\ractual addr : " + address.getHostAddress() + ":" + request.getLocalPort();
    }
	
	@Value("${server.port}")
	private String port;
 
    public String getPort() {
        return port;
    }
 
    public void setPort(String port) {
        this.port = port;
    }
	
}

