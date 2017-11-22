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


public class AddNPerturbatorImpl implements perturbation.perturbator.Perturbator {
    private int n = 1;

    public AddNPerturbatorImpl(int n) {
        this.n = n;
    }

    @java.lang.Override
    public boolean pboolean(boolean value) {
        throw new java.lang.UnsupportedOperationException();
    }

    @java.lang.Override
    public byte pbyte(byte value) {
        return ((byte) (value + (this.n)));
    }

    @java.lang.Override
    public short pshort(short value) {
        return ((short) (value + (this.n)));
    }

    @java.lang.Override
    public int pint(int value) {
        return value + (this.n);
    }

    @java.lang.Override
    public long plong(long value) {
        return value + (this.n);
    }

    @java.lang.Override
    public char pchar(char value) {
        return ((char) (value + (this.n)));
    }

    @java.lang.Override
    public float pfloat(float value) {
        return value + (this.n);
    }

    @java.lang.Override
    public double pdouble(double value) {
        return value + (this.n);
    }

    public java.math.BigInteger pBigInteger(java.math.BigInteger value) {
        return value.add(java.math.BigInteger.valueOf(this.n));
    }
}

