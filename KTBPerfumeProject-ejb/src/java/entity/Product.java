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
@Table(name = "PRODUCT", catalog = "KTBPerfume", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Product.findAll", query = "SELECT p FROM Product p"),
    @NamedQuery(name = "Product.findByProductId", query = "SELECT p FROM Product p WHERE p.productId = :productId"),
    @NamedQuery(name = "Product.findByProductName", query = "SELECT p FROM Product p WHERE p.productName = :productName"),
    @NamedQuery(name = "Product.findByDescription", query = "SELECT p FROM Product p WHERE p.description = :description"),
    @NamedQuery(name = "Product.findByForGender", query = "SELECT p FROM Product p WHERE p.forGender = :forGender"),
    @NamedQuery(name = "Product.findByPrice", query = "SELECT p FROM Product p WHERE p.price = :price"),
    @NamedQuery(name = "Product.findByImage", query = "SELECT p FROM Product p WHERE p.image = :image"),
    @NamedQuery(name = "Product.findBySizeOfBottle", query = "SELECT p FROM Product p WHERE p.sizeOfBottle = :sizeOfBottle"),
    @NamedQuery(name = "Product.findByVolumeOfPerfumeOil", query = "SELECT p FROM Product p WHERE p.volumeOfPerfumeOil = :volumeOfPerfumeOil"),
    @NamedQuery(name = "Product.findByCountry", query = "SELECT p FROM Product p WHERE p.country = :country"),
    @NamedQuery(name = "Product.findByYearIssue", query = "SELECT p FROM Product p WHERE p.yearIssue = :yearIssue"),
    @NamedQuery(name = "Product.findByAverageRating", query = "SELECT p FROM Product p WHERE p.averageRating = :averageRating"),
    @NamedQuery(name = "Product.findByDateAddProduct", query = "SELECT p FROM Product p WHERE p.dateAddProduct = :dateAddProduct")})
public class Product implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "ProductId", nullable = false, length = 30)
    private String productId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "ProductName", nullable = false, length = 30)
    private String productName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2000)
    @Column(name = "Description", nullable = false, length = 2000)
    private String description;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "ForGender", nullable = false, length = 10)
    private String forGender;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Price", nullable = false)
    private int price;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "Image", nullable = false, length = 100)
    private String image;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "SizeOfBottle", nullable = false, length = 30)
    private String sizeOfBottle;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "VolumeOfPerfumeOil", nullable = false, length = 30)
    private String volumeOfPerfumeOil;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "Country", nullable = false, length = 30)
    private String country;
    @Basic(optional = false)
    @NotNull
    @Column(name = "YearIssue", nullable = false)
    private int yearIssue;
    @Basic(optional = false)
    @NotNull
    @Column(name = "AverageRating", nullable = false)
    private double averageRating;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DateAddProduct", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateAddProduct;
    @JoinColumn(name = "BrandId", referencedColumnName = "BrandId", nullable = false)
    @ManyToOne(optional = false)
    private Brand brandId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productId")
    private Collection<Orderdetail> orderdetailCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productId")
    private Collection<Wishlist> wishlistCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productId")
    private Collection<Comment> commentCollection;

    public Product() {
    }

    public Product(String productId) {
        this.productId = productId;
    }

    public Product(String productId, String productName, String description, String forGender, int price, String image, String sizeOfBottle, String volumeOfPerfumeOil, String country, int yearIssue, double averageRating, Date dateAddProduct) {
        this.productId = productId;
        this.productName = productName;
        this.description = description;
        this.forGender = forGender;
        this.price = price;
        this.image = image;
        this.sizeOfBottle = sizeOfBottle;
        this.volumeOfPerfumeOil = volumeOfPerfumeOil;
        this.country = country;
        this.yearIssue = yearIssue;
        this.averageRating = averageRating;
        this.dateAddProduct = dateAddProduct;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getForGender() {
        return forGender;
    }

    public void setForGender(String forGender) {
        this.forGender = forGender;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getSizeOfBottle() {
        return sizeOfBottle;
    }

    public void setSizeOfBottle(String sizeOfBottle) {
        this.sizeOfBottle = sizeOfBottle;
    }

    public String getVolumeOfPerfumeOil() {
        return volumeOfPerfumeOil;
    }

    public void setVolumeOfPerfumeOil(String volumeOfPerfumeOil) {
        this.volumeOfPerfumeOil = volumeOfPerfumeOil;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getYearIssue() {
        return yearIssue;
    }

    public void setYearIssue(int yearIssue) {
        this.yearIssue = yearIssue;
    }

    public double getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(double averageRating) {
        this.averageRating = averageRating;
    }

    public Date getDateAddProduct() {
        return dateAddProduct;
    }

    public void setDateAddProduct(Date dateAddProduct) {
        this.dateAddProduct = dateAddProduct;
    }

    public Brand getBrandId() {
        return brandId;
    }

    public void setBrandId(Brand brandId) {
        this.brandId = brandId;
    }

    @XmlTransient
    public Collection<Orderdetail> getOrderdetailCollection() {
        return orderdetailCollection;
    }

    public void setOrderdetailCollection(Collection<Orderdetail> orderdetailCollection) {
        this.orderdetailCollection = orderdetailCollection;
    }

    @XmlTransient
    public Collection<Wishlist> getWishlistCollection() {
        return wishlistCollection;
    }

    public void setWishlistCollection(Collection<Wishlist> wishlistCollection) {
        this.wishlistCollection = wishlistCollection;
    }

    @XmlTransient
    public Collection<Comment> getCommentCollection() {
        return commentCollection;
    }

    public void setCommentCollection(Collection<Comment> commentCollection) {
        this.commentCollection = commentCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (productId != null ? productId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Product)) {
            return false;
        }
        Product other = (Product) object;
        if ((this.productId == null && other.productId != null) || (this.productId != null && !this.productId.equals(other.productId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Product[ productId=" + productId + " ]";
    }
    
}
