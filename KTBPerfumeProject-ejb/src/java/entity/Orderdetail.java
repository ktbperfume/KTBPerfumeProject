package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author MyPC
 */
@Entity
@Table(name = "ORDERDETAIL", catalog = "KTBPerfume", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Orderdetail.findAll", query = "SELECT o FROM Orderdetail o"),
    @NamedQuery(name = "Orderdetail.findByOrderDetailCode", query = "SELECT o FROM Orderdetail o WHERE o.orderDetailCode = :orderDetailCode"),
    @NamedQuery(name = "Orderdetail.findByQuantity", query = "SELECT o FROM Orderdetail o WHERE o.quantity = :quantity")})
public class Orderdetail implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "OrderDetailCode", nullable = false, length = 30)
    private String orderDetailCode;
    @Column(name = "Quantity")
    private Integer quantity;
    @JoinColumn(name = "OrderCode", referencedColumnName = "OrderCode", nullable = false)
    @ManyToOne(optional = false)
    private Orderinfo orderCode;
    @JoinColumn(name = "ProductId", referencedColumnName = "ProductId", nullable = false)
    @ManyToOne(optional = false)
    private Product productId;

    public Orderdetail() {
    }

    public Orderdetail(String orderDetailCode, Integer quantity, Orderinfo orderCode, Product productId) {
        this.orderDetailCode = orderDetailCode;
        this.quantity = quantity;
        this.orderCode = orderCode;
        this.productId = productId;
    }   
    

    public Orderdetail(String orderDetailCode) {
        this.orderDetailCode = orderDetailCode;
    }

    public String getOrderDetailCode() {
        return orderDetailCode;
    }

    public void setOrderDetailCode(String orderDetailCode) {
        this.orderDetailCode = orderDetailCode;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Orderinfo getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(Orderinfo orderCode) {
        this.orderCode = orderCode;
    }

    public Product getProductId() {
        return productId;
    }

    public void setProductId(Product productId) {
        this.productId = productId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (orderDetailCode != null ? orderDetailCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Orderdetail)) {
            return false;
        }
        Orderdetail other = (Orderdetail) object;
        if ((this.orderDetailCode == null && other.orderDetailCode != null) || (this.orderDetailCode != null && !this.orderDetailCode.equals(other.orderDetailCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Orderdetail[ orderDetailCode=" + orderDetailCode + " ]";
    }
    
}
