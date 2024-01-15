package com.dr.grpcexceptionhandling.server;

import com.dr.grpcexceptionhandling.HelloRequest;
import com.dr.grpcexceptionhandling.HelloResponse;
import com.dr.grpcexceptionhandling.HelloServiceGrpc.HelloServiceImplBase;
import io.grpc.stub.StreamObserver;

public class HelloServiceImpl extends HelloServiceImplBase {

    @Override
    public void hello(HelloRequest request, StreamObserver<HelloResponse> responseObserver) {
        String greeting = "Hello there, " + request.getFirstName() + " " + request.getLastName();
        HelloResponse response = HelloResponse.newBuilder().setGreeting(greeting).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
