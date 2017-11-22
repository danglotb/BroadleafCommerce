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
package org.broadleafcommerce.common.config.service;


@org.springframework.stereotype.Service("blSystemPropertiesService")
public class SystemPropertiesServiceImpl implements org.broadleafcommerce.common.config.service.SystemPropertiesService {
    public static final java.lang.String PROPERTY_SOURCE_NAME = "systemPropertySource";

    protected static final java.lang.ThreadLocal<java.lang.Boolean> originatedFromEnvironment = org.broadleafcommerce.common.classloader.release.ThreadLocalManager.createThreadLocal(java.lang.Boolean.class, false);

    private static final java.lang.String NULL_RESPONSE = "*NULL_RESPONSE*";

    protected net.sf.ehcache.Cache systemPropertyCache;

    @javax.annotation.Resource(name = "blSystemPropertiesDao")
    protected org.broadleafcommerce.common.config.dao.SystemPropertiesDao systemPropertiesDao;

    @javax.annotation.Resource(name = "blSystemPropertyServiceExtensionManager")
    protected org.broadleafcommerce.common.config.service.SystemPropertyServiceExtensionManager extensionManager;

    @org.springframework.beans.factory.annotation.Value("${system.property.cache.timeout}")
    protected int systemPropertyCacheTimeout;

    @org.springframework.beans.factory.annotation.Autowired
    protected org.springframework.core.env.Environment env;

    @java.lang.Override
    public java.lang.String resolveSystemProperty(java.lang.String name, java.lang.String defaultValue) {
        java.lang.String result = resolveSystemProperty(name);
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.config.service.SystemPropertiesServiceImpl.__L412, org.apache.commons.lang3.StringUtils.isBlank(result))) {
            return defaultValue;
        }
        return result;
    }

    @java.lang.Override
    public java.lang.String resolveSystemProperty(java.lang.String name) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.config.service.SystemPropertiesServiceImpl.__L413, ((extensionManager) != null))) {
            org.broadleafcommerce.common.extension.ExtensionResultHolder holder = new org.broadleafcommerce.common.extension.ExtensionResultHolder();
            extensionManager.getProxy().resolveProperty(name, holder);
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.config.service.SystemPropertiesServiceImpl.__L414, ((holder.getResult()) != null))) {
                return holder.getResult().toString();
            }
        }
        java.lang.String result;
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.config.service.SystemPropertiesServiceImpl.__L417, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.config.service.SystemPropertiesServiceImpl.__L415, ((org.broadleafcommerce.common.web.BroadleafRequestContext.getBroadleafRequestContext()) == null))) || (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.config.service.SystemPropertiesServiceImpl.__L416, ((org.broadleafcommerce.common.web.BroadleafRequestContext.getBroadleafRequestContext().getSandBox()) == null)))))) {
            result = getPropertyFromCache(name);
        }else {
            result = null;
        }
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.config.service.SystemPropertiesServiceImpl.__L418, (result != null))) {
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.config.service.SystemPropertiesServiceImpl.__L419, result.equals(org.broadleafcommerce.common.config.service.SystemPropertiesServiceImpl.NULL_RESPONSE)) ? null : result;
        }
        org.broadleafcommerce.common.config.domain.SystemProperty property = systemPropertiesDao.readSystemPropertyByName(name);
        boolean envOrigination = perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.config.service.SystemPropertiesServiceImpl.__L420, org.apache.commons.lang3.BooleanUtils.isTrue(org.broadleafcommerce.common.config.service.SystemPropertiesServiceImpl.originatedFromEnvironment.get()));
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.config.service.SystemPropertiesServiceImpl.__L423, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.config.service.SystemPropertiesServiceImpl.__L421, (property == null))) || (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.config.service.SystemPropertiesServiceImpl.__L422, org.apache.commons.lang3.StringUtils.isEmpty(property.getValue())))))) {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.config.service.SystemPropertiesServiceImpl.__L424, envOrigination)) {
                result = null;
            }else {
                result = env.getProperty(name);
            }
        }else {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.config.service.SystemPropertiesServiceImpl.__L425, "_blank_".equals(property.getValue()))) {
                result = "";
            }else {
                result = property.getValue();
            }
        }
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.config.service.SystemPropertiesServiceImpl.__L426, (result == null))) {
            result = org.broadleafcommerce.common.config.service.SystemPropertiesServiceImpl.NULL_RESPONSE;
        }
        addPropertyToCache(name, result);
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.config.service.SystemPropertiesServiceImpl.__L427, result.equals(org.broadleafcommerce.common.config.service.SystemPropertiesServiceImpl.NULL_RESPONSE)) ? null : result;
    }

    protected void addPropertyToCache(java.lang.String propertyName, java.lang.String propertyValue) {
        java.lang.String key = buildKey(propertyName);
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.config.service.SystemPropertiesServiceImpl.__L430, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.config.service.SystemPropertiesServiceImpl.__L428, systemPropertyCacheTimeout)) < (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.config.service.SystemPropertiesServiceImpl.__L429, 0))))) {
            getSystemPropertyCache().put(new net.sf.ehcache.Element(key, propertyValue));
        }else {
            getSystemPropertyCache().put(new net.sf.ehcache.Element(key, propertyValue, perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.config.service.SystemPropertiesServiceImpl.__L431, systemPropertyCacheTimeout), perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.config.service.SystemPropertiesServiceImpl.__L432, systemPropertyCacheTimeout)));
        }
    }

    protected java.lang.String getPropertyFromCache(java.lang.String propertyName) {
        java.lang.String key = buildKey(propertyName);
        net.sf.ehcache.Element cacheElement = getSystemPropertyCache().get(key);
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.config.service.SystemPropertiesServiceImpl.__L435, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.config.service.SystemPropertiesServiceImpl.__L433, (cacheElement != null))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.config.service.SystemPropertiesServiceImpl.__L434, ((cacheElement.getObjectValue()) != null)))))) {
            return ((java.lang.String) (cacheElement.getObjectValue()));
        }
        return null;
    }

    protected java.lang.String buildKey(java.lang.String propertyName) {
        java.lang.String key = propertyName;
        org.broadleafcommerce.common.web.BroadleafRequestContext brc = org.broadleafcommerce.common.web.BroadleafRequestContext.getBroadleafRequestContext();
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.config.service.SystemPropertiesServiceImpl.__L436, (brc != null))) {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.config.service.SystemPropertiesServiceImpl.__L437, ((brc.getSite()) != null))) {
                key = ((brc.getSite().getId()) + "-") + key;
            }
        }
        return key;
    }

    protected java.lang.String buildKey(org.broadleafcommerce.common.config.domain.SystemProperty systemProperty) {
        java.lang.String key = systemProperty.getName();
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.config.service.SystemPropertiesServiceImpl.__L440, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.config.service.SystemPropertiesServiceImpl.__L438, (systemProperty instanceof org.broadleafcommerce.common.extensibility.jpa.SiteDiscriminator))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.config.service.SystemPropertiesServiceImpl.__L439, ((((org.broadleafcommerce.common.extensibility.jpa.SiteDiscriminator) (systemProperty)).getSiteDiscriminator()) != null)))))) {
            key = ((((org.broadleafcommerce.common.extensibility.jpa.SiteDiscriminator) (systemProperty)).getSiteDiscriminator()) + "-") + key;
        }
        return key;
    }

    protected net.sf.ehcache.Cache getSystemPropertyCache() {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.config.service.SystemPropertiesServiceImpl.__L441, ((systemPropertyCache) == null))) {
            systemPropertyCache = net.sf.ehcache.CacheManager.getInstance().getCache("blSystemPropertyElements");
        }
        return systemPropertyCache;
    }

    @java.lang.Override
    public org.broadleafcommerce.common.config.domain.SystemProperty findById(java.lang.Long id) {
        return systemPropertiesDao.readById(id);
    }

    @java.lang.Override
    public void removeFromCache(org.broadleafcommerce.common.config.domain.SystemProperty systemProperty) {
        java.lang.String key = buildKey(systemProperty);
        getSystemPropertyCache().remove(key);
        systemPropertiesDao.removeFromCache(systemProperty);
    }

    @java.lang.Override
    public int resolveIntSystemProperty(java.lang.String name) {
        java.lang.String systemProperty = resolveSystemProperty(name, "0");
        return perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.config.service.SystemPropertiesServiceImpl.__L442, java.lang.Integer.valueOf(systemProperty).intValue());
    }

    @java.lang.Override
    public int resolveIntSystemProperty(java.lang.String name, int defaultValue) {
        java.lang.String systemProperty = resolveSystemProperty(name, java.lang.Integer.toString(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.config.service.SystemPropertiesServiceImpl.__L443, defaultValue)));
        return perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.config.service.SystemPropertiesServiceImpl.__L444, java.lang.Integer.valueOf(systemProperty).intValue());
    }

    @java.lang.Override
    public boolean resolveBooleanSystemProperty(java.lang.String name) {
        java.lang.String systemProperty = resolveSystemProperty(name, "false");
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.config.service.SystemPropertiesServiceImpl.__L445, java.lang.Boolean.valueOf(systemProperty).booleanValue());
    }

    @java.lang.Override
    public boolean resolveBooleanSystemProperty(java.lang.String name, boolean defaultValue) {
        java.lang.String systemProperty = resolveSystemProperty(name, java.lang.Boolean.toString(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.config.service.SystemPropertiesServiceImpl.__L446, defaultValue)));
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.config.service.SystemPropertiesServiceImpl.__L447, java.lang.Boolean.valueOf(systemProperty).booleanValue());
    }

    @java.lang.Override
    public long resolveLongSystemProperty(java.lang.String name) {
        java.lang.String systemProperty = resolveSystemProperty(name, "0");
        return perturbation.PerturbationEngine.plong(org.broadleafcommerce.common.config.service.SystemPropertiesServiceImpl.__L448, java.lang.Long.valueOf(systemProperty).longValue());
    }

    @java.lang.Override
    public long resolveLongSystemProperty(java.lang.String name, long defaultValue) {
        java.lang.String systemProperty = resolveSystemProperty(name, java.lang.Long.toString(perturbation.PerturbationEngine.plong(org.broadleafcommerce.common.config.service.SystemPropertiesServiceImpl.__L449, defaultValue)));
        return perturbation.PerturbationEngine.plong(org.broadleafcommerce.common.config.service.SystemPropertiesServiceImpl.__L450, java.lang.Long.valueOf(systemProperty).longValue());
    }

    @java.lang.Override
    public boolean isValueValidForType(java.lang.String value, org.broadleafcommerce.common.config.service.type.SystemPropertyFieldType type) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.config.service.SystemPropertiesServiceImpl.__L451, (value == null))) {
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.config.service.SystemPropertiesServiceImpl.__L452, true);
        }
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.config.service.SystemPropertiesServiceImpl.__L453, type.equals(org.broadleafcommerce.common.config.service.type.SystemPropertyFieldType.BOOLEAN_TYPE))) {
            value = value.toUpperCase();
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.config.service.SystemPropertiesServiceImpl.__L458, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.config.service.SystemPropertiesServiceImpl.__L454, (value != null))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.config.service.SystemPropertiesServiceImpl.__L457, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.config.service.SystemPropertiesServiceImpl.__L455, value.equals("TRUE"))) || (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.config.service.SystemPropertiesServiceImpl.__L456, value.equals("FALSE"))))))))) {
                return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.config.service.SystemPropertiesServiceImpl.__L459, true);
            }
        }else
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.config.service.SystemPropertiesServiceImpl.__L460, type.equals(org.broadleafcommerce.common.config.service.type.SystemPropertyFieldType.INT_TYPE))) {
                try {
                    java.lang.Integer.parseInt(value);
                    return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.config.service.SystemPropertiesServiceImpl.__L461, true);
                } catch (java.lang.Exception e) {
                }
            }else
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.config.service.SystemPropertiesServiceImpl.__L462, type.equals(org.broadleafcommerce.common.config.service.type.SystemPropertyFieldType.LONG_TYPE))) {
                    try {
                        java.lang.Long.parseLong(value);
                        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.config.service.SystemPropertiesServiceImpl.__L463, true);
                    } catch (java.lang.Exception e) {
                    }
                }else
                    if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.config.service.SystemPropertiesServiceImpl.__L464, type.equals(org.broadleafcommerce.common.config.service.type.SystemPropertyFieldType.DOUBLE_TYPE))) {
                        try {
                            java.lang.Double.parseDouble(value);
                            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.config.service.SystemPropertiesServiceImpl.__L465, true);
                        } catch (java.lang.Exception e) {
                        }
                    }else
                        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.config.service.SystemPropertiesServiceImpl.__L466, type.equals(org.broadleafcommerce.common.config.service.type.SystemPropertyFieldType.STRING_TYPE))) {
                            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.config.service.SystemPropertiesServiceImpl.__L467, true);
                        }




        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.config.service.SystemPropertiesServiceImpl.__L468, false);
    }

    public static perturbation.location.PerturbationLocation __L412;

    public static perturbation.location.PerturbationLocation __L413;

    public static perturbation.location.PerturbationLocation __L414;

    public static perturbation.location.PerturbationLocation __L415;

    public static perturbation.location.PerturbationLocation __L416;

    public static perturbation.location.PerturbationLocation __L417;

    public static perturbation.location.PerturbationLocation __L418;

    public static perturbation.location.PerturbationLocation __L419;

    public static perturbation.location.PerturbationLocation __L420;

    public static perturbation.location.PerturbationLocation __L421;

    public static perturbation.location.PerturbationLocation __L422;

    public static perturbation.location.PerturbationLocation __L423;

    public static perturbation.location.PerturbationLocation __L424;

    public static perturbation.location.PerturbationLocation __L425;

    public static perturbation.location.PerturbationLocation __L426;

    public static perturbation.location.PerturbationLocation __L427;

    public static perturbation.location.PerturbationLocation __L428;

    public static perturbation.location.PerturbationLocation __L429;

    public static perturbation.location.PerturbationLocation __L430;

    public static perturbation.location.PerturbationLocation __L431;

    public static perturbation.location.PerturbationLocation __L432;

    public static perturbation.location.PerturbationLocation __L433;

    public static perturbation.location.PerturbationLocation __L434;

    public static perturbation.location.PerturbationLocation __L435;

    public static perturbation.location.PerturbationLocation __L436;

    public static perturbation.location.PerturbationLocation __L437;

    public static perturbation.location.PerturbationLocation __L438;

    public static perturbation.location.PerturbationLocation __L439;

    public static perturbation.location.PerturbationLocation __L440;

    public static perturbation.location.PerturbationLocation __L441;

    public static perturbation.location.PerturbationLocation __L442;

    public static perturbation.location.PerturbationLocation __L443;

    public static perturbation.location.PerturbationLocation __L444;

    public static perturbation.location.PerturbationLocation __L445;

    public static perturbation.location.PerturbationLocation __L446;

    public static perturbation.location.PerturbationLocation __L447;

    public static perturbation.location.PerturbationLocation __L448;

    public static perturbation.location.PerturbationLocation __L449;

    public static perturbation.location.PerturbationLocation __L450;

    public static perturbation.location.PerturbationLocation __L451;

    public static perturbation.location.PerturbationLocation __L452;

    public static perturbation.location.PerturbationLocation __L453;

    public static perturbation.location.PerturbationLocation __L454;

    public static perturbation.location.PerturbationLocation __L455;

    public static perturbation.location.PerturbationLocation __L456;

    public static perturbation.location.PerturbationLocation __L457;

    public static perturbation.location.PerturbationLocation __L458;

    public static perturbation.location.PerturbationLocation __L459;

    public static perturbation.location.PerturbationLocation __L460;

    public static perturbation.location.PerturbationLocation __L461;

    public static perturbation.location.PerturbationLocation __L462;

    public static perturbation.location.PerturbationLocation __L463;

    public static perturbation.location.PerturbationLocation __L464;

    public static perturbation.location.PerturbationLocation __L465;

    public static perturbation.location.PerturbationLocation __L466;

    public static perturbation.location.PerturbationLocation __L467;

    public static perturbation.location.PerturbationLocation __L468;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.config.service.SystemPropertiesServiceImpl.__L412 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/service/SystemPropertiesServiceImpl.java:76)", 412, "Boolean");
        org.broadleafcommerce.common.config.service.SystemPropertiesServiceImpl.__L413 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/service/SystemPropertiesServiceImpl.java:84)", 413, "Boolean");
        org.broadleafcommerce.common.config.service.SystemPropertiesServiceImpl.__L414 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/service/SystemPropertiesServiceImpl.java:87)", 414, "Boolean");
        org.broadleafcommerce.common.config.service.SystemPropertiesServiceImpl.__L415 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/service/SystemPropertiesServiceImpl.java:94)", 415, "Boolean");
        org.broadleafcommerce.common.config.service.SystemPropertiesServiceImpl.__L416 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/service/SystemPropertiesServiceImpl.java:95)", 416, "Boolean");
        org.broadleafcommerce.common.config.service.SystemPropertiesServiceImpl.__L417 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/service/SystemPropertiesServiceImpl.java:94)", 417, "Boolean");
        org.broadleafcommerce.common.config.service.SystemPropertiesServiceImpl.__L418 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/service/SystemPropertiesServiceImpl.java:101)", 418, "Boolean");
        org.broadleafcommerce.common.config.service.SystemPropertiesServiceImpl.__L419 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/service/SystemPropertiesServiceImpl.java:102)", 419, "Boolean");
        org.broadleafcommerce.common.config.service.SystemPropertiesServiceImpl.__L420 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/service/SystemPropertiesServiceImpl.java:106)", 420, "Boolean");
        org.broadleafcommerce.common.config.service.SystemPropertiesServiceImpl.__L421 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/service/SystemPropertiesServiceImpl.java:107)", 421, "Boolean");
        org.broadleafcommerce.common.config.service.SystemPropertiesServiceImpl.__L422 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/service/SystemPropertiesServiceImpl.java:107)", 422, "Boolean");
        org.broadleafcommerce.common.config.service.SystemPropertiesServiceImpl.__L423 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/service/SystemPropertiesServiceImpl.java:107)", 423, "Boolean");
        org.broadleafcommerce.common.config.service.SystemPropertiesServiceImpl.__L424 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/service/SystemPropertiesServiceImpl.java:108)", 424, "Boolean");
        org.broadleafcommerce.common.config.service.SystemPropertiesServiceImpl.__L425 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/service/SystemPropertiesServiceImpl.java:114)", 425, "Boolean");
        org.broadleafcommerce.common.config.service.SystemPropertiesServiceImpl.__L426 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/service/SystemPropertiesServiceImpl.java:121)", 426, "Boolean");
        org.broadleafcommerce.common.config.service.SystemPropertiesServiceImpl.__L427 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/service/SystemPropertiesServiceImpl.java:125)", 427, "Boolean");
        org.broadleafcommerce.common.config.service.SystemPropertiesServiceImpl.__L428 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/service/SystemPropertiesServiceImpl.java:130)", 428, "Numerical");
        org.broadleafcommerce.common.config.service.SystemPropertiesServiceImpl.__L429 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/service/SystemPropertiesServiceImpl.java:130)", 429, "Numerical");
        org.broadleafcommerce.common.config.service.SystemPropertiesServiceImpl.__L430 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/service/SystemPropertiesServiceImpl.java:130)", 430, "Boolean");
        org.broadleafcommerce.common.config.service.SystemPropertiesServiceImpl.__L431 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/service/SystemPropertiesServiceImpl.java:133)", 431, "Numerical");
        org.broadleafcommerce.common.config.service.SystemPropertiesServiceImpl.__L432 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/service/SystemPropertiesServiceImpl.java:134)", 432, "Numerical");
        org.broadleafcommerce.common.config.service.SystemPropertiesServiceImpl.__L433 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/service/SystemPropertiesServiceImpl.java:141)", 433, "Boolean");
        org.broadleafcommerce.common.config.service.SystemPropertiesServiceImpl.__L434 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/service/SystemPropertiesServiceImpl.java:141)", 434, "Boolean");
        org.broadleafcommerce.common.config.service.SystemPropertiesServiceImpl.__L435 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/service/SystemPropertiesServiceImpl.java:141)", 435, "Boolean");
        org.broadleafcommerce.common.config.service.SystemPropertiesServiceImpl.__L436 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/service/SystemPropertiesServiceImpl.java:157)", 436, "Boolean");
        org.broadleafcommerce.common.config.service.SystemPropertiesServiceImpl.__L437 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/service/SystemPropertiesServiceImpl.java:158)", 437, "Boolean");
        org.broadleafcommerce.common.config.service.SystemPropertiesServiceImpl.__L438 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/service/SystemPropertiesServiceImpl.java:174)", 438, "Boolean");
        org.broadleafcommerce.common.config.service.SystemPropertiesServiceImpl.__L439 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/service/SystemPropertiesServiceImpl.java:174)", 439, "Boolean");
        org.broadleafcommerce.common.config.service.SystemPropertiesServiceImpl.__L440 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/service/SystemPropertiesServiceImpl.java:174)", 440, "Boolean");
        org.broadleafcommerce.common.config.service.SystemPropertiesServiceImpl.__L441 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/service/SystemPropertiesServiceImpl.java:181)", 441, "Boolean");
        org.broadleafcommerce.common.config.service.SystemPropertiesServiceImpl.__L442 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/service/SystemPropertiesServiceImpl.java:205)", 442, "Numerical");
        org.broadleafcommerce.common.config.service.SystemPropertiesServiceImpl.__L443 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/service/SystemPropertiesServiceImpl.java:210)", 443, "Numerical");
        org.broadleafcommerce.common.config.service.SystemPropertiesServiceImpl.__L444 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/service/SystemPropertiesServiceImpl.java:211)", 444, "Numerical");
        org.broadleafcommerce.common.config.service.SystemPropertiesServiceImpl.__L445 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/service/SystemPropertiesServiceImpl.java:217)", 445, "Boolean");
        org.broadleafcommerce.common.config.service.SystemPropertiesServiceImpl.__L446 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/service/SystemPropertiesServiceImpl.java:222)", 446, "Boolean");
        org.broadleafcommerce.common.config.service.SystemPropertiesServiceImpl.__L447 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/service/SystemPropertiesServiceImpl.java:223)", 447, "Boolean");
        org.broadleafcommerce.common.config.service.SystemPropertiesServiceImpl.__L448 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/service/SystemPropertiesServiceImpl.java:229)", 448, "Numerical");
        org.broadleafcommerce.common.config.service.SystemPropertiesServiceImpl.__L449 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/service/SystemPropertiesServiceImpl.java:234)", 449, "Numerical");
        org.broadleafcommerce.common.config.service.SystemPropertiesServiceImpl.__L450 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/service/SystemPropertiesServiceImpl.java:235)", 450, "Numerical");
        org.broadleafcommerce.common.config.service.SystemPropertiesServiceImpl.__L451 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/service/SystemPropertiesServiceImpl.java:240)", 451, "Boolean");
        org.broadleafcommerce.common.config.service.SystemPropertiesServiceImpl.__L452 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/service/SystemPropertiesServiceImpl.java:241)", 452, "Boolean");
        org.broadleafcommerce.common.config.service.SystemPropertiesServiceImpl.__L453 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/service/SystemPropertiesServiceImpl.java:244)", 453, "Boolean");
        org.broadleafcommerce.common.config.service.SystemPropertiesServiceImpl.__L454 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/service/SystemPropertiesServiceImpl.java:246)", 454, "Boolean");
        org.broadleafcommerce.common.config.service.SystemPropertiesServiceImpl.__L455 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/service/SystemPropertiesServiceImpl.java:246)", 455, "Boolean");
        org.broadleafcommerce.common.config.service.SystemPropertiesServiceImpl.__L456 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/service/SystemPropertiesServiceImpl.java:246)", 456, "Boolean");
        org.broadleafcommerce.common.config.service.SystemPropertiesServiceImpl.__L457 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/service/SystemPropertiesServiceImpl.java:246)", 457, "Boolean");
        org.broadleafcommerce.common.config.service.SystemPropertiesServiceImpl.__L458 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/service/SystemPropertiesServiceImpl.java:246)", 458, "Boolean");
        org.broadleafcommerce.common.config.service.SystemPropertiesServiceImpl.__L459 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/service/SystemPropertiesServiceImpl.java:247)", 459, "Boolean");
        org.broadleafcommerce.common.config.service.SystemPropertiesServiceImpl.__L460 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/service/SystemPropertiesServiceImpl.java:249)", 460, "Boolean");
        org.broadleafcommerce.common.config.service.SystemPropertiesServiceImpl.__L461 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/service/SystemPropertiesServiceImpl.java:252)", 461, "Boolean");
        org.broadleafcommerce.common.config.service.SystemPropertiesServiceImpl.__L462 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/service/SystemPropertiesServiceImpl.java:256)", 462, "Boolean");
        org.broadleafcommerce.common.config.service.SystemPropertiesServiceImpl.__L463 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/service/SystemPropertiesServiceImpl.java:259)", 463, "Boolean");
        org.broadleafcommerce.common.config.service.SystemPropertiesServiceImpl.__L464 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/service/SystemPropertiesServiceImpl.java:263)", 464, "Boolean");
        org.broadleafcommerce.common.config.service.SystemPropertiesServiceImpl.__L465 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/service/SystemPropertiesServiceImpl.java:266)", 465, "Boolean");
        org.broadleafcommerce.common.config.service.SystemPropertiesServiceImpl.__L466 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/service/SystemPropertiesServiceImpl.java:270)", 466, "Boolean");
        org.broadleafcommerce.common.config.service.SystemPropertiesServiceImpl.__L467 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/service/SystemPropertiesServiceImpl.java:271)", 467, "Boolean");
        org.broadleafcommerce.common.config.service.SystemPropertiesServiceImpl.__L468 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/config/service/SystemPropertiesServiceImpl.java:274)", 468, "Boolean");
    }

    static {
        org.broadleafcommerce.common.config.service.SystemPropertiesServiceImpl.initPerturbationLocation0();
    }
}

