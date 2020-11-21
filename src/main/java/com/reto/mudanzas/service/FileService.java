package com.reto.mudanzas.service;

import com.reto.mudanzas.exception.BusinessException;
import java.util.List;

public interface FileService {

    public List<Integer> read(byte[] file) throws BusinessException;

    public void create();

}
