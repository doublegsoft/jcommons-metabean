package com.doublegsoft.jcommons.metabean;

import com.doublegsoft.jcommons.metabean.ast.Identifier;
import com.doublegsoft.jcommons.metabean.type.ObjectType;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class BehaviorContext {

  private final Map<String, Identifier> variants = new HashMap<>();

  public void addVariant(Identifier variant) {
    variants.put(variant.text(), variant);
  }

  public void setVariantType(String name, ObjectType type) {
    Identifier variant = variants.get(name);
    if (variant == null) {
      return;
    }
    variant.type(type);
  }

  public Identifier[] getVariants() {
    Collection coll = variants.values();
    return variants.values().toArray(new Identifier[coll.size()]);
  }

  public Identifier getVariant(String name) {
    return variants.get(name);
  }

}
