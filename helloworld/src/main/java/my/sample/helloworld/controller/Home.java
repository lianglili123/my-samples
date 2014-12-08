package my.sample.helloworld.controller;

import my.sample.helloworld.dao.WriterDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class Home {
	
	@Autowired
	WriterDao dao;
	
	@RequestMapping(value="/home",method=RequestMethod.GET)
	public String home(Model model){
		model.addAttribute("writer",dao.getWriter(1));
		return "home";
	}

}
