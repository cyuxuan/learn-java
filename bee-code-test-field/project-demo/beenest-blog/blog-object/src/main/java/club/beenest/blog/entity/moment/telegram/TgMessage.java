package club.beenest.blog.entity.moment.telegram;

import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * Telegram新消息
 *
 * @author 陈玉轩
 * @since　1.0
 */

public class TgMessage {
	@JsonProperty("update_id")
	private String updateId;
	private Message message;


	public class Message {
		@JsonProperty("message_id")
		private String messageId;
		private From from;
		private Chat chat;
		private String date;
		private String text;


		public class From {
			private String id;
			@JsonProperty("is_bot")
			private Boolean isBot;
			@JsonProperty("first_name")
			private String firstName;
			private String username;
			@JsonProperty("language_code")
			private String languageCode;

			public From() {
			}

			public From(String id, Boolean isBot, String firstName, String username, String languageCode) {
				this.id = id;
				this.isBot = isBot;
				this.firstName = firstName;
				this.username = username;
				this.languageCode = languageCode;
			}

			public String getId() {
				return id;
			}

			public void setId(String id) {
				this.id = id;
			}

			public Boolean getBot() {
				return isBot;
			}

			public void setBot(Boolean bot) {
				isBot = bot;
			}

			public String getFirstName() {
				return firstName;
			}

			public void setFirstName(String firstName) {
				this.firstName = firstName;
			}

			public String getUsername() {
				return username;
			}

			public void setUsername(String username) {
				this.username = username;
			}

			public String getLanguageCode() {
				return languageCode;
			}

			public void setLanguageCode(String languageCode) {
				this.languageCode = languageCode;
			}
		}


		public class Chat {
			private String id;
			@JsonProperty("first_name")
			private String firstName;
			private String username;
			private String type;

			public String getId() {
				return id;
			}

			public void setId(String id) {
				this.id = id;
			}

			public String getFirstName() {
				return firstName;
			}

			public void setFirstName(String firstName) {
				this.firstName = firstName;
			}

			public String getUsername() {
				return username;
			}

			public void setUsername(String username) {
				this.username = username;
			}

			public String getType() {
				return type;
			}

			public void setType(String type) {
				this.type = type;
			}

			public Chat() {
			}

			public Chat(String id, String firstName, String username, String type) {
				this.id = id;
				this.firstName = firstName;
				this.username = username;
				this.type = type;
			}
		}


		public String getMessageId() {
			return messageId;
		}

		public void setMessageId(String messageId) {
			this.messageId = messageId;
		}

		public From getFrom() {
			return from;
		}

		public void setFrom(From from) {
			this.from = from;
		}

		public Chat getChat() {
			return chat;
		}

		public void setChat(Chat chat) {
			this.chat = chat;
		}

		public String getDate() {
			return date;
		}

		public void setDate(String date) {
			this.date = date;
		}

		public String getText() {
			return text;
		}

		public void setText(String text) {
			this.text = text;
		}


		public Message() {
		}

		public Message(String messageId, From from, Chat chat, String date, String text) {
			this.messageId = messageId;
			this.from = from;
			this.chat = chat;
			this.date = date;
			this.text = text;
		}
	}

	public TgMessage() {
	}

	public TgMessage(String updateId, Message message) {
		this.updateId = updateId;
		this.message = message;
	}

	public String getUpdateId() {
		return updateId;
	}

	public void setUpdateId(String updateId) {
		this.updateId = updateId;
	}

	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}
}
