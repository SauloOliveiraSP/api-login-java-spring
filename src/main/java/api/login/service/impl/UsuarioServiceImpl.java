package api.login.service.impl;

import api.login.model.EnderecoModel;
import api.login.model.UsuarioModel;
import api.login.repository.EnderecoRepository;
import api.login.repository.LoginRepository;
import api.login.repository.UsuarioRepository;
import api.login.service.UsuarioService;
import api.login.service.ViaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    // Singleton: Injetar os componentes do Spring com @Autowired.
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private EnderecoRepository enderecoRepository;
    @Autowired
    private ViaCepService viaCepService;
    @Autowired
    private LoginRepository loginRepository;

    // Strategy: Implementar os métodos definidos na interface.
    // Facade: Abstrair integrações com subsistemas, provendo uma interface simples.

    @Override
    public Iterable<UsuarioModel> buscarTodos() {
        // Buscar todos os usuários.
        return usuarioRepository.findAll();
    }

    @Override
    public UsuarioModel buscarPorId(Long id) {
        // Buscar Usuario por ID.
        Optional<UsuarioModel> usuario = usuarioRepository.findById(id);
        return usuario.get();
    }

    @Override
    public void inserir(UsuarioModel usuarioModel) {
        salvarUsuarioComCep(usuarioModel);
    }

    @Override
    public void atualizar(Long id, UsuarioModel usuarioModel) {
        // Buscar Usuario por ID, caso exista:
        Optional<UsuarioModel> usuarioBd = usuarioRepository.findById(id);
        if (usuarioBd.isPresent()) {
            salvarUsuarioComCep(usuarioModel);
        }
    }

    @Override
    public void deletar(Long id) {
        // Deletar Usuario por ID.
        usuarioRepository.deleteById(id);
    }

    @Override
    public UsuarioModel loginUsuario(String email, String senha) {
        return loginRepository.findByEmailAndSenha(email, senha);
    }

    private void salvarUsuarioComCep(UsuarioModel usuarioModel) {
        // Verificar se o Endereco do Usuario já existe (pelo CEP).
        String cep = usuarioModel.getEndereco().getCep();
        EnderecoModel endereco = enderecoRepository.findById(cep).orElseGet(() -> {
            // Caso não exista, integrar com o ViaCEP e persistir o retorno.
            EnderecoModel novoEndereco = viaCepService.consultarCep(cep);
            enderecoRepository.save(novoEndereco);
            return novoEndereco;
        });
        usuarioModel.setEndereco(endereco);
        // Inserir Usuario, vinculando o Endereco (novo ou existente).
        usuarioRepository.save(usuarioModel);
    }

}