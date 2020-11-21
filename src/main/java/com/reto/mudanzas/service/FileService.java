package com.reto.mudanzas.service;

import com.reto.mudanzas.exception.BusinessException;
import java.util.List;

public interface FileService {

    public List<Integer> read(String content) throws BusinessException;

    public void create();

}
