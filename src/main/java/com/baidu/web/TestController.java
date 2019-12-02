package com.baidu.web;

import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

@Controller
public class TestController {

    @RequestMapping(value = "/test/sayHello.do", method = RequestMethod.GET)
    public String sayHello() {
        return "hello";
    }


    @RequestMapping(value = "/test/sayOk.action", method = RequestMethod.GET)
    public void sayOk(HttpServletResponse response) throws IOException {
        ResultVo resultVo = new ResultVo();
        resultVo.setId(UUID.randomUUID().toString());
        resultVo.setName("resultVo");
        response.getWriter().write(JSON.toJSONString(resultVo));
    }


    class ResultVo {
        private String id;

        private String name;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
