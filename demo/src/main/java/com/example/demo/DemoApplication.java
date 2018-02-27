package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;


@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
/*
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		//Query query = session.createQuery("from MyUser E  where ((E.userName =A)and (E.userName=B)")
		String hql = "FROM MyUser  WHERE MyUser.userName = A ";
		Query query = session.createQuery(hql);
		List list = query.list();

*/
	}
}
