/*
 * DOUBLEGSOFT.COM CONFIDENTIAL
 *
 * [2023] - [?] doublegsoft.com
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
package com.doublegsoft.jcommons.metabean.ast;

import java.util.ArrayList;
import java.util.List;

public class Identifier extends Value {

  private final List<String> owners = new ArrayList<>();

  private String name;

  public Identifier(String text) {
    this.text = text;
    String[] strs = text.split("\\.");
    this.name = strs[strs.length - 1];
    for (int i = 0; i < strs.length - 1; i++) {
      owners.add(strs[i]);
    }
  }

  public String name() {
    return name;
  }

  public String owner() {
    StringBuilder retVal = new StringBuilder();
    for (String o : owners) {
      if (retVal.length() > 0) {
        retVal.append(".");
      }
      retVal.append(o);
    }
    return retVal.toString();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Identifier that = (Identifier) o;

    return text.equals(that.text);
  }

  @Override
  public int hashCode() {
    return text.hashCode();
  }

  @Override
  public String toString() {
    return text;
  }
}
