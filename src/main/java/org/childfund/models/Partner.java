package org.childfund.models;

public class Partner {
    public enum LocalPartner{
        MBALE("mbale"),
        SOROTI("soroti"),
        BUSIA("busia"),
        LANGO("lango"),
        ACHOLI("acholi"),
        MASINDI("masindi"),
        KAMPALA("kampala"),
        JINJA("jinja"),
        KIBOGA("kiboga");

        public final String partnerName;

        LocalPartner(String partner){
            this.partnerName = partner;
        }

        public String getValue() {
            return partnerName;
        }

    }

}
