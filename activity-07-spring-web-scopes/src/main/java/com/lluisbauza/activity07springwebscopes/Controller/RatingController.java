package com.lluisbauza.activity07springwebscopes.Controller;

import com.lluisbauza.activity07springwebscopes.Service.RatingCountService;
import com.lluisbauza.activity07springwebscopes.Service.RatingProcessor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RatingController {

    private final RatingProcessor ratingProcessor;
    private final RatingCountService ratingCountService;

    public RatingController(RatingProcessor ratingProcessor, RatingCountService ratingCountService) {
        this.ratingProcessor = ratingProcessor;
        this.ratingCountService = ratingCountService;
    }

    @GetMapping("/rating")
    public String getRating() {
        return "rating.html";
    }

    @PostMapping("/rating")
    public String postRating(
            @RequestParam String agentName,
            @RequestParam int rating,
            @RequestParam String comment,
            Model model
    ) {

        if(ratingProcessor.validateRating(agentName, rating, comment)) {
            model.addAttribute("message", "Rating submitted");
            return "redirect:/summary";
        } else {
            model.addAttribute("message", "Invalid rating");
        }

        return "rating.html";
    }

    @GetMapping("/summary")
    public String getSummary(@RequestParam(required = false) String reset, Model model) {
        if (reset != null){
            ratingCountService.setCount(0);
        }
        model.addAttribute("ratingCount", ratingCountService.getCount());
        return "summary.html";
    }

}
