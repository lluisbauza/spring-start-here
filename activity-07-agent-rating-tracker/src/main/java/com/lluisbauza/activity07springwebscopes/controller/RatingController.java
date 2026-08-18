package com.lluisbauza.activity07springwebscopes.controller;

import com.lluisbauza.activity07springwebscopes.service.RatingCountService;
import com.lluisbauza.activity07springwebscopes.service.RatingProcessor;
import com.lluisbauza.activity07springwebscopes.service.TotalCountService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RatingController {

    private final RatingProcessor ratingProcessor;
    private final RatingCountService ratingCountService;
    private final TotalCountService totalCountService;

    public RatingController(
            RatingProcessor ratingProcessor,
            RatingCountService ratingCountService,
            TotalCountService totalCountService) {
        this.ratingProcessor = ratingProcessor;
        this.ratingCountService = ratingCountService;
        this.totalCountService = totalCountService;
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

        ratingProcessor.setAgentName(agentName);
        ratingProcessor.setRating(rating);
        ratingProcessor.setComment(comment);

        if (ratingProcessor.isValid()) {
            ratingCountService.increment();
            totalCountService.increment();
            totalCountService.addRating(rating);

            return "redirect:/summary";
        }

        model.addAttribute("message", "Invalid rating");
        return "rating.html";
    }

    @GetMapping("/summary")
    public String getSummary(@RequestParam(required = false) String reset, Model model) {
        if (reset != null){
            ratingCountService.setCount(0);
        }

        model.addAttribute("ratingCount", ratingCountService.getCount());
        model.addAttribute("totalRatingCount", totalCountService.getTotalCount());
        model.addAttribute("averageRating", totalCountService.getAverageRating());

        return "summary.html";
    }

}
