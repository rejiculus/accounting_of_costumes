package com.accounting_of_costumes.api.config.web;

import com.accounting_of_costumes.api.Image.Gateway.ImageDatabaseGateway;
import com.accounting_of_costumes.api.Item.Gateway.ItemDatabaseGateway;
import com.accounting_of_costumes.api.ItemState.Gateway.ItemStateDatabaseGateway;
import com.accounting_of_costumes.api.Location.DTO.GetLocationByPlaceData;
import com.accounting_of_costumes.api.Location.Gateway.LocationDatabaseGateway;
import com.accounting_of_costumes.api.Place.Controller.CreatePlaceController;
import com.accounting_of_costumes.api.Place.Gateway.PlaceDatabaseGateway;
import com.accounting_of_costumes.api.Tag.Gateway.TagDatabaseGateway;
import com.accounting_of_costumes.api.config.db.repository.*;
import com.accounting_of_costumes.entities.Image.gateway.ImageGateway;
import com.accounting_of_costumes.entities.Item.gateway.ItemGateway;
import com.accounting_of_costumes.entities.ItemState.gateway.ItemStateGateway;
import com.accounting_of_costumes.entities.Location.gateway.LocationGateway;
import com.accounting_of_costumes.entities.Location.model.Location;
import com.accounting_of_costumes.entities.Place.gateway.PlaceGateway;
import com.accounting_of_costumes.entities.Tag.gateway.TagGateway;
import com.accounting_of_costumes.usercases.Image.*;
import com.accounting_of_costumes.usercases.Item.*;
import com.accounting_of_costumes.usercases.ItemState.CreateItemStateUserCase;
import com.accounting_of_costumes.usercases.ItemState.DeleteItemStateUserCase;
import com.accounting_of_costumes.usercases.ItemState.GetAllItemStatesUserCase;
import com.accounting_of_costumes.usercases.ItemState.GetItemStateByNameUserCase;
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

    /*      ItemState       */

    @Bean
    public CreateItemStateUserCase createItemStateUserCase(ItemStateRepository itemStateRepository){
        ItemStateGateway gateway = new ItemStateDatabaseGateway(itemStateRepository);
        return new CreateItemStateUserCase(gateway);
    }

    @Bean
    public DeleteItemStateUserCase deleteItemStateUserCase(ItemStateRepository itemStateRepository){
        ItemStateGateway gateway = new ItemStateDatabaseGateway(itemStateRepository);
        return new DeleteItemStateUserCase(gateway);
    }

    @Bean
    public GetAllItemStatesUserCase getAllItemStatesUserCase(ItemStateRepository itemStateRepository){
        ItemStateGateway gateway = new ItemStateDatabaseGateway(itemStateRepository);
        return new GetAllItemStatesUserCase(gateway);
    }

    @Bean
    public GetItemStateByNameUserCase getItemStateByNameUserCase(ItemStateRepository itemStateRepository){
        ItemStateGateway gateway = new ItemStateDatabaseGateway(itemStateRepository);
        return new GetItemStateByNameUserCase(gateway);
    }

    /*      Item        */

    @Bean
    public CreateItemUserCase createItemUserCase(ItemRepository itemRepository, LocationRepository locationRepository, ItemStateRepository itemStateRepository, ImageRepository imageRepository, TagRepository tagRepository){
        ItemGateway itemGateway = new ItemDatabaseGateway(itemRepository);
        LocationGateway locationGateway = new LocationDatabaseGateway(locationRepository);
        ItemStateGateway itemStateGateway = new ItemStateDatabaseGateway(itemStateRepository);
        ImageGateway imageGateway = new ImageDatabaseGateway(imageRepository);
        TagGateway tagGateway = new TagDatabaseGateway(tagRepository);

        return new CreateItemUserCase(itemGateway, locationGateway, itemStateGateway, imageGateway, tagGateway);
    }

    @Bean
    public DeleteItemUserCase deleteItemUserCase(ItemRepository itemRepository){
        ItemGateway itemGateway = new ItemDatabaseGateway(itemRepository);
        return new DeleteItemUserCase(itemGateway);
    }

    @Bean
    public GetAllItemUserCase getAllItemUserCase(ItemRepository itemRepository){
        ItemGateway itemGateway = new ItemDatabaseGateway(itemRepository);
        return new GetAllItemUserCase(itemGateway);
    }

    @Bean
    public GetItemByArticleUserCase getItemByArticleUserCase(ItemRepository itemRepository){
        ItemGateway itemGateway = new ItemDatabaseGateway(itemRepository);
        return new GetItemByArticleUserCase(itemGateway);
    }

    @Bean
    public GetItemByIdUserCase getItemByIdUserCase(ItemRepository itemRepository){
        ItemGateway itemGateway = new ItemDatabaseGateway(itemRepository);
        return new GetItemByIdUserCase(itemGateway);
    }

    @Bean
    public GetItemByLocationUserCase getItemByLocationUserCase(ItemRepository itemRepository,LocationRepository locationRepository){
        ItemGateway itemGateway = new ItemDatabaseGateway(itemRepository);
        LocationGateway locationGateway = new LocationDatabaseGateway(locationRepository);
        return new GetItemByLocationUserCase(itemGateway, locationGateway);
    }

    @Bean
    public GetItemByNameUserCase getItemByNameUserCase(ItemRepository itemRepository){
        ItemGateway itemGateway = new ItemDatabaseGateway(itemRepository);
        return new GetItemByNameUserCase(itemGateway);
    }

    @Bean
    public GetItemByRegistrationDateUserCase getItemByRegistrationDateUserCase(ItemRepository itemRepository){
        ItemGateway itemGateway = new ItemDatabaseGateway(itemRepository);
        return new GetItemByRegistrationDateUserCase(itemGateway);
    }

    @Bean
    public GetItemByWriteOffDateUserCase getItemByWriteOffDateUserCase(ItemRepository itemRepository){
        ItemGateway itemGateway = new ItemDatabaseGateway(itemRepository);
        return new GetItemByWriteOffDateUserCase(itemGateway);
    }

    @Bean
    public GetItemByRegistrationDateBetweenUserCase getItemByRegistrationDateBetweenUserCase(ItemRepository itemRepository){
        ItemGateway itemGateway = new ItemDatabaseGateway(itemRepository);
        return new GetItemByRegistrationDateBetweenUserCase(itemGateway);
    }

    @Bean
    public GetItemByWriteOffDateBetweenUserCase getItemByWriteOffDateBetweenUserCase(ItemRepository itemRepository){
        ItemGateway itemGateway = new ItemDatabaseGateway(itemRepository);
        return new GetItemByWriteOffDateBetweenUserCase(itemGateway);
    }
    @Bean
    public UpdateItemUserCase updateItemUserCase(ItemRepository itemRepository, LocationRepository locationRepository, ItemStateRepository itemStateRepository, ImageRepository imageRepository, TagRepository tagRepository){
        ItemGateway itemGateway = new ItemDatabaseGateway(itemRepository);
        LocationGateway locationGateway = new LocationDatabaseGateway(locationRepository);
        ItemStateGateway itemStateGateway = new ItemStateDatabaseGateway(itemStateRepository);
        ImageGateway imageGateway = new ImageDatabaseGateway(imageRepository);
        TagGateway tagGateway = new TagDatabaseGateway(tagRepository);

        return new UpdateItemUserCase(itemGateway, locationGateway, itemStateGateway, imageGateway, tagGateway);
    }


    /*      Image       */

    @Bean
    public CreateImageUserCase createImageUserCase(ImageRepository imageRepository, ItemRepository itemRepository){
        ImageGateway imageGateway = new ImageDatabaseGateway(imageRepository);
        ItemGateway itemGateway = new ItemDatabaseGateway(itemRepository);
        return new CreateImageUserCase(imageGateway, itemGateway);
    }

    @Bean
    public DeleteImageUserCase deleteImageUserCase(ImageRepository imageRepository){
        ImageGateway imageGateway = new ImageDatabaseGateway(imageRepository);
        return new DeleteImageUserCase(imageGateway);
    }

    @Bean
    public GetAllImagesUserCase getAllImagesUserCase(ImageRepository imageRepository){
        ImageGateway imageGateway = new ImageDatabaseGateway(imageRepository);
        return new GetAllImagesUserCase(imageGateway);
    }

    @Bean
    public GetImageByItemUserCase getImageByItemUserCase(ImageRepository imageRepository, ItemRepository itemRepository){
        ImageGateway imageGateway = new ImageDatabaseGateway(imageRepository);
        ItemGateway itemGateway = new ItemDatabaseGateway(itemRepository);
        return new GetImageByItemUserCase(imageGateway, itemGateway);
    }

    @Bean
    public GetImageByIdUserCase getImageByIdUserCase(ImageRepository imageRepository){
        ImageGateway imageGateway = new ImageDatabaseGateway(imageRepository);
        return new GetImageByIdUserCase(imageGateway);
    }

    @Bean
    public GetImageBySourceUserCase getImageBySourceUserCase(ImageRepository imageRepository){
        ImageGateway imageGateway = new ImageDatabaseGateway(imageRepository);
        return new GetImageBySourceUserCase(imageGateway);
    }

    @Bean
    public UpdateImageUserCase updateImageUserCase(ImageRepository imageRepository, ItemRepository itemRepository){
        ImageGateway imageGateway = new ImageDatabaseGateway(imageRepository);
        ItemGateway itemGateway = new ItemDatabaseGateway(itemRepository);
        return new UpdateImageUserCase(imageGateway, itemGateway);
    }


}
