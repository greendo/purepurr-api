package com.purepurr.apiservice;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.RetryNTimes;
import org.apache.curator.x.discovery.ServiceDiscoveryBuilder;
import org.apache.curator.x.discovery.ServiceInstance;
import org.apache.curator.x.discovery.UriSpec;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApiServiceApplication {

	@Value("${server.port}")
	private static String port;

	public static void main(String[] args) {
		System.out.println("PORT: " + ApiServiceApplication.port);

		try {
			registerInZookeeper(9696);
		} catch (Exception e) {
			e.printStackTrace();
		}

		SpringApplication.run(ApiServiceApplication.class, args);
	}

	private static void registerInZookeeper(int port) throws Exception {
		CuratorFramework curatorFramework = CuratorFrameworkFactory.newClient("localhost:2181", new RetryNTimes(5, 1000));
		curatorFramework.start();
		ServiceInstance<Object> serviceInstance = ServiceInstance.builder()
				.uriSpec(new UriSpec("{scheme}://{address}:{port}"))
				.address("localhost")
				.port(port)
				.name("api-service")
				.build();

		ServiceDiscoveryBuilder.builder(Object.class)
				.basePath("api")
				.client(curatorFramework)
				.thisInstance(serviceInstance)
				.build()
				.start();
	}
}
