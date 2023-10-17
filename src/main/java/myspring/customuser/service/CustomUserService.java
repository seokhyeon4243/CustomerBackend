package myspring.customuser.service;

import java.util.List;

import myspring.customuser.vo.CustomUserVO;

public interface CustomUserService {
	public CustomUserVO getCustomUser(int id);
	
	public List<CustomUserVO> getCustomUserList();
}
