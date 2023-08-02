package com.br.estudos.Api.controllers;

import java.lang.reflect.InvocationTargetException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.estudos.Api.DAOs.IProfissionalRepository;
import com.br.estudos.Api.DTOs.ProfissionalDTO;
import com.br.estudos.Api.DTOs.ProfissionalMinimoDTO;
import com.br.estudos.Api.modelView.ErroModelView;
import com.br.estudos.Api.models.Profissional;
import com.br.estudos.Api.servicos.BuilderDTOModel;
import com.br.estudos.Api.servicos.GenericBuilderDTOModel;

@RestController
@RequestMapping("/profissionais")
public class ProfissionaisController {

    @Autowired
    private IProfissionalRepository repo;

    @GetMapping
    public ResponseEntity<Iterable<Profissional>> index(){
        var profissionais = repo.findAll();
        return ResponseEntity.status(200).body(profissionais);
    }    

    @PostMapping
    public ResponseEntity<Object> criar(@RequestBody ProfissionalDTO profissionalDTO) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException, NoSuchMethodException, SecurityException{ 
        var profissional = (Profissional)BuilderDTOModel.build(profissionalDTO, new Profissional());
        repo.save(profissional);
        return ResponseEntity.status(201).body(profissional);
    } 

    @PutMapping("/{id}")
    public ResponseEntity<Object> alterar(@PathVariable int id, @RequestBody ProfissionalDTO profissionalDTO) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException, NoSuchMethodException, SecurityException{
        if(!repo.existsById(id)){            
            return ResponseEntity.status(404).body(new ErroModelView("Profissonal não Encontrado"));
        }
       
        var profissional = (Profissional)BuilderDTOModel.build(profissionalDTO, repo.findById(id).get());
        repo.save(profissional);
        return ResponseEntity.status(200).body(profissional);
    } 

    @PatchMapping("/{id}")
    public ResponseEntity<Object> alterarParte(@PathVariable int id, @RequestBody ProfissionalMinimoDTO profissionalMinimoDTO) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException, NoSuchMethodException, SecurityException{        
        if(!repo.existsById(id)){            
            return ResponseEntity.status(404).body(new ErroModelView("Profissonal não Encontrado"));
        }

        var profissional = new GenericBuilderDTOModel<Profissional>(Profissional.class).build(profissionalMinimoDTO, repo.findById(id).get());
        repo.save(profissional);
        return ResponseEntity.status(200).body(profissional);
    }    

    @GetMapping("/{id}")
    public ResponseEntity<Object> mostrar(@PathVariable int id){             
        var profissionalOption = repo.findById(id);        

        if(profissionalOption.isEmpty()){            
            return ResponseEntity.status(404).body(new ErroModelView("Profissonal não Encontrado"));
        }
        return ResponseEntity.status(200).body(profissionalOption.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> excluir(@PathVariable int id){                   

        if(!repo.existsById(id)){            
            return ResponseEntity.status(404).body(new ErroModelView("Profissonal não Encontrado"));
        }        
        repo.deleteById(id);

        return ResponseEntity.status(204).body("");
    }    

}
