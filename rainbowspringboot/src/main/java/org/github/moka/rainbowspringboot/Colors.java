package org.github.moka.rainbowspringboot;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.concurrent.ThreadLocalRandom; //Random number generator

@Controller
public class Colors {

    @GetMapping("/colors")
    public String index( Model model ) {

        int [] rgb = new int[3];
        rgb[0] = 0;
        rgb[1] = 0;
        rgb[2] = 0;

        while (rgb[0] == rgb[1] && rgb[1] == rgb[2] ){ //I don't want black or white
            for (int i=0; i<3; i++) {
                rgb[i]= 255*ThreadLocalRandom.current().nextInt(0,2);   
            }
        }

        model.addAttribute("red", rgb[0]);
        model.addAttribute("green", rgb[1]);
        model.addAttribute("blue", rgb[2]);

        return "rainbow";
    }
}