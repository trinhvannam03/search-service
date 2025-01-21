package com.project.searchservice.repositories;

import com.project.searchservice.documents.UserEntityDocument;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserEntityDocRepository extends ElasticsearchRepository<UserEntityDocument, String> {

}
