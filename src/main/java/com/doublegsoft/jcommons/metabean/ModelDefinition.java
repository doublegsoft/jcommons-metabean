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
import java.util.ArrayList;
import java.util.List;

/**
 * The {@link ModelDefinition} type describes the metadata for the model of applications or frameworks.
 *
 * @author <a href="mailto:guo.guo.gan@gmail.com">Christian Gann</a>
 * 
 * @version 3.0.1 - Added java serialization support on Feb 8, 2019. <br>
 */
public class ModelDefinition implements Serializable {
    
  private static final long serialVersionUID = -1L;
  
  public static final ModelDefinition FAKE_MODEL = new ModelDefinition();

  /**
   * the application name.
   */
  private String applicationName;

  /**
   * the namespace for code.
   */
  private String namespace;

  /**
   * the meta objects.
   */
  private final List<ObjectDefinition> objects = new ArrayList<>();

  public ModelDefinition() {

  }

  public String getApplicationName() {
    return applicationName;
  }

  public void setApplicationName(String applicationName) {
    this.applicationName = applicationName;
  }

  public String getNamespace() {
    return namespace;
  }

  public void setNamespace(String namespace) {
    this.namespace = namespace;
  }

  public ObjectDefinition[] getObjects() {
    return objects.toArray(new ObjectDefinition[objects.size()]);
  }

  public ObjectDefinition findObjectByName(String name) {
    if (name == null) {
      return null;
    }
    for (ObjectDefinition obj : objects) {
      if (name.equalsIgnoreCase(obj.getName())) {
        return obj;
      }
    }
    return null;
  }

  public ObjectDefinition findObjectByPersistenceName(String persistenceName) {
    if (persistenceName == null) {
      return null;
    }
    for (ObjectDefinition obj : objects) {
      if (persistenceName.equalsIgnoreCase(obj.getPersistenceName())) {
        return obj;
      }
    }
    return null;
  }

  public AttributeDefinition findAttributeByNames(String objectName, String attributeName) {
    ObjectDefinition obj = findObjectByName(objectName);
    if (obj == null) {
      return null;
    }
    if (attributeName == null) {
      return null;
    }
    for (AttributeDefinition attr : obj.getAttributes()) {
      if (attributeName.equalsIgnoreCase(attr.getName())) {
        return attr;
      }
    }
    return null;
  }

  public AttributeDefinition findAttributeByPersistenceNames(String objectPersistenceName, String attributePersistenceName) {
    ObjectDefinition obj = findObjectByPersistenceName(objectPersistenceName);
    if (obj == null) {
      return null;
    }
    if (attributePersistenceName == null) {
      return null;
    }
    for (AttributeDefinition attr : obj.getAttributes()) {
      if (attributePersistenceName.equalsIgnoreCase(attr.getPersistenceName())) {
        return attr;
      }
    }
    return null;
  }

  /**
   * Finds the indirect relative object for the given base object, especially for many-to-many style and will adds more attributes to the base object
   * implicitly.
   *
   * @param base the base object
   *
   * @return all indirect relative objects
   */
  public ObjectDefinition[] findIndirectRelativeObjects(ObjectDefinition base) {
    List<ObjectDefinition> retVal = new ArrayList<>();
    for (ObjectDefinition obj : objects) {
      if (obj.getRole() != ObjectRole.RELATIOINSHIP) {
        continue;
      }
      ObjectDefinition matching = null;
      // find the matching indirect relative object
      for (AttributeDefinition attr : obj.getAttributes()) {
        RelationshipDefinition rel = attr.getDirectRelationship();
        if (rel == null) {
          continue;
        }
        if (rel.getDirectTarget().equals(base)) {
          matching = obj;
          break;
        }
      }
      if (matching != null) {
        for (AttributeDefinition attr : matching.getAttributes()) {
          RelationshipDefinition rel = attr.getDirectRelationship();
          if (rel == null || rel.getDirectTarget().equals(base)) {
            continue;
          }
          retVal.add(rel.getDirectTarget());
        }
      }
    }
    return retVal.toArray(new ObjectDefinition[retVal.size()]);
  }

  public void addObject(ObjectDefinition obj) {
    objects.add(obj);
  }
}
