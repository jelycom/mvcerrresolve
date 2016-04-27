package cn.jely.cd.domain;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "demo")
public class DemoDomain extends InfoModel<DemoDomain> {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
