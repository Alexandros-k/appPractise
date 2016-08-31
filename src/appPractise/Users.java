package appPractise;

public class Users {
private int id;
private String type;
private String name;
private String userName;
private String passWord;
public Users(String type, String name, String userName, String passWord) {
	
	this.type = type;
	this.name = name;
	this.userName = userName;
	this.passWord = passWord;
}
public Users(int id, String type, String name, String userName, String passWord) {
	
	this.id = id;
	this.type = type;
	this.name = name;
	this.userName = userName;
	this.passWord = passWord;
}
@Override
public String toString() {
	return "Users [id=" + id + ", type=" + type + ", name=" + name + ", userName=" + userName + ", passWord=" + passWord
			+ "]";
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}
public String getPassWord() {
	return passWord;
}
public void setPassWord(String passWord) {
	this.passWord = passWord;
}

}
