package br.com.cds.jobs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JobsController {

	@RequestMapping("/")
	String home(ModelMap modal) {
		modal.addAttribute("title","CDS - JOBS");
		return "index";
	}
	@RequestMapping("/detalhe")
	String detalhe(ModelMap modal) {
		return "detalhe";
	}

	@RequestMapping("/index")
	String index(ModelMap modal) {
		return "index";
	}
	@RequestMapping("/jobs/{page}")
	String partialHandler(@PathVariable("page") final String page) {
		return page;
	}


}
