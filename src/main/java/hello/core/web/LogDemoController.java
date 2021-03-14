package hello.core.web;

import hello.core.common.MyLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequiredArgsConstructor
public class LogDemoController {

    // MyLogger를 주입받는 것이 아니라 MyLogger를 찾을 수 있는 DL할 수 있도록 생성
    private final MyLogger myLogger;
    private final LogDemoService logDemoService;

    @RequestMapping("log-demo") // log-demo라는 요청이 오면
    @ResponseBody // 뷰 화면이 없이 문자만 반환하기 위해서
    public String logDemo(HttpServletRequest request) {
        String requestURL = request.getRequestURL().toString();

        System.out.println("myLogger = " + myLogger.getClass());
        myLogger.setRequestURL(requestURL);

        myLogger.log("controller test");
        logDemoService.logic("testId");

        return "OK";
    }
}
