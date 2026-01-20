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

import com.doublegsoft.jcommons.metabean.type.CustomType;
import com.doublegsoft.jcommons.metabean.type.ObjectType;
import com.doublegsoft.jcommons.utils.Inflector;
import com.doublegsoft.jcommons.utils.Strings;
import java.io.Serializable;
import java.util.*;

/**
 * Defines all attributes which are used in object-oriented design.
 *
 * @author <a href="mailto:guo.guo.gan@gmail.com">Christian Gann</a>
 *
 * @since 1.0
 *
 * @version 1.0.0 - Initial creation on 02/01/2013. <br>
 *          1.1.0 - Implemented Pluralizable on Apr 5, 2013. <br>
 *          3.0.1 - Added java serialization support on Feb 8, 2019. <br>
 */
public class ObjectDefinition implements Definition, ObjectType, Cloneable, Serializable {
  
  private static final long serialVersionUID = -1L;
  
  private final ModelDefinition model;

  /**
   * the object name.
   */
  private String name;

  /**
   * the object alias name.
   */
  private String alias;

  /**
   * the user-readable text.
   */
  private String text;

  /**
   * singular for name.
   */
  private String singular;

  /**
   * the plural for this object name.
   */
  private String plural;

  /**
   * the persistence name means the name stored in database management systems, files or other storages.
   */
  private String persistenceName;

  /**
   * the module name which this object belongs to.
   */
  private String moduleName;

  /**
   * the labelled options like java annotation.
   */
  private final Map<String, Map<String, String>> labelledOptions = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);

  /**
   * the object role.
   */
  private ObjectRole role;

  private final ObjectType type;

  private final List<AttributeDefinition> attrDefs = new ArrayList<>();

  private final List<BehaviorDefinition> bxDefs = new ArrayList<>();

  private final Set<AttributeDefinition> attrDefCache = new HashSet<>();

  private final Set<RelationshipDefinition> relationships = new HashSet<>();
  
  /**
   * the source script.
   */
  private String script;

  public ObjectDefinition(String name, ModelDefinition model) {
    this.model = model;
    this.name = name;
    this.type = new CustomType(name, this);
    this.model.addObject(this);
  }

  public String getName() {
    if (name != null) {
      return name;
    } else {
      return persistenceName;
    }
  }

  public void setName(String name) {
    this.name = name;
  }

  public ObjectType getType() {
    return type;
  }

  public AttributeDefinition[] getAttributes() {
    return attrDefs.toArray(new AttributeDefinition[attrDefs.size()]);
  }

  public BehaviorDefinition[] getBehaviors() {
    return bxDefs.toArray(new BehaviorDefinition[bxDefs.size()]);
  }

  public void setPlural(String plural) {
    this.plural = plural;
  }

  public String getPlural() {
    if (plural == null) {
      String retVal = Inflector.getInstance().pluralize(getName());
      if (!retVal.equalsIgnoreCase(text)) {
        return retVal;
      }
      return getName() + "s";
    }
    return plural;
  }

  public String getSingular() {
    if (singular == null) {
      return getName();
    }
    return singular;
  }

  public String getModuleName() {
    return moduleName;
  }

  public void setModuleName(String moduleName) {
    this.moduleName = moduleName;
  }

  public String getPersistenceName() {
    return persistenceName;
  }

  public void setPersistenceName(String persistenceName) {
    this.persistenceName = persistenceName;
  }

  public ModelDefinition getModel() {
    return model;
  }

  public String getAlias() {
    return alias;
  }

  public void setAlias(String alias) {
    this.alias = alias;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  /**
   * Checks the {@link ObjectDefinition} object having an identifiable attribute.
   *
   * @return true or false
   */
  public boolean hasIdentifiableAttribute() {
    for (AttributeDefinition attr : attrDefs) {
      if (attr.isIdentifiable()) {
        return true;
      }
    }
    return false;
  }

  /**
   * Gets the identifiable attribute.
   *
   * @return identifiable {@link AttributeDefinition} instance or null
   */
  public AttributeDefinition getIdentifiableAttribute() {
    for (AttributeDefinition attr : attrDefs) {
      if (attr.isIdentifiable()) {
        return attr;
      }
    }
    return null;
  }

  public AttributeDefinition getAttribute(String attrname) {
    if (attrname == null) {
      return null;
    }
    for (AttributeDefinition attr : attrDefs) {
      if (attrname.equals(attr.getName())) {
        return attr;
      }
    }
    return null;
  }

  public ObjectRole getRole() {
    return role;
  }

  public void setRole(ObjectRole role) {
    this.role = role;
  }

  public RelationshipDefinition[] getRelationships() {
    return relationships.toArray(new RelationshipDefinition[relationships.size()]);
  }

  public ObjectDefinition[] getObjects(RelationshipStyle style) {
    List<ObjectDefinition> retVal = new ArrayList<>();
    for (RelationshipDefinition rd : relationships) {
      if (rd.getStyle() == style) {
        retVal.add(rd.getIndirectTarget());
      }
    }
    return retVal.toArray(new ObjectDefinition[retVal.size()]);
  }
  
  /**
   * Gets the first or only one label id for the label.
   * 
   * @param label
   *        the label name
   * 
   * @return the label id or {@code null}
   * 
   * @since 4.0
   */
  public String getLabelId(String label) {
    for (String key : labelledOptions.keySet()) {
      if (key.indexOf(label + "#") == 0) {
        return labelledOptions.get(key).get("id");
      }
    }
    return null;
  }
  
  /**
   * Gets the all label id list existing for the label.
   * 
   * @param label
   *        the label name
   * 
   * @return the label id list
   * 
   * @since 4.0
   */
  public List<String> getLabelIdList(String label) {
    List<String> retVal = new ArrayList<>();
    for (String key : labelledOptions.keySet()) {
      if (key.indexOf(label + "#") == 0) {
        retVal.add(labelledOptions.get(key).get("id"));
      }
    }
    return retVal;
  }
  
  public Map<String, Map<String, String>> getLabelledOptions() {
    return labelledOptions;
  }

  public boolean isLabelled(String label) {
    for (String key : labelledOptions.keySet()) {
      if (key.equalsIgnoreCase(label)) {
        return true;
      }
    }
    return false;
  }
  
  /**
   * Gets the labelled options with the label name and id.
   * 
   * @param label
   *        the label name
   * 
   * @return the labelled options
   * 
   * @since 4.0
   */
  public Map<String, String> getLabelledOptions(String label) {
    Map<String, String> retVal = labelledOptions.get(label);
    if (retVal == null) {
      return Collections.emptyMap();
    }
    return retVal;
  }
  
  /**
   * Gets the labelled options with the label name and id.
   * 
   * @param label
   *        the label name
   * 
   * @param id
   *        the id for label
   * 
   * @return the labelled options
   * 
   * @since 4.0
   */
  public Map<String, String> getLabelledOptions(String label, String id) {
    return getLabelledOptions(label + '#' + id);
  }
  
  /**
   * Sets the label and its option values, the id option may exists.
   * 
   * @param label
   *        the label name
   * 
   * @param options
   *        the option values
   * 
   * @since 4.0
   * 
   * @version 4.0.0 - added on id option value as key on Apr 9, 2019
   */
  public void setLabelledOptions(String label, Map<String, String> options) {
    String id = options.get("id");
    if (!Strings.isEmpty(id)) {
      this.labelledOptions.put(label + "#" + id, options);
    } else {
      this.labelledOptions.put(label, options);
    }
  }

  public void setLabelledOption(String label, String key, String value) {
    Map<String, String> options = labelledOptions.get(label);
    if (options == null) {
      options = new HashMap<>();
      labelledOptions.put(label, options);
    }
    options.put(key, value);
  }

  public void addLabelledOption(String label, String key, String value) {
    String rename = key;
    Map<String, String> options = labelledOptions.get(label);
    if (options == null) {
      options = new HashMap<>();
      labelledOptions.put(label, options);
    }
    for (int i = 0; i < 10; i++) {
      if (!options.containsKey(key + "_" + i)) {
        options.put(key + "_" + i, value);
        break;
      }
    }
  }

  public String getLabelledOption(String label, String key) {
    Map<String, String> options = labelledOptions.get(label);
    if (options == null) {
      return null;
    }
    return options.get(key);
  }

  public List<String> getLabelledOptionAsList(String label, String key) {
    List<String> retVal = new ArrayList<>();
    Map<String, String> options = labelledOptions.get(label);
    if (options == null) {
      return new ArrayList<>();
    }
    for (int i = 0; i < 10; i++) {
      if (options.containsKey(key + "_" + i)) {
        retVal.add(options.get(key + "_" + i));
      }
    }
    if (retVal.isEmpty()) {
      String val = options.get(key);
      if (val == null) {
        return retVal;
      }
      retVal.add(val);
    }
    return retVal;
  }

  public void setSingular(String singular) {
    this.singular = singular;
  }

  public String getScript() {
    return script;
  }

  public void setScript(String script) {
    this.script = script;
  }

  @Override
  public int hashCode() {
    int hash = 3;
    hash = 53 * hash + Objects.hashCode(this.getName());
    return hash;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    final ObjectDefinition other = (ObjectDefinition) obj;
    if (!Objects.equals(this.getName(), other.getName())) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "ObjectDefinition{" + "name=" + getName() + '}';
  }
  
  /**
   * Adds an attribute to this object.
   *
   * @param attr the attribute
   */
  public void addAttribute(AttributeDefinition attr) {
    if (attrDefCache.contains(attr)) {
      throw new IllegalArgumentException("the given attr[\"" + attr.getName() + "\"] already exists.");
    }
    attrDefs.add(attr);
    attrDefCache.add(attr);
  }

  void addBehavior(BehaviorDefinition bx) {
    bxDefs.add(bx);
  }

  /**
   * Adds indirect relative target.
   * <p>
   * The indirect target means: an attribute references another target, and the another target references the attributes parent indirectly.
   *
   * @param indirectTarget the indirect relative target
   *
   * @param style the relationship style
   */
  void addRelationship(ObjectDefinition indirectTarget, RelationshipStyle style) {
    RelationshipDefinition rd = new RelationshipDefinition();
    rd.setIndirectTarget(indirectTarget);
    rd.setStyle(style);
    relationships.add(rd);
    // many-to-many mapping
    for (ObjectDefinition obj : model.getObjects()) {
      for (RelationshipDefinition r : obj.getRelationships()) {
        ObjectDefinition io = r.getIndirectTarget();
        if (io == null || r.getStyle() != RelationshipStyle.ONE_TO_MANY) {
          continue;
        }
        for (AttributeDefinition a : io.getAttributes()) {
          RelationshipDefinition ar = a.getRelationship();
          if (ar == null) {
            continue;
          }
          ObjectDefinition dt = ar.getDirectTarget();
          if (!equals(dt) && dt != null && dt.getRole() == ObjectRole.ENTITY) {
            rd = new RelationshipDefinition();
            rd.setIndirectTarget(io);
            rd.setStyle(RelationshipStyle.MANY_TO_MANY);
            obj.addRelationship(rd);
          }
        }
      }
    }
  }

  /**
   * Adds the relationship.
   *
   * @param relationship the relationship
   */
  void addRelationship(RelationshipDefinition relationship) {
    relationships.add(relationship);
  }
}
