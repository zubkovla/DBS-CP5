package jpa.modelEntities;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

@Embeddable
public class PriceId implements Serializable {
    private static final long serialVersionUID = 3615744138230538590L;
    @Column(name = "serviceid", nullable = false)
    private Integer serviceid;

    @Column(name = "seasonfromdate", nullable = false)
    private LocalDate seasonfromdate;

    @Column(name = "seasontodate", nullable = false)
    private LocalDate seasontodate;

    @Column(name = "amountadult", nullable = false, precision = 10, scale = 2)
    private BigDecimal amountadult;

    @Column(name = "amountchild", nullable = false, precision = 10, scale = 2)
    private BigDecimal amountchild;

    @Column(name = "currency", nullable = false, length = 3)
    private String currency;

    public Integer getServiceid() {
        return serviceid;
    }

    public void setServiceid(Integer serviceid) {
        this.serviceid = serviceid;
    }

    public LocalDate getSeasonfromdate() {
        return seasonfromdate;
    }

    public void setSeasonfromdate(LocalDate seasonfromdate) {
        this.seasonfromdate = seasonfromdate;
    }

    public LocalDate getSeasontodate() {
        return seasontodate;
    }

    public void setSeasontodate(LocalDate seasontodate) {
        this.seasontodate = seasontodate;
    }

    public BigDecimal getAmountadult() {
        return amountadult;
    }

    public void setAmountadult(BigDecimal amountadult) {
        this.amountadult = amountadult;
    }

    public BigDecimal getAmountchild() {
        return amountchild;
    }

    public void setAmountchild(BigDecimal amountchild) {
        this.amountchild = amountchild;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PriceId entity = (PriceId) o;
        return Objects.equals(this.amountchild, entity.amountchild) &&
                Objects.equals(this.seasontodate, entity.seasontodate) &&
                Objects.equals(this.amountadult, entity.amountadult) &&
                Objects.equals(this.currency, entity.currency) &&
                Objects.equals(this.serviceid, entity.serviceid) &&
                Objects.equals(this.seasonfromdate, entity.seasonfromdate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amountchild, seasontodate, amountadult, currency, serviceid, seasonfromdate);
    }

}