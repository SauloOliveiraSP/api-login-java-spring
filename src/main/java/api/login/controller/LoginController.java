package api.login.controller;

import api.login.model.UsuarioModel;
import api.login.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/{email}")
    public ResponseEntity<String> loginUsuario(@PathVariable String email, @RequestBody String senha) {
        UsuarioModel usuario = usuarioService.loginUsuario(email, senha);
        if (usuario != null) {
            return ResponseEntity.ok("Login realizado.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não cadastrado.");
        }
    }
}
