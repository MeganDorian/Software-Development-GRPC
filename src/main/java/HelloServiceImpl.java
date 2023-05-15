import io.grpc.stub.StreamObserver;
import org.itmo.Hello;
import org.itmo.HelloRequest;
import org.itmo.HelloResponse;
import org.itmo.HelloServiceGrpc;

public class HelloServiceImpl extends HelloServiceGrpc.HelloServiceImplBase {
    
    /**
     * @param responseObserver
     */
    @Override
    public StreamObserver<HelloRequest> hello(StreamObserver<HelloResponse> responseObserver) {
        return new StreamObserver<>() {
            @Override
            public void onNext(HelloRequest value) {
                System.out.println("message: " + value.getAllFields());
                HelloResponse response = HelloResponse.newBuilder().setGreeting("Heeeello there").build();
                responseObserver.onNext(response);
            }
    
            @Override
            public void onError(Throwable t) {
        
            }
    
            @Override
            public void onCompleted() {
        
            }
        };
    }
    
//    @Override
//    public void hello(
//            HelloRequest request, StreamObserver<HelloResponse> responseObserver) {
//
//        String greeting = new StringBuilder()
//                .append("Hello, ")
//                .append(request.getFirstName())
//                .append(" ")
//                .append(request.getLastName())
//                .toString();
//
//        HelloResponse response = HelloResponse.newBuilder()
//                                              .setGreeting(greeting)
//                                              .build();
//
//        responseObserver.onNext(response);
//        responseObserver.onCompleted();
//    }
}