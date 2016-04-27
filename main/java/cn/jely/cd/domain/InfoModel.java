package cn.jely.cd.domain;

import java.io.Serializable;
import java.util.Date;

public abstract class InfoModel<T extends InfoModel> implements Serializable {
    private Date createTime;
    private Date updateTime;

    public void preSave() {
        setCreateTime(new Date());
        setUpdateTime(new Date());
    }

    public void preUpdate() {
        setUpdateTime((new Date()));
    }
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

}
