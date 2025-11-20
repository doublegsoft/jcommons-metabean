package com.doublegsoft.jcommons.metabean.ast;

public class Argument {

  private Identifier name;

  private Value value;

  public Argument name(Identifier name) {
    this.name = name;
    return this;
  }

  public Identifier name() {
    return name;
  }

  public Argument value(Value value) {
    this.value = value;
    return this;
  }

  public Value value() {
    return value;
  }
}
