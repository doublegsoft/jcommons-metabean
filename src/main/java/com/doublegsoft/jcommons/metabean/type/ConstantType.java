package com.doublegsoft.jcommons.metabean.type;

public class ConstantType implements ObjectType {

  private Object value;

  public ConstantType(String value) {
    try {
      this.value = Integer.valueOf(value);
    } catch (Throwable cause) {
      this.value = value;
    }
  }

  public Object getValue() {
    return value;
  }

  @Override
  public String getName() {
    if (value instanceof Integer) {
      return "int";
    }
    return "string";
  }

}
