package com.xuedao.service;
import java.util.List;
import com.xuedao.bean.MonthTypeVolume;
import com.xuedao.dao.MonthTypeVolumeDao;
public class MonthTypeVolumeService {
	public List<MonthTypeVolume> getMonthType(String month) {
		MonthTypeVolumeDao mtvd = new MonthTypeVolumeDao();
		return mtvd.getMonthType(month);
	}
}
