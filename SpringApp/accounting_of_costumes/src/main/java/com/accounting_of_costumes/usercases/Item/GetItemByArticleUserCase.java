package com.accounting_of_costumes.usercases.Item;

import com.accounting_of_costumes.entities.Item.gateway.ItemGateway;
import com.accounting_of_costumes.entities.Item.model.Item;

import java.util.List;

public class GetItemByArticleUserCase {
    private ItemGateway itemGateway;

    public GetItemByArticleUserCase(ItemGateway itemGateway) {
        this.itemGateway = itemGateway;
    }

    public List<Item> execute(String article){
        return this.itemGateway.findByArticle(article);
    }
}
