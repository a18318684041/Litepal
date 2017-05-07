package com.example.administrator.test_litepal;

import org.litepal.crud.DataSupport;

/**
 * Created by Administrator on 2017/5/7 0007.
 */

public class info  extends DataSupport {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }

    private String name;
    private int  age;
    private String work;
    //在litepalz中会自动生成id这个字段
}
