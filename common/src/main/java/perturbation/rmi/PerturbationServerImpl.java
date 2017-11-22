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


public class PerturbationServerImpl implements perturbation.rmi.PerturbationServer {
    private static final java.lang.String NAME_LOGGER = "PerturbationServerLogger";

    public static final int PORT = 13223;

    public static final java.lang.String NAME_SERVER = "PerturbationServer";

    private java.util.List<perturbation.location.PerturbationLocation> locations;

    private static perturbation.rmi.PerturbationServer server;

    private static java.rmi.registry.Registry registry;

    public PerturbationServerImpl(java.lang.String project, java.lang.String packagePath) {
        this.locations = perturbation.rmi.LocationsListBuilder.buildLocationsList(project, packagePath);
        java.util.Collections.sort(this.locations, new java.util.Comparator<perturbation.location.PerturbationLocation>() {
            @java.lang.Override
            public int compare(perturbation.location.PerturbationLocation l1, perturbation.location.PerturbationLocation l2) {
                return (l1.getLocationIndex()) - (l2.getLocationIndex());
            }
        });
        perturbation.PerturbationEngine.loggers.put(perturbation.rmi.PerturbationServerImpl.NAME_LOGGER, new perturbation.log.LoggerImpl());
    }

    public java.util.List<perturbation.location.PerturbationLocation> getLocations() throws java.rmi.RemoteException {
        return this.locations;
    }

    @java.lang.Override
    public perturbation.location.PerturbationLocation enableLocation(perturbation.location.PerturbationLocation location) throws java.rmi.RemoteException {
        location = locations.get(locations.indexOf(location));
        location.setEnactor(new perturbation.enactor.AlwaysEnactorImpl());
        return location;
    }

    @java.lang.Override
    public perturbation.location.PerturbationLocation enableLocation(perturbation.location.PerturbationLocation location, perturbation.enactor.Enactor enactor) throws java.rmi.RemoteException {
        location = locations.get(locations.indexOf(location));
        location.setEnactor(enactor);
        return location;
    }

    @java.lang.Override
    public perturbation.location.PerturbationLocation logOn(perturbation.location.PerturbationLocation location) throws java.rmi.RemoteException {
        location = locations.get(locations.indexOf(location));
        perturbation.PerturbationEngine.loggers.get(perturbation.rmi.PerturbationServerImpl.NAME_LOGGER).logOn(location);
        return location;
    }

    @java.lang.Override
    public void logAllLocation() throws java.rmi.RemoteException {
        for (perturbation.location.PerturbationLocation location : this.locations) {
            perturbation.PerturbationEngine.loggers.get(perturbation.rmi.PerturbationServerImpl.NAME_LOGGER).logOn(location);
        }
    }

    @java.lang.Override
    public perturbation.location.PerturbationLocation stopLogOn(perturbation.location.PerturbationLocation location) throws java.rmi.RemoteException {
        location = locations.get(locations.indexOf(location));
        perturbation.PerturbationEngine.loggers.get(perturbation.rmi.PerturbationServerImpl.NAME_LOGGER).remove(location);
        return location;
    }

    @java.lang.Override
    public void stopLogOnAllLocation() throws java.rmi.RemoteException {
        for (perturbation.location.PerturbationLocation location : this.locations) {
            perturbation.PerturbationEngine.loggers.get(perturbation.rmi.PerturbationServerImpl.NAME_LOGGER).remove(location);
        }
    }

    @java.lang.Override
    public int getCalls(perturbation.location.PerturbationLocation location) throws java.rmi.RemoteException {
        location = locations.get(locations.indexOf(location));
        return perturbation.PerturbationEngine.loggers.get(perturbation.rmi.PerturbationServerImpl.NAME_LOGGER).getCalls(location);
    }

    @java.lang.Override
    public int getEnactions(perturbation.location.PerturbationLocation location) throws java.rmi.RemoteException {
        location = locations.get(locations.indexOf(location));
        return perturbation.PerturbationEngine.loggers.get(perturbation.rmi.PerturbationServerImpl.NAME_LOGGER).getEnactions(location);
    }

    @java.lang.Override
    public int[] getCalls() throws java.rmi.RemoteException {
        int[] calls = new int[this.locations.size()];
        for (int i = 0; i < (this.locations.size()); i++) {
            calls[i] = perturbation.PerturbationEngine.loggers.get(perturbation.rmi.PerturbationServerImpl.NAME_LOGGER).getCalls(this.locations.get(i));
        }
        return calls;
    }

    @java.lang.Override
    public int[] getCallsAndResetLogger() throws java.rmi.RemoteException {
        int[] calls = new int[this.locations.size()];
        for (int i = 0; i < (this.locations.size()); i++) {
            calls[i] = perturbation.PerturbationEngine.loggers.get(perturbation.rmi.PerturbationServerImpl.NAME_LOGGER).getCalls(this.locations.get(i));
            perturbation.PerturbationEngine.loggers.get(perturbation.rmi.PerturbationServerImpl.NAME_LOGGER).remove(this.locations.get(i));
            perturbation.PerturbationEngine.loggers.get(perturbation.rmi.PerturbationServerImpl.NAME_LOGGER).logOn(this.locations.get(i));
        }
        return calls;
    }

    @java.lang.Override
    public int[] getEnactions() throws java.rmi.RemoteException {
        int[] enactions = new int[this.locations.size()];
        for (int i = 0; i < (this.locations.size()); i++) {
            enactions[i] = perturbation.PerturbationEngine.loggers.get(perturbation.rmi.PerturbationServerImpl.NAME_LOGGER).getEnactions(this.locations.get(i));
        }
        return enactions;
    }

    @java.lang.Override
    public int[] getEnactionsAndResetLogger() throws java.rmi.RemoteException {
        int[] enactions = new int[this.locations.size()];
        for (int i = 0; i < (this.locations.size()); i++) {
            enactions[i] = perturbation.PerturbationEngine.loggers.get(perturbation.rmi.PerturbationServerImpl.NAME_LOGGER).getEnactions(this.locations.get(i));
            perturbation.PerturbationEngine.loggers.get(perturbation.rmi.PerturbationServerImpl.NAME_LOGGER).remove(this.locations.get(i));
            perturbation.PerturbationEngine.loggers.get(perturbation.rmi.PerturbationServerImpl.NAME_LOGGER).logOn(this.locations.get(i));
        }
        return enactions;
    }

    @java.lang.Override
    public perturbation.location.PerturbationLocation disableLocation(perturbation.location.PerturbationLocation location) throws java.rmi.RemoteException {
        location = locations.get(locations.indexOf(location));
        location.setEnactor(new perturbation.enactor.NeverEnactorImpl());
        return location;
    }

    public void stopService() throws java.rmi.RemoteException {
        try {
            perturbation.rmi.PerturbationServerImpl.registry.unbind(perturbation.rmi.PerturbationServerImpl.NAME_SERVER);
        } catch (java.rmi.NotBoundException ignored) {
        }
        java.rmi.server.UnicastRemoteObject.unexportObject(perturbation.rmi.PerturbationServerImpl.server, true);
    }

    public static void startServer(final java.lang.String project, final java.lang.String packagePath) {
        new java.lang.Thread(new java.lang.Runnable() {
            @java.lang.Override
            public void run() {
                try {
                    perturbation.rmi.PerturbationServerImpl.server = new perturbation.rmi.PerturbationServerImpl(project, packagePath);
                    java.rmi.server.UnicastRemoteObject.exportObject(perturbation.rmi.PerturbationServerImpl.server, perturbation.rmi.PerturbationServerImpl.PORT);
                    perturbation.rmi.PerturbationServerImpl.registry = java.rmi.registry.LocateRegistry.createRegistry(perturbation.rmi.PerturbationServerImpl.PORT);
                    perturbation.rmi.PerturbationServerImpl.registry.rebind(perturbation.rmi.PerturbationServerImpl.NAME_SERVER, perturbation.rmi.PerturbationServerImpl.server);
                } catch (java.lang.Exception e) {
                    e.printStackTrace();
                    throw new java.lang.RuntimeException(e);
                }
            }
        }).start();
    }
}

