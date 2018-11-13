package com.huatec.edu.mobileshop.db;


import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;

import java.io.Serializable;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class Category implements Serializable {

    @Id
    private Long cat_id;
    private String name;
    private int parent_id;
    private String cat_path;
    private int goods_count;
    private int sort;
    private int type_id;
    private int list_show;
    private String image;
    public String getImage() {
        return this.image;
    }
    public void setImage(String image) {
        this.image = image;
    }
    public int getList_show() {
        return this.list_show;
    }
    public void setList_show(int list_show) {
        this.list_show = list_show;
    }
    public int getType_id() {
        return this.type_id;
    }
    public void setType_id(int type_id) {
        this.type_id = type_id;
    }
    public int getSort() {
        return this.sort;
    }
    public void setSort(int sort) {
        this.sort = sort;
    }
    public int getGoods_count() {
        return this.goods_count;
    }
    public void setGoods_count(int goods_count) {
        this.goods_count = goods_count;
    }
    public String getCat_path() {
        return this.cat_path;
    }
    public void setCat_path(String cat_path) {
        this.cat_path = cat_path;
    }
    public int getParent_id() {
        return this.parent_id;
    }
    public void setParent_id(int parent_id) {
        this.parent_id = parent_id;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Long getCat_id() {
        return this.cat_id;
    }
    public void setCat_id(Long cat_id) {
        this.cat_id = cat_id;
    }
    @Generated(hash = 825816281)
    public Category(Long cat_id, String name, int parent_id, String cat_path,
            int goods_count, int sort, int type_id, int list_show, String image) {
        this.cat_id = cat_id;
        this.name = name;
        this.parent_id = parent_id;
        this.cat_path = cat_path;
        this.goods_count = goods_count;
        this.sort = sort;
        this.type_id = type_id;
        this.list_show = list_show;
        this.image = image;
    }
    @Generated(hash = 1150634039)
    public Category() {
    }

}
