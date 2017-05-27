/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Chamini
 */
@Embeddable
public class FndPermissionTabPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "Window")
    private String window;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "User")
    private String user;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "Permission")
    private String permission;

    public FndPermissionTabPK() {
    }

    public FndPermissionTabPK(String window, String user, String permission) {
        this.window = window;
        this.user = user;
        this.permission = permission;
    }

    public String getWindow() {
        return window;
    }

    public void setWindow(String window) {
       
       this.window = window;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (window != null ? window.hashCode() : 0);
        hash += (user != null ? user.hashCode() : 0);
        hash += (permission != null ? permission.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FndPermissionTabPK)) {
            return false;
        }
        FndPermissionTabPK other = (FndPermissionTabPK) object;
        if ((this.window == null && other.window != null) || (this.window != null && !this.window.equals(other.window))) {
            return false;
        }
        if ((this.user == null && other.user != null) || (this.user != null && !this.user.equals(other.user))) {
            return false;
        }
        if ((this.permission == null && other.permission != null) || (this.permission != null && !this.permission.equals(other.permission))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.FndPermissionTabPK[ window=" + window + ", user=" + user + ", permission=" + permission + " ]";
    }
    
}
