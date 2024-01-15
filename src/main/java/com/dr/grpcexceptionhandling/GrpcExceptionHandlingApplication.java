package com.dr.grpcexceptionhandling;

import com.dr.grpcexceptionhandling.server.HelloServiceImpl;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class GrpcExceptionHandlingApplication {
	public static void main(String[] args) throws IOException, InterruptedException {
		SpringApplication.run(GrpcExceptionHandlingApplication.class, args);

		Server server = ServerBuilder.forPort(6900)
				.addService(new HelloServiceImpl())
				.build();
		server.start();
		server.awaitTermination();
	}
}
