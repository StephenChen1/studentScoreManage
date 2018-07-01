package web;

import javax.servlet.http.HttpServletRequest;

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
	public String execution(HttpServletRequest request){
		String position = request.getParameter("position");
		System.out.println("position::" + position);
		if(position.equals("student")){
			return "student";
		}else if(position.equals("teacher")){
			return "teacher";
		}else if(position.equals("manager")){
			return "manager";
		}else{
			return "login";
		}
	}
	
}
