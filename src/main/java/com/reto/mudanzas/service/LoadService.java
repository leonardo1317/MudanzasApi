package com.reto.mudanzas.service;

import com.reto.mudanzas.exception.BusinessException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class LoadService {

    public List<List<Integer>> getWeights(List<Integer> elements) throws BusinessException {
        List<List<Integer>> weights = new ArrayList<>();

        int days = elements.get(0);
        if (!checkDays(days)) {
            throw new BusinessException("Se encontro un número de dias con el valor: " + days
                    + " y solo se permiten valores entre 1 y 500");
        }

        for (int i = 1; i < elements.size(); i++) {
            int j = 0;
            int N = elements.get(i);
            if (!checkWeight(N)) {
                throw new BusinessException("Se encontró un elemento con el valor: " + N
                        + " y solo se permiten valores entre 1 y 100");
            }
            List<Integer> weightList = new ArrayList<>();

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

    public List<Integer> getNumberOfTrips(List<List<Integer>> weights) throws BusinessException {
        List<Integer> tripsList = new ArrayList<>();
        for (List<Integer> weightList : weights) {

            Integer greaterWeight = Collections.max(weightList);

            if (!checkWeight(greaterWeight)) {
                throw new BusinessException("Se encontró un elemento con peso: " + greaterWeight
                        + " y solo se permiten valores entre 1 y 100");
            }
            tripsList.add(calculateTrips(weightList));

        }

        return tripsList;

    }

    private int calculateTrips(List<Integer> weightList) {

        int maxValue = Collections.max(weightList);
        int element = 1;
        int trips = 0;

        weightList.remove(weightList.indexOf(maxValue));
        while ((element * maxValue) < 50) {

            if (!weightList.isEmpty()) {
                int minValue = Collections.min(weightList);
                weightList.remove(weightList.lastIndexOf(minValue));
                element++;
            } else {
                return trips;
            }
        }
        trips++;
        if (!weightList.isEmpty()) {
            trips += calculateTrips(weightList);
        }

        return trips;
    }

    private boolean checkWeight(int value) {
        return 1 <= value && value <= 100;
    }

    private boolean checkDays(int value) {
        return 1 <= value && value <= 500;
    }

}
