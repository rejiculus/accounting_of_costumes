package com.accounting_of_costumes.api.Tag.Gateway;

import com.accounting_of_costumes.api.config.db.repository.TagRepository;
import com.accounting_of_costumes.entities.Tag.gateway.TagGateway;
import com.accounting_of_costumes.api.config.db.schema.TagSchema;
import com.accounting_of_costumes.entities.Tag.model.Tag;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class TagDatabaseGateway implements TagGateway {
    private final TagRepository repository;

    public TagDatabaseGateway(TagRepository tagRepository){
        this.repository = tagRepository;
    }
    /*todo
        переделать в формат adminRepository.save(new AdminSchema(admin)).toAdmin();
        вынести схемы в infrastructure создать в entities правильные модели
     */

    @Override
    public Tag create(Tag tag) {
        return repository.save(new TagSchema(tag)).toTag();
    }

    @Override
    public Tag update(Tag tag) {
        return repository.save(new TagSchema(tag)).toTag();
    }

    @Override
    public void delete(Tag tag) {
        repository.deleteById(tag.getName());

    }

    @Override
    public Optional<Tag> findByName(String name) {
        return Optional.of(repository.findByName(name).toTag());
    }

    @Override
    public List<Tag> findAll() {
        return repository.findAll().stream()
                .map(TagSchema::toTag)
                .collect(Collectors.toList());
    }
}
