package com.huaita.springcloudssoserver.ds.entity;

public class Entity
{
  public static final String ACTION_ADD = "add";
  public static final String ACTION_EDIT = "edit";
  private String action;

  public String getAction()
  {
    return this.action;
  }

  public void setAction(String action)
  {
    this.action = action;
  }
}