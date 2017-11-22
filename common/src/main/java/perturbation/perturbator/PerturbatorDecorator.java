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


public class PerturbatorDecorator implements perturbation.perturbator.Perturbator {
    protected perturbation.perturbator.Perturbator decoratedPerturbator;

    public PerturbatorDecorator(perturbation.perturbator.Perturbator decoratedPerturbator) {
        this.decoratedPerturbator = decoratedPerturbator;
    }

    @java.lang.Override
    public boolean pboolean(boolean value) {
        return this.decoratedPerturbator.pboolean(value);
    }

    @java.lang.Override
    public byte pbyte(byte value) {
        return this.decoratedPerturbator.pbyte(value);
    }

    @java.lang.Override
    public short pshort(short value) {
        return this.decoratedPerturbator.pshort(value);
    }

    @java.lang.Override
    public int pint(int value) {
        return this.decoratedPerturbator.pint(value);
    }

    @java.lang.Override
    public long plong(long value) {
        return this.decoratedPerturbator.plong(value);
    }

    @java.lang.Override
    public char pchar(char value) {
        return this.decoratedPerturbator.pchar(value);
    }

    @java.lang.Override
    public float pfloat(float value) {
        return this.decoratedPerturbator.pfloat(value);
    }

    @java.lang.Override
    public double pdouble(double value) {
        return this.decoratedPerturbator.pdouble(value);
    }

    public java.math.BigInteger pBigInteger(java.math.BigInteger value) {
        return this.decoratedPerturbator.pBigInteger(value);
    }

    @java.lang.Override
    public java.lang.String toString() {
        return this.decoratedPerturbator.toString();
    }
}

