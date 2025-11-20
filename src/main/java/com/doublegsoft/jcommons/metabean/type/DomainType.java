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
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * It's a business-domain type for any attributes.
 *
 * @author <a href="mailto:guo.guo.gan@gmail.com">Christian Gann</a>
 *
 * @since 1.2
 * 
 * @version 3.0.1 - Added java serialization support on Feb 8, 2019. <br>
 */
public class DomainType implements ObjectType, Serializable {
  
  private static final long serialVersionUID = -1L;
  
  @Deprecated
  public static DomainType getDomainType(String expr) {
    return new DomainType(expr);
  }

  private final Map<String, Object> options = new HashMap<>();

  private final String expression;

  private String name;
  
  private boolean array;

  /**
   * Constructor with the given expression.
   *
   * @param expr the domain type expression
   */
  public DomainType(String expr) {
    expression = expr;
    this.name = expr;
  }

  public void setName(String name) {
    this.name = name;
  }

  public boolean isArray() {
    return array;
  }

  public void setArray(boolean array) {
    this.array = array;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String getName() {
    return name;
  }

  /**
   * Adds an option to this domain type.
   *
   * @param name the name
   *
   * @param value the option value
   */
  public void addOption(String name, Object value) {
    options.put(name, value);
  }

  /**
   * Gets the option value with the name.
   *
   * @param name the option name
   *
   * @return the option value or {@code null}
   */
  public <T> T getOption(String name) {
    return (T) options.get(name);
  }
  
  public Map<String, Object> getOptions() {
    return Collections.unmodifiableMap(options);
  }

  /**
   * Gets the domain type expression.
   *
   * @return the expression
   */
  public String getExpression() {
    return expression;
  }

  @Override
  public String toString() {
    return expression;
  }

}
