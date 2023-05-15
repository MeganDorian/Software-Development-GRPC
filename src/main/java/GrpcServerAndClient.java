import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Server;
import io.grpc.ServerBuilder;

import io.grpc.stub.StreamObserver;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import org.itmo.Hello;
import org.itmo.HelloRequest;
import org.itmo.HelloResponse;
import org.itmo.HelloServiceGrpc;

public class GrpcServerAndClient {
    public static void main(String[] args) throws IOException, InterruptedException {
        if(args.length == 1) {
            Server server =
                ServerBuilder.forPort(8080).addService(new HelloServiceImpl(args[0])).build();
            server.start();
            server.awaitTermination();
        } else if(args.length == 2) {
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost",
                    Integer.parseInt(args[1]))
                .usePlaintext()
                .build();
            
            HelloServiceGrpc.HelloServiceStub stub
                = HelloServiceGrpc.newStub(channel);
            Scanner scan = new Scanner(System.in);
            
            while(true) {
                System.out.print("Enter message: ");
                String str = scan.nextLine();
                StreamObserver<HelloResponse> obs = new StreamObserver<HelloResponse>() {
                    @Override
                    public void onNext(HelloResponse value) {
                        System.out.println("Answer [" + value.getDate() + "] " + value.getName() + ":" +
                                           " " + value.getMessage());
                    }
                    
                    @Override
                    public void onError(Throwable t) {
                    
                    }
                    
                    @Override
                    public void onCompleted() {
                    
                    }
                };
                
                StreamObserver<HelloRequest> helloResponse = stub.hello(obs);
                HelloRequest helloRequest =
                    HelloRequest.newBuilder().setDate(dateFormat.format(new Date()))
                        .setName(args[0]).setMessage(str).build();
                helloResponse.onNext(helloRequest);
            }
        } else {
            throw new RuntimeException("Not found username!");
        }
    }
}