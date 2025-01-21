package com.project.searchservice.documents;

import com.project.searchservice.enums.AccountStatus;
import com.project.searchservice.enums.AccountVisibility;
import com.project.searchservice.enums.Gender;
import jakarta.persistence.Id;
import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Document(indexName = "user_entity")
@Data
public class UserEntityDocument {
    @Id
    private String id;

    @Field(type = FieldType.Text)
    private String username;

    @Field(type = FieldType.Text)
    private String email;

    @Field(type = FieldType.Keyword)
    private String userEntityId;

    @Field(type = FieldType.Text)
    private String phone;

    @Field(type = FieldType.Text)
    private String firstName;

    @Field(type = FieldType.Text)
    private String lastName;

    @Field(type = FieldType.Text)
    private String biography;

    @Field(type = FieldType.Text)
    private String profilePicture;

    @Field(type = FieldType.Text)
    private String website;

    @Field(type = FieldType.Boolean)
    private boolean emailVerified;

    @Field(type = FieldType.Keyword)
    private Gender gender;

    @Field(type = FieldType.Keyword)
    private AccountVisibility accountVisibility;

    @Field(type = FieldType.Keyword)
    private AccountStatus accountStatus;
}