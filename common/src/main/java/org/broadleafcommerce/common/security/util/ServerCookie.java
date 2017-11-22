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
package org.broadleafcommerce.common.security.util;


public class ServerCookie {
    private static final java.lang.String tspecials = ",; ";

    private static final java.lang.String tspecials2 = "()<>@,;:\\\"/[]?={} \t";

    private static final java.lang.String tspecials2NoSlash = "()<>@,;:\\\"[]?={} \t";

    private static final java.lang.String OLD_COOKIE_PATTERN = "EEE, dd-MMM-yyyy HH:mm:ss z";

    private static final java.lang.ThreadLocal<java.text.DateFormat> OLD_COOKIE_FORMAT = new java.lang.ThreadLocal<java.text.DateFormat>() {
        protected java.text.DateFormat initialValue() {
            java.text.DateFormat df = new java.text.SimpleDateFormat(org.broadleafcommerce.common.security.util.ServerCookie.OLD_COOKIE_PATTERN, java.util.Locale.US);
            df.setTimeZone(java.util.TimeZone.getTimeZone("GMT"));
            return df;
        }
    };

    private static final java.lang.String ancientDate;

    public static final boolean STRICT_SERVLET_COMPLIANCE = false;

    public static final boolean ALWAYS_ADD_EXPIRES = true;

    public static void appendCookieValue(java.lang.StringBuffer headerBuf, int version, java.lang.String name, java.lang.String value, java.lang.String path, java.lang.String domain, java.lang.String comment, int maxAge, boolean isSecure, boolean isHttpOnly) {
        java.lang.StringBuffer buf = new java.lang.StringBuffer();
        buf.append(name);
        buf.append("=");
        version = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.security.util.ServerCookie.__L4920, org.broadleafcommerce.common.security.util.ServerCookie.maybeQuote2(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.security.util.ServerCookie.__L4918, version), buf, value, perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.security.util.ServerCookie.__L4919, true)));
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.security.util.ServerCookie.__L4923, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.security.util.ServerCookie.__L4921, version)) == (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.security.util.ServerCookie.__L4922, 1))))) {
            buf.append("; Version=1");
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.security.util.ServerCookie.__L4924, (comment != null))) {
                buf.append("; Comment=");
                org.broadleafcommerce.common.security.util.ServerCookie.maybeQuote2(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.security.util.ServerCookie.__L4925, version), buf, comment);
            }
        }
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.security.util.ServerCookie.__L4926, (domain != null))) {
            buf.append("; Domain=");
            org.broadleafcommerce.common.security.util.ServerCookie.maybeQuote2(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.security.util.ServerCookie.__L4927, version), buf, domain);
        }
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.security.util.ServerCookie.__L4930, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.security.util.ServerCookie.__L4928, maxAge)) >= (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.security.util.ServerCookie.__L4929, 0))))) {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.security.util.ServerCookie.__L4933, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.security.util.ServerCookie.__L4931, version)) > (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.security.util.ServerCookie.__L4932, 0))))) {
                buf.append("; Max-Age=");
                buf.append(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.security.util.ServerCookie.__L4934, maxAge));
            }
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.security.util.ServerCookie.__L4939, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.security.util.ServerCookie.__L4937, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.security.util.ServerCookie.__L4935, version)) == (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.security.util.ServerCookie.__L4936, 0))))) || (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.security.util.ServerCookie.__L4938, org.broadleafcommerce.common.security.util.ServerCookie.ALWAYS_ADD_EXPIRES))))) {
                buf.append("; Expires=");
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.security.util.ServerCookie.__L4942, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.security.util.ServerCookie.__L4940, maxAge)) == (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.security.util.ServerCookie.__L4941, 0)))))
                    buf.append(org.broadleafcommerce.common.security.util.ServerCookie.ancientDate);
                else
                    org.broadleafcommerce.common.security.util.ServerCookie.OLD_COOKIE_FORMAT.get().format(new java.util.Date(perturbation.PerturbationEngine.plong(org.broadleafcommerce.common.security.util.ServerCookie.__L4947, ((perturbation.PerturbationEngine.plong(org.broadleafcommerce.common.security.util.ServerCookie.__L4943, java.lang.System.currentTimeMillis())) + (perturbation.PerturbationEngine.plong(org.broadleafcommerce.common.security.util.ServerCookie.__L4946, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.security.util.ServerCookie.__L4944, maxAge)) * (perturbation.PerturbationEngine.plong(org.broadleafcommerce.common.security.util.ServerCookie.__L4945, 1000L)))))))), buf, new java.text.FieldPosition(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.security.util.ServerCookie.__L4948, 0)));

            }
        }
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.security.util.ServerCookie.__L4949, (path != null))) {
            buf.append("; Path=");
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.security.util.ServerCookie.__L4952, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.security.util.ServerCookie.__L4950, version)) == (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.security.util.ServerCookie.__L4951, 0))))) {
                org.broadleafcommerce.common.security.util.ServerCookie.maybeQuote2(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.security.util.ServerCookie.__L4953, version), buf, path);
            }else {
                org.broadleafcommerce.common.security.util.ServerCookie.maybeQuote2(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.security.util.ServerCookie.__L4954, version), buf, path, org.broadleafcommerce.common.security.util.ServerCookie.tspecials2NoSlash, perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.security.util.ServerCookie.__L4955, false));
            }
        }
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.security.util.ServerCookie.__L4956, isSecure)) {
            buf.append("; Secure");
        }
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.security.util.ServerCookie.__L4957, isHttpOnly)) {
            buf.append("; HttpOnly");
        }
        headerBuf.append(buf);
    }

    public static int maybeQuote2(int version, java.lang.StringBuffer buf, java.lang.String value) {
        return perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.security.util.ServerCookie.__L4960, org.broadleafcommerce.common.security.util.ServerCookie.maybeQuote2(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.security.util.ServerCookie.__L4958, version), buf, value, perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.security.util.ServerCookie.__L4959, false)));
    }

    public static int maybeQuote2(int version, java.lang.StringBuffer buf, java.lang.String value, boolean allowVersionSwitch) {
        return perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.security.util.ServerCookie.__L4963, org.broadleafcommerce.common.security.util.ServerCookie.maybeQuote2(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.security.util.ServerCookie.__L4961, version), buf, value, null, perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.security.util.ServerCookie.__L4962, allowVersionSwitch)));
    }

    public static int maybeQuote2(int version, java.lang.StringBuffer buf, java.lang.String value, java.lang.String literals, boolean allowVersionSwitch) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.security.util.ServerCookie.__L4968, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.security.util.ServerCookie.__L4964, (value == null))) || (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.security.util.ServerCookie.__L4967, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.security.util.ServerCookie.__L4965, value.length())) == (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.security.util.ServerCookie.__L4966, 0)))))))) {
            buf.append("\"\"");
        }else
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.security.util.ServerCookie.__L4970, org.broadleafcommerce.common.security.util.ServerCookie.containsCTL(value, perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.security.util.ServerCookie.__L4969, version))))
                throw new java.lang.IllegalArgumentException("Control character in cookie value, consider BASE64 encoding your value");
            else
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.security.util.ServerCookie.__L4971, org.broadleafcommerce.common.security.util.ServerCookie.alreadyQuoted(value))) {
                    buf.append('"');
                    buf.append(org.broadleafcommerce.common.security.util.ServerCookie.escapeDoubleQuotes(value, perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.security.util.ServerCookie.__L4972, 1), perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.security.util.ServerCookie.__L4975, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.security.util.ServerCookie.__L4973, value.length())) - (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.security.util.ServerCookie.__L4974, 1))))));
                    buf.append('"');
                }else
                    if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.security.util.ServerCookie.__L4986, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.security.util.ServerCookie.__L4983, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.security.util.ServerCookie.__L4979, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.security.util.ServerCookie.__L4976, allowVersionSwitch)) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.security.util.ServerCookie.__L4978, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.security.util.ServerCookie.__L4977, org.broadleafcommerce.common.security.util.ServerCookie.STRICT_SERVLET_COMPLIANCE)))))))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.security.util.ServerCookie.__L4982, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.security.util.ServerCookie.__L4980, version)) == (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.security.util.ServerCookie.__L4981, 0)))))))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.security.util.ServerCookie.__L4985, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.security.util.ServerCookie.__L4984, org.broadleafcommerce.common.security.util.ServerCookie.isToken2(value, literals))))))))) {
                        buf.append('"');
                        buf.append(org.broadleafcommerce.common.security.util.ServerCookie.escapeDoubleQuotes(value, perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.security.util.ServerCookie.__L4987, 0), perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.security.util.ServerCookie.__L4988, value.length())));
                        buf.append('"');
                        version = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.security.util.ServerCookie.__L4989, 1);
                    }else
                        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.security.util.ServerCookie.__L4995, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.security.util.ServerCookie.__L4992, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.security.util.ServerCookie.__L4990, version)) == (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.security.util.ServerCookie.__L4991, 0))))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.security.util.ServerCookie.__L4994, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.security.util.ServerCookie.__L4993, org.broadleafcommerce.common.security.util.ServerCookie.isToken(value, literals))))))))) {
                            buf.append('"');
                            buf.append(org.broadleafcommerce.common.security.util.ServerCookie.escapeDoubleQuotes(value, perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.security.util.ServerCookie.__L4996, 0), perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.security.util.ServerCookie.__L4997, value.length())));
                            buf.append('"');
                        }else
                            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.security.util.ServerCookie.__L5003, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.security.util.ServerCookie.__L5000, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.security.util.ServerCookie.__L4998, version)) == (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.security.util.ServerCookie.__L4999, 1))))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.security.util.ServerCookie.__L5002, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.security.util.ServerCookie.__L5001, org.broadleafcommerce.common.security.util.ServerCookie.isToken2(value, literals))))))))) {
                                buf.append('"');
                                buf.append(org.broadleafcommerce.common.security.util.ServerCookie.escapeDoubleQuotes(value, perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.security.util.ServerCookie.__L5004, 0), perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.security.util.ServerCookie.__L5005, value.length())));
                                buf.append('"');
                            }else {
                                buf.append(value);
                            }





        return perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.security.util.ServerCookie.__L5006, version);
    }

    public static boolean containsCTL(java.lang.String value, int version) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.security.util.ServerCookie.__L5007, (value == null)))
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.security.util.ServerCookie.__L5008, false);

        int len = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.security.util.ServerCookie.__L5009, value.length());
        for (int i = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.security.util.ServerCookie.__L5010, 0); perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.security.util.ServerCookie.__L5013, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.security.util.ServerCookie.__L5011, i)) < (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.security.util.ServerCookie.__L5012, len)))); perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.security.util.ServerCookie.__L5014, (i++))) {
            char c = value.charAt(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.security.util.ServerCookie.__L5015, i));
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.security.util.ServerCookie.__L5018, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.security.util.ServerCookie.__L5016, (c < 32))) || (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.security.util.ServerCookie.__L5017, (c >= 127)))))) {
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.security.util.ServerCookie.__L5019, (c == 9)))
                    continue;

                return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.security.util.ServerCookie.__L5020, true);
            }
        }
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.security.util.ServerCookie.__L5021, false);
    }

    public static boolean alreadyQuoted(java.lang.String value) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.security.util.ServerCookie.__L5026, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.security.util.ServerCookie.__L5022, (value == null))) || (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.security.util.ServerCookie.__L5025, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.security.util.ServerCookie.__L5023, value.length())) == (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.security.util.ServerCookie.__L5024, 0))))))))
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.security.util.ServerCookie.__L5027, false);

        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.security.util.ServerCookie.__L5034, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.security.util.ServerCookie.__L5029, ((value.charAt(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.security.util.ServerCookie.__L5028, 0))) == '\"'))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.security.util.ServerCookie.__L5033, ((value.charAt(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.security.util.ServerCookie.__L5032, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.security.util.ServerCookie.__L5030, value.length())) - (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.security.util.ServerCookie.__L5031, 1)))))) == '\"')))));
    }

    private static java.lang.String escapeDoubleQuotes(java.lang.String s, int beginIndex, int endIndex) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.security.util.ServerCookie.__L5044, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.security.util.ServerCookie.__L5039, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.security.util.ServerCookie.__L5035, (s == null))) || (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.security.util.ServerCookie.__L5038, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.security.util.ServerCookie.__L5036, s.length())) == (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.security.util.ServerCookie.__L5037, 0)))))))) || (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.security.util.ServerCookie.__L5043, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.security.util.ServerCookie.__L5040, s.indexOf('"'))) == (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.security.util.ServerCookie.__L5042, (-(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.security.util.ServerCookie.__L5041, 1))))))))))) {
            return s;
        }
        java.lang.StringBuffer b = new java.lang.StringBuffer();
        for (int i = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.security.util.ServerCookie.__L5045, beginIndex); perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.security.util.ServerCookie.__L5048, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.security.util.ServerCookie.__L5046, i)) < (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.security.util.ServerCookie.__L5047, endIndex)))); perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.security.util.ServerCookie.__L5049, (i++))) {
            char c = s.charAt(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.security.util.ServerCookie.__L5050, i));
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.security.util.ServerCookie.__L5051, (c == '\\'))) {
                b.append(c);
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.security.util.ServerCookie.__L5054, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.security.util.ServerCookie.__L5052, (++i))) >= (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.security.util.ServerCookie.__L5053, endIndex)))))
                    throw new java.lang.IllegalArgumentException("Invalid escape character in cookie value.");

                b.append(s.charAt(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.security.util.ServerCookie.__L5055, i)));
            }else
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.security.util.ServerCookie.__L5056, (c == '"')))
                    b.append('\\').append('"');
                else
                    b.append(c);


        }
        return b.toString();
    }

    public static boolean isToken(java.lang.String value) {
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.security.util.ServerCookie.__L5057, org.broadleafcommerce.common.security.util.ServerCookie.isToken(value, null));
    }

    public static boolean isToken(java.lang.String value, java.lang.String literals) {
        java.lang.String tspecials = (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.security.util.ServerCookie.__L5058, (literals == null))) ? org.broadleafcommerce.common.security.util.ServerCookie.tspecials : literals;
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.security.util.ServerCookie.__L5059, (value == null)))
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.security.util.ServerCookie.__L5060, true);

        int len = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.security.util.ServerCookie.__L5061, value.length());
        for (int i = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.security.util.ServerCookie.__L5062, 0); perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.security.util.ServerCookie.__L5065, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.security.util.ServerCookie.__L5063, i)) < (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.security.util.ServerCookie.__L5064, len)))); perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.security.util.ServerCookie.__L5066, (i++))) {
            char c = value.charAt(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.security.util.ServerCookie.__L5067, i));
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.security.util.ServerCookie.__L5071, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.security.util.ServerCookie.__L5068, tspecials.indexOf(c))) != (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.security.util.ServerCookie.__L5070, (-(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.security.util.ServerCookie.__L5069, 1))))))))
                return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.security.util.ServerCookie.__L5072, false);

        }
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.security.util.ServerCookie.__L5073, true);
    }

    public static boolean isToken2(java.lang.String value) {
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.security.util.ServerCookie.__L5074, org.broadleafcommerce.common.security.util.ServerCookie.isToken2(value, null));
    }

    public static boolean isToken2(java.lang.String value, java.lang.String literals) {
        java.lang.String tspecials2 = (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.security.util.ServerCookie.__L5075, (literals == null))) ? org.broadleafcommerce.common.security.util.ServerCookie.tspecials2 : literals;
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.security.util.ServerCookie.__L5076, (value == null)))
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.security.util.ServerCookie.__L5077, true);

        int len = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.security.util.ServerCookie.__L5078, value.length());
        for (int i = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.security.util.ServerCookie.__L5079, 0); perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.security.util.ServerCookie.__L5082, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.security.util.ServerCookie.__L5080, i)) < (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.security.util.ServerCookie.__L5081, len)))); perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.security.util.ServerCookie.__L5083, (i++))) {
            char c = value.charAt(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.security.util.ServerCookie.__L5084, i));
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.security.util.ServerCookie.__L5088, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.security.util.ServerCookie.__L5085, tspecials2.indexOf(c))) != (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.security.util.ServerCookie.__L5087, (-(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.security.util.ServerCookie.__L5086, 1))))))))
                return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.security.util.ServerCookie.__L5089, false);

        }
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.security.util.ServerCookie.__L5090, true);
    }

    public static perturbation.location.PerturbationLocation __L4918;

    public static perturbation.location.PerturbationLocation __L4919;

    public static perturbation.location.PerturbationLocation __L4920;

    public static perturbation.location.PerturbationLocation __L4921;

    public static perturbation.location.PerturbationLocation __L4922;

    public static perturbation.location.PerturbationLocation __L4923;

    public static perturbation.location.PerturbationLocation __L4924;

    public static perturbation.location.PerturbationLocation __L4925;

    public static perturbation.location.PerturbationLocation __L4926;

    public static perturbation.location.PerturbationLocation __L4927;

    public static perturbation.location.PerturbationLocation __L4928;

    public static perturbation.location.PerturbationLocation __L4929;

    public static perturbation.location.PerturbationLocation __L4930;

    public static perturbation.location.PerturbationLocation __L4931;

    public static perturbation.location.PerturbationLocation __L4932;

    public static perturbation.location.PerturbationLocation __L4933;

    public static perturbation.location.PerturbationLocation __L4934;

    public static perturbation.location.PerturbationLocation __L4935;

    public static perturbation.location.PerturbationLocation __L4936;

    public static perturbation.location.PerturbationLocation __L4937;

    public static perturbation.location.PerturbationLocation __L4938;

    public static perturbation.location.PerturbationLocation __L4939;

    public static perturbation.location.PerturbationLocation __L4940;

    public static perturbation.location.PerturbationLocation __L4941;

    public static perturbation.location.PerturbationLocation __L4942;

    public static perturbation.location.PerturbationLocation __L4943;

    public static perturbation.location.PerturbationLocation __L4944;

    public static perturbation.location.PerturbationLocation __L4945;

    public static perturbation.location.PerturbationLocation __L4946;

    public static perturbation.location.PerturbationLocation __L4947;

    public static perturbation.location.PerturbationLocation __L4948;

    public static perturbation.location.PerturbationLocation __L4949;

    public static perturbation.location.PerturbationLocation __L4950;

    public static perturbation.location.PerturbationLocation __L4951;

    public static perturbation.location.PerturbationLocation __L4952;

    public static perturbation.location.PerturbationLocation __L4953;

    public static perturbation.location.PerturbationLocation __L4954;

    public static perturbation.location.PerturbationLocation __L4955;

    public static perturbation.location.PerturbationLocation __L4956;

    public static perturbation.location.PerturbationLocation __L4957;

    public static perturbation.location.PerturbationLocation __L4958;

    public static perturbation.location.PerturbationLocation __L4959;

    public static perturbation.location.PerturbationLocation __L4960;

    public static perturbation.location.PerturbationLocation __L4961;

    public static perturbation.location.PerturbationLocation __L4962;

    public static perturbation.location.PerturbationLocation __L4963;

    public static perturbation.location.PerturbationLocation __L4964;

    public static perturbation.location.PerturbationLocation __L4965;

    public static perturbation.location.PerturbationLocation __L4966;

    public static perturbation.location.PerturbationLocation __L4967;

    public static perturbation.location.PerturbationLocation __L4968;

    public static perturbation.location.PerturbationLocation __L4969;

    public static perturbation.location.PerturbationLocation __L4970;

    public static perturbation.location.PerturbationLocation __L4971;

    public static perturbation.location.PerturbationLocation __L4972;

    public static perturbation.location.PerturbationLocation __L4973;

    public static perturbation.location.PerturbationLocation __L4974;

    public static perturbation.location.PerturbationLocation __L4975;

    public static perturbation.location.PerturbationLocation __L4976;

    public static perturbation.location.PerturbationLocation __L4977;

    public static perturbation.location.PerturbationLocation __L4978;

    public static perturbation.location.PerturbationLocation __L4979;

    public static perturbation.location.PerturbationLocation __L4980;

    public static perturbation.location.PerturbationLocation __L4981;

    public static perturbation.location.PerturbationLocation __L4982;

    public static perturbation.location.PerturbationLocation __L4983;

    public static perturbation.location.PerturbationLocation __L4984;

    public static perturbation.location.PerturbationLocation __L4985;

    public static perturbation.location.PerturbationLocation __L4986;

    public static perturbation.location.PerturbationLocation __L4987;

    public static perturbation.location.PerturbationLocation __L4988;

    public static perturbation.location.PerturbationLocation __L4989;

    public static perturbation.location.PerturbationLocation __L4990;

    public static perturbation.location.PerturbationLocation __L4991;

    public static perturbation.location.PerturbationLocation __L4992;

    public static perturbation.location.PerturbationLocation __L4993;

    public static perturbation.location.PerturbationLocation __L4994;

    public static perturbation.location.PerturbationLocation __L4995;

    public static perturbation.location.PerturbationLocation __L4996;

    public static perturbation.location.PerturbationLocation __L4997;

    public static perturbation.location.PerturbationLocation __L4998;

    public static perturbation.location.PerturbationLocation __L4999;

    public static perturbation.location.PerturbationLocation __L5000;

    public static perturbation.location.PerturbationLocation __L5001;

    public static perturbation.location.PerturbationLocation __L5002;

    public static perturbation.location.PerturbationLocation __L5003;

    public static perturbation.location.PerturbationLocation __L5004;

    public static perturbation.location.PerturbationLocation __L5005;

    public static perturbation.location.PerturbationLocation __L5006;

    public static perturbation.location.PerturbationLocation __L5007;

    public static perturbation.location.PerturbationLocation __L5008;

    public static perturbation.location.PerturbationLocation __L5009;

    public static perturbation.location.PerturbationLocation __L5010;

    public static perturbation.location.PerturbationLocation __L5011;

    public static perturbation.location.PerturbationLocation __L5012;

    public static perturbation.location.PerturbationLocation __L5013;

    public static perturbation.location.PerturbationLocation __L5014;

    public static perturbation.location.PerturbationLocation __L5015;

    public static perturbation.location.PerturbationLocation __L5016;

    public static perturbation.location.PerturbationLocation __L5017;

    public static perturbation.location.PerturbationLocation __L5018;

    public static perturbation.location.PerturbationLocation __L5019;

    public static perturbation.location.PerturbationLocation __L5020;

    public static perturbation.location.PerturbationLocation __L5021;

    public static perturbation.location.PerturbationLocation __L5022;

    public static perturbation.location.PerturbationLocation __L5023;

    public static perturbation.location.PerturbationLocation __L5024;

    public static perturbation.location.PerturbationLocation __L5025;

    public static perturbation.location.PerturbationLocation __L5026;

    public static perturbation.location.PerturbationLocation __L5027;

    public static perturbation.location.PerturbationLocation __L5028;

    public static perturbation.location.PerturbationLocation __L5029;

    public static perturbation.location.PerturbationLocation __L5030;

    public static perturbation.location.PerturbationLocation __L5031;

    public static perturbation.location.PerturbationLocation __L5032;

    public static perturbation.location.PerturbationLocation __L5033;

    public static perturbation.location.PerturbationLocation __L5034;

    public static perturbation.location.PerturbationLocation __L5035;

    public static perturbation.location.PerturbationLocation __L5036;

    public static perturbation.location.PerturbationLocation __L5037;

    public static perturbation.location.PerturbationLocation __L5038;

    public static perturbation.location.PerturbationLocation __L5039;

    public static perturbation.location.PerturbationLocation __L5040;

    public static perturbation.location.PerturbationLocation __L5041;

    public static perturbation.location.PerturbationLocation __L5042;

    public static perturbation.location.PerturbationLocation __L5043;

    public static perturbation.location.PerturbationLocation __L5044;

    public static perturbation.location.PerturbationLocation __L5045;

    public static perturbation.location.PerturbationLocation __L5046;

    public static perturbation.location.PerturbationLocation __L5047;

    public static perturbation.location.PerturbationLocation __L5048;

    public static perturbation.location.PerturbationLocation __L5049;

    public static perturbation.location.PerturbationLocation __L5050;

    public static perturbation.location.PerturbationLocation __L5051;

    public static perturbation.location.PerturbationLocation __L5052;

    public static perturbation.location.PerturbationLocation __L5053;

    public static perturbation.location.PerturbationLocation __L5054;

    public static perturbation.location.PerturbationLocation __L5055;

    public static perturbation.location.PerturbationLocation __L5056;

    public static perturbation.location.PerturbationLocation __L5057;

    public static perturbation.location.PerturbationLocation __L5058;

    public static perturbation.location.PerturbationLocation __L5059;

    public static perturbation.location.PerturbationLocation __L5060;

    public static perturbation.location.PerturbationLocation __L5061;

    public static perturbation.location.PerturbationLocation __L5062;

    public static perturbation.location.PerturbationLocation __L5063;

    public static perturbation.location.PerturbationLocation __L5064;

    public static perturbation.location.PerturbationLocation __L5065;

    public static perturbation.location.PerturbationLocation __L5066;

    public static perturbation.location.PerturbationLocation __L5067;

    public static perturbation.location.PerturbationLocation __L5068;

    public static perturbation.location.PerturbationLocation __L5069;

    public static perturbation.location.PerturbationLocation __L5070;

    public static perturbation.location.PerturbationLocation __L5071;

    public static perturbation.location.PerturbationLocation __L5072;

    public static perturbation.location.PerturbationLocation __L5073;

    public static perturbation.location.PerturbationLocation __L5074;

    public static perturbation.location.PerturbationLocation __L5075;

    public static perturbation.location.PerturbationLocation __L5076;

    public static perturbation.location.PerturbationLocation __L5077;

    public static perturbation.location.PerturbationLocation __L5078;

    public static perturbation.location.PerturbationLocation __L5079;

    public static perturbation.location.PerturbationLocation __L5080;

    public static perturbation.location.PerturbationLocation __L5081;

    public static perturbation.location.PerturbationLocation __L5082;

    public static perturbation.location.PerturbationLocation __L5083;

    public static perturbation.location.PerturbationLocation __L5084;

    public static perturbation.location.PerturbationLocation __L5085;

    public static perturbation.location.PerturbationLocation __L5086;

    public static perturbation.location.PerturbationLocation __L5087;

    public static perturbation.location.PerturbationLocation __L5088;

    public static perturbation.location.PerturbationLocation __L5089;

    public static perturbation.location.PerturbationLocation __L5090;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.security.util.ServerCookie.__L4918 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/util/ServerCookie.java:86)", 4918, "Numerical");
        org.broadleafcommerce.common.security.util.ServerCookie.__L4919 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/util/ServerCookie.java:86)", 4919, "Boolean");
        org.broadleafcommerce.common.security.util.ServerCookie.__L4920 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/util/ServerCookie.java:86)", 4920, "Numerical");
        org.broadleafcommerce.common.security.util.ServerCookie.__L4921 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/util/ServerCookie.java:89)", 4921, "Numerical");
        org.broadleafcommerce.common.security.util.ServerCookie.__L4922 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/util/ServerCookie.java:89)", 4922, "Numerical");
        org.broadleafcommerce.common.security.util.ServerCookie.__L4923 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/util/ServerCookie.java:89)", 4923, "Boolean");
        org.broadleafcommerce.common.security.util.ServerCookie.__L4924 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/util/ServerCookie.java:94)", 4924, "Boolean");
        org.broadleafcommerce.common.security.util.ServerCookie.__L4925 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/util/ServerCookie.java:96)", 4925, "Numerical");
        org.broadleafcommerce.common.security.util.ServerCookie.__L4926 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/util/ServerCookie.java:101)", 4926, "Boolean");
        org.broadleafcommerce.common.security.util.ServerCookie.__L4927 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/util/ServerCookie.java:103)", 4927, "Numerical");
        org.broadleafcommerce.common.security.util.ServerCookie.__L4928 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/util/ServerCookie.java:108)", 4928, "Numerical");
        org.broadleafcommerce.common.security.util.ServerCookie.__L4929 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/util/ServerCookie.java:108)", 4929, "Numerical");
        org.broadleafcommerce.common.security.util.ServerCookie.__L4930 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/util/ServerCookie.java:108)", 4930, "Boolean");
        org.broadleafcommerce.common.security.util.ServerCookie.__L4931 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/util/ServerCookie.java:109)", 4931, "Numerical");
        org.broadleafcommerce.common.security.util.ServerCookie.__L4932 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/util/ServerCookie.java:109)", 4932, "Numerical");
        org.broadleafcommerce.common.security.util.ServerCookie.__L4933 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/util/ServerCookie.java:109)", 4933, "Boolean");
        org.broadleafcommerce.common.security.util.ServerCookie.__L4934 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/util/ServerCookie.java:111)", 4934, "Numerical");
        org.broadleafcommerce.common.security.util.ServerCookie.__L4935 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/util/ServerCookie.java:115)", 4935, "Numerical");
        org.broadleafcommerce.common.security.util.ServerCookie.__L4936 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/util/ServerCookie.java:115)", 4936, "Numerical");
        org.broadleafcommerce.common.security.util.ServerCookie.__L4937 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/util/ServerCookie.java:115)", 4937, "Boolean");
        org.broadleafcommerce.common.security.util.ServerCookie.__L4938 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/util/ServerCookie.java:115)", 4938, "Boolean");
        org.broadleafcommerce.common.security.util.ServerCookie.__L4939 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/util/ServerCookie.java:115)", 4939, "Boolean");
        org.broadleafcommerce.common.security.util.ServerCookie.__L4940 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/util/ServerCookie.java:119)", 4940, "Numerical");
        org.broadleafcommerce.common.security.util.ServerCookie.__L4941 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/util/ServerCookie.java:119)", 4941, "Numerical");
        org.broadleafcommerce.common.security.util.ServerCookie.__L4942 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/util/ServerCookie.java:119)", 4942, "Boolean");
        org.broadleafcommerce.common.security.util.ServerCookie.__L4943 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/util/ServerCookie.java:123)", 4943, "Numerical");
        org.broadleafcommerce.common.security.util.ServerCookie.__L4944 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/util/ServerCookie.java:124)", 4944, "Numerical");
        org.broadleafcommerce.common.security.util.ServerCookie.__L4945 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/util/ServerCookie.java:124)", 4945, "Numerical");
        org.broadleafcommerce.common.security.util.ServerCookie.__L4946 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/util/ServerCookie.java:124)", 4946, "Numerical");
        org.broadleafcommerce.common.security.util.ServerCookie.__L4947 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/util/ServerCookie.java:123)", 4947, "Numerical");
        org.broadleafcommerce.common.security.util.ServerCookie.__L4948 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/util/ServerCookie.java:125)", 4948, "Numerical");
        org.broadleafcommerce.common.security.util.ServerCookie.__L4949 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/util/ServerCookie.java:130)", 4949, "Boolean");
        org.broadleafcommerce.common.security.util.ServerCookie.__L4950 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/util/ServerCookie.java:132)", 4950, "Numerical");
        org.broadleafcommerce.common.security.util.ServerCookie.__L4951 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/util/ServerCookie.java:132)", 4951, "Numerical");
        org.broadleafcommerce.common.security.util.ServerCookie.__L4952 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/util/ServerCookie.java:132)", 4952, "Boolean");
        org.broadleafcommerce.common.security.util.ServerCookie.__L4953 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/util/ServerCookie.java:133)", 4953, "Numerical");
        org.broadleafcommerce.common.security.util.ServerCookie.__L4954 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/util/ServerCookie.java:135)", 4954, "Numerical");
        org.broadleafcommerce.common.security.util.ServerCookie.__L4955 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/util/ServerCookie.java:135)", 4955, "Boolean");
        org.broadleafcommerce.common.security.util.ServerCookie.__L4956 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/util/ServerCookie.java:140)", 4956, "Boolean");
        org.broadleafcommerce.common.security.util.ServerCookie.__L4957 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/util/ServerCookie.java:145)", 4957, "Boolean");
        org.broadleafcommerce.common.security.util.ServerCookie.__L4958 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/util/ServerCookie.java:152)", 4958, "Numerical");
        org.broadleafcommerce.common.security.util.ServerCookie.__L4959 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/util/ServerCookie.java:152)", 4959, "Boolean");
        org.broadleafcommerce.common.security.util.ServerCookie.__L4960 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/util/ServerCookie.java:152)", 4960, "Numerical");
        org.broadleafcommerce.common.security.util.ServerCookie.__L4961 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/util/ServerCookie.java:156)", 4961, "Numerical");
        org.broadleafcommerce.common.security.util.ServerCookie.__L4962 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/util/ServerCookie.java:156)", 4962, "Boolean");
        org.broadleafcommerce.common.security.util.ServerCookie.__L4963 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/util/ServerCookie.java:156)", 4963, "Numerical");
        org.broadleafcommerce.common.security.util.ServerCookie.__L4964 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/util/ServerCookie.java:160)", 4964, "Boolean");
        org.broadleafcommerce.common.security.util.ServerCookie.__L4965 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/util/ServerCookie.java:160)", 4965, "Numerical");
        org.broadleafcommerce.common.security.util.ServerCookie.__L4966 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/util/ServerCookie.java:160)", 4966, "Numerical");
        org.broadleafcommerce.common.security.util.ServerCookie.__L4967 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/util/ServerCookie.java:160)", 4967, "Boolean");
        org.broadleafcommerce.common.security.util.ServerCookie.__L4968 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/util/ServerCookie.java:160)", 4968, "Boolean");
        org.broadleafcommerce.common.security.util.ServerCookie.__L4969 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/util/ServerCookie.java:162)", 4969, "Numerical");
        org.broadleafcommerce.common.security.util.ServerCookie.__L4970 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/util/ServerCookie.java:162)", 4970, "Boolean");
        org.broadleafcommerce.common.security.util.ServerCookie.__L4971 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/util/ServerCookie.java:164)", 4971, "Boolean");
        org.broadleafcommerce.common.security.util.ServerCookie.__L4972 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/util/ServerCookie.java:166)", 4972, "Numerical");
        org.broadleafcommerce.common.security.util.ServerCookie.__L4973 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/util/ServerCookie.java:166)", 4973, "Numerical");
        org.broadleafcommerce.common.security.util.ServerCookie.__L4974 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/util/ServerCookie.java:166)", 4974, "Numerical");
        org.broadleafcommerce.common.security.util.ServerCookie.__L4975 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/util/ServerCookie.java:166)", 4975, "Numerical");
        org.broadleafcommerce.common.security.util.ServerCookie.__L4976 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/util/ServerCookie.java:168)", 4976, "Boolean");
        org.broadleafcommerce.common.security.util.ServerCookie.__L4977 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/util/ServerCookie.java:168)", 4977, "Boolean");
        org.broadleafcommerce.common.security.util.ServerCookie.__L4978 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/util/ServerCookie.java:168)", 4978, "Boolean");
        org.broadleafcommerce.common.security.util.ServerCookie.__L4979 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/util/ServerCookie.java:168)", 4979, "Boolean");
        org.broadleafcommerce.common.security.util.ServerCookie.__L4980 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/util/ServerCookie.java:168)", 4980, "Numerical");
        org.broadleafcommerce.common.security.util.ServerCookie.__L4981 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/util/ServerCookie.java:168)", 4981, "Numerical");
        org.broadleafcommerce.common.security.util.ServerCookie.__L4982 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/util/ServerCookie.java:168)", 4982, "Boolean");
        org.broadleafcommerce.common.security.util.ServerCookie.__L4983 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/util/ServerCookie.java:168)", 4983, "Boolean");
        org.broadleafcommerce.common.security.util.ServerCookie.__L4984 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/util/ServerCookie.java:168)", 4984, "Boolean");
        org.broadleafcommerce.common.security.util.ServerCookie.__L4985 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/util/ServerCookie.java:168)", 4985, "Boolean");
        org.broadleafcommerce.common.security.util.ServerCookie.__L4986 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/util/ServerCookie.java:168)", 4986, "Boolean");
        org.broadleafcommerce.common.security.util.ServerCookie.__L4987 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/util/ServerCookie.java:170)", 4987, "Numerical");
        org.broadleafcommerce.common.security.util.ServerCookie.__L4988 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/util/ServerCookie.java:170)", 4988, "Numerical");
        org.broadleafcommerce.common.security.util.ServerCookie.__L4989 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/util/ServerCookie.java:172)", 4989, "Numerical");
        org.broadleafcommerce.common.security.util.ServerCookie.__L4990 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/util/ServerCookie.java:173)", 4990, "Numerical");
        org.broadleafcommerce.common.security.util.ServerCookie.__L4991 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/util/ServerCookie.java:173)", 4991, "Numerical");
        org.broadleafcommerce.common.security.util.ServerCookie.__L4992 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/util/ServerCookie.java:173)", 4992, "Boolean");
        org.broadleafcommerce.common.security.util.ServerCookie.__L4993 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/util/ServerCookie.java:173)", 4993, "Boolean");
        org.broadleafcommerce.common.security.util.ServerCookie.__L4994 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/util/ServerCookie.java:173)", 4994, "Boolean");
        org.broadleafcommerce.common.security.util.ServerCookie.__L4995 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/util/ServerCookie.java:173)", 4995, "Boolean");
        org.broadleafcommerce.common.security.util.ServerCookie.__L4996 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/util/ServerCookie.java:175)", 4996, "Numerical");
        org.broadleafcommerce.common.security.util.ServerCookie.__L4997 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/util/ServerCookie.java:175)", 4997, "Numerical");
        org.broadleafcommerce.common.security.util.ServerCookie.__L4998 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/util/ServerCookie.java:177)", 4998, "Numerical");
        org.broadleafcommerce.common.security.util.ServerCookie.__L4999 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/util/ServerCookie.java:177)", 4999, "Numerical");
        org.broadleafcommerce.common.security.util.ServerCookie.__L5000 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/util/ServerCookie.java:177)", 5000, "Boolean");
        org.broadleafcommerce.common.security.util.ServerCookie.__L5001 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/util/ServerCookie.java:177)", 5001, "Boolean");
        org.broadleafcommerce.common.security.util.ServerCookie.__L5002 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/util/ServerCookie.java:177)", 5002, "Boolean");
        org.broadleafcommerce.common.security.util.ServerCookie.__L5003 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/util/ServerCookie.java:177)", 5003, "Boolean");
        org.broadleafcommerce.common.security.util.ServerCookie.__L5004 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/util/ServerCookie.java:179)", 5004, "Numerical");
        org.broadleafcommerce.common.security.util.ServerCookie.__L5005 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/util/ServerCookie.java:179)", 5005, "Numerical");
        org.broadleafcommerce.common.security.util.ServerCookie.__L5006 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/util/ServerCookie.java:184)", 5006, "Numerical");
        org.broadleafcommerce.common.security.util.ServerCookie.__L5007 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/util/ServerCookie.java:188)", 5007, "Boolean");
        org.broadleafcommerce.common.security.util.ServerCookie.__L5008 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/util/ServerCookie.java:188)", 5008, "Boolean");
        org.broadleafcommerce.common.security.util.ServerCookie.__L5009 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/util/ServerCookie.java:189)", 5009, "Numerical");
        org.broadleafcommerce.common.security.util.ServerCookie.__L5010 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/util/ServerCookie.java:190)", 5010, "Numerical");
        org.broadleafcommerce.common.security.util.ServerCookie.__L5011 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/util/ServerCookie.java:190)", 5011, "Numerical");
        org.broadleafcommerce.common.security.util.ServerCookie.__L5012 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/util/ServerCookie.java:190)", 5012, "Numerical");
        org.broadleafcommerce.common.security.util.ServerCookie.__L5013 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/util/ServerCookie.java:190)", 5013, "Boolean");
        org.broadleafcommerce.common.security.util.ServerCookie.__L5014 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/util/ServerCookie.java:190)", 5014, "Numerical");
        org.broadleafcommerce.common.security.util.ServerCookie.__L5015 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/util/ServerCookie.java:191)", 5015, "Numerical");
        org.broadleafcommerce.common.security.util.ServerCookie.__L5016 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/util/ServerCookie.java:192)", 5016, "Boolean");
        org.broadleafcommerce.common.security.util.ServerCookie.__L5017 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/util/ServerCookie.java:192)", 5017, "Boolean");
        org.broadleafcommerce.common.security.util.ServerCookie.__L5018 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/util/ServerCookie.java:192)", 5018, "Boolean");
        org.broadleafcommerce.common.security.util.ServerCookie.__L5019 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/util/ServerCookie.java:193)", 5019, "Boolean");
        org.broadleafcommerce.common.security.util.ServerCookie.__L5020 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/util/ServerCookie.java:195)", 5020, "Boolean");
        org.broadleafcommerce.common.security.util.ServerCookie.__L5021 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/util/ServerCookie.java:198)", 5021, "Boolean");
        org.broadleafcommerce.common.security.util.ServerCookie.__L5022 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/util/ServerCookie.java:202)", 5022, "Boolean");
        org.broadleafcommerce.common.security.util.ServerCookie.__L5023 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/util/ServerCookie.java:202)", 5023, "Numerical");
        org.broadleafcommerce.common.security.util.ServerCookie.__L5024 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/util/ServerCookie.java:202)", 5024, "Numerical");
        org.broadleafcommerce.common.security.util.ServerCookie.__L5025 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/util/ServerCookie.java:202)", 5025, "Boolean");
        org.broadleafcommerce.common.security.util.ServerCookie.__L5026 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/util/ServerCookie.java:202)", 5026, "Boolean");
        org.broadleafcommerce.common.security.util.ServerCookie.__L5027 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/util/ServerCookie.java:202)", 5027, "Boolean");
        org.broadleafcommerce.common.security.util.ServerCookie.__L5028 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/util/ServerCookie.java:203)", 5028, "Numerical");
        org.broadleafcommerce.common.security.util.ServerCookie.__L5029 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/util/ServerCookie.java:203)", 5029, "Boolean");
        org.broadleafcommerce.common.security.util.ServerCookie.__L5030 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/util/ServerCookie.java:203)", 5030, "Numerical");
        org.broadleafcommerce.common.security.util.ServerCookie.__L5031 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/util/ServerCookie.java:203)", 5031, "Numerical");
        org.broadleafcommerce.common.security.util.ServerCookie.__L5032 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/util/ServerCookie.java:203)", 5032, "Numerical");
        org.broadleafcommerce.common.security.util.ServerCookie.__L5033 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/util/ServerCookie.java:203)", 5033, "Boolean");
        org.broadleafcommerce.common.security.util.ServerCookie.__L5034 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/util/ServerCookie.java:203)", 5034, "Boolean");
        org.broadleafcommerce.common.security.util.ServerCookie.__L5035 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/util/ServerCookie.java:216)", 5035, "Boolean");
        org.broadleafcommerce.common.security.util.ServerCookie.__L5036 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/util/ServerCookie.java:216)", 5036, "Numerical");
        org.broadleafcommerce.common.security.util.ServerCookie.__L5037 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/util/ServerCookie.java:216)", 5037, "Numerical");
        org.broadleafcommerce.common.security.util.ServerCookie.__L5038 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/util/ServerCookie.java:216)", 5038, "Boolean");
        org.broadleafcommerce.common.security.util.ServerCookie.__L5039 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/util/ServerCookie.java:216)", 5039, "Boolean");
        org.broadleafcommerce.common.security.util.ServerCookie.__L5040 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/util/ServerCookie.java:216)", 5040, "Numerical");
        org.broadleafcommerce.common.security.util.ServerCookie.__L5041 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/util/ServerCookie.java:216)", 5041, "Numerical");
        org.broadleafcommerce.common.security.util.ServerCookie.__L5042 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/util/ServerCookie.java:216)", 5042, "Numerical");
        org.broadleafcommerce.common.security.util.ServerCookie.__L5043 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/util/ServerCookie.java:216)", 5043, "Boolean");
        org.broadleafcommerce.common.security.util.ServerCookie.__L5044 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/util/ServerCookie.java:216)", 5044, "Boolean");
        org.broadleafcommerce.common.security.util.ServerCookie.__L5045 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/util/ServerCookie.java:221)", 5045, "Numerical");
        org.broadleafcommerce.common.security.util.ServerCookie.__L5046 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/util/ServerCookie.java:221)", 5046, "Numerical");
        org.broadleafcommerce.common.security.util.ServerCookie.__L5047 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/util/ServerCookie.java:221)", 5047, "Numerical");
        org.broadleafcommerce.common.security.util.ServerCookie.__L5048 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/util/ServerCookie.java:221)", 5048, "Boolean");
        org.broadleafcommerce.common.security.util.ServerCookie.__L5049 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/util/ServerCookie.java:221)", 5049, "Numerical");
        org.broadleafcommerce.common.security.util.ServerCookie.__L5050 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/util/ServerCookie.java:222)", 5050, "Numerical");
        org.broadleafcommerce.common.security.util.ServerCookie.__L5051 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/util/ServerCookie.java:223)", 5051, "Boolean");
        org.broadleafcommerce.common.security.util.ServerCookie.__L5052 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/util/ServerCookie.java:226)", 5052, "Numerical");
        org.broadleafcommerce.common.security.util.ServerCookie.__L5053 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/util/ServerCookie.java:226)", 5053, "Numerical");
        org.broadleafcommerce.common.security.util.ServerCookie.__L5054 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/util/ServerCookie.java:226)", 5054, "Boolean");
        org.broadleafcommerce.common.security.util.ServerCookie.__L5055 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/util/ServerCookie.java:227)", 5055, "Numerical");
        org.broadleafcommerce.common.security.util.ServerCookie.__L5056 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/util/ServerCookie.java:228)", 5056, "Boolean");
        org.broadleafcommerce.common.security.util.ServerCookie.__L5057 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/util/ServerCookie.java:247)", 5057, "Boolean");
        org.broadleafcommerce.common.security.util.ServerCookie.__L5058 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/util/ServerCookie.java:251)", 5058, "Boolean");
        org.broadleafcommerce.common.security.util.ServerCookie.__L5059 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/util/ServerCookie.java:252)", 5059, "Boolean");
        org.broadleafcommerce.common.security.util.ServerCookie.__L5060 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/util/ServerCookie.java:252)", 5060, "Boolean");
        org.broadleafcommerce.common.security.util.ServerCookie.__L5061 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/util/ServerCookie.java:253)", 5061, "Numerical");
        org.broadleafcommerce.common.security.util.ServerCookie.__L5062 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/util/ServerCookie.java:255)", 5062, "Numerical");
        org.broadleafcommerce.common.security.util.ServerCookie.__L5063 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/util/ServerCookie.java:255)", 5063, "Numerical");
        org.broadleafcommerce.common.security.util.ServerCookie.__L5064 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/util/ServerCookie.java:255)", 5064, "Numerical");
        org.broadleafcommerce.common.security.util.ServerCookie.__L5065 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/util/ServerCookie.java:255)", 5065, "Boolean");
        org.broadleafcommerce.common.security.util.ServerCookie.__L5066 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/util/ServerCookie.java:255)", 5066, "Numerical");
        org.broadleafcommerce.common.security.util.ServerCookie.__L5067 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/util/ServerCookie.java:256)", 5067, "Numerical");
        org.broadleafcommerce.common.security.util.ServerCookie.__L5068 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/util/ServerCookie.java:258)", 5068, "Numerical");
        org.broadleafcommerce.common.security.util.ServerCookie.__L5069 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/util/ServerCookie.java:258)", 5069, "Numerical");
        org.broadleafcommerce.common.security.util.ServerCookie.__L5070 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/util/ServerCookie.java:258)", 5070, "Numerical");
        org.broadleafcommerce.common.security.util.ServerCookie.__L5071 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/util/ServerCookie.java:258)", 5071, "Boolean");
        org.broadleafcommerce.common.security.util.ServerCookie.__L5072 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/util/ServerCookie.java:259)", 5072, "Boolean");
        org.broadleafcommerce.common.security.util.ServerCookie.__L5073 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/util/ServerCookie.java:261)", 5073, "Boolean");
        org.broadleafcommerce.common.security.util.ServerCookie.__L5074 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/util/ServerCookie.java:265)", 5074, "Boolean");
        org.broadleafcommerce.common.security.util.ServerCookie.__L5075 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/util/ServerCookie.java:269)", 5075, "Boolean");
        org.broadleafcommerce.common.security.util.ServerCookie.__L5076 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/util/ServerCookie.java:270)", 5076, "Boolean");
        org.broadleafcommerce.common.security.util.ServerCookie.__L5077 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/util/ServerCookie.java:270)", 5077, "Boolean");
        org.broadleafcommerce.common.security.util.ServerCookie.__L5078 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/util/ServerCookie.java:271)", 5078, "Numerical");
        org.broadleafcommerce.common.security.util.ServerCookie.__L5079 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/util/ServerCookie.java:273)", 5079, "Numerical");
        org.broadleafcommerce.common.security.util.ServerCookie.__L5080 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/util/ServerCookie.java:273)", 5080, "Numerical");
        org.broadleafcommerce.common.security.util.ServerCookie.__L5081 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/util/ServerCookie.java:273)", 5081, "Numerical");
        org.broadleafcommerce.common.security.util.ServerCookie.__L5082 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/util/ServerCookie.java:273)", 5082, "Boolean");
        org.broadleafcommerce.common.security.util.ServerCookie.__L5083 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/util/ServerCookie.java:273)", 5083, "Numerical");
        org.broadleafcommerce.common.security.util.ServerCookie.__L5084 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/util/ServerCookie.java:274)", 5084, "Numerical");
        org.broadleafcommerce.common.security.util.ServerCookie.__L5085 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/util/ServerCookie.java:275)", 5085, "Numerical");
        org.broadleafcommerce.common.security.util.ServerCookie.__L5086 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/util/ServerCookie.java:275)", 5086, "Numerical");
        org.broadleafcommerce.common.security.util.ServerCookie.__L5087 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/util/ServerCookie.java:275)", 5087, "Numerical");
        org.broadleafcommerce.common.security.util.ServerCookie.__L5088 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/util/ServerCookie.java:275)", 5088, "Boolean");
        org.broadleafcommerce.common.security.util.ServerCookie.__L5089 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/util/ServerCookie.java:276)", 5089, "Boolean");
        org.broadleafcommerce.common.security.util.ServerCookie.__L5090 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/security/util/ServerCookie.java:278)", 5090, "Boolean");
    }

    static {
        ancientDate = org.broadleafcommerce.common.security.util.ServerCookie.OLD_COOKIE_FORMAT.get().format(new java.util.Date(10000));
    }

    static {
        org.broadleafcommerce.common.security.util.ServerCookie.initPerturbationLocation0();
    }
}

