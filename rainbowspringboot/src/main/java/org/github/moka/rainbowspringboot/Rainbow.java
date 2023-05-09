package org.github.moka.rainbowspringboot;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.concurrent.ThreadLocalRandom; //Random number generator

@Controller
public class Rainbow {
    private RgbModel[] rainbow = new RgbModel[7];

    public Rainbow(){
        int[][] colors = {
            {255, 0, 0},      // Red
            {255, 127, 0},    // Orange
            {255, 255, 0},    // Yellow
            {0, 255, 0},      // Green
            {0, 0, 255},      // Blue
            {75, 0, 130},     // Violet
            {143, 0, 255}     // Purple
        };

        for (int i=0; i < rainbow.length; i++){
            this.rainbow[i] = new RgbModel(colors[i][0], colors[i][1], colors[i][2]);
        }

    }

    @GetMapping("/")
    public String index(Model model ) {

        int i = ThreadLocalRandom.current().nextInt(0,7); // Select a random color from the rainbow
        int [] rgb = this.rainbow[i].getModel();

        //Add attributes to templates/rainbow.html
        model.addAttribute("red", rgb[0]);
        model.addAttribute("green", rgb[1]);
        model.addAttribute("blue", rgb[2]);

        return "rainbow"; //Returns rainbow model
    }

}