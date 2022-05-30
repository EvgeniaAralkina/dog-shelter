package com.example;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.annotation.PostConstruct;
import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "dogs")
public class Dog {
    /**
     * entity-class for Dog
     */
    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "dogs_seq", sequenceName =
            "dogs_sequence", allocationSize = 1)
    @GeneratedValue(generator = "dogs_seq", strategy =
            GenerationType.SEQUENCE)
    private Long id;
    String name;
    Float age;
    String size;
    String gender;
    String photo;
    String description;
    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "user_id")
    @JsonIgnore
    public User user;
    @Transient
    String age2;

    public Dog() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getRealAge() { return age;}

    public String getAge() {
        return setAge2(age);
    }

    public void setAge(Float age) {
        this.age = age;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAge2() {
        return age2;
    }
    public String setAge2(float age) {
        if (age % 1 == 0){
            if (age < 5 && age > 1) {
                this.age2 = String.valueOf((int) age) + " года";
            } if (age == 1){ this.age2 = "1 год";}
            else{
                this.age2 = String.valueOf((int) age) + " лет";
            }
        } else{
            int lastAge = (int)(age % 1 * 10);
            int firstAge = (int)age;
            if (firstAge < 5 && firstAge >0) {
                this.age2 = String.valueOf((int) firstAge) + " года и " +
                        String.valueOf((int) lastAge) + " месяцев";
            } if(firstAge==0){ this.age2 = String.valueOf((int) lastAge) + " месяца";}
            else { this.age2 = "1 год и " + String.valueOf((int) lastAge) + " месяца";}
        }
        return age2;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", size='" + size + '\'' +
                ", gender='" + gender + '\'' +
                ", photo='" + photo + '\'' +
                ", description='" + description + '\'' +
                ", user=" + user +
                '}';
    }
}
