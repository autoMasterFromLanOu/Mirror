package com.ba.dllo.mirroralone.model.bean;

import com.litesuits.orm.db.annotation.PrimaryKey;
import com.litesuits.orm.db.annotation.Table;
import com.litesuits.orm.db.enums.AssignType;

/**
 * 创建Address类作为数据库的表
 * Created by ${巴为焱} on 16/6/30.
 */
@Table("myAddress")
public class Address {
    //设置id为自增长主建
    @PrimaryKey(AssignType.AUTO_INCREMENT)
    private int id;
    private String address;
    private String name;
    private String num;

    public Address() {
    }

    public Address(int id, String address, String name, String num) {
        this.id = id;
        this.address = address;
        this.name = name;
        this.num = num;
    }

    public Address(String address, String name, String num) {
        this.address = address;
        this.name = name;
        this.num = num;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }
}


