package com.urlmonitor.controller.Url;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.urlmonitor.model.Url.URL;
import com.urlmonitor.service.Url.URLService;

@RestController
@RequestMapping(value="/api")
public class UrlController {

	@Autowired
	URLService urlService;

	@PostMapping(value="/url")
	public List<URL> postCustomer(@RequestBody List<String> urls){
		return this.urlService.startMonitor(urls);
	}
}