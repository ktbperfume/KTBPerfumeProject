/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author MyPC
 */
@Entity
@Table(name = "ORDERINFO", catalog = "KTBPerfume", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Orderinfo.findAll", query = "SELECT o FROM Orderinfo o"),
    @NamedQuery(name = "Orderinfo.findByOrderCode", query = "SELECT o FROM Orderinfo o WHERE o.orderCode = :orderCode"),
    @NamedQuery(name = "Orderinfo.findByDate", query = "SELECT o FROM Orderinfo o WHERE o.date = :date"),
    @NamedQuery(name = "Orderinfo.findByTotal", query = "SELECT o FROM Orderinfo o WHERE o.total = :total"),
    @NamedQuery(name = "Orderinfo.findByPaymentMethod", query = "SELECT o FROM Orderinfo o WHERE o.paymentMethod = :paymentMethod"),
    @NamedQuery(name = "Orderinfo.findByDeliveryTo", query = "SELECT o FROM Orderinfo o WHERE o.deliveryTo = :deliveryTo"),
    @NamedQuery(name = "Orderinfo.findByMobile", query = "SELECT o FROM Orderinfo o WHERE o.mobile = :mobile"),
    @NamedQuery(name = "Orderinfo.findByStatus", query = "SELECT o FROM Orderinfo o WHERE o.status = :status")})
public class Orderinfo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "OrderCode", nullable = false, length = 30)
    private String orderCode;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Total", nullable = false)
    private double total;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "PaymentMethod", nullable = false, length = 50)
    private String paymentMethod;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "DeliveryTo", nullable = false, length = 50)
    private String deliveryTo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "Mobile", nullable = false, length = 20)
    private String mobile;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Status", nullable = false)
    private boolean status;
    @JoinColumn(name = "CustomerId", referencedColumnName = "CustomerId", nullable = false)
    @ManyToOne(optional = false)
    private Customer customerId;
    @JoinColumn(name = "EventCode", referencedColumnName = "EventCode")
    @ManyToOne
    private Event eventCode;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "orderCode")
    private Collection<Orderdetail> orderdetailCollection;

    public Orderinfo() {
    }

    public Orderinfo(String orderCode) {
        this.orderCode = orderCode;
    }

    public Orderinfo(String orderCode, Date date, double total, String paymentMethod, String deliveryTo, String mobile, boolean status) {
        this.orderCode = orderCode;
        this.date = date;
        this.total = total;
        this.paymentMethod = paymentMethod;
        this.deliveryTo = deliveryTo;
        this.mobile = mobile;
        this.status = status;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getDeliveryTo() {
        return deliveryTo;
    }

    public void setDeliveryTo(String deliveryTo) {
        this.deliveryTo = deliveryTo;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Customer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Customer customerId) {
        this.customerId = customerId;
    }

    public Event getEventCode() {
        return eventCode;
    }

    public void setEventCode(Event eventCode) {
        this.eventCode = eventCode;
    }

    @XmlTransient
    public Collection<Orderdetail> getOrderdetailCollection() {
        return orderdetailCollection;
    }

    public void setOrderdetailCollection(Collection<Orderdetail> orderdetailCollection) {
        this.orderdetailCollection = orderdetailCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (orderCode != null ? orderCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Orderinfo)) {
            return false;
        }
        Orderinfo other = (Orderinfo) object;
        if ((this.orderCode == null && other.orderCode != null) || (this.orderCode != null && !this.orderCode.equals(other.orderCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Orderinfo[ orderCode=" + orderCode + " ]";
    }
    
}
