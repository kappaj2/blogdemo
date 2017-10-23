package org.jhipster.blog.web.rest;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

import org.jhipster.blog.domain.GCUser;
import org.jhipster.blog.domain.Message;
import org.jhipster.blog.service.GCUserService;
import org.jhipster.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.cloud.datastore.Entity;

@RestController
public class GCUserController {

    @Autowired
    GCUserService gcuserService;
    
    /**
     * Upsert new user
     *
     * @param user
     * @return
     */
    @RequestMapping(value = "/gcusers", method = RequestMethod.POST)
    public ResponseEntity<Message> addUser(@Valid @RequestBody GCUser user) {
        gcuserService.createUser(user);
        return ResponseEntity.ok().body(new Message("Created"));
    }
    
    @RequestMapping(value="/bulk", method = RequestMethod.GET)
    public void bulkLoad(){
        
        List<GCUser> userList = new ArrayList<>();
        
        for (int i = 0; i < 10; i++){
            GCUser user = new GCUser();
            user.setAge(i);
            user.setId(""+i);
            user.setEmail("testuser_"+i+"@gmail.com");
            user.setFullName("FirsName_"+1);
            user.setPassword("12221");
            userList.add(user);
        }
        
        for (GCUser u:userList) {
            Entity retEntity = gcuserService.createUser(u);
        }
        
        System.out.println("Users created....");
    }

}
