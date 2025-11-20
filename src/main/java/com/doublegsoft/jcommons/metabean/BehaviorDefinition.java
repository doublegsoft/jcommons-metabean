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

import com.doublegsoft.jcommons.metabean.ast.Statement;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Defines meta-behaviors for any objects.
 * 
 * @author <a href="mailto:guo.guo.gan@gmail.com">Christian Gann</a>
 * 
 * @since 2.0
 * 
 * @version 3.0.1 - Added java serialization support on Feb 8, 2019. <br>
 */
public class BehaviorDefinition extends ObjectDefinition implements Serializable {
  
  private static final long serialVersionUID = -1L;
  
  /**
   * the behavior name.
   */
  private final String name;

  /**
   * the owner object.
   */
  private final ObjectDefinition owner;

  /**
   * the behavior parameters.
   */
  private final List<AttributeDefinition> parameters = new ArrayList<>();

  /**
   * the return value.
   */
  private AttributeDefinition returnValue;

  /**
   * the behavior body like function body.
   */
  private String body;

  private final List<Statement> statements = new ArrayList<>();

  public BehaviorDefinition(String name, ObjectDefinition owner) {
    super(name, ModelDefinition.FAKE_MODEL);
    this.name = name;
    this.owner = owner;
    this.owner.addBehavior(this);
  }

  public AttributeDefinition getReturnValue() {
    return returnValue;
  }

  public void setReturnValue(AttributeDefinition returnValue) {
    this.returnValue = returnValue;
  }

  public String getBody() {
    return body;
  }

  public void setBody(String body) {
    this.body = body;
  }

  public AttributeDefinition[] getParameters() {
    return parameters.toArray(new AttributeDefinition[parameters.size()]);
  }

  public void addParameter(AttributeDefinition param) {
    parameters.add(param);
  }

  public Statement[] getStatements() {
    return statements.toArray(new Statement[statements.size()]);
  }

  public void addStatement(Statement stmt) {
    statements.add(stmt);
  }

}
