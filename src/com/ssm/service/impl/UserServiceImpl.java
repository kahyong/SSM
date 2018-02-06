package com.ssm.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.ssm.dao.redis.RedisDao;
import com.ssm.dao.DaoSupport;
import com.ssm.dao.UserManager;
import com.ssm.dao.redis.impl.RedisDaoImpl;
import com.ssm.model.SysMenu;
import com.ssm.model.User;
import com.ssm.service.UserService;


/** 系统用户
 * @author CK
 * 修改时间：2015.11.2
 */
@Service("userService")
public class UserServiceImpl implements UserService{

	@Autowired
	private UserManager usersMapper;
//	@Autowired
//	private DaoSupport daoSupport;
	
	
	public void test() {
		try {
			
			System.out.println(usersMapper.getUser("admin").getUsername());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("asdasd");
	}
	
	/**
	 * 获取该用户权限的菜单
	 * @param userId
	 * @return
	 */
	public List<SysMenu> getMenu(int userId) {
		return usersMapper.getMenuByUserId(userId);  
	}
	
	 //将查询到的数据缓存到myCache中,并使用方法名称加上参数中的userNo作为缓存的key  
    //通常更新操作只需刷新缓存中的某个值,所以为了准确的清除特定的缓存,故定义了这个唯一的key,从而不会影响其它缓存值  
    @Cacheable(value="myCache", key="#id")  
    public String getUsernameById(int id){  
//        System.out.println("数据库中查到此用户号[" + id + "]对应的用户名为[" + usersMapper.getUsernameById(id) + "]");  
        return usersMapper.getUsernameById(id);  
    }
	
//	/**登录判断
//	 * @param pd
//	 * @return
//	 * @throws Exception
//	 */
//	public PageData getUserByNameAndPwd(PageData pd)throws Exception{
//		return (PageData)dao.findForObject("UserMapper.getUserInfo", pd);
//	}
//	
//	/**更新登录时间
//	 * @param pd
//	 * @throws Exception
//	 */
//	public void updateLastLogin(PageData pd)throws Exception{
//		dao.update("UserMapper.updateLastLogin", pd);
//	}
//	
//	/**通过用户ID获取用户信息和角色信息
//	 * @param USER_ID
//	 * @return
//	 * @throws Exception
//	 */
//	public User getUserAndRoleById(String USER_ID) throws Exception {
//		return (User) dao.findForObject("UserMapper.getUserAndRoleById", USER_ID);
//	}
//	
//	/**通过USERNAEME获取数据
//	 * @param pd
//	 * @return
//	 * @throws Exception
//	 */
//	public PageData findByUsername(PageData pd)throws Exception{
//		return (PageData)dao.findForObject("UserMapper.findByUsername", pd);
//	}
//	
//	/**列出某角色下的所有用户
//	 * @param pd
//	 * @return
//	 * @throws Exception
//	 */
//	@SuppressWarnings("unchecked")
//	public List<PageData> listAllUserByRoldId(PageData pd) throws Exception {
//		return (List<PageData>) dao.findForList("UserMapper.listAllUserByRoldId", pd);
//		
//	}
//	
//	/**保存用户IP
//	 * @param pd
//	 * @throws Exception
//	 */
//	public void saveIP(PageData pd)throws Exception{
//		dao.update("UserMapper.saveIP", pd);
//	}
//	
//	/**用户列表
//	 * @param page
//	 * @return
//	 * @throws Exception
//	 */
//	@SuppressWarnings("unchecked")
//	public List<PageData> listUsers(Page page)throws Exception{
//		return (List<PageData>) dao.findForList("UserMapper.userlistPage", page);
//	}
//	
//	/**用户列表(弹窗选择用)
//	 * @param page
//	 * @return
//	 * @throws Exception
//	 */
//	@SuppressWarnings("unchecked")
//	public List<PageData> listUsersBystaff(Page page)throws Exception{
//		return (List<PageData>) dao.findForList("UserMapper.userBystafflistPage", page);
//	}
//	
//	/**通过邮箱获取数据
//	 * @param pd
//	 * @return
//	 * @throws Exception
//	 */
//	public PageData findByUE(PageData pd)throws Exception{
//		return (PageData)dao.findForObject("UserMapper.findByUE", pd);
//	}
//	
//	/**通过编号获取数据
//	 * @param pd
//	 * @return
//	 * @throws Exception
//	 */
//	public PageData findByUN(PageData pd)throws Exception{
//		return (PageData)dao.findForObject("UserMapper.findByUN", pd);
//	}
//	
//	/**通过id获取数据
//	 * @param pd
//	 * @return
//	 * @throws Exception
//	 */
//	public PageData findById(PageData pd)throws Exception{
//		return (PageData)dao.findForObject("UserMapper.findById", pd);
//	}
//	
//	/**保存用户
//	 * @param pd
//	 * @throws Exception
//	 */
//	public void saveU(PageData pd)throws Exception{
//		dao.save("UserMapper.saveU", pd);
//	}
//	 
//	/**修改用户
//	 * @param pd
//	 * @throws Exception
//	 */
//	public void editU(PageData pd)throws Exception{
//		dao.update("UserMapper.editU", pd);
//	}
//	
//	/**删除用户
//	 * @param pd
//	 * @throws Exception
//	 */
//	public void deleteU(PageData pd)throws Exception{
//		dao.delete("UserMapper.deleteU", pd);
//	}
//	
//	/**批量删除用户
//	 * @param USER_IDS
//	 * @throws Exception
//	 */
//	public void deleteAllU(String[] USER_IDS)throws Exception{
//		dao.delete("UserMapper.deleteAllU", USER_IDS);
//	}
//	
//	/**用户列表(全部)
//	 * @param USER_IDS
//	 * @throws Exception
//	 */
//	@SuppressWarnings("unchecked")
//	public List<PageData> listAllUser(PageData pd)throws Exception{
//		return (List<PageData>) dao.findForList("UserMapper.listAllUser", pd);
//	}
//	
//	/**获取总数
//	 * @param pd
//	 * @throws Exception
//	 */
//	public PageData getUserCount(String value)throws Exception{
//		return (PageData)dao.findForObject("UserMapper.getUserCount", value);
//	}
	
}
