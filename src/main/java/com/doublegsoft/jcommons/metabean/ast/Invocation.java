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

public class Invocation extends Value implements Statement {

  private String action;

  private Value location;

  private String format;

  private String text;

  private final List<Argument> arguments = new ArrayList<>();

  public Invocation action(String action) {
    this.action = action;
    return this;
  }

  public String action() {
    return action;
  }

  public Invocation location(Value location) {
    this.location = location;
    return this;
  }

  public Value location() {
    return location;
  }

  public Invocation format(String format) {
    this.format = format;
    return this;
  }

  public String format() {
    return format;
  }

  public Argument[] arguments() {
    return arguments.toArray(new Argument[arguments.size()]);
  }

  public Invocation argument(Argument argument) {
    arguments.add(argument);
    return this;
  }

  public Invocation text(String text) {
    this.text = text;
    return this;
  }

  @Override
  public String text() {
    return text;
  }

}
