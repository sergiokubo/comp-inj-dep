package com.example.meuDesafio1;

import java.util.Locale;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.meuDesafio1.entities.Order;
import com.example.meuDesafio1.services.OrderService;

@SpringBootApplication
public class MeuDesafio1Application implements CommandLineRunner{
	
	@Autowired
	private OrderService orderService;
	

	public static void main(String[] args) {
		SpringApplication.run(MeuDesafio1Application.class, args);
		
		
	}

	@Override
	public void run(String... args) throws Exception {
	
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		int code;
		double basic;
		double discount;
		
		code = sc.nextInt();
		basic = sc.nextDouble();
		discount = sc.nextDouble();
		
		Order order = new Order(code, basic, discount);
		System.out.println("Pedido código " + order.getCode());
		System.out.printf("Valor total: R$ %.2f", orderService.total(order));
		
		sc.close();
		
	}

}
