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
package org.broadleafcommerce.common.presentation.override;


public class PropertyType {
    public static class AdminTabPresentation {
        public static final java.lang.String NAME = "name";

        public static final java.lang.String ORDER = "order";
    }

    public static class AdminGroupPresentation {
        public static final java.lang.String NAME = "name";

        public static final java.lang.String ORDER = "order";

        public static final java.lang.String COLUMN = "column";

        public static final java.lang.String UNTITLED = "untitled";

        public static final java.lang.String TOOLTIP = "tooltip";

        public static final java.lang.String COLLAPSED = "collapsed";
    }

    public static class AdminPresentation {
        public static final java.lang.String FRIENDLYNAME = "friendlyName";

        public static final java.lang.String ADDFRIENDLYNAME = "addFriendlyName";

        public static final java.lang.String SECURITYLEVEL = "securityLevel";

        public static final java.lang.String ORDER = "order";

        public static final java.lang.String GRIDORDER = "gridOrder";

        public static final java.lang.String VISIBILITY = "visibility";

        public static final java.lang.String FIELDTYPE = "fieldType";

        public static final java.lang.String LARGEENTRY = "largeEntry";

        public static final java.lang.String PROMINENT = "prominent";

        public static final java.lang.String COLUMNWIDTH = "columnWidth";

        public static final java.lang.String BROADLEAFENUMERATION = "broadleafEnumeration";

        public static final java.lang.String HIDEENUMERATIONIFEMPTY = "hideEnumerationIfEmpty";

        public static final java.lang.String FIELDCOMPONENTRENDERER = "fieldComponentRenderer";

        public static final java.lang.String REQUIREDOVERRIDE = "requiredOverride";

        public static final java.lang.String EXCLUDED = "excluded";

        public static final java.lang.String TOOLTIP = "tooltip";

        public static final java.lang.String HELPTEXT = "helpText";

        public static final java.lang.String HINT = "hint";

        public static final java.lang.String SHOWIFPROPERTY = "showIfProperty";

        public static final java.lang.String SHOWIFFIELDEQUALS = "showIfFieldEquals";

        public static final java.lang.String CURRENCYCODEFIELD = "currencyCodeField";

        public static final java.lang.String RULEIDENTIFIER = "ruleIdentifier";

        public static final java.lang.String READONLY = "readOnly";

        public static final java.lang.String VALIDATIONCONFIGURATIONS = "validationConfigurations";

        public static final java.lang.String DEFAULTVALUE = "defaultValue";

        public static final java.lang.String GROUP = "group";

        public static final java.lang.String TAB = "tab";

        public static final java.lang.String CANLINKTOEXTERNALENTITY = "canLinkToExternalEntity";

        public static final java.lang.String TRANSLATABLE = "translatable";

        public static final java.lang.String ASSOCIATEDFIELDNAME = "associatedFieldName";

        @java.lang.Deprecated
        public static final java.lang.String GROUPORDER = "groupOrder";

        @java.lang.Deprecated
        public static final java.lang.String GROUPCOLLAPSED = "groupCollapsed";

        @java.lang.Deprecated
        public static final java.lang.String TABORDER = "tabOrder";
    }

    public static class AdminPresentationToOneLookup {
        public static final java.lang.String LOOKUPDISPLAYPROPERTY = "lookupDisplayProperty";

        public static final java.lang.String USESERVERSIDEINSPECTIONCACHE = "useServerSideInspectionCache";

        public static final java.lang.String LOOKUPTYPE = "lookupType";

        public static final java.lang.String CUSTOMCRITERIA = "customCriteria";

        public static final java.lang.String FORCEPOPULATECHILDPROPERTIES = "forcePopulateChildProperties";

        public static final java.lang.String ENABLETYPEAHEADLOOKUP = "enableTypeaheadLookup";
    }

    public static class AdminPresentationDataDrivenEnumeration {
        public static final java.lang.String OPTIONLISTENTITY = "optionListEntity";

        public static final java.lang.String OPTIONVALUEFIELDNAME = "optionValueFieldName";

        public static final java.lang.String OPTIONDISPLAYFIELDNAME = "optionDisplayFieldName";

        public static final java.lang.String OPTIONCANEDITVALUES = "optionCanEditValues";

        public static final java.lang.String OPTIONFILTERPARAMS = "optionFilterParams";

        public static final java.lang.String OPTIONHIDEIFEMPTY = "optionHideIfEmpty";
    }

    public static class AdminPresentationAdornedTargetCollection {
        public static final java.lang.String FRIENDLYNAME = "friendlyName";

        public static final java.lang.String SECURITYLEVEL = "securityLevel";

        public static final java.lang.String EXCLUDED = "excluded";

        public static final java.lang.String SHOWIFPROPERTY = "showIfProperty";

        public static final java.lang.String SHOWIFFIELDEQUALS = "showIfFieldEquals";

        public static final java.lang.String READONLY = "readOnly";

        public static final java.lang.String USESERVERSIDEINSPECTIONCACHE = "useServerSideInspectionCache";

        public static final java.lang.String PARENTOBJECTPROPERTY = "parentObjectProperty";

        public static final java.lang.String PARENTOBJECTIDPROPERTY = "parentObjectIdProperty";

        public static final java.lang.String TARGETOBJECTPROPERTY = "targetObjectProperty";

        public static final java.lang.String MAINTAINEDADORNEDTARGETFIELDS = "maintainedAdornedTargetFields";

        public static final java.lang.String GRIDVISIBLEFIELDS = "gridVisibleFields";

        public static final java.lang.String SELECTIZEVISIBLEFIELD = "selectizeVisibleField";

        public static final java.lang.String TARGETOBJECTIDPROPERTY = "targetObjectIdProperty";

        public static final java.lang.String JOINENTITYCLASS = "joinEntityClass";

        public static final java.lang.String SORTPROPERTY = "sortProperty";

        public static final java.lang.String SORTASCENDING = "sortAscending";

        public static final java.lang.String IGNOREADORNEDPROPERTIES = "ignoreAdornedProperties";

        public static final java.lang.String ORDER = "order";

        public static final java.lang.String CUSTOMCRITERIA = "customCriteria";

        public static final java.lang.String CURRENCYCODEFIELD = "currencyCodeField";

        public static final java.lang.String OPERATIONTYPES = "operationTypes";

        public static final java.lang.String GROUP = "group";

        public static final java.lang.String ADORNEDTARGETADDTYPE = "adornedTargetAddType";

        @java.lang.Deprecated
        public static final java.lang.String TAB = "tab";

        @java.lang.Deprecated
        public static final java.lang.String TABORDER = "tabOrder";
    }

    public static class AdminPresentationCollection {
        public static final java.lang.String FRIENDLYNAME = "friendlyName";

        public static final java.lang.String ADDFRIENDLYNAME = "addFriendlyName";

        public static final java.lang.String SECURITYLEVEL = "securityLevel";

        public static final java.lang.String EXCLUDED = "excluded";

        public static final java.lang.String READONLY = "readOnly";

        public static final java.lang.String USESERVERSIDEINSPECTIONCACHE = "useServerSideInspectionCache";

        public static final java.lang.String ADDTYPE = "addType";

        public static final java.lang.String SELECTIZEVISIBLEFIELD = "selectizeVisibleField";

        public static final java.lang.String MANYTOFIELD = "manyToField";

        public static final java.lang.String ORDER = "order";

        public static final java.lang.String SORTPROPERTY = "sortProperty";

        public static final java.lang.String SORTASCENDING = "sortAscending";

        public static final java.lang.String CUSTOMCRITERIA = "customCriteria";

        public static final java.lang.String OPERATIONTYPES = "operationTypes";

        public static final java.lang.String SHOWIFPROPERTY = "showIfProperty";

        public static final java.lang.String SHOWIFFIELDEQUALS = "showIfFieldEquals";

        public static final java.lang.String CURRENCYCODEFIELD = "currencyCodeField";

        public static final java.lang.String GROUP = "group";

        @java.lang.Deprecated
        public static final java.lang.String TAB = "tab";

        @java.lang.Deprecated
        public static final java.lang.String TABORDER = "tabOrder";
    }

    public static class AdminPresentationMap {
        public static final java.lang.String FRIENDLYNAME = "friendlyName";

        public static final java.lang.String SECURITYLEVEL = "securityLevel";

        public static final java.lang.String EXCLUDED = "excluded";

        public static final java.lang.String READONLY = "readOnly";

        public static final java.lang.String USESERVERSIDEINSPECTIONCACHE = "useServerSideInspectionCache";

        public static final java.lang.String ORDER = "order";

        public static final java.lang.String KEYCLASS = "keyClass";

        public static final java.lang.String MAPKEYVALUEPROPERTY = "mapKeyValueProperty";

        public static final java.lang.String KEYPROPERTYFRIENDLYNAME = "keyPropertyFriendlyName";

        public static final java.lang.String VALUECLASS = "valueClass";

        public static final java.lang.String DELETEENTITYUPONREMOVE = "deleteEntityUponRemove";

        public static final java.lang.String VALUEPROPERTYFRIENDLYNAME = "valuePropertyFriendlyName";

        public static final java.lang.String ISSIMPLEVALUE = "isSimpleValue";

        public static final java.lang.String MEDIAFIELD = "mediaField";

        public static final java.lang.String KEYS = "keys";

        public static final java.lang.String FORCEFREEFORMKEYS = "forceFreeFormKeys";

        public static final java.lang.String MANYTOFIELD = "manyToField";

        public static final java.lang.String MAPKEYOPTIONENTITYCLASS = "mapKeyOptionEntityClass";

        public static final java.lang.String MAPKEYOPTIONENTITYDISPLAYFIELD = "mapKeyOptionEntityDisplayField";

        public static final java.lang.String MAPKEYOPTIONENTITYVALUEFIELD = "mapKeyOptionEntityValueField";

        public static final java.lang.String CUSTOMCRITERIA = "customCriteria";

        public static final java.lang.String OPERATIONTYPES = "operationTypes";

        public static final java.lang.String SHOWIFPROPERTY = "showIfProperty";

        public static final java.lang.String SHOWIFFIELDEQUALS = "showIfFieldEquals";

        public static final java.lang.String CURRENCYCODEFIELD = "currencyCodeField";

        public static final java.lang.String GROUP = "group";

        @java.lang.Deprecated
        public static final java.lang.String TAB = "tab";

        @java.lang.Deprecated
        public static final java.lang.String TABORDER = "tabOrder";
    }
}

