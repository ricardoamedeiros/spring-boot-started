#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.usuario.rest.v1;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import ${package}.usuario.entity.Usuario;
import ${package}.usuario.mapper.UsuarioMapper;
import ${package}.usuario.rest.v1.dto.UsuarioDTO;
import ${package}.usuario.service.UsuarioService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;


@RestController
@RequestMapping("/v1/usuarios")
@Api(value = "usuarios", description = "Operações sobre usuários", tags = "Usuário")
public class UsuarioRest {

    private final UsuarioMapper usuarioMapper;
	private final UsuarioService usuarioService;


	public UsuarioRest(UsuarioService usuarioService, UsuarioMapper usuarioMapper) {
		super();
		this.usuarioMapper = usuarioMapper;
		this.usuarioService = usuarioService;
	}

	@PostMapping
	@ApiOperation(value = "Adiciona um usuário")
	public ResponseEntity<Void> adicionarUsuario(
			@ApiParam(name = "usuario", value = "Representação do usuário a ser adicionado", required = true)
			@Valid @RequestBody UsuarioDTO dto) {
		Usuario novoUsuario = usuarioMapper.toEntity(dto);
		novoUsuario = usuarioService.adicionarUsuario(novoUsuario);
		UsuarioDTO usuarioCriado = usuarioMapper.toDto(novoUsuario);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path(
				"/{id}").buildAndExpand(usuarioCriado.getId()).toUri();
		return ResponseEntity.created(location).build();
	}

}
