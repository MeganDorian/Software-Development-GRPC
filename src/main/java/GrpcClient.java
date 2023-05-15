import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import java.util.Scanner;
import org.itmo.HelloRequest;
import org.itmo.HelloRequestOrBuilder;
import org.itmo.HelloResponse;
import org.itmo.HelloServiceGrpc;

public class GrpcClient {
    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8080)
                                                      .usePlaintext()
                                                      .build();
        
        HelloServiceGrpc.HelloServiceStub stub
                = HelloServiceGrpc.newStub(channel);
        Scanner scan = new Scanner(System.in);
    
        while(true) {
            String str = scan.nextLine();
            StreamObserver<HelloResponse> obs = new StreamObserver<HelloResponse>() {
                @Override
                public void onNext(HelloResponse value) {
                    System.out.println("message: " + value.getAllFields());
                    System.out.println("Hello from onNext");
                }
        
                @Override
                public void onError(Throwable t) {
            
                }
        
                @Override
                public void onCompleted() {
            
                }
            };
    
            StreamObserver<HelloRequest> helloResponse = stub.hello(obs);
            HelloRequest helloRequest1 = HelloRequest.newBuilder().setFirstName(str).build();
            helloResponse.onNext(helloRequest1);
        }
  
    
    
//        channel.shutdown();
    }
}