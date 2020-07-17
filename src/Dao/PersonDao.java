package Dao;

import bean.Person;

public interface PersonDao {
    /**
     * 查数据
     * @param person 插入对象，密码，email，账号
     * @return 返回true成功
     */
    boolean insertz(Person person);

    /**
     * 查询数据库
     * @param person 查账户密码，email，账号
     * @return 返回true成功
     */
    boolean selectz(Person person);

    /**
     * 改密码
     * @param oldpass 老密码
     * @param newpass 新密码
     * @return true成功
     */
    boolean updatez(String oldpass,String newpass);
}
