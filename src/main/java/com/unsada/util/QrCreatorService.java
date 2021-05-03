package com.unsada.util;
import java.util.UUID;

public interface QrCreatorService {
  public static String generateQrId() {
    return UUID.randomUUID().toString().replace("-", "");
  }
}
