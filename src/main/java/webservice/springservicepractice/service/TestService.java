package webservice.springservicepractice.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class TestService {
    @Async
    public void asyncMethod(int i) {
        try {
            Thread.sleep(500);
            System.out.println(i + "번째 작동");
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
    }

}
