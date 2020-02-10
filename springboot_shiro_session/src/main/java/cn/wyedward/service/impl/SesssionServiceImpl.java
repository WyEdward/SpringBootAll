package cn.wyedward.service.impl;

import cn.wyedward.domain.User;
import cn.wyedward.domain.UserOnline;
import cn.wyedward.service.SessionService;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.subject.support.DefaultSubjectContext;
import org.crazycake.shiro.RedisSessionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
@Service("sessionService")
public class SesssionServiceImpl implements SessionService {
    // Shiroconfig中配置的sessionDao
    @Autowired
    private RedisSessionDAO sessionDao;

    /**
     * 所有在线人员登录在线信息集合
     * @return
     */
    @Override
    public List<UserOnline> list() {
        List<UserOnline> list = new ArrayList<>();
        Collection<Session> sessions = sessionDao.getActiveSessions();
        for (Session session : sessions) {
            UserOnline userOnline = new UserOnline();
            User user = new User();
            SimplePrincipalCollection principalCollection = new SimplePrincipalCollection();
            if(session.getAttribute(DefaultSubjectContext.PRINCIPALS_SESSION_KEY) == null){
                continue;
            } else{
                principalCollection =  (SimplePrincipalCollection) session.getAttribute(DefaultSubjectContext.PRINCIPALS_SESSION_KEY);
                user =(User)principalCollection.getPrimaryPrincipal();
                userOnline.setUsername(user.getUsername());
                userOnline.setUserId(String.valueOf(user.getId()));
            }
            userOnline.setId((String) session.getId());
            userOnline.setHost(session.getHost());
            userOnline.setStartTimestamp(session.getStartTimestamp());
            userOnline.setLastAccessTime(session.getLastAccessTime());
            long timeout = session.getTimeout();
            if(timeout == 0){
                userOnline.setStatus("离线");
            }else{
                userOnline.setStatus("在线");
            }
            userOnline.setTimeout(timeout);
            list.add(userOnline);
        }
        return list;
    }

    /**
     * 根据id强制下线
     * @param sessionId
     * @return
     */
    @Override
    public boolean forceLogout(String sessionId) {
        Session session = sessionDao.readSession(sessionId);
        sessionDao.delete(session);
        return true;
    }
}
