/*
 * #%L
 * BroadleafCommerce Common Libraries
 * %%
 * Copyright (C) 2009 - 2017 Broadleaf Commerce
 * %%
 * Licensed under the Broadleaf Fair Use License Agreement, Version 1.0
 * (the "Fair Use License" located  at http://license.broadleafcommerce.org/fair_use_license-1.0.txt)
 * unless the restrictions on use therein are violated and require payment to Broadleaf in which case
 * the Broadleaf End User License Agreement (EULA), Version 1.1
 * (the "Commercial License" located at http://license.broadleafcommerce.org/commercial_license-1.1.txt)
 * shall apply.
 * 
 * Alternatively, the Commercial License may be replaced with a mutually agreed upon license (the "Custom License")
 * between you and Broadleaf Commerce. You may not use this file except in compliance with the applicable license.
 * #L%
 */
package org.broadleafcommerce.common.util;


public class PomEvaluator {
    static class Dependency {
        java.lang.String groupId;

        java.lang.String artifactId;

        java.lang.String version;

        java.lang.String scope;

        java.util.List<org.broadleafcommerce.common.util.PomEvaluator.Category> categoriesThatDependOnThis = new java.util.ArrayList<>();

        @java.lang.Override
        public java.lang.String toString() {
            return (((((((groupId) + ".") + (artifactId)) + ".") + (version)) + "  [") + (scope)) + "]";
        }
    }

    static class LicenseType {
        private java.lang.String name;

        private java.lang.String url;

        public static org.broadleafcommerce.common.util.PomEvaluator.LicenseType APACHE2 = new org.broadleafcommerce.common.util.PomEvaluator.LicenseType("APACHE2", "http://www.apache.org/licenses/LICENSE-2.0.html");

        public static org.broadleafcommerce.common.util.PomEvaluator.LicenseType LGPL = new org.broadleafcommerce.common.util.PomEvaluator.LicenseType("LGPL", "http://www.gnu.org/licenses/lgpl-3.0.html, http://www.gnu.org/licenses/lgpl-2.1.html,");

        public static org.broadleafcommerce.common.util.PomEvaluator.LicenseType MIT = new org.broadleafcommerce.common.util.PomEvaluator.LicenseType("MIT", "http://opensource.org/licenses/MIT");

        public static org.broadleafcommerce.common.util.PomEvaluator.LicenseType JAVA_EXTENSION = new org.broadleafcommerce.common.util.PomEvaluator.LicenseType("JAVA_EXTENSION", "n/a");

        public static org.broadleafcommerce.common.util.PomEvaluator.LicenseType OW2 = new org.broadleafcommerce.common.util.PomEvaluator.LicenseType("OW2", "http://asm.ow2.org/license.html");

        public static org.broadleafcommerce.common.util.PomEvaluator.LicenseType XSTREAM_BSD = new org.broadleafcommerce.common.util.PomEvaluator.LicenseType("XSTREAM_BSD", "http://xstream.codehaus.org/license.html");

        public static org.broadleafcommerce.common.util.PomEvaluator.LicenseType ANTLR_BSD = new org.broadleafcommerce.common.util.PomEvaluator.LicenseType("ANTLR_BSD", "http://www.antlr.org/license.html");

        public static org.broadleafcommerce.common.util.PomEvaluator.LicenseType ANTISAMMY_BSD = new org.broadleafcommerce.common.util.PomEvaluator.LicenseType("ANTISAMMY_BSD", "http://opensource.org/licenses/bsd-license.php");

        public static org.broadleafcommerce.common.util.PomEvaluator.LicenseType OTHER = new org.broadleafcommerce.common.util.PomEvaluator.LicenseType("OTHER", "Unknown");

        public static org.broadleafcommerce.common.util.PomEvaluator.LicenseType ECLIPSE_PUBLIC = new org.broadleafcommerce.common.util.PomEvaluator.LicenseType("ECLIPSE PUBLIC", "http://www.eclipse.org/legal/epl-v10.html");

        public static org.broadleafcommerce.common.util.PomEvaluator.LicenseType YAHOO_YUI = new org.broadleafcommerce.common.util.PomEvaluator.LicenseType("YAHOO YUI", "http://yuilibrary.com/license/");

        public LicenseType(java.lang.String name, java.lang.String url) {
            this.name = name;
            this.url = url;
        }

        @java.lang.Override
        public java.lang.String toString() {
            return ((name.toString()) + ":") + (url);
        }
    }

    static enum FrameworkType {
        PERSISTENCE, GENERAL, LOGGING, UI, XML, UTILITY, SCHEDULER, CACHE, RULES, ECOMMERCE, OTHER;}

    static class Category {
        java.lang.String categoryName;

        org.broadleafcommerce.common.util.PomEvaluator.LicenseType licenseType;

        org.broadleafcommerce.common.util.PomEvaluator.FrameworkType frameworkType;

        java.util.List<org.broadleafcommerce.common.util.PomEvaluator.Dependency> dependencyList = new java.util.ArrayList<>();

        org.broadleafcommerce.common.util.PomEvaluator.Category[] usedByCategories;

        public Category(java.lang.String categoryName, org.broadleafcommerce.common.util.PomEvaluator.LicenseType type, org.broadleafcommerce.common.util.PomEvaluator.FrameworkType frameworkType) {
            this.categoryName = categoryName;
            this.licenseType = type;
            this.frameworkType = frameworkType;
        }

        public Category(java.lang.String categoryName, org.broadleafcommerce.common.util.PomEvaluator.LicenseType type, org.broadleafcommerce.common.util.PomEvaluator.FrameworkType frameworkType, org.broadleafcommerce.common.util.PomEvaluator.Category... usedByCategories) {
            this(categoryName, type, frameworkType);
            this.usedByCategories = usedByCategories;
        }

        @java.lang.Override
        public java.lang.String toString() {
            return (((("Category Name : " + (categoryName)) + "\rLicense Type : ") + (licenseType.name)) + "\rLicense URL : ") + (licenseType.url);
        }
    }

    private static java.lang.String SEPARATOR = "============================================================";

    private static java.util.Map<java.lang.String, org.broadleafcommerce.common.util.PomEvaluator.Category> knownLibraries = new java.util.HashMap<>();

    private static java.util.Map<org.broadleafcommerce.common.util.PomEvaluator.LicenseType, java.util.List<org.broadleafcommerce.common.util.PomEvaluator.Dependency>> licenseDependencyMap = new java.util.HashMap<>();

    private static org.broadleafcommerce.common.util.PomEvaluator.Category SPRING = new org.broadleafcommerce.common.util.PomEvaluator.Category("Spring Framework", org.broadleafcommerce.common.util.PomEvaluator.LicenseType.APACHE2, org.broadleafcommerce.common.util.PomEvaluator.FrameworkType.GENERAL);

    private static org.broadleafcommerce.common.util.PomEvaluator.Category HIBERNATE = new org.broadleafcommerce.common.util.PomEvaluator.Category("Hibernate Framework", org.broadleafcommerce.common.util.PomEvaluator.LicenseType.LGPL, org.broadleafcommerce.common.util.PomEvaluator.FrameworkType.PERSISTENCE);

    private static org.broadleafcommerce.common.util.PomEvaluator.Category GOOGLE = new org.broadleafcommerce.common.util.PomEvaluator.Category("Google", org.broadleafcommerce.common.util.PomEvaluator.LicenseType.APACHE2, org.broadleafcommerce.common.util.PomEvaluator.FrameworkType.GENERAL);

    private static org.broadleafcommerce.common.util.PomEvaluator.Category BROADLEAF_OPEN_SOURCE = new org.broadleafcommerce.common.util.PomEvaluator.Category("Broadleaf Framework Open Source", org.broadleafcommerce.common.util.PomEvaluator.LicenseType.APACHE2, org.broadleafcommerce.common.util.PomEvaluator.FrameworkType.ECOMMERCE);

    private static org.broadleafcommerce.common.util.PomEvaluator.Category BROADLEAF_COMMERCIAL = new org.broadleafcommerce.common.util.PomEvaluator.Category("Broadleaf Framework Commercial", org.broadleafcommerce.common.util.PomEvaluator.LicenseType.APACHE2, org.broadleafcommerce.common.util.PomEvaluator.FrameworkType.ECOMMERCE);

    private static org.broadleafcommerce.common.util.PomEvaluator.Category APACHE_FOUNDATION = new org.broadleafcommerce.common.util.PomEvaluator.Category("Apache 2.0", org.broadleafcommerce.common.util.PomEvaluator.LicenseType.APACHE2, org.broadleafcommerce.common.util.PomEvaluator.FrameworkType.GENERAL);

    private static org.broadleafcommerce.common.util.PomEvaluator.Category JAVAX = new org.broadleafcommerce.common.util.PomEvaluator.Category("javax", org.broadleafcommerce.common.util.PomEvaluator.LicenseType.JAVA_EXTENSION, org.broadleafcommerce.common.util.PomEvaluator.FrameworkType.OTHER);

    private static org.broadleafcommerce.common.util.PomEvaluator.Category SLF4J = new org.broadleafcommerce.common.util.PomEvaluator.Category("slfj", org.broadleafcommerce.common.util.PomEvaluator.LicenseType.MIT, org.broadleafcommerce.common.util.PomEvaluator.FrameworkType.LOGGING);

    private static org.broadleafcommerce.common.util.PomEvaluator.Category LOG4J = new org.broadleafcommerce.common.util.PomEvaluator.Category("log4j", org.broadleafcommerce.common.util.PomEvaluator.LicenseType.APACHE2, org.broadleafcommerce.common.util.PomEvaluator.FrameworkType.LOGGING);

    private static org.broadleafcommerce.common.util.PomEvaluator.Category LOG4J2 = new org.broadleafcommerce.common.util.PomEvaluator.Category("log4j2", org.broadleafcommerce.common.util.PomEvaluator.LicenseType.APACHE2, org.broadleafcommerce.common.util.PomEvaluator.FrameworkType.LOGGING);

    private static org.broadleafcommerce.common.util.PomEvaluator.Category OTHER = new org.broadleafcommerce.common.util.PomEvaluator.Category("Other", org.broadleafcommerce.common.util.PomEvaluator.LicenseType.OTHER, org.broadleafcommerce.common.util.PomEvaluator.FrameworkType.OTHER);

    private static org.broadleafcommerce.common.util.PomEvaluator.Category YAHOO = new org.broadleafcommerce.common.util.PomEvaluator.Category("Yahoo", org.broadleafcommerce.common.util.PomEvaluator.LicenseType.YAHOO_YUI, org.broadleafcommerce.common.util.PomEvaluator.FrameworkType.UI);

    private static org.broadleafcommerce.common.util.PomEvaluator.Category JACKSON = new org.broadleafcommerce.common.util.PomEvaluator.Category("Codehaus Jackson Library", org.broadleafcommerce.common.util.PomEvaluator.LicenseType.APACHE2, org.broadleafcommerce.common.util.PomEvaluator.FrameworkType.XML, org.broadleafcommerce.common.util.PomEvaluator.SPRING, org.broadleafcommerce.common.util.PomEvaluator.APACHE_FOUNDATION);

    private static org.broadleafcommerce.common.util.PomEvaluator.Category PLEXUS = new org.broadleafcommerce.common.util.PomEvaluator.Category("Codehaus Plexus Library", org.broadleafcommerce.common.util.PomEvaluator.LicenseType.APACHE2, org.broadleafcommerce.common.util.PomEvaluator.FrameworkType.XML, org.broadleafcommerce.common.util.PomEvaluator.SPRING, org.broadleafcommerce.common.util.PomEvaluator.APACHE_FOUNDATION);

    private static org.broadleafcommerce.common.util.PomEvaluator.Category ASM = new org.broadleafcommerce.common.util.PomEvaluator.Category("OW2 ASM libraries", org.broadleafcommerce.common.util.PomEvaluator.LicenseType.OW2, org.broadleafcommerce.common.util.PomEvaluator.FrameworkType.GENERAL, org.broadleafcommerce.common.util.PomEvaluator.APACHE_FOUNDATION, org.broadleafcommerce.common.util.PomEvaluator.GOOGLE);

    private static org.broadleafcommerce.common.util.PomEvaluator.Category CGLIB = new org.broadleafcommerce.common.util.PomEvaluator.Category("CGLIB libraries", org.broadleafcommerce.common.util.PomEvaluator.LicenseType.APACHE2, org.broadleafcommerce.common.util.PomEvaluator.FrameworkType.GENERAL, org.broadleafcommerce.common.util.PomEvaluator.SPRING, org.broadleafcommerce.common.util.PomEvaluator.HIBERNATE);

    private static org.broadleafcommerce.common.util.PomEvaluator.Category JERSEY = new org.broadleafcommerce.common.util.PomEvaluator.Category("Jersey Libraries", org.broadleafcommerce.common.util.PomEvaluator.LicenseType.LGPL, org.broadleafcommerce.common.util.PomEvaluator.FrameworkType.XML);

    private static org.broadleafcommerce.common.util.PomEvaluator.Category XSTREAM = new org.broadleafcommerce.common.util.PomEvaluator.Category("Codehaus XML parsing library", org.broadleafcommerce.common.util.PomEvaluator.LicenseType.XSTREAM_BSD, org.broadleafcommerce.common.util.PomEvaluator.FrameworkType.XML);

    private static org.broadleafcommerce.common.util.PomEvaluator.Category JODA_TIME = new org.broadleafcommerce.common.util.PomEvaluator.Category("Date and time utilities", org.broadleafcommerce.common.util.PomEvaluator.LicenseType.APACHE2, org.broadleafcommerce.common.util.PomEvaluator.FrameworkType.UTILITY, org.broadleafcommerce.common.util.PomEvaluator.APACHE_FOUNDATION);

    private static org.broadleafcommerce.common.util.PomEvaluator.Category TRANSMORPH = new org.broadleafcommerce.common.util.PomEvaluator.Category("Entropy Transmorph - SalesForce.com", org.broadleafcommerce.common.util.PomEvaluator.LicenseType.APACHE2, org.broadleafcommerce.common.util.PomEvaluator.FrameworkType.UTILITY);

    private static org.broadleafcommerce.common.util.PomEvaluator.Category QUARTZ = new org.broadleafcommerce.common.util.PomEvaluator.Category("Teracotta Quartz", org.broadleafcommerce.common.util.PomEvaluator.LicenseType.APACHE2, org.broadleafcommerce.common.util.PomEvaluator.FrameworkType.SCHEDULER);

    private static org.broadleafcommerce.common.util.PomEvaluator.Category EHCACHE = new org.broadleafcommerce.common.util.PomEvaluator.Category("Teracotta ehCache", org.broadleafcommerce.common.util.PomEvaluator.LicenseType.APACHE2, org.broadleafcommerce.common.util.PomEvaluator.FrameworkType.CACHE);

    private static org.broadleafcommerce.common.util.PomEvaluator.Category ANTLR = new org.broadleafcommerce.common.util.PomEvaluator.Category("Antlr Runtime", org.broadleafcommerce.common.util.PomEvaluator.LicenseType.ANTLR_BSD, org.broadleafcommerce.common.util.PomEvaluator.FrameworkType.UTILITY, org.broadleafcommerce.common.util.PomEvaluator.APACHE_FOUNDATION);

    private static org.broadleafcommerce.common.util.PomEvaluator.Category ASPECTJ = new org.broadleafcommerce.common.util.PomEvaluator.Category("Aspect J", org.broadleafcommerce.common.util.PomEvaluator.LicenseType.ECLIPSE_PUBLIC, org.broadleafcommerce.common.util.PomEvaluator.FrameworkType.GENERAL, org.broadleafcommerce.common.util.PomEvaluator.SPRING);

    private static org.broadleafcommerce.common.util.PomEvaluator.Category MVEL = new org.broadleafcommerce.common.util.PomEvaluator.Category("MVEL rules evaluation", org.broadleafcommerce.common.util.PomEvaluator.LicenseType.APACHE2, org.broadleafcommerce.common.util.PomEvaluator.FrameworkType.RULES);

    private static org.broadleafcommerce.common.util.PomEvaluator.Category ORO = new org.broadleafcommerce.common.util.PomEvaluator.Category("ORO regular expressions", org.broadleafcommerce.common.util.PomEvaluator.LicenseType.APACHE2, org.broadleafcommerce.common.util.PomEvaluator.FrameworkType.RULES);

    private static org.broadleafcommerce.common.util.PomEvaluator.Category JAVA_ASSIST = new org.broadleafcommerce.common.util.PomEvaluator.Category("Java Assist", org.broadleafcommerce.common.util.PomEvaluator.LicenseType.APACHE2, org.broadleafcommerce.common.util.PomEvaluator.FrameworkType.GENERAL);

    private static org.broadleafcommerce.common.util.PomEvaluator.Category ANTISAMMY = new org.broadleafcommerce.common.util.PomEvaluator.Category("Anti-Sammy", org.broadleafcommerce.common.util.PomEvaluator.LicenseType.ANTISAMMY_BSD, org.broadleafcommerce.common.util.PomEvaluator.FrameworkType.GENERAL);

    private static void initializeKnownLibraries() {
        org.broadleafcommerce.common.util.PomEvaluator.knownLibraries.put("org.springframework", org.broadleafcommerce.common.util.PomEvaluator.SPRING);
        org.broadleafcommerce.common.util.PomEvaluator.knownLibraries.put("org.springframework.security", org.broadleafcommerce.common.util.PomEvaluator.SPRING);
        org.broadleafcommerce.common.util.PomEvaluator.knownLibraries.put("org.springframework.social", org.broadleafcommerce.common.util.PomEvaluator.SPRING);
        org.broadleafcommerce.common.util.PomEvaluator.knownLibraries.put("org.hibernate", org.broadleafcommerce.common.util.PomEvaluator.HIBERNATE);
        org.broadleafcommerce.common.util.PomEvaluator.knownLibraries.put("org.hibernate.javax.persistence", org.broadleafcommerce.common.util.PomEvaluator.HIBERNATE);
        org.broadleafcommerce.common.util.PomEvaluator.knownLibraries.put("org.broadleafcommerce", org.broadleafcommerce.common.util.PomEvaluator.BROADLEAF_OPEN_SOURCE);
        org.broadleafcommerce.common.util.PomEvaluator.knownLibraries.put("com.broadleafcommerce", org.broadleafcommerce.common.util.PomEvaluator.BROADLEAF_COMMERCIAL);
        org.broadleafcommerce.common.util.PomEvaluator.knownLibraries.put("javax.xml.bind", org.broadleafcommerce.common.util.PomEvaluator.JAVAX);
        org.broadleafcommerce.common.util.PomEvaluator.knownLibraries.put("javax.mail", org.broadleafcommerce.common.util.PomEvaluator.JAVAX);
        org.broadleafcommerce.common.util.PomEvaluator.knownLibraries.put("javax.servlet", org.broadleafcommerce.common.util.PomEvaluator.JAVAX);
        org.broadleafcommerce.common.util.PomEvaluator.knownLibraries.put("javax.validation", org.broadleafcommerce.common.util.PomEvaluator.JAVAX);
        org.broadleafcommerce.common.util.PomEvaluator.knownLibraries.put("jstl", org.broadleafcommerce.common.util.PomEvaluator.JAVAX);
        org.broadleafcommerce.common.util.PomEvaluator.knownLibraries.put("org.slf4j", org.broadleafcommerce.common.util.PomEvaluator.SLF4J);
        org.broadleafcommerce.common.util.PomEvaluator.knownLibraries.put("log4j", org.broadleafcommerce.common.util.PomEvaluator.LOG4J);
        org.broadleafcommerce.common.util.PomEvaluator.knownLibraries.put("org.apache.logging.log4j", org.broadleafcommerce.common.util.PomEvaluator.LOG4J2);
        org.broadleafcommerce.common.util.PomEvaluator.knownLibraries.put("commons-validator", org.broadleafcommerce.common.util.PomEvaluator.APACHE_FOUNDATION);
        org.broadleafcommerce.common.util.PomEvaluator.knownLibraries.put("commons-collections", org.broadleafcommerce.common.util.PomEvaluator.APACHE_FOUNDATION);
        org.broadleafcommerce.common.util.PomEvaluator.knownLibraries.put("commons-beanutils", org.broadleafcommerce.common.util.PomEvaluator.APACHE_FOUNDATION);
        org.broadleafcommerce.common.util.PomEvaluator.knownLibraries.put("commons-cli", org.broadleafcommerce.common.util.PomEvaluator.APACHE_FOUNDATION);
        org.broadleafcommerce.common.util.PomEvaluator.knownLibraries.put("commons-fileupload", org.broadleafcommerce.common.util.PomEvaluator.APACHE_FOUNDATION);
        org.broadleafcommerce.common.util.PomEvaluator.knownLibraries.put("commons-dbcp", org.broadleafcommerce.common.util.PomEvaluator.APACHE_FOUNDATION);
        org.broadleafcommerce.common.util.PomEvaluator.knownLibraries.put("commons-codec", org.broadleafcommerce.common.util.PomEvaluator.APACHE_FOUNDATION);
        org.broadleafcommerce.common.util.PomEvaluator.knownLibraries.put("org.apache.commons", org.broadleafcommerce.common.util.PomEvaluator.APACHE_FOUNDATION);
        org.broadleafcommerce.common.util.PomEvaluator.knownLibraries.put("commons-lang", org.broadleafcommerce.common.util.PomEvaluator.APACHE_FOUNDATION);
        org.broadleafcommerce.common.util.PomEvaluator.knownLibraries.put("commons-digester", org.broadleafcommerce.common.util.PomEvaluator.APACHE_FOUNDATION);
        org.broadleafcommerce.common.util.PomEvaluator.knownLibraries.put("commons-logging", org.broadleafcommerce.common.util.PomEvaluator.APACHE_FOUNDATION);
        org.broadleafcommerce.common.util.PomEvaluator.knownLibraries.put("commons-pool", org.broadleafcommerce.common.util.PomEvaluator.APACHE_FOUNDATION);
        org.broadleafcommerce.common.util.PomEvaluator.knownLibraries.put("org.apache.geronimo.specs", org.broadleafcommerce.common.util.PomEvaluator.APACHE_FOUNDATION);
        org.broadleafcommerce.common.util.PomEvaluator.knownLibraries.put("org.apache.solr", org.broadleafcommerce.common.util.PomEvaluator.APACHE_FOUNDATION);
        org.broadleafcommerce.common.util.PomEvaluator.knownLibraries.put("org.apache.velocity", org.broadleafcommerce.common.util.PomEvaluator.APACHE_FOUNDATION);
        org.broadleafcommerce.common.util.PomEvaluator.knownLibraries.put("org.apache.xmlbeans", org.broadleafcommerce.common.util.PomEvaluator.APACHE_FOUNDATION);
        org.broadleafcommerce.common.util.PomEvaluator.knownLibraries.put("taglibs", org.broadleafcommerce.common.util.PomEvaluator.APACHE_FOUNDATION);
        org.broadleafcommerce.common.util.PomEvaluator.knownLibraries.put("jakarta-regexp", org.broadleafcommerce.common.util.PomEvaluator.APACHE_FOUNDATION);
        org.broadleafcommerce.common.util.PomEvaluator.knownLibraries.put("ant.ant", org.broadleafcommerce.common.util.PomEvaluator.APACHE_FOUNDATION);
        org.broadleafcommerce.common.util.PomEvaluator.knownLibraries.put("com.google.gwt", org.broadleafcommerce.common.util.PomEvaluator.GOOGLE);
        org.broadleafcommerce.common.util.PomEvaluator.knownLibraries.put("com.google.code.gwt-math", org.broadleafcommerce.common.util.PomEvaluator.GOOGLE);
        org.broadleafcommerce.common.util.PomEvaluator.knownLibraries.put("com.google.code.findbugs", org.broadleafcommerce.common.util.PomEvaluator.GOOGLE);
        org.broadleafcommerce.common.util.PomEvaluator.knownLibraries.put("net.sf.gwt-widget", org.broadleafcommerce.common.util.PomEvaluator.GOOGLE);
        org.broadleafcommerce.common.util.PomEvaluator.knownLibraries.put("com.google.guava", org.broadleafcommerce.common.util.PomEvaluator.GOOGLE);
        org.broadleafcommerce.common.util.PomEvaluator.knownLibraries.put("org.codehaus.jackson", org.broadleafcommerce.common.util.PomEvaluator.JACKSON);
        org.broadleafcommerce.common.util.PomEvaluator.knownLibraries.put("org.codehaus.plexus", org.broadleafcommerce.common.util.PomEvaluator.PLEXUS);
        org.broadleafcommerce.common.util.PomEvaluator.knownLibraries.put("asm", org.broadleafcommerce.common.util.PomEvaluator.ASM);
        org.broadleafcommerce.common.util.PomEvaluator.knownLibraries.put("cglib", org.broadleafcommerce.common.util.PomEvaluator.CGLIB);
        org.broadleafcommerce.common.util.PomEvaluator.knownLibraries.put("com.sun.jersey", org.broadleafcommerce.common.util.PomEvaluator.JERSEY);
        org.broadleafcommerce.common.util.PomEvaluator.knownLibraries.put("com.sun.jersey.contribs", org.broadleafcommerce.common.util.PomEvaluator.JERSEY);
        org.broadleafcommerce.common.util.PomEvaluator.knownLibraries.put("com.thoughtworks.xstream", org.broadleafcommerce.common.util.PomEvaluator.JERSEY);
        org.broadleafcommerce.common.util.PomEvaluator.knownLibraries.put("joda-time", org.broadleafcommerce.common.util.PomEvaluator.JODA_TIME);
        org.broadleafcommerce.common.util.PomEvaluator.knownLibraries.put("net.sf.jsr107cache", org.broadleafcommerce.common.util.PomEvaluator.JAVAX);
        org.broadleafcommerce.common.util.PomEvaluator.knownLibraries.put("net.sf.transmorph", org.broadleafcommerce.common.util.PomEvaluator.TRANSMORPH);
        org.broadleafcommerce.common.util.PomEvaluator.knownLibraries.put("net.sf.ehcache", org.broadleafcommerce.common.util.PomEvaluator.EHCACHE);
        org.broadleafcommerce.common.util.PomEvaluator.knownLibraries.put("org.opensymphony.quartz", org.broadleafcommerce.common.util.PomEvaluator.QUARTZ);
        org.broadleafcommerce.common.util.PomEvaluator.knownLibraries.put("org.antlr", org.broadleafcommerce.common.util.PomEvaluator.ANTLR);
        org.broadleafcommerce.common.util.PomEvaluator.knownLibraries.put("org.aspectj", org.broadleafcommerce.common.util.PomEvaluator.ASPECTJ);
        org.broadleafcommerce.common.util.PomEvaluator.knownLibraries.put("org.mvel", org.broadleafcommerce.common.util.PomEvaluator.MVEL);
        org.broadleafcommerce.common.util.PomEvaluator.knownLibraries.put("oro", org.broadleafcommerce.common.util.PomEvaluator.ORO);
        org.broadleafcommerce.common.util.PomEvaluator.knownLibraries.put("org.javassist", org.broadleafcommerce.common.util.PomEvaluator.JAVA_ASSIST);
        org.broadleafcommerce.common.util.PomEvaluator.knownLibraries.put("org.owasp.antisamy", org.broadleafcommerce.common.util.PomEvaluator.ANTISAMMY);
        org.broadleafcommerce.common.util.PomEvaluator.knownLibraries.put("com.yahoo.platform.yui", org.broadleafcommerce.common.util.PomEvaluator.YAHOO);
    }

    public static void printOutDependencies(org.broadleafcommerce.common.util.PomEvaluator.Category category, java.util.List<org.broadleafcommerce.common.util.PomEvaluator.Dependency> dependencies) {
        java.util.List<java.lang.String> dependencyNames = new java.util.ArrayList<>();
        for (org.broadleafcommerce.common.util.PomEvaluator.Dependency d : dependencies) {
            dependencyNames.add(d.toString());
        }
        java.util.Collections.sort(dependencyNames);
        java.lang.System.out.println(category);
        java.lang.System.out.println(org.broadleafcommerce.common.util.PomEvaluator.SEPARATOR);
        for (java.lang.String name : dependencyNames) {
            java.lang.System.out.println(name);
        }
        java.lang.System.out.println((((("Total count for category " + (category.categoryName)) + ": ") + (dependencyNames.size())) + "\r\r"));
    }

    public static java.util.List<org.broadleafcommerce.common.util.PomEvaluator.Dependency> populateDependencies(java.io.BufferedReader br) throws java.io.IOException {
        java.lang.String currentLine;
        java.util.List<org.broadleafcommerce.common.util.PomEvaluator.Dependency> dependencyList = new java.util.ArrayList<>();
        while (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.PomEvaluator.__L6473, org.broadleafcommerce.common.util.PomEvaluator.forwardToTag("<dependency", br))) {
            org.broadleafcommerce.common.util.PomEvaluator.Dependency current = new org.broadleafcommerce.common.util.PomEvaluator.Dependency();
            while (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.PomEvaluator.__L6474, ((currentLine = br.readLine()) != null))) {
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.PomEvaluator.__L6475, currentLine.contains("</dependency>"))) {
                    break;
                }
                current.scope = org.broadleafcommerce.common.util.PomEvaluator.getTagValue("<scope>", currentLine, current.scope);
                current.groupId = org.broadleafcommerce.common.util.PomEvaluator.getTagValue("<groupId>", currentLine, current.groupId);
                current.artifactId = org.broadleafcommerce.common.util.PomEvaluator.getTagValue("<artifactId>", currentLine, current.artifactId);
                current.version = org.broadleafcommerce.common.util.PomEvaluator.getTagValue("<version>", currentLine, current.version);
            } 
            dependencyList.add(current);
        } 
        return dependencyList;
    }

    public static java.lang.String getTagValue(java.lang.String tagName, java.lang.String line, java.lang.String currentValue) {
        int startPos = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.PomEvaluator.__L6476, line.indexOf(tagName));
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.PomEvaluator.__L6479, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.PomEvaluator.__L6477, startPos)) >= (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.PomEvaluator.__L6478, 0))))) {
            int endPos = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.PomEvaluator.__L6483, line.indexOf("</", perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.PomEvaluator.__L6482, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.PomEvaluator.__L6480, startPos)) + (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.PomEvaluator.__L6481, 1))))));
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.PomEvaluator.__L6486, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.PomEvaluator.__L6484, endPos)) >= (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.PomEvaluator.__L6485, 0))))) {
                return line.substring(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.PomEvaluator.__L6489, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.PomEvaluator.__L6487, startPos)) + (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.PomEvaluator.__L6488, tagName.length())))), perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.PomEvaluator.__L6490, endPos));
            }
        }
        return currentValue;
    }

    public static boolean forwardToTag(java.lang.String tagName, java.io.BufferedReader br) throws java.io.IOException {
        java.lang.String sCurrentLine;
        while (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.PomEvaluator.__L6491, ((sCurrentLine = br.readLine()) != null))) {
            java.lang.String lowerCaseLine = sCurrentLine.toLowerCase();
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.PomEvaluator.__L6494, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.PomEvaluator.__L6492, lowerCaseLine.indexOf(tagName))) >= (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.util.PomEvaluator.__L6493, 0))))) {
                return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.PomEvaluator.__L6495, true);
            }
        } 
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.util.PomEvaluator.__L6496, false);
    }

    public static perturbation.location.PerturbationLocation __L6473;

    public static perturbation.location.PerturbationLocation __L6474;

    public static perturbation.location.PerturbationLocation __L6475;

    public static perturbation.location.PerturbationLocation __L6476;

    public static perturbation.location.PerturbationLocation __L6477;

    public static perturbation.location.PerturbationLocation __L6478;

    public static perturbation.location.PerturbationLocation __L6479;

    public static perturbation.location.PerturbationLocation __L6480;

    public static perturbation.location.PerturbationLocation __L6481;

    public static perturbation.location.PerturbationLocation __L6482;

    public static perturbation.location.PerturbationLocation __L6483;

    public static perturbation.location.PerturbationLocation __L6484;

    public static perturbation.location.PerturbationLocation __L6485;

    public static perturbation.location.PerturbationLocation __L6486;

    public static perturbation.location.PerturbationLocation __L6487;

    public static perturbation.location.PerturbationLocation __L6488;

    public static perturbation.location.PerturbationLocation __L6489;

    public static perturbation.location.PerturbationLocation __L6490;

    public static perturbation.location.PerturbationLocation __L6491;

    public static perturbation.location.PerturbationLocation __L6492;

    public static perturbation.location.PerturbationLocation __L6493;

    public static perturbation.location.PerturbationLocation __L6494;

    public static perturbation.location.PerturbationLocation __L6495;

    public static perturbation.location.PerturbationLocation __L6496;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.util.PomEvaluator.__L6473 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/PomEvaluator.java:265)", 6473, "Boolean");
        org.broadleafcommerce.common.util.PomEvaluator.__L6474 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/PomEvaluator.java:267)", 6474, "Boolean");
        org.broadleafcommerce.common.util.PomEvaluator.__L6475 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/PomEvaluator.java:268)", 6475, "Boolean");
        org.broadleafcommerce.common.util.PomEvaluator.__L6476 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/PomEvaluator.java:283)", 6476, "Numerical");
        org.broadleafcommerce.common.util.PomEvaluator.__L6477 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/PomEvaluator.java:284)", 6477, "Numerical");
        org.broadleafcommerce.common.util.PomEvaluator.__L6478 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/PomEvaluator.java:284)", 6478, "Numerical");
        org.broadleafcommerce.common.util.PomEvaluator.__L6479 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/PomEvaluator.java:284)", 6479, "Boolean");
        org.broadleafcommerce.common.util.PomEvaluator.__L6480 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/PomEvaluator.java:285)", 6480, "Numerical");
        org.broadleafcommerce.common.util.PomEvaluator.__L6481 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/PomEvaluator.java:285)", 6481, "Numerical");
        org.broadleafcommerce.common.util.PomEvaluator.__L6482 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/PomEvaluator.java:285)", 6482, "Numerical");
        org.broadleafcommerce.common.util.PomEvaluator.__L6483 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/PomEvaluator.java:285)", 6483, "Numerical");
        org.broadleafcommerce.common.util.PomEvaluator.__L6484 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/PomEvaluator.java:286)", 6484, "Numerical");
        org.broadleafcommerce.common.util.PomEvaluator.__L6485 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/PomEvaluator.java:286)", 6485, "Numerical");
        org.broadleafcommerce.common.util.PomEvaluator.__L6486 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/PomEvaluator.java:286)", 6486, "Boolean");
        org.broadleafcommerce.common.util.PomEvaluator.__L6487 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/PomEvaluator.java:287)", 6487, "Numerical");
        org.broadleafcommerce.common.util.PomEvaluator.__L6488 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/PomEvaluator.java:287)", 6488, "Numerical");
        org.broadleafcommerce.common.util.PomEvaluator.__L6489 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/PomEvaluator.java:287)", 6489, "Numerical");
        org.broadleafcommerce.common.util.PomEvaluator.__L6490 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/PomEvaluator.java:287)", 6490, "Numerical");
        org.broadleafcommerce.common.util.PomEvaluator.__L6491 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/PomEvaluator.java:295)", 6491, "Boolean");
        org.broadleafcommerce.common.util.PomEvaluator.__L6492 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/PomEvaluator.java:297)", 6492, "Numerical");
        org.broadleafcommerce.common.util.PomEvaluator.__L6493 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/PomEvaluator.java:297)", 6493, "Numerical");
        org.broadleafcommerce.common.util.PomEvaluator.__L6494 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/PomEvaluator.java:297)", 6494, "Boolean");
        org.broadleafcommerce.common.util.PomEvaluator.__L6495 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/PomEvaluator.java:298)", 6495, "Boolean");
        org.broadleafcommerce.common.util.PomEvaluator.__L6496 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/util/PomEvaluator.java:301)", 6496, "Boolean");
    }

    static {
        org.broadleafcommerce.common.util.PomEvaluator.initPerturbationLocation0();
    }
}

