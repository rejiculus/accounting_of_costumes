package com.accounting_of_costumes.api.Item.Controller;

import com.accounting_of_costumes.usercases.Item.GetItemByArticleUserCase;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetItemByArticleController {
    private GetItemByArticleUserCase userCase;

    public GetItemByArticleController(GetItemByArticleUserCase userCase) {
        this.userCase = userCase;
    }

    @GetMapping("/items/?article={article}")
    public String getItemByArticle(@PathVariable String article){
        return this.userCase.execute(article).toString();
    }
}
