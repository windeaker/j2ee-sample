package mybatis.simple.pojo;

import java.util.Date;

public class SysAccount {
    private Integer id;

    private Byte deleted;

    private Date cstCreated;

    private Date cstModified;

    private String account;

    private String nickName;

    private String pwdDigest;

    private String digestSalt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Byte getDeleted() {
        return deleted;
    }

    public void setDeleted(Byte deleted) {
        this.deleted = deleted;
    }

    public Date getCstCreated() {
        return cstCreated;
    }

    public void setCstCreated(Date cstCreated) {
        this.cstCreated = cstCreated;
    }

    public Date getCstModified() {
        return cstModified;
    }

    public void setCstModified(Date cstModified) {
        this.cstModified = cstModified;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName == null ? null : nickName.trim();
    }

    public String getPwdDigest() {
        return pwdDigest;
    }

    public void setPwdDigest(String pwdDigest) {
        this.pwdDigest = pwdDigest == null ? null : pwdDigest.trim();
    }

    public String getDigestSalt() {
        return digestSalt;
    }

    public void setDigestSalt(String digestSalt) {
        this.digestSalt = digestSalt == null ? null : digestSalt.trim();
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        SysAccount other = (SysAccount) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getDeleted() == null ? other.getDeleted() == null : this.getDeleted().equals(other.getDeleted()))
            && (this.getCstCreated() == null ? other.getCstCreated() == null : this.getCstCreated().equals(other.getCstCreated()))
            && (this.getCstModified() == null ? other.getCstModified() == null : this.getCstModified().equals(other.getCstModified()))
            && (this.getAccount() == null ? other.getAccount() == null : this.getAccount().equals(other.getAccount()))
            && (this.getNickName() == null ? other.getNickName() == null : this.getNickName().equals(other.getNickName()))
            && (this.getPwdDigest() == null ? other.getPwdDigest() == null : this.getPwdDigest().equals(other.getPwdDigest()))
            && (this.getDigestSalt() == null ? other.getDigestSalt() == null : this.getDigestSalt().equals(other.getDigestSalt()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getDeleted() == null) ? 0 : getDeleted().hashCode());
        result = prime * result + ((getCstCreated() == null) ? 0 : getCstCreated().hashCode());
        result = prime * result + ((getCstModified() == null) ? 0 : getCstModified().hashCode());
        result = prime * result + ((getAccount() == null) ? 0 : getAccount().hashCode());
        result = prime * result + ((getNickName() == null) ? 0 : getNickName().hashCode());
        result = prime * result + ((getPwdDigest() == null) ? 0 : getPwdDigest().hashCode());
        result = prime * result + ((getDigestSalt() == null) ? 0 : getDigestSalt().hashCode());
        return result;
    }
}