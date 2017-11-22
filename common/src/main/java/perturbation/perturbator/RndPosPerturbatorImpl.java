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
package perturbation.perturbator;


public class RndPosPerturbatorImpl extends perturbation.perturbator.PerturbatorDecorator {
    public RndPosPerturbatorImpl() {
        super(new perturbation.perturbator.RndPerturbatorImpl());
    }

    @java.lang.Override
    public byte pbyte(byte value) {
        byte perturbation = super.pbyte(value);
        return perturbation >= 0 ? perturbation : ((byte) ((-1) * perturbation));
    }

    @java.lang.Override
    public short pshort(short value) {
        short perturbation = ((short) (new java.util.Random().nextInt()));
        return perturbation >= 0 ? perturbation : ((short) ((-1) * perturbation));
    }

    @java.lang.Override
    public int pint(int value) {
        int perturbation = super.pint(value);
        return perturbation >= 0 ? perturbation : (-1) * perturbation;
    }

    @java.lang.Override
    public long plong(long value) {
        long perturbation = plong(value);
        return perturbation >= 0 ? perturbation : (-1) * perturbation;
    }

    @java.lang.Override
    public char pchar(char value) {
        return super.pchar(value);
    }

    @java.lang.Override
    public float pfloat(float value) {
        float perturbation = super.pfloat(value);
        return perturbation >= 0 ? perturbation : (-1) * perturbation;
    }

    @java.lang.Override
    public double pdouble(double value) {
        double perturbation = super.pdouble(value);
        return perturbation >= 0 ? perturbation : (-1) * perturbation;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "RNDP";
    }
}

