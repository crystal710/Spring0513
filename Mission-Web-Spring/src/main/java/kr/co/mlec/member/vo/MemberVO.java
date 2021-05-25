package kr.co.mlec.member.vo;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

// alt+shift+s -> c, o, r, s 
public class MemberVO {

	@NotBlank(message = "필수항목입니다")
	private String id;
	@NotBlank(message = "필수항목입니다")
	private String name;
	@NotBlank(message = "필수항목입니다")
	@Length(min=3, max=10, message="최소 3글자이상 10글자 이하를 입력하세요")
	private String password;
	private String type;
	@NotBlank(message = "필수항목입니다")
	private String email_domain;
	@NotBlank(message = "필수항목입니다")
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

	
	public MemberVO(String id, String name, String password, String email_domain, String email_id) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.email_domain = email_domain;
		this.email_id = email_id;
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
