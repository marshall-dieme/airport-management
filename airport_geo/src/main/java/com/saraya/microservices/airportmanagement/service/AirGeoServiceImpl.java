package com.saraya.microservices.airportmanagement.service;



import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.saraya.microservices.airportmanagement.model.Airport_Geo;
import com.saraya.microservices.airportmanagement.model.Airport_Geo_DTO;
import com.saraya.microservices.airportmanagement.repository.AirGeoRepository;


@Service
public class AirGeoServiceImpl implements AirGeoService {

	@Autowired
	private final AirGeoRepository airGeoRepository;
	
	public AirGeoServiceImpl(AirGeoRepository airGeoRepository) {
		this.airGeoRepository = airGeoRepository;
	}

	@Override
	public List<Airport_Geo> listAirpGeo() {
		return airGeoRepository.findAll();
	}

	@Override
	public Airport_Geo createAirportGeo(Airport_Geo_DTO dto) {
    	Airport_Geo airport_Geo = new Airport_Geo();
    	airport_Geo.setCountry(dto.getCountry());
		airport_Geo.setCity(dto.getCity());
        airport_Geo.setAirport_geo_id(dto.getAirport_geo_id());   
            return airGeoRepository.save(airport_Geo);
             
        
//        RestTemplate template = new RestTemplate();
//        Map<String, String> urlValues = new HashMap<>();
//        urlValues.put("name", dto.getAirp());
//        String airport_id = template.getForEntity(
//                "http://localhost:8800/airport/name/{name}",
//                        String.class,
//                        urlValues)
//                        .getBody();
      //  changeToModel(dto, airport_Geo);
     //   airport_Geo.setAirport_id(airport_id);;
	//	return airGeoRepository.save(dto);
	}

//
//	private static void changeToModel(Airport_Geo_DTO dto, Airport_Geo airport_Geo) {
//		airport_Geo.setCountry(dto.getCity());
//		airport_Geo.setCity(dto.getCity());
//        airport_Geo.setAirport_geo_id(dto.getAirport_geo_id());     
//	}

	@Override
	public Airport_Geo updateAirportGeo(Airport_Geo_DTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteAirportGeo(Long airport_Geo_id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getIdAirport(String name) {
		// TODO Auto-generated method stub
		return null;
	}
		
	

}
