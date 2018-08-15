/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author MyPC
 */
@Entity
@Table(name = "EVENT", catalog = "KTBPerfume", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Event.findAll", query = "SELECT e FROM Event e"),
    @NamedQuery(name = "Event.findByEventCode", query = "SELECT e FROM Event e WHERE e.eventCode = :eventCode"),
    @NamedQuery(name = "Event.findByName", query = "SELECT e FROM Event e WHERE e.name = :name"),
    @NamedQuery(name = "Event.findByDescription", query = "SELECT e FROM Event e WHERE e.description = :description"),
    @NamedQuery(name = "Event.findByDiscountpercent", query = "SELECT e FROM Event e WHERE e.discountpercent = :discountpercent"),
    @NamedQuery(name = "Event.findByActive", query = "SELECT e FROM Event e WHERE e.active = :active")})
public class Event implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "EventCode", nullable = false, length = 30)
    private String eventCode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "Name", nullable = false, length = 30)
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "Description", nullable = false, length = 300)
    private String description;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Discount percent", nullable = false)
    private double discountpercent;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Active", nullable = false)
    private boolean active;
    @OneToMany(mappedBy = "eventCode")
    private Collection<Orderinfo> orderinfoCollection;

    public Event() {
    }

    public Event(String eventCode) {
        this.eventCode = eventCode;
    }

    public Event(String eventCode, String name, String description, double discountpercent, boolean active) {
        this.eventCode = eventCode;
        this.name = name;
        this.description = description;
        this.discountpercent = discountpercent;
        this.active = active;
    }

    public String getEventCode() {
        return eventCode;
    }

    public void setEventCode(String eventCode) {
        this.eventCode = eventCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getDiscountpercent() {
        return discountpercent;
    }

    public void setDiscountpercent(double discountpercent) {
        this.discountpercent = discountpercent;
    }

    public boolean getActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @XmlTransient
    public Collection<Orderinfo> getOrderinfoCollection() {
        return orderinfoCollection;
    }

    public void setOrderinfoCollection(Collection<Orderinfo> orderinfoCollection) {
        this.orderinfoCollection = orderinfoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (eventCode != null ? eventCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Event)) {
            return false;
        }
        Event other = (Event) object;
        if ((this.eventCode == null && other.eventCode != null) || (this.eventCode != null && !this.eventCode.equals(other.eventCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Event[ eventCode=" + eventCode + " ]";
    }
    
}
