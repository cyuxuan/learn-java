/*
 * Copyright ©2023-2023 BeeNest Club. Some rights reserved.
 */

package club.beenest.blog.controller.friend;

import club.beenest.blog.entity.friend.Friend;
import club.beenest.blog.entity.friend.FriendInfo;
import club.beenest.blog.service.friend.FriendService;
import club.beenest.blog.support.log.annotation.VisitLogger;
import club.beenest.blog.support.log.enums.VisitBehavior;
import club.beenest.blog.support.request.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 友链
 *
 * @author 陈玉轩
 * @since　1.0
 */
@RestController
public class FriendController {
	@Autowired
	FriendService friendService;

	/**
	 * 获取友链页面
	 *
	 * @return
	 */
	@VisitLogger(VisitBehavior.FRIEND)
	@GetMapping("/friends")
	public Result friends() {
		List<Friend> friendList = friendService.getFriendVOList();
		FriendInfo friendInfo = friendService.getFriendInfo(true, true);
		Map<String, Object> map = new HashMap<>(4);
		map.put("friendList", friendList);
		map.put("friendInfo", friendInfo);
		return Result.ok("获取成功", map);
	}

	/**
	 * 按昵称增加友链浏览次数
	 *
	 * @param nickname 友链昵称
	 * @return
	 */
	@VisitLogger(VisitBehavior.CLICK_FRIEND)
	@PostMapping("/friend")
	public Result addViews(@RequestParam String nickname) {
		friendService.updateViewsByNickname(nickname);
		return Result.ok("请求成功");
	}
}
