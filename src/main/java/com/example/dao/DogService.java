package com.example.dao;

import com.example.Dog;
import com.example.User;
import com.example.repository.DogRepository;
import com.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class DogService {
    @Autowired
    private DogRepository dogRepository;
    @Autowired
    private UserRepository userRepository;


    public List<Dog> index(){
        return (List<Dog>)dogRepository.findAll();
    }

    public void update(String dog, User user){
        Dog dog1 = dogRepository.findByName(dog);
        System.out.println("in dog update");
        //System.out.println(dog1.toString());
        System.out.println(user.getUsername());
        System.out.println(dog1.getName());
        Dog dogToUpdate = dogRepository.getOne(dog1.getId());
        dogToUpdate.setUser(user);
        dogRepository.save(dogToUpdate);
    }

    public Dog show(Long id) {
        System.out.println("show " + id);
        return dogRepository.findById(id).orElseThrow(() ->
                new IllegalStateException("Dog with this id not found"));

    }

    public List<Dog> getDogFilteredByGender(String gender){
        return dogRepository.findAllByGender(gender);
    }

    public List<Dog> getDogFilteredBySize(String size){
        return dogRepository.findAllBySize(size);
    }

    public List<Dog> getDogFilteredBySizeAndGender(String size, String gender) {
        return dogRepository.findAllBySizeAndGender(size, gender);
    }

    public List<Dog> getDogFilteredByAge(String age) {
        List<Dog> d = dogRepository.findAll();

        //d.removeIf(dog -> dog.getRealAge() < 1.0f);
        if (age.equals("young")){
            //List <Dog> d2 = dogRepository.findAll();
            //d2.removeAll(d);
            d.removeIf(dog -> dog.getRealAge() > 1.0f);
            //return d2;
        } else
            d.removeIf(dog -> dog.getRealAge() < 1.0f);
        return d;
    }

    public List<Dog> getDogFilteredByAgeAndGender(String age, String gender) {
        List<Dog> d1 = getDogFilteredByGender(gender);
        List<Dog> d2 = getDogFilteredByAge(age);
        d1.retainAll(d2);
        return d1;
    }

    public List<Dog> getDogFilteredByAgeAndSize(String age, String size) {
        List<Dog> d1 = getDogFilteredBySize(size);
        List<Dog> d2 = getDogFilteredByAge(age);
        d1.retainAll(d2);
        return d1;
    }

    public List<Dog> getDogFilteredByAgeAndSizeAndGender(String age, String size, String gender) {
        List<Dog> d1 = dogRepository.findAllBySizeAndGender(size, gender);
        List<Dog> d2 = getDogFilteredByAge(age);
        d1.retainAll(d2);
        return d1;
    }

    public void save(Dog dog) {
        dog.setUser(userRepository.findByUsername("defaultuser"));
        dogRepository.save(dog);
    }
}
