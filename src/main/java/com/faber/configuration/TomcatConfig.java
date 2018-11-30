package com.faber.configuration;

//<editor-fold defaultstate="collapsed" desc="IMPORT">
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
//</editor-fold>

/**
 *
 * @author Nguyen Duc Thien
 * @email nguyenducthien@fabercompany.co.jp
 */
@Configuration
public class TomcatConfig {

    @Bean
    public ConfigurableServletWebServerFactory webServerFactory() {
        TomcatServletWebServerFactory factory = new TomcatServletWebServerFactory();
        /* Use Http11Nio2Protocol instead of Http11NioProtocol for better performance */
        factory.setProtocol("org.apache.coyote.http11.Http11Nio2Protocol");
        factory.setPort(9000);
        factory.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND, "/notfound.html"));
        return factory;
    }
}
