package com.accounting_of_costumes.usercases.Tag;

import com.accounting_of_costumes.api.config.db.schema.ItemSchema;
import com.accounting_of_costumes.api.config.db.schema.TagSchema;
import com.accounting_of_costumes.entities.Tag.gateway.TagGateway;
import com.accounting_of_costumes.entities.Tag.model.Tag;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class TestData implements TagGateway {
    private static TestData instance;

    public static TestData getTestDataInstance(){
        if(instance==null)
            instance=new TestData();
        return instance;
    }
    private TestData(){}
    Set<TagSchema> tags = new HashSet<>(Set.of(
            new TagSchema("test 1"),
            new TagSchema("test 2",Set.of(new ItemSchema(0L)))
    ));

    public void setTags(Set<Tag> tags){
        this.tags = tags.stream()
                .map(TagSchema::new)
                .collect(Collectors.toSet());
    }

    public List<Tag> getTagList(){
        return this.tags.stream()
                .map(TagSchema::toTag)
                .collect(Collectors.toList());
    }


    @Override
    public Tag create(Tag tag) {
        TagSchema tagSchema = new TagSchema(tag);
        tags.add(tagSchema);
        return tagSchema.toTag();
    }

    @Override
    public Tag update(Tag tag) {
        TagSchema tagSchema = new TagSchema(tag);
        tags.add(tagSchema);
        return tagSchema.toTag();
    }

    @Override
    public void delete(Tag tag) {
        TagSchema tagSchema = new TagSchema(tag);
        tags.remove(tagSchema);

    }

    @Override
    public Optional<Tag> findByName(String name) {
        for(TagSchema tag: tags ){
            if(tag.getName().equals(name))
                return Optional.of(tag.toTag());
        }
        return Optional.empty();
    }

    @Override
    public List<Tag> findAll() {
        return tags.stream()
                .map(TagSchema::toTag)
                .collect(Collectors.toList());
    }
}

