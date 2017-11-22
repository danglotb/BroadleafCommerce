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
package perturbation.enactor;


public class RandomEnactorImpl extends perturbation.enactor.EnactorDecorator {
    private float epsilon;

    private java.util.Random rnd;

    public RandomEnactorImpl(perturbation.enactor.Enactor enactor, int seed, float epsilon) {
        super(enactor);
        this.epsilon = epsilon;
        this.rnd = new java.util.Random(seed);
    }

    public RandomEnactorImpl() {
        this(new perturbation.enactor.AlwaysEnactorImpl(), ((int) (java.lang.System.currentTimeMillis())), 0.05F);
    }

    public RandomEnactorImpl(float epsilon) {
        this(new perturbation.enactor.AlwaysEnactorImpl(), ((int) (java.lang.System.currentTimeMillis())), epsilon);
    }

    public RandomEnactorImpl(int seed, float epsilon) {
        this(new perturbation.enactor.AlwaysEnactorImpl(), seed, epsilon);
    }

    @java.lang.Override
    public boolean shouldBeActivated() {
        return ((rnd.nextFloat()) < (this.epsilon)) && (super.shouldBeActivated());
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "RAND" + (super.toString());
    }
}

