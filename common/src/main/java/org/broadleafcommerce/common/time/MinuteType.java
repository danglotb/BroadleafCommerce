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
package org.broadleafcommerce.common.time;


public class MinuteType implements java.io.Serializable , org.broadleafcommerce.common.BroadleafEnumerationType {
    private static final long serialVersionUID = 1L;

    private static final java.util.Map<java.lang.String, org.broadleafcommerce.common.time.MinuteType> TYPES = new java.util.LinkedHashMap<java.lang.String, org.broadleafcommerce.common.time.MinuteType>();

    public static final org.broadleafcommerce.common.time.MinuteType ZERO = new org.broadleafcommerce.common.time.MinuteType("0", "00");

    public static final org.broadleafcommerce.common.time.MinuteType ONE = new org.broadleafcommerce.common.time.MinuteType("1", "01");

    public static final org.broadleafcommerce.common.time.MinuteType TWO = new org.broadleafcommerce.common.time.MinuteType("2", "02");

    public static final org.broadleafcommerce.common.time.MinuteType THREE = new org.broadleafcommerce.common.time.MinuteType("3", "03");

    public static final org.broadleafcommerce.common.time.MinuteType FOUR = new org.broadleafcommerce.common.time.MinuteType("4", "04");

    public static final org.broadleafcommerce.common.time.MinuteType FIVE = new org.broadleafcommerce.common.time.MinuteType("5", "05");

    public static final org.broadleafcommerce.common.time.MinuteType SIX = new org.broadleafcommerce.common.time.MinuteType("6", "06");

    public static final org.broadleafcommerce.common.time.MinuteType SEVEN = new org.broadleafcommerce.common.time.MinuteType("7", "07");

    public static final org.broadleafcommerce.common.time.MinuteType EIGHT = new org.broadleafcommerce.common.time.MinuteType("8", "08");

    public static final org.broadleafcommerce.common.time.MinuteType NINE = new org.broadleafcommerce.common.time.MinuteType("9", "09");

    public static final org.broadleafcommerce.common.time.MinuteType TEN = new org.broadleafcommerce.common.time.MinuteType("10", "10");

    public static final org.broadleafcommerce.common.time.MinuteType ELEVEN = new org.broadleafcommerce.common.time.MinuteType("11", "11");

    public static final org.broadleafcommerce.common.time.MinuteType TWELVE = new org.broadleafcommerce.common.time.MinuteType("12", "12");

    public static final org.broadleafcommerce.common.time.MinuteType THIRTEEN = new org.broadleafcommerce.common.time.MinuteType("13", "13");

    public static final org.broadleafcommerce.common.time.MinuteType FOURTEEN = new org.broadleafcommerce.common.time.MinuteType("14", "14");

    public static final org.broadleafcommerce.common.time.MinuteType FIFTEEN = new org.broadleafcommerce.common.time.MinuteType("15", "15");

    public static final org.broadleafcommerce.common.time.MinuteType SIXTEEN = new org.broadleafcommerce.common.time.MinuteType("16", "16");

    public static final org.broadleafcommerce.common.time.MinuteType SEVENTEEN = new org.broadleafcommerce.common.time.MinuteType("17", "17");

    public static final org.broadleafcommerce.common.time.MinuteType EIGHTEEN = new org.broadleafcommerce.common.time.MinuteType("18", "18");

    public static final org.broadleafcommerce.common.time.MinuteType NINETEEN = new org.broadleafcommerce.common.time.MinuteType("19", "19");

    public static final org.broadleafcommerce.common.time.MinuteType TWENTY = new org.broadleafcommerce.common.time.MinuteType("20", "20");

    public static final org.broadleafcommerce.common.time.MinuteType TWENTYONE = new org.broadleafcommerce.common.time.MinuteType("21", "21");

    public static final org.broadleafcommerce.common.time.MinuteType TWNETYTWO = new org.broadleafcommerce.common.time.MinuteType("22", "22");

    public static final org.broadleafcommerce.common.time.MinuteType TWENTYTHREE = new org.broadleafcommerce.common.time.MinuteType("23", "23");

    public static final org.broadleafcommerce.common.time.MinuteType TWENTYFOUR = new org.broadleafcommerce.common.time.MinuteType("24", "24");

    public static final org.broadleafcommerce.common.time.MinuteType TWENTYFIVE = new org.broadleafcommerce.common.time.MinuteType("25", "25");

    public static final org.broadleafcommerce.common.time.MinuteType TWENTYSIX = new org.broadleafcommerce.common.time.MinuteType("26", "26");

    public static final org.broadleafcommerce.common.time.MinuteType TWENTYSEVEN = new org.broadleafcommerce.common.time.MinuteType("27", "27");

    public static final org.broadleafcommerce.common.time.MinuteType TWENTYEIGHT = new org.broadleafcommerce.common.time.MinuteType("28", "28");

    public static final org.broadleafcommerce.common.time.MinuteType TWENTYNINE = new org.broadleafcommerce.common.time.MinuteType("29", "29");

    public static final org.broadleafcommerce.common.time.MinuteType THIRTY = new org.broadleafcommerce.common.time.MinuteType("30", "30");

    public static final org.broadleafcommerce.common.time.MinuteType THIRTYONE = new org.broadleafcommerce.common.time.MinuteType("31", "31");

    public static final org.broadleafcommerce.common.time.MinuteType THIRTYTWO = new org.broadleafcommerce.common.time.MinuteType("32", "32");

    public static final org.broadleafcommerce.common.time.MinuteType THIRTYTHREE = new org.broadleafcommerce.common.time.MinuteType("33", "33");

    public static final org.broadleafcommerce.common.time.MinuteType THIRTYFOUR = new org.broadleafcommerce.common.time.MinuteType("34", "34");

    public static final org.broadleafcommerce.common.time.MinuteType THIRTYFIVE = new org.broadleafcommerce.common.time.MinuteType("35", "35");

    public static final org.broadleafcommerce.common.time.MinuteType THIRTYSIX = new org.broadleafcommerce.common.time.MinuteType("36", "36");

    public static final org.broadleafcommerce.common.time.MinuteType THIRTYSEVEN = new org.broadleafcommerce.common.time.MinuteType("37", "37");

    public static final org.broadleafcommerce.common.time.MinuteType THIRTYEIGHT = new org.broadleafcommerce.common.time.MinuteType("38", "38");

    public static final org.broadleafcommerce.common.time.MinuteType THIRTYNINE = new org.broadleafcommerce.common.time.MinuteType("39", "39");

    public static final org.broadleafcommerce.common.time.MinuteType FOURTY = new org.broadleafcommerce.common.time.MinuteType("40", "40");

    public static final org.broadleafcommerce.common.time.MinuteType FOURTYONE = new org.broadleafcommerce.common.time.MinuteType("41", "41");

    public static final org.broadleafcommerce.common.time.MinuteType FOURTYTWO = new org.broadleafcommerce.common.time.MinuteType("42", "42");

    public static final org.broadleafcommerce.common.time.MinuteType FOURTYTHREE = new org.broadleafcommerce.common.time.MinuteType("43", "43");

    public static final org.broadleafcommerce.common.time.MinuteType FOURTYFOUR = new org.broadleafcommerce.common.time.MinuteType("44", "44");

    public static final org.broadleafcommerce.common.time.MinuteType FOURTYFIVE = new org.broadleafcommerce.common.time.MinuteType("45", "45");

    public static final org.broadleafcommerce.common.time.MinuteType FOURTYSIX = new org.broadleafcommerce.common.time.MinuteType("46", "46");

    public static final org.broadleafcommerce.common.time.MinuteType FOURTYSEVEN = new org.broadleafcommerce.common.time.MinuteType("47", "47");

    public static final org.broadleafcommerce.common.time.MinuteType FOURTYEIGHT = new org.broadleafcommerce.common.time.MinuteType("48", "48");

    public static final org.broadleafcommerce.common.time.MinuteType FOURTYNINE = new org.broadleafcommerce.common.time.MinuteType("49", "49");

    public static final org.broadleafcommerce.common.time.MinuteType FIFTY = new org.broadleafcommerce.common.time.MinuteType("50", "50");

    public static final org.broadleafcommerce.common.time.MinuteType FIFTYONE = new org.broadleafcommerce.common.time.MinuteType("51", "51");

    public static final org.broadleafcommerce.common.time.MinuteType FIFTYTWO = new org.broadleafcommerce.common.time.MinuteType("52", "52");

    public static final org.broadleafcommerce.common.time.MinuteType FIFTYTHREE = new org.broadleafcommerce.common.time.MinuteType("53", "53");

    public static final org.broadleafcommerce.common.time.MinuteType FIFTYFOUR = new org.broadleafcommerce.common.time.MinuteType("54", "54");

    public static final org.broadleafcommerce.common.time.MinuteType FIFTYFIVE = new org.broadleafcommerce.common.time.MinuteType("55", "55");

    public static final org.broadleafcommerce.common.time.MinuteType FIFTYSIX = new org.broadleafcommerce.common.time.MinuteType("56", "56");

    public static final org.broadleafcommerce.common.time.MinuteType FIFTYSEVEN = new org.broadleafcommerce.common.time.MinuteType("57", "57");

    public static final org.broadleafcommerce.common.time.MinuteType FIFTYEIGHT = new org.broadleafcommerce.common.time.MinuteType("58", "58");

    public static final org.broadleafcommerce.common.time.MinuteType FIFTYNINE = new org.broadleafcommerce.common.time.MinuteType("59", "59");

    private java.lang.String type;

    private java.lang.String friendlyType;

    public static org.broadleafcommerce.common.time.MinuteType getInstance(final java.lang.String type) {
        return org.broadleafcommerce.common.time.MinuteType.TYPES.get(type);
    }

    public MinuteType() {
    }

    public MinuteType(final java.lang.String type, final java.lang.String friendlyType) {
        this.friendlyType = friendlyType;
        setType(type);
    }

    public java.lang.String getType() {
        return type;
    }

    public java.lang.String getFriendlyType() {
        return friendlyType;
    }

    private void setType(final java.lang.String type) {
        this.type = type;
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.time.MinuteType.__L5718, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.time.MinuteType.__L5717, org.broadleafcommerce.common.time.MinuteType.TYPES.containsKey(type)))))) {
            org.broadleafcommerce.common.time.MinuteType.TYPES.put(type, this);
        }else {
            throw new java.lang.RuntimeException(((("Cannot add the type: (" + type) + "). It already exists as a type via ") + (org.broadleafcommerce.common.time.MinuteType.getInstance(type).getClass().getName())));
        }
    }

    @java.lang.Override
    public int hashCode() {
        final int prime = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.time.MinuteType.__L5719, 31);
        int result = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.time.MinuteType.__L5720, 1);
        result = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.time.MinuteType.__L5728, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.time.MinuteType.__L5723, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.time.MinuteType.__L5721, prime)) * (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.time.MinuteType.__L5722, result))))) + (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.time.MinuteType.__L5727, (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.time.MinuteType.__L5724, ((type) == null)) ? perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.time.MinuteType.__L5725, 0) : perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.time.MinuteType.__L5726, type.hashCode()))))));
        return perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.time.MinuteType.__L5729, result);
    }

    @java.lang.Override
    public boolean equals(java.lang.Object obj) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.time.MinuteType.__L5730, ((this) == obj)))
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.time.MinuteType.__L5731, true);

        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.time.MinuteType.__L5732, (obj == null)))
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.time.MinuteType.__L5733, false);

        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.time.MinuteType.__L5735, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.time.MinuteType.__L5734, getClass().isAssignableFrom(obj.getClass()))))))
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.time.MinuteType.__L5736, false);

        org.broadleafcommerce.common.time.MinuteType other = ((org.broadleafcommerce.common.time.MinuteType) (obj));
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.time.MinuteType.__L5737, ((type) == null))) {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.time.MinuteType.__L5738, ((other.type) != null)))
                return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.time.MinuteType.__L5739, false);

        }else
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.time.MinuteType.__L5741, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.time.MinuteType.__L5740, type.equals(other.type))))))
                return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.time.MinuteType.__L5742, false);


        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.time.MinuteType.__L5743, true);
    }

    public static perturbation.location.PerturbationLocation __L5717;

    public static perturbation.location.PerturbationLocation __L5718;

    public static perturbation.location.PerturbationLocation __L5719;

    public static perturbation.location.PerturbationLocation __L5720;

    public static perturbation.location.PerturbationLocation __L5721;

    public static perturbation.location.PerturbationLocation __L5722;

    public static perturbation.location.PerturbationLocation __L5723;

    public static perturbation.location.PerturbationLocation __L5724;

    public static perturbation.location.PerturbationLocation __L5725;

    public static perturbation.location.PerturbationLocation __L5726;

    public static perturbation.location.PerturbationLocation __L5727;

    public static perturbation.location.PerturbationLocation __L5728;

    public static perturbation.location.PerturbationLocation __L5729;

    public static perturbation.location.PerturbationLocation __L5730;

    public static perturbation.location.PerturbationLocation __L5731;

    public static perturbation.location.PerturbationLocation __L5732;

    public static perturbation.location.PerturbationLocation __L5733;

    public static perturbation.location.PerturbationLocation __L5734;

    public static perturbation.location.PerturbationLocation __L5735;

    public static perturbation.location.PerturbationLocation __L5736;

    public static perturbation.location.PerturbationLocation __L5737;

    public static perturbation.location.PerturbationLocation __L5738;

    public static perturbation.location.PerturbationLocation __L5739;

    public static perturbation.location.PerturbationLocation __L5740;

    public static perturbation.location.PerturbationLocation __L5741;

    public static perturbation.location.PerturbationLocation __L5742;

    public static perturbation.location.PerturbationLocation __L5743;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.time.MinuteType.__L5717 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/time/MinuteType.java:124)", 5717, "Boolean");
        org.broadleafcommerce.common.time.MinuteType.__L5718 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/time/MinuteType.java:124)", 5718, "Boolean");
        org.broadleafcommerce.common.time.MinuteType.__L5719 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/time/MinuteType.java:133)", 5719, "Numerical");
        org.broadleafcommerce.common.time.MinuteType.__L5720 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/time/MinuteType.java:134)", 5720, "Numerical");
        org.broadleafcommerce.common.time.MinuteType.__L5721 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/time/MinuteType.java:135)", 5721, "Numerical");
        org.broadleafcommerce.common.time.MinuteType.__L5722 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/time/MinuteType.java:135)", 5722, "Numerical");
        org.broadleafcommerce.common.time.MinuteType.__L5723 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/time/MinuteType.java:135)", 5723, "Numerical");
        org.broadleafcommerce.common.time.MinuteType.__L5724 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/time/MinuteType.java:135)", 5724, "Boolean");
        org.broadleafcommerce.common.time.MinuteType.__L5725 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/time/MinuteType.java:135)", 5725, "Numerical");
        org.broadleafcommerce.common.time.MinuteType.__L5726 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/time/MinuteType.java:135)", 5726, "Numerical");
        org.broadleafcommerce.common.time.MinuteType.__L5727 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/time/MinuteType.java:135)", 5727, "Numerical");
        org.broadleafcommerce.common.time.MinuteType.__L5728 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/time/MinuteType.java:135)", 5728, "Numerical");
        org.broadleafcommerce.common.time.MinuteType.__L5729 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/time/MinuteType.java:136)", 5729, "Numerical");
        org.broadleafcommerce.common.time.MinuteType.__L5730 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/time/MinuteType.java:141)", 5730, "Boolean");
        org.broadleafcommerce.common.time.MinuteType.__L5731 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/time/MinuteType.java:142)", 5731, "Boolean");
        org.broadleafcommerce.common.time.MinuteType.__L5732 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/time/MinuteType.java:143)", 5732, "Boolean");
        org.broadleafcommerce.common.time.MinuteType.__L5733 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/time/MinuteType.java:144)", 5733, "Boolean");
        org.broadleafcommerce.common.time.MinuteType.__L5734 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/time/MinuteType.java:145)", 5734, "Boolean");
        org.broadleafcommerce.common.time.MinuteType.__L5735 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/time/MinuteType.java:145)", 5735, "Boolean");
        org.broadleafcommerce.common.time.MinuteType.__L5736 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/time/MinuteType.java:146)", 5736, "Boolean");
        org.broadleafcommerce.common.time.MinuteType.__L5737 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/time/MinuteType.java:148)", 5737, "Boolean");
        org.broadleafcommerce.common.time.MinuteType.__L5738 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/time/MinuteType.java:149)", 5738, "Boolean");
        org.broadleafcommerce.common.time.MinuteType.__L5739 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/time/MinuteType.java:150)", 5739, "Boolean");
        org.broadleafcommerce.common.time.MinuteType.__L5740 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/time/MinuteType.java:151)", 5740, "Boolean");
        org.broadleafcommerce.common.time.MinuteType.__L5741 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/time/MinuteType.java:151)", 5741, "Boolean");
        org.broadleafcommerce.common.time.MinuteType.__L5742 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/time/MinuteType.java:152)", 5742, "Boolean");
        org.broadleafcommerce.common.time.MinuteType.__L5743 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/time/MinuteType.java:153)", 5743, "Boolean");
    }

    static {
        org.broadleafcommerce.common.time.MinuteType.initPerturbationLocation0();
    }
}

