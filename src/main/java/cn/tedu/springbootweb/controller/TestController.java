package cn.tedu.springbootweb.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 用于处理Web请求的JavaBean要标注 @Controller注解
 */
@Controller
@RequestMapping("/")
@Slf4j
public class TestController {
    /**
     * @RequestMapping("/demo") 通知Spring MVC在
     * 浏览器请求 /demo 时候, 执行demo()方法
     * @ResponseBody 通知SpringMVC将demo()方法的
     * 返回值经过适当的转换, 添加到响应消息的正文中发送
     * 到浏览器.
     * @return
     * 请求路径： http://localhost:8080/demo
     */
    @RequestMapping("")
    @ResponseBody
    public String demo(){
        log.debug("Hello World!");
        return "OK";
    }
    /**
    @author hu
    @see 测试案例
    */
    @RequestMapping("save")
    @ResponseBody
    public String save1(
            String username,
            String password,
            Integer num,
            @RequestParam("default") String def){
        //检查接收到的表单参数
        log.debug("username:{}, password:{}, num:{}",
                username, password, num);
        log.debug("default:{}",def);
        return "OK";
    }

    /**
     * SpringMVC控制器接收表单参数
     * 当控制器方法参数名与表单中输入项的name属性值
     * 一致时候, SpringMVC就会自动处理表单参数,
     * 将参数的值, 注入到 控制器方法参数中
     *
     * @RequestParam("default") 用于映射表单参数
     * 如果出现特殊情况时候, 就可以利用这个注解映射
     * 处理表单参数
     */
    @RequestMapping("/save")
    @ResponseBody
    public String save(
            String username,
            String password,
            Integer num,
            @RequestParam("default") String def){
        //检查接收到的表单参数
        log.debug("username:{}, password:{}, num:{}",
                username, password, num);
        log.debug("default:{}",def);
        return "OK";
    }
}
