package kr.or.ddit.vo;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

public class MemberVO {
	
	private String userId = "user";
	private String password = "pwd";
	private int coin = 100;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date birth;
	
	private String gender;
	
	private String nationality;
	
	private String[] cars;
	private String car;
	
	private String[] hobbyList;
	private String hobby;
	
	private boolean merriaged;

	//중첩된 자바빈
	private AddressVO addressVO;
	
	private List<CardVO> cardVOList;
	
	public MemberVO() {}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getCoin() {
		return coin;
	}

	public void setCoin(int coin) {
		this.coin = coin;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public String getGender() {
		return gender;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getNationality() {
		return nationality;
	}
	
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String[] getCars() {
		return cars;
	}
	
	public void setCars(String[] cars) {
		this.cars = cars;
	}

	public String[] getHobbyList() {
		return hobbyList;
	}

	public void setHobbyList(String[] hobbyList) {
		this.hobbyList = hobbyList;
	}

	public boolean isMerriaged() {
		return merriaged;
	}

	public void setMerriaged(boolean merriaged) {
		this.merriaged = merriaged;
	}

	public AddressVO getAddressVO() {
		return addressVO;
	}

	public void setAddressVO(AddressVO addressVO) {
		this.addressVO = addressVO;
	}

	public List<CardVO> getCardVOList() {
		return cardVOList;
	}

	public void setCardVOList(List<CardVO> cardVOList) {
		this.cardVOList = cardVOList;
	}

	public String getCar() {
		return car;
	}

	public void setCar(String car) {
		this.car = car;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	@Override
	public String toString() {
		return "MemberVO [userId=" + userId + ", password=" + password + ", coin=" + coin + ", birth=" + birth
				+ ", gender=" + gender + ", nationality=" + nationality + ", cars=" + Arrays.toString(cars) + ", car="
				+ car + ", hobbyList=" + Arrays.toString(hobbyList) + ", hobby=" + hobby + ", merriaged=" + merriaged
				+ ", addressVO=" + addressVO + ", cardVOList=" + cardVOList + "]";
	}


}
