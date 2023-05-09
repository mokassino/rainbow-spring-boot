package org.github.moka.rainbowspringboot;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.concurrent.ThreadLocalRandom; //Random number generator

@Controller
public class Rainbow {
    private RgbModel[] rainbow;

    public Rainbow(){
        this.rainbow = new RgbModel[7];
        for (int i=0; i < 7; i++){
            this.rainbow[i] = new RgbModel();
        }

        fillRainbow();
    }

    private void fillRainbow(){ //fill array of RGB Models with colors form the rainbow
        int[][] colors = {
            {255, 0, 0},      // Red
            {255, 127, 0},    // Orange
            {255, 255, 0},    // Yellow
            {0, 255, 0},      // Green
            {0, 0, 255},      // Blue
            {75, 0, 130},     // Violet
            {143, 0, 255}     // Purple
        };

        for (int i = 0; i < rainbow.length; i++) {
            rainbow[i].setModel(colors[i][0], colors[i][1], colors[i][2]);
        }
    }

    @GetMapping("/")
    public String index( @RequestParam(value = "name", defaultValue = "World") String name, Model model ) {

        int i = ThreadLocalRandom.current().nextInt(0,7);
        int [] rgb = this.rainbow[i].getModel();

        model.addAttribute("red", rgb[0]);
        model.addAttribute("green", rgb[1]);
        model.addAttribute("blue", rgb[2]);

        return "rainbow";
    }

}