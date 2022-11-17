package tn.esprit.Spring.Controllers;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.Spring.Entities.Etudiant;
import tn.esprit.Spring.Services.IDepartementService;
import tn.esprit.Spring.Services.IEtudiantService;

import javax.websocket.server.PathParam;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/etudiant")
public class EtudiantController {
    //@Autowired     //injecter un bean qui imlemente l'interface iEtudiantService
    IEtudiantService iEtudiantService;
    @Autowired
    IDepartementService iDepartementService;

    @GetMapping("/hello/{classname}")
    public String sayHello(@PathVariable String classname){
        return "hello "+classname;
    }

    @PostMapping("/add")
    public Etudiant addStudent(@RequestBody Etudiant e){
        return iEtudiantService.addStudent(e);
    }

    @PostMapping("/assign/{idEtudiant}/{idDepartement}")
    public void addAndAssignEtudiant(@PathVariable int idEtudiant,@PathVariable int idDepartement) {
        iEtudiantService.addAndAssignEtudiant(idEtudiant, idDepartement);
    }

    @PutMapping("/update")
    public Etudiant updateEtudiant(@RequestBody Etudiant e){
        return iEtudiantService.updateStudent(e);
    }

    @GetMapping("/getall")
    public Etudiant retrieveEtudiant(@PathParam("id") Integer idEtudiant){
        return iEtudiantService.getById(idEtudiant);
    }

    @DeleteMapping("/delete/{id}")
    public void removeEtudiant(@PathVariable Integer idEtudiant){
        iEtudiantService.removeStudent(idEtudiant);
    }

    @PostMapping("/asetoec/{idContrat}/{idEquipe}")
    public ResponseEntity AssignEtudiantToEquipeAndContrat(@RequestBody Etudiant e , @PathVariable Integer idContrat , @PathVariable Integer idEquipe) {
        iEtudiantService.AssignEtudiantToEquipeAndContrat(e, idContrat, idEquipe);
        return new ResponseEntity<>("Added", HttpStatus.OK);
    }

    @GetMapping("etudByDep/{idDepartment}")
    public List<Etudiant> findByDep(@PathVariable int idDepartment){
        return iEtudiantService.getEtudiantsByDepartement(idDepartment);
    }

}
