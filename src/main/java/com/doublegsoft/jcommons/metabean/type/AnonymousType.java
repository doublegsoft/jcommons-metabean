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

import com.doublegsoft.jcommons.metabean.ModelDefinition;
import com.doublegsoft.jcommons.metabean.ObjectDefinition;
import java.io.Serializable;

/**
 * Represents an anonymouse type defined in object type.
 *
 * @author <a href="mailto:guo.guo.gan@gmail.com">Christian Gann</a>
 *
 * @since 3.0
 * 
 * @version 3.0.1 - Added java serialization support on Feb 8, 2019. <br>
 */
public class AnonymousType extends ObjectDefinition implements Serializable {
  
  private static final long serialVersionUID = -1L;
  
  private static final ModelDefinition FAKE = new ModelDefinition();
  
  public AnonymousType(String name) {
    super(name, FAKE);
  }
  
}
