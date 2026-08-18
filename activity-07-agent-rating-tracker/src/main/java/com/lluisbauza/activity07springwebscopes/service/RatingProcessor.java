package com.lluisbauza.activity07springwebscopes.service;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.RequestScope;

@Service
@RequestScope
public class RatingProcessor {

    private String agentName;
    private int rating;
    private String comment;

    public void setAgentName(String agentName) { this.agentName = agentName; }
    public void setRating(int rating) { this.rating = rating; }
    public void setComment(String comment) { this.comment = comment; }

    public boolean isValid() {
        return rating > 0 && rating <= 5
                && agentName != null && !agentName.isBlank();

    }

}
