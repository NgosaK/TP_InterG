package za.ac.tpProject.API;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

/**
 * Created by User on 2015/11/22.
 */
@RestController
@RequestMapping("/api/")
public class UsersPage {

    @Autowired
    private StaffService service;

    //---------------------Retrieve All Staff -------------------------

    @RequestMapping(value = "staff/", method = RequestMethod.GET)
    public ResponseEntity<List<museum.domain.Staff>> listAllStaff(){
        List<museum.domain.Staff> Staff = service.findAll();
        if(Staff.isEmpty()){
            return new ResponseEntity<List<museum.domain.Staff>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<museum.domain.Staff>>(Staff, HttpStatus.OK);
    }

    //--------------------Retrieve Single Staff Member------------------------

    @RequestMapping(value = "staff/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<museum.domain.Staff> getStaff(@PathVariable("id") int id){
        System.out.println("Fetching staff with code: " + id);
        museum.domain.Staff Staff = service.findById(id);
        if(Staff == null){
            System.out.println("Staff with id " + id + " not found");
            return new ResponseEntity<museum.domain.Staff>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<museum.domain.Staff>(Staff, HttpStatus.OK);
    }

    //---------------------Create a Staff Member ------------------------------------

    @RequestMapping(value = "staff/create", method = RequestMethod.POST)
    public ResponseEntity<Void> createStaff(@RequestBody museum.domain.Staff staff, UriComponentsBuilder uBuilder){
        System.out.println("Creating staff member " + staff.getName());

        service.save(staff);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(uBuilder.path("/staff/{id}").buildAndExpand(staff.getName()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    //-------------------Update a staff member---------------------------

    @RequestMapping(value = "staff/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<museum.domain.Staff> updateStaff(@PathVariable("id") int id, @RequestBody museum.domain.Staff staff){
        System.out.println("Updating Staff Member");

        museum.domain.Staff currentStaff = service.findById(id);

        if(currentStaff == null){
            System.out.println("Staff member with Staff code " + id + " not found");
            return new ResponseEntity<Staff>(HttpStatus.NOT_FOUND);
        }

        museum.domain.Staff updatedStaff = new Staff
                .Builder(currentStaff.getName())
                .copy(currentStaff)
                .build();

        service.update(updatedStaff);

        return new ResponseEntity<museum.domain.Staff>(updatedStaff, HttpStatus.OK);
    }

    //--------------------Delete a Staff member ----------------------------

    @RequestMapping(value = "staff/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<museum.domain.Staff> deleteStaff(@PathVariable("id")int id){
        System.out.println("Fetching and deleting a staff member with id " + id);

        museum.domain.Staff staff = service.findById(id);
        if(staff == null){
            System.out.println("Unable to delete. Staff member with id + " + id + " not found");
            return new ResponseEntity<museum.domain.Staff>(HttpStatus.NOT_FOUND);
        }

        service.delete(staff);
        return new ResponseEntity<museum.domain.Staff>(HttpStatus.NO_CONTENT);
    }
}
