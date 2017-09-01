package br.com.heiderlopes.fiapgameapi.repository;

import br.com.heiderlopes.fiapgameapi.model.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends MongoRepository<Usuario, String> {

    Usuario findByUsernameAndPassword(String username, String password);
    Usuario findByUsername(String username);

}
