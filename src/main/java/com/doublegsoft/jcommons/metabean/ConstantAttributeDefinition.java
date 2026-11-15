package com.doublegsoft.jcommons.metabean;

import com.doublegsoft.jcommons.metabean.type.PrimitiveType;

public class ConstantAttributeDefinition extends AttributeDefinition {

  public static final ModelDefinition CONSTANT_MODEL = new ModelDefinition();

  public static final ObjectDefinition CONSTANT_OBJECT = new ObjectDefinition("constant_object", CONSTANT_MODEL) {
    public void addAttribute(AttributeDefinition attr) {

    }
  };

  private final Object value;

  public ConstantAttributeDefinition(Object value) {
    super(value.toString(), CONSTANT_OBJECT);
    this.value = value;
    if (value instanceof String) {
      setType(new PrimitiveType(PrimitiveType.STRING));
    } else if (value instanceof Integer) {
      setType(new PrimitiveType(PrimitiveType.INTEGER));
    } else {
      throw new IllegalArgumentException("unsupported value type: " + value.getClass().getName());
    }
  }

  @Override
  public boolean isConstantValue() {
    return true;
  }
}
