package com.application.demo.BookMyShow.dtos.request;
import com.application.demo.BookMyShow.enums.Genre;
import com.application.demo.BookMyShow.enums.Language;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RequestMoviedto {
    String moviename;
    int duration;
    double rating;
    Language language;
    Genre genre;
}
