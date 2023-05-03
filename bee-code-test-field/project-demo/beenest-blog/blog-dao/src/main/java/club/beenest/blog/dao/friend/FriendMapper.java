package club.beenest.blog.dao.friend;

import club.beenest.blog.entity.friend.Friend;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 友链持久层接口
 *
 * @author 陈玉轩
 * @since　1.0
 */
@Mapper
@Repository
public interface FriendMapper {
	List<Friend> getFriendList();

	List<Friend> getFriendVOList();

	int updateFriendPublishedById(Long id, Boolean published);

	int saveFriend(Friend friend);

	int updateFriend(Friend friend);

	int deleteFriend(Long id);

	int updateViewsByNickname(String nickname);
}
