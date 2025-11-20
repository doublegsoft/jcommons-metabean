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

import com.doublegsoft.jcommons.metabean.type.ObjectType;
import com.doublegsoft.jcommons.metabean.type.PrimitiveType;
import com.doublegsoft.jcommons.utils.SafeDateTime;
import com.doublegsoft.jcommons.utils.SafeNumber;

public class Value implements Statement {

  protected ObjectType type;

  protected String constant;

  protected String text;

  public Value(String text) {
    this.text = text;
    if (text.indexOf("'") == 0) {
      type = new PrimitiveType(PrimitiveType.STRING);
      constant = text.substring(1, text.length() - 1);
    } else if (SafeNumber.safeBigDecimal(text) != null) {
      type = new PrimitiveType(PrimitiveType.NUMBER);
      constant = text;
    } else if (SafeDateTime.safeDate(text) != null) {
      type = new PrimitiveType(PrimitiveType.DATE);
      constant = text;
    }
  }

  public Value() {

  }

  public Value constant(String constant) {
    this.constant = constant;
    return this;
  }

  public String constant() {
    return constant;
  }

  public Value type(ObjectType type) {
    this.type = type;
    return this;
  }

  public ObjectType type() {
    return type;
  }

  @Override
  public String toString() {
    return constant;
  }

  @Override
  public String text() {
    return text;
  }
}
