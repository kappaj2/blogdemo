package org.jhipster.blog.service;

import javax.annotation.PostConstruct;

import org.jhipster.blog.domain.GCUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.Entity;
import com.google.cloud.datastore.Key;
import com.google.cloud.datastore.KeyFactory;

@Service
public class GCUserService {
    
    private final Logger log = LoggerFactory.getLogger(GCUserService.class);
    
    @Autowired
    Datastore datastore;
    
    private KeyFactory userKeyFactory;
    
    @PostConstruct
    public void initializeKeyFactories() {
        log.info("Initializing key factories");
        userKeyFactory = datastore.newKeyFactory();
    }
    
    public Entity createUser(GCUser user) {
        Entity ent = createUserEntity(user);
        ent.hasKey();
        return datastore.put(ent);
    }
    
    private Entity createUserEntity(GCUser user) {
        System.out.println("Adding entry id : " + user.getId());
        userKeyFactory.setNamespace("blog");
        userKeyFactory.setKind("User");
        Key key = userKeyFactory.newKey(user.getId());
        
        return Entity.newBuilder(key)
            .set("email", user.getEmail())
            .set("password", user.getPassword())
            .set("fullName", user.getFullName())
            .set("age", user.getAge())
            .build();
    }
    
}
