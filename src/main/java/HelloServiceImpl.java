import io.grpc.stub.StreamObserver;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import org.itmo.Hello;
import org.itmo.HelloRequest;
import org.itmo.HelloResponse;
import org.itmo.HelloServiceGrpc;

public class HelloServiceImpl extends HelloServiceGrpc.HelloServiceImplBase {
    Scanner scanner = new Scanner(System.in);
    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    String name;
    
    public HelloServiceImpl(String name) {
        this.name = name;
    }
    
    /**
     * @param responseObserver
     */
    @Override
    public StreamObserver<HelloRequest> hello(StreamObserver<HelloResponse> responseObserver) {
        return new StreamObserver<>() {
            @Override
            public void onNext(HelloRequest value) {
                System.out.println("[" + value.getDate() + "] " + value.getName() + ": " + value.getMessage());
                System.out.print("enter answer or will be sent standard message: ");
                String answer;
                try {
                    answer = scanner.nextLine();
                } catch (Exception ex) {
                    answer = "All good!";
                }
                HelloResponse response = HelloResponse.newBuilder().setDate(dateFormat.format(new Date()))
                    .setName(name).setMessage(answer).build();
                responseObserver.onNext(response);
            }
    
            @Override
            public void onError(Throwable t) {
        
            }
    
            @Override
            public void onCompleted() {
                System.out.println("Hello");
            }
        };
    }
    
}