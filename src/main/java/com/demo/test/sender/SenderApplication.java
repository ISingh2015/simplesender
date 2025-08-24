package com.demo.test.sender;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
/**
 * 
 * @author Inderjit Singh Sanhotra
 * @since 01-06-2021
 * @version 0.0.1
 *
 */

@SpringBootApplication
@RestController()
@Slf4j
public class SenderApplication {

	ArrayList<Customer> customerList = new ArrayList<>();

	public SenderApplication() {
		this.customerList.add(new Customer(100, "ABC Customer"));
		this.customerList.add(new Customer(200, "CDE Customer"));
		this.customerList.add(new Customer(300, "FGH Customer"));
		this.customerList.add(new Customer(400, "IJK Customer"));
		this.customerList.add(new Customer(500, "LMN Customer"));
	}

	public static void main(String[] args) {
		SpringApplication.run(SenderApplication.class, args);
	}

	@GetMapping(value = "/healthcheck-sender-app")
	public ResponseEntity<String> healthCheck() {
		log.info("Status: UP.  on : {}", new Date());
		return new ResponseEntity<>("Status Sender App: UP. on : "+ new Date(), HttpStatus.OK);
	}

	@GetMapping(value = "/customer/list")
	public ResponseEntity<ArrayList<Customer>> getAllCustomers() {
		log.info("{} Customers List {}", new Date(), customerList);
		return new ResponseEntity<>(customerList,HttpStatus.OK);
	}


}
