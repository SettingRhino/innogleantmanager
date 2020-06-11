package com.han.innogle.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.han.innogle.dao.DiaryDao;
import com.han.innogle.model.Diary;

@Service
public class DiaryService {
	@Autowired
	DiaryDao diaryDao;
	public List<Diary> getDiarylist(String name) {
		// TODO Auto-generated method stub
		
		return diaryDao.getDiarylist(name);
	}
	public Diary getDiary(int id) {
		// TODO Auto-generated method stub
		return diaryDao.getDiary(id);
	}
	public void updateDiary(Diary diary, Authentication auth) {
		// TODO Auto-generated method stub
		diary.setUser(auth.getName());
		if(diary.getDate().equals("")) {
			Date date=new Date();
		    SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd-hh-mm");
			diary.setDate(formater.format(date));
		}
		diaryDao.updateDiary(diary);
	}
	public void deleteDiary(Diary diary) {
		diaryDao.deleteDiary(diary);
	}

}
