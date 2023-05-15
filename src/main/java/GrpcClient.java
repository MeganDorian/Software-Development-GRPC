import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
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
    
        while(true) {
            StreamObserver<HelloResponse> obs = new StreamObserver<HelloResponse>() {
                @Override
                public void onNext(HelloResponse value) {
            
                }
        
                @Override
                public void onError(Throwable t) {
            
                }
        
                @Override
                public void onCompleted() {
            
                }
            };
    
            StreamObserver<HelloRequest> helloResponse = stub.hello(obs);
        }
  
    
    
//        channel.shutdown();
    }
}