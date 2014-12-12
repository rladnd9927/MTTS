package com.mju.mtts.movie.controller;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mju.mtts.movie.service.MovieService;
import com.mju.mtts.movie.service.MovieTimeService;
import com.mju.mtts.movie.service.ReservInfoService;
import com.mju.mtts.movie.service.SeatInfoService;
import com.mju.mtts.movie.service.ShowMovieService;
import com.mju.mtts.movie.service.TheaterService;
import com.mju.mtts.vo.movie.MovieTime;
import com.mju.mtts.vo.movie.ReservInfo;
import com.mju.mtts.vo.movie.SeatInfo;
import com.mju.mtts.vo.movie.ShowMovie;
import com.mju.mtts.vo.movie.Theater;

@Controller
public class ShowMoviesController {
	
	@Autowired
	private ShowMovieService showMovieService;
	
	@Autowired
	private TheaterService theaterServie;
	
	@Autowired
	private MovieTimeService MovieTimeService;
	
	@Autowired
	private SeatInfoService seatInfoService;
	
	@Autowired
	private MovieService movieService;
	
	@Autowired
	private ReservInfoService reservInfoService;
	
	
	@RequestMapping("/reserv/reserv.do")
	public String reservHome(
			HttpServletRequest request,
			HttpServletResponse response,
			ModelMap model,
			@RequestParam(value = "theaterSeq", required = false) String theaterSeq,
			@RequestParam(value = "movieSeq", required = false) String movieSeq,
			@RequestParam(value = "showDate", required = false) String showDate){
		
		
		
		return "reserv/reserv";
	}
	
	@RequestMapping(value="/reserv/movieList", method=RequestMethod.POST)
	public void movieList(HttpServletResponse resp) throws Exception {
		List<ShowMovie> list=showMovieService.getShowMovieAll();
		JSONObject jso=new JSONObject();    // JASON 객체생성
		jso.put("data", list);
		
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out=resp.getWriter();
		out.print(jso.toString());        // out.print 내용을 ajax의 dataType이 jason인 놈에게 데이터 쏴줌
		
		System.out.println("movieList : " + jso);
	}
	
	@RequestMapping(value="/reserv/theaterList", method=RequestMethod.POST)
	public void theaterList(HttpServletResponse resp, String movieSeq) throws Exception {
		List<Theater> list=theaterServie.getTheaterAll(movieSeq);
		
		JSONObject jso=new JSONObject();
		jso.put("data", list);
		
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out=resp.getWriter();
		out.print(jso.toString());
		
		System.out.println("theaterList : " + jso);
	}
	
	@RequestMapping(value="/reserv/dateList", method=RequestMethod.POST)
	public void theaterList(HttpServletResponse resp, String movieSeq, String theaterSeq, String showDate) throws Exception {
		List<MovieTime> list=MovieTimeService.getMovieTimeAll(theaterSeq, movieSeq, showDate);
		JSONObject jso=new JSONObject();
		jso.put("data", list);
		
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out=resp.getWriter();
		out.print(jso.toString());
		
		System.out.println("dateList : " + jso);
	}
	
	@RequestMapping(value="/reserv/seatList", method=RequestMethod.POST)
	public void seatList(HttpServletResponse resp, String showTimeSeq) throws Exception {
		List<SeatInfo> list=seatInfoService.getSeatInfoAll(showTimeSeq);
		JSONObject jso=new JSONObject();
		jso.put("data", list);
		
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out=resp.getWriter();
		out.print(jso.toString());
		
		System.out.println("seatList : " + jso);
	}
	
	
	
	@RequestMapping(value="/reserv/reservEnd", method=RequestMethod.POST)
	public void reservEnd(HttpServletResponse resp, String movieSeq, String theaterSeq, String showDate, String showTimeSeq, String reservSeat, String memberSeq) throws Exception {
		//좌석 예약
		boolean flag = seatInfoService.setReservSeat(showTimeSeq, reservSeat);
		//예매정보 입력
		
		//영화에 예매수 업데이트
		boolean flag3 = movieService.updateReservCnt(movieSeq, "plus");
		
		if(flag == true){
			List<ReservInfo> list=reservInfoService.getReservInfo(memberSeq);
			JSONObject jso=new JSONObject();
			jso.put("data", list);	
			
			resp.setContentType("text/html;charset=utf-8");
			PrintWriter out=resp.getWriter();
			out.print(jso.toString());
			
			System.out.println("seatList : " + jso);
		}
		else{
			resp.setContentType("text/html;charset=utf-8");
			PrintWriter out=resp.getWriter();
			out.print("예매 실패!");
		}
	}
			

}
