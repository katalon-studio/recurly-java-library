/*
 * Copyright 2010-2014 Ning, Inc.
 * Copyright 2014-2015 The Billing Project, LLC
 *
 * The Billing Project licenses this file to you under the Apache License, version 2.0
 * (the "License"); you may not use this file except in compliance with the
 * License.  You may obtain a copy of the License at:
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */

package com.ning.billing.recurly.model;

import com.google.common.base.Objects;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement(name = "account_balance")
public class AccountBalance extends RecurlyObject {

    @XmlTransient
    public static final String ACCOUNT_BALANCE_RESOURCE = "/balance";

    @XmlElement(name = "past_due")
    private Boolean pastDue;

    @XmlElement(name = "balance_in_cents")
    private RecurlyUnitCurrency balanceInCents;

    public Boolean getPastDue() {
        return pastDue;
    }

    public void setPastDue(final Object pastDue) { this.pastDue = booleanOrNull(pastDue); }

    public RecurlyUnitCurrency getBalanceInCents() {
        return balanceInCents;
    }

    public void setBalanceInCents(final RecurlyUnitCurrency balanceInCents) { this.balanceInCents = balanceInCents; }

    @Override
    public String toString() {
        String sb = "AccountBalance{" + ", pastDue=" + pastDue +
                ", balanceInCents=" + balanceInCents +
                '}';
        return sb;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        final AccountBalance accountBalance = (AccountBalance) o;

        if (pastDue != null ? !pastDue.equals(accountBalance.pastDue) : accountBalance.pastDue != null) {
            return false;
        }
        if (balanceInCents != null ? !balanceInCents.equals(accountBalance.balanceInCents) : accountBalance.balanceInCents != null) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(
                pastDue,
                balanceInCents
        );
    }


}
