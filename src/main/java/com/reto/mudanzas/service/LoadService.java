package com.reto.mudanzas.service;

import com.reto.mudanzas.exception.BusinessException;
import com.reto.mudanzas.service.validation.BusinessValidation;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class LoadService {

    /**
     * Método para obtener los pesos de los elementos
     *
     * @param elements
     * @return
     * @throws BusinessException
     */
    public List<List<Integer>> getWeights(List<Integer> elements) throws BusinessException {
        List<List<Integer>> weights = new ArrayList<>();

        int days = elements.get(0);
        if (!BusinessValidation.checkDays(days)) {
            throw new BusinessException("Se encontro un número de dias con el valor: " + days
                    + " y solo se permiten valores entre 1 y 500");
        }

        for (int i = 1; i < elements.size(); i++) {
            int j = 0;
            int N = elements.get(i);
            if (!BusinessValidation.checkElementsQuantity(N)) {
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

    /**
     * Se obtiene el número de viajes deacuerdo a una lista de pesos agrupados
     * por día
     *
     * @param weights
     * @return
     * @throws BusinessException
     */
    public List<Integer> getNumberOfTrips(List<List<Integer>> weights) throws BusinessException {
        List<Integer> tripsList = new ArrayList<>();
        for (List<Integer> weightList : weights) {

            int maxWeight = Collections.max(weightList);

            if (!BusinessValidation.checkMaxWeight(maxWeight)) {
                throw new BusinessException("Se encontró un elemento con peso: " + maxWeight
                        + " y solo se permiten valores entre 1 y 100");
            }
            tripsList.add(calculateTrips(weightList));

        }

        return tripsList;

    }

    /**
     *
     * @param weightList
     * @return
     */
    private int calculateTrips(List<Integer> weightList) {

        int maxWeight = Collections.max(weightList);
        int element = 1;
        int trips = 0;

        weightList.remove(weightList.indexOf(maxWeight));
        while (BusinessValidation.checkTotalWeight(element, maxWeight)) {

            if (!weightList.isEmpty()) {
                int minWeight = Collections.min(weightList);
                weightList.remove(weightList.lastIndexOf(minWeight));
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

}
