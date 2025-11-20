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
 *
 * @author christian
 * 
 * @version 3.0.1 - Added java serialization support on Feb 8, 2019. <br>
 */
public enum RelationshipStyle implements Serializable {
    
  ONE_TO_ONE("1..1"),
  ONE_TO_MANY("1..*"),
  MANY_TO_ONE("*..1"),
  MANY_TO_MANY("*..*");

  private static final long serialVersionUID = -1L;

  /**
   * Gets the {@link RelationshipStyle} instance by the key.
   *
   * @param key the key
   *
   * @return the matching {@link RelationshipStyle} instance
   *
   * @throws IllegalArgumentException if not found with the key
   */
  public static RelationshipStyle getRelationshipStyle(String key) {
    for (RelationshipStyle s : RelationshipStyle.values()) {
      if (s.key.equalsIgnoreCase(key)) {
        return s;
      }
    }
    throw new IllegalArgumentException("unknown relationship style key: " + key);
  }

  public static RelationshipStyle reverseRelationshipStyle(RelationshipStyle style) {
    switch (style) {
      case ONE_TO_ONE:
        return ONE_TO_ONE;
      case ONE_TO_MANY:
        return MANY_TO_ONE;
      case MANY_TO_ONE:
        return ONE_TO_MANY;
      case MANY_TO_MANY:
        return MANY_TO_MANY;
    }
    throw new IllegalArgumentException("unknown relationship style key: " + style);
  }

  private final String key;

  private RelationshipStyle(String key) {
    this.key = key;
  }
}
