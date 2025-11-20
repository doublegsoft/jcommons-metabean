package com.doublegsoft.jcommons.metabean.ast;

import java.util.ArrayList;
import java.util.List;

public class If implements Statement {

  private Comparison comparison;

  private final List<Statement> statements = new ArrayList<>();

  /*
   * @reserved
   */
  private final List<If> elseifStatements = new ArrayList<>();

  private If $else;

  public If comparison(Comparison comparison) {
    this.comparison = comparison;
    return this;
  }

  public Comparison comparison() {
    return comparison;
  }

  public If statement(Statement statement) {
    this.statements.add(statement);
    return this;
  }

  public Statement[] statements() {
    return statements.toArray(new Statement[statements.size()]);
  }

  public If $else(If $else) {
    this.$else = $else;
    return this;
  }

  public If $else() {
    return $else;
  }

  @Override
  public String text() {
    return null;
  }
}
