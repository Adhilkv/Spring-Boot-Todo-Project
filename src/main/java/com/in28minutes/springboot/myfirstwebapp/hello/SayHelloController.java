package com.in28minutes.springboot.myfirstwebapp.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SayHelloController {

	@RequestMapping("say-hello")
	@ResponseBody
	public String SayHello() {
		return "Hello! What are you learning today";
	}

	@RequestMapping("say-hello-html")
	@ResponseBody
	public String SayHelloHtml() {
		StringBuffer sb = new StringBuffer();
		sb.append("<html>");
		sb.append("<head>");
		sb.append("<title>");
		sb.append("Html Page");
		sb.append("</title>");
		sb.append("</head>");
		sb.append("<body>");
		sb.append("My First Html Page....");
		sb.append("</body>");
		sb.append("</html>");

		return sb.toString();
	}
	

	@RequestMapping("say-hello-jsp")
	public String SayHelloJsp() {
		return "sayHello";
	}
}
