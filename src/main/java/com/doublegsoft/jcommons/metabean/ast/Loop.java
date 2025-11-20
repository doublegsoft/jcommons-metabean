package com.doublegsoft.jcommons.metabean.ast;

import java.util.ArrayList;
import java.util.List;

public class Loop implements Statement {

  private Value lower;

  private Value upper;

  private final List<Statement> statements = new ArrayList<>();

  public Loop lower(Value lower) {
    this.lower = lower;
    return this;
  }

  public Value lower() {
    return lower;
  }

  public Loop upper(Value upper) {
    this.upper = upper;
    return this;
  }

  public Value upper() {
    return upper;
  }

  public Loop statement(Statement statement) {
    this.statements.add(statement);
    return this;
  }

  public Statement[] statements() {
    return statements.toArray(new Statement[statements.size()]);
  }

  @Override
  public String text() {
    return null;
  }
}
