package com.project.searchservice.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.project.searchservice.documents.UserEntityDocument;
import com.project.searchservice.enums.AccountStatus;
import com.project.searchservice.enums.AccountVisibility;
import com.project.searchservice.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserEntityDTO {
    private String userEntityId;
    private String username;
    private String email;
    private String phone;
    private String firstName;
    private String lastName;
    private String fullName;
    private String profilePicture;
    private String biography;
    private boolean emailVerified;
    private Gender gender;
    private String website;
    private AccountVisibility accountVisibility;
    private AccountStatus accountStatus;

    public UserEntityDocument toDocument() {
        UserEntityDocument userEntityDocument = new UserEntityDocument();
        userEntityDocument.setId(userEntityId);
        userEntityDocument.setUserEntityId(userEntityId);
        userEntityDocument.setUsername(username);
        userEntityDocument.setEmail(email);
        userEntityDocument.setPhone(phone);
        userEntityDocument.setFirstName(firstName);
        userEntityDocument.setLastName(lastName);
        userEntityDocument.setBiography(biography);
        userEntityDocument.setProfilePicture(profilePicture);
        userEntityDocument.setWebsite(website);
        userEntityDocument.setEmailVerified(emailVerified);
        userEntityDocument.setGender(gender);
        userEntityDocument.setAccountVisibility(accountVisibility);
        userEntityDocument.setAccountStatus(accountStatus);
        return userEntityDocument;
    }
}
