package com.oops_project_backend.user;
import java.util.HashSet;
import java.util.Set;
import java.util.Collections;
import com.oops_project_backend.IncidentCategory;
public class Technician extends User {
    //skills, availability, workload
     private Set<IncidentCategory> skills;
     private Availability availability;
     private int workload;


    public Technician(String name, String email, String passwordHash,Set<IncidentCategory> skills){
        super(name,email,passwordHash);
        this.workload=0;
        this.availability=Availability.AVAILABLE;
       
        if(skills==null || skills.isEmpty()||skills.contains(null)){
            throw new IllegalArgumentException("Skills cannot be empty or null");
        }
        this.skills=new HashSet<>(skills);
    }
    public Set<IncidentCategory> getSkills(){
        return Collections.unmodifiableSet(skills);
    }
    public Availability getAvailability(){
        return availability;
    }
    public int getWorkload(){
        return workload;
    }

    public void setAvailability(Availability a){
        if(a!=null){
        this.availability=a;
        }
        else if(a==null) throw new IllegalArgumentException("Availability cannot be null");
    }
    public void addSkill(IncidentCategory i ){
        if (i == null) {
    throw new IllegalArgumentException("Skill cannot be null");
        }
        this.skills.add(i);
    }
    public void removeSkill(IncidentCategory i){
        if(i==null){
                throw new IllegalArgumentException("Skill cannot be null");
            }    
        else if(skills.size()>1){
            skills.remove(i);
            }
             
            
        
    }
   
public void incrementWorkload(){
    workload+=1;
}
public void decrementWorkload(){
    if(workload>0){
    workload-=1;
    }
   }
}