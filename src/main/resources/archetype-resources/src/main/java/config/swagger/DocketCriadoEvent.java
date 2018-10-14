#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.config.swagger;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;
import springfox.documentation.spring.web.plugins.Docket;

@Getter
public class DocketCriadoEvent extends ApplicationEvent {

    private static final long serialVersionUID = 1L;

    private final Docket docket;

    public DocketCriadoEvent(Object source, Docket docket) {
        super(source);
        this.docket = docket;
    }
}
