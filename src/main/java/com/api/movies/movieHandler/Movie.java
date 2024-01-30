package com.api.movies.movieHandler;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.util.Date;
import java.util.List;

@Document(collection = "movies")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Movie {

    @Id
    private String id;

//    private String _id;

    private String imdbId;

    private String title;

    private String releaseDate;

    private String trailerLink;

    private List<String> genres;
    private String poster;

//    @CreatedDate
//    private Date createdAt;
//
//    @LastModifiedDate
//    private Date updatedAt;

    @DBRef
    private List<String> backdrops;

    private List<ObjectId> reviewIds;

    public List<ObjectId> getReviewIds(){
        return reviewIds;
    }

}
