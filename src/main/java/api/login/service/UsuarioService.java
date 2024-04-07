package api.login.service;

import api.login.model.UsuarioModel;

public interface UsuarioService {
    Iterable<UsuarioModel> buscarTodos();

    UsuarioModel buscarPorId(Long id);

    void inserir(UsuarioModel cliente);

    void atualizar(Long id, UsuarioModel cliente);

    void deletar(Long id);

    UsuarioModel loginUsuario(String email, String senha);
}
