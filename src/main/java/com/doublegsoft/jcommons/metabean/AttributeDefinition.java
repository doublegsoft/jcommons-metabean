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

import com.doublegsoft.jcommons.metabean.type.ObjectType;
import com.doublegsoft.jcommons.utils.Inflector;
import com.doublegsoft.jcommons.utils.Strings;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;

/**
 * Defines meta-attributes for any attribute in object.
 *
 * @author <a href="mailto:guo.guo.gan@gmail.com">Christian Gann</a>
 *
 * @since 1.0
 *
 * @version 1.0.0 - Initial creation on 02/01/2013. <br>
 *          1.1.0 - Changed modifier of the name, added a constructor with it on 02/19/2013. <br>
 *          1.2.0 - Implemented Pluralizable on Apr 5, 2013. <br>
 *          3.0.1 - Added java serialization support on Feb 8, 2019. <br>
 *          3.0.2 - Added bounded attribute for the source in a relationship on Feb 24, 2019. <br>
 */
public class AttributeDefinition implements Definition, Serializable {
  
  private final static long serialVersionUID = -1L;
  
  /**
   * the attribute name.
   */
  private final String name;

  /**
   * the attribute alias name.
   */
  private String alias;

  /**
   * the attribute user-readable text.
   */
  private String text;

  /**
   * the parent object.
   */
  private final ObjectDefinition parent;

  /**
   * the persistence name means the name stored in database management systems, files or other storages.
   */
  private String persistenceName;

  /**
   * singular for name.
   */
  private String singular;

  /**
   * plural for name.
   */
  private String plural;

  /**
   * the attribute object type.
   */
  private ObjectType type;

  /**
   * the attribute value unit.
   */
  private String unit;

  /**
   * the labelled options like java annotation.
   */
  private final Map<String, Map<String, String>> labelledOptions = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);

  /**
   * the relationship which this attribute has.
   */
  private final Set<RelationshipDefinition> relationships = new HashSet<>();

  /**
   * the attribute constraint.
   */
  private final ConstraintDefinition constraint = new ConstraintDefinition();

  /**
   * the attribute extension.
   */
  private final ExtensionDefinition extension = new ExtensionDefinition();

  public AttributeDefinition(String name, ObjectDefinition parent) {
    this.name = name;
    this.parent = parent;
    this.parent.addAttribute(this);
  }

  /**
   * Checks this attribute is identifiable for its parent object or one of identifiers of its parent object.
   *
   * @return the identifiable or not
   */
  public boolean isIdentifiable() {
    return constraint.isIdentifiable() || constraint.isOneOfIdentified();
  }

  public String getName() {
    if (name != null) {
      return name;
    }
    return persistenceName;
  }

  public ObjectType getType() {
    return type;
  }

  public void setType(ObjectType type) {
    this.type = type;
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

  public void setSingular(String singular) {
    this.singular = singular;
  }

  public String getSingular() {
    if (singular == null) {
      return getName();
    }
    return singular;
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

  public String getPersistenceName() {
//        if (persistenceName != null) {
//            return persistenceName;
//        }
    return persistenceName;
  }

  public void setPersistenceName(String persistenceName) {
    this.persistenceName = persistenceName;
  }

  public ConstraintDefinition getConstraint() {
    return constraint;
  }

  public ExtensionDefinition getExtension() {
    return extension;
  }

  public ObjectDefinition getParent() {
    return parent;
  }

  public RelationshipDefinition getRelationship() {
    if (relationships.size() >= 1) {
      Iterator<RelationshipDefinition> ite = getRelationships();
      return ite.next();
    }
    return null;
  }

  public Iterator<RelationshipDefinition> getRelationships() {
    return relationships.iterator();
  }

  public RelationshipDefinition getDirectRelationship() {
    for (RelationshipDefinition rel : relationships) {
      if (rel.getDirectTarget() != null) {
        return rel;
      }
    }
    return null;
  }

  public Set<RelationshipDefinition> getIndirectRelationships() {
    Set<RelationshipDefinition> retVal = new HashSet<>();
    for (RelationshipDefinition rel : relationships) {
      if (rel.getIndirectTarget() != null) {
        retVal.add(rel);
      }
    }
    return retVal;
  }

  public int getRelationshipCount() {
    return relationships.size();
  }

  public String getUnit() {
    return unit;
  }

  public void setUnit(String unit) {
    this.unit = unit;
  }

  /**
   * Sets the direct relationship.
   * <p>
   *
   * For example:
   * <p>
   * {@code
   * A.BCD -> B.CD (*..1)
   * }
   *
   * @param directTarget the direct relative target
   *
   * @param style the relationship style
   */
  public void addRelationship(ObjectDefinition directTarget, RelationshipStyle style) {
    RelationshipDefinition relationship = new RelationshipDefinition();
    relationship.setSource(this);
    relationship.setDirectTarget(directTarget);
    relationship.setStyle(style);
    // tree-like 
    if (parent.equals(directTarget)) {
      RelationshipDefinition rd = new RelationshipDefinition();
      rd.setIndirectTarget(directTarget);
      rd.setStyle(RelationshipStyle.ONE_TO_MANY);
      parent.addRelationship(rd);
    }
    // many-to-many for entity
    if (directTarget != null && directTarget.getRole() == ObjectRole.ENTITY) {
      directTarget.addRelationship(parent, RelationshipStyle.reverseRelationshipStyle(style));
    }
    relationships.add(relationship);
  }
  
  /**
   * Adds a relationship to {@code this} attribute.
   * 
   * @param directTargetAttribute
   *        the relative direct target attribute, etc. an entity id
   * 
   * @param style 
   *        the relationship style
   * 
   * @version 3.0.1 - DO NOT REVERSE RELATIONSHIP STYLE
   */
  public void addRelationship(AttributeDefinition directTargetAttribute, RelationshipStyle style) {
    if (directTargetAttribute == null) {
      System.err.println("not found direct target object or attribute: " + getParent().getName() + "[" + getName() + "]");
      return;
    }
    
    RelationshipDefinition rd = new RelationshipDefinition();
    if (style == RelationshipStyle.MANY_TO_ONE || style == RelationshipStyle.ONE_TO_ONE) {
      rd.setSource(this);
      rd.setDirectTarget(directTargetAttribute.getParent());
      rd.addBounded(directTargetAttribute, this);
      relationships.add(rd);
    } else {
      addRelationship(directTargetAttribute.getParent(), style);
      rd.setSource(directTargetAttribute);
      rd.setIndirectTarget(parent);
      rd.addBounded(this, directTargetAttribute);
      rd.setStyle(RelationshipStyle.reverseRelationshipStyle(style));
      directTargetAttribute.relationships.add(rd);
    }
  }

  /**
   * Sets the direct relationship.
   * <p>
   *
   * For example:
   * <p>
   *
   * {@code
   * A.BCD -> B.CD (WHEN B.FLD = 'DDR' AND B.TYPE = 'OTP') (*..1) <p>
   *
   * (WHEN B.FLD = 'DDR' AND B.TYPE = 'OTP') is called as bounded attributes.
   * }
   *
   * @param directTarget the direct relative target
   *
   * @param boundedAttrs the bounded attributes
   *
   * @param style the relationship style
   */
  public void setRelationship(ObjectDefinition directTarget, Map<AttributeDefinition, Object> boundedAttrs, RelationshipStyle style) {
    RelationshipDefinition relationship = new RelationshipDefinition();
    relationship.setSource(this);
    boundedAttrs.entrySet().stream().forEach((e) -> {
      relationship.addBounded(e.getKey(), e.getValue());
    });
    relationship.setDirectTarget(directTarget);
    relationship.setStyle(style);
    // tree-like 
    if (parent.equals(directTarget)) {
      RelationshipDefinition rd = new RelationshipDefinition();
      rd.setIndirectTarget(directTarget);
      rd.setStyle(RelationshipStyle.ONE_TO_MANY);
      parent.addRelationship(rd);
    }
    // many-to-many for entity
    if (directTarget.getRole() == ObjectRole.ENTITY) {
      directTarget.addRelationship(parent, RelationshipStyle.reverseRelationshipStyle(style));
    }
    relationships.add(relationship);
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
   * @since 2.0
   * 
   * @version 4.0.0 - added on id option value as key on Apr 9, 2019
   */
  public void setLabelledOptions(String label, Map<String, String> options) {
    String id = options.get("id");
    if (!Strings.isEmpty(id)) {
      labelledOptions.put(label + "#" + id, options);
    } else {
      labelledOptions.put(label, options);
    }
  }

  @Override
  public String toString() {
    return "AttributeDefinition{" + "name=" + name + ", parent=" + parent + '}';
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 53 * hash + Objects.hashCode(this.getName());
    hash = 53 * hash + Objects.hashCode(this.parent);
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
    final AttributeDefinition other = (AttributeDefinition) obj;
    if (!Objects.equals(this.getName(), other.getName())) {
      return false;
    }
    if (!Objects.equals(this.parent, other.parent)) {
      return false;
    }
    return true;
  }

}
