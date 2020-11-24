package com.reto.mudanzas.service.utils;

import com.reto.mudanzas.exception.BusinessException;
import java.io.IOException;
import java.time.Instant;
import org.springframework.web.multipart.MultipartFile;

public class Util {

    public static long currentTimeMillis() {
        Instant instant = Instant.now();
        return instant.toEpochMilli();
    }

    public static byte[] toByteArray(MultipartFile multipartFile) throws BusinessException {
        try {
            return multipartFile.getBytes();
        } catch (IOException ex) {
            throw new BusinessException(ex.getMessage());
        }

    }

}
