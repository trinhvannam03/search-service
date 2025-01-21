package com.project.searchservice.controllers;


import com.project.searchservice.documents.UserEntityDocument;
import com.project.searchservice.services.SearchUserEntityDocumentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/search/users")
@RequiredArgsConstructor
public class UserEntityDocumentController {
    private final SearchUserEntityDocumentService searchUserEntityDocumentService;

}
