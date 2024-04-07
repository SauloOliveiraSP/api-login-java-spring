package api.login.service;

import api.login.model.UsuarioModel;

public interface LoginService {
    UsuarioModel buscarPorId(Long id);
}
