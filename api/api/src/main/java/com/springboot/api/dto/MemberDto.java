package com.springboot.api.dto;

public class MemberDto {

    private String name;
    private String email;
    private String organization;

    public String getName(){
        return name;
    }

    public String getEmail(){
        return email;
    }

    public String getOrganization(){
        return organization;
    }

    public void setName(String name){
        this.name = name;
    }


    public void setEmail(String email){
        this.email = email;
    }

    public void setOrganization(String organization){
        this.organization = organization;
    }

    @Override
    public String toString(){
        return "MemberDto{" +
                "name = " + name +
                ", email = " + email +
                ", organization = " + organization;
    }
}
