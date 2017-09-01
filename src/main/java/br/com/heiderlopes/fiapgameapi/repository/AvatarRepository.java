package br.com.heiderlopes.fiapgameapi.repository;

import br.com.heiderlopes.fiapgameapi.model.Avatar;
import br.com.heiderlopes.fiapgameapi.model.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AvatarRepository extends MongoRepository<Avatar, String> {

    Avatar findByUsername(String username);

}
