package com.lluisbauza.activity07springwebscopes.Service;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.RequestScope;

@Service
@RequestScope
public class RatingProcessor {

    private final RatingCountService ratingCountService;
    private final TotalCountService totalCountService;
    private String agentName;
    private int rating;
    private String comment;

    public RatingProcessor(RatingCountService ratingCountService, TotalCountService totalCountService) {
        this.ratingCountService = ratingCountService;
        this.totalCountService = totalCountService;
    }

    public boolean validateRating(String agentName, int rating, String comment) {

        if(rating > 0 && rating <= 5) {
            ratingCountService.increment();
            totalCountService.increment();
            totalCountService.addRating(rating);

            return true;
        }

        return false;
    }

}
