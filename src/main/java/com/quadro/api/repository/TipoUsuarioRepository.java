package com.quadro.api.repository;

import com.quadro.api.model.TIPOUSUARIO;
import com.quadro.api.model.TipoUsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoUsuarioRepository extends JpaRepository<TipoUsuarioEntity, Long> {
    TipoUsuarioEntity findByTipo(TIPOUSUARIO tipo);
}
