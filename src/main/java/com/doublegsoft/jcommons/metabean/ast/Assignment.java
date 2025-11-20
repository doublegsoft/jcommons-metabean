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

public class Assignment implements Statement {

  private Identifier assignee;

  private Value operand;

  private Operator operator;

  public Assignment assignee(Identifier assignee) {
    this.assignee = assignee;
    return this;
  }

  public Identifier assignee() {
    return assignee;
  }

  public Assignment operator(Operator operator) {
    this.operator = operator;
    return this;
  }

  public Assignment operator(String operator) {
    this.operator = Operator.parse(operator);
    if (this.operator == null) {
      throw new IllegalArgumentException("unknown \"" + operator + "\" comparator.");
    }
    return this;
  }

  public Operator operator() {
    return operator;
  }

  public Assignment operand(Value operand) {
    this.operand = operand;
    return this;
  }

  public Value operand() {
    return operand;
  }

  @Override
  public String text() {
    return null;
  }
}
