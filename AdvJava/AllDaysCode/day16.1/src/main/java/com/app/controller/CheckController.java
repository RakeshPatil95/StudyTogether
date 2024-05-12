package com.app.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller // MANDATORY
@RequestMapping("/check") // OPTIONAL BUT reco : for purpose of segregation
public class CheckController {
	public CheckController() {
		System.out.println("in ctor of " + getClass());
	}

//add request handling method to generate dyn contents
	@GetMapping("/test1") // MANDATORY
	public ModelAndView testModelAndView() {
		System.out.println("in test m n v");
		// o.s.w.s.ModelAndView(String logicalViewName,String modelAttrName,Object
		// attrValue)
		return new ModelAndView("/test/show", "server_ts", LocalDateTime.now());
		// Handler rets ModelAndView to D.S
		// D.S --> V.R : LVN /test1/show , AVN : /WEB-INF/views/test/show.jsp
		// D.S -- model attrs --> stores on req scope --forward --> show.jsp

	}

	// add req handling method to test Model map to generate results
	@GetMapping("/test2")
	public String testModelMap(Model map) {
		System.out.println("in test model map " + map);// {} : empty map
		System.out.println("Model map "+map.getClass());
		// API of o.s.ui.Model : public Model addAttribute(String name,Object value)
		map.addAttribute("server_ts", LocalDateTime.now()).
		addAttribute("num_list", List.of(1, 2, 3, 4, 5, 6));
		System.out.println("map again "+map);//populated map
		return "/test/show";//This method expl rets : LVN --->  AVN : /WEB-INF/views/test/show.jsp
		//implicitly returned : model attr map
	}
}
