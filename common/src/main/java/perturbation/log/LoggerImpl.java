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
package perturbation.log;


public class LoggerImpl implements perturbation.log.Logger {
    private java.util.Map<perturbation.location.PerturbationLocation, java.lang.Integer> numberOfCallsPerLocation = new java.util.HashMap<perturbation.location.PerturbationLocation, java.lang.Integer>();

    private java.util.Map<perturbation.location.PerturbationLocation, java.lang.Integer> numberOfEnactionsPerLocation = new java.util.HashMap<perturbation.location.PerturbationLocation, java.lang.Integer>();

    @java.lang.Override
    public void logOn(perturbation.location.PerturbationLocation location) {
        this.numberOfCallsPerLocation.put(location, 0);
        this.numberOfEnactionsPerLocation.put(location, 0);
    }

    @java.lang.Override
    public void remove(perturbation.location.PerturbationLocation location) {
        this.numberOfCallsPerLocation.remove(location);
        this.numberOfEnactionsPerLocation.remove(location);
    }

    @java.lang.Override
    public void logCall(perturbation.location.PerturbationLocation location) {
        if (this.numberOfCallsPerLocation.containsKey(location))
            this.numberOfCallsPerLocation.put(location, ((this.numberOfCallsPerLocation.get(location)) + 1));

    }

    @java.lang.Override
    public void logEnaction(perturbation.location.PerturbationLocation location) {
        if (numberOfEnactionsPerLocation.containsKey(location))
            this.numberOfEnactionsPerLocation.put(location, ((this.numberOfEnactionsPerLocation.get(location)) + 1));

    }

    @java.lang.Override
    public int getCalls(perturbation.location.PerturbationLocation location) {
        return this.numberOfCallsPerLocation.get(location);
    }

    @java.lang.Override
    public int getEnactions(perturbation.location.PerturbationLocation location) {
        return this.numberOfEnactionsPerLocation.get(location);
    }

    @java.lang.Override
    public boolean isLogging(perturbation.location.PerturbationLocation location) {
        return (this.numberOfCallsPerLocation.containsKey(location)) && (this.numberOfEnactionsPerLocation.containsKey(location));
    }

    @java.lang.Override
    public void reset() {
        this.numberOfCallsPerLocation.clear();
        this.numberOfEnactionsPerLocation.clear();
    }
}

