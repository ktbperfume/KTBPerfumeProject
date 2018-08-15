

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
@Table(name = "USER_ADMIN", catalog = "KTBPerfume", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserAdmin.findAll", query = "SELECT u FROM UserAdmin u"),
    @NamedQuery(name = "UserAdmin.findByUsername", query = "SELECT u FROM UserAdmin u WHERE u.username = :username"),
    @NamedQuery(name = "UserAdmin.findByPassword", query = "SELECT u FROM UserAdmin u WHERE u.password = :password"),
    @NamedQuery(name = "UserAdmin.findByFullName", query = "SELECT u FROM UserAdmin u WHERE u.fullName = :fullName"),
    @NamedQuery(name = "UserAdmin.findByEmail", query = "SELECT u FROM UserAdmin u WHERE u.email = :email"),
    @NamedQuery(name = "UserAdmin.findByAvatar", query = "SELECT u FROM UserAdmin u WHERE u.avatar = :avatar"),
    @NamedQuery(name = "UserAdmin.findByRole", query = "SELECT u FROM UserAdmin u WHERE u.role = :role"),
    @NamedQuery(name = "UserAdmin.findByStatus", query = "SELECT u FROM UserAdmin u WHERE u.status = :status")})
public class UserAdmin implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "Username", nullable = false, length = 30)
    private String username;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "Password", nullable = false, length = 30)
    private String password;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "FullName", nullable = false, length = 50)
    private String fullName;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Email", nullable = false, length = 50)
    private String email;
    @Size(max = 100)
    @Column(name = "Avatar", length = 100)
    private String avatar;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "Role", nullable = false, length = 10)
    private String role;
    @Column(name = "Status")
    private Boolean status;
    @OneToMany(mappedBy = "username")
    private Collection<Comment> commentCollection;
    @OneToMany(mappedBy = "username")
    private Collection<Feedback> feedbackCollection;
    public UserAdmin() {
    }

    public UserAdmin(String username) {
        this.username = username;
    }

    public UserAdmin(String username, String password, String fullName, String email, String role) {
        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.email = email;
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    @XmlTransient
    public Collection<Comment> getCommentCollection() {
        return commentCollection;
    }

    public void setCommentCollection(Collection<Comment> commentCollection) {
        this.commentCollection = commentCollection;
    }

    @XmlTransient
    public Collection<Feedback> getFeedbackCollection() {
        return feedbackCollection;
    }

    public void setFeedbackCollection(Collection<Feedback> feedbackCollection) {
        this.feedbackCollection = feedbackCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (username != null ? username.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserAdmin)) {
            return false;
        }
        UserAdmin other = (UserAdmin) object;
        if ((this.username == null && other.username != null) || (this.username != null && !this.username.equals(other.username))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.UserAdmin[ username=" + username + " ]";
    }
}