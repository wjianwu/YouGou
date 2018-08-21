package darian.serviceImpl;

import darian.dao.SmallBlockDao;
import darian.entity.SmallBlock;
import darian.service.SmallBlockService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class SmallBlockServiceImpl implements SmallBlockService {

	@Resource
	private SmallBlockDao smallBlockDao;

	@Override
	public SmallBlock classify(int classId) {
		return smallBlockDao.selectByPrimaryKey(classId);
	}
}
