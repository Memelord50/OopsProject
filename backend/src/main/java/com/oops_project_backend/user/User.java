package com.oops_project_backend.user;

import java.time.LocalDateTime;
import java.util.UUID;
public abstract class User {
    private UUID userId;
    private String name;
    private String email;
    private String passwordHash;
    private AccountStatus accountStatus;
    private LocalDateTime createdAt;
    private String displayId;

    protected User(String name, String email, String passwordHash){
        this.name=name;
        this.email=email;
        this.passwordHash=passwordHash;
        userId=UUID.randomUUID();
        this.accountStatus=AccountStatus.ACTIVE;
        createdAt=LocalDateTime.now();
    }
    //getters
    public String getName(){
        return name;
    }
    public String getEmail(){
        return email;
    }
    public String getDisplayId(){
        return displayId;
    }
    public UUID getUserId(){
        return userId;
    }
    public AccountStatus getAccountStatus(){
        return accountStatus;
    }
    public LocalDateTime getCreatedAt(){
        return createdAt;
    }
    //setters
    public void setName(String name){
        this.name=name;
    }
    public void setEmail(String email){
        this.email=email;
    }

}
