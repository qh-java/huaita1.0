package com.huaita.springcloudssoserver.ds.util;

import java.util.ResourceBundle;

public class Read
{
  private static String paths = "set";

  ResourceBundle resources = ResourceBundle.getBundle(paths);

  public static void setPath(String path)
  {
    setPaths(path);
  }

  private static void setPaths(String path)
  {
    paths = path;
  }

  public static String getMsg(String propertiesName, String key)
  {
    ResourceBundle resources = ResourceBundle.getBundle(propertiesName);
    return resources.getString(key);
  }

  public static String getMsg(String key)
  {
    return new Read().getMsgs(key);
  }


  private String getMsgs(String key)
  {
    return this.resources.getString(key);
  }
}