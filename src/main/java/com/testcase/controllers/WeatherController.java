package com.testcase.controllers;

import com.testcase.models.GeoLocation;
import com.testcase.models.Weather;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WeatherController {

    @RequestMapping(value = "/searchForm", method = RequestMethod.GET)
    public ModelAndView getSearchForm() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("geoLocation",
                new GeoLocation());
        modelAndView.setViewName("searchForm");
        return modelAndView;
    }

    @RequestMapping(value = "/weatherInfo", method = RequestMethod.POST)
    public ModelAndView getWeather(@ModelAttribute("geoLocation") GeoLocation geoLocation) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("weather",
                Weather.Randomizer.generateWeather(geoLocation));
        modelAndView.setViewName("weatherInfo");
        return modelAndView;
    }

    @RequestMapping(value = "/index")
    public String getIndex(){
        return "index";
    }

    @ExceptionHandler({Exception.class, Error.class})
    public ModelAndView handleException(Exception ex) {

        ModelAndView model = new ModelAndView();
        model.addObject("exception", ex.getMessage());
        model.setViewName("error");

        return model;
    }
}
