package com.thanglequoc;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class RootController {
    @RequestMapping(method = RequestMethod.GET)
    public String entrySiteShowUp() {
	return "Now you see our company";
    }
}
