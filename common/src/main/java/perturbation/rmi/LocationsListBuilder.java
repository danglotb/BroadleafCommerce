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


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class LocationsListBuilder {

    protected static final Log LOG = LogFactory.getLog(LocationsListBuilder.class);

    private static java.lang.String removeExt(java.lang.String name) {
        return name.substring(0, ((name.length()) - (".java".length())));
    }

    private static boolean isJava(java.lang.String name) {
        return name.endsWith(".java");
    }

    static java.util.List<perturbation.location.PerturbationLocation> buildLocationsList(java.lang.String project, java.lang.String packagePath) {
        final java.util.List<perturbation.location.PerturbationLocation> locations = new java.util.ArrayList<perturbation.location.PerturbationLocation>();
        java.util.List<java.lang.Class> classes = perturbation.rmi.LocationsListBuilder.iterateFolders(new java.util.ArrayList<java.lang.Class>(), project, packagePath);
        for (int i = 0; i < (classes.size()); i++) {
            java.lang.Class clazz = classes.get(i);
//            LOG.info(clazz.getSimpleName());
            java.util.List<perturbation.location.PerturbationLocation> locationFromClass = perturbation.location.PerturbationLocationImpl.getLocationFromClass(clazz);
            for (int j = 0; j < (locationFromClass.size()); j++) {
                perturbation.location.PerturbationLocation location = locationFromClass.get(j);
                locations.add(location);
                location.setPerturbator(new perturbation.perturbator.AddOnePerturbatorImpl(new perturbation.perturbator.InvPerturbatorImpl()));
            }
        }
        return locations;
    }

    private static java.util.List<java.lang.Class> iterateFolders(java.util.List<java.lang.Class> classes, java.lang.String path, java.lang.String currentPackage) {
        java.io.File root = new java.io.File(path);
//        LOG.info(path);
        assert (root.listFiles()) != null;
        for (java.io.File subFile : root.listFiles()) {
//            LOG.info(subFile);
            if (subFile.isDirectory())
                perturbation.rmi.LocationsListBuilder.iterateFolders(classes, ((path + (subFile.getName())) + "/"), ((currentPackage + ".") + (subFile.getName())));
            else
                if (perturbation.rmi.LocationsListBuilder.isJava(subFile.getName())) {
                    try {
                        java.lang.String packageAsString = ((currentPackage.length()) == 0) ? "" : currentPackage + ".";
//                        LOG.info((packageAsString + (perturbation.rmi.LocationsListBuilder.removeExt(subFile.getName()))));
                        java.lang.Class<?> clazz = java.lang.Class.forName((packageAsString + (perturbation.rmi.LocationsListBuilder.removeExt(subFile.getName()))));
                        classes.add(clazz);
                    } catch (Exception | Error e) {
                        continue;
                    }
                }

        }
        return classes;
    }
}

