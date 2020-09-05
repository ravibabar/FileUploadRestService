package com.example.interv.demo;
import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.util.UriComponentsBuilder;
 
 
@SpringBootTest
public class SpringBootDemoApplicationTests 
{
	
	
    @Autowired
    private TestRestTemplate restTemplate;
     
   // @Test
    public void testFileUpload() throws URISyntaxException 
    {
        final String baseUrl = "http://localhost:"+8080+"/";
        URI uri = new URI(baseUrl);
        
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);  
        
        
        MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
        body.add("data",new File("abc.csv"));
        body.add("column", "number");
      
       HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(body, headers);

 
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(baseUrl)
                .queryParam("data", 1)
                .queryParam("number", 10);
        
        HttpEntity<String> response = restTemplate.exchange(
                builder.build().encode().toUri(), 
                HttpMethod.POST, requestEntity,
                String.class);
        
        //Verify request succeed
      //  Assert.assertEquals("42.0", response.getBody());
    }
     
 
 
}
