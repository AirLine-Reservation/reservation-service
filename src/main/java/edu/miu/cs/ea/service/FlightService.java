package edu.miu.cs.ea.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import edu.miu.cs.ea.domain.Flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.support.BasicAuthorizationInterceptor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class FlightService {

    @Autowired
    private RestTemplate restTemplate;
    @Qualifier("eurekaClient")
    @Autowired
    private EurekaClient eurekaClient;
    private String EaFinalProjectServiceName = "admin-service";
    public List<Flight> getAllFlights(List<Integer> ids){
        restTemplate.getInterceptors().add(
                new BasicAuthorizationInterceptor("admin", "354eb0af-082d-4f37-adce-5baa0199801d"));

//        ParameterizedTypeReference<List<Flight>> typeRef = new ParameterizedTypeReference<List<Flight>>() {
//        };
//        ResponseEntity<List<Flight>> responseEntity =restTemplate.
//                postForObject(lookupUrlFor(EaFinalProjectServiceName) + "/flights/list",flights, HttpMethod.POST,new HttpEntity<>(mvm), typeRef);
//
//        List<Flight> fs = responseEntity.getBody();
        //airPortListCache = Arrays.asList(restTemplate.exchange(url, HttpMethod.GET, createHttpEntity(), AirPort[].class).getBody());

        List<Flight>
        flights = Arrays.asList(restTemplate.postForObject(lookupUrlFor(EaFinalProjectServiceName) + "/flights/list",ids,
                Flight[].class));
        System.out.println("####### "+flights);

//        String url=lookupUrlFor(EaFinalProjectServiceName) + "/flights/list";
//
//        List<Flight> cityList = Arrays.asList(restTemplate.exchange(url, HttpMethod.POST, createHttpEntity(ids),
//                Flight[].class).getBody());
//        System.out.println(cityList);

        return flights;
       //return  restTemplate.exchange(lookupUrlFor(EaFinalProjectServiceName) + "/flights/list", HttpMethod.GET, createHttpEntity(flights), List.class);
        //List<Flight>[] fs=restTemplate.postForObject(lookupUrlFor(EaFinalProjectServiceName) + "/flights/list",flights, List[].class);

        //return fs;
    }
    private String lookupUrlFor(String appName) {
        InstanceInfo instanceInfo = eurekaClient.getNextServerFromEureka(appName, false);
        return instanceInfo.getHomePageUrl();
    }
    private HttpEntity<Object> createHttpEntity(List<Integer> flights) {
        HttpEntity<List<Integer>> request = new HttpEntity<>(flights);

        return new HttpEntity<>(request);
    }
}
