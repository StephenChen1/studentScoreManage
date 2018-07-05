package web;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import dto.LoginForm;
import service.LoginService;

@Controller
@RequestMapping("/login")
public class LoginController {

	@Autowired
	private LoginService loginService ;
	
	@RequestMapping(value = "/index")
	public String login(){
		
		return "login";
	}
	
	@RequestMapping(value = "/execution")
	@ResponseBody
	public boolean execution(@RequestBody LoginForm loginForm){
		System.out.println("position："+loginForm.getPosition());
		System.out.println("id："+loginForm.getId());
		System.out.println("password："+loginForm.getPassword());
		boolean successLogin = loginService.judgeLogin(loginForm.getPosition(), loginForm.getId(), loginForm.getPassword());
		System.out.println("successLogin:" + successLogin);
		return successLogin;
	}
	
	@RequestMapping(value = "/navigate")
	public String execution(HttpServletRequest request,HttpServletResponse response){
		String position = request.getParameter("position");
		String id = request.getParameter("id");
		System.out.println("position::" + position);
		System.out.println("id::" + id);
		if(position.equals("student")){
			addCookie(response,"student_id",id);
			return "student";
		}else if(position.equals("teacher")){
			addCookie(response,"teacher_id",id);
			return "teacher";
		}else if(position.equals("manager")){
			addCookie(response,"manager_id",id);
			return "manager";
		}else{
			return "loginIndex";
		}
	}
	
	//添加cookie
	private void addCookie(HttpServletResponse response,String position,String id){
		Cookie cookie = new Cookie(position, id);
        cookie.setMaxAge(30 * 60);// 设置为30min
        cookie.setPath("/");
        System.out.println("已添加===============");
        response.addCookie(cookie);
	}
	
	//退出登录操作，删除cookie，返回登录界面
	@RequestMapping("/exit")
	public String exitLogin(HttpServletRequest request,HttpServletResponse response){
		
		//获取cookie
		Cookie[] cookies = request.getCookies();
		//迭代删除cookie
		for (Cookie cookie: cookies) {
			cookie.setMaxAge(0);
			response.addCookie(cookie);
		}
		
		return "login";
	}
	
	
}
