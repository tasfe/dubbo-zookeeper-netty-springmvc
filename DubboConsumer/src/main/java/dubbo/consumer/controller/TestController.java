package dubbo.consumer.controller;

import dubbo.common.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by lenovo on 2015/5/11.
 */
@Controller
public class TestController {

    @Autowired
    private HelloService helloService ;

    @ResponseBody
    @RequestMapping("/test")
    public String index(HttpServletRequest request){
        String str=request.getParameter("str");
        return helloService.sayHello(str) ;
    }
}
