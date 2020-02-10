package cn.wyedward.service;

import cn.wyedward.domain.UserOnline;

import java.util.List;

public interface SessionService {
    /**
     * 查看所有在线用户
     * @return
     */
    List<UserOnline> list();

    /**
     * 根据sessionId 提出用户抽象方法
     * @param sessionId
     * @return
     */
    boolean forceLogout(String sessionId);
}
