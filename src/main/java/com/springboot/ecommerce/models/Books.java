package com.springboot.ecommerce.models;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "Books")
public class Books {

	@Id
	private ObjectId _id;
	@Field("book_id")
	@Indexed(unique = true)
	@NotNull
	private Integer bookId;
	private String authors;
	@Field("original_publication_year")
	private Integer originalPublicationYear;
	@NotBlank
	private String title;
	@Field("language_code")
	private String languageCode;
	@Field("average_rating")
	private Float averageRating;
	@Field("ratings_count")
	private Long ratingsCount;
	@Field("work_text_reviews_count")
	private Long TextReviewsCount;
	@Field("ratings_1")
	private Long ratings1;
	@Field("ratings_2")
	private Long ratings2;
	@Field("ratings_3")
	private Long ratings3;
	@Field("ratings_4")
	private Long ratings4;
	@Field("ratings_5")
	private Long ratings5;
	@Field("image_url")
	private String imageURL;
	@Field("small_image_url")
	private String smallImageURL;

	public Integer getBookId() {
		return bookId;
	}
	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}
	public String getAuthors() {
		return authors;
	}
	public void setAuthors(String authors) {
		this.authors = authors;
	}
	public Integer getOriginalPublicationYear() {
		return originalPublicationYear;
	}
	public void setOriginalPublicationYear(Integer originalPublicationYear) {
		this.originalPublicationYear = originalPublicationYear;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getLanguageCode() {
		return languageCode;
	}
	public void setLanguageCode(String languageCode) {
		this.languageCode = languageCode;
	}
	public Float getAverageRating() {
		return averageRating;
	}
	public void setAverageRating(Float averageRating) {
		this.averageRating = averageRating;
	}
	public Long getRatingsCount() {
		return ratingsCount;
	}
	public void setRatingsCount(Long ratingsCount) {
		this.ratingsCount = ratingsCount;
	}
	public Long getTextReviewsCount() {
		return TextReviewsCount;
	}
	public void setTextReviewsCount(Long textReviewsCount) {
		TextReviewsCount = textReviewsCount;
	}
	public Long getRatings1() {
		return ratings1;
	}
	public void setRatings1(Long ratings1) {
		this.ratings1 = ratings1;
	}
	public Long getRatings2() {
		return ratings2;
	}
	public void setRatings2(Long ratings2) {
		this.ratings2 = ratings2;
	}
	public Long getRatings3() {
		return ratings3;
	}
	public void setRatings3(Long ratings3) {
		this.ratings3 = ratings3;
	}
	public Long getRatings4() {
		return ratings4;
	}
	public void setRatings4(Long ratings4) {
		this.ratings4 = ratings4;
	}
	public Long getRatings5() {
		return ratings5;
	}
	public void setRatings5(Long ratings5) {
		this.ratings5 = ratings5;
	}
	public String getImageURL() {
		return imageURL;
	}
	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}
	public String getSmallImageURL() {
		return smallImageURL;
	}
	public void setSmallImageURL(String smallImageURL) {
		this.smallImageURL = smallImageURL;
	}
	
}
