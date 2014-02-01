package com.massiverun.main;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;
/**
 * 
 * @author Nilamber Kumar Config
 * Test
 *
 */
@Controller
public class TestController {

	@ResponseBody
	public String getData()
	{
		
		return "new Data";
	}
}
