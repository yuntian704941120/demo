package com.springboot.demo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

/**
 * @author Levin
 * @since 2018/4/23 0023
 */
@Api("用户接口")
@Controller
@RequestMapping
public class ThymeleafController {

    private static final Logger logger = LoggerFactory.getLogger(ThymeleafController.class);

    @Value("${aa}")
    private String aa;

    @Autowired
    private RedisTemplate redisCacheTemplate;


    @Autowired
    private Name nn;


    @Autowired
    private UserMapper userMapper;

    @GetMapping("/demo")
    @ResponseBody
    public String demo1() {



        String[] name=new String[2];
        name[0]="aa";
        name[1]="bb";
        System.out.println("这是什么环境："+aa);
        logger.info("你大爷在测试");
        System.out.println(aa);
        System.out.println(nn.getName()+":"+nn.getAge());
        return "Hello Luis";
    }


    @GetMapping("/users")
    @ResponseBody
    @ApiOperation("获取用户")
    public List<User> getUsers(){
        User user=new User("kaka","123456");
        userMapper.insert(user);
        user=new User("ronaldo","2151589");
        userMapper.insert(user);
        List<User> list=userMapper.findByUsername("kaka");
        ResponseMsg msg=new ResponseMsg();
        msg.setData(list);




        // TODO 以下只演示整合，具体Redis命令可以参考官方文档，Spring Data Redis 只是改了个名字而已，Redis支持的命令它都支持
        String key = "battcn:user:1";
        redisCacheTemplate.opsForValue().set(key, new User(1L, "u1", "pa"));
        // TODO 对应 String（字符串）
        user = (User) redisCacheTemplate.opsForValue().get(key);
        logger.info("[对象缓存结果] - [{}]", user);


        return list;
    }



    @GetMapping("/index")
    public ModelAndView index() {
        ModelAndView view = new ModelAndView();
        view.setViewName("/fragments/greet");
        view.addObject("title","欢迎使用Thymeleaf!");
        return view;
    }

    @GetMapping("/index1")
    public String index1(HttpServletRequest request) {
        // TODO 与上面的写法不同，但是结果一致。
        // 设置属性
        request.setAttribute("title", "我的第一个WEB页面");
        request.setAttribute("desc", "欢迎进入Luis-web 系统");
        Author author = new Author();
        author.setAge(24);
        author.setEmail("1085143002@qq.com");
        author.setName("Luis");
        request.setAttribute("author", author);
        // 返回的 index 默认映射到 src/main/resources/templates/xxxx.html
        return "index";
    }

    class Author {
        private int age;
        private String name;
        private String email;
        // 省略 get set

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }
    }
}
