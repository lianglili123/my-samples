package my.sample.helloworld.controller;

import java.util.Locale;

import javax.servlet.http.HttpServletResponse;

import my.sample.helloworld.dao.WriterDao;
import my.sample.helloworld.email.EmailSender;
import my.sample.helloworld.entities.Writer;
import my.sample.helloworld.model.LoginModel;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes("writer")
public class Home {

	@Autowired
	WriterDao dao;
	@Autowired
	EmailSender sender;

	Logger log = Logger.getLogger(this.getClass());

	@RequestMapping(value="/",method = RequestMethod.GET)
	public String indexMapping(Model model) {
		LoginModel loginModel=new LoginModel();
		model.addAttribute("login", loginModel);
		return "index";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginMapping(@ModelAttribute("login") LoginModel lm,Model model) {
		String userid = lm.getUserid();
		String password = lm.getPassword();
		Writer writer=dao.getWriter(Integer.parseInt(userid));

		if (writer.getPassword().equals( password)) {
			log.info("1:"+userid+":"+password);
			model.addAttribute("writer", writer);
		} else {
			log.info("2:"+userid+":"+password);
		}
		return "home";

	}

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String homeMapping(Model model) {
		model.addAttribute("writer", dao.getWriter(1));
		log.info("<<<<<return home");
		return "home";
	}

	@RequestMapping(value = "/echo/id={id},name={name},email={email}", method = RequestMethod.GET)
	public String echoMapping(@PathVariable String id,
			@PathVariable String name, @PathVariable String email, Model model) {
		Writer writer = new Writer();
		writer.setId(Integer.parseInt(id));
		writer.setName(name);
		writer.setEmail(email);
		model.addAttribute("writer", writer);
		return "home";
	}

	@RequestMapping(value = "/js", method = RequestMethod.GET)
	public String js(HttpServletResponse response, Locale locale, Model model) {
		return "js";
	}
	
	@RequestMapping(value = "/sendEmail", method = RequestMethod.POST)
	public String sendMapping(@ModelAttribute("writer") Writer writer,Model model) {
		Boolean isSent=false;
		if(writer.getEmail()!=null){
			try{
				sender.sendEmail(writer.getEmail());
			}catch(Exception e){
				return "home";
			}
			isSent=true;
		}
		model.addAttribute("isSent", isSent);
		return "home";
	}

}
