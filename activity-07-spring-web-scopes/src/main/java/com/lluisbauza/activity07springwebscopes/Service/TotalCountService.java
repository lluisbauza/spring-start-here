package com.lluisbauza.activity07springwebscopes.Service;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;

@Service
@ApplicationScope
public class TotalCountService {

    private int totalCount;
    private int totalRating;

    public int getTotalCount() {
        return totalCount;
    }

    public int getTotalRating() {
        return totalRating;
    }

    public void increment() {
        totalCount++;
    }

    public void addRating(int rating) {
        totalRating += rating;
    }

    public double getAverageRating() {
        return (double) totalRating / totalCount;
    }
}
