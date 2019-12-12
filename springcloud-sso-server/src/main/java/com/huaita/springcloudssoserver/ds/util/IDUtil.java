package com.huaita.springcloudssoserver.ds.util;

import java.util.Date;

public class IDUtil
{
  public static final long getNextLongId()
  {
    Date date = new Date();
    long result = date.getTime();
    return result;
  }

  public static final String getUUIDStr(int len)
  {
    long varl = 0L;
    if (len > 32)
    {
      len = 32;
    }
    String UUID = Long.toHexString(new Date().getTime())
      .toUpperCase();
    UUID = UUID + Long.toHexString(varl);
    varl += 1L;

    while (UUID.length() < len)
    {
      String random = String.valueOf(Math.random());
      try
      {
        UUID = UUID + Long.toHexString(
          Long.parseLong(random.substring(2))).toUpperCase();
      }
      catch (NumberFormatException localNumberFormatException) {
      }
    }
    UUID = UUID.substring(0, len);
    return UUID;
  }

  public static final String getUUIDStr()
  {
    return getUUIDStr(32);
  }
}