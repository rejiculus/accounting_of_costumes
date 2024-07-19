package com.accounting_of_costumes.api.config.web;

import com.accounting_of_costumes.api.Location.DTO.GetLocationByPlaceData;
import com.accounting_of_costumes.api.Location.Gateway.LocationDatabaseGateway;
import com.accounting_of_costumes.api.Place.Controller.CreatePlaceController;
import com.accounting_of_costumes.api.Place.Gateway.PlaceDatabaseGateway;
import com.accounting_of_costumes.api.Tag.Gateway.TagDatabaseGateway;
import com.accounting_of_costumes.api.config.db.repository.LocationRepository;
import com.accounting_of_costumes.api.config.db.repository.PlaceRepository;
import com.accounting_of_costumes.api.config.db.repository.TagRepository;
import com.accounting_of_costumes.entities.Location.gateway.LocationGateway;
import com.accounting_of_costumes.entities.Location.model.Location;
import com.accounting_of_costumes.entities.Place.gateway.PlaceGateway;
import com.accounting_of_costumes.entities.Tag.gateway.TagGateway;
import com.accounting_of_costumes.usercases.Location.*;
import com.accounting_of_costumes.usercases.Place.*;
import com.accounting_of_costumes.usercases.Tag.CreateTagUserCase;
import com.accounting_of_costumes.usercases.Tag.DeleteTagUserCase;
import com.accounting_of_costumes.usercases.Tag.GetAllTagsUserCase;
import com.accounting_of_costumes.usercases.Tag.GetTagUserCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MvcConfig {

    /*      Tags        */
    @Bean
    public GetAllTagsUserCase getAllTagsUserCase(TagRepository tagRepository){
        TagGateway tagGateway = new TagDatabaseGateway(tagRepository);
        return new GetAllTagsUserCase(tagGateway);
    }

    @Bean
    public CreateTagUserCase createTagUserCase(TagRepository tagRepository){
        TagGateway tagGateway = new TagDatabaseGateway(tagRepository);
        return new CreateTagUserCase(tagGateway);
    }
    @Bean
    public GetTagUserCase getTagUserCase(TagRepository tagRepository){
        TagGateway tagGateway = new TagDatabaseGateway(tagRepository);
        return new GetTagUserCase(tagGateway);
    }
    @Bean
    public DeleteTagUserCase deleteTagUserCase(TagRepository tagRepository){
        TagGateway tagGateway = new TagDatabaseGateway(tagRepository);
        return new DeleteTagUserCase(tagGateway);
    }

    /*      Places      */


    @Bean
    public CreatePlaceUserCase createPlaceUserCase(PlaceRepository placeRepository){
        PlaceGateway placeGateway = new PlaceDatabaseGateway(placeRepository);
        return new CreatePlaceUserCase(placeGateway);
    }

    @Bean
    public DeletePlaceUserCase deletePlaceUserCase(PlaceRepository placeRepository){
        PlaceGateway placeGateway = new PlaceDatabaseGateway(placeRepository);
        return new DeletePlaceUserCase(placeGateway);
    }

    @Bean
    public GetAllPlacesUserCase getAllPlacesUserCase(PlaceRepository placeRepository){
        PlaceGateway placeGateway = new PlaceDatabaseGateway(placeRepository);
        return new GetAllPlacesUserCase(placeGateway);
    }

    @Bean
    public GetPlaceByIdUserCase getPlaceByIdUserCase(PlaceRepository placeRepository){
        PlaceGateway placeGateway = new PlaceDatabaseGateway(placeRepository);
        return new GetPlaceByIdUserCase(placeGateway);
    }

    @Bean
    public GetPlaceByNameUserCase getPlaceByNameUserCase(PlaceRepository placeRepository){
        PlaceGateway placeGateway = new PlaceDatabaseGateway(placeRepository);
        return new GetPlaceByNameUserCase(placeGateway);
    }

    @Bean
    public UpdatePlaceUserCase updatePlaceUserCase(PlaceRepository placeRepository){
        PlaceGateway placeGateway = new PlaceDatabaseGateway(placeRepository);
        return new UpdatePlaceUserCase(placeGateway);
    }

    /*      Locations       */
    @Bean
    public CreateLocationUserCase createLocationUserCase(LocationRepository locationRepository,PlaceRepository placeRepository){
        LocationGateway locationGateway = new LocationDatabaseGateway(locationRepository);
        PlaceGateway placeGateway = new PlaceDatabaseGateway(placeRepository);
        return new CreateLocationUserCase(locationGateway, placeGateway);
    }

    @Bean
    public DeleteLocationUserCase deleteLocationUserCase(LocationRepository locationRepository){
        LocationGateway locationGateway = new LocationDatabaseGateway(locationRepository);
        return new DeleteLocationUserCase(locationGateway);
    }

    @Bean
    public GetAllLocationsUserCase getAllLocationsUserCase(LocationRepository locationRepository){
        LocationGateway locationGateway = new LocationDatabaseGateway(locationRepository);
        return new GetAllLocationsUserCase(locationGateway);
    }

    @Bean
    public GetLocationByIdUserCase getLocationByIdUserCase(LocationRepository locationRepository){
        LocationGateway locationGateway = new LocationDatabaseGateway(locationRepository);
        return new GetLocationByIdUserCase(locationGateway);
    }

    @Bean
    public GetLocationByPlaceUserCase getLocationByPlaceUserCase(LocationRepository locationRepository,PlaceRepository placeRepository){
        LocationGateway locationGateway = new LocationDatabaseGateway(locationRepository);
        PlaceGateway placeGateway = new PlaceDatabaseGateway(placeRepository);
        return new GetLocationByPlaceUserCase(locationGateway, placeGateway);
    }

    @Bean
    public GetLocationByRouteUserCase getLocationByRouteUserCase(LocationRepository locationRepository){
        LocationGateway locationGateway = new LocationDatabaseGateway(locationRepository);
        return new GetLocationByRouteUserCase(locationGateway);
    }

    @Bean
    public UpdateLocationUserCase updateLocationUserCase(LocationRepository locationRepository,PlaceRepository placeRepository){
        LocationGateway locationGateway = new LocationDatabaseGateway(locationRepository);
        PlaceGateway placeGateway = new PlaceDatabaseGateway(placeRepository);
        return new UpdateLocationUserCase(locationGateway, placeGateway);
    }

}
