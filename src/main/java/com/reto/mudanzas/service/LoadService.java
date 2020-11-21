package com.reto.mudanzas.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class LoadService {

    private List<Integer> elements;

    public LoadService() {
    }

    public void setElements(List<Integer> elements) {
        this.elements = elements;
    }

    public Integer getDays() {

        return this.elements.get(0);
    }

    public List<List<Integer>> getWeights() {
        List<List<Integer>> weights = new ArrayList<>();
        int j = 0;
        for (int i = 1; i < elements.size(); i++) {
            List<Integer> weightList = new ArrayList<>();
            int N = elements.get(i);
            for (j = i + 1; j <= (i + N); j++) {
                weightList.add(elements.get(j));
            }
            if (!weightList.isEmpty()) {
                weights.add(weightList);
            }
            i = j - 1;
        }

        return weights;

    }

    public List<List<Integer>> getNumberOfTrips(List<List<Integer>> weights) {

        for (List<Integer> weightList : weights) {
       

            System.out.println("max: " + Collections.max(weightList));
            System.out.println("min: " + Collections.min(weightList));

        }

        return null;

    }

    //
    private boolean checkWeight() {
        return false;
    }

}
