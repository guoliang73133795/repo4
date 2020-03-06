package cn.itcast.domian;

public class Province {
    private Integer id;
    private Integer provinceID;
    private String province;

    public Province() {
    }

    public Province(Integer id, Integer provinceID, String province) {
        this.id = id;
        this.provinceID = provinceID;
        this.province = province;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProvinceID() {
        return provinceID;
    }

    public void setProvinceID(Integer provinceID) {
        this.provinceID = provinceID;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    @Override
    public String toString() {
        return "Province{" + "id=" + id + ", provinceID=" + provinceID + ", province='" + province + '\'' + '}';
    }
}
