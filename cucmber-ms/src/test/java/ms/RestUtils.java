package ms;

import lombok.Data;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

public class RestUtils<T> {

    final RestTemplate restTemplate = new RestTemplate();

    final Class<T> typeParameterClass;
    final String url;

    public RestUtils(Class<T> typeParameterClass, String url) {
        this.typeParameterClass = typeParameterClass;
        this.url = url;
    }

    private HttpEntity<T> createHttpEntityBodyAndHeaders(T t, Header header) {
        HttpHeaders headers = getHttpHeaders(header);
        return new HttpEntity<>(t, headers);
    }

    private HttpEntity<T> createHttpEntityHeaders(Header header) {
        HttpHeaders headers = getHttpHeaders(header);
        return new HttpEntity<>(headers);
    }

    private HttpHeaders getHttpHeaders(Header header) {
        HttpHeaders headers = new HttpHeaders();
        headers.set(header.getName(), header.getValue());
        return headers;
    }

    public ResponseEntity<T> post(T t, Header header) {
        try {
            ResponseEntity<T> response =
                    restTemplate.exchange(
                            url,
                            HttpMethod.POST,
                            createHttpEntityBodyAndHeaders(t, header),
                            typeParameterClass);

            return response;

        } catch (RestClientException e) {
            e.printStackTrace();
        }

        return null;
    }

    public T get(Header header) {

        ResponseEntity<T> response = null;
        try {
            response = restTemplate.exchange(
                    url,
                    HttpMethod.GET,
                    createHttpEntityHeaders(header),
                    typeParameterClass);
        } catch (RestClientException e) {
            e.printStackTrace();
        }

        return response.getBody();
    }

    @Data
    public static class Header {

        String name;
        String value;

        public Header(String name, String value) {
            this.name = name;
            this.value = value;
        }
    }

    public static class UserIdHeader extends Header {
        public UserIdHeader(String value) {
            super("nim_userid", value);
        }
    }
}