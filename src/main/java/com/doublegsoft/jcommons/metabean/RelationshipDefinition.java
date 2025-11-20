/*
 * DOUBLEGSOFT.COM CONFIDENTIAL
 *
 * [2016] - [?] doublegsoft.com
 *
 * All Rights Reserved.
 *
 * NOTICE:  All information contained herein is, and remains
 * the property of doublegsoft.com and its suppliers, if any.
 * The intellectual and technical concepts contained herein
 * are proprietary to doublegsoft.com and its suppliers  and
 * may be covered by China and Foreign Patents, patents in
 * process, and are protected by trade secret or copyright law.
 *
 * Dissemination of this information or reproduction of this material
 * is strictly forbidden unless prior written permission is obtained
 * from doublegsoft.com.
 */
package com.doublegsoft.jcommons.metabean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * It is the relationship definition for attribute linking to other reference object or attribute.
 * 
 * @since 1.0
 * 
 * @version 3.0.1 - add attribute reference on Feb 24, 2019.
 */
public class RelationshipDefinition implements Serializable {
    
  private static final long serialVersionUID = -1L;
  
  /**
   * the source attribute which link to others.
   */
  private AttributeDefinition source;

  private final Map<Prerequisite, List<Bounded>> boundedAttrs = new HashMap<>();

  private ObjectDefinition directTarget;

  private ObjectDefinition indirectTarget;

  private RelationshipStyle style;

  public AttributeDefinition getSource() {
    return source;
  }

  public void setSource(AttributeDefinition source) {
    this.source = source;
  }

  /**
   * Gets the direct target attribute referenced by the source attribute.
   *
   * @return the direct target attribute
   */
  public AttributeDefinition getTargetAttribute() {
    List<Bounded> boundedList = boundedAttrs.get(null);
    if (boundedList == null || boundedList.isEmpty()) {
      return null;
    }
    for (Bounded bounded : boundedList) {
      if (bounded.value.equals(source)) {
        return bounded.attribute;
      }
    }
    return null;
  }

  public Map<Object, AttributeDefinition> listPrerequisites() {
    Map<Object, AttributeDefinition> retVal = new HashMap<>();
    boundedAttrs.keySet().stream().filter((pre) -> (pre != null)).forEach((pre) -> {
      retVal.put(pre.value, pre.attribute);
    });
    return retVal;
  }

  /**
   * Gets the bounded target attributes which are referencing with constant values.
   *
   * @return the attributes
   */
  public Map<AttributeDefinition, Object> getBoundedTargetAttributesAndValues() {
    return getBoundedTargetAttributesAndValues(null, null);
  }

  /**
   * Gets the bounded target attributes which are referencing with constant values.
   *
   * @param prerequisiteAttr the prerequisite attribute
   *
   * @param prerequisiteValue the prerequisite value
   *
   * @return the attributes
   */
  public Map<AttributeDefinition, Object> getBoundedTargetAttributesAndValues(AttributeDefinition prerequisiteAttr, Object prerequisiteValue) {
    Prerequisite pre = null;
    if (prerequisiteAttr != null) {
      pre = new Prerequisite();
      pre.attribute = prerequisiteAttr;
      pre.value = prerequisiteValue;
    }
    Map<AttributeDefinition, Object> retVal = new HashMap<>();
    List<Bounded> boundedList = boundedAttrs.get(pre);
    if (boundedList == null) {
      return retVal;
    }
    boundedList.stream().filter((bounded) -> (!(bounded.value instanceof AttributeDefinition))).forEach((bounded) -> {
      retVal.put(bounded.attribute, bounded.value);
    });
    return retVal;
  }

  /**
   * Gets the bounded target attributes which are referenced by self attributes.
   *
   * @return the attributes
   */
  public Map<AttributeDefinition, AttributeDefinition> getBoundedTargetAttributesAndSelfAttributes() {
    return getBoundedTargetAttributesAndSelfAttributes(null, null);
  }

  /**
   * Gets the bounded target attributes which are referenced by self attributes.
   *
   * @param prerequisiteAttr the prerequisite attribute
   *
   * @param prerequisiteValue the prerequisite value
   *
   * @return the attributes
   */
  public Map<AttributeDefinition, AttributeDefinition> getBoundedTargetAttributesAndSelfAttributes(AttributeDefinition prerequisiteAttr, Object prerequisiteValue) {
    Prerequisite pre = null;
    if (prerequisiteAttr != null) {
      pre = new Prerequisite();
      pre.attribute = prerequisiteAttr;
      pre.value = prerequisiteValue;
    }
    Map<AttributeDefinition, AttributeDefinition> retVal = new HashMap<>();
    List<Bounded> boundedList = boundedAttrs.get(pre);
    if (boundedList == null) {
      return retVal;
    }
    boundedList.stream().filter((bounded) -> (bounded.value instanceof AttributeDefinition)).forEach((bounded) -> {
      retVal.put(bounded.attribute, (AttributeDefinition) bounded.value);
    });
    return retVal;
  }

  /**
   * Adds a bounded value or attribute.
   *
   * @param boundedAttr the bounded attribute
   *
   * @param boundedValue the bounded value is a constant or a {@link AttributeDefinition} instance
   */
  public void addBounded(AttributeDefinition boundedAttr, Object boundedValue) {
    addBounded(null, null, boundedAttr, boundedValue);
  }

  public void addBoundedByPersistenceName(String objectPersistenceName, String attributePersistenceName, Object prerequisiteValue, AttributeDefinition boundedAttr, Object boundedValue) {
    ModelDefinition model = source.getParent().getModel();
    AttributeDefinition prerequisiteAttr = model.findAttributeByPersistenceNames(objectPersistenceName, attributePersistenceName);
    addBounded(prerequisiteAttr, prerequisiteValue, boundedAttr, boundedValue);
  }

  /**
   * Adds a bounded value or attribute.
   *
   * @param prerequisiteAttr the prerequisite attribute
   *
   * @param prerequisiteValue the prerequisite value with the prerequisite attribute
   *
   * @param boundedAttr the bounded attribute
   *
   * @param boundedValue the bounded value is a constant or a {@link AttributeDefinition} instance
   */
  public void addBounded(AttributeDefinition prerequisiteAttr, Object prerequisiteValue, AttributeDefinition boundedAttr, Object boundedValue) {
    Prerequisite pre = null;
    if (prerequisiteAttr != null) {
      pre = new Prerequisite();
      pre.attribute = prerequisiteAttr;
      pre.value = prerequisiteValue;
    }
    List<Bounded> boundedList = boundedAttrs.get(pre);
    if (boundedList == null) {
      boundedList = new ArrayList<>();
      boundedAttrs.put(pre, boundedList);
    }
    Bounded bounded = new Bounded();
    bounded.attribute = boundedAttr;
    bounded.value = boundedValue;
    boundedList.add(bounded);
  }

  public RelationshipStyle getStyle() {
    return style;
  }

  public void setStyle(RelationshipStyle style) {
    this.style = style;
  }

  public ObjectDefinition getDirectTarget() {
    return directTarget;
  }

  public void setDirectTarget(ObjectDefinition directTarget) {
    this.directTarget = directTarget;
  }

  public ObjectDefinition getIndirectTarget() {
    return indirectTarget;
  }

  public void setIndirectTarget(ObjectDefinition indirectTarget) {
    this.indirectTarget = indirectTarget;
  }

  @Override
  public int hashCode() {
    int hash = 7;
    return hash;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    final RelationshipDefinition other = (RelationshipDefinition) obj;
    if (!Objects.equals(this.source, other.source)) {
      return false;
    }
    if (!Objects.equals(this.boundedAttrs, other.boundedAttrs)) {
      return false;
    }
    if (!Objects.equals(this.directTarget, other.directTarget)) {
      return false;
    }
    if (!Objects.equals(this.indirectTarget, other.indirectTarget)) {
      return false;
    }
    if (this.style != other.style) {
      return false;
    }
    return true;
  }

  private static class Prerequisite {

    AttributeDefinition attribute;

    Object value;

    @Override
    public int hashCode() {
      int hash = 5;
      return hash;
    }

    @Override
    public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      }
      if (obj == null) {
        return false;
      }
      if (getClass() != obj.getClass()) {
        return false;
      }
      final Prerequisite other = (Prerequisite) obj;
      if (!Objects.equals(this.attribute, other.attribute)) {
        return false;
      }
      if (!Objects.equals(this.value, other.value)) {
        return false;
      }
      return true;
    }
  }

  private static class Bounded {

    AttributeDefinition attribute;

    Object value;
  }

}
