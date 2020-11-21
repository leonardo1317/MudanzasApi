package com.reto.mudanzas.service.utils;

import com.reto.mudanzas.exception.BusinessException;
import java.io.IOException;
import java.time.Instant;
import java.util.Base64;
import java.util.UUID;
import org.springframework.web.multipart.MultipartFile;

public class Util {

    public static String base64Decode(String content) throws BusinessException {
        try {
            byte[] decodedBytes = Base64.getDecoder().decode((content != null) ? content : "");
            return new String(decodedBytes);
        } catch (IllegalArgumentException ex) {
            throw new BusinessException("No fue posible decodificar el contenido del archivo", ex);
        }
    }

    public static String base64Encode(String content) {
        String encoded = "";
        if (content == null || content.length() == 0) {
            return encoded;
        } else {
            encoded = Base64.getEncoder().encodeToString(content.getBytes());
        }
        return encoded;
    }

    public static String toUUIDString() {
        return UUID.randomUUID().toString();
    }

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
