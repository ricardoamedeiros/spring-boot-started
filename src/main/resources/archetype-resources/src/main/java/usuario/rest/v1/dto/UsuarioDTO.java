#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.usuario.rest.v1.dto;

import lombok.Data;

@Data
public class UsuarioDTO {
	
	private Long id;

    private String nome;

    private Integer idade;
}
