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
package com.doublegsoft.jcommons.metabean.type;

import java.io.Serializable;

/**
 * Represents primitive object's type.
 *
 * @author <a href="mailto:guo.guo.gan@gmail.com">Christian Gann</a>
 *
 * @since 3.0
 *
 * @version 1.0.0 - Initial creation on 02/01/2013. <br>
 *          1.1.0 - Added more types on Apr 6, 2013. <br>
 *          3.0.0 - Change type to interface.
 *          3.0.1 - Added java serialization support on Feb 8, 2019. <br>
 */
public class PrimitiveType implements ObjectType, Serializable {
  
  private static final long serialVersionUID = -1L;
  
  public static final String STRING = "string";
  
  public static final String NUMBER = "number";
  
  public static final String DATETIME = "datetime";
  
  public static final String DATE = "date";
  
  public static final String TIME = "time";
  
  public static final String BOOL = "bool";
  
  public static final String INTEGER = "int";
  
  public static final String LONG = "long";
  
  private final String name;
  
  private int length;
  
  private int precision;
  
  private int scale;
  
  public PrimitiveType(String name) {
    this.name = name;
  }
  
  @Override
  public String getName() {
    return name;
  }

  public int getLength() {
    return length;
  }

  public void setLength(int length) {
    this.length = length;
  }

  public int getPrecision() {
    return precision;
  }

  public void setPrecision(int precision) {
    this.precision = precision;
  }

  public int getScale() {
    return scale;
  }

  public void setScale(int scale) {
    this.scale = scale;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    PrimitiveType that = (PrimitiveType) o;

    if (length != that.length) return false;
    if (precision != that.precision) return false;
    if (scale != that.scale) return false;
    return name.equals(that.name);
  }

  @Override
  public int hashCode() {
    int result = name.hashCode();
    result = 31 * result + length;
    result = 31 * result + precision;
    result = 31 * result + scale;
    return result;
  }
}
