package com.rest.webservices.restfulwebservices.service;

import com.rest.webservices.restfulwebservices.data.User;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.Date;

@Component
public class UserService {

    private static List<User> users = new ArrayList<>();

    private static int userCount = 3;
    static{
        users.add(new User(1,"Ankit", new Date()));
        users.add(new User(2,"Arpit", new Date()));
        users.add(new User(3,"Animal", new Date()));
    }

    public List<User> findAll(){
        return users;
    }

    public User saveUser(User user){
        if(user.getId()==0)
        {
            user.setId(++userCount);
        }
        users.add(user);
        return user;
    }

    public User userById(int id){
        for(User user : users)
        {
            if(user.getId()==id)
            {
                return user;
            }
        }
        return null;
    }

    public User deleteUserById(int id){
        User deletedUser=null;
        Iterator<User> it = users.iterator();
        while(it.hasNext())
        {
            User todeleteUser = it.next();
            if(todeleteUser.getId()==id)
            {
                it.remove();
                return todeleteUser;
            }

        }
        return null;
    }

}
