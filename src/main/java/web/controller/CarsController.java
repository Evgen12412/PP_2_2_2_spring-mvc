package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;

import web.model.Car;
import web.service.CarServiceImp;


import java.util.List;

@Controller
public class CarsController {

    private final CarServiceImp carServiceImp;

    @Autowired
    public CarsController(CarServiceImp carServiceImp) {
        this.carServiceImp = carServiceImp;
    }

    @GetMapping("/cars")
    public String getAllCars( Model model) {
        List<Car> list = carServiceImp.showAllCars();
        model.addAttribute("list", list);
        return "cars";
    }
    @GetMapping("/cars/{count}")
    public String showCars(@PathVariable("count") int count, Model model) {

        if (count >= 5) {
            List<Car> list = carServiceImp.showAllCars();
            model.addAttribute("list", list);
        } else {
            List<Car> list = carServiceImp.showAllCarsByCount(count);
            model.addAttribute("list", list);
        }

        return "cars";
    }

}
