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
package com.doublegsoft.jcommons.metabean.type;

import java.io.Serializable;

/**
 * It is the type representation to sql type.
 * 
 * @author <a href="mailto:guo.guo.gan@gmail.com">Christian Gann</a>
 * 
 * @since 1.0
 * 
 * @version 1.0.0 - Initial creation on 02/01/2013.<br>
 *          3.0.1 - Added java serialization support on Feb 8, 2019. <br>
 */
public class DataType implements ObjectType, Serializable {
    
  private static final long serialVersionUID = -1L;
  
  private final String name;

  private final String expr;

  public DataType(String expr) {
    this.expr = expr.toLowerCase();
    int index = expr.indexOf("(");
    if (index != -1) {
      this.name = expr.substring(0, index).toLowerCase();
    } else {
      this.name = this.expr;
    }
  }

  @Override
  public String getName() {
    return name;
  }
    
}
