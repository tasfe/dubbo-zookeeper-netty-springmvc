package dubbo.provider.service.impl;

import dubbo.common.service.HelloService;

/**
 * Created by lenovo on 2015/5/11.
 */
public class HelloServiceImpl implements HelloService {

    public String sayHello(String str) {
        System.out.println(str);
       return "Hello "+str;
    }
}
