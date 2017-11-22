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
package perturbation.rmi;


public interface PerturbationServer extends java.rmi.Remote {
    perturbation.location.PerturbationLocation enableLocation(perturbation.location.PerturbationLocation location) throws java.rmi.RemoteException;

    perturbation.location.PerturbationLocation enableLocation(perturbation.location.PerturbationLocation location, perturbation.enactor.Enactor enactor) throws java.rmi.RemoteException;

    perturbation.location.PerturbationLocation disableLocation(perturbation.location.PerturbationLocation location) throws java.rmi.RemoteException;

    java.util.List<perturbation.location.PerturbationLocation> getLocations() throws java.rmi.RemoteException;

    int getCalls(perturbation.location.PerturbationLocation location) throws java.rmi.RemoteException;

    int getEnactions(perturbation.location.PerturbationLocation location) throws java.rmi.RemoteException;

    int[] getCalls() throws java.rmi.RemoteException;

    int[] getCallsAndResetLogger() throws java.rmi.RemoteException;

    int[] getEnactions() throws java.rmi.RemoteException;

    int[] getEnactionsAndResetLogger() throws java.rmi.RemoteException;

    perturbation.location.PerturbationLocation logOn(perturbation.location.PerturbationLocation location) throws java.rmi.RemoteException;

    void logAllLocation() throws java.rmi.RemoteException;

    perturbation.location.PerturbationLocation stopLogOn(perturbation.location.PerturbationLocation location) throws java.rmi.RemoteException;

    void stopLogOnAllLocation() throws java.rmi.RemoteException;

    void stopService() throws java.rmi.RemoteException;
}

