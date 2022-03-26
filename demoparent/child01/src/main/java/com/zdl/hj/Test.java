package com.zdl.hj;

import com.zdl.core.model.Person;

import javax.annotation.Resource;

public class Test {
    @Resource
    Person p;
    private String getName(){
        String name  = p.getName();
        return name;
    }
}
