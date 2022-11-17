package tn.esprit.Spring.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.Spring.Entities.Equipe;
import tn.esprit.Spring.Services.IEquipeService;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/equipe")
public class EquipeController {
    @Autowired
    IEquipeService iEquipeService;

    @GetMapping("/getall")
    public List<Equipe> retrieveAllEquipes(){
      return iEquipeService.getAllEquipe();
    };

    @PostMapping ("/add")
    public Equipe addEquipe(@RequestBody Equipe e){
        return iEquipeService.addEquipe(e);
    }

    @GetMapping("/getone")
    public Equipe retieveEquipe(@PathParam("id") Integer idEquipe){
      return iEquipeService.getById(idEquipe);
    };

    @DeleteMapping("/delete")
    public void removeEquipe(@PathParam("id") Integer idEquipe){
        iEquipeService.removeEquipe(idEquipe);
    }
}
