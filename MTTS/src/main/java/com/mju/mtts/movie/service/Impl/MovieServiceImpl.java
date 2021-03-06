package com.mju.mtts.movie.service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mju.mtts.dao.movie.MovieDao;
import com.mju.mtts.movie.service.MovieService;
import com.mju.mtts.vo.movie.FameLine;
import com.mju.mtts.vo.movie.Genre;
import com.mju.mtts.vo.movie.Movie;
import com.mju.mtts.vo.movie.Picture;
import com.mju.mtts.vo.movie.Review;
import com.mju.mtts.vo.movie.Staff;
import com.mju.mtts.vo.movie.Video;

@Service("MovieService")
public class MovieServiceImpl implements MovieService {

	@Autowired
	private MovieDao movieDao;
	
	@Override
	public List<Movie> getMovieAll(String movieSeq, String sortCode) {
		Movie param = new Movie();
		List<Movie> temp =  new ArrayList<Movie>();
		
		param.setMovieSeq(movieSeq);
		param.setSortCode(sortCode);
		temp = movieDao.selectAll(param);
		
		for(int i=0; i<temp.size(); i++){
			
			temp.get(i).setGenre(getGenre(movieDao.selectAll(param).get(i).getMovieSeq())); 
			temp.get(i).setRate(getRate(movieDao.selectAll(param).get(i).getMovieSeq()));
			temp.get(i).setCountry(getCountry(movieDao.selectAll(param).get(i).getMovieSeq()));
			temp.get(i).setActor(getMovieActor(movieDao.selectAll(param).get(i).getMovieSeq()));
			temp.get(i).setDirector(getMovieDirector(movieDao.selectAll(param).get(i).getMovieSeq()));
			temp.get(i).setPicture(getMoviePicture(movieDao.selectAll(param).get(i).getMovieSeq()));
			temp.get(i).setPoster(getMoviePoster(movieDao.selectAll(param).get(i).getMovieSeq()));
			
		}
		
		return temp;
	}

	@Override
	public Movie getMovie(String movieSeq) {
		Movie movie = new Movie();
		movie.setMovieSeq(movieSeq);
		
		return movieDao.selectAll(movie).get(0);
	}

	@Override
	public Double getGrade(String movieSeq) {
		return movieDao.getGrade(movieSeq);
	}

	@Override
	public List<Genre> getGenre(String movieSeq) {
		Movie param = new Movie();
		param.setMovieSeq(movieSeq);
	
		return movieDao.getGenre(param);
	}

	@Override
	public List<String> getCountry(String movieSeq) {
		return movieDao.getCountry(movieSeq);
	}
	
	public String getRate(String movieSeq){
		return movieDao.getRate(movieSeq);
	}

	@Override
	public List<Movie> getGenreMovie(String genreSeq, String sortCode) {
		Movie param = new Movie();
		param.setGenreSeq(genreSeq);
		param.setSortCode(sortCode);
		
		List<Movie> temp =  new ArrayList<Movie>();
		
		temp = movieDao.getGenreMovie(param);
		
		for(int i=0; i<temp.size(); i++){
			
			temp.get(i).setGenre(getGenre(movieDao.getGenreMovie(param).get(i).getMovieSeq())); 
			temp.get(i).setRate(getRate(movieDao.getGenreMovie(param).get(i).getMovieSeq()));
			temp.get(i).setCountry(getCountry(movieDao.getGenreMovie(param).get(i).getMovieSeq()));
			temp.get(i).setActor(getMovieActor(movieDao.getGenreMovie(param).get(i).getMovieSeq()));
			temp.get(i).setDirector(getMovieDirector(movieDao.getGenreMovie(param).get(i).getMovieSeq()));
			temp.get(i).setPicture(getMoviePicture(movieDao.getGenreMovie(param).get(i).getMovieSeq()));
			temp.get(i).setPoster(getMoviePoster(movieDao.getGenreMovie(param).get(i).getMovieSeq()));
		}	
		
		return temp;
	}

	@Override
	public List<Staff> getMovieActor(String movieSeq) {
		Movie param = new Movie();
		param.setMovieSeq(movieSeq);
		
		return movieDao.getMovieActor(param);
	}

	@Override
	public List<Staff> getMovieDirector(String movieSeq) {
		Movie param = new Movie();
		param.setMovieSeq(movieSeq);
		
		return movieDao.getMovieDirector(param);
	}

	@Override
	public List<Picture> getMoviePicture(String movieSeq) {
		Movie param = new Movie();
		param.setMovieSeq(movieSeq);
		return movieDao.getMoviePicture(param);
	}

	@Override
	public List<Picture> getMoviePoster(String movieSeq) {
		Movie param = new Movie();
		param.setMovieSeq(movieSeq);
		return movieDao.getMoviePoster(param);
	}
	
	@Override
	public List<Review> getMovieReview(String movieSeq){
		Movie param = new Movie();
		param.setMovieSeq(movieSeq);
		return movieDao.getMovieReview(param);
	}

	@Override
	public List<Video> getMovieVideo(String movieSeq) {
		Movie param = new Movie();
		param.setMovieSeq(movieSeq);
		return movieDao.getMovieVideo(param);
	}
	@Override
	public List<FameLine> getMovieFameLine(String movieSeq) {
		Movie param = new Movie();
		param.setMovieSeq(movieSeq);
		
		return movieDao.getMovieFameLine(param);
	}
}
