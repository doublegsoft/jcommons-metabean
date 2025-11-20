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

import com.doublegsoft.jcommons.metabean.ObjectDefinition;
import java.io.Serializable;

/**
 * Represents custom domain object's type.
 *
 * @author <a href="mailto:guo.guo.gan@gmail.com">Christian Gann</a>
 *
 * @since 1.0
 *
 * @version 1.0.0 - Initial creation on 02/15/2013.<br>
 *          1.1.0 - added objectDefinition field on Mar 14, 2013.<br>
 *          3.0.1 - Added java serialization support on Feb 8, 2019. <br>
 */
public class CustomType implements ObjectType, Serializable {
  
  private static final long serialVersionUID = -1L;
  
  /**
   * custom class identifier.
   */
  private final String name;

  private final ObjectDefinition objectDefinition;

  /**
   * Creates {@link CustomType} instance.
   *
   * @param name custom class identifier
   *
   * @param objectDefinition the object definition
   */
  public CustomType(String name, ObjectDefinition objectDefinition) {
    this.name = name;
    this.objectDefinition = objectDefinition;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String getName() {
    return name;
  }

  public ObjectDefinition getObjectDefinition() {
    return objectDefinition;
  }

}
