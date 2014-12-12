package com.mju.mtts.movie.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mju.mtts.dao.movie.SeatInfoDao;
import com.mju.mtts.dao.movie.TheaterDao;
import com.mju.mtts.movie.service.SeatInfoService;
import com.mju.mtts.vo.movie.SeatInfo;

@Service("SeatInfoService")
public class SeatInfoServiceImpl implements SeatInfoService {

	@Autowired
	private SeatInfoDao seatInfoDao;
	
	@Override
	public List<SeatInfo> getSeatInfoAll(String showTimeSeq) {
		// TODO Auto-generated method stub
		return seatInfoDao.selectAll(showTimeSeq);
	}

	@Override
	public boolean setReservSeat(String showTimeSeq, String seatNumber) {
		// TODO Auto-generated method stub
		int flag = -1;
		
		flag = seatInfoDao.reservSeat(showTimeSeq, seatNumber);
		
		return flag > 0 ? true : false;
	}
	
}
