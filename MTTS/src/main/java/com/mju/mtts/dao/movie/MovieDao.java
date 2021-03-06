package com.mju.mtts.dao.movie;

import java.util.List;

import com.mju.mtts.vo.movie.FameLine;
import com.mju.mtts.vo.movie.Genre;
import com.mju.mtts.vo.movie.Movie;
import com.mju.mtts.vo.movie.Picture;
import com.mju.mtts.vo.movie.Review;
import com.mju.mtts.vo.movie.Staff;
import com.mju.mtts.vo.movie.Video;

public interface MovieDao {
	
	List<Movie> selectAll(Movie param);
	Movie selectDetail(Movie param);
	Double getGrade(String param);
	List<Genre> getGenre(Movie param);
	List<String> getCountry(String param);
	String getRate(String param);
	
	List<Movie> getGenreMovie(Movie param);
	
	List<Staff> getMovieActor(Movie param);
	List<Staff> getMovieDirector(Movie param);
	
	List<Picture> getMoviePicture(Movie param);
	List<Picture> getMoviePoster(Movie param);
	
	List<Review> getMovieReview(Movie param);
	List<Video> getMovieVideo(Movie param);

	List<FameLine> getMovieFameLine(Movie param);
}
