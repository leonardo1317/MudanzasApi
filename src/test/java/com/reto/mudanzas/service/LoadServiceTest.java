package com.reto.mudanzas.service;

import com.reto.mudanzas.exception.BusinessException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class LoadServiceTest {

    public LoadServiceTest() {
    }

    @Test
    public void testGetWeights() throws Exception {
        List<Integer> weightList = new ArrayList<>(
                Arrays.asList(5, 4, 30, 30, 1, 1, 10, 32, 56, 76, 8, 44, 60, 47, 85, 71, 91));
        
        //prueba que la cantidad de número de dias no supere el valor de 500 
        List<Integer> weightList2 = new ArrayList<>(
                Arrays.asList(700, 4, 30, 30, 1, 1, 10, 32, 56, 76, 8, 44, 60, 47, 85, 71, 91));
        
        //prueba que el número de los elementos no supere el valor de 100
        List<Integer> weightList3 = new ArrayList<>(
                Arrays.asList(5, 150, 30, 30, 1, 1, 10, 32, 56, 76, 8, 44, 60, 47, 85, 71, 91));

        LoadService loadService = new LoadService();

        assertTrue(loadService.getWeights(weightList).size() > 0);
        try {
            loadService.getWeights(weightList2);
        } catch (BusinessException ex) {
            assertNotNull(ex);
        }
        try {
            loadService.getWeights(weightList3);
        } catch (BusinessException ex) {
            assertNotNull(ex);
        }

    }

    @Test
    public void testGetNumberOfTrips() throws Exception {
        List<List<Integer>> weights = new ArrayList<>();
        List<Integer> weightList1 = new ArrayList<>(
                Arrays.asList(32, 56, 76, 8, 44, 60, 47, 85, 71, 91));
        List<Integer> weightList2 = new ArrayList<>(
                Arrays.asList(30, 30, 1, 1));
        
        List<Integer> weightList3 = new ArrayList<>(
                Arrays.asList(200, 30, 1, 1));
        
        weights.add(weightList1);
        weights.add(weightList2);
        
        LoadService loadService = new LoadService();
        assertTrue(loadService.getNumberOfTrips(weights).size() > 0);
        
        weights = new ArrayList<>();
        weights.add(weightList3);
        
          try {
            loadService.getNumberOfTrips(weights);
        } catch (BusinessException ex) {
            assertNotNull(ex);
        }

    }

}
