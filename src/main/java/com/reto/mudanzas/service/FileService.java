package com.reto.mudanzas.service;

import com.reto.mudanzas.exception.BusinessException;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class FileService {
    
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

    public String write(List<Integer> tripsList) {
        StringBuilder builder = new StringBuilder();
        String value = "Case #";
        for (int i = 0; i < tripsList.size(); i++) {

            builder.append(value)
                    .append(String.valueOf(i + 1))
                    .append(": ")
                    .append(tripsList.get(i));

            if (i < tripsList.size() - 1) {
                builder.append("\n");
            }
        }

        return builder.toString();

    }

}
