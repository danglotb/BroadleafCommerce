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
package perturbation.location;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import perturbation.rmi.LocationsListBuilder;

public class PerturbationLocationImpl implements perturbation.location.PerturbationLocation {

    protected static final Log LOG = LogFactory.getLog(PerturbationLocationImpl.class);

    private final java.lang.String locationType;

    private final int locationIndex;

    private final java.lang.String locationInCode;

    private perturbation.perturbator.Perturbator perturbator = new perturbation.perturbator.NothingPerturbatorImpl();

    private perturbation.enactor.Enactor enactor = new perturbation.enactor.NeverEnactorImpl();

    @java.lang.Override
    public int getLocationIndex() {
        return this.locationIndex;
    }

    @java.lang.Override
    public java.lang.String getLocationInCode() {
        return this.locationInCode;
    }

    @java.lang.Override
    public java.lang.String getType() {
        return this.locationType;
    }

    private PerturbationLocationImpl() {
        this.locationInCode = "";
        this.locationIndex = -1;
        this.locationType = "";
    }

    public PerturbationLocationImpl(java.lang.String location, int index, java.lang.String type) {
        this.locationInCode = location;
        this.locationIndex = index;
        this.locationType = type;
        this.perturbator = new perturbation.perturbator.InvPerturbatorImpl();
    }

    public perturbation.perturbator.Perturbator getPerturbator() {
        return this.perturbator;
    }

    public void setPerturbator(perturbation.perturbator.Perturbator pertubator) {
        this.perturbator = pertubator;
    }

    @java.lang.Override
    public perturbation.enactor.Enactor getEnactor() {
        return this.enactor;
    }

    @java.lang.Override
    public void setEnactor(perturbation.enactor.Enactor enactor) {
        this.enactor = enactor;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return ((((locationIndex) + "\t") + (locationInCode)) + "\t") + (locationType);
    }

    @java.lang.Override
    public int hashCode() {
        return this.locationIndex;
    }

    @java.lang.Override
    public boolean equals(java.lang.Object that) {
        return (that instanceof perturbation.location.PerturbationLocationImpl) && ((this.locationIndex) == (((perturbation.location.PerturbationLocationImpl) (that)).locationIndex));
    }

    public static java.util.List<perturbation.location.PerturbationLocation> getLocationFromClass(java.lang.Class clazz) {
        java.util.List<perturbation.location.PerturbationLocation> locations = new java.util.ArrayList<perturbation.location.PerturbationLocation>();
        try {
            java.lang.reflect.Field[] fields = clazz.getFields();
            for (java.lang.reflect.Field field : fields) {
                field.setAccessible(true);
                if (field.getName().startsWith("__L"))
                    try {
                        locations.add(((perturbation.location.PerturbationLocation) (field.get(null))));
                    } catch (java.lang.IllegalAccessException e) {
                        e.printStackTrace();
                    }

            }
        } catch (java.lang.NoClassDefFoundError e) {
        }
        return locations;
    }
}

