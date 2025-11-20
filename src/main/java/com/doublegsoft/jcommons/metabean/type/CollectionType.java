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
 * Represents collection object's type.
 *
 * @author <a href="mailto:guo.guo.gan@gmail.com">Christian Gann</a>
 *
 * @since 1.0
 *
 * @version 1.0.0 - Initial creation on 02/01/2013. <br>
 *          1.1.0 - Removed constants and made constructor public on 02/20/2013. <br>
 *          3.0.1 - Added java serialization support on Feb 8, 2019. <br>
 */
public class CollectionType implements ObjectType, Serializable {
  
  private static final long serialVersionUID = -1L;
  
  /**
   * identifier name.
   */
  private final String name;

  /**
   * component type in container.
   */
  private ObjectType componentType;

  /**
   * Creates a {@link CollectionType} instance.
   *
   * @param name identifier name
   */
  public CollectionType(String name) {
    this.name = name;
  }

  /**
   * Sets the component type.
   *
   * @param componentType component type in container
   */
  public void setComponentType(ObjectType componentType) {
    this.componentType = componentType;
  }

  /**
   * if {@code this} is a set type like {@link java.util.Collection},
   * {@link java.util.Set} etc, gets the component type in set type; if not, it is null.
   *
   * @return component type
   */
  public ObjectType getComponentType() {
    return componentType;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String getName() {
    return name;
  }

}
