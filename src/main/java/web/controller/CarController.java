package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.service.CarServiceImpl;

import java.util.Optional;

@Controller
public class CarController {
    @Autowired
    private CarServiceImpl carServiceImpl;

    @GetMapping(value = "/cars")
    public String carsList(@RequestParam(value = "count") Optional<Integer> count, Model model) {
        model.addAttribute("cars", carServiceImpl.getCars(count.orElse(0)));
        return "cars";
    }
}
