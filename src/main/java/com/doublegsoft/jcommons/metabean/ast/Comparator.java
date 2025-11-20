package com.doublegsoft.jcommons.metabean.ast;

public enum Comparator {

  NOT_LESS_THAN(">="),

  NOT_GREATER_THAN("<="),

  LESS_THAN("<"),

  GREATER_THAN(">"),

  EQUAL("=="),

  NOT_EQUAL("!=");

  public static Comparator parse(String text) {
    for (Comparator op : Comparator.values()) {
      if (text.equals(op.symbol)) {
        return op;
      }
    }
    return null;
  }

  private Comparator(String symbol) {
    this.symbol = symbol;
  }

  private final String symbol;

}
