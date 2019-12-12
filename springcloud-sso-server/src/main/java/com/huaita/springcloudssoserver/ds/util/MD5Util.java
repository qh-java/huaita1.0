package com.huaita.springcloudssoserver.ds.util;


public class MD5Util
{
  public static String fnDefaultEncrypt(String inputPwd)
  {
    return fnEncrypt(inputPwd, "00linkage");
  }

  public static String fnEncrypt(String InputPwd, String ParaPwd)
  {
    long bytes = 6L; long retlen = 6L;
    long randSeed1 = 23456L;
    long randSeed2 = 31212L;
    long randSeed3 = 1029L;
    long modSeed = 32768L;
    long[] mm = new long[101];
    char tempChar = '\000';
    char tempChar1 = '\000';
    char tempChar2 = '\000';
    String cmm = ""; String pwd = "";
    String result = "";

    if ((InputPwd == null) || (InputPwd.length() <= 0)) {
      return null;
    }
    if ((ParaPwd == null) || (ParaPwd.length() <= 0)) {
      return null;
    }
    pwd = InputPwd + ParaPwd;

    long longtmp = 0L;
    int length = pwd.length();
    for (int i = 1; i <= length; i++) {
      tempChar = pwd.charAt(i - 1);
      longtmp = tempChar;
      randSeed1 = (randSeed1 + longtmp * i) % modSeed;
      randSeed2 = (randSeed2 + longtmp * (length - i)) % (modSeed / 4L) * 2L;
      randSeed3 = (randSeed3 + longtmp * longtmp) % (modSeed / 4L) * 2L + 1L;
    }

    InputPwd = pwd;
    if (bytes > 10L) {
      bytes = 10L;
    }
    length = InputPwd.length();

    if (length <= bytes)
    {
      for (length++; length <= bytes; length++) {
        randSeed1 = (randSeed1 * randSeed2 + randSeed3) % modSeed;
        longtmp = randSeed1 % 126L;
        if (longtmp < 33L) {
          longtmp += 65L;
        }
        InputPwd = InputPwd + (char)(int)longtmp;
      }
    }

    length = ParaPwd.length();

    if (length <= bytes)
    {
      for (length++; length <= bytes; length++) {
        randSeed1 = (randSeed1 * randSeed2 + randSeed3) % modSeed;
        longtmp = randSeed1 % 126L;
        if (longtmp < 33L) {
          longtmp += 65L;
        }
        ParaPwd = ParaPwd + (char)(int)longtmp;
      }

    }

    longtmp = (randSeed1 * randSeed2 + randSeed3) % modSeed;
    for (int j = 1; j <= bytes; j++) {
      for (int k = 1; k <= bytes; k++) {
        tempChar1 = InputPwd.charAt(j - 1);
        tempChar2 = ParaPwd.charAt(j - 1);
        longtmp = (longtmp * randSeed1 + tempChar1 * tempChar2 * j) % 
          modSeed;
        if (longtmp >= modSeed / 2L) {
          randSeed1 = (randSeed1 * randSeed2 + randSeed3) % modSeed;
          mm[((int)(randSeed1 % (bytes * bytes)))] = randSeed1;
        } else {
          randSeed1 = (randSeed1 * (randSeed3 + 1L) + randSeed2 + 1L) % 
            modSeed;
          mm[((int)(randSeed1 % (bytes * bytes)))] = randSeed1;
        }
      }
    }

    for (int k = (int)(bytes * bytes); k >= 1; k--) {
      if (k > 1) {
        mm[(k - 1)] += mm[k] / 256L;
      }
    }

    for (int k = 1; k <= bytes * bytes; k++) {
      randSeed1 = randSeed1 * randSeed1 % modSeed;
      if (mm[k] == 0L) {
        mm[k] = randSeed1;
      }

    }

    for (int k = 1; k <= bytes; k++) {
      for (int i = 1; i <= bytes; i++) {
        tempChar1 = InputPwd.charAt(i - 1);
        tempChar2 = ParaPwd.charAt(k - 1);
        longtmp = mm[((int)(i + (k - 1) * bytes))] * tempChar2 * tempChar1 % 62L;
        if (longtmp < 10L) {
          cmm = cmm + (char)(int)(longtmp + 48L);
        }
        else if (longtmp < 36L) {
          cmm = cmm + (char)(int)(longtmp - 10L + 97L);
        }
        else if (longtmp < 62L)
          cmm = cmm + (char)(int)(longtmp - 36L + 65L);
        else {
          cmm = cmm + "_";
        }

      }

    }

    result = cmm.substring(0, (int)retlen);
    return result;
  }

  public static void main(String[] args) {
    System.out.println("----pwd=" + 
      fnEncrypt("12345", "00linkage"));
  }
}