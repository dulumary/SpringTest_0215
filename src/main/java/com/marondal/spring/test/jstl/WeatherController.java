package com.marondal.spring.test.jstl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/jstl/weather")
@Controller
public class WeatherController {
	
	@GetMapping("/list")
	public String weatherHistory() {
		return "jstl/weather/list";
	}
	
	@GetMapping("/input")
	public String inputWeather() {
		return "jstl/weather/input";
	}

}
