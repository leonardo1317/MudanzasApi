/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reto.mudanzas.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.boot.test.context.SpringBootTest;

/**
 *
 * @author leo
 */
@SpringBootTest
public class LoadServiceTest {
    
    public LoadServiceTest() {
    }

    @Test
    public void testSetElements() {
    }

    @Test
    public void testGetDays() {
    }

    @Test
    public void testGetWeights() throws Exception {
    }

    @Test
    public void testAdd() throws Exception {
         /*List<Integer> weightList = new ArrayList<>(
                Arrays.asList(32, 56, 76, 8, 44, 60, 47, 85, 71, 91));*/
         List<Integer> weightList = new ArrayList<>(
                Arrays.asList(30, 30, 1, 1));
        Collections.sort(weightList, Collections.reverseOrder()); 
             
             LoadService javaApplication9 = new LoadService();
             //System.out.println("----------------: "+ javaApplication9.(weightList));
        
        
    }
    
}
