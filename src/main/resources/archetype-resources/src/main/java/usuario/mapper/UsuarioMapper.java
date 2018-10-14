#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.usuario.mapper;

import ${package}.interfaces.mapper.BaseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import ${package}.usuario.entity.Usuario;
import ${package}.usuario.rest.v1.dto.UsuarioDTO;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UsuarioMapper extends BaseMapper<Usuario, UsuarioDTO> {


}
