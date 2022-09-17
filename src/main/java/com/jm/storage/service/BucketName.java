package com.jm.storage.service;

/**
 * @author zhanghongbin
 */
public enum BucketName{

    IMAGE("image"),VIDEO("video"),FILE("file");
    private String name;
    BucketName(String name){
        this.name = name;
    }

    public String toString(){
        return this.name;
    }

}
