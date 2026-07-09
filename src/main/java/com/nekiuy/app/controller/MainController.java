package com.nekiuy.app.controller;

import com.nekiuy.app.model.People;
import com.nekiuy.app.model.Regiment;
import com.nekiuy.app.service.MainService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Slf4j
@Controller
public class MainController {

    private final MainService mainService;

    public MainController(MainService mainService) {
        this.mainService = mainService;
    }

    @GetMapping("/")
    public String getRegiments(Model model) {
        model.addAttribute("regiments", mainService.getAllEntity(Regiment.class));

        return "home";
    }

    @PostMapping("/add/rgt")
    public String addRegiment(@RequestParam String name,
                              @RequestParam int number)
    {
        Regiment regiment = new Regiment();
        regiment.setName(name);
        regiment.setNumber(number);
        mainService.saveEntity(regiment, Regiment.class);

        log.info("Создан полк {}", regiment.toString());
        return "redirect:/";
    }

    @PostMapping("/add/people")
    public String addPeople(@RequestParam String fullName,
                            @RequestParam int age,
                            @RequestParam String purpose,
                            @RequestParam int regimentId)
    {
        try {
            Regiment regiment = mainService.findEntity(regimentId, Regiment.class)
                    .orElseThrow(() -> new RuntimeException("Полк с id " + regimentId + " не найден"));

            People people = new People();
            people.setFullName(fullName);
            people.setAge(age);
            people.setPurpose(purpose);
            people.setRegiment(regiment);

            mainService.saveEntity(people, People.class);
            return "redirect:/";
        }
        catch (RuntimeException e) {
            log.error("Ошибка - {}", e.getMessage());
            return "redirect:/?error=" + e.getMessage();
        }
    }
}
