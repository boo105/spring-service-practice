package webservice.springservicepractice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import webservice.springservicepractice.service.TestService;

@Controller
public class TestController {
    @Autowired
    private TestService testService;

//    @Async
//    public void asyncMethod(int i) {
//        try {
//            Thread.sleep(500);
//            System.out.println(i + "번째 작동");
//        } catch(InterruptedException e) {
//            e.printStackTrace();
//        }
//    }

    @GetMapping("async")
    public String testAsync() {
        for(int i = 0; i < 50; i++) {
            testService.asyncMethod(i);
        }
        return "";
    }

}
