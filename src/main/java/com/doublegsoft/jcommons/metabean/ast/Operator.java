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

public enum Operator {

  ADDITION("+="),

  SUBTRACTION("-="),

  MULTIPLICATION("*="),

  DIVISION("/="),

  ASSIGNMENT("=");

  public static Operator parse(String text) {
    for (Operator op : Operator.values()) {
      if (text.equals(op.symbol)) {
        return op;
      }
    }
    return null;
  }

  private Operator(String symbol) {
    this.symbol = symbol;
  }

  private final String symbol;

}
