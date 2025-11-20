/*
 * DOUBLEGSOFT.COM CONFIDENTIAL
 *
 * [2016] - [?] doublegsoft.com
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
package com.doublegsoft.jcommons.metabean;

import java.io.Serializable;

/**
 * Defined the extended properties for attritutes.
 * 
 * @author <a href="mailto:guo.guo.gan@gmail.com">Christian Gann</a>
 * 
 * @since 1.3
 * 
 * @version 3.0.1 - Added java serialization support on Feb 8, 2019. <br>
 */
public class ExtensionDefinition implements Serializable {
    
  private static final long serialVersionUID = -1L;
  
   public ExtensionDefinition() {

  }

  public ExtensionDefinition(final String code) {
    setExtension(code);
  }

  public ExtensionDefinition(int code) {
    throw new UnsupportedOperationException("the constructor will be supported in the future.");
  }

  /**
   * the attribute is automatic increment.
   * <p>
   * Code: A
   */
  private boolean automaticIncrement = false;

  /**
   * the attribute is boolean enumeration.
   * <p>
   * Code: B, Y means yes and N means no.
   */
  private boolean enumeratingBoolean;

  /**
   * the attribute is customizing code.
   * <p>
   * Code: C
   */
  private boolean customizingCode;

  /**
   * the attribute is applied to be a dimension.
   * <p>
   * Code: D
   */
  private boolean dimension;

  /**
   * the attribute is a customizing enumeration.
   * <p>
   * Code: E
   */
  private boolean enumeratingCustom;

  /**
   * the attribute is to store a general file as binary.
   * <p>
   * Code: F
   */
  private boolean binaryFile;

  /**
   * the attribute is applied to group.
   * <p>
   * Code: G, example for hint: orgcd is a group.
   */
  private boolean grouping;

  /**
   * the attribute is applied to index in database system.
   * <p>
   * Code: I
   */
  private boolean indexing;

  /**
   * the attribute is to store json-format text.
   * <p>
   * Code: J
   */
  private boolean textJson;

  /**
   * the attribute is an unique value.
   * <p>
   * Code: K
   */
  @Deprecated
  private boolean uniqueSingle;

  /**
   * the attribute is a link in business domain.
   * <p>
   * Code: L
   */
  private boolean link;

  /**
   * the attribute is to store multimedia binary file.
   * <p>
   * Code: M
   */
  private boolean binaryMultimedia;

  /**
   * the attribute is allowed to be null.
   * <p>
   * Code: N
   */
  private boolean nullable = true;

  /**
   * the attribute is to store a persistent object.
   * <p>
   * Code: O
   */
  private boolean persistentObject = true;

  /**
   * the attribute is parent relationship to its parent.
   * <p>
   * Code: P
   */
  private boolean parentRelative;

  /**
   * the attribute is applied to query.
   * <p>
   * Code: Q
   */
  private boolean queryable;

  /**
   * the attribute is required in business domain.
   * <p>
   * Code: R
   */
  private boolean required;

  /**
   * the attribute is a state enumeration.
   * <p>
   * Code: S
   */
  private boolean stateable;

  /**
   * the attribute is a timestamp.
   * <p>
   * Code: T
   */
  private boolean timestampable;

  /**
   * the attribute is real-only in business domain.
   * <p>
   * Code: U
   */
  private boolean unmodifiable;

  /**
   * the attribute is value-meaning.
   * <p>
   * Code: V
   */
  private boolean valueable;

  /**
   * the attribute is to store xml-format text.
   * <p>
   * Code: X
   */
  private boolean textXml;

  /**
   * the attribute is to store email.
   * <p>
   * Code: @
   */
  private boolean email;

  /**
   * the attribute is to store currency.
   * <p>
   * Code: $
   */
  private boolean currency;

  /**
   * the attribute is to store percentage value.
   * <p>
   * Code: %
   */
  private boolean percentage;

  /**
   * the attribute is to store mobile number.
   * <p>
   * Code: #
   */
  private boolean mobile;

  /**
   * the attribute is to store password.
   * <p>
   * Code: *
   */
  private boolean password;

  public boolean isAutomaticIncrement() {
    return automaticIncrement;
  }

  public void setAutomaticIncrement(boolean automaticIncrement) {
    this.automaticIncrement = automaticIncrement;
  }

  public boolean isEnumeratingBoolean() {
    return enumeratingBoolean;
  }

  public void setEnumeratingBoolean(boolean enumeratingBoolean) {
    this.enumeratingBoolean = enumeratingBoolean;
  }

  public boolean isCustomizingCode() {
    return customizingCode;
  }

  public void setCustomizingCode(boolean customizingCode) {
    this.customizingCode = customizingCode;
  }

  public boolean isDimension() {
    return dimension;
  }

  public void setDimension(boolean dimension) {
    this.dimension = dimension;
  }

  public boolean isEnumeratingCustom() {
    return enumeratingCustom;
  }

  public void setEnumeratingCustom(boolean enumeratingCustom) {
    this.enumeratingCustom = enumeratingCustom;
  }

  public boolean isBinaryFile() {
    return binaryFile;
  }

  public void setBinaryFile(boolean binaryFile) {
    this.binaryFile = binaryFile;
  }

  public boolean isGrouping() {
    return grouping;
  }

  public void setGrouping(boolean grouping) {
    this.grouping = grouping;
  }

  public boolean isIndexing() {
    return indexing;
  }

  public void setIndexing(boolean indexing) {
    this.indexing = indexing;
  }

  public boolean isTextJson() {
    return textJson;
  }

  public void setTextJson(boolean textJson) {
    this.textJson = textJson;
  }

  public boolean isUniqueSingle() {
    return uniqueSingle;
  }

  public void setUniqueSingle(boolean uniqueSingle) {
    this.uniqueSingle = uniqueSingle;
  }

  public boolean isLink() {
    return link;
  }

  public void setLink(boolean link) {
    this.link = link;
  }

  public boolean isBinaryMultimedia() {
    return binaryMultimedia;
  }

  public void setBinaryMultimedia(boolean binaryMultimedia) {
    this.binaryMultimedia = binaryMultimedia;
  }

  public boolean isPersistentObject() {
    return persistentObject;
  }

  public void setPersistentObject(boolean persistentObject) {
    this.persistentObject = persistentObject;
  }

  public boolean isParentRelative() {
    return parentRelative;
  }

  public void setParentRelative(boolean parentRelative) {
    this.parentRelative = parentRelative;
  }

  public boolean isQueryable() {
    return queryable;
  }

  public void setQueryable(boolean queryable) {
    this.queryable = queryable;
  }

  public boolean isRequired() {
    return required;
  }

  public void setRequired(boolean required) {
    this.required = required;
  }

  public boolean isStateable() {
    return stateable;
  }

  public void setStateable(boolean stateable) {
    this.stateable = stateable;
  }

  public boolean isTimestampable() {
    return timestampable;
  }

  public void setTimestampable(boolean timestampable) {
    this.timestampable = timestampable;
  }

  public boolean isUnmodifiable() {
    return unmodifiable;
  }

  public void setUnmodifiable(boolean unmodifiable) {
    this.unmodifiable = unmodifiable;
  }

  public boolean isValueable() {
    return valueable;
  }

  public void setValueable(boolean valueable) {
    this.valueable = valueable;
  }

  public boolean isTextXml() {
    return textXml;
  }

  public void setTextXml(boolean textXml) {
    this.textXml = textXml;
  }

  public boolean isNullable() {
    return nullable;
  }

  public void setNullable(boolean nullable) {
    this.nullable = nullable;
  }

  public boolean isEmail() {
    return email;
  }

  public void setEmail(boolean email) {
    this.email = email;
  }

  public boolean isCurrency() {
    return currency;
  }

  public void setCurrency(boolean currency) {
    this.currency = currency;
  }

  public boolean isPercentage() {
    return percentage;
  }

  public void setPercentage(boolean percentage) {
    this.percentage = percentage;
  }

  public boolean isMobile() {
    return mobile;
  }

  public void setMobile(boolean mobile) {
    this.mobile = mobile;
  }

  public boolean isPassword() {
    return password;
  }

  public void setPassword(boolean password) {
    this.password = password;
  }

  public final void setExtension(String extensionCode) {
    if (extensionCode == null) {
      return;
    }
    String upper = extensionCode.toUpperCase();
    if (upper.contains("A")) {
      automaticIncrement = true;
    }
    if (upper.contains("B")) {
      enumeratingBoolean = true;
    }
    if (upper.contains("C")) {
      customizingCode = true;
    }
    if (upper.contains("D")) {
      dimension = true;
    }
    if (upper.contains("E")) {
      enumeratingCustom = true;
    }
    if (upper.contains("F")) {
      binaryFile = true;
    }
    if (upper.contains("G")) {
      grouping = true;
    }
    if (upper.contains("I")) {
      indexing = true;
    }
    if (upper.contains("J")) {
      textJson = true;
    }
    if (upper.contains("K")) {
      uniqueSingle = true;
    }
    if (upper.contains("L")) {
      link = true;
    }
    if (upper.contains("M")) {
      binaryMultimedia = true;
    }
    if (upper.contains("N")) {
      nullable = false;
    }
    if (upper.contains("O")) {
      persistentObject = true;
    }
    if (upper.contains("P")) {
      parentRelative = true;
    }
    if (upper.contains("Q")) {
      queryable = true;
    }
    if (upper.contains("R")) {
      required = true;
    }
    if (upper.contains("S")) {
      stateable = true;
    }
    if (upper.contains("T")) {
      timestampable = true;
    }
    if (upper.contains("U")) {
      unmodifiable = true;
    }
    if (upper.contains("V")) {
      valueable = true;
    }
    if (upper.contains("X")) {
      textXml = true;
    }
    if (upper.contains("@")) {
      email = true;
    }
    if (upper.contains("#")) {
      mobile = true;
    }
    if (upper.contains("%")) {
      percentage = true;
    }
    if (upper.contains("$")) {
      currency = true;
    }
    if (upper.contains("*")) {
      password = true;
    }
  }
}
