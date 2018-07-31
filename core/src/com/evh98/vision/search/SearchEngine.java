package com.evh98.vision.search;

import com.evh98.vision.Vision;
import com.evh98.vision.card.Card;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;

public class SearchEngine {

    private final Vision vision;

    private final double similarityThreshold = 0.5;

    public SearchEngine(Vision vision) {
        this.vision = vision;
    }

    public ArrayList<Card> getResults(String query) {
        ArrayList<Card> results = new ArrayList<Card>();

        for (Card card : vision.cards.getCards()) {
            if (similarity(query, card.getTitle()) > similarityThreshold) {
                results.add(card);
            }
        }

        return results;
    }

    public double similarity(String s1, String s2) {
        String longer = s1, shorter = s2;
        if (s1.length() < s2.length()) {
            longer = s2; shorter = s1;
        }
        int longerLength = longer.length();
        if (longerLength == 0) {
            return 1.0;
        }
        return (longerLength - StringUtils.getLevenshteinDistance(longer, shorter)) / (double) longerLength;
    }
}
