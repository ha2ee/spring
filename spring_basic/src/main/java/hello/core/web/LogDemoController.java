package hello.core.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import hello.core.common.MyLogger;
import lombok.RequiredArgsConstructor;


@Controller
@RequiredArgsConstructor
public class LogDemoController {

    private final LogDemoService LogDemoService;
    private final MyLogger myLogger;

    @RequestMapping(value="log-demo")
    @ResponseBody
    public String logDemo(HttpServletRequest request) {
        String requestURL = request.getRequestURI().toString();
        myLogger.setRequestURL(requestURL);

        myLogger.log("controller test");
        LogDemoService.login("testId");
        return "OK";
    }
    
    
}
