package my.sample.helloworld.controller;

import java.util.Locale;

import javax.servlet.http.HttpServletResponse;

import my.sample.helloworld.dao.WriterDao;
import my.sample.helloworld.entities.Writer;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class Home {

	@Autowired
	WriterDao dao;
	
	Logger log=Logger.getLogger(this.getClass());

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String homeMapping(Model model) {
		model.addAttribute("writer", dao.getWriter(1));
		log.info("<<<<<return home");
		return "home";
	}

	@RequestMapping(value = "/echo/id={id},name={name},email={email}", method = RequestMethod.GET)
	public String echoMapping(@PathVariable String id, @PathVariable String name,
			@PathVariable String email, Model model) {
		Writer writer = new Writer();
		writer.setId(Integer.parseInt(id));
		writer.setName(name);
		writer.setEmail(email);
		model.addAttribute("writer", writer);
		return "home";
	}

	@RequestMapping(value = "/js", method = RequestMethod.GET)
	public String js(HttpServletResponse response, Locale locale, Model model) {
		// model.addAttribute("writer",dao.getWriter(1));
		return "js";
	}

}
