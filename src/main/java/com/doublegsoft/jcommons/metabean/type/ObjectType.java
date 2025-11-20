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

/**
 * It's root class in type hierarchy.
 * 
 * @author <a href="mailto:guo.guo.gan@gmail.com">Christian Gann</a>
 * 
 * @since 1.0
 * 
 * @version 1.0.0 - Initial creation on 02/01/2013.<br>
 */
public interface ObjectType {
    
    /**
     * Gets full qualified class name.
     * 
     * <p>
     * Example for Java:
     * <ul>
     * <li>String: java.lang.String</li>
     * <li>List: java.util.List</li>
     * <li>UserDefinedType: &lt;package&gt;.UserDefinedType</li>
     * <li>String[]: []</li>
     * </ul>
     * 
     * @return full qualified class name
     * 
     * @see Class#getCanonicalName() 
     */
    String getName();
    
    default boolean isPrimitive() {
      return getClass().equals(PrimitiveType.class);
    } 
    
    default boolean isDomain() {
      return getClass().equals(DomainType.class);
    } 
    
    default boolean isCollection() {
      return getClass().equals(CollectionType.class);
    } 
    
    default boolean isCustom() {
      return getClass().equals(CustomType.class);
    } 
    
    default boolean isNative() {
      return getClass().equals(NativeType.class);
    } 
    
    default boolean isData() {
      return getClass().equals(DataType.class);
    } 
    
    default boolean isAnonymous() {
      return getClass().equals(AnonymousType.class);
    }
}
