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


public class EnactorDecorator implements perturbation.enactor.Enactor {
    protected perturbation.enactor.Enactor decoratedEnactor;

    public EnactorDecorator(perturbation.enactor.Enactor decoratedEnactor) {
        super();
        this.decoratedEnactor = decoratedEnactor;
    }

    @java.lang.Override
    public boolean shouldBeActivated() {
        return this.decoratedEnactor.shouldBeActivated();
    }

    @java.lang.Override
    public java.lang.String toString() {
        return this.decoratedEnactor.toString();
    }
}

