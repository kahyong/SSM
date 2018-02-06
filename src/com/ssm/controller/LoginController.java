package com.ssm.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;
import javax.print.DocFlavor.STRING;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.ssm.controller.base.BaseController;
import com.ssm.dao.redis.RedisDao;
import com.ssm.model.SysMenu;
import com.ssm.model.User;
import com.ssm.model.easyui.Tree;
import com.ssm.service.IAuthService;
import com.ssm.service.UserService;
import com.ssm.util.RedisUtil;
/**
 * 总入口
 * @author fh QQ 3 1 3 5 9 6 7 9 0[青苔]
 * 修改日期：2015/11/2
 */
/**
 * @author CK
 *
 */
@Controller
@Scope(value="prototype")
public class LoginController extends BaseController {
	private final Logger log = LoggerFactory.getLogger(SystemController.class);

	@Autowired
	private UserService userService;
	@Autowired
	private RedisUtil redisUtil; 
	@Autowired
    private IAuthService iAuthService;
//	@Autowired
//	private RedisDao redisDao;
	

	/**
	 * home page
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value= "/",method = RequestMethod.GET)
	public String  home (){
		if (!SecurityUtils.getSubject().isAuthenticated()) {
			return "/login";
		}
		return "/index";
	}
	
	/**访问登录页
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/login_toLogin")
	public ModelAndView toLogin()throws Exception{
		System.out.println("test.....");
		ModelAndView mv = this.getModelAndView();
		mv.setViewName("login");
		mv.addObject("object","TEST");
		userService.test();
		System.err.println("test.....");
		return mv;
	}
	
	/**
	 * 请讲接口 http://127.0.0.1:8080/项目名称/appRedisDemo/redisDemo.do
	 * demo展示的在redis存储读取数据的方式，本系统暂时用不到redis，此redis接口可根据实际业务需求选择使用
	 * 具体redis的应用场景->百度下即可
	 */
	@RequestMapping(value="/redisDemo")
	@ResponseBody
	public Object redis(){
		
		try {
			System.out.println("start.....");
//			redisDao.addString("test", "ckyong");
//			System.out.println(redisDao.get("test"));
			redisUtil.set("test", "ckyong123");
			System.out.println(redisUtil.get("test"));
			System.out.println("end.....");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "asdasd";
	}
	
	//用户登录
    @RequestMapping("/login")
    public String login(User user, HttpServletRequest request) {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), user.getPassword());
        try{
            subject.login(token);   //会跳到我们自定义的realm中
            if (subject.isAuthenticated()) {
                logger.info("login success !!!!");
            } else {
                logger.info("login fail !!!!");
            }
            User user2=iAuthService.getByUsername( user.getUsername());
            request.getSession().setAttribute("userId", user2.getId()); 
            request.getSession().setAttribute("user", user.getUsername());
            return "/index";
        }catch(Exception e){
            //e.printStackTrace();
            request.setAttribute("message", "username or password error");
            return "login";
        }
    }
    
    @ResponseBody
    @RequestMapping(value="/getMenu", method = RequestMethod.POST)  
    public List<Tree> getMenu(HttpSession session){  
    	int userId =  (Integer)session.getAttribute("userId"); 
    	List<SysMenu> menuList = userService.getMenu(userId);
    	List<Tree> treeList = new ArrayList<Tree>();

        for (SysMenu menu : menuList) {
			Tree node = new Tree();
			BeanUtils.copyProperties(menu, node);
			if(menu.getParentId()!=0){	//有父节点
				node.setPid(menu.getParentId());
			}
			Map<String, Object> attr = new HashMap<String, Object>();
			attr.put("url", menu.getUrl());
			node.setAttributes(attr);
			treeList.add(node);
        }
    	    return treeList;
    }
    @RequestMapping(value = "/hello", produces = "text/plain;charset=UTF-8" ,method = RequestMethod.GET) 
    @ResponseBody  
    public   String hello() {  
        return "你好！hello";  
    }  
    
    @RequestMapping(value = "/say/{msg}", produces = "application/json;charset=UTF-8")  
    public @ResponseBody  
    String say(@PathVariable(value = "msg") String msg) {  
        return "{\"msg\":\"you say:'" + msg + "'\"}";  
    }  
    


   
	
}
