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

import com.doublegsoft.jcommons.metabean.type.DomainType;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Defines attribute or object validation.
 * 
 * @author <a href="mailto:guo.guo.gan@gmail.com">Christian Gann</a>
 * 
 * @since 1.0
 * 
 * @version 1.0.0 - Initial creation on 02/01/2013.<br>
 *          2.0.0 - Renamed to ConstraintDefinition from ValidationDefinition on 02/22/2013.<br>
 *          3.0.1 - Added java serialization support on Feb 8, 2019. <br>
 */
public class ConstraintDefinition implements Definition, Serializable {
    
  private static final long serialVersionUID = -1L;
  
    /**
   * it's identifiable.
   */
  private boolean identifiable;

  /**
   * value should be unique with others.
   */
  private boolean unique;

  /**
   * if the value type is string, is the min length of string.
   */
  private int minSize;

  /**
   * if the value type type is string, is the max length of string.
   */
  private int maxSize;

  /**
   * the number scale for number type.
   */
  private int scale;

  /**
   * if the value type type is number, is the min value.
   */
  private Number minValue;

  /**
   * if the value type type is number, is the max value.
   */
  private Number maxValue;

  /**
   * attribute field is readonly in UI.
   */
  private boolean readonly;

  /**
   * attribute field is non-visible for users.
   */
  private boolean system;

  /**
   * the default value for this attribute.
   */
  private Object defaultValue;

  /**
   * an attribute field is visible in UI.
   */
  private boolean visible;

  /**
   * the domain type for an attribute.
   */
  private DomainType domainType;

  /**
   * the data type for an attribute.
   */
  private String dataType;

  /**
   * the attributes is allowed to be null.
   */
  private boolean nullable = true;

  /**
   * the check values for an attribute.
   */
  private final List<Object> checkValues = new ArrayList<>();

  /**
   * an attribute with other attributes are an identifier for an object.
   */
  private final List<AttributeDefinition> identifiedWith = new ArrayList<>();

  /**
   * an attribute with other attributes are composed as an unique value.
   */
  private final List<AttributeDefinition> uniqueWith = new ArrayList<>();

  /**
   * an attribute within other attributes are an unique value.
   */
  private final List<AttributeDefinition> uniqueWithin = new ArrayList<>();

  /**
   * Checks a field is one of unique fields.
   * <p>
   * Example: <br>
   * a and b are combined unique fields for object o. And a is one of unique and also b is.
   *
   * @return the result of one of unique fields.
   */
  public boolean isOneOfUnique() {
    return !uniqueWith.isEmpty();
  }

  /**
   * Checks a field is unique within other fields.
   * <p>
   * Example: <br>
   * a, b, c are fields of object O. if c is unique within a and b, it means o1(a = 1, b = 1, c = 1) and o2(a = 1, b = 1, c != 1) should be ok. And if o2'c = 1,
   * it violates unique-within constraint.
   *
   * @return the result of having unique-within constraint
   */
  public boolean isWithinUnique() {
    return !uniqueWithin.isEmpty();
  }

  /**
   * Checks a field is one of identified fields.
   *
   * @return the result of one of identified fields
   */
  public boolean isOneOfIdentified() {
    return !identifiedWith.isEmpty();
  }

  public void addCheckValue(Object checkValue) {
    checkValues.add(checkValue);
  }

  public Object[] getCheckValues() {
    return checkValues.toArray();
  }

  public void addAttributeIdentifiedWith(AttributeDefinition attr) {
    identifiedWith.add(attr);
  }

  public AttributeDefinition[] getAttributesIdentifiedWith() {
    return identifiedWith.toArray(new AttributeDefinition[identifiedWith.size()]);
  }

  public void addAttributeUniqueWith(AttributeDefinition attr) {
    uniqueWith.add(attr);
  }

  public AttributeDefinition[] getAttributesUniqueWith() {
    return uniqueWith.toArray(new AttributeDefinition[uniqueWith.size()]);
  }

  public void addAttributeUniqueWithin(AttributeDefinition attr) {
    uniqueWithin.add(attr);
  }

  public AttributeDefinition[] getFieldsUniqueWithin() {
    return uniqueWithin.toArray(new AttributeDefinition[uniqueWithin.size()]);
  }

  public boolean isIdentifiable() {
    return identifiable;
  }

  public void setIdentifiable(boolean identifiable) {
    this.identifiable = identifiable;
  }

  public int getMaxSize() {
    return maxSize;
  }

  public void setMaxSize(int maxSize) {
    this.maxSize = maxSize;
  }

  public Number getMaxValue() {
    return maxValue;
  }

  public void setMaxValue(Number maxValue) {
    this.maxValue = maxValue;
  }

  public int getMinSize() {
    return minSize;
  }

  public void setMinSize(int minSize) {
    this.minSize = minSize;
  }

  public int getScale() {
    return scale;
  }

  public void setScale(int scale) {
    this.scale = scale;
  }

  public Number getMinValue() {
    return minValue;
  }

  public void setMinValue(Number minValue) {
    this.minValue = minValue;
  }

  public boolean isNullable() {
    return nullable;
  }

  public void setNullable(boolean nullable) {
    this.nullable = nullable;
  }

  public boolean isReadonly() {
    return readonly;
  }

  public void setReadonly(boolean readonly) {
    this.readonly = readonly;
  }

  public boolean isUnique() {
    return unique;
  }

  public void setUnique(boolean unique) {
    this.unique = unique;
  }

  public boolean isVisible() {
    return visible;
  }

  public void setVisible(boolean visible) {
    this.visible = visible;
  }

  public Object getDefaultValue() {
    return defaultValue;
  }

  public void setDefaultValue(Object defaultValue) {
    this.defaultValue = defaultValue;
  }

  public DomainType getDomainType() {
    return domainType;
  }

  public void setDomainType(DomainType domainType) {
    this.domainType = domainType;
  }

  public boolean isSystem() {
    return system;
  }

  public void setSystem(boolean system) {
    this.system = system;
  }

  public String getDataType() {
    return dataType;
  }

  public void setDataType(String dataType) {
    this.dataType = dataType;
  }
    
}
