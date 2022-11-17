package tn.esprit.Spring.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.Spring.Entities.Universite;
import tn.esprit.Spring.Services.IUnivresiteService;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/universite")
public class UniversiteController {

    @Autowired
    IUnivresiteService iUnivresiteService;

    @GetMapping("getall")
    public List<Universite> retrieveAllUniversite(){
      return iUnivresiteService.getAllUniversite();
    };

    @PostMapping("/add")
    public Universite addUnivesite(@RequestBody Universite u){
        return iUnivresiteService.addUniversite(u);
    }

    @PutMapping("/update")
    public Universite updateUniversite(@RequestBody Universite u){
        return iUnivresiteService.updateUniversite(u);
    }

    @GetMapping ("/getOne")
    public Universite retrieveUniversite(@PathParam("id") Integer idUniversite){
        return  iUnivresiteService.getById(idUniversite);
    }

    @DeleteMapping("/delete")
    public void removeUniversite(@PathParam("id") Integer idUniversite){
        iUnivresiteService.removeUniversite(idUniversite);
    }

}
