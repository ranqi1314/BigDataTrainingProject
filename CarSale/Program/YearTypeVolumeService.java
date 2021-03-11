package com.xuedao.service;
import java.util.List;
import com.xuedao.bean.YearTypeVolume;
import com.xuedao.dao.YearTypeVolumeDao;
public class YearTypeVolumeService {
	public List<YearTypeVolume> getYearTypeVolume(String year) {
		YearTypeVolumeDao ytvd = new YearTypeVolumeDao();
		return ytvd.getYearType(year);
	}
}
