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

/**
 * Defines the object roles.
 * 
 * @author <a href="mailto:guo.guo.gan@gmail.com">Christian Gann</a>
 * 
 * @since 1.2
 * 
 * @version 3.0.1 - Added java serialization support on Feb 8, 2019. <br>
 */
public enum ObjectRole implements Serializable {
  
  ENTITY("N"),
  DATA("D"),
  RELATIOINSHIP("R"),
  ENUMERATION("E"),
  STATISTICS("S");
  
  private static final long serialVersionUID = -1L;
  
  /**
   * Gets the {@link ObjectRole} instance by the key.
   *
   * @param key the key
   *
   * @return the matching {@link ObjectRole} instance
   *
   * @throws IllegalArgumentException if not found with the key
   */
  public static ObjectRole getObjectRole(String key) {
    for (ObjectRole r : ObjectRole.values()) {
      if (r.key.equalsIgnoreCase(key)) {
        return r;
      }
    }
    throw new IllegalArgumentException("unknown object role key: " + key);
  }

  private final String key;

  private ObjectRole(String key) {
    this.key = key;
  }
    
}
