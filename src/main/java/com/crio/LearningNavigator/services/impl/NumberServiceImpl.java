package com.crio.LearningNavigator.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.crio.LearningNavigator.services.NumberService;

@Service
public class NumberServiceImpl implements NumberService {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public String getNumberFact(int num) {
        String url = buildRequestURL(num);
        String apiResponse = restTemplate.getForObject(url, String.class);
        return apiResponse;
        
    }

    private String buildRequestURL(int num) {
        String URL = "http://numbersapi.com/" + String.valueOf(num);
        return URL;
    }
     
    
}
