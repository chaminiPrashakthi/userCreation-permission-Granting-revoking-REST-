/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Chamini
 */
@Entity
@Table(name = "user")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u"),
    @NamedQuery(name = "User.findByHost", query = "SELECT u FROM User u WHERE u.userPK.host = :host"),
    @NamedQuery(name = "User.findByUser", query = "SELECT u FROM User u WHERE u.userPK.user = :user"),
    @NamedQuery(name = "User.findBySelectpriv", query = "SELECT u FROM User u WHERE u.selectpriv = :selectpriv"),
    @NamedQuery(name = "User.findByInsertpriv", query = "SELECT u FROM User u WHERE u.insertpriv = :insertpriv"),
    @NamedQuery(name = "User.findByUpdatepriv", query = "SELECT u FROM User u WHERE u.updatepriv = :updatepriv"),
    @NamedQuery(name = "User.findByDeletepriv", query = "SELECT u FROM User u WHERE u.deletepriv = :deletepriv"),
    @NamedQuery(name = "User.findByCreatepriv", query = "SELECT u FROM User u WHERE u.createpriv = :createpriv"),
    @NamedQuery(name = "User.findByDroppriv", query = "SELECT u FROM User u WHERE u.droppriv = :droppriv"),
    @NamedQuery(name = "User.findByReloadpriv", query = "SELECT u FROM User u WHERE u.reloadpriv = :reloadpriv"),
    @NamedQuery(name = "User.findByShutdownpriv", query = "SELECT u FROM User u WHERE u.shutdownpriv = :shutdownpriv"),
    @NamedQuery(name = "User.findByProcesspriv", query = "SELECT u FROM User u WHERE u.processpriv = :processpriv"),
    @NamedQuery(name = "User.findByFilepriv", query = "SELECT u FROM User u WHERE u.filepriv = :filepriv"),
    @NamedQuery(name = "User.findByGrantpriv", query = "SELECT u FROM User u WHERE u.grantpriv = :grantpriv"),
    @NamedQuery(name = "User.findByReferencespriv", query = "SELECT u FROM User u WHERE u.referencespriv = :referencespriv"),
    @NamedQuery(name = "User.findByIndexpriv", query = "SELECT u FROM User u WHERE u.indexpriv = :indexpriv"),
    @NamedQuery(name = "User.findByAlterpriv", query = "SELECT u FROM User u WHERE u.alterpriv = :alterpriv"),
    @NamedQuery(name = "User.findByShowdbpriv", query = "SELECT u FROM User u WHERE u.showdbpriv = :showdbpriv"),
    @NamedQuery(name = "User.findBySuperpriv", query = "SELECT u FROM User u WHERE u.superpriv = :superpriv"),
    @NamedQuery(name = "User.findByCreatetmptablepriv", query = "SELECT u FROM User u WHERE u.createtmptablepriv = :createtmptablepriv"),
    @NamedQuery(name = "User.findByLocktablespriv", query = "SELECT u FROM User u WHERE u.locktablespriv = :locktablespriv"),
    @NamedQuery(name = "User.findByExecutepriv", query = "SELECT u FROM User u WHERE u.executepriv = :executepriv"),
    @NamedQuery(name = "User.findByReplslavepriv", query = "SELECT u FROM User u WHERE u.replslavepriv = :replslavepriv"),
    @NamedQuery(name = "User.findByReplclientpriv", query = "SELECT u FROM User u WHERE u.replclientpriv = :replclientpriv"),
    @NamedQuery(name = "User.findByCreateviewpriv", query = "SELECT u FROM User u WHERE u.createviewpriv = :createviewpriv"),
    @NamedQuery(name = "User.findByShowviewpriv", query = "SELECT u FROM User u WHERE u.showviewpriv = :showviewpriv"),
    @NamedQuery(name = "User.findByCreateroutinepriv", query = "SELECT u FROM User u WHERE u.createroutinepriv = :createroutinepriv"),
    @NamedQuery(name = "User.findByAlterroutinepriv", query = "SELECT u FROM User u WHERE u.alterroutinepriv = :alterroutinepriv"),
    @NamedQuery(name = "User.findByCreateuserpriv", query = "SELECT u FROM User u WHERE u.createuserpriv = :createuserpriv"),
    @NamedQuery(name = "User.findByEventpriv", query = "SELECT u FROM User u WHERE u.eventpriv = :eventpriv"),
    @NamedQuery(name = "User.findByTriggerpriv", query = "SELECT u FROM User u WHERE u.triggerpriv = :triggerpriv"),
    @NamedQuery(name = "User.findByCreatetablespacepriv", query = "SELECT u FROM User u WHERE u.createtablespacepriv = :createtablespacepriv"),
    @NamedQuery(name = "User.findBySslType", query = "SELECT u FROM User u WHERE u.sslType = :sslType"),
    @NamedQuery(name = "User.findByMaxQuestions", query = "SELECT u FROM User u WHERE u.maxQuestions = :maxQuestions"),
    @NamedQuery(name = "User.findByMaxUpdates", query = "SELECT u FROM User u WHERE u.maxUpdates = :maxUpdates"),
    @NamedQuery(name = "User.findByMaxConnections", query = "SELECT u FROM User u WHERE u.maxConnections = :maxConnections"),
    @NamedQuery(name = "User.findByMaxUserConnections", query = "SELECT u FROM User u WHERE u.maxUserConnections = :maxUserConnections"),
    @NamedQuery(name = "User.findByPlugin", query = "SELECT u FROM User u WHERE u.plugin = :plugin"),
    @NamedQuery(name = "User.findByPasswordExpired", query = "SELECT u FROM User u WHERE u.passwordExpired = :passwordExpired"),
    @NamedQuery(name = "User.findByPasswordLastChanged", query = "SELECT u FROM User u WHERE u.passwordLastChanged = :passwordLastChanged"),
    @NamedQuery(name = "User.findByPasswordLifetime", query = "SELECT u FROM User u WHERE u.passwordLifetime = :passwordLifetime"),
    @NamedQuery(name = "User.findByAccountLocked", query = "SELECT u FROM User u WHERE u.accountLocked = :accountLocked")})
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected UserPK userPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "Select_priv")
    private String selectpriv;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "Insert_priv")
    private String insertpriv;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "Update_priv")
    private String updatepriv;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "Delete_priv")
    private String deletepriv;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "Create_priv")
    private String createpriv;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "Drop_priv")
    private String droppriv;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "Reload_priv")
    private String reloadpriv;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "Shutdown_priv")
    private String shutdownpriv;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "Process_priv")
    private String processpriv;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "File_priv")
    private String filepriv;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "Grant_priv")
    private String grantpriv;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "References_priv")
    private String referencespriv;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "Index_priv")
    private String indexpriv;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "Alter_priv")
    private String alterpriv;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "Show_db_priv")
    private String showdbpriv;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "Super_priv")
    private String superpriv;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "Create_tmp_table_priv")
    private String createtmptablepriv;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "Lock_tables_priv")
    private String locktablespriv;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "Execute_priv")
    private String executepriv;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "Repl_slave_priv")
    private String replslavepriv;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "Repl_client_priv")
    private String replclientpriv;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "Create_view_priv")
    private String createviewpriv;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "Show_view_priv")
    private String showviewpriv;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "Create_routine_priv")
    private String createroutinepriv;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "Alter_routine_priv")
    private String alterroutinepriv;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "Create_user_priv")
    private String createuserpriv;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "Event_priv")
    private String eventpriv;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "Trigger_priv")
    private String triggerpriv;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "Create_tablespace_priv")
    private String createtablespacepriv;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 9)
    @Column(name = "ssl_type")
    private String sslType;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Column(name = "ssl_cipher")
    private byte[] sslCipher;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Column(name = "x509_issuer")
    private byte[] x509Issuer;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Column(name = "x509_subject")
    private byte[] x509Subject;
    @Basic(optional = false)
    @NotNull
    @Column(name = "max_questions")
    private int maxQuestions;
    @Basic(optional = false)
    @NotNull
    @Column(name = "max_updates")
    private int maxUpdates;
    @Basic(optional = false)
    @NotNull
    @Column(name = "max_connections")
    private int maxConnections;
    @Basic(optional = false)
    @NotNull
    @Column(name = "max_user_connections")
    private int maxUserConnections;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "plugin")
    private String plugin;
    @Lob
    @Size(max = 65535)
    @Column(name = "authentication_string")
    private String authenticationString;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "password_expired")
    private String passwordExpired;
    @Column(name = "password_last_changed")
    @Temporal(TemporalType.TIMESTAMP)
    private Date passwordLastChanged;
    @Column(name = "password_lifetime")
    private Short passwordLifetime;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "account_locked")
    private String accountLocked;

    public User() {
    }

    public User(UserPK userPK) {
        this.userPK = userPK;
    }

    public User(UserPK userPK, String selectpriv, String insertpriv, String updatepriv, String deletepriv, String createpriv, String droppriv, String reloadpriv, String shutdownpriv, String processpriv, String filepriv, String grantpriv, String referencespriv, String indexpriv, String alterpriv, String showdbpriv, String superpriv, String createtmptablepriv, String locktablespriv, String executepriv, String replslavepriv, String replclientpriv, String createviewpriv, String showviewpriv, String createroutinepriv, String alterroutinepriv, String createuserpriv, String eventpriv, String triggerpriv, String createtablespacepriv, String sslType, byte[] sslCipher, byte[] x509Issuer, byte[] x509Subject, int maxQuestions, int maxUpdates, int maxConnections, int maxUserConnections, String plugin, String passwordExpired, String accountLocked) {
        this.userPK = userPK;
        this.selectpriv = selectpriv;
        this.insertpriv = insertpriv;
        this.updatepriv = updatepriv;
        this.deletepriv = deletepriv;
        this.createpriv = createpriv;
        this.droppriv = droppriv;
        this.reloadpriv = reloadpriv;
        this.shutdownpriv = shutdownpriv;
        this.processpriv = processpriv;
        this.filepriv = filepriv;
        this.grantpriv = grantpriv;
        this.referencespriv = referencespriv;
        this.indexpriv = indexpriv;
        this.alterpriv = alterpriv;
        this.showdbpriv = showdbpriv;
        this.superpriv = superpriv;
        this.createtmptablepriv = createtmptablepriv;
        this.locktablespriv = locktablespriv;
        this.executepriv = executepriv;
        this.replslavepriv = replslavepriv;
        this.replclientpriv = replclientpriv;
        this.createviewpriv = createviewpriv;
        this.showviewpriv = showviewpriv;
        this.createroutinepriv = createroutinepriv;
        this.alterroutinepriv = alterroutinepriv;
        this.createuserpriv = createuserpriv;
        this.eventpriv = eventpriv;
        this.triggerpriv = triggerpriv;
        this.createtablespacepriv = createtablespacepriv;
        this.sslType = sslType;
        this.sslCipher = sslCipher;
        this.x509Issuer = x509Issuer;
        this.x509Subject = x509Subject;
        this.maxQuestions = maxQuestions;
        this.maxUpdates = maxUpdates;
        this.maxConnections = maxConnections;
        this.maxUserConnections = maxUserConnections;
        this.plugin = plugin;
        this.passwordExpired = passwordExpired;
        this.accountLocked = accountLocked;
    }

    public User(String host, String user) {
        this.userPK = new UserPK(host, user);
    }

    public UserPK getUserPK() {
        return userPK;
    }

    public void setUserPK(UserPK userPK) {
        this.userPK = userPK;
    }

    public String getSelectpriv() {
        return selectpriv;
    }

    public void setSelectpriv(String selectpriv) {
        this.selectpriv = selectpriv;
    }

    public String getInsertpriv() {
        return insertpriv;
    }

    public void setInsertpriv(String insertpriv) {
        this.insertpriv = insertpriv;
    }

    public String getUpdatepriv() {
        return updatepriv;
    }

    public void setUpdatepriv(String updatepriv) {
        this.updatepriv = updatepriv;
    }

    public String getDeletepriv() {
        return deletepriv;
    }

    public void setDeletepriv(String deletepriv) {
        this.deletepriv = deletepriv;
    }

    public String getCreatepriv() {
        return createpriv;
    }

    public void setCreatepriv(String createpriv) {
        this.createpriv = createpriv;
    }

    public String getDroppriv() {
        return droppriv;
    }

    public void setDroppriv(String droppriv) {
        this.droppriv = droppriv;
    }

    public String getReloadpriv() {
        return reloadpriv;
    }

    public void setReloadpriv(String reloadpriv) {
        this.reloadpriv = reloadpriv;
    }

    public String getShutdownpriv() {
        return shutdownpriv;
    }

    public void setShutdownpriv(String shutdownpriv) {
        this.shutdownpriv = shutdownpriv;
    }

    public String getProcesspriv() {
        return processpriv;
    }

    public void setProcesspriv(String processpriv) {
        this.processpriv = processpriv;
    }

    public String getFilepriv() {
        return filepriv;
    }

    public void setFilepriv(String filepriv) {
        this.filepriv = filepriv;
    }

    public String getGrantpriv() {
        return grantpriv;
    }

    public void setGrantpriv(String grantpriv) {
        this.grantpriv = grantpriv;
    }

    public String getReferencespriv() {
        return referencespriv;
    }

    public void setReferencespriv(String referencespriv) {
        this.referencespriv = referencespriv;
    }

    public String getIndexpriv() {
        return indexpriv;
    }

    public void setIndexpriv(String indexpriv) {
        this.indexpriv = indexpriv;
    }

    public String getAlterpriv() {
        return alterpriv;
    }

    public void setAlterpriv(String alterpriv) {
        this.alterpriv = alterpriv;
    }

    public String getShowdbpriv() {
        return showdbpriv;
    }

    public void setShowdbpriv(String showdbpriv) {
        this.showdbpriv = showdbpriv;
    }

    public String getSuperpriv() {
        return superpriv;
    }

    public void setSuperpriv(String superpriv) {
        this.superpriv = superpriv;
    }

    public String getCreatetmptablepriv() {
        return createtmptablepriv;
    }

    public void setCreatetmptablepriv(String createtmptablepriv) {
        this.createtmptablepriv = createtmptablepriv;
    }

    public String getLocktablespriv() {
        return locktablespriv;
    }

    public void setLocktablespriv(String locktablespriv) {
        this.locktablespriv = locktablespriv;
    }

    public String getExecutepriv() {
        return executepriv;
    }

    public void setExecutepriv(String executepriv) {
        this.executepriv = executepriv;
    }

    public String getReplslavepriv() {
        return replslavepriv;
    }

    public void setReplslavepriv(String replslavepriv) {
        this.replslavepriv = replslavepriv;
    }

    public String getReplclientpriv() {
        return replclientpriv;
    }

    public void setReplclientpriv(String replclientpriv) {
        this.replclientpriv = replclientpriv;
    }

    public String getCreateviewpriv() {
        return createviewpriv;
    }

    public void setCreateviewpriv(String createviewpriv) {
        this.createviewpriv = createviewpriv;
    }

    public String getShowviewpriv() {
        return showviewpriv;
    }

    public void setShowviewpriv(String showviewpriv) {
        this.showviewpriv = showviewpriv;
    }

    public String getCreateroutinepriv() {
        return createroutinepriv;
    }

    public void setCreateroutinepriv(String createroutinepriv) {
        this.createroutinepriv = createroutinepriv;
    }

    public String getAlterroutinepriv() {
        return alterroutinepriv;
    }

    public void setAlterroutinepriv(String alterroutinepriv) {
        this.alterroutinepriv = alterroutinepriv;
    }

    public String getCreateuserpriv() {
        return createuserpriv;
    }

    public void setCreateuserpriv(String createuserpriv) {
        this.createuserpriv = createuserpriv;
    }

    public String getEventpriv() {
        return eventpriv;
    }

    public void setEventpriv(String eventpriv) {
        this.eventpriv = eventpriv;
    }

    public String getTriggerpriv() {
        return triggerpriv;
    }

    public void setTriggerpriv(String triggerpriv) {
        this.triggerpriv = triggerpriv;
    }

    public String getCreatetablespacepriv() {
        return createtablespacepriv;
    }

    public void setCreatetablespacepriv(String createtablespacepriv) {
        this.createtablespacepriv = createtablespacepriv;
    }

    public String getSslType() {
        return sslType;
    }

    public void setSslType(String sslType) {
        this.sslType = sslType;
    }

    public byte[] getSslCipher() {
        return sslCipher;
    }

    public void setSslCipher(byte[] sslCipher) {
        this.sslCipher = sslCipher;
    }

    public byte[] getX509Issuer() {
        return x509Issuer;
    }

    public void setX509Issuer(byte[] x509Issuer) {
        this.x509Issuer = x509Issuer;
    }

    public byte[] getX509Subject() {
        return x509Subject;
    }

    public void setX509Subject(byte[] x509Subject) {
        this.x509Subject = x509Subject;
    }

    public int getMaxQuestions() {
        return maxQuestions;
    }

    public void setMaxQuestions(int maxQuestions) {
        this.maxQuestions = maxQuestions;
    }

    public int getMaxUpdates() {
        return maxUpdates;
    }

    public void setMaxUpdates(int maxUpdates) {
        this.maxUpdates = maxUpdates;
    }

    public int getMaxConnections() {
        return maxConnections;
    }

    public void setMaxConnections(int maxConnections) {
        this.maxConnections = maxConnections;
    }

    public int getMaxUserConnections() {
        return maxUserConnections;
    }

    public void setMaxUserConnections(int maxUserConnections) {
        this.maxUserConnections = maxUserConnections;
    }

    public String getPlugin() {
        return plugin;
    }

    public void setPlugin(String plugin) {
        this.plugin = plugin;
    }

    public String getAuthenticationString() {
        return authenticationString;
    }

    public void setAuthenticationString(String authenticationString) {
        this.authenticationString = authenticationString;
    }

    public String getPasswordExpired() {
        return passwordExpired;
    }

    public void setPasswordExpired(String passwordExpired) {
        this.passwordExpired = passwordExpired;
    }

    public Date getPasswordLastChanged() {
        return passwordLastChanged;
    }

    public void setPasswordLastChanged(Date passwordLastChanged) {
        this.passwordLastChanged = passwordLastChanged;
    }

    public Short getPasswordLifetime() {
        return passwordLifetime;
    }

    public void setPasswordLifetime(Short passwordLifetime) {
        this.passwordLifetime = passwordLifetime;
    }

    public String getAccountLocked() {
        return accountLocked;
    }

    public void setAccountLocked(String accountLocked) {
        this.accountLocked = accountLocked;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userPK != null ? userPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.userPK == null && other.userPK != null) || (this.userPK != null && !this.userPK.equals(other.userPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.User[ userPK=" + userPK + " ]";
    }
    
}
