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
 * It is the type representation to the high level abstraction of programming 
 * language native object type, 
 * 
 * @author <a href="mailto:guo.guo.gan@gmail.com">Christian Gann</a>
 * 
 * @since 2.0
 * 
 * @version 3.0.1 - Added java serialization support on Feb 8, 2019. <br>
 */
public class NativeType implements ObjectType, Serializable {
    
  private static final long serialVersionUID = -1L;
  
  /**
   * the module or framework name, specially for python, go etc.
   */
  private String moduleName;

  /**
   * the module or framework alias.
   */
  private String moduleAlias;

  /**
   * the dependency path, and the import or require path stated in source code, and it is the expression for the dependency.
   */
  private String dependencyPath;

  /**
   * the dependency library expressoin like gradle dependency expression, and used in package.json, maven, gradle etc build systems.
   */
  private String dependencyLibrary;

  /**
   * the canonical name.
   */
  private String canonicalName;

  /**
   * the simple name.
   */
  private String simpleName;

  @Override
  public String getName() {
    return simpleName;
  }

  public String getModuleName() {
    if (moduleName == null) {
      return moduleAlias;
    }
    return moduleName;
  }

  public void setModuleName(String moduleName) {
    this.moduleName = moduleName;
  }

  public String getModuleAlias() {
    if (moduleAlias == null) {
      return moduleName;
    }
    return moduleAlias;
  }

  public void setModuleAlias(String moduleAlias) {
    this.moduleAlias = moduleAlias;
  }

  public String getCanonicalName() {
    return canonicalName;
  }

  public void setCanonicalName(String canonicalName) {
    this.canonicalName = canonicalName;
  }

  public String getSimpleName() {
    return simpleName;
  }

  public void setSimpleName(String simpleName) {
    this.simpleName = simpleName;
  }

  public String getDependencyPath() {
    return dependencyPath;
  }

  public void setDependencyPath(String dependencyPath) {
    this.dependencyPath = dependencyPath;
  }

  public String getDependencyLibrary() {
    return dependencyLibrary;
  }

  public void setDependencyLibrary(String dependencyLibrary) {
    this.dependencyLibrary = dependencyLibrary;
  }

}
