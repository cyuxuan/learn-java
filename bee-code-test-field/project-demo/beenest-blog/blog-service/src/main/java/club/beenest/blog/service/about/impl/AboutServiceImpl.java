package club.beenest.blog.service.about.impl;

import club.beenest.blog.dao.about.AboutMapper;
import club.beenest.blog.entity.about.About;
import club.beenest.blog.service.about.AboutService;
import club.beenest.blog.support.auth.RequestContextManager;
import club.beenest.blog.vo.about.AdminAboutVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * 关于我页面业务层实现
 *
 * @author 陈玉轩
 * @since 1.0
 */
@Service
public class AboutServiceImpl implements AboutService {
    @Autowired
    AboutMapper aboutMapper;

    @Override
    public About getAboutInfo() {
        return aboutMapper.selectAboutByUserId(1L);
    }

    @Override
    public About getAboutSetting() {
        // 从上下文中取出账户信息
        long userId = RequestContextManager.getRequestContext().getSecurityUser().getUserId();
        return aboutMapper.selectAboutByUserId(userId);
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    @Override
    public void updateAbout(AdminAboutVO adminAbout) {
        aboutMapper.updateAbout(adminAbout);
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)

    @Override
    public boolean getAboutCommentEnabled() {
        String commentEnabledString = String.valueOf(aboutMapper.getAboutCommentEnabled(1L));
        return Boolean.parseBoolean(commentEnabledString);
    }
}
