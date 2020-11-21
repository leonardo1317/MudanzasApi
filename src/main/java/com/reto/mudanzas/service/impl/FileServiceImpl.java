package com.reto.mudanzas.service.impl;

import com.reto.mudanzas.exception.BusinessException;
import com.reto.mudanzas.service.FileService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class FileServiceImpl implements FileService {

    @Override
    public List<Integer> read(byte[] file) throws BusinessException {

        try {
            return new String(file).lines()
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (NumberFormatException ex) {
            throw new BusinessException(ex.getMessage());
        }
    }

    @Override
    public void create() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
