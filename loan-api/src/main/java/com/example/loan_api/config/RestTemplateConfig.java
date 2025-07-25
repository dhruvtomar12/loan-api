//package com.example.loan_api.config;
//
//import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
//import org.apache.hc.client5.http.impl.classic.HttpClients;
//import org.apache.hc.client5.http.ssl.NoopHostnameVerifier;
//import org.apache.hc.core5.ssl.SSLContexts;
//import org.apache.hc.core5.ssl.TrustStrategy;
//import org.apache.hc.client5.http.ssl.DefaultClientTlsStrategy;
//import org.apache.hc.client5.http.impl.io.PoolingHttpClientConnectionManagerBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
//import org.springframework.web.client.RestTemplate;
//
//import javax.net.ssl.SSLContext;
//import java.security.cert.X509Certificate;
//
//@Configuration
//public class RestTemplateConfig {
//
//    @Bean
//    public RestTemplate restTemplate() throws Exception {
//        // Trust all certificates
//        SSLContext sslContext = SSLContexts.custom()
//                .loadTrustMaterial(null, (TrustStrategy) (X509Certificate[] chain, String authType) -> true)
//                .build();
//
//        // Set up TLS strategy with no hostname verification
//        var tlsStrategy = new DefaultClientTlsStrategy(sslContext, NoopHostnameVerifier.INSTANCE);
//
//        // Connection manager with TLS strategy
//        var connManager = PoolingHttpClientConnectionManagerBuilder.create()
//                .setTlsStrategy(tlsStrategy)
//                .build();
//
//        // Build the client
//        CloseableHttpClient httpClient = HttpClients.custom()
//                .setConnectionManager(connManager)
//                .build();
//
//        // Return RestTemplate with the custom HTTP client
//        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory(httpClient);
//        return new RestTemplate(factory);
//    }
//}
