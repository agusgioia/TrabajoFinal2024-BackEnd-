package com.PersonalizaTuViaje.PersonalizaTuViaje.Controller;

import com.PersonalizaTuViaje.PersonalizaTuViaje.LogicaDeNegocio.Usuario;
import com.PersonalizaTuViaje.PersonalizaTuViaje.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/user")
@CrossOrigin("http://localhost:4200/")
public class UserController {

    @Autowired
    private UserService service;

    @RequestMapping(value = "/lista", method = RequestMethod.GET)
    public ResponseEntity ListaUsuarios() {
        return new ResponseEntity(service.ListaUsuarios(), HttpStatus.OK);
    }

    @RequestMapping(value = "/nuevo", method = RequestMethod.POST)
    public ResponseEntity NuevoUsuario(@RequestBody Usuario usuario) {
        return new ResponseEntity(service.NuevoUsuario(usuario), HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}/editar", method = RequestMethod.PUT)
    public ResponseEntity EditarUsuario(@PathVariable(value = "id") String id, @RequestBody Usuario usuario) {
        return new ResponseEntity(service.EditarUsuario(id,usuario), HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}/borrar",method = RequestMethod.DELETE)
    public ResponseEntity EliminarUsuario(@PathVariable(value = "id")String id){
        return new ResponseEntity(service.EliminarUsuario(id),HttpStatus.OK);
    }
}
