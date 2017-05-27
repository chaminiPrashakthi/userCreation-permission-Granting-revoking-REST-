/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Chamini
 */
@Entity
@Table(name = "fnd_permission_tab")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FndPermissionTab.findAll", query = "SELECT f FROM FndPermissionTab f"),
    @NamedQuery(name = "FndPermissionTab.findByCompany", query = "SELECT f FROM FndPermissionTab f WHERE f.company = :company"),
    @NamedQuery(name = "FndPermissionTab.findByWindow", query = "SELECT f FROM FndPermissionTab f WHERE f.fndPermissionTabPK.window = :window"),
    @NamedQuery(name = "FndPermissionTab.findByUser", query = "SELECT f FROM FndPermissionTab f WHERE f.fndPermissionTabPK.user = :user"),
    @NamedQuery(name = "FndPermissionTab.findByPermission", query = "SELECT f FROM FndPermissionTab f WHERE f.fndPermissionTabPK.permission = :permission"),
    @NamedQuery(name = "FndPermissionTab.findByGranted", query = "SELECT f FROM FndPermissionTab f WHERE f.granted = :granted")})
public class FndPermissionTab implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected FndPermissionTabPK fndPermissionTabPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "Company")
    private String company;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "Granted")
    private String granted;

    public FndPermissionTab() {
    }

    public FndPermissionTab(FndPermissionTabPK fndPermissionTabPK) {
        this.fndPermissionTabPK = fndPermissionTabPK;
    }

    public FndPermissionTab(FndPermissionTabPK fndPermissionTabPK, String company, String granted) {
        this.fndPermissionTabPK = fndPermissionTabPK;
        this.company = company;
        this.granted = granted;
    }

    public FndPermissionTab(String window, String user, String permission) {
        this.fndPermissionTabPK = new FndPermissionTabPK(window, user, permission);
    }

    public FndPermissionTabPK getFndPermissionTabPK() {
        return fndPermissionTabPK;
    }

    public void setFndPermissionTabPK(FndPermissionTabPK fndPermissionTabPK) {
        this.fndPermissionTabPK = fndPermissionTabPK;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getGranted() {
        return granted;
    }

    public void setGranted(String granted) {
        this.granted = granted;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fndPermissionTabPK != null ? fndPermissionTabPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FndPermissionTab)) {
            return false;
        }
        FndPermissionTab other = (FndPermissionTab) object;
        if ((this.fndPermissionTabPK == null && other.fndPermissionTabPK != null) || (this.fndPermissionTabPK != null && !this.fndPermissionTabPK.equals(other.fndPermissionTabPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.FndPermissionTab[ fndPermissionTabPK=" + fndPermissionTabPK + " ]";
    }
    
}
