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

public class Comparison {

  private Comparator comparator;

  private Identifier leftComparand;

  private Value rightComparand;

  public Comparison comparator(Comparator comparator) {
    this.comparator = comparator;
    return this;
  }

  public Comparison comparator(String comparator) {
    this.comparator = Comparator.parse(comparator);
    if (this.comparator == null) {
      throw new IllegalArgumentException("unknown \"" + comparator + "\" comparator.");
    }
    return this;
  }

  public Comparator comparator() {
    return comparator;
  }

  public Comparison left(Identifier leftComparand) {
    this.leftComparand = leftComparand;
    return this;
  }

  public Identifier left() {
    return leftComparand;
  }

  public Comparison right(Value rightComparand) {
    this.rightComparand = rightComparand;
    return this;
  }

  public Value right() {
    return rightComparand;
  }

}
