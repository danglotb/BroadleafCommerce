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
package org.broadleafcommerce.common.web;


@org.springframework.stereotype.Component("blSandBoxResolver")
public class BroadleafSandBoxResolverImpl implements org.broadleafcommerce.common.web.BroadleafSandBoxResolver {
    private final org.apache.commons.logging.Log LOG = org.apache.commons.logging.LogFactory.getLog(org.broadleafcommerce.common.web.BroadleafSandBoxResolverImpl.class);

    protected java.lang.Boolean sandBoxPreviewEnabled = ((boolean) (true));

    private static java.lang.String SANDBOX_DATE_TIME_VAR = "blSandboxDateTime";

    private static final org.apache.commons.lang3.time.FastDateFormat CONTENT_DATE_FORMATTER = org.apache.commons.lang3.time.FastDateFormat.getInstance("yyyyMMddHHmm");

    private static final org.apache.commons.lang3.time.FastDateFormat CONTENT_DATE_DISPLAY_FORMATTER = org.apache.commons.lang3.time.FastDateFormat.getInstance("MM/dd/yyyy");

    private static final org.apache.commons.lang3.time.FastDateFormat CONTENT_DATE_DISPLAY_HOURS_FORMATTER = org.apache.commons.lang3.time.FastDateFormat.getInstance("h");

    private static final org.apache.commons.lang3.time.FastDateFormat CONTENT_DATE_DISPLAY_MINUTES_FORMATTER = org.apache.commons.lang3.time.FastDateFormat.getInstance("mm");

    private static final org.apache.commons.lang3.time.FastDateFormat CONTENT_DATE_PARSE_FORMAT = org.apache.commons.lang3.time.FastDateFormat.getInstance("MM/dd/yyyy hh:mm aa");

    private static java.lang.String SANDBOX_DATE_TIME_RIBBON_OVERRIDE_PARAM = "blSandboxDateTimeRibbonOverride";

    private static final java.lang.String SANDBOX_DISPLAY_DATE_TIME_DATE_PARAM = "blSandboxDisplayDateTimeDate";

    private static final java.lang.String SANDBOX_DISPLAY_DATE_TIME_HOURS_PARAM = "blSandboxDisplayDateTimeHours";

    private static final java.lang.String SANDBOX_DISPLAY_DATE_TIME_MINUTES_PARAM = "blSandboxDisplayDateTimeMinutes";

    private static final java.lang.String SANDBOX_DISPLAY_DATE_TIME_AMPM_PARAM = "blSandboxDisplayDateTimeAMPM";

    public static java.lang.String SANDBOX_VAR = "blSandbox";

    @javax.annotation.Resource(name = "blSandBoxDao")
    private org.broadleafcommerce.common.sandbox.dao.SandBoxDao sandBoxDao;

    @org.springframework.beans.factory.annotation.Autowired(required = false)
    @org.springframework.beans.factory.annotation.Qualifier("blCrossAppAuthService")
    protected org.broadleafcommerce.common.crossapp.service.CrossAppAuthService crossAppAuthService;

    @java.lang.Override
    public org.broadleafcommerce.common.sandbox.domain.SandBox resolveSandBox(javax.servlet.http.HttpServletRequest request, org.broadleafcommerce.common.site.domain.Site site) {
        return resolveSandBox(new org.springframework.web.context.request.ServletWebRequest(request), site);
    }

    @java.lang.Override
    public org.broadleafcommerce.common.sandbox.domain.SandBox resolveSandBox(org.springframework.web.context.request.WebRequest request, org.broadleafcommerce.common.site.domain.Site site) {
        java.lang.Long previousSandBoxId = null;
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BroadleafSandBoxResolverImpl.__L7923, org.broadleafcommerce.common.util.BLCRequestUtils.isOKtoUseSession(request))) {
            previousSandBoxId = ((java.lang.Long) (request.getAttribute(org.broadleafcommerce.common.web.BroadleafSandBoxResolver.SANDBOX_ID_VAR, perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.web.BroadleafSandBoxResolverImpl.__L7924, org.springframework.web.context.request.WebRequest.SCOPE_GLOBAL_SESSION))));
        }
        org.broadleafcommerce.common.sandbox.domain.SandBox currentSandbox = null;
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BroadleafSandBoxResolverImpl.__L7925, (!(sandBoxPreviewEnabled)))) {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BroadleafSandBoxResolverImpl.__L7926, LOG.isTraceEnabled())) {
                LOG.trace("Sandbox preview disabled. Setting sandbox to production");
            }
            request.setAttribute(org.broadleafcommerce.common.web.BroadleafSandBoxResolverImpl.SANDBOX_VAR, currentSandbox, perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.web.BroadleafSandBoxResolverImpl.__L7927, org.springframework.web.context.request.WebRequest.SCOPE_REQUEST));
        }else
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BroadleafSandBoxResolverImpl.__L7931, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BroadleafSandBoxResolverImpl.__L7928, ((crossAppAuthService) != null))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BroadleafSandBoxResolverImpl.__L7930, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BroadleafSandBoxResolverImpl.__L7929, crossAppAuthService.isAuthedFromAdmin())))))))) {
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BroadleafSandBoxResolverImpl.__L7932, LOG.isDebugEnabled())) {
                    LOG.debug("Sandbox preview attempted without authentication");
                }
                request.setAttribute(org.broadleafcommerce.common.web.BroadleafSandBoxResolverImpl.SANDBOX_VAR, currentSandbox, perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.web.BroadleafSandBoxResolverImpl.__L7933, org.springframework.web.context.request.WebRequest.SCOPE_REQUEST));
            }else
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BroadleafSandBoxResolverImpl.__L7936, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BroadleafSandBoxResolverImpl.__L7934, ((crossAppAuthService) != null))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BroadleafSandBoxResolverImpl.__L7935, crossAppAuthService.hasCsrPermission()))))) {
                    if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BroadleafSandBoxResolverImpl.__L7937, LOG.isDebugEnabled())) {
                        LOG.debug("Sandbox preview attempted in CSR mode");
                    }
                    request.setAttribute(org.broadleafcommerce.common.web.BroadleafSandBoxResolverImpl.SANDBOX_VAR, currentSandbox, perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.web.BroadleafSandBoxResolverImpl.__L7938, org.springframework.web.context.request.WebRequest.SCOPE_REQUEST));
                }else {
                    java.lang.Long sandboxId = null;
                    if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BroadleafSandBoxResolverImpl.__L7941, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BroadleafSandBoxResolverImpl.__L7939, ((request.getParameter("blClearSandBox")) == null))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BroadleafSandBoxResolverImpl.__L7940, ((request.getParameter("blSandboxDateTimeRibbonProduction")) == null)))))) {
                        sandboxId = lookupSandboxId(request);
                    }else {
                        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BroadleafSandBoxResolverImpl.__L7942, LOG.isTraceEnabled())) {
                            LOG.trace("Removing sandbox from session.");
                        }
                        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BroadleafSandBoxResolverImpl.__L7943, org.broadleafcommerce.common.util.BLCRequestUtils.isOKtoUseSession(request))) {
                            request.removeAttribute(org.broadleafcommerce.common.web.BroadleafSandBoxResolverImpl.SANDBOX_DATE_TIME_VAR, perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.web.BroadleafSandBoxResolverImpl.__L7944, org.springframework.web.context.request.WebRequest.SCOPE_GLOBAL_SESSION));
                            request.removeAttribute(org.broadleafcommerce.common.web.BroadleafSandBoxResolver.SANDBOX_ID_VAR, perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.web.BroadleafSandBoxResolverImpl.__L7945, org.springframework.web.context.request.WebRequest.SCOPE_GLOBAL_SESSION));
                        }
                        org.broadleafcommerce.common.time.SystemTime.resetLocalTimeSource();
                    }
                    if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BroadleafSandBoxResolverImpl.__L7946, (sandboxId != null))) {
                        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BroadleafSandBoxResolverImpl.__L7950, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BroadleafSandBoxResolverImpl.__L7947, (previousSandBoxId != null))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BroadleafSandBoxResolverImpl.__L7949, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BroadleafSandBoxResolverImpl.__L7948, previousSandBoxId.equals(sandboxId))))))))) {
                            request.setAttribute(org.broadleafcommerce.common.web.BroadleafRequestProcessor.REPROCESS_PARAM_NAME, perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BroadleafSandBoxResolverImpl.__L7951, true), perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.web.BroadleafSandBoxResolverImpl.__L7952, org.springframework.web.context.request.WebRequest.SCOPE_REQUEST));
                        }
                        currentSandbox = sandBoxDao.retrieve(sandboxId);
                        request.setAttribute(org.broadleafcommerce.common.web.BroadleafSandBoxResolverImpl.SANDBOX_VAR, currentSandbox, perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.web.BroadleafSandBoxResolverImpl.__L7953, org.springframework.web.context.request.WebRequest.SCOPE_REQUEST));
                        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BroadleafSandBoxResolverImpl.__L7957, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BroadleafSandBoxResolverImpl.__L7954, (currentSandbox != null))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BroadleafSandBoxResolverImpl.__L7956, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BroadleafSandBoxResolverImpl.__L7955, org.broadleafcommerce.common.sandbox.domain.SandBoxType.PRODUCTION.equals(currentSandbox.getSandBoxType()))))))))) {
                            setContentTime(request);
                        }
                    }
                }


        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BroadleafSandBoxResolverImpl.__L7958, LOG.isTraceEnabled())) {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BroadleafSandBoxResolverImpl.__L7959, (currentSandbox != null))) {
                LOG.trace(("Serving request using sandbox: " + currentSandbox));
            }else {
                LOG.trace("Serving request without a sandbox.");
            }
        }
        java.util.Date currentSystemDateTime = org.broadleafcommerce.common.time.SystemTime.asDate(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BroadleafSandBoxResolverImpl.__L7960, true));
        java.util.Calendar sandboxDateTimeCalendar = java.util.Calendar.getInstance();
        sandboxDateTimeCalendar.setTime(currentSystemDateTime);
        request.setAttribute(org.broadleafcommerce.common.web.BroadleafSandBoxResolverImpl.SANDBOX_DISPLAY_DATE_TIME_DATE_PARAM, org.broadleafcommerce.common.web.BroadleafSandBoxResolverImpl.CONTENT_DATE_DISPLAY_FORMATTER.format(currentSystemDateTime), perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.web.BroadleafSandBoxResolverImpl.__L7961, org.springframework.web.context.request.WebRequest.SCOPE_REQUEST));
        request.setAttribute(org.broadleafcommerce.common.web.BroadleafSandBoxResolverImpl.SANDBOX_DISPLAY_DATE_TIME_HOURS_PARAM, org.broadleafcommerce.common.web.BroadleafSandBoxResolverImpl.CONTENT_DATE_DISPLAY_HOURS_FORMATTER.format(currentSystemDateTime), perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.web.BroadleafSandBoxResolverImpl.__L7962, org.springframework.web.context.request.WebRequest.SCOPE_REQUEST));
        request.setAttribute(org.broadleafcommerce.common.web.BroadleafSandBoxResolverImpl.SANDBOX_DISPLAY_DATE_TIME_MINUTES_PARAM, org.broadleafcommerce.common.web.BroadleafSandBoxResolverImpl.CONTENT_DATE_DISPLAY_MINUTES_FORMATTER.format(currentSystemDateTime), perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.web.BroadleafSandBoxResolverImpl.__L7963, org.springframework.web.context.request.WebRequest.SCOPE_REQUEST));
        request.setAttribute(org.broadleafcommerce.common.web.BroadleafSandBoxResolverImpl.SANDBOX_DISPLAY_DATE_TIME_AMPM_PARAM, perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.web.BroadleafSandBoxResolverImpl.__L7965, sandboxDateTimeCalendar.get(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.web.BroadleafSandBoxResolverImpl.__L7964, java.util.Calendar.AM_PM))), perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.web.BroadleafSandBoxResolverImpl.__L7966, org.springframework.web.context.request.WebRequest.SCOPE_REQUEST));
        return currentSandbox;
    }

    private java.lang.Long lookupSandboxId(org.springframework.web.context.request.WebRequest request) {
        java.lang.String sandboxIdStr = request.getParameter(org.broadleafcommerce.common.web.BroadleafSandBoxResolver.SANDBOX_ID_VAR);
        java.lang.Long sandboxId = null;
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BroadleafSandBoxResolverImpl.__L7967, (sandboxIdStr != null))) {
            try {
                sandboxId = java.lang.Long.valueOf(sandboxIdStr);
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BroadleafSandBoxResolverImpl.__L7968, LOG.isTraceEnabled())) {
                    LOG.trace(("SandboxId found on request " + sandboxId));
                }
            } catch (java.lang.NumberFormatException nfe) {
                LOG.warn("blcSandboxId parameter could not be converted into a Long", nfe);
            }
        }
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BroadleafSandBoxResolverImpl.__L7969, org.broadleafcommerce.common.util.BLCRequestUtils.isOKtoUseSession(request))) {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BroadleafSandBoxResolverImpl.__L7970, (sandboxId == null))) {
                sandboxId = ((java.lang.Long) (request.getAttribute(org.broadleafcommerce.common.web.BroadleafSandBoxResolver.SANDBOX_ID_VAR, perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.web.BroadleafSandBoxResolverImpl.__L7971, org.springframework.web.context.request.WebRequest.SCOPE_GLOBAL_SESSION))));
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BroadleafSandBoxResolverImpl.__L7972, LOG.isTraceEnabled())) {
                    if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BroadleafSandBoxResolverImpl.__L7973, (sandboxId != null))) {
                        LOG.trace(("SandboxId found in session " + sandboxId));
                    }
                }
            }else {
                request.setAttribute(org.broadleafcommerce.common.web.BroadleafSandBoxResolver.SANDBOX_ID_VAR, sandboxId, perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.web.BroadleafSandBoxResolverImpl.__L7974, org.springframework.web.context.request.WebRequest.SCOPE_GLOBAL_SESSION));
            }
        }
        return sandboxId;
    }

    private void setContentTime(org.springframework.web.context.request.WebRequest request) {
        java.lang.String sandboxDateTimeParam = request.getParameter(org.broadleafcommerce.common.web.BroadleafSandBoxResolverImpl.SANDBOX_DATE_TIME_VAR);
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BroadleafSandBoxResolverImpl.__L7975, (!(sandBoxPreviewEnabled)))) {
            sandboxDateTimeParam = null;
        }
        java.util.Date overrideTime = null;
        try {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BroadleafSandBoxResolverImpl.__L7976, ((request.getParameter(org.broadleafcommerce.common.web.BroadleafSandBoxResolverImpl.SANDBOX_DATE_TIME_RIBBON_OVERRIDE_PARAM)) != null))) {
                overrideTime = readDateFromRequest(request);
            }else
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BroadleafSandBoxResolverImpl.__L7977, (sandboxDateTimeParam != null))) {
                    if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BroadleafSandBoxResolverImpl.__L7978, LOG.isDebugEnabled())) {
                        LOG.debug(("Setting date/time using " + (org.broadleafcommerce.common.util.StringUtil.sanitize(sandboxDateTimeParam))));
                    }
                    overrideTime = org.broadleafcommerce.common.web.BroadleafSandBoxResolverImpl.CONTENT_DATE_FORMATTER.parse(sandboxDateTimeParam);
                }

        } catch (java.text.ParseException e) {
            LOG.debug(e);
        }
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BroadleafSandBoxResolverImpl.__L7979, org.broadleafcommerce.common.util.BLCRequestUtils.isOKtoUseSession(request))) {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BroadleafSandBoxResolverImpl.__L7980, (overrideTime == null))) {
                overrideTime = ((java.util.Date) (request.getAttribute(org.broadleafcommerce.common.web.BroadleafSandBoxResolverImpl.SANDBOX_DATE_TIME_VAR, perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.web.BroadleafSandBoxResolverImpl.__L7981, org.springframework.web.context.request.WebRequest.SCOPE_GLOBAL_SESSION))));
            }else {
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BroadleafSandBoxResolverImpl.__L7982, LOG.isDebugEnabled())) {
                    LOG.debug(((("Setting date-time for sandbox mode to " + overrideTime) + " for sandboxDateTimeParam = ") + (org.broadleafcommerce.common.util.StringUtil.sanitize(sandboxDateTimeParam))));
                }
                request.setAttribute(org.broadleafcommerce.common.web.BroadleafSandBoxResolverImpl.SANDBOX_DATE_TIME_VAR, overrideTime, perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.web.BroadleafSandBoxResolverImpl.__L7983, org.springframework.web.context.request.WebRequest.SCOPE_GLOBAL_SESSION));
            }
        }
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BroadleafSandBoxResolverImpl.__L7984, (overrideTime != null))) {
            org.broadleafcommerce.common.time.FixedTimeSource ft = new org.broadleafcommerce.common.time.FixedTimeSource(perturbation.PerturbationEngine.plong(org.broadleafcommerce.common.web.BroadleafSandBoxResolverImpl.__L7985, overrideTime.getTime()));
            org.broadleafcommerce.common.time.SystemTime.setLocalTimeSource(ft);
        }else {
            org.broadleafcommerce.common.time.SystemTime.resetLocalTimeSource();
        }
    }

    private java.util.Date readDateFromRequest(org.springframework.web.context.request.WebRequest request) throws java.text.ParseException {
        java.lang.String date = request.getParameter(org.broadleafcommerce.common.web.BroadleafSandBoxResolverImpl.SANDBOX_DISPLAY_DATE_TIME_DATE_PARAM);
        java.lang.String minutes = request.getParameter(org.broadleafcommerce.common.web.BroadleafSandBoxResolverImpl.SANDBOX_DISPLAY_DATE_TIME_MINUTES_PARAM);
        java.lang.String hours = request.getParameter(org.broadleafcommerce.common.web.BroadleafSandBoxResolverImpl.SANDBOX_DISPLAY_DATE_TIME_HOURS_PARAM);
        java.lang.String ampm = request.getParameter(org.broadleafcommerce.common.web.BroadleafSandBoxResolverImpl.SANDBOX_DISPLAY_DATE_TIME_AMPM_PARAM);
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BroadleafSandBoxResolverImpl.__L7986, org.apache.commons.lang.StringUtils.isEmpty(minutes))) {
            minutes = java.lang.Integer.toString(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.web.BroadleafSandBoxResolverImpl.__L7988, org.broadleafcommerce.common.time.SystemTime.asCalendar().get(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.web.BroadleafSandBoxResolverImpl.__L7987, java.util.Calendar.MINUTE))));
        }
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BroadleafSandBoxResolverImpl.__L7989, org.apache.commons.lang.StringUtils.isEmpty(hours))) {
            hours = java.lang.Integer.toString(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.web.BroadleafSandBoxResolverImpl.__L7991, org.broadleafcommerce.common.time.SystemTime.asCalendar().get(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.web.BroadleafSandBoxResolverImpl.__L7990, java.util.Calendar.HOUR_OF_DAY))));
        }
        java.lang.String dateString = (((((date + " ") + hours) + ":") + minutes) + " ") + ampm;
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.web.BroadleafSandBoxResolverImpl.__L7992, LOG.isDebugEnabled())) {
            LOG.debug(("Setting date/time using " + (org.broadleafcommerce.common.util.StringUtil.sanitize(dateString))));
        }
        java.util.Date parsedDate = org.broadleafcommerce.common.web.BroadleafSandBoxResolverImpl.CONTENT_DATE_PARSE_FORMAT.parse(dateString);
        return parsedDate;
    }

    public java.lang.Boolean getSandBoxPreviewEnabled() {
        return sandBoxPreviewEnabled;
    }

    public void setSandBoxPreviewEnabled(java.lang.Boolean sandBoxPreviewEnabled) {
        this.sandBoxPreviewEnabled = sandBoxPreviewEnabled;
    }

    public static perturbation.location.PerturbationLocation __L7923;

    public static perturbation.location.PerturbationLocation __L7924;

    public static perturbation.location.PerturbationLocation __L7925;

    public static perturbation.location.PerturbationLocation __L7926;

    public static perturbation.location.PerturbationLocation __L7927;

    public static perturbation.location.PerturbationLocation __L7928;

    public static perturbation.location.PerturbationLocation __L7929;

    public static perturbation.location.PerturbationLocation __L7930;

    public static perturbation.location.PerturbationLocation __L7931;

    public static perturbation.location.PerturbationLocation __L7932;

    public static perturbation.location.PerturbationLocation __L7933;

    public static perturbation.location.PerturbationLocation __L7934;

    public static perturbation.location.PerturbationLocation __L7935;

    public static perturbation.location.PerturbationLocation __L7936;

    public static perturbation.location.PerturbationLocation __L7937;

    public static perturbation.location.PerturbationLocation __L7938;

    public static perturbation.location.PerturbationLocation __L7939;

    public static perturbation.location.PerturbationLocation __L7940;

    public static perturbation.location.PerturbationLocation __L7941;

    public static perturbation.location.PerturbationLocation __L7942;

    public static perturbation.location.PerturbationLocation __L7943;

    public static perturbation.location.PerturbationLocation __L7944;

    public static perturbation.location.PerturbationLocation __L7945;

    public static perturbation.location.PerturbationLocation __L7946;

    public static perturbation.location.PerturbationLocation __L7947;

    public static perturbation.location.PerturbationLocation __L7948;

    public static perturbation.location.PerturbationLocation __L7949;

    public static perturbation.location.PerturbationLocation __L7950;

    public static perturbation.location.PerturbationLocation __L7951;

    public static perturbation.location.PerturbationLocation __L7952;

    public static perturbation.location.PerturbationLocation __L7953;

    public static perturbation.location.PerturbationLocation __L7954;

    public static perturbation.location.PerturbationLocation __L7955;

    public static perturbation.location.PerturbationLocation __L7956;

    public static perturbation.location.PerturbationLocation __L7957;

    public static perturbation.location.PerturbationLocation __L7958;

    public static perturbation.location.PerturbationLocation __L7959;

    public static perturbation.location.PerturbationLocation __L7960;

    public static perturbation.location.PerturbationLocation __L7961;

    public static perturbation.location.PerturbationLocation __L7962;

    public static perturbation.location.PerturbationLocation __L7963;

    public static perturbation.location.PerturbationLocation __L7964;

    public static perturbation.location.PerturbationLocation __L7965;

    public static perturbation.location.PerturbationLocation __L7966;

    public static perturbation.location.PerturbationLocation __L7967;

    public static perturbation.location.PerturbationLocation __L7968;

    public static perturbation.location.PerturbationLocation __L7969;

    public static perturbation.location.PerturbationLocation __L7970;

    public static perturbation.location.PerturbationLocation __L7971;

    public static perturbation.location.PerturbationLocation __L7972;

    public static perturbation.location.PerturbationLocation __L7973;

    public static perturbation.location.PerturbationLocation __L7974;

    public static perturbation.location.PerturbationLocation __L7975;

    public static perturbation.location.PerturbationLocation __L7976;

    public static perturbation.location.PerturbationLocation __L7977;

    public static perturbation.location.PerturbationLocation __L7978;

    public static perturbation.location.PerturbationLocation __L7979;

    public static perturbation.location.PerturbationLocation __L7980;

    public static perturbation.location.PerturbationLocation __L7981;

    public static perturbation.location.PerturbationLocation __L7982;

    public static perturbation.location.PerturbationLocation __L7983;

    public static perturbation.location.PerturbationLocation __L7984;

    public static perturbation.location.PerturbationLocation __L7985;

    public static perturbation.location.PerturbationLocation __L7986;

    public static perturbation.location.PerturbationLocation __L7987;

    public static perturbation.location.PerturbationLocation __L7988;

    public static perturbation.location.PerturbationLocation __L7989;

    public static perturbation.location.PerturbationLocation __L7990;

    public static perturbation.location.PerturbationLocation __L7991;

    public static perturbation.location.PerturbationLocation __L7992;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.web.BroadleafSandBoxResolverImpl.__L7923 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafSandBoxResolverImpl.java:108)", 7923, "Boolean");
        org.broadleafcommerce.common.web.BroadleafSandBoxResolverImpl.__L7924 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafSandBoxResolverImpl.java:109)", 7924, "Numerical");
        org.broadleafcommerce.common.web.BroadleafSandBoxResolverImpl.__L7925 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafSandBoxResolverImpl.java:112)", 7925, "Boolean");
        org.broadleafcommerce.common.web.BroadleafSandBoxResolverImpl.__L7926 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafSandBoxResolverImpl.java:113)", 7926, "Boolean");
        org.broadleafcommerce.common.web.BroadleafSandBoxResolverImpl.__L7927 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafSandBoxResolverImpl.java:116)", 7927, "Numerical");
        org.broadleafcommerce.common.web.BroadleafSandBoxResolverImpl.__L7928 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafSandBoxResolverImpl.java:117)", 7928, "Boolean");
        org.broadleafcommerce.common.web.BroadleafSandBoxResolverImpl.__L7929 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafSandBoxResolverImpl.java:117)", 7929, "Boolean");
        org.broadleafcommerce.common.web.BroadleafSandBoxResolverImpl.__L7930 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafSandBoxResolverImpl.java:117)", 7930, "Boolean");
        org.broadleafcommerce.common.web.BroadleafSandBoxResolverImpl.__L7931 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafSandBoxResolverImpl.java:117)", 7931, "Boolean");
        org.broadleafcommerce.common.web.BroadleafSandBoxResolverImpl.__L7932 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafSandBoxResolverImpl.java:118)", 7932, "Boolean");
        org.broadleafcommerce.common.web.BroadleafSandBoxResolverImpl.__L7933 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafSandBoxResolverImpl.java:121)", 7933, "Numerical");
        org.broadleafcommerce.common.web.BroadleafSandBoxResolverImpl.__L7934 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafSandBoxResolverImpl.java:122)", 7934, "Boolean");
        org.broadleafcommerce.common.web.BroadleafSandBoxResolverImpl.__L7935 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafSandBoxResolverImpl.java:122)", 7935, "Boolean");
        org.broadleafcommerce.common.web.BroadleafSandBoxResolverImpl.__L7936 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafSandBoxResolverImpl.java:122)", 7936, "Boolean");
        org.broadleafcommerce.common.web.BroadleafSandBoxResolverImpl.__L7937 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafSandBoxResolverImpl.java:123)", 7937, "Boolean");
        org.broadleafcommerce.common.web.BroadleafSandBoxResolverImpl.__L7938 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafSandBoxResolverImpl.java:126)", 7938, "Numerical");
        org.broadleafcommerce.common.web.BroadleafSandBoxResolverImpl.__L7939 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafSandBoxResolverImpl.java:130)", 7939, "Boolean");
        org.broadleafcommerce.common.web.BroadleafSandBoxResolverImpl.__L7940 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafSandBoxResolverImpl.java:130)", 7940, "Boolean");
        org.broadleafcommerce.common.web.BroadleafSandBoxResolverImpl.__L7941 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafSandBoxResolverImpl.java:130)", 7941, "Boolean");
        org.broadleafcommerce.common.web.BroadleafSandBoxResolverImpl.__L7942 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafSandBoxResolverImpl.java:133)", 7942, "Boolean");
        org.broadleafcommerce.common.web.BroadleafSandBoxResolverImpl.__L7943 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafSandBoxResolverImpl.java:136)", 7943, "Boolean");
        org.broadleafcommerce.common.web.BroadleafSandBoxResolverImpl.__L7944 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafSandBoxResolverImpl.java:137)", 7944, "Numerical");
        org.broadleafcommerce.common.web.BroadleafSandBoxResolverImpl.__L7945 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafSandBoxResolverImpl.java:138)", 7945, "Numerical");
        org.broadleafcommerce.common.web.BroadleafSandBoxResolverImpl.__L7946 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafSandBoxResolverImpl.java:142)", 7946, "Boolean");
        org.broadleafcommerce.common.web.BroadleafSandBoxResolverImpl.__L7947 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafSandBoxResolverImpl.java:143)", 7947, "Boolean");
        org.broadleafcommerce.common.web.BroadleafSandBoxResolverImpl.__L7948 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafSandBoxResolverImpl.java:143)", 7948, "Boolean");
        org.broadleafcommerce.common.web.BroadleafSandBoxResolverImpl.__L7949 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafSandBoxResolverImpl.java:143)", 7949, "Boolean");
        org.broadleafcommerce.common.web.BroadleafSandBoxResolverImpl.__L7950 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafSandBoxResolverImpl.java:143)", 7950, "Boolean");
        org.broadleafcommerce.common.web.BroadleafSandBoxResolverImpl.__L7951 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafSandBoxResolverImpl.java:144)", 7951, "Boolean");
        org.broadleafcommerce.common.web.BroadleafSandBoxResolverImpl.__L7952 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafSandBoxResolverImpl.java:144)", 7952, "Numerical");
        org.broadleafcommerce.common.web.BroadleafSandBoxResolverImpl.__L7953 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafSandBoxResolverImpl.java:148)", 7953, "Numerical");
        org.broadleafcommerce.common.web.BroadleafSandBoxResolverImpl.__L7954 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafSandBoxResolverImpl.java:149)", 7954, "Boolean");
        org.broadleafcommerce.common.web.BroadleafSandBoxResolverImpl.__L7955 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafSandBoxResolverImpl.java:149)", 7955, "Boolean");
        org.broadleafcommerce.common.web.BroadleafSandBoxResolverImpl.__L7956 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafSandBoxResolverImpl.java:149)", 7956, "Boolean");
        org.broadleafcommerce.common.web.BroadleafSandBoxResolverImpl.__L7957 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafSandBoxResolverImpl.java:149)", 7957, "Boolean");
        org.broadleafcommerce.common.web.BroadleafSandBoxResolverImpl.__L7958 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafSandBoxResolverImpl.java:159)", 7958, "Boolean");
        org.broadleafcommerce.common.web.BroadleafSandBoxResolverImpl.__L7959 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafSandBoxResolverImpl.java:160)", 7959, "Boolean");
        org.broadleafcommerce.common.web.BroadleafSandBoxResolverImpl.__L7960 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafSandBoxResolverImpl.java:167)", 7960, "Boolean");
        org.broadleafcommerce.common.web.BroadleafSandBoxResolverImpl.__L7961 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafSandBoxResolverImpl.java:170)", 7961, "Numerical");
        org.broadleafcommerce.common.web.BroadleafSandBoxResolverImpl.__L7962 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafSandBoxResolverImpl.java:171)", 7962, "Numerical");
        org.broadleafcommerce.common.web.BroadleafSandBoxResolverImpl.__L7963 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafSandBoxResolverImpl.java:172)", 7963, "Numerical");
        org.broadleafcommerce.common.web.BroadleafSandBoxResolverImpl.__L7964 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafSandBoxResolverImpl.java:173)", 7964, "Numerical");
        org.broadleafcommerce.common.web.BroadleafSandBoxResolverImpl.__L7965 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafSandBoxResolverImpl.java:173)", 7965, "Numerical");
        org.broadleafcommerce.common.web.BroadleafSandBoxResolverImpl.__L7966 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafSandBoxResolverImpl.java:173)", 7966, "Numerical");
        org.broadleafcommerce.common.web.BroadleafSandBoxResolverImpl.__L7967 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafSandBoxResolverImpl.java:188)", 7967, "Boolean");
        org.broadleafcommerce.common.web.BroadleafSandBoxResolverImpl.__L7968 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafSandBoxResolverImpl.java:191)", 7968, "Boolean");
        org.broadleafcommerce.common.web.BroadleafSandBoxResolverImpl.__L7969 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafSandBoxResolverImpl.java:199)", 7969, "Boolean");
        org.broadleafcommerce.common.web.BroadleafSandBoxResolverImpl.__L7970 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafSandBoxResolverImpl.java:200)", 7970, "Boolean");
        org.broadleafcommerce.common.web.BroadleafSandBoxResolverImpl.__L7971 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafSandBoxResolverImpl.java:202)", 7971, "Numerical");
        org.broadleafcommerce.common.web.BroadleafSandBoxResolverImpl.__L7972 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafSandBoxResolverImpl.java:204)", 7972, "Boolean");
        org.broadleafcommerce.common.web.BroadleafSandBoxResolverImpl.__L7973 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafSandBoxResolverImpl.java:205)", 7973, "Boolean");
        org.broadleafcommerce.common.web.BroadleafSandBoxResolverImpl.__L7974 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafSandBoxResolverImpl.java:210)", 7974, "Numerical");
        org.broadleafcommerce.common.web.BroadleafSandBoxResolverImpl.__L7975 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafSandBoxResolverImpl.java:223)", 7975, "Boolean");
        org.broadleafcommerce.common.web.BroadleafSandBoxResolverImpl.__L7976 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafSandBoxResolverImpl.java:229)", 7976, "Boolean");
        org.broadleafcommerce.common.web.BroadleafSandBoxResolverImpl.__L7977 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafSandBoxResolverImpl.java:231)", 7977, "Boolean");
        org.broadleafcommerce.common.web.BroadleafSandBoxResolverImpl.__L7978 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafSandBoxResolverImpl.java:232)", 7978, "Boolean");
        org.broadleafcommerce.common.web.BroadleafSandBoxResolverImpl.__L7979 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafSandBoxResolverImpl.java:241)", 7979, "Boolean");
        org.broadleafcommerce.common.web.BroadleafSandBoxResolverImpl.__L7980 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafSandBoxResolverImpl.java:242)", 7980, "Boolean");
        org.broadleafcommerce.common.web.BroadleafSandBoxResolverImpl.__L7981 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafSandBoxResolverImpl.java:243)", 7981, "Numerical");
        org.broadleafcommerce.common.web.BroadleafSandBoxResolverImpl.__L7982 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafSandBoxResolverImpl.java:245)", 7982, "Boolean");
        org.broadleafcommerce.common.web.BroadleafSandBoxResolverImpl.__L7983 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafSandBoxResolverImpl.java:248)", 7983, "Numerical");
        org.broadleafcommerce.common.web.BroadleafSandBoxResolverImpl.__L7984 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafSandBoxResolverImpl.java:252)", 7984, "Boolean");
        org.broadleafcommerce.common.web.BroadleafSandBoxResolverImpl.__L7985 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafSandBoxResolverImpl.java:253)", 7985, "Numerical");
        org.broadleafcommerce.common.web.BroadleafSandBoxResolverImpl.__L7986 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafSandBoxResolverImpl.java:266)", 7986, "Boolean");
        org.broadleafcommerce.common.web.BroadleafSandBoxResolverImpl.__L7987 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafSandBoxResolverImpl.java:267)", 7987, "Numerical");
        org.broadleafcommerce.common.web.BroadleafSandBoxResolverImpl.__L7988 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafSandBoxResolverImpl.java:267)", 7988, "Numerical");
        org.broadleafcommerce.common.web.BroadleafSandBoxResolverImpl.__L7989 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafSandBoxResolverImpl.java:270)", 7989, "Boolean");
        org.broadleafcommerce.common.web.BroadleafSandBoxResolverImpl.__L7990 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafSandBoxResolverImpl.java:271)", 7990, "Numerical");
        org.broadleafcommerce.common.web.BroadleafSandBoxResolverImpl.__L7991 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafSandBoxResolverImpl.java:271)", 7991, "Numerical");
        org.broadleafcommerce.common.web.BroadleafSandBoxResolverImpl.__L7992 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/web/BroadleafSandBoxResolverImpl.java:276)", 7992, "Boolean");
    }

    static {
        org.broadleafcommerce.common.web.BroadleafSandBoxResolverImpl.initPerturbationLocation0();
    }
}

