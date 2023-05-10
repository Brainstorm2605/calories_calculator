package com.calorie.demo;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.HashMap;


@RestController
public class BmiCalculatorController {

    @GetMapping("/")
    public String home (){
        return "index";
    }
    @PostMapping("/calculate-bmi/")
    public Double calculateBmi(@RequestBody double weight, @RequestBody double height,
    @RequestBody int age,@RequestBody String gender, @RequestBody String active) 
    {
        Double calorieCalculator= 0.0;
        HashMap<String, Double> PA = new HashMap<>();
        if(gender.toLowerCase().equals("male")){

            PA.put("sedentary",1.0);
            PA.put("low active",1.12);
            PA.put("active",1.27);
            PA.put("very active",1.54);
            calorieCalculator = (864 - 9.72 * age + PA.get(active.toLowerCase()) * (14.2 * weight + 503 * height));
        }else{
            PA.put("sedentary",1.0);
            PA.put("low active",1.14);
            PA.put("active",1.27);
            PA.put("very active",1.45);
            calorieCalculator = (387 - 7.31 * age + PA.get(active.toLowerCase()) * (10.9 * weight + 660.7 * height));
        }
        return calorieCalculator;
    }
}
