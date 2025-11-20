package com.doublegsoft.jcommons.metabean.ast;

public class Validation implements Statement {

  private String message;

  private Identifier variable;

  private boolean required;

  private boolean unique;

  private String format;

  private String text;

  public Validation(String text) {
    this.text = text;
  }

  public Validation message(String message) {
    this.message = message;
    return this;
  }

  public String message() {
    return message;
  }

  public Validation variable(Identifier variable) {
    this.variable = variable;
    return this;
  }

  public Identifier variable() {
    return variable;
  }

  public Validation format(String format) {
    this.format = format;
    return this;
  }

  public String format() {
    return format;
  }

  public Validation required(boolean required) {
    this.required = required;
    return this;
  }

  public boolean required() {
    return required;
  }

  public Validation unique(boolean unique) {
    this.unique = unique;
    return this;
  }

  public boolean unique() {
    return unique;
  }

  @Override
  public String text() {
    return null;
  }

}
