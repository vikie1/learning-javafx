package org.openjfx.util;

public class Item {
    private String sku;
    private String descr;
    private float price;
    private boolean taxable;

    /**
     * @param sku
     * @param descr
     * @param price
     * @param taxable
     */
    public Item(String sku, String descr, float price, boolean taxable) {
        this.setSku(sku);
        this.setDescr(descr);
        this.setPrice(price);
        this.setTaxable(taxable);
    }

    /**
     * @return the sku
     */
    public String getSku() {
        return sku;
    }

    /**
     * @param sku the sku to set
     */
    public void setSku(String sku) {
        this.sku = sku;
    }

    /**
     * @return the descr
     */
    public String getDescr() {
        return descr;
    }

    /**
     * @param descr the descr to set
     */
    public void setDescr(String descr) {
        this.descr = descr;
    }

    /**
     * @return the taxable
     */
    public boolean isTaxable() {
        return taxable;
    }

    /**
     * @param taxable the taxable to set
     */
    public void setTaxable(boolean taxable) {
        this.taxable = taxable;
    }

    /**
     * @return the price
     */
    public float getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(float price) {
        this.price = price;
    }
}
