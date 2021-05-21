package kr.co.mlec.member.vo;
// alt+shift+s -> c, o, r, s 
public class MemberVO {


	private String id;
	private String name;
	private String password;
	private String type;
	private String email_domain;
	private String email_id;
	private String email;
	private String post;
	private String regDate;
	

	public MemberVO() {
		super();
	}
	
	public MemberVO(String id, String name, String password, String type, String email, String post, String regDate) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.type = type;
		this.email = email;
		this.post = post;
		this.regDate = regDate;
	}

	public MemberVO(String id, String name, String password, String type) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.type = type;
	}

	
	public String getEmail_domain() {
		return email_domain;
	}
	
	public void setEmail_domain(String email_domain) {
		this.email_domain = email_domain;
	}
	
	public String getEmail_id() {
		return email_id;
	}
	
	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPost() {
		return post;
		
	}
	
	public void setPost(String post) {
		this.post = post;
	}
	
	public String getRegDate() {
		return regDate;
	}
	
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	@Override
	public String toString() {
		return "MemberVO [id=" + id + ", name=" + name + ", password=" + password + ", type=" + type + ", email="
				+ email + ", post=" + post + ", regDate=" + regDate + "]";
	}

	
}
