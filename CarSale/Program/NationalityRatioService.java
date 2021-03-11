package com.xuedao.service;
import java.util.List;
import com.xuedao.bean.NationalityRatio;
import com.xuedao.dao.NationalityRatioDao;
public class NationalityRatioService {
	public List<NationalityRatio> getNationalityRatioService(String month) {
		NationalityRatioDao nrd = new NationalityRatioDao();
		return nrd.getNationalityRatio(month);
	}
}
