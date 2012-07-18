package me.gotdo.vp3.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mongodb.DB;

@Controller
public class TestController {
	
	@Autowired
	private MongoTemplate mongo;
	
	@RequestMapping(value="/test", method = RequestMethod.GET)
	public String login(ModelMap model) {
		
		if (mongo != null) {
			model.addAttribute("works", "yes");
			
			DB db = mongo.getDb();
			model.addAttribute("dbname", db.getName());
		}
 
		return "test";
 
	}
	
}
