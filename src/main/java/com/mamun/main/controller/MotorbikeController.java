package com.mamun.main.controller;


import com.mamun.main.model.Motorbike;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MotorbikeController {
    private List<Motorbike> motorbikes = new ArrayList<>();
    private Long idCounter = 6L;

    public MotorbikeController() {
        motorbikes.add(new Motorbike(1L, "Honda CB500X", "Honda", " Red"));
        motorbikes.add(new Motorbike(2L, "Yamaha YZF-R6", "Yamaha", "Blue"));
        motorbikes.add(new Motorbike(3L, "Harley-Davidson Iron 883", "Harley-Davidson", "Black"));
        motorbikes.add(new Motorbike(4L, "Kawasaki Ninja 400", "Kawasaki", "Green"));
        motorbikes.add(new Motorbike(5L, "BMW R 1250 GS", "BMW", " White"));
    }



    @GetMapping("/")
    public String homePage(Model model) {
        model.addAttribute("motorbikes", motorbikes);
        return "motorbike-list";
    }
    @GetMapping("/motorbikes")
    public String getMotorbikes(Model model) {
        model.addAttribute("motorbikes", motorbikes);
        return "motorbike-list";
    }

    @GetMapping("/motorbikes/{id}")
    public String getMotorbike(@PathVariable Long id, Model model) {
        Motorbike motorbike = findMotorbikeById(id);
        if (motorbike != null) {
            model.addAttribute("motorbike", motorbike);
        }
        return "motorbike-details";
    }

    @GetMapping("/motorbikes/new")
    public String newMotorbikeForm(Model model) {
        model.addAttribute("motorbike", new Motorbike());
        return "add-motorbike";
    }

    @PostMapping("/motorbikes")
    public String createMotorbike(@ModelAttribute Motorbike motorbike) {
        motorbike.setId(idCounter++);
        motorbikes.add(motorbike);
        return "redirect:/motorbikes";
    }

    @GetMapping("/motorbikes/{id}/edit")
    public String editMotorbikeForm(@PathVariable Long id, Model model) {
        Motorbike motorbike = findMotorbikeById(id);
        if (motorbike != null) {
            model.addAttribute("motorbike", motorbike);
            return "edit-motorbike"; // Use the correct template name
        } else {
            return "redirect:/motorbikes";
        }
    }

    @PostMapping("/motorbikes/{id}")
    public String updateMotorbike(@PathVariable Long id, @ModelAttribute Motorbike updatedMotorbike) {
        Motorbike motorbike = findMotorbikeById(id);
        if (motorbike != null) {
            motorbike.setBikeName(updatedMotorbike.getBikeName());
            motorbike.setBrand(updatedMotorbike.getBrand());
            motorbike.setColor(updatedMotorbike.getColor());
        }
        return "redirect:/motorbikes";
    }

    @PostMapping("/motorbikes/{id}/delete")
    public String deleteMotorbike(@PathVariable Long id) {
        Motorbike motorbike = findMotorbikeById(id);
        if (motorbike != null) {
            motorbikes.remove(motorbike);
        }
        return "redirect:/motorbikes";
    }

    private Motorbike findMotorbikeById(Long id) {
        return motorbikes.stream()
                .filter(m -> m.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}