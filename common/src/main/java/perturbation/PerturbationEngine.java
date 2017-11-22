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
package perturbation;


public class PerturbationEngine {
    public static java.util.Map<java.lang.String, perturbation.log.Logger> loggers = new java.util.HashMap<java.lang.String, perturbation.log.Logger>();

    public static boolean pboolean(perturbation.location.PerturbationLocation perturbationLocation, boolean value) {
        try {
            if (perturbationLocation.getEnactor().shouldBeActivated()) {
                perturbation.PerturbationEngine.notifyEnactionOn(perturbationLocation);
                boolean perturbation = perturbationLocation.getPerturbator().pboolean(value);
                return perturbation;
            } else {
                perturbation.PerturbationEngine.notifyCallOn(perturbationLocation);
                return value;
            }
        } catch (Exception e) {
            return value;
        }
    }

    public static byte pbyte(perturbation.location.PerturbationLocation perturbationLocation, byte value) {
        try {
            if (perturbationLocation.getEnactor().shouldBeActivated()) {
                perturbation.PerturbationEngine.notifyEnactionOn(perturbationLocation);
                byte perturbation = perturbationLocation.getPerturbator().pbyte(value);
                return perturbation;
            } else {
                perturbation.PerturbationEngine.notifyCallOn(perturbationLocation);
                return value;
            }
        } catch (Exception e) {
            return value;
        }
    }

    public static short pshort(perturbation.location.PerturbationLocation perturbationLocation, short value) {
        try {
            if (perturbationLocation.getEnactor().shouldBeActivated()) {
                perturbation.PerturbationEngine.notifyEnactionOn(perturbationLocation);
                short perturbation = perturbationLocation.getPerturbator().pshort(value);
                return perturbation;
            } else {
                perturbation.PerturbationEngine.notifyCallOn(perturbationLocation);
                return value;
            }
        } catch (Exception e) {
            return value;
        }
    }

    public static int pint(perturbation.location.PerturbationLocation perturbationLocation, int value) {
        try {
            if (perturbationLocation.getEnactor().shouldBeActivated()) {
                perturbation.PerturbationEngine.notifyEnactionOn(perturbationLocation);
                int perturbation = perturbationLocation.getPerturbator().pint(value);
                return perturbation;
            } else {
                perturbation.PerturbationEngine.notifyCallOn(perturbationLocation);
                return value;
            }
        } catch (Exception e) {
            return value;
        }
    }

    public static long plong(perturbation.location.PerturbationLocation perturbationLocation, long value) {
        try {
            if (perturbationLocation.getEnactor().shouldBeActivated()) {
                perturbation.PerturbationEngine.notifyEnactionOn(perturbationLocation);
                long perturbation = perturbationLocation.getPerturbator().plong(value);
                return perturbation;
            } else {
                perturbation.PerturbationEngine.notifyCallOn(perturbationLocation);
                return value;
            }
        } catch (Exception e) {
            return value;
        }
    }

    public static char pchar(perturbation.location.PerturbationLocation perturbationLocation, char value) {
        try {
            if (perturbationLocation.getEnactor().shouldBeActivated()) {
                perturbation.PerturbationEngine.notifyEnactionOn(perturbationLocation);
                char perturbation = perturbationLocation.getPerturbator().pchar(value);
                return perturbation;
            } else {
                perturbation.PerturbationEngine.notifyCallOn(perturbationLocation);
                return value;
            }
        } catch (Exception e) {
            return value;
        }
    }

    public static float pfloat(perturbation.location.PerturbationLocation perturbationLocation, float value) {
        try {
            if (perturbationLocation.getEnactor().shouldBeActivated()) {
                perturbation.PerturbationEngine.notifyEnactionOn(perturbationLocation);
                float perturbation = perturbationLocation.getPerturbator().pfloat(value);
                return perturbation;
            } else {
                perturbation.PerturbationEngine.notifyCallOn(perturbationLocation);
                return value;
            }
        } catch (Exception e) {
            return value;
        }
    }

    public static double pdouble(perturbation.location.PerturbationLocation perturbationLocation, double value) {
        try {
            if (perturbationLocation.getEnactor().shouldBeActivated()) {
                perturbation.PerturbationEngine.notifyEnactionOn(perturbationLocation);
                double perturbation = perturbationLocation.getPerturbator().pdouble(value);
                return perturbation;
            } else {
                perturbation.PerturbationEngine.notifyCallOn(perturbationLocation);
                return value;
            }
        } catch (Exception e) {
            return value;
        }
    }

    public static java.math.BigInteger pBigInteger(perturbation.location.PerturbationLocation perturbationLocation, java.math.BigInteger value) {
        try {
            if (perturbationLocation.getEnactor().shouldBeActivated()) {
                perturbation.PerturbationEngine.notifyEnactionOn(perturbationLocation);
                java.math.BigInteger perturbation = perturbationLocation.getPerturbator().pBigInteger(value);
                return perturbation;
            } else {
                perturbation.PerturbationEngine.notifyCallOn(perturbationLocation);
                return value;
            }
        } catch (Exception e) {
            return value;
        }
    }

    private static void notifyCallOn(perturbation.location.PerturbationLocation location) {
        for (perturbation.log.Logger logger : perturbation.PerturbationEngine.loggers.values()) {
            logger.logCall(location);
        }
    }

    private static void notifyEnactionOn(perturbation.location.PerturbationLocation location) {
        for (perturbation.log.Logger logger : perturbation.PerturbationEngine.loggers.values()) {
            logger.logCall(location);
            logger.logEnaction(location);
        }
    }
}

