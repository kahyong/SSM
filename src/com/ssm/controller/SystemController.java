/**
 * 
 */
package com.ssm.controller;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssm.model.SysMenu;
import com.ssm.model.easyui.Tree;
import com.ssm.service.UserService;

/**
 * @author ck
 * 
 */
@Controller
public class SystemController {
	private final Logger log = LoggerFactory.getLogger(SystemController.class);
	
	@Autowired
	private UserService userService;
	

	
	@RequestMapping(value = "/test/hello",method = RequestMethod.GET)
    public String testHello(@RequestParam String test) {
    	log.info("执行了testHello方法！");
    	log.info(test);
        return "loginSuccess";
    }
	
//    /**
//     * 测试缓存
//     * @param id
//     * @param model
//     * @return
//     */
//    @RequestMapping(value="/get/{id}", method = RequestMethod.GET)  
//    public String get(@PathVariable int id, Model model){  
//        String username = userService.getUsernameById(id);  
//        model.addAttribute("username", username);  
//        return "getUsername";  
//    } 
    
    /**
     * 获取菜单栏
     * @param id
     * @param model
     * @return
     */
   
    
 
      
    //allEntries为true表示清除value中的全部缓存,默认为false  
    @CacheEvict(value="myCache", allEntries=true)  
    public void removeAll(){  
        System.out.println("移除缓存中的所有数据");  
    }  
    
    

}
