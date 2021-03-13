package org.zx.blog.Model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Mytest {
    @Autowired
    My my;
    @GetMapping("/my")
    public String my(){
        return my.toString();
    }
}
