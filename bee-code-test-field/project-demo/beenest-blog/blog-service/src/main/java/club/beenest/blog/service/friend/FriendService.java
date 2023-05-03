package club.beenest.blog.service.friend;


import club.beenest.blog.entity.friend.Friend;
import club.beenest.blog.entity.friend.FriendInfo;

import java.util.List;

public interface FriendService {
	List<Friend> getFriendList();

	List<Friend> getFriendVOList();

	void updateFriendPublishedById(Long friendId, Boolean published);

	void saveFriend(Friend friend);

	void updateFriend(Friend friend);

	void deleteFriend(Long id);

	void updateViewsByNickname(String nickname);

	FriendInfo getFriendInfo(boolean cache, boolean md);

	void updateFriendInfoContent(String content);

	void updateFriendInfoCommentEnabled(Boolean commentEnabled);
}
