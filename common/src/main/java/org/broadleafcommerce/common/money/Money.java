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
package org.broadleafcommerce.common.money;


@javax.xml.bind.annotation.XmlAccessorType(javax.xml.bind.annotation.XmlAccessType.FIELD)
@com.fasterxml.jackson.annotation.JsonIgnoreProperties({ "zero" })
public class Money implements java.io.Externalizable , java.io.Serializable , java.lang.Cloneable , java.lang.Comparable<org.broadleafcommerce.common.money.Money> {
    private static final long serialVersionUID = 1L;

    @javax.xml.bind.annotation.XmlElement
    @javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter(org.broadleafcommerce.common.util.xml.BigDecimalRoundingAdapter.class)
    private java.math.BigDecimal amount;

    @javax.xml.bind.annotation.XmlElement
    @javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter(org.broadleafcommerce.common.money.util.CurrencyAdapter.class)
    private final java.util.Currency currency;

    public static final org.broadleafcommerce.common.money.Money ZERO = new org.broadleafcommerce.common.money.Money(java.math.BigDecimal.ZERO);

    protected static java.lang.String getCurrencyCode(org.broadleafcommerce.common.currency.domain.BroadleafCurrency blCurrency) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.money.Money.__L3563, (blCurrency != null))) {
            return blCurrency.getCurrencyCode();
        }else {
            return org.broadleafcommerce.common.money.Money.defaultCurrency().getCurrencyCode();
        }
    }

    public Money(java.util.Currency currency) {
        this(org.broadleafcommerce.common.money.BankersRounding.zeroAmount(), currency);
    }

    public Money(org.broadleafcommerce.common.currency.domain.BroadleafCurrency blCurrency) {
        this(0, java.util.Currency.getInstance(org.broadleafcommerce.common.money.Money.getCurrencyCode(blCurrency)));
    }

    public Money(java.math.BigDecimal amount, org.broadleafcommerce.common.currency.domain.BroadleafCurrency blCurrency) {
        this(amount, java.util.Currency.getInstance(org.broadleafcommerce.common.money.Money.getCurrencyCode(blCurrency)));
    }

    public Money(java.math.BigDecimal amount, org.broadleafcommerce.common.currency.domain.BroadleafCurrency blCurrency, int scale) {
        this(amount, java.util.Currency.getInstance(org.broadleafcommerce.common.money.Money.getCurrencyCode(blCurrency)), scale);
    }

    public Money() {
        this(org.broadleafcommerce.common.money.BankersRounding.zeroAmount(), org.broadleafcommerce.common.money.Money.defaultCurrency());
    }

    public Money(java.math.BigDecimal amount) {
        this(amount, org.broadleafcommerce.common.money.Money.defaultCurrency());
    }

    public Money(double amount) {
        this(org.broadleafcommerce.common.money.Money.valueOf(amount), org.broadleafcommerce.common.money.Money.defaultCurrency());
    }

    public Money(int amount) {
        this(java.math.BigDecimal.valueOf(amount).setScale(org.broadleafcommerce.common.money.BankersRounding.getScaleForCurrency(org.broadleafcommerce.common.money.Money.defaultCurrency()), java.math.RoundingMode.HALF_EVEN), org.broadleafcommerce.common.money.Money.defaultCurrency());
    }

    public Money(long amount) {
        this(java.math.BigDecimal.valueOf(amount).setScale(org.broadleafcommerce.common.money.BankersRounding.getScaleForCurrency(org.broadleafcommerce.common.money.Money.defaultCurrency()), java.math.RoundingMode.HALF_EVEN), org.broadleafcommerce.common.money.Money.defaultCurrency());
    }

    public Money(java.lang.String amount) {
        this(org.broadleafcommerce.common.money.Money.valueOf(amount), org.broadleafcommerce.common.money.Money.defaultCurrency());
    }

    public Money(java.math.BigDecimal amount, java.lang.String currencyCode) {
        this(amount, java.util.Currency.getInstance(currencyCode));
    }

    public Money(double amount, java.util.Currency currency) {
        this(org.broadleafcommerce.common.money.Money.valueOf(amount), currency);
    }

    public Money(double amount, java.lang.String currencyCode) {
        this(org.broadleafcommerce.common.money.Money.valueOf(amount), java.util.Currency.getInstance(currencyCode));
    }

    public Money(int amount, java.util.Currency currency) {
        this(java.math.BigDecimal.valueOf(amount).setScale(org.broadleafcommerce.common.money.BankersRounding.getScaleForCurrency(currency), java.math.RoundingMode.HALF_EVEN), currency);
    }

    public Money(int amount, java.lang.String currencyCode) {
        this(java.math.BigDecimal.valueOf(amount).setScale(org.broadleafcommerce.common.money.BankersRounding.getScaleForCurrency(java.util.Currency.getInstance(currencyCode)), java.math.RoundingMode.HALF_EVEN), java.util.Currency.getInstance(currencyCode));
    }

    public Money(long amount, java.util.Currency currency) {
        this(java.math.BigDecimal.valueOf(amount).setScale(org.broadleafcommerce.common.money.BankersRounding.getScaleForCurrency(currency), java.math.RoundingMode.HALF_EVEN), currency);
    }

    public Money(long amount, java.lang.String currencyCode) {
        this(java.math.BigDecimal.valueOf(amount).setScale(org.broadleafcommerce.common.money.BankersRounding.getScaleForCurrency(java.util.Currency.getInstance(currencyCode)), java.math.RoundingMode.HALF_EVEN), java.util.Currency.getInstance(currencyCode));
    }

    public Money(java.lang.String amount, java.util.Currency currency) {
        this(org.broadleafcommerce.common.money.Money.valueOf(amount), currency);
    }

    public Money(java.lang.String amount, java.lang.String currencyCode) {
        this(org.broadleafcommerce.common.money.Money.valueOf(amount), java.util.Currency.getInstance(currencyCode));
    }

    public Money(java.math.BigDecimal amount, java.util.Currency currency) {
        if (currency == null) {
            throw new java.lang.IllegalArgumentException("currency cannot be null");
        }
        this.currency = currency;
        this.amount = org.broadleafcommerce.common.money.BankersRounding.setScale(org.broadleafcommerce.common.money.BankersRounding.getScaleForCurrency(currency), amount);
    }

    public Money(java.math.BigDecimal amount, java.util.Currency currency, int scale) {
        if (currency == null) {
            throw new java.lang.IllegalArgumentException("currency cannot be null");
        }
        this.currency = currency;
        this.amount = org.broadleafcommerce.common.money.BankersRounding.setScale(amount, scale);
    }

    public java.math.BigDecimal getAmount() {
        return amount;
    }

    public java.util.Currency getCurrency() {
        return currency;
    }

    public org.broadleafcommerce.common.money.Money add(org.broadleafcommerce.common.money.Money other) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.money.Money.__L3565, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.money.Money.__L3564, other.getCurrency().equals(getCurrency())))))) {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.money.Money.__L3572, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.money.Money.__L3570, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.money.Money.__L3566, ((org.broadleafcommerce.common.money.CurrencyConversionContext.getCurrencyConversionContext()) != null))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.money.Money.__L3569, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.money.Money.__L3567, org.broadleafcommerce.common.money.CurrencyConversionContext.getCurrencyConversionContext().size())) > (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.money.Money.__L3568, 0)))))))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.money.Money.__L3571, ((org.broadleafcommerce.common.money.CurrencyConversionContext.getCurrencyConversionService()) != null)))))) {
                other = org.broadleafcommerce.common.money.CurrencyConversionContext.getCurrencyConversionService().convertCurrency(other, getCurrency(), perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.money.Money.__L3573, amount.scale()));
            }else {
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.money.Money.__L3574, ((this) == (org.broadleafcommerce.common.money.Money.ZERO)))) {
                    return new org.broadleafcommerce.common.money.Money(amount.add(other.amount), other.currency, perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.money.Money.__L3580, (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.money.Money.__L3577, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.money.Money.__L3575, amount.scale())) == (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.money.Money.__L3576, 0)))) ? perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.money.Money.__L3578, org.broadleafcommerce.common.money.BankersRounding.getScaleForCurrency(other.currency)) : perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.money.Money.__L3579, amount.scale()))));
                }else
                    if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.money.Money.__L3581, (other == (org.broadleafcommerce.common.money.Money.ZERO)))) {
                        return this;
                    }

                throw new java.lang.UnsupportedOperationException(((((("No currency conversion service is registered, cannot add different currency " + "types together (") + (getCurrency().getCurrencyCode())) + " ") + (other.getCurrency().getCurrencyCode())) + ")"));
            }
        }
        return new org.broadleafcommerce.common.money.Money(amount.add(other.amount), currency, perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.money.Money.__L3587, (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.money.Money.__L3584, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.money.Money.__L3582, amount.scale())) == (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.money.Money.__L3583, 0)))) ? perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.money.Money.__L3585, org.broadleafcommerce.common.money.BankersRounding.getScaleForCurrency(currency)) : perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.money.Money.__L3586, amount.scale()))));
    }

    public org.broadleafcommerce.common.money.Money subtract(org.broadleafcommerce.common.money.Money other) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.money.Money.__L3589, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.money.Money.__L3588, other.getCurrency().equals(getCurrency())))))) {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.money.Money.__L3596, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.money.Money.__L3594, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.money.Money.__L3590, ((org.broadleafcommerce.common.money.CurrencyConversionContext.getCurrencyConversionContext()) != null))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.money.Money.__L3593, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.money.Money.__L3591, org.broadleafcommerce.common.money.CurrencyConversionContext.getCurrencyConversionContext().size())) > (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.money.Money.__L3592, 0)))))))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.money.Money.__L3595, ((org.broadleafcommerce.common.money.CurrencyConversionContext.getCurrencyConversionService()) != null)))))) {
                other = org.broadleafcommerce.common.money.CurrencyConversionContext.getCurrencyConversionService().convertCurrency(other, getCurrency(), perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.money.Money.__L3597, amount.scale()));
            }else {
                if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.money.Money.__L3598, (other == (org.broadleafcommerce.common.money.Money.ZERO)))) {
                    return this;
                }else
                    if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.money.Money.__L3599, ((this) == (org.broadleafcommerce.common.money.Money.ZERO)))) {
                        return new org.broadleafcommerce.common.money.Money(amount.subtract(other.amount), other.currency, perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.money.Money.__L3605, (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.money.Money.__L3602, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.money.Money.__L3600, amount.scale())) == (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.money.Money.__L3601, 0)))) ? perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.money.Money.__L3603, org.broadleafcommerce.common.money.BankersRounding.getScaleForCurrency(other.currency)) : perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.money.Money.__L3604, amount.scale()))));
                    }

                throw new java.lang.UnsupportedOperationException(((((("No currency conversion service is registered, cannot subtract different currency " + "types (") + (getCurrency().getCurrencyCode())) + ", ") + (other.getCurrency().getCurrencyCode())) + ")"));
            }
        }
        return new org.broadleafcommerce.common.money.Money(amount.subtract(other.amount), currency, perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.money.Money.__L3611, (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.money.Money.__L3608, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.money.Money.__L3606, amount.scale())) == (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.money.Money.__L3607, 0)))) ? perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.money.Money.__L3609, org.broadleafcommerce.common.money.BankersRounding.getScaleForCurrency(currency)) : perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.money.Money.__L3610, amount.scale()))));
    }

    public org.broadleafcommerce.common.money.Money multiply(double amount) {
        return multiply(org.broadleafcommerce.common.money.Money.valueOf(amount));
    }

    public org.broadleafcommerce.common.money.Money multiply(int amount) {
        java.math.BigDecimal value = java.math.BigDecimal.valueOf(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.money.Money.__L3612, amount));
        value = value.setScale(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.money.Money.__L3613, org.broadleafcommerce.common.money.BankersRounding.getScaleForCurrency(currency)), java.math.RoundingMode.HALF_EVEN);
        return multiply(value);
    }

    public org.broadleafcommerce.common.money.Money multiply(java.math.BigDecimal multiplier) {
        return new org.broadleafcommerce.common.money.Money(amount.multiply(multiplier), currency, perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.money.Money.__L3619, (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.money.Money.__L3616, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.money.Money.__L3614, amount.scale())) == (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.money.Money.__L3615, 0)))) ? perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.money.Money.__L3617, org.broadleafcommerce.common.money.BankersRounding.getScaleForCurrency(currency)) : perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.money.Money.__L3618, amount.scale()))));
    }

    public org.broadleafcommerce.common.money.Money divide(double amount) {
        return this.divide(amount, java.math.RoundingMode.HALF_EVEN);
    }

    public org.broadleafcommerce.common.money.Money divide(double amount, java.math.RoundingMode roundingMode) {
        return divide(org.broadleafcommerce.common.money.Money.valueOf(amount), roundingMode);
    }

    public org.broadleafcommerce.common.money.Money divide(int amount) {
        return this.divide(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.money.Money.__L3620, amount), java.math.RoundingMode.HALF_EVEN);
    }

    public org.broadleafcommerce.common.money.Money divide(int amount, java.math.RoundingMode roundingMode) {
        java.math.BigDecimal value = java.math.BigDecimal.valueOf(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.money.Money.__L3621, amount));
        value = value.setScale(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.money.Money.__L3622, org.broadleafcommerce.common.money.BankersRounding.getScaleForCurrency(currency)), java.math.RoundingMode.HALF_EVEN);
        return divide(value, roundingMode);
    }

    public org.broadleafcommerce.common.money.Money divide(java.math.BigDecimal divisor) {
        return this.divide(divisor, java.math.RoundingMode.HALF_EVEN);
    }

    public org.broadleafcommerce.common.money.Money divide(java.math.BigDecimal divisor, java.math.RoundingMode roundingMode) {
        return new org.broadleafcommerce.common.money.Money(amount.divide(divisor, perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.money.Money.__L3623, amount.scale()), roundingMode), currency, perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.money.Money.__L3629, (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.money.Money.__L3626, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.money.Money.__L3624, amount.scale())) == (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.money.Money.__L3625, 0)))) ? perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.money.Money.__L3627, org.broadleafcommerce.common.money.BankersRounding.getScaleForCurrency(currency)) : perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.money.Money.__L3628, amount.scale()))));
    }

    public org.broadleafcommerce.common.money.Money abs() {
        return new org.broadleafcommerce.common.money.Money(amount.abs(), currency);
    }

    public org.broadleafcommerce.common.money.Money min(org.broadleafcommerce.common.money.Money other) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.money.Money.__L3630, (other == null))) {
            return this;
        }
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.money.Money.__L3631, lessThan(other)) ? this : other;
    }

    public org.broadleafcommerce.common.money.Money max(org.broadleafcommerce.common.money.Money other) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.money.Money.__L3632, (other == null))) {
            return this;
        }
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.money.Money.__L3633, greaterThan(other)) ? this : other;
    }

    public org.broadleafcommerce.common.money.Money negate() {
        return new org.broadleafcommerce.common.money.Money(amount.negate(), currency);
    }

    public boolean isZero() {
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.money.Money.__L3636, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.money.Money.__L3634, amount.compareTo(org.broadleafcommerce.common.money.BankersRounding.zeroAmount()))) == (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.money.Money.__L3635, 0))));
    }

    public org.broadleafcommerce.common.money.Money zero() {
        return org.broadleafcommerce.common.money.Money.zero(currency);
    }

    public boolean lessThan(org.broadleafcommerce.common.money.Money other) {
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.money.Money.__L3639, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.money.Money.__L3637, compareTo(other))) < (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.money.Money.__L3638, 0))));
    }

    public boolean lessThan(java.math.BigDecimal value) {
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.money.Money.__L3642, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.money.Money.__L3640, amount.compareTo(value))) < (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.money.Money.__L3641, 0))));
    }

    public boolean lessThanOrEqual(org.broadleafcommerce.common.money.Money other) {
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.money.Money.__L3645, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.money.Money.__L3643, compareTo(other))) <= (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.money.Money.__L3644, 0))));
    }

    public boolean lessThanOrEqual(java.math.BigDecimal value) {
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.money.Money.__L3648, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.money.Money.__L3646, amount.compareTo(value))) <= (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.money.Money.__L3647, 0))));
    }

    public boolean greaterThan(org.broadleafcommerce.common.money.Money other) {
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.money.Money.__L3651, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.money.Money.__L3649, compareTo(other))) > (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.money.Money.__L3650, 0))));
    }

    public boolean greaterThan(java.math.BigDecimal value) {
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.money.Money.__L3654, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.money.Money.__L3652, amount.compareTo(value))) > (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.money.Money.__L3653, 0))));
    }

    public boolean greaterThanOrEqual(org.broadleafcommerce.common.money.Money other) {
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.money.Money.__L3657, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.money.Money.__L3655, compareTo(other))) >= (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.money.Money.__L3656, 0))));
    }

    public boolean greaterThanOrEqual(java.math.BigDecimal value) {
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.money.Money.__L3660, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.money.Money.__L3658, amount.compareTo(value))) >= (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.money.Money.__L3659, 0))));
    }

    @java.lang.Override
    public int compareTo(org.broadleafcommerce.common.money.Money other) {
        return perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.money.Money.__L3661, amount.compareTo(other.amount));
    }

    public int compareTo(java.math.BigDecimal value) {
        return perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.money.Money.__L3662, amount.compareTo(value));
    }

    @java.lang.Override
    public boolean equals(java.lang.Object o) {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.money.Money.__L3663, ((this) == o))) {
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.money.Money.__L3664, true);
        }
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.money.Money.__L3665, (o == null)))
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.money.Money.__L3666, false);

        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.money.Money.__L3668, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.money.Money.__L3667, getClass().isAssignableFrom(o.getClass())))))) {
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.money.Money.__L3669, false);
        }
        org.broadleafcommerce.common.money.Money money = ((org.broadleafcommerce.common.money.Money) (o));
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.money.Money.__L3674, (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.money.Money.__L3670, ((amount) != null)) ? perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.money.Money.__L3672, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.money.Money.__L3671, amount.equals(money.amount))))) : perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.money.Money.__L3673, ((money.amount) != null))))) {
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.money.Money.__L3675, false);
        }
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.money.Money.__L3676, isZero())) {
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.money.Money.__L3677, true);
        }
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.money.Money.__L3682, (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.money.Money.__L3678, ((currency) != null)) ? perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.money.Money.__L3680, (!(perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.money.Money.__L3679, currency.equals(money.currency))))) : perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.money.Money.__L3681, ((money.currency) != null))))) {
            return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.money.Money.__L3683, false);
        }
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.money.Money.__L3684, true);
    }

    @java.lang.Override
    public int hashCode() {
        int result = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.money.Money.__L3688, (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.money.Money.__L3685, ((amount) != null)) ? perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.money.Money.__L3686, amount.hashCode()) : perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.money.Money.__L3687, 0)));
        result = perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.money.Money.__L3696, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.money.Money.__L3691, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.money.Money.__L3689, 31)) * (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.money.Money.__L3690, result))))) + (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.money.Money.__L3695, (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.money.Money.__L3692, ((currency) != null)) ? perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.money.Money.__L3693, currency.hashCode()) : perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.money.Money.__L3694, 0))))));
        return perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.money.Money.__L3697, result);
    }

    @java.lang.Override
    public java.lang.Object clone() {
        return new org.broadleafcommerce.common.money.Money(amount, currency);
    }

    @java.lang.Override
    public java.lang.String toString() {
        return amount.toString();
    }

    public double doubleValue() {
        try {
            return amount.doubleValue();
        } catch (java.lang.NumberFormatException e) {
            if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.money.Money.__L3698, e.getMessage().equals("For input string: \"0.00null\""))) {
                return amount.doubleValue();
            }else {
                throw e;
            }
        }
    }

    public java.lang.String stringValue() {
        return ((amount.toString()) + " ") + (currency.getCurrencyCode());
    }

    public static org.broadleafcommerce.common.money.Money zero(java.lang.String currencyCode) {
        return org.broadleafcommerce.common.money.Money.zero(java.util.Currency.getInstance(currencyCode));
    }

    public static org.broadleafcommerce.common.money.Money zero(java.util.Currency currency) {
        return new org.broadleafcommerce.common.money.Money(org.broadleafcommerce.common.money.BankersRounding.zeroAmount(), currency);
    }

    public static org.broadleafcommerce.common.money.Money abs(org.broadleafcommerce.common.money.Money money) {
        return new org.broadleafcommerce.common.money.Money(money.amount.abs(), money.currency);
    }

    public static org.broadleafcommerce.common.money.Money min(org.broadleafcommerce.common.money.Money left, org.broadleafcommerce.common.money.Money right) {
        return left.min(right);
    }

    public static org.broadleafcommerce.common.money.Money max(org.broadleafcommerce.common.money.Money left, org.broadleafcommerce.common.money.Money right) {
        return left.max(right);
    }

    public static java.math.BigDecimal toAmount(org.broadleafcommerce.common.money.Money money) {
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.money.Money.__L3699, (money == null)) ? null : money.amount;
    }

    public static java.util.Currency toCurrency(org.broadleafcommerce.common.money.Money money) {
        return perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.money.Money.__L3700, (money == null)) ? null : money.currency;
    }

    private static java.math.BigDecimal valueOf(double amount) {
        return org.broadleafcommerce.common.money.Money.valueOf(java.lang.String.valueOf(amount));
    }

    private static java.math.BigDecimal valueOf(java.lang.String amount) {
        java.math.BigDecimal value = new java.math.BigDecimal(amount);
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.money.Money.__L3703, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.money.Money.__L3701, value.scale())) < (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.money.Money.__L3702, 2))))) {
            value = value.setScale(perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.money.Money.__L3704, org.broadleafcommerce.common.money.BankersRounding.getScaleForCurrency(org.broadleafcommerce.common.money.Money.defaultCurrency())), java.math.RoundingMode.HALF_EVEN);
        }
        return value;
    }

    public static java.util.Currency defaultCurrency() {
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.money.Money.__L3711, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.money.Money.__L3709, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.money.Money.__L3705, ((org.broadleafcommerce.common.money.CurrencyConsiderationContext.getCurrencyConsiderationContext()) != null))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.money.Money.__L3708, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.money.Money.__L3706, org.broadleafcommerce.common.money.CurrencyConsiderationContext.getCurrencyConsiderationContext().size())) > (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.money.Money.__L3707, 0)))))))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.money.Money.__L3710, ((org.broadleafcommerce.common.money.CurrencyConsiderationContext.getCurrencyDeterminationService()) != null)))))) {
            return java.util.Currency.getInstance(org.broadleafcommerce.common.money.CurrencyConsiderationContext.getCurrencyDeterminationService().getCurrencyCode(org.broadleafcommerce.common.money.CurrencyConsiderationContext.getCurrencyConsiderationContext()));
        }
        org.broadleafcommerce.common.web.BroadleafRequestContext brc = org.broadleafcommerce.common.web.BroadleafRequestContext.getBroadleafRequestContext();
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.money.Money.__L3714, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.money.Money.__L3712, (brc != null))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.money.Money.__L3713, ((brc.getBroadleafCurrency()) != null)))))) {
            assert perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.money.Money.__L3715, ((brc.getBroadleafCurrency().getCurrencyCode()) != null));
            return java.util.Currency.getInstance(brc.getBroadleafCurrency().getCurrencyCode());
        }
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.money.Money.__L3716, ((java.lang.System.getProperty("currency.default")) != null))) {
            return java.util.Currency.getInstance(java.lang.System.getProperty("currency.default"));
        }
        java.util.Locale locale = java.util.Locale.getDefault();
        if (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.money.Money.__L3721, ((perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.money.Money.__L3717, ((locale.getCountry()) != null))) && (perturbation.PerturbationEngine.pboolean(org.broadleafcommerce.common.money.Money.__L3720, ((perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.money.Money.__L3718, locale.getCountry().length())) == (perturbation.PerturbationEngine.pint(org.broadleafcommerce.common.money.Money.__L3719, 2)))))))) {
            return java.util.Currency.getInstance(locale);
        }
        return java.util.Currency.getInstance("USD");
    }

    @java.lang.Override
    public void readExternal(java.io.ObjectInput in) throws java.io.IOException, java.lang.ClassNotFoundException {
        amount = new java.math.BigDecimal(in.readFloat());
    }

    @java.lang.Override
    public void writeExternal(java.io.ObjectOutput out) throws java.io.IOException {
        out.writeFloat(amount.floatValue());
    }

    public static perturbation.location.PerturbationLocation __L3563;

    public static perturbation.location.PerturbationLocation __L3564;

    public static perturbation.location.PerturbationLocation __L3565;

    public static perturbation.location.PerturbationLocation __L3566;

    public static perturbation.location.PerturbationLocation __L3567;

    public static perturbation.location.PerturbationLocation __L3568;

    public static perturbation.location.PerturbationLocation __L3569;

    public static perturbation.location.PerturbationLocation __L3570;

    public static perturbation.location.PerturbationLocation __L3571;

    public static perturbation.location.PerturbationLocation __L3572;

    public static perturbation.location.PerturbationLocation __L3573;

    public static perturbation.location.PerturbationLocation __L3574;

    public static perturbation.location.PerturbationLocation __L3575;

    public static perturbation.location.PerturbationLocation __L3576;

    public static perturbation.location.PerturbationLocation __L3577;

    public static perturbation.location.PerturbationLocation __L3578;

    public static perturbation.location.PerturbationLocation __L3579;

    public static perturbation.location.PerturbationLocation __L3580;

    public static perturbation.location.PerturbationLocation __L3581;

    public static perturbation.location.PerturbationLocation __L3582;

    public static perturbation.location.PerturbationLocation __L3583;

    public static perturbation.location.PerturbationLocation __L3584;

    public static perturbation.location.PerturbationLocation __L3585;

    public static perturbation.location.PerturbationLocation __L3586;

    public static perturbation.location.PerturbationLocation __L3587;

    public static perturbation.location.PerturbationLocation __L3588;

    public static perturbation.location.PerturbationLocation __L3589;

    public static perturbation.location.PerturbationLocation __L3590;

    public static perturbation.location.PerturbationLocation __L3591;

    public static perturbation.location.PerturbationLocation __L3592;

    public static perturbation.location.PerturbationLocation __L3593;

    public static perturbation.location.PerturbationLocation __L3594;

    public static perturbation.location.PerturbationLocation __L3595;

    public static perturbation.location.PerturbationLocation __L3596;

    public static perturbation.location.PerturbationLocation __L3597;

    public static perturbation.location.PerturbationLocation __L3598;

    public static perturbation.location.PerturbationLocation __L3599;

    public static perturbation.location.PerturbationLocation __L3600;

    public static perturbation.location.PerturbationLocation __L3601;

    public static perturbation.location.PerturbationLocation __L3602;

    public static perturbation.location.PerturbationLocation __L3603;

    public static perturbation.location.PerturbationLocation __L3604;

    public static perturbation.location.PerturbationLocation __L3605;

    public static perturbation.location.PerturbationLocation __L3606;

    public static perturbation.location.PerturbationLocation __L3607;

    public static perturbation.location.PerturbationLocation __L3608;

    public static perturbation.location.PerturbationLocation __L3609;

    public static perturbation.location.PerturbationLocation __L3610;

    public static perturbation.location.PerturbationLocation __L3611;

    public static perturbation.location.PerturbationLocation __L3612;

    public static perturbation.location.PerturbationLocation __L3613;

    public static perturbation.location.PerturbationLocation __L3614;

    public static perturbation.location.PerturbationLocation __L3615;

    public static perturbation.location.PerturbationLocation __L3616;

    public static perturbation.location.PerturbationLocation __L3617;

    public static perturbation.location.PerturbationLocation __L3618;

    public static perturbation.location.PerturbationLocation __L3619;

    public static perturbation.location.PerturbationLocation __L3620;

    public static perturbation.location.PerturbationLocation __L3621;

    public static perturbation.location.PerturbationLocation __L3622;

    public static perturbation.location.PerturbationLocation __L3623;

    public static perturbation.location.PerturbationLocation __L3624;

    public static perturbation.location.PerturbationLocation __L3625;

    public static perturbation.location.PerturbationLocation __L3626;

    public static perturbation.location.PerturbationLocation __L3627;

    public static perturbation.location.PerturbationLocation __L3628;

    public static perturbation.location.PerturbationLocation __L3629;

    public static perturbation.location.PerturbationLocation __L3630;

    public static perturbation.location.PerturbationLocation __L3631;

    public static perturbation.location.PerturbationLocation __L3632;

    public static perturbation.location.PerturbationLocation __L3633;

    public static perturbation.location.PerturbationLocation __L3634;

    public static perturbation.location.PerturbationLocation __L3635;

    public static perturbation.location.PerturbationLocation __L3636;

    public static perturbation.location.PerturbationLocation __L3637;

    public static perturbation.location.PerturbationLocation __L3638;

    public static perturbation.location.PerturbationLocation __L3639;

    public static perturbation.location.PerturbationLocation __L3640;

    public static perturbation.location.PerturbationLocation __L3641;

    public static perturbation.location.PerturbationLocation __L3642;

    public static perturbation.location.PerturbationLocation __L3643;

    public static perturbation.location.PerturbationLocation __L3644;

    public static perturbation.location.PerturbationLocation __L3645;

    public static perturbation.location.PerturbationLocation __L3646;

    public static perturbation.location.PerturbationLocation __L3647;

    public static perturbation.location.PerturbationLocation __L3648;

    public static perturbation.location.PerturbationLocation __L3649;

    public static perturbation.location.PerturbationLocation __L3650;

    public static perturbation.location.PerturbationLocation __L3651;

    public static perturbation.location.PerturbationLocation __L3652;

    public static perturbation.location.PerturbationLocation __L3653;

    public static perturbation.location.PerturbationLocation __L3654;

    public static perturbation.location.PerturbationLocation __L3655;

    public static perturbation.location.PerturbationLocation __L3656;

    public static perturbation.location.PerturbationLocation __L3657;

    public static perturbation.location.PerturbationLocation __L3658;

    public static perturbation.location.PerturbationLocation __L3659;

    public static perturbation.location.PerturbationLocation __L3660;

    public static perturbation.location.PerturbationLocation __L3661;

    public static perturbation.location.PerturbationLocation __L3662;

    public static perturbation.location.PerturbationLocation __L3663;

    public static perturbation.location.PerturbationLocation __L3664;

    public static perturbation.location.PerturbationLocation __L3665;

    public static perturbation.location.PerturbationLocation __L3666;

    public static perturbation.location.PerturbationLocation __L3667;

    public static perturbation.location.PerturbationLocation __L3668;

    public static perturbation.location.PerturbationLocation __L3669;

    public static perturbation.location.PerturbationLocation __L3670;

    public static perturbation.location.PerturbationLocation __L3671;

    public static perturbation.location.PerturbationLocation __L3672;

    public static perturbation.location.PerturbationLocation __L3673;

    public static perturbation.location.PerturbationLocation __L3674;

    public static perturbation.location.PerturbationLocation __L3675;

    public static perturbation.location.PerturbationLocation __L3676;

    public static perturbation.location.PerturbationLocation __L3677;

    public static perturbation.location.PerturbationLocation __L3678;

    public static perturbation.location.PerturbationLocation __L3679;

    public static perturbation.location.PerturbationLocation __L3680;

    public static perturbation.location.PerturbationLocation __L3681;

    public static perturbation.location.PerturbationLocation __L3682;

    public static perturbation.location.PerturbationLocation __L3683;

    public static perturbation.location.PerturbationLocation __L3684;

    public static perturbation.location.PerturbationLocation __L3685;

    public static perturbation.location.PerturbationLocation __L3686;

    public static perturbation.location.PerturbationLocation __L3687;

    public static perturbation.location.PerturbationLocation __L3688;

    public static perturbation.location.PerturbationLocation __L3689;

    public static perturbation.location.PerturbationLocation __L3690;

    public static perturbation.location.PerturbationLocation __L3691;

    public static perturbation.location.PerturbationLocation __L3692;

    public static perturbation.location.PerturbationLocation __L3693;

    public static perturbation.location.PerturbationLocation __L3694;

    public static perturbation.location.PerturbationLocation __L3695;

    public static perturbation.location.PerturbationLocation __L3696;

    public static perturbation.location.PerturbationLocation __L3697;

    public static perturbation.location.PerturbationLocation __L3698;

    public static perturbation.location.PerturbationLocation __L3699;

    public static perturbation.location.PerturbationLocation __L3700;

    public static perturbation.location.PerturbationLocation __L3701;

    public static perturbation.location.PerturbationLocation __L3702;

    public static perturbation.location.PerturbationLocation __L3703;

    public static perturbation.location.PerturbationLocation __L3704;

    public static perturbation.location.PerturbationLocation __L3705;

    public static perturbation.location.PerturbationLocation __L3706;

    public static perturbation.location.PerturbationLocation __L3707;

    public static perturbation.location.PerturbationLocation __L3708;

    public static perturbation.location.PerturbationLocation __L3709;

    public static perturbation.location.PerturbationLocation __L3710;

    public static perturbation.location.PerturbationLocation __L3711;

    public static perturbation.location.PerturbationLocation __L3712;

    public static perturbation.location.PerturbationLocation __L3713;

    public static perturbation.location.PerturbationLocation __L3714;

    public static perturbation.location.PerturbationLocation __L3715;

    public static perturbation.location.PerturbationLocation __L3716;

    public static perturbation.location.PerturbationLocation __L3717;

    public static perturbation.location.PerturbationLocation __L3718;

    public static perturbation.location.PerturbationLocation __L3719;

    public static perturbation.location.PerturbationLocation __L3720;

    public static perturbation.location.PerturbationLocation __L3721;

    private static void initPerturbationLocation0() {
        org.broadleafcommerce.common.money.Money.__L3563 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/money/Money.java:62)", 3563, "Boolean");
        org.broadleafcommerce.common.money.Money.__L3564 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/money/Money.java:172)", 3564, "Boolean");
        org.broadleafcommerce.common.money.Money.__L3565 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/money/Money.java:172)", 3565, "Boolean");
        org.broadleafcommerce.common.money.Money.__L3566 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/money/Money.java:173)", 3566, "Boolean");
        org.broadleafcommerce.common.money.Money.__L3567 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/money/Money.java:174)", 3567, "Numerical");
        org.broadleafcommerce.common.money.Money.__L3568 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/money/Money.java:174)", 3568, "Numerical");
        org.broadleafcommerce.common.money.Money.__L3569 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/money/Money.java:174)", 3569, "Boolean");
        org.broadleafcommerce.common.money.Money.__L3570 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/money/Money.java:173)", 3570, "Boolean");
        org.broadleafcommerce.common.money.Money.__L3571 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/money/Money.java:175)", 3571, "Boolean");
        org.broadleafcommerce.common.money.Money.__L3572 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/money/Money.java:173)", 3572, "Boolean");
        org.broadleafcommerce.common.money.Money.__L3573 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/money/Money.java:176)", 3573, "Numerical");
        org.broadleafcommerce.common.money.Money.__L3574 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/money/Money.java:178)", 3574, "Boolean");
        org.broadleafcommerce.common.money.Money.__L3575 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/money/Money.java:179)", 3575, "Numerical");
        org.broadleafcommerce.common.money.Money.__L3576 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/money/Money.java:179)", 3576, "Numerical");
        org.broadleafcommerce.common.money.Money.__L3577 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/money/Money.java:179)", 3577, "Boolean");
        org.broadleafcommerce.common.money.Money.__L3578 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/money/Money.java:180)", 3578, "Numerical");
        org.broadleafcommerce.common.money.Money.__L3579 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/money/Money.java:180)", 3579, "Numerical");
        org.broadleafcommerce.common.money.Money.__L3580 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/money/Money.java:179)", 3580, "Numerical");
        org.broadleafcommerce.common.money.Money.__L3581 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/money/Money.java:181)", 3581, "Boolean");
        org.broadleafcommerce.common.money.Money.__L3582 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/money/Money.java:189)", 3582, "Numerical");
        org.broadleafcommerce.common.money.Money.__L3583 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/money/Money.java:189)", 3583, "Numerical");
        org.broadleafcommerce.common.money.Money.__L3584 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/money/Money.java:189)", 3584, "Boolean");
        org.broadleafcommerce.common.money.Money.__L3585 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/money/Money.java:189)", 3585, "Numerical");
        org.broadleafcommerce.common.money.Money.__L3586 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/money/Money.java:189)", 3586, "Numerical");
        org.broadleafcommerce.common.money.Money.__L3587 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/money/Money.java:189)", 3587, "Numerical");
        org.broadleafcommerce.common.money.Money.__L3588 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/money/Money.java:193)", 3588, "Boolean");
        org.broadleafcommerce.common.money.Money.__L3589 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/money/Money.java:193)", 3589, "Boolean");
        org.broadleafcommerce.common.money.Money.__L3590 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/money/Money.java:194)", 3590, "Boolean");
        org.broadleafcommerce.common.money.Money.__L3591 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/money/Money.java:195)", 3591, "Numerical");
        org.broadleafcommerce.common.money.Money.__L3592 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/money/Money.java:195)", 3592, "Numerical");
        org.broadleafcommerce.common.money.Money.__L3593 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/money/Money.java:195)", 3593, "Boolean");
        org.broadleafcommerce.common.money.Money.__L3594 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/money/Money.java:194)", 3594, "Boolean");
        org.broadleafcommerce.common.money.Money.__L3595 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/money/Money.java:196)", 3595, "Boolean");
        org.broadleafcommerce.common.money.Money.__L3596 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/money/Money.java:194)", 3596, "Boolean");
        org.broadleafcommerce.common.money.Money.__L3597 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/money/Money.java:197)", 3597, "Numerical");
        org.broadleafcommerce.common.money.Money.__L3598 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/money/Money.java:199)", 3598, "Boolean");
        org.broadleafcommerce.common.money.Money.__L3599 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/money/Money.java:201)", 3599, "Boolean");
        org.broadleafcommerce.common.money.Money.__L3600 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/money/Money.java:202)", 3600, "Numerical");
        org.broadleafcommerce.common.money.Money.__L3601 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/money/Money.java:202)", 3601, "Numerical");
        org.broadleafcommerce.common.money.Money.__L3602 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/money/Money.java:202)", 3602, "Boolean");
        org.broadleafcommerce.common.money.Money.__L3603 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/money/Money.java:203)", 3603, "Numerical");
        org.broadleafcommerce.common.money.Money.__L3604 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/money/Money.java:203)", 3604, "Numerical");
        org.broadleafcommerce.common.money.Money.__L3605 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/money/Money.java:202)", 3605, "Numerical");
        org.broadleafcommerce.common.money.Money.__L3606 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/money/Money.java:210)", 3606, "Numerical");
        org.broadleafcommerce.common.money.Money.__L3607 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/money/Money.java:210)", 3607, "Numerical");
        org.broadleafcommerce.common.money.Money.__L3608 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/money/Money.java:210)", 3608, "Boolean");
        org.broadleafcommerce.common.money.Money.__L3609 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/money/Money.java:210)", 3609, "Numerical");
        org.broadleafcommerce.common.money.Money.__L3610 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/money/Money.java:210)", 3610, "Numerical");
        org.broadleafcommerce.common.money.Money.__L3611 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/money/Money.java:210)", 3611, "Numerical");
        org.broadleafcommerce.common.money.Money.__L3612 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/money/Money.java:218)", 3612, "Numerical");
        org.broadleafcommerce.common.money.Money.__L3613 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/money/Money.java:219)", 3613, "Numerical");
        org.broadleafcommerce.common.money.Money.__L3614 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/money/Money.java:224)", 3614, "Numerical");
        org.broadleafcommerce.common.money.Money.__L3615 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/money/Money.java:224)", 3615, "Numerical");
        org.broadleafcommerce.common.money.Money.__L3616 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/money/Money.java:224)", 3616, "Boolean");
        org.broadleafcommerce.common.money.Money.__L3617 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/money/Money.java:224)", 3617, "Numerical");
        org.broadleafcommerce.common.money.Money.__L3618 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/money/Money.java:224)", 3618, "Numerical");
        org.broadleafcommerce.common.money.Money.__L3619 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/money/Money.java:224)", 3619, "Numerical");
        org.broadleafcommerce.common.money.Money.__L3620 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/money/Money.java:236)", 3620, "Numerical");
        org.broadleafcommerce.common.money.Money.__L3621 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/money/Money.java:240)", 3621, "Numerical");
        org.broadleafcommerce.common.money.Money.__L3622 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/money/Money.java:241)", 3622, "Numerical");
        org.broadleafcommerce.common.money.Money.__L3623 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/money/Money.java:250)", 3623, "Numerical");
        org.broadleafcommerce.common.money.Money.__L3624 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/money/Money.java:250)", 3624, "Numerical");
        org.broadleafcommerce.common.money.Money.__L3625 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/money/Money.java:250)", 3625, "Numerical");
        org.broadleafcommerce.common.money.Money.__L3626 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/money/Money.java:250)", 3626, "Boolean");
        org.broadleafcommerce.common.money.Money.__L3627 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/money/Money.java:250)", 3627, "Numerical");
        org.broadleafcommerce.common.money.Money.__L3628 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/money/Money.java:250)", 3628, "Numerical");
        org.broadleafcommerce.common.money.Money.__L3629 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/money/Money.java:250)", 3629, "Numerical");
        org.broadleafcommerce.common.money.Money.__L3630 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/money/Money.java:258)", 3630, "Boolean");
        org.broadleafcommerce.common.money.Money.__L3631 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/money/Money.java:261)", 3631, "Boolean");
        org.broadleafcommerce.common.money.Money.__L3632 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/money/Money.java:265)", 3632, "Boolean");
        org.broadleafcommerce.common.money.Money.__L3633 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/money/Money.java:268)", 3633, "Boolean");
        org.broadleafcommerce.common.money.Money.__L3634 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/money/Money.java:276)", 3634, "Numerical");
        org.broadleafcommerce.common.money.Money.__L3635 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/money/Money.java:276)", 3635, "Numerical");
        org.broadleafcommerce.common.money.Money.__L3636 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/money/Money.java:276)", 3636, "Boolean");
        org.broadleafcommerce.common.money.Money.__L3637 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/money/Money.java:284)", 3637, "Numerical");
        org.broadleafcommerce.common.money.Money.__L3638 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/money/Money.java:284)", 3638, "Numerical");
        org.broadleafcommerce.common.money.Money.__L3639 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/money/Money.java:284)", 3639, "Boolean");
        org.broadleafcommerce.common.money.Money.__L3640 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/money/Money.java:288)", 3640, "Numerical");
        org.broadleafcommerce.common.money.Money.__L3641 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/money/Money.java:288)", 3641, "Numerical");
        org.broadleafcommerce.common.money.Money.__L3642 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/money/Money.java:288)", 3642, "Boolean");
        org.broadleafcommerce.common.money.Money.__L3643 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/money/Money.java:292)", 3643, "Numerical");
        org.broadleafcommerce.common.money.Money.__L3644 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/money/Money.java:292)", 3644, "Numerical");
        org.broadleafcommerce.common.money.Money.__L3645 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/money/Money.java:292)", 3645, "Boolean");
        org.broadleafcommerce.common.money.Money.__L3646 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/money/Money.java:296)", 3646, "Numerical");
        org.broadleafcommerce.common.money.Money.__L3647 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/money/Money.java:296)", 3647, "Numerical");
        org.broadleafcommerce.common.money.Money.__L3648 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/money/Money.java:296)", 3648, "Boolean");
        org.broadleafcommerce.common.money.Money.__L3649 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/money/Money.java:300)", 3649, "Numerical");
        org.broadleafcommerce.common.money.Money.__L3650 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/money/Money.java:300)", 3650, "Numerical");
        org.broadleafcommerce.common.money.Money.__L3651 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/money/Money.java:300)", 3651, "Boolean");
        org.broadleafcommerce.common.money.Money.__L3652 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/money/Money.java:304)", 3652, "Numerical");
        org.broadleafcommerce.common.money.Money.__L3653 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/money/Money.java:304)", 3653, "Numerical");
        org.broadleafcommerce.common.money.Money.__L3654 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/money/Money.java:304)", 3654, "Boolean");
        org.broadleafcommerce.common.money.Money.__L3655 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/money/Money.java:308)", 3655, "Numerical");
        org.broadleafcommerce.common.money.Money.__L3656 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/money/Money.java:308)", 3656, "Numerical");
        org.broadleafcommerce.common.money.Money.__L3657 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/money/Money.java:308)", 3657, "Boolean");
        org.broadleafcommerce.common.money.Money.__L3658 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/money/Money.java:312)", 3658, "Numerical");
        org.broadleafcommerce.common.money.Money.__L3659 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/money/Money.java:312)", 3659, "Numerical");
        org.broadleafcommerce.common.money.Money.__L3660 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/money/Money.java:312)", 3660, "Boolean");
        org.broadleafcommerce.common.money.Money.__L3661 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/money/Money.java:317)", 3661, "Numerical");
        org.broadleafcommerce.common.money.Money.__L3662 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/money/Money.java:321)", 3662, "Numerical");
        org.broadleafcommerce.common.money.Money.__L3663 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/money/Money.java:326)", 3663, "Boolean");
        org.broadleafcommerce.common.money.Money.__L3664 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/money/Money.java:327)", 3664, "Boolean");
        org.broadleafcommerce.common.money.Money.__L3665 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/money/Money.java:329)", 3665, "Boolean");
        org.broadleafcommerce.common.money.Money.__L3666 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/money/Money.java:329)", 3666, "Boolean");
        org.broadleafcommerce.common.money.Money.__L3667 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/money/Money.java:330)", 3667, "Boolean");
        org.broadleafcommerce.common.money.Money.__L3668 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/money/Money.java:330)", 3668, "Boolean");
        org.broadleafcommerce.common.money.Money.__L3669 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/money/Money.java:331)", 3669, "Boolean");
        org.broadleafcommerce.common.money.Money.__L3670 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/money/Money.java:336)", 3670, "Boolean");
        org.broadleafcommerce.common.money.Money.__L3671 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/money/Money.java:336)", 3671, "Boolean");
        org.broadleafcommerce.common.money.Money.__L3672 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/money/Money.java:336)", 3672, "Boolean");
        org.broadleafcommerce.common.money.Money.__L3673 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/money/Money.java:336)", 3673, "Boolean");
        org.broadleafcommerce.common.money.Money.__L3674 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/money/Money.java:336)", 3674, "Boolean");
        org.broadleafcommerce.common.money.Money.__L3675 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/money/Money.java:337)", 3675, "Boolean");
        org.broadleafcommerce.common.money.Money.__L3676 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/money/Money.java:340)", 3676, "Boolean");
        org.broadleafcommerce.common.money.Money.__L3677 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/money/Money.java:341)", 3677, "Boolean");
        org.broadleafcommerce.common.money.Money.__L3678 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/money/Money.java:344)", 3678, "Boolean");
        org.broadleafcommerce.common.money.Money.__L3679 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/money/Money.java:344)", 3679, "Boolean");
        org.broadleafcommerce.common.money.Money.__L3680 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/money/Money.java:344)", 3680, "Boolean");
        org.broadleafcommerce.common.money.Money.__L3681 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/money/Money.java:344)", 3681, "Boolean");
        org.broadleafcommerce.common.money.Money.__L3682 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/money/Money.java:344)", 3682, "Boolean");
        org.broadleafcommerce.common.money.Money.__L3683 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/money/Money.java:345)", 3683, "Boolean");
        org.broadleafcommerce.common.money.Money.__L3684 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/money/Money.java:348)", 3684, "Boolean");
        org.broadleafcommerce.common.money.Money.__L3685 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/money/Money.java:353)", 3685, "Boolean");
        org.broadleafcommerce.common.money.Money.__L3686 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/money/Money.java:353)", 3686, "Numerical");
        org.broadleafcommerce.common.money.Money.__L3687 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/money/Money.java:353)", 3687, "Numerical");
        org.broadleafcommerce.common.money.Money.__L3688 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/money/Money.java:353)", 3688, "Numerical");
        org.broadleafcommerce.common.money.Money.__L3689 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/money/Money.java:354)", 3689, "Numerical");
        org.broadleafcommerce.common.money.Money.__L3690 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/money/Money.java:354)", 3690, "Numerical");
        org.broadleafcommerce.common.money.Money.__L3691 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/money/Money.java:354)", 3691, "Numerical");
        org.broadleafcommerce.common.money.Money.__L3692 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/money/Money.java:354)", 3692, "Boolean");
        org.broadleafcommerce.common.money.Money.__L3693 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/money/Money.java:354)", 3693, "Numerical");
        org.broadleafcommerce.common.money.Money.__L3694 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/money/Money.java:354)", 3694, "Numerical");
        org.broadleafcommerce.common.money.Money.__L3695 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/money/Money.java:354)", 3695, "Numerical");
        org.broadleafcommerce.common.money.Money.__L3696 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/money/Money.java:354)", 3696, "Numerical");
        org.broadleafcommerce.common.money.Money.__L3697 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/money/Money.java:355)", 3697, "Numerical");
        org.broadleafcommerce.common.money.Money.__L3698 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/money/Money.java:373)", 3698, "Boolean");
        org.broadleafcommerce.common.money.Money.__L3699 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/money/Money.java:406)", 3699, "Boolean");
        org.broadleafcommerce.common.money.Money.__L3700 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/money/Money.java:410)", 3700, "Boolean");
        org.broadleafcommerce.common.money.Money.__L3701 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/money/Money.java:424)", 3701, "Numerical");
        org.broadleafcommerce.common.money.Money.__L3702 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/money/Money.java:424)", 3702, "Numerical");
        org.broadleafcommerce.common.money.Money.__L3703 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/money/Money.java:424)", 3703, "Boolean");
        org.broadleafcommerce.common.money.Money.__L3704 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/money/Money.java:425)", 3704, "Numerical");
        org.broadleafcommerce.common.money.Money.__L3705 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/money/Money.java:437)", 3705, "Boolean");
        org.broadleafcommerce.common.money.Money.__L3706 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/money/Money.java:438)", 3706, "Numerical");
        org.broadleafcommerce.common.money.Money.__L3707 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/money/Money.java:438)", 3707, "Numerical");
        org.broadleafcommerce.common.money.Money.__L3708 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/money/Money.java:438)", 3708, "Boolean");
        org.broadleafcommerce.common.money.Money.__L3709 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/money/Money.java:437)", 3709, "Boolean");
        org.broadleafcommerce.common.money.Money.__L3710 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/money/Money.java:439)", 3710, "Boolean");
        org.broadleafcommerce.common.money.Money.__L3711 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/money/Money.java:437)", 3711, "Boolean");
        org.broadleafcommerce.common.money.Money.__L3712 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/money/Money.java:446)", 3712, "Boolean");
        org.broadleafcommerce.common.money.Money.__L3713 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/money/Money.java:446)", 3713, "Boolean");
        org.broadleafcommerce.common.money.Money.__L3714 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/money/Money.java:446)", 3714, "Boolean");
        org.broadleafcommerce.common.money.Money.__L3715 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/money/Money.java:447)", 3715, "Boolean");
        org.broadleafcommerce.common.money.Money.__L3716 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/money/Money.java:451)", 3716, "Boolean");
        org.broadleafcommerce.common.money.Money.__L3717 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/money/Money.java:455)", 3717, "Boolean");
        org.broadleafcommerce.common.money.Money.__L3718 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/money/Money.java:455)", 3718, "Numerical");
        org.broadleafcommerce.common.money.Money.__L3719 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/money/Money.java:455)", 3719, "Numerical");
        org.broadleafcommerce.common.money.Money.__L3720 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/money/Money.java:455)", 3720, "Boolean");
        org.broadleafcommerce.common.money.Money.__L3721 = new perturbation.location.PerturbationLocationImpl("(/home/bdanglot/blc/BroadleafCommerce/common/src/main/java/org/broadleafcommerce/common/money/Money.java:455)", 3721, "Boolean");
    }

    static {
        org.broadleafcommerce.common.money.Money.initPerturbationLocation0();
    }
}

