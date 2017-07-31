package com.zor07.services;

import com.zor07.domain.Source;
import com.zor07.domain.User;
import com.zor07.repositories.SourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SourceService implements DomainService<Source>{
    private SourceRepository repository;

    @Autowired
    public void setRepository(SourceRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Source> list(User user) {
        return repository.findAll().stream()
                .filter(category -> user.equals(category.getUser()))
                .collect(Collectors.toList());
    }

    @Override
    public Source getById(Integer id) {
        return repository.getOne(id);
    }

    @Override
    public Source save(Source obj) {
        return repository.save(obj);
    }

    @Override
    public void delete(Integer id) {
        repository.delete(id);
    }

}
